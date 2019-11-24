package com.api.presence_list.service.implementation;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.presence_list.model.QRCode;

import com.api.presence_list.repository.QRCodeRepository;

import com.api.presence_list.service.QRCodeService;

@Service("QRCodeService")
public class QRCodeServiceImplementation extends GenericServiceImplementation<QRCode, ObjectId>
		implements QRCodeService {

	@Autowired
	private QRCodeRepository QRCodeRepository;

}