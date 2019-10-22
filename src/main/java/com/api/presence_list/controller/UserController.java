package com.api.presence_list.controller;

import com.api.presence_list.model.User;

import org.bson.types.ObjectId;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(tags = "User")
@RestController
@RequestMapping("/user")
@Lazy
public class UserController extends GenericController<User, ObjectId> {

}