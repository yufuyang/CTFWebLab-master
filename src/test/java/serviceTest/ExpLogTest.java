package serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import service.ExpLogService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ExpLogTest {

	@Autowired
	ExpLogService expLogService;

	@Test
	public void selestCourse(){

	}

	@Test
	public void selestOneCourse(){

	}

	@Test
	public void addOneCourse(){

	}

	@Test
	public void deleteOneCourse(){

	}

	@Test
	public void selectByPageCourse(){

	}

}
