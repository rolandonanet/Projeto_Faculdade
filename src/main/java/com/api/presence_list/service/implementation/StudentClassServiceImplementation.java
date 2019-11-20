package com.api.presence_list.service.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.api.presence_list.model.SchoolSubject;
import com.api.presence_list.model.StudentClass;
import com.api.presence_list.model.Theme;
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
//		Theme themeQuery = new Theme();
//		themeQuery.set_id(entity.getThemeId().toHexString());
//		SchoolSubject schoolSubjectQuery = new SchoolSubject();
//		schoolSubjectQuery.set_id(null);
//		schoolSubjectQuery.setTheme(themeQuery);
//		StudentClass studentClassQuery = new StudentClass();
//		List<SchoolSubject> schoolSubjectQueryList = new ArrayList<SchoolSubject>();
//		schoolSubjectQueryList.add(schoolSubjectQuery);
//		studentClassQuery.setSchoolSubjects(schoolSubjectQueryList);
//		Example<StudentClass> example = Example.of(studentClassQuery);
//		List<StudentClass> studentClassRaw = studentClassRepository.findAll(example);
//		StudentClass studentClass = new StudentClass();
//		List<SchoolSubject> subjects = studentClass.getSchoolSubjects();
//
//		for (SchoolSubject subject : subjects) {
//			if (subject.getTheme().get_id().equals(entity.getThemeId())) {
//				subject.getTheme().getUserIds().add(entity.getUserId());
//			}
//		}
//		studentClass.setSchoolSubjects(subjects);
//		studentClassRepository.save(studentClass);

		List<StudentClass> studentClassRaw = studentClassRepository.findAll();

		for (StudentClass studentClass : studentClassRaw) {

			List<SchoolSubject> subjects = studentClass.getSchoolSubjects();

			for (SchoolSubject subject : subjects) {
				if (subject.getTheme().get_id().equals(entity.getThemeId().toHexString())) {
					subject.getTheme().getUserIds().add(entity.getUserId());
					studentClass.setSchoolSubjects(subjects);
					studentClassRepository.save(studentClass);
				}
			}

		}
	}

}