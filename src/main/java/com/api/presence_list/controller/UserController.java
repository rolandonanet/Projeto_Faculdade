package com.api.presence_list.controller;

import com.api.presence_list.model.User;
import com.api.presence_list.model.DTO.LoginDTO;

import com.api.presence_list.model.DTO.PresenceInsertDTO;
import com.api.presence_list.model.DTO.PresenceUpdateDTO;
import com.api.presence_list.model.DTO.QRCodeCheckDTO;
import com.api.presence_list.model.DTO.QRCodeDTO;
import com.api.presence_list.model.DTO.QRCodeResponseDTO;
import com.api.presence_list.service.UserService;

import java.text.ParseException;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "User")
@RestController
@RequestMapping("/user")
public class UserController extends GenericController<User, ObjectId> {

	@Autowired
	private UserService service;

	@ApiOperation(value = "Show a Pageable list of all items by type")
	@RequestMapping(method = RequestMethod.GET, value = "/listType")
	public Page<User> list(@RequestParam(value = "type", defaultValue = "") String type,
			@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "direction", defaultValue = "ASC") Sort.Direction direction,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {
		return service.listType(type, pageNumber, pageSize, direction, orderBy);
	}

	@ApiOperation(value = "Valid if user exists")
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public Optional<User> read(@ApiParam(value = "entity", required = true) @RequestBody LoginDTO entity) {
		return service.login(entity);
	}
	
	@ApiOperation(value = "Insert presente of user")
	@RequestMapping(method = RequestMethod.POST, value = "/presence/insert")
	public User insert(@ApiParam(value = "entity", required = true) @RequestBody PresenceInsertDTO entity) {
		return service.insertPresence(entity);
	}
	
	@ApiOperation(value = "Update presente of user")
	@RequestMapping(method = RequestMethod.PUT, value = "/presence/update")
	public String update(@ApiParam(value = "entity", required = true) @RequestBody PresenceUpdateDTO entity) {
		return service.updatePresence(entity);
	}
	
	@ApiOperation(value = "Request to generate QR code")
	@RequestMapping(method = RequestMethod.POST, value = "/qrcode")
	public QRCodeResponseDTO generateQRCode(@ApiParam(value = "entity", required = true) @RequestBody QRCodeDTO entity) {
		return service.generateQRCode(entity);
	}
	
	@ApiOperation(value = "Check QR code")
	@RequestMapping(method = RequestMethod.PUT, value = "/qrcode")
	public QRCodeResponseDTO checkQRCode(@ApiParam(value = "entity", required = true) @RequestBody QRCodeCheckDTO entity) throws ParseException {
		return service.checkQRCode(entity);
	}
	
}