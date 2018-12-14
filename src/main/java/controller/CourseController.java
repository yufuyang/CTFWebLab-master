package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import domian.Course;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import service.CourseService;
import springfox.documentation.annotations.ApiIgnore;
import util.Obj2ListData;
import util.PageResult;
import util.ResultJSON;
import util.UserContext;

@Api(value = "/course", tags = "课程相关接口")
@RequestMapping("/course")
@Controller
public class CourseController extends BaseController {

	@Autowired
	CourseService courseservive;

	@ApiOperation(value = "获取首页课程", notes = "获取首页上展示的部分课程,暂时设置为获取9个课程信息", httpMethod = "GET")
	@RequestMapping(value = "/v1/courses", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON selectCourses() {
	    ResultJSON json = new ResultJSON();
		List<Course> courses =courseservive.selectHomePage(9);
		json.success();
        List<HashMap> listData = Obj2ListData.CourseToListData(courses);
        HashMap<String,List> datamap= new HashMap<>();
        datamap.put("listData",listData);
        json.setData(datamap);
		return json;
	}

	@ApiOperation(value = "查看指定课程", notes = "根据课程id查询课程信息", httpMethod = "GET", response = Course.class)
	@RequestMapping(value = "/v1/course/{courseid}", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON selectCourse(@PathVariable Long courseid) {
		ResultJSON json =new ResultJSON();
		Course courseinfo = courseservive.select(courseid);
		HashMap<String,Course> map = new HashMap<>();
		map.put("courseinfo",courseinfo);
		json.success(map);
		return json;
	}


	@ApiOperation(value = "查看更多课程", notes = "首页点击“更多”，将分页展示所有课程，传入参数为当前页数，pageSize暂时设定为9", httpMethod = "GET", response = Course.class)
	@RequestMapping(value = "/v1/courses/more", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON selectCoursesMore(Integer currentPage) {
		ResultJSON json = new ResultJSON();
		PageResult pageResult= this.courseservive.selectAllByPage(currentPage,9);
		HashMap<String,PageResult> map = new HashMap<>();
		map.put("pageResult",pageResult);
		json.success(map);
		return json;
	}



	@ApiIgnore
	@RequestMapping(value = "/v1/coursejoin", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON joinCourse(@Param("courseid") Long courseid) {
		ResultJSON json = new ResultJSON();

		Long stuid = UserContext.getCurrent().getUserinfo();
		List<Course> courses = courseservive.selectByStuId(stuid);
		for (Course course : courses) {
			if (course.getId() == courseid) {
				//json.setMsg("已参加过该课程");
				return json;
			}
		}

		//json.setSuccess(true);
		//json.setMsg(courses.toString() + " " + courseid);

		return json;
	}
    /**
     * @Author:Rider yufuyang
     * @Description: 添加课程的方法
     * @Date: 19:56 2018/12/13
    */
	@ApiOperation(value = "添加课程",httpMethod = "POST")
	@RequestMapping(value = "/v1/insertCourse",method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON insertCourse(@RequestBody Course course){
		ResultJSON json=new ResultJSON();
		if (course!=null){

			courseservive.add(course);
			if(course.getId()!=null){
				return  json.success();
			}else  return json.failure("添加失败");
		}else return json.failure("输入为空 ");
	}


	/**
     * @Author:Rider yufuayng
     * @Description: 修改课程的方法
     * @Date: 19:58 2018/12/13
    */
	@ApiOperation(value = "修改课程",httpMethod = "PUT")
	@RequestMapping(value = "/v1/updateCourse",method = RequestMethod.PUT)
	@ResponseBody
	public ResultJSON updteCourse(@RequestBody Course course){
		ResultJSON json=new ResultJSON();
		if (course.getId()!=null){
			courseservive.update(course);
			return json.success();
		}else  return json.failure("输入为空");
	}

	/**
	 * @Author:Rider yufuyang
	 * @Description: 删除课程的方法
	 * @Date: 20:00 2018/12/13
	*/
	@ApiOperation(value = "删除课程",httpMethod = "DELETE")
	@RequestMapping(value = "/v1/Course/{courseid}",method = RequestMethod.DELETE)
	@ResponseBody
	public ResultJSON deleteCourse(@PathVariable Long courseid){
		ResultJSON json=new ResultJSON();
		if (courseid!=null){
			int Usertype=UserContext.getCurrent().getUsertype();//判断用户类型
			if(Usertype==1){
				Long teacherId=courseservive.select(courseid).getTchId();//得到此课程老师的id
				Long userinfo=UserContext.getCurrent().getUserinfo();//得到操作此课程老师的id
				if (teacherId==userinfo)
				{
					courseservive.delete(courseid);
					return json.success();
				}else return json.failure("此课程不属于此老师");
			}else return  json.failure("只能老师删除课程");

		}else return json.failure("输入为空");
	}

}
