package service;


import domian.Report;
import domian.Teacher;

import java.util.List;

public interface TeacherService {
	
	void add(Teacher t);
	
	void update(Teacher t);
	
	Teacher select(Long id);
	
	void delete(Long id);
	
	List<Teacher> list();

	/**
	 * @Author:Rider yufuyang
	 * @Description: 老师评估实验报告的方法
	 * @Date: 22:46 2018/12/13
	 */
	void updateReport(Report r);
}
