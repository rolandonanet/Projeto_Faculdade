package com.api.presence_list.controller;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.presence_list.model.Theme;
import com.api.presence_list.service.ThemeService;

import io.swagger.annotations.Api;

@Api(tags = "Theme")
@RestController
@RequestMapping("/Theme")

public class ThemeController extends GenericController<Theme, ObjectId> {

	ThemeController(ThemeService service) {
		super(service);
	}

}