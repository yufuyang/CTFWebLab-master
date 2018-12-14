package service.impl;

import domian.Course;
import domian.CourseTemplete;
import mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CourseService;
import util.Obj2ListData;
import util.PageResult;
import util.UserContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseMapper coursemapper;
	
	@Override
	public void add(Course c) {
		coursemapper.insert(c);
		List<CourseTemplete> courseTempletes = c.getCourseTempletes();
        for (CourseTemplete courseTemplete:courseTempletes) {
            coursemapper.handleTmpRelation(c.getId(),courseTemplete.getId());
        }
	}
/**
 * @Author:Rider yufuyang
 * @Description: 修改了添加的方法
 * @Date: 21:38 2018/12/13
*/
	@Override
	public void update(Course u) {
		coursemapper.updateByPrimaryKey(u);
		List<CourseTemplete> courseTempletes = u.getCourseTempletes();
		coursemapper.deleteTmpRelation(u.getId());
		for (CourseTemplete courseTemplete:courseTempletes) {
			coursemapper.handleTmpRelation(u.getId(),courseTemplete.getId());
		}

	}

	@Override
	public Course select(Long id) {
		Course course = coursemapper.selectByPrimaryKey(id);
		int checked = coursemapper.checkIsJonined(UserContext.getCurrent().getUserinfo(),id);
		if (checked == 1){
			course.setIsjoined(true);
		}else {
			course.setIsjoined(false);
		}
		return course;
	}

	@Override
	public void delete(Long id) {
        coursemapper.deleteTmpRelation(id);
		coursemapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Course> list() {
		List<Course> courses = coursemapper.selectAll();
		return courses;
	}

    @Override
    public List<Course> selectHomePage(int number) {
        List<Course> courses = coursemapper.selectByPage(0,number);
        return courses;
    }

    @Override
    public PageResult selectAllByPage(int currentPage,int pageSize) {
        List<Course> courses = coursemapper.selectByPage((currentPage - 1) * pageSize,pageSize);

        List<HashMap> listData = Obj2ListData.CourseToListData(courses);
        int totalCount = coursemapper.countCourse();
	    PageResult pageResult = new PageResult(listData,totalCount,currentPage,pageSize);
        return pageResult;
    }

    @Override
	public List<Course> selectByStuId(Long id) {
		List<Course> courses = coursemapper.selectByStuId(id);
		return courses;
	}


		
}
