package com.api.presence_list.model;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Theme {
	
	private ObjectId themeId;
	private String name;
	private ObjectId teacherId;
	private String[] schedule_List;
	private List<ObjectId> userId;

	public String getTeacherId() {
		return teacherId.toHexString();
	}

}
