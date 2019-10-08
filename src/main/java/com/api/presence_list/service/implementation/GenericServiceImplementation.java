package com.api.presence_list.service.implementation;

import com.api.presence_list.repository.GenericRepository;
import com.api.presence_list.service.GenericService;
import org.springframework.data.domain.*;

import java.util.List;
import java.util.Optional;

public class GenericServiceImplementation<R, D> implements GenericService<R, D> {
	private final GenericRepository<R, D> genericRepository;

	GenericServiceImplementation(GenericRepository<R, D> genericRepository) {
		this.genericRepository = genericRepository;
	}

	// Custom REST Methods
	@Override
	public R create(R entity) {
		return genericRepository.save(entity);
	}

	@Override
	public Optional<R> read(D id) {
		return genericRepository.findById(id);
	}

	@Override
	public R update(R entity) {
		return genericRepository.save(entity);
	}

	@Override
	public Page<R> list(Integer pageNumber, Integer pageSize, Sort.Direction direction, String orderBy) {
		Pageable pagination = PageRequest.of(pageNumber, pageSize, direction, orderBy);
		return genericRepository.findAll(pagination);
	}

	@Override
	public Page<R> search(R entity, Integer pageNumber, Integer pageSize, Sort.Direction direction, String orderBy) {
		Pageable pagination = PageRequest.of(pageNumber, pageSize, direction, orderBy);
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnorePaths("id");
		Example<R> query = Example.of(entity, matcher);
		return genericRepository.findAll(query, pagination);
	}

	@Override
	public Page<R> find(R entity, Integer pageNumber, Integer pageSize, Sort.Direction direction, String orderBy) {
		Pageable pagination = PageRequest.of(pageNumber, pageSize, direction, orderBy);
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues()
				.withStringMatcher(ExampleMatcher.StringMatcher.EXACT).withIgnorePaths("id");
		Example<R> query = Example.of(entity, matcher);
		return genericRepository.findAll(query, pagination);
	}

	// Default Generic Methods
	@Override
	public <S extends R> S save(S entity) {
		return genericRepository.save(entity);
	}

	@Override
	public <S extends R> List<S> saveAll(Iterable<S> entities) {
		return genericRepository.saveAll(entities);
	}

	@Override
	public Optional<R> findById(D d) {
		return genericRepository.findById(d);
	}

	@Override
	public boolean existsById(D d) {
		return genericRepository.existsById(d);
	}

	@Override
	public List<R> findAll() {
		return genericRepository.findAll();
	}

	@Override
	public Iterable<R> findAllById(Iterable<D> ds) {
		return findAllById(ds);
	}

	@Override
	public long count() {
		return count();
	}

	@Override
	public void deleteById(D d) {
	}

	@Override
	public void delete(R entity) {
	}

	@Override
	public void deleteAll(Iterable<? extends R> entities) {
	}

	@Override
	public void deleteAll() {
	}

	@Override
	public List<R> findAll(Sort sort) {
		return genericRepository.findAll(sort);
	}

	@Override
	public Page<R> findAll(Pageable pageable) {
		return genericRepository.findAll(pageable);
	}

	@Override
	public <S extends R> S insert(S entity) {
		return genericRepository.insert(entity);
	}

	@Override
	public <S extends R> List<S> insert(Iterable<S> entities) {
		return genericRepository.insert(entities);
	}

	@Override
	public <S extends R> Optional<S> findOne(Example<S> example) {
		return genericRepository.findOne(example);
	}

	@Override
	public <S extends R> List<S> findAll(Example<S> example) {
		return genericRepository.findAll(example);
	}

	@Override
	public <S extends R> List<S> findAll(Example<S> example, Sort sort) {
		return genericRepository.findAll(example, sort);
	}

	@Override
	public <S extends R> Page<S> findAll(Example<S> example, Pageable pageable) {
		return genericRepository.findAll(example, pageable);
	}

	@Override
	public <S extends R> long count(Example<S> example) {
		return genericRepository.count(example);
	}

	@Override
	public <S extends R> boolean exists(Example<S> example) {
		return genericRepository.exists(example);
	}

}