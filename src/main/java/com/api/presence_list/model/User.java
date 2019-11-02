package com.api.presence_list.model;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	@Id
	private ObjectId _id;
	private String userType;
	private String name;
	private int registration;
	@DBRef
	private List<Presence> presence;
	private Base64 password;

	public String get_id() {
		return _id.toHexString();
	}

}
