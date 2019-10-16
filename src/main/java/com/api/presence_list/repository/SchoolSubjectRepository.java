package com.api.presence_list.repository;

import com.api.presence_list.model.SchoolSubject;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolSubjectRepository extends GenericRepository<SchoolSubject, ObjectId> {
}