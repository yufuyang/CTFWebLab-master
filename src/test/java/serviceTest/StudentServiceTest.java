package serviceTest;

import domian.Course;
import domian.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import service.CourseService;
import service.StudentService;

import java.util.List;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @Test
    public void selectTest() {
        Student student =studentService.select((long)1);
        System.out.println(student);
    }
    @Test
    public void selectCoursesTest() {
        List<Course> courses = courseService.selectByStuId((long)1);
        for (Course course:courses
             ) {
            System.out.println(course);
        }
    }
}
