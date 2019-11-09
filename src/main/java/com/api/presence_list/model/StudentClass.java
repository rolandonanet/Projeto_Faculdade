package com.api.presence_list.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentClass {

	@Id
	private ObjectId _id;
	private String name;
	private List<SchoolSubject> schoolSubjects;

	public String get_id() {
		return _id.toHexString();
	}
	
}
