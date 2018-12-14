package service;


import domian.Course;
import util.PageResult;

import java.util.List;

public interface CourseService {
	
	void add(Course c);
	
	void update(Course c);
	
	Course select(Long id);
	
	void delete(Long id);
	
	List<Course> list();

	List<Course> selectHomePage(int number);

    PageResult selectAllByPage(int currentPage,int pageSize);

	List<Course> selectByStuId(Long id);
}
