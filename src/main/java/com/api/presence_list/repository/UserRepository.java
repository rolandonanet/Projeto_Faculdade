package com.api.presence_list.repository;

import com.api.presence_list.model.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericRepository<User, ObjectId> {

	Page<User> findAllByUserType(String type, Pageable pagination);

	Optional<User> findByEmailAndPassword(String email, String password);

}