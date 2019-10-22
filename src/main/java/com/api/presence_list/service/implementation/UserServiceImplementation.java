package com.api.presence_list.service.implementation;

import com.api.presence_list.model.User;
import com.api.presence_list.service.UserService;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImplementation extends GenericServiceImplementation<User, ObjectId> implements UserService {

}