package com.api.presence_list.model.DTO;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.bson.types.ObjectId;

import com.api.presence_list.model.Presence;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PresenceUpdateDTO {
	
	private ObjectId userId;
	@NotEmpty
	private Presence presence;
	
}
