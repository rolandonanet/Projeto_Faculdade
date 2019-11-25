package com.api.presence_list.service.implementation;

import com.api.presence_list.model.Presence;
import com.api.presence_list.model.QRCode;
import com.api.presence_list.model.Schedule;
import com.api.presence_list.model.User;
import com.api.presence_list.model.DTO.LoginDTO;
import com.api.presence_list.model.DTO.PresenceInsertDTO;
import com.api.presence_list.model.DTO.PresenceUpdateDTO;

import com.api.presence_list.model.DTO.QRCodeCheckDTO;
import com.api.presence_list.model.DTO.QRCodeDTO;
import com.api.presence_list.model.DTO.QRCodeResponseDTO;
import com.api.presence_list.repository.GenericRepository;
import com.api.presence_list.repository.UserRepository;
import com.api.presence_list.service.UserService;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAccessor; 

@Service("userService")
public class UserServiceImplementation extends GenericServiceImplementation<User, ObjectId> implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Page<User> listType(String type, Integer pageNumber, Integer pageSize, Direction direction, String orderBy) {
		Pageable pagination = PageRequest.of(pageNumber, pageSize, direction, orderBy);
		return userRepository.findAllByUserType(type, pagination);
	}

	@Override
	public Optional<User> login(LoginDTO entity) {
		return userRepository.findByEmailAndPassword(entity.getEmail(), entity.getPassword());
	}

	@Override
	public User insertPresence(PresenceInsertDTO entity) {
		Optional<User> userRaw = userRepository.findById(entity.getUserId());
		User user = userRaw.get();
		user.getPresences().addAll(entity.getPresence());
		return userRepository.save(user);
	}
	

	public String updatePresence(PresenceUpdateDTO entity) {
		Optional<User> userRaw = userRepository.findById(entity.getUserId());
		User user = userRaw.get();
		for (Presence presence: user.getPresences()) {
			if (presence.getDay().equals(entity.getPresence().getDay()) && presence.getThemeId().equals(entity.getPresence().getThemeId())) {
			    presence.setPresent(entity.getPresence().getPresent());
			    userRepository.save(user);
				return "User successfully updated";
			}
		}
		return "User not updated successfully because presence is already recorded for this day";
	}

	@Override
	public QRCodeResponseDTO generateQRCode(QRCodeDTO entity) {
		QRCodeResponseDTO response = new QRCodeResponseDTO();
		Optional<User> userRaw = userRepository.findById(new ObjectId(entity.getTeacherId()));
		User teacher = userRaw.get();
		if(teacher == null) {
			response.setError("Usuário não encontrado");
			return response;
		}
		if(!teacher.getUserType().equals("teacher")) {
			response.setError("Usuário não é professor");
			return response;
		}

		List<Schedule> schedules = teacher.getSchedules();
		
		Date now = new Date();
		
		SimpleDateFormat  simpleDayOfWeekDateformat = new SimpleDateFormat("EEEE", Locale.ENGLISH);
		
		String currentDayOfWeek = simpleDayOfWeekDateformat.format(now);

		Schedule currentSchedule = null;
		
		for(Schedule schedule : schedules){
			String scheduleDayOfWeek = schedule.getSchedule().substring(0, schedule.getSchedule().indexOf("_"));
			if(scheduleDayOfWeek.toLowerCase().equals(currentDayOfWeek.toLowerCase())) {
				if(currentSchedule == null) {
					currentSchedule = new Schedule();
					currentSchedule = schedule;
					continue;
				}
				
				String scheduleTime =  schedule.getSchedule().substring(schedule.getSchedule().indexOf("_") + 1);
				Integer scheduleHour = Integer.parseInt(scheduleTime.substring(0, scheduleTime.indexOf(":")));
				String currentScheduleTime = currentSchedule.getSchedule().substring(currentSchedule.getSchedule().indexOf("_") + 1);
				Integer currentScheduleHour = Integer.parseInt(currentScheduleTime.substring(0, currentScheduleTime.indexOf(":")));
				Integer currentHour =  (int)(now.getTime() % 86400000) / 3600000;
				Integer hourDif = scheduleHour - currentHour;
				Integer curHourDif = currentScheduleHour - currentHour;

				
				if(Math.abs(hourDif) < Math.abs(curHourDif)) {
					currentSchedule = new Schedule();
					currentSchedule = schedule;
					continue;
				}	
			}
		}
		
		if(currentSchedule == null) {
			response.setError("Não foi encontrado um horário válido");
			return response;
		}		
		QRCode qrCode = new QRCode();
		String key = Base64.getEncoder().encodeToString(new Date().toString().getBytes());
		qrCode.setKey(key);
		qrCode.setThemeId(new ObjectId(currentSchedule.getThemeId()));
		String currentScheduleTime = currentSchedule.getSchedule().substring(currentSchedule.getSchedule().indexOf("_") + 1);
		qrCode.setTime(currentScheduleTime);
		teacher.setQrCode(qrCode);
		
		response.setMessage(teacher.get_id() + "|" + key);
		
		userRepository.save(teacher);

		return response;
	}

	@Override
	public QRCodeResponseDTO checkQRCode(QRCodeCheckDTO entity) throws ParseException {
		
		QRCodeResponseDTO response = new QRCodeResponseDTO();
		
		String qrCode = entity.getEncodedQRCode();
		String teacherId = qrCode.substring(0, qrCode.indexOf("|"));
		String key = qrCode.substring(qrCode.indexOf("|") + 1);
		
		Optional<User> teacherRaw = userRepository.findById(new ObjectId(teacherId));
		User teacher = teacherRaw.get();
		
		if(teacher == null) {
			response.setError("Professor não encontrado");
			return response;
		}
		
		if(!teacher.getQrCode().getKey().equals(key)) {
			response.setError("Chave inválida");
			return response;
		}
		
		Presence studentPresence = new Presence();
		
		studentPresence.setDay(new Date());
		studentPresence.setPresent(true);
		studentPresence.setThemeId(teacher.getQrCode().getThemeId());
		
		SimpleDateFormat toDay = new SimpleDateFormat("yyyy-MM-dd");
		
		String now = toDay.format(new Date());
		
		Date presenceTime = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(now + " " + teacher.getQrCode().getTime());
		
		studentPresence.setDay(presenceTime);
		
		Optional<User> studentRaw = userRepository.findById(new ObjectId(entity.getStudentId()));
		User student = studentRaw.get();
		
		if(student == null) {
			response.setError("Aluno não encontrado");
			return response;
		}
		
		for(Presence curStudentPresence : student.getPresences()) {
			if(curStudentPresence.getPresent().equals(studentPresence.getPresent())
					&& curStudentPresence.getDay().equals(studentPresence.getDay())
					&& curStudentPresence.getThemeId().equals(studentPresence.getThemeId()))  {
				if(curStudentPresence.getPresent()){
					response.setError("Já possui esta presença");
					return response;
				}
				curStudentPresence.setPresent(true);
			}
		}
		
		student.getPresences().add(studentPresence);
		
		userRepository.save(student);
		
		response.setMessage("Presença registrada com sucesso");
		
		return response;
	}
	
}
