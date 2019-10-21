package com.api.presence_list.service.implementation;

import com.api.presence_list.model.SchoolSubject;
import com.api.presence_list.repository.GenericRepository;
import com.api.presence_list.repository.SchoolSubjectRepository;
import com.api.presence_list.service.SchoolSubjectService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service("schoolSubjectService")
public class SchoolSubjectServiceImplementation extends GenericServiceImplementation<SchoolSubject, ObjectId> implements SchoolSubjectService {
	@Autowired
	private SchoolSubjectRepository repository;


	public SchoolSubjectServiceImplementation(GenericRepository<SchoolSubject, ObjectId> genericRepository) {
		super(genericRepository);

	}

}