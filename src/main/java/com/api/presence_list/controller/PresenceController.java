package com.api.presence_list.controller;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.presence_list.model.Presence;
import com.api.presence_list.service.PresenceService;
import io.swagger.annotations.Api;

@Api(tags = "Presence")
@RestController
@RequestMapping("/Presence")

public class PresenceController extends GenericController<Presence, ObjectId> {

	PresenceController(PresenceService service) {
		super(service);
	}


}


