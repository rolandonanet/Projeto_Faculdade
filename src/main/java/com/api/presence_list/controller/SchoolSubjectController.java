package com.api.presence_list.controller;

import com.api.presence_list.model.SchoolSubject;
import com.api.presence_list.service.SchoolSubjectService;
import io.swagger.annotations.Api;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "SchoolSubjetcs")
@RestController
@RequestMapping("/schoolSubjetcs")
@Lazy
public class SchoolSubjectController extends GenericController<SchoolSubject, ObjectId> {

	SchoolSubjectController(SchoolSubjectService service) {
		super(service);
	}

}