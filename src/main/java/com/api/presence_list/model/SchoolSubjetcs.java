package com.api.presence_list.model;

import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolSubjetcs {

	@Id
	//private ObjectId _id;
	private String name;
	private String teacher;
	private String [] students;
	
	
}
