package serviceTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import domian.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import service.*;
import util.PageResult;
import util.ResultJSON;

import java.util.*;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class CourseServiceTest {

	@Autowired
    CourseService courseservice;
    @Autowired
	CourseTmpService courseTmpService;
	@Test
	public void selestCourse(){
		List<Course> courses = courseservice.list();
		for (Course course : courses) {
			System.out.println(course);
		}
	}

	@Test
	public void selestOneCourse(){
		Course course = courseservice.select((long)2);
		System.out.println(course);
        courseservice.add(course);
	}

	@Test
	public void addCourse(){
		Course course=new Course();
		course.setTchId(new Long(1));
		course.setState(0);
		course.setCreatedtime(new Date());
		course.setCount(42);
		course.setCname("yufuayng");
		List<CourseTemplete> courseTempletes=courseTmpService.list();
        course.setCourseTempletes(courseTempletes);

		courseservice.add(course);

	}

	@Test
	public void deleteOneCourse(){
	    for (int i=41;i<45;i++) {
            courseservice.delete((long)i);
        }
	}

	@Test
	public void selectByPageCourse(){
	    PageResult result = courseservice.selectAllByPage(1,9);
        System.out.println(result);
	}

	@Test
	public void updteCourse(){
		Course course=courseservice.select((long) 40);
		course.setCname("chenliangxuan");
		courseservice.update(course);
	}

}
