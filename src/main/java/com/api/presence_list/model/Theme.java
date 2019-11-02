package com.api.presence_list.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Theme {

	@Id
	private ObjectId _id;
	private String name;
	private String theme;
	private ObjectId teacher_id;
	private String[] schedule_List;

	public String get_id() {
		return _id.toHexString();
	}

}
