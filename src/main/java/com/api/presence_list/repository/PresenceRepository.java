package com.api.presence_list.repository;

import com.api.presence_list.model.Presence;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

@Repository
public interface PresenceRepository extends GenericRepository<Presence, ObjectId> {
}