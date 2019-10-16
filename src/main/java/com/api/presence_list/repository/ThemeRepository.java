package com.api.presence_list.repository;

import com.api.presence_list.model.Theme;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends GenericRepository<Theme, ObjectId> {
}