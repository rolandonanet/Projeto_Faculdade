package com.api.presence_list.service;

import com.api.presence_list.model.SchoolSubject;
import com.api.presence_list.repository.SchoolSubjectRepository;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface SchoolSubjectService extends GenericService<SchoolSubject, ObjectId>, SchoolSubjectRepository {

	Optional<SchoolSubject> read(ObjectId id);

	SchoolSubject update(SchoolSubject schoolsubjetcs);

	void delete(SchoolSubject id);

	Page<SchoolSubject> list(Integer pageNumber, Integer pageSize, Sort.Direction direction, String orderBy);

	Page<SchoolSubject> search(SchoolSubject schoolsubjetcs, Integer pageNumber, Integer pageSize,
			Sort.Direction direction, String orderBy);

	Page<SchoolSubject> find(SchoolSubject schoolsubjetcs, Integer pageNumber, Integer pageSize,
			Sort.Direction direction, String orderBy);

}