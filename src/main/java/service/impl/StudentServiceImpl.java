package service.impl;

import domian.Student;
import mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentmapper;
	
	@Override
	public void add(Student s) {
		studentmapper.insert(s);
	}

	@Override
	public void update(Student s) {
		studentmapper.updateByPrimaryKey(s);
	}

	@Override
	public Student select(Long id) {
		Student student = studentmapper.selectByPrimaryKey(id);
		return student;
	}

	@Override
	public void delete(Long id) {
		studentmapper.deleteByPrimaryKey(id);
		studentmapper.deleteRelation(id);
	}

	@Override
	public List<Student> list() {
		List<Student> students = studentmapper.selectAll();
		return students;
	}	
	
	
		
}
