package com.api.presence_list.controller;

import com.api.presence_list.model.QRCode;
import com.api.presence_list.model.DTO.QRCodeDTO;
import com.api.presence_list.service.QRCodeService;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "QRCode")
@RestController
@RequestMapping("/QRCode")
public class QRCodeController extends GenericController<QRCode, ObjectId> {

	private QRCodeService QRCodeService;
	
	@ApiOperation(value = "Generate QRCode for teacher")
	@RequestMapping(method = RequestMethod.POST, value = "/generate")
	public QRCode generate(@ApiParam(value = "entity", required = true) @RequestBody QRCodeDTO entity) {
		return new QRCode();
	}
	
	@ApiOperation(value = "Validated QRCode for teacher")
	@RequestMapping(method = RequestMethod.POST, value = "/validate")
	public String validate(@ApiParam(value = "entity", required = true) @RequestBody QRCode entity) {
		return "teste";
	}
	
	
	
}