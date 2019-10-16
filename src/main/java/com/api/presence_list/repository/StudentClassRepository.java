package com.api.presence_list.repository;

import com.api.presence_list.model.StudentClass;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentClassRepository extends GenericRepository<StudentClass, ObjectId> {
}