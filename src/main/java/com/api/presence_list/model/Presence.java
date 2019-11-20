package com.api.presence_list.model;

import java.util.Date;
import java.util.logging.Logger;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Presence {

	private ObjectId themeId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date day;
	private Boolean present;
	
}
