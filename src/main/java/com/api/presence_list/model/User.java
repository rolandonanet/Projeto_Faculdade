package com.api.presence_list.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

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
	private List<Subjects> subjects;
	private String password;
    
}
