package com.api.presence_list.service.implementation;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.presence_list.model.SchoolSubject;
import com.api.presence_list.model.StudentClass;
import com.api.presence_list.model.DTO.InsertThemeUserDTO;
import com.api.presence_list.repository.StudentClassRepository;
import com.api.presence_list.service.StudentClassService;

@Service("studentClassService")
public class StudentClassServiceImplementation extends GenericServiceImplementation<StudentClass, ObjectId>
		implements StudentClassService {

	@Autowired
	private StudentClassRepository studentClassRepository;

	@Override
	public void updateThemeUser(InsertThemeUserDTO entity) {
		Optional<StudentClass> studentClassRaw = studentClassRepository.findById(entity.getThemeId());
		StudentClass studentClass = studentClassRaw.get();
		List<SchoolSubject> subjects = studentClass.getSchoolSubject();
		
		 for (SchoolSubject subject : subjects) {
		        if (subject.getTheme().getThemeId().equals(entity.getThemeId())) {
		           subject.getTheme().getUserId().add(entity.getUserId());
		        }
		    }
		studentClass.setSchoolSubject(subjects);
		studentClassRepository.save(studentClass);
	}

}