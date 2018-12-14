package service;


import domian.CourseTemplete;

import java.util.List;

public interface CourseTmpService {
	
	void add(CourseTemplete c);
	
	void update(CourseTemplete c);
	
	CourseTemplete select(Long id);
	
	void delete(Long id);
	
	List<CourseTemplete> list();
}
