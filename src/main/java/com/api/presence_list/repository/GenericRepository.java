package com.api.presence_list.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * The type Generic Repository.
 *
 * @param <E> Generic Entity
 * @param <U> Generic Entity ObjectId
 */
@NoRepositoryBean
public interface GenericRepository<E, D> extends MongoRepository<E, D> {
}
