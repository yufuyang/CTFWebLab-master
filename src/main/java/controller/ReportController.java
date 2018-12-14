package controller;

import domian.Report;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ReportService;
import util.Obj2ListData;
import util.ResultJSON;

import java.util.HashMap;
import java.util.List;

@Api(value = "/report", tags = "报告相关接口")
@RequestMapping("/report")
@Controller
public class ReportController
{
    @Autowired
    ReportService reportService;
    /**
     * @Author:Rider yufuyang
     * @Description: 添加报告的方法
     * @Date: 20:04 2018/12/13
    */
    @ApiOperation(value = "添加报告", httpMethod = "POST")
    @RequestMapping(value = "/v1/addReport", method = RequestMethod.POST)
    @ResponseBody
    public ResultJSON addReport(@RequestBody Report report){
        ResultJSON json=new ResultJSON();
        if (report!=null){
            reportService.add(report);
            if (report.getId()!=null){
                return json.success();
            }else return json.failure("添加失败");
        }else return json.failure("输入为空");
    }

    /**
     * @Author:Rider yufuyang
     * @Description: 修改报告的方法
     * @Date: 20:05 2018/12/13
    */
    @ApiOperation(value = "修改报告", httpMethod = "PUT")
    @RequestMapping(value = "/v1/updateReport", method = RequestMethod.PUT)
    @ResponseBody
    public ResultJSON updateReport(@RequestBody Report report){
        ResultJSON json=new ResultJSON();
        if (report!=null){
            if (report.getId()!=null){
                reportService.update(report);
                return json.success();
            }return json.failure("修改失败");
        }return json.failure("输入为空");
    }
    /**
     * @Author:Rider yufuyang
     * @Description: 根据id查询报告的方法
     * @Date: 20:07 2018/12/13
    */

    @ApiOperation(value = "查询报告", httpMethod = "GET")
    @RequestMapping(value = "/v1/selectReport/{reportid}", method = RequestMethod.GET)
    @ResponseBody
    public ResultJSON selectReport(@PathVariable Long reportid){
        ResultJSON json=new ResultJSON();
        if (reportid!=null){
            reportService.select(reportid);
            return json.success();
        }else return  json.failure("输入为空");

    }

    /**
     * @Author:Rider yufuyang
     * @Description: 根据id删除报告的方法
     * @Date: 20:09 2018/12/13
    */

    /*
    @ApiOperation(value = "删除报告", httpMethod = "DELETE")
    @RequestMapping(value = "/v1/deleteReport/{reportid}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResultJSON deleteReport(@PathVariable Long reportid){
        ResultJSON json=new ResultJSON();
        if (reportid!=null){
            reportService.delete(reportid);
            return json.success();
        }else return  json.failure();
    }
    */

    /**
     * @Author:Rider yufuyang
     * @Description: 查看全部报告的方法
     * @Date: 20:16 2018/12/13
    */
    @ApiOperation(value = "查看全部报告", httpMethod = "GET")
    @RequestMapping(value = "/v1/selectAllReport", method = RequestMethod.GET)
    @ResponseBody
    public ResultJSON selectAllReport(){
        ResultJSON json=new ResultJSON();
        List<Report> list=reportService.list();
        json.success();
        List<HashMap> listData = Obj2ListData.ReportToListData(list);
        HashMap<String,List> datamap= new HashMap<>();
        datamap.put("listData",listData);
        json.setData(datamap);
        return json;

    }


    }


