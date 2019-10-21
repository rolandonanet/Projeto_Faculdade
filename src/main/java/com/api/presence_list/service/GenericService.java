package com.api.presence_list.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.api.presence_list.repository.GenericRepository;

import java.util.Optional;

/**
 * The type Generic Service.
 *
 * @param <E> Generic Entity
 * @param <U> Generic Entity ObjectId
 */

public interface GenericService<E, D> extends GenericRepository<E, D> {

	E create(E entity);

	Optional<E> read(D id);

	E update(E entity);

	void deleteById(D id);

	Page<E> list(Integer pageNumber, Integer pageSize, Sort.Direction direction, String orderBy);

	Page<E> search(E entity, Integer pageNumber, Integer pageSize, Sort.Direction direction, String orderBy);

	Page<E> find(E entity, Integer pageNumber, Integer pageSize, Sort.Direction direction, String orderBy);

}
