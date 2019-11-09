package com.api.presence_list.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.presence_list.model.StudentClass;
import com.api.presence_list.model.User;

@Repository
public interface StudentClassRepository extends GenericRepository<StudentClass, ObjectId> {
	
}