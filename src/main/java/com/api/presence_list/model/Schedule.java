package com.api.presence_list.model;

import org.bson.types.ObjectId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Schedule {
	
	private ObjectId themeId;
	private String schedule;
	
}
