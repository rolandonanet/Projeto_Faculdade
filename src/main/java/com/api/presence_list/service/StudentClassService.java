package com.api.presence_list.service;

import com.api.presence_list.model.StudentClass;
import com.api.presence_list.repository.StudentClassRepository;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface StudentClassService extends GenericService<StudentClass, ObjectId>, StudentClassRepository {

	Optional<StudentClass> read(ObjectId id);

	StudentClass update(StudentClass studentClass);

	void delete(StudentClass id);

	Page<StudentClass> list(Integer pageNumber, Integer pageSize, Sort.Direction direction, String orderBy);

	Page<StudentClass> search(StudentClass studentClass, Integer pageNumber, Integer pageSize,
			Sort.Direction direction, String orderBy);

	Page<StudentClass> find(StudentClass studentClass, Integer pageNumber, Integer pageSize,
			Sort.Direction direction, String orderBy);

}