package com.api.presence_list.service;

import com.api.presence_list.model.User;
import com.api.presence_list.model.DTO.LoginDTO;

import com.api.presence_list.model.DTO.PresenceInsertDTO;
import com.api.presence_list.model.DTO.PresenceUpdateDTO;
import com.api.presence_list.model.DTO.QRCodeCheckDTO;
import com.api.presence_list.model.DTO.QRCodeDTO;
import com.api.presence_list.model.DTO.QRCodeResponseDTO;

import java.text.ParseException;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface UserService extends GenericService<User, ObjectId> {

	Page<User> listType(String type, Integer pageNumber, Integer pageSize, Sort.Direction direction, String orderBy);

	Optional<User> login(LoginDTO entity);

	User insertPresence(PresenceInsertDTO entity);

	String updatePresence(PresenceUpdateDTO entity);
	
	QRCodeResponseDTO generateQRCode(QRCodeDTO entity);
	
	QRCodeResponseDTO checkQRCode(QRCodeCheckDTO entity) throws ParseException;

}