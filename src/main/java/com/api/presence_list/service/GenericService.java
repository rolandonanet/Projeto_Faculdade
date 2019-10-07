package com.api.presence_list.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.api.presence_list.repository.GenericRepository;

import java.util.Optional;

/**
 * The type Generic Service.
 *
 * @param <E> Generic Entity
 * @param <U> Generic Entity ObjectId
 */
public interface GenericService<E, D> extends GenericRepository<E, D> {


}
