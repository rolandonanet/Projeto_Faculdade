package com.api.presence_list.service;

import com.api.presence_list.model.StudentClass;
import com.api.presence_list.model.DTO.InsertThemeUserDTO;

import org.bson.types.ObjectId;

public interface StudentClassService extends GenericService<StudentClass, ObjectId> {

	void updateThemeUser(InsertThemeUserDTO entity);

}