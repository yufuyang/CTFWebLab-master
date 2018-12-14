package daoTest;

import domian.Course;
import mapper.CourseMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CourseMapperTest {

    @Autowired
    CourseMapper courseMapper;

    @Test
    public void coursesTest() {
        List<Course> courses = courseMapper.selectAll();
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Test
    public void selectOneTest() {
        Course course = courseMapper.selectByPrimaryKey((long) 1);
        System.out.println(course);
    }

    @Test
    public void addOneTest() {
        for (int i = 1; i <= 4; i++) {
            Course course1 = courseMapper.selectByPrimaryKey((long) i);
            courseMapper.insert(course1);
        }
    }

    @Test
    public void selectByPageTest() {
        List<Course> courses = courseMapper.selectByPage(0,9);
        for (Course course:courses
             ) {
            System.out.println(course);
        }
    }

   @Test
    public void countCourseTest() {
       int count = courseMapper.countCourse();
       System.out.println(count);
    }

    @Test
    public void checkedTest() {
      int check = courseMapper.checkIsJonined((long)1,(long)3);
        System.out.println(check);
    }


}
