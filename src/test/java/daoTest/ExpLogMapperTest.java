package daoTest;

import mapper.ExperimentlogMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ExpLogMapperTest {

    @Autowired
    ExperimentlogMapper experimentlogMapper;

    @Test
    public void coursesTest() {

    }

    @Test
    public void selectOneTest() {

    }

    @Test
    public void addOneTest() {

    }

    @Test
    public void selectByPageTest() {

    }

   @Test
    public void countCourseTest() {

    }

    @Test
    public void checkedTest() {

    }


}
