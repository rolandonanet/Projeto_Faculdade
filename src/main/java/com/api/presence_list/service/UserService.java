package com.api.presence_list.service;

import com.api.presence_list.model.User;
import com.api.presence_list.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface UserService extends GenericService<User, ObjectId>, UserRepository {

	Optional<User> read(ObjectId id);

	User update(User user);

	void delete(User id);

	Page<User> list(Integer pageNumber, Integer pageSize, Sort.Direction direction, String orderBy);

	Page<User> search(User user, Integer pageNumber, Integer pageSize, Sort.Direction direction,
			String orderBy);

	Page<User> find(User user, Integer pageNumber, Integer pageSize, Sort.Direction direction, String orderBy);

}