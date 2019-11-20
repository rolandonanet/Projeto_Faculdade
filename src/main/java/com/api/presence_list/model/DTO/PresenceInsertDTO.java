package com.api.presence_list.model.DTO;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.bson.types.ObjectId;

import com.api.presence_list.model.Presence;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PresenceInsertDTO {
	
	private ObjectId userId;
	@NotEmpty
	private List<Presence> presence;
	
}
