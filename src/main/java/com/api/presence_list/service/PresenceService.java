package com.api.presence_list.service;

import com.api.presence_list.model.Presence;
import com.api.presence_list.repository.PresenceRepository;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import java.util.Optional;

@Lazy
public interface PresenceService extends GenericService<Presence, ObjectId>, PresenceRepository {

	Optional<Presence> read(ObjectId id);

	Presence update(Presence presence);

	void delete(Presence id);

	Page<Presence> list(Integer pageNumber, Integer pageSize, Sort.Direction direction, String orderBy);

	Page<Presence> search(Presence presence, Integer pageNumber, Integer pageSize,
			Sort.Direction direction, String orderBy);

	Page<Presence> find(Presence presence, Integer pageNumber, Integer pageSize,
			Sort.Direction direction, String orderBy);

}