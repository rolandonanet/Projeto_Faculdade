package com.api.presence_list.service.implementation;

import com.api.presence_list.model.StudentClass;
import com.api.presence_list.repository.GenericRepository;
import com.api.presence_list.repository.StudentClassRepository;
import com.api.presence_list.service.StudentClassService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("StudentClassService")
public class StudentClassServiceImplementation extends GenericServiceImplementation<StudentClass, ObjectId> implements StudentClassService {
	private StudentClassRepository repository;

	@Autowired
	public StudentClassServiceImplementation(GenericRepository<StudentClass, ObjectId> genericRepository) {
		super(genericRepository);

	}

}