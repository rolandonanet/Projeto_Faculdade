package com.api.presence_list.service.implementation;

import java.util.List;
import java.util.Optional;

import com.api.presence_list.model.Schedule;
import com.api.presence_list.model.SchoolSubject;
import com.api.presence_list.model.StudentClass;
import com.api.presence_list.model.User;
import com.api.presence_list.model.DTO.UpdateThemeUserDTO;
import com.api.presence_list.repository.GenericRepository;
import com.api.presence_list.repository.StudentClassRepository;
import com.api.presence_list.repository.UserRepository;
import com.api.presence_list.service.GenericService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericServiceImplementation<R, D> implements GenericService<R, D> {

	@Autowired
	private GenericRepository<R, D> genericRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StudentClassRepository studentClassRepository;

	// Custom REST Methods
	@Override
	public R create(R entity) {
		return genericRepository.save(entity);
	}

	@Override
	public Optional<R> read(D id) {
		return genericRepository.findById(id);
	}

	@Override
	public R update(R entity) {
		return genericRepository.save(entity);
	}

	@Override
	public void deleteById(D d) {
		genericRepository.deleteById(d);
	}

	@Override
	public Page<R> list(Integer pageNumber, Integer pageSize, Sort.Direction direction, String orderBy) {
		Pageable pagination = PageRequest.of(pageNumber, pageSize, direction, orderBy);
		return genericRepository.findAll(pagination);
	}

	@Override
	public Page<R> search(R entity, Integer pageNumber, Integer pageSize, Sort.Direction direction, String orderBy) {
		Pageable pagination = PageRequest.of(pageNumber, pageSize, direction, orderBy);
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnorePaths("id");
		Example<R> query = Example.of(entity, matcher);
		return genericRepository.findAll(query, pagination);
	}

	@Override
	public Page<R> find(R entity, Integer pageNumber, Integer pageSize, Sort.Direction direction, String orderBy) {
		Pageable pagination = PageRequest.of(pageNumber, pageSize, direction, orderBy);
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues()
				.withStringMatcher(ExampleMatcher.StringMatcher.EXACT).withIgnorePaths("id");
		Example<R> query = Example.of(entity, matcher);
		return genericRepository.findAll(query, pagination);
	}

	@Override
	public void updateThemeUser(UpdateThemeUserDTO entity) {
		List<StudentClass> studentClassRaw = studentClassRepository.findAll();
		Optional<User> userRaw = userRepository.findById(entity.getUserId());
		User user = userRaw.get();
		Schedule schedule;

		for (StudentClass studentClass : studentClassRaw) {

			List<SchoolSubject> subjects = studentClass.getSchoolSubjects();

			for (SchoolSubject subject : subjects) {
				if (subject.getTheme().get_id().equals(entity.getThemeId().toHexString())) {
					subject.getTheme().getUserIds().add(entity.getUserId());
					studentClass.setSchoolSubjects(subjects);
					subject.getTheme().get_id();

					for (String scheduleList : subject.getTheme().getSchedules()) {
						schedule = new Schedule();
						schedule.setSchedule(scheduleList);
						schedule.setThemeId(new ObjectId(subject.getTheme().get_id()));
						user.getSchedules().add(schedule);
					}
					userRepository.save(user);
					studentClassRepository.save(studentClass);
				}
			}

		}

	}

}