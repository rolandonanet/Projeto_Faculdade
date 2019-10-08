package com.api.presence_list.repository;

import com.api.presence_list.model.User;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericRepository<User, ObjectId> {
}