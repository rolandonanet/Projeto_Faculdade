package com.api.presence_list.controller;

import com.api.presence_list.model.SchoolSubject;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(tags = "SchoolSubjetcs")
@RestController
@RequestMapping("/schoolSubject")
public class SchoolSubjectController extends GenericController<SchoolSubject, ObjectId> {

}