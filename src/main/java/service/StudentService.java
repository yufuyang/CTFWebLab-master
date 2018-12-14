package service;


import domian.Student;

import java.util.List;

public interface StudentService {
	
	void add(Student s);
	
	void update(Student s);
	
	Student select(Long id);
	
	void delete(Long id);
	
	List<Student> list();
}
