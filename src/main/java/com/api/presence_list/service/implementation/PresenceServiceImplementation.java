package com.api.presence_list.service.implementation;

import com.api.presence_list.model.Presence;
import com.api.presence_list.service.PresenceService;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service("presenceService")
public class PresenceServiceImplementation extends GenericServiceImplementation<Presence, ObjectId>
		implements PresenceService {

}