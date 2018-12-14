package daoTest;

import domian.Report;
import mapper.CourseMapper;
import mapper.ReportMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import service.CourseTmpService;

import java.util.Date;
import java.util.List;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ReportMapperTest
{
    @Autowired
    ReportMapper reportMapper;
    @Autowired
    CourseTmpService courseTmpService;

    @Test
    public void insert(){
        Report report=new Report();
       report.setCourseTemplete(courseTmpService.select(new Long(1)));
        report.setCname("linux实验");
        report.setCreatedtime(new Date());
        report.setGrade("12");
        report.setRemark("yufuyang");
        report.setStuId(new Long(1));
        report.setTmpId(new Long(1));

        reportMapper.insert(report);
    }

    @Test
    public void deleteByPrimaryKey(){
        reportMapper.deleteByPrimaryKey(new Long(4));
    }

    @Test
    public void selectByPrimaryKey(){
        Report report=reportMapper.selectByPrimaryKey(new Long(5));
        System.out.println(report);
    }

    @Test
    public void selectAll(){
        List<Report> list=reportMapper.selectAll();
        for (Report report:list){
            System.out.println(report);
        }
    }

    @Test
    public  void selectByStuId(){
        List<Report> list=reportMapper.selectByStuId(new Long(1));
        for (Report report:list){
            System.out.println(report);
        }
    }

    @Test
    public void updateByPrimaryKey(){
        Report report=reportMapper.selectByPrimaryKey(new Long(5));
        report.setCname("yujiajun");
        reportMapper.updateByPrimaryKey(report);
    }


}
