package com.api.presence_list.service.implementation;

import java.util.Optional;

import com.api.presence_list.repository.GenericRepository;
import com.api.presence_list.service.GenericService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericServiceImplementation<R, D> implements GenericService<R, D> {

	@Autowired
	private GenericRepository<R, D> genericRepository;

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
	public void deleteById(D d) {
		genericRepository.deleteById(d);
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

}