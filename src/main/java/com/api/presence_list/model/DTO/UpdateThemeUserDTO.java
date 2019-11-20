package com.api.presence_list.model.DTO;

import org.bson.types.ObjectId;

import com.api.presence_list.model.Schedule;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateThemeUserDTO {

	private ObjectId themeId;
	private ObjectId userId;

}
