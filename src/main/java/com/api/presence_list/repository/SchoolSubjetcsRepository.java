package com.api.presence_list.repository;

import com.api.presence_list.model.SchoolSubjetcs;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolSubjetcsRepository extends GenericRepository<SchoolSubjetcs, ObjectId> {
}