package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import domian.Course;
import domian.Report;
import domian.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import service.CourseService;
import service.ReportService;
import service.StudentService;
import springfox.documentation.annotations.ApiIgnore;
import util.ResultJSON;
import util.UserContext;

@Api(value="/stu",tags="学生相关接口")
@ResponseBody
@RequestMapping("/student")
@Controller
public class StudentController extends BaseController {
	
	@Autowired
	StudentService studentservice;
	
	@Autowired
	ReportService reportService;

	@Autowired
    CourseService courseService;

	@ApiOperation(value = "获取学生信息", notes = "获取学生基本信息", httpMethod = "GET")
	@RequestMapping(value="v1/info",method=RequestMethod.GET)
	public ResultJSON getinfo(){
		ResultJSON json = new ResultJSON();
		Long stuid = UserContext.getCurrent().getUserinfo();
		Student studentinfo = studentservice.select(stuid);
        System.out.println(studentinfo);
		HashMap<String,Student> map = new HashMap<>();
		map.put("studentinfo",studentinfo);
		json.success(map);
		return json;
	}

	@ApiIgnore
    @ApiOperation(value = "我的课程", notes = "获取我参加的课程", httpMethod = "GET")
    @RequestMapping(value="v1/courses",method=RequestMethod.GET)
    public ResultJSON getCourses(){
	    ResultJSON json =new ResultJSON();
        List<Course> courses = courseService.selectByStuId(UserContext.getCurrent().getUserinfo());
        List<HashMap> listData = new ArrayList<>();
        for (Course course:courses) {
            HashMap<String,String> map = new HashMap<>();
            map.put("courseid",course.getId().toString());
            map.put("coursename",course.getCname());
            map.put("img",course.getImg());
            map.put("state",course.getState().toString());
            listData.add(map);
        }
        HashMap<String , List> datamap = new HashMap<>();
        datamap.put("listData",listData);
        json.success(datamap);
        return json;
    }

    @ApiIgnore
	@ApiOperation(value = "我的实验记录", notes = "获取关于我的所有实验记录", httpMethod = "GET")
	@RequestMapping(value="v1/repos",method=RequestMethod.GET)
	public List<Report> getRepos(){
		Long stuid = UserContext.getCurrent().getUserinfo();
		List<Report> reports=reportService.selectByStuId(stuid);
		return reports;
	}

	@ApiIgnore
	@ApiOperation(value = "查看指定实验报告", notes = "获取指定实验报告的详细内容，实验报告页面具体字段还需商榷（待讨论", httpMethod = "GET")
	@RequestMapping(value="v1/repos/{repoid}",method=RequestMethod.GET)
	public Report getReposById(@PathVariable Long repoid){
		return reportService.select(repoid);
	}
	
	

}
