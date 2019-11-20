package com.api.presence_list.service.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.api.presence_list.model.SchoolSubject;
import com.api.presence_list.model.StudentClass;
import com.api.presence_list.model.Theme;
import com.api.presence_list.repository.StudentClassRepository;
import com.api.presence_list.service.StudentClassService;

@Service("studentClassService")
public class StudentClassServiceImplementation extends GenericServiceImplementation<StudentClass, ObjectId>
		implements StudentClassService {

	@Autowired
	private StudentClassRepository studentClassRepository;

}