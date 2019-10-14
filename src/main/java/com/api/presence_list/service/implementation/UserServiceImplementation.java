package com.api.presence_list.service.implementation;

import com.api.presence_list.model.User;
import com.api.presence_list.repository.UserRepository;
import com.api.presence_list.repository.GenericRepository;
import com.api.presence_list.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImplementation extends GenericServiceImplementation<User, ObjectId> implements UserService {
	private UserRepository repository;

	@Autowired
	public UserServiceImplementation(GenericRepository<User, ObjectId> genericRepository) {
		super(genericRepository);

	}

}