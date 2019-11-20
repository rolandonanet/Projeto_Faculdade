package com.api.presence_list.service;

import com.api.presence_list.model.User;
import com.api.presence_list.model.DTO.InsertThemeUserDTO;
import com.api.presence_list.model.DTO.LoginDTO;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface UserService extends GenericService<User, ObjectId> {

	Page<User> listType(String type, Integer pageNumber, Integer pageSize, Sort.Direction direction, String orderBy);

	Optional<User> login(loginDTO entity);
	
	void updateThemeUser(InsertThemeUserDTO entity);

}