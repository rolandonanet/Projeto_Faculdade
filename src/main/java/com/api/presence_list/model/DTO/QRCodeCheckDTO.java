package com.api.presence_list.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QRCodeCheckDTO {
	private String studentId;
	private String encodedQRCode;
}
