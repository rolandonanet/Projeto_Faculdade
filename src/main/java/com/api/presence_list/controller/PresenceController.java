package com.api.presence_list.controller;

import com.api.presence_list.model.Presence;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(tags = "Presence")
@RestController
@RequestMapping("/presence")
public class PresenceController extends GenericController<Presence, ObjectId> {

}
