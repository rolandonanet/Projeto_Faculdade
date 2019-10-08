package com.api.presence_list.service;

import com.api.presence_list.model.SchoolSubjetcs;
import com.api.presence_list.repository.SchoolSubjetcsRepository;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface SchoolSubjetcsService extends GenericService<SchoolSubjetcs, ObjectId>, SchoolSubjetcsRepository {

	Optional<SchoolSubjetcs> read(ObjectId id);

	SchoolSubjetcs update(SchoolSubjetcs schoolsubjetcs);

	void delete(SchoolSubjetcs id);

	Page<SchoolSubjetcs> list(Integer pageNumber, Integer pageSize, Sort.Direction direction, String orderBy);

	Page<SchoolSubjetcs> search(SchoolSubjetcs schoolsubjetcs, Integer pageNumber, Integer pageSize,
			Sort.Direction direction, String orderBy);

	Page<SchoolSubjetcs> find(SchoolSubjetcs schoolsubjetcs, Integer pageNumber, Integer pageSize,
			Sort.Direction direction, String orderBy);

}