package com.api.presence_list.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

import org.bson.types.ObjectId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolSubject {
	
	private ObjectId _id = new ObjectId();
	private String name;
	private Theme theme;
	
	
	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(String id) {
		this._id = (id == null) ? null : new ObjectId(id);
	}

}
