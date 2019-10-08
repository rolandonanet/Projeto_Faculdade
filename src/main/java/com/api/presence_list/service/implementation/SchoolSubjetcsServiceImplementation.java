package com.api.presence_list.service.implementation;

import com.api.presence_list.model.SchoolSubjetcs;
import com.api.presence_list.repository.SchoolSubjetcsRepository;
import com.api.presence_list.repository.GenericRepository;
import com.api.presence_list.service.SchoolSubjetcsService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class SchoolSubjetcsServiceImplementation extends GenericServiceImplementation<SchoolSubjetcs, ObjectId> implements SchoolSubjetcsService {
	private SchoolSubjetcsRepository repository;

	@Autowired
	public SchoolSubjetcsServiceImplementation(GenericRepository<SchoolSubjetcs, ObjectId> genericRepository) {
		super(genericRepository);

	}

}