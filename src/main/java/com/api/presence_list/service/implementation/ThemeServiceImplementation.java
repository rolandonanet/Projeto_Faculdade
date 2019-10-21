package com.api.presence_list.service.implementation;

import com.api.presence_list.model.Theme;
import com.api.presence_list.repository.GenericRepository;
import com.api.presence_list.repository.ThemeRepository;
import com.api.presence_list.service.ThemeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("themeService")
public class ThemeServiceImplementation extends GenericServiceImplementation<Theme, ObjectId> implements ThemeService {
	@Autowired
	private ThemeRepository repository;


	public ThemeServiceImplementation(GenericRepository<Theme, ObjectId> genericRepository) {
		super(genericRepository);

	}

}