package com.api.presence_list.controller;

import com.api.presence_list.model.SchoolSubject;
import com.api.presence_list.service.SchoolSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "SchoolSubjetcs")
@RestController
@RequestMapping("/SchoolSubjetcs")

public class SchoolSubjectController extends GenericController<SchoolSubject, ObjectId> {

	SchoolSubjectController(SchoolSubjectService service) {
		super(service);
	}

}