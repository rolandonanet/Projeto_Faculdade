package com.api.presence_list.controller;

import com.api.presence_list.model.User;
import com.api.presence_list.service.UserService;
import io.swagger.annotations.Api;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "User")
@RestController
@RequestMapping("/User")
public class UserController extends GenericController<User, ObjectId> {

	UserController(UserService service) {
		super(service);
	}
}

