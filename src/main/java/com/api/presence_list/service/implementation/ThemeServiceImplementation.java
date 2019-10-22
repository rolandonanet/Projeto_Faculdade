package com.api.presence_list.service.implementation;

import com.api.presence_list.model.Theme;
import com.api.presence_list.service.ThemeService;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service("themeService")
public class ThemeServiceImplementation extends GenericServiceImplementation<Theme, ObjectId> implements ThemeService {

}