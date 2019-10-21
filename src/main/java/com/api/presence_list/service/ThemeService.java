package com.api.presence_list.service;

import com.api.presence_list.model.Theme;
import com.api.presence_list.repository.ThemeRepository;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import java.util.Optional;

@Lazy
public interface ThemeService extends GenericService<Theme, ObjectId>, ThemeRepository {

	Optional<Theme> read(ObjectId id);

	Theme update(Theme theme);

	void delete(Theme id);

	Page<Theme> list(Integer pageNumber, Integer pageSize, Sort.Direction direction, String orderBy);

	Page<Theme> search(Theme theme, Integer pageNumber, Integer pageSize,
			Sort.Direction direction, String orderBy);

	Page<Theme> find(Theme theme, Integer pageNumber, Integer pageSize,
			Sort.Direction direction, String orderBy);

}