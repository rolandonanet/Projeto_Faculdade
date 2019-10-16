package com.api.presence_list.model;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Presence {

	@Id
	private ObjectId _id;
	private String theme;
	private Date day;
}







