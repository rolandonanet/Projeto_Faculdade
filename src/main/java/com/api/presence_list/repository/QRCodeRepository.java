package com.api.presence_list.repository;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.api.presence_list.model.QRCode;
import com.api.presence_list.model.StudentClass;

@Repository
public interface QRCodeRepository extends GenericRepository<QRCode, ObjectId> {

}

