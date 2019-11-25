package com.api.presence_list.model;

import org.bson.types.ObjectId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QRCode {
	private ObjectId themeId;
	private String key;
	private String time;
}
