package com.api.presence_list.controller;

import com.api.presence_list.service.GenericService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * The type Generic controller.
 *
 * @param <E> Generic Entity
 * @param <U> Generic Entity ObjectId
 */
public abstract class GenericController<E, U> {

	@Autowired
	private GenericService<E, U> service;

	@ApiOperation(value = "create")
	@RequestMapping(method = RequestMethod.POST)
	public E create(@ApiParam(value = "entity", required = true) @RequestBody E entity) {
		return service.create(entity);
	}

	@ApiOperation(value = "read")
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Optional<E> read(@ApiParam(value = "id", required = true) @PathVariable U id) {
		return service.read(id);
	}

	@ApiOperation(value = "update")
	@RequestMapping(method = RequestMethod.PUT)
	public E update(@ApiParam(value = "entity", required = true) @RequestBody @Valid E entity) {
		return service.update(entity);
	}

	@ApiOperation(value = "delete")
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@ApiParam(value = "id", required = true) @PathVariable U id) {
		service.deleteById(id);
	}

	@ApiOperation(value = "Show a Pageable list of all items")
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public Page<E> list(@RequestParam(value = "page number", defaultValue = "0") Integer pageNumber,
			@RequestParam(value = "page size", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "direction", defaultValue = "ASC") Sort.Direction direction,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {
		return service.list(pageNumber, pageSize, direction, orderBy);
	}

	@ApiOperation(value = "Show a pageable list of a filter of items (like)")
	@RequestMapping(method = RequestMethod.GET, value = "/search")
	public Page<E> search(@ApiParam(value = "game", required = true) E entity,
			@RequestParam(value = "page number", defaultValue = "0") Integer pageNumber,
			@RequestParam(value = "page size", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "direction", defaultValue = "ASC") Sort.Direction direction,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {
		return service.search(entity, pageNumber, pageSize, direction, orderBy);
	}

	@ApiOperation(value = "Show a pageable list of a filter of items (exact)")
	@RequestMapping(method = RequestMethod.GET, value = "/find")
	public Page<E> find(@ApiParam(value = "game", required = true) E entity,
			@RequestParam(value = "page number", defaultValue = "0") Integer pageNumber,
			@RequestParam(value = "page size", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "direction", defaultValue = "ASC") Sort.Direction direction,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {
		return service.find(entity, pageNumber, pageSize, direction, orderBy);
	}

}
