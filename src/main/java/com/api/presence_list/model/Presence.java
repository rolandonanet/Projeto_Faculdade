package com.api.presence_list.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

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
