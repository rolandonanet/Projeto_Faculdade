package com.api.presence_list.service.implementation;

import com.api.presence_list.model.SchoolSubject;
import com.api.presence_list.service.SchoolSubjectService;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service("schoolSubjectService")
public class SchoolSubjectServiceImplementation extends GenericServiceImplementation<SchoolSubject, ObjectId>
		implements SchoolSubjectService {

}