package service.impl;

import domian.Course;
import domian.Report;
import domian.Teacher;
import mapper.CourseMapper;
import mapper.ReportMapper;
import mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ReportService;
import service.TeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherMapper teachermapper;

	@Autowired
	ReportMapper reportMapper;
	
	@Autowired
	CourseMapper coursemapper;
	
	@Override
	public void add(Teacher t) {
		teachermapper.insert(t);
	}

	@Override
	public void update(Teacher t) {
		teachermapper.updateByPrimaryKey(t);
	}

	@Override
	public Teacher select(Long id) {
		Teacher teacher = teachermapper.selectByPrimaryKey(id);
		return teacher;
	}

	@Override
	public void delete(Long id) {
		teachermapper.deleteByPrimaryKey(id);
		List<Course> courses = coursemapper.selectByTchId(id);
		for (Course course : courses) {
			course.setTchId(null);
			coursemapper.updateByPrimaryKey(course);
		}
	}

	@Override
	public List<Teacher> list() {
		List<Teacher> teachers = teachermapper.selectAll();
		return teachers;
	}

	/**
	 * @Author:Rider yufuyang
	 * @Description: 老师评估实验报告的方法
	 * @Date: 22:46 2018/12/13
	 */
	@Override
	public void updateReport(Report r)
	{
		reportMapper.updateByTeacher(r);
	}


}
