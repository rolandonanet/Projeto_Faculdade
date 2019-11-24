package com.api.presence_list.service.implementation;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.presence_list.model.StudentClass;
import com.api.presence_list.repository.StudentClassRepository;
import com.api.presence_list.service.StudentClassService;

@Service("studentClassService")
public class StudentClassServiceImplementation extends GenericServiceImplementation<StudentClass, ObjectId>
		implements StudentClassService {

	@Autowired
	private StudentClassRepository studentClassRepository;

}