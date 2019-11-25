package com.api.presence_list.model;

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
	private String email;
	private String password;
	private String name;
	private String userType;
	private int registration;
	private QRCode qrCode;
	private List<Presence> presences;
	private List<Schedule> schedules;
	

	public String get_id() {
		return _id.toHexString();
	}

	public String getPassword() {
		return null;
	}

}
