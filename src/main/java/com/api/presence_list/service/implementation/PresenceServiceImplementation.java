package com.api.presence_list.service.implementation;

import com.api.presence_list.model.Presence;
import com.api.presence_list.repository.GenericRepository;
import com.api.presence_list.repository.PresenceRepository;
import com.api.presence_list.service.PresenceService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("PresenceService")
public class PresenceServiceImplementation extends GenericServiceImplementation<Presence, ObjectId> implements PresenceService {
	private PresenceRepository repository;

	@Autowired
	public PresenceServiceImplementation(GenericRepository<Presence, ObjectId> genericRepository) {
		super(genericRepository);

	}

}