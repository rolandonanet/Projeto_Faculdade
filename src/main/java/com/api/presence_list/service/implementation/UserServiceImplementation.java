package com.api.presence_list.service.implementation;

import com.api.presence_list.model.Presence;
import com.api.presence_list.model.User;
import com.api.presence_list.model.DTO.InsertThemeUserDTO;
import com.api.presence_list.model.DTO.LoginDTO;
import com.api.presence_list.model.DTO.PresenceInsertDTO;
import com.api.presence_list.model.DTO.PresenceUpdateDTO;
import com.api.presence_list.repository.GenericRepository;
import com.api.presence_list.repository.UserRepository;
import com.api.presence_list.service.UserService;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

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
	public void updateThemeUser(InsertThemeUserDTO entity) {
		Optional<User> userRaw = userRepository.findById(entity.getUserId());
		User user = userRaw.get();
		user.getThemeIds().add(entity.getThemeId());
		userRepository.save(user);
	}
	
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
	
}
