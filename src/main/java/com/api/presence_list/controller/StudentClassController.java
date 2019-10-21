package com.api.presence_list.controller;

import org.bson.types.ObjectId;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.presence_list.model.StudentClass;
import com.api.presence_list.service.StudentClassService;
import io.swagger.annotations.Api;

@Api(tags = "StudentClass")
@RestController
@RequestMapping("/studentClass")
@Lazy
public class StudentClassController extends GenericController<StudentClass, ObjectId> {

	StudentClassController(StudentClassService service) {
		super(service);
	}
}