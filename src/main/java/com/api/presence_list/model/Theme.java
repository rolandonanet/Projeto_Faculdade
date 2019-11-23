package com.api.presence_list.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Theme {
	
	private ObjectId _id = new ObjectId();
	private String name;
	private ObjectId teacherId;
	private String[] schedules;
	private List<ObjectId> userIds;

	public String getTeacherId() {
		return teacherId.toHexString();
	}
	
	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(String id) {
		this._id = (id == null) ? null : new ObjectId(id);
	}
	
	public List<String> getUserIds(){
		List<String> response = new ArrayList<>();
		for(ObjectId userId : userIds) {
			response.add(userId.toHexString());
		}
		return response;
	}
}
