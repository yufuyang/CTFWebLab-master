package controller;

import domian.Report;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TeacherService;
import util.ResultJSON;

@Api(value = "/teacher", tags = "老师相关接口")
@RequestMapping("/teacher")
@Controller
public class TeacherController
{


    @Autowired
    TeacherService teacherService;

    /**
     * @Author:Rider yufuyang
     * @Description: 老师评估实验报告的方法
     * @Date: 22:46 2018/12/13
    */
    @ApiOperation(value = "评估实验报告",httpMethod = "PUT")
    @RequestMapping(value = "/v1/updateReport",method = RequestMethod.PUT)
    @ResponseBody
    public ResultJSON updateReport(@RequestBody Report report){
        ResultJSON json=new ResultJSON();
        if (report!=null){
            teacherService.updateReport(report);
            return json.success();
        }else return json.failure("输入为空");
    }
}
