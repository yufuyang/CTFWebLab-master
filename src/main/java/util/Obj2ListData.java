package util;

import domian.Course;
import domian.Report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Obj2ListData {

    public static List<HashMap> CourseToListData(List<Course> courses){
        List<HashMap> listData = new ArrayList<>();
        for (Course course:courses) {
            HashMap<String,String> map = new HashMap<>();
            map.put("courseid",course.getId().toString());
            map.put("coursename",course.getCname());
            map.put("count",course.getCount().toString());
            map.put("img",course.getImg());
            map.put("state",course.getState().toString());
            map.put("teachername",course.getTeacher().getTname());
            listData.add(map);
        }
        return listData;
    }
    /**
     * @Author:Rider yufuyang
     * @Description: Report对象转Hashmap
     * @Date: 20:18 2018/12/13
    */
    public static List<HashMap> ReportToListData(List<Report> reports){
        List<HashMap> listData = new ArrayList<>();
        for (Report report:reports) {
            HashMap<String,String> map = new HashMap<>();
            map.put("cname",report.getCname());
            map.put("tmpId",report.getTmpId().toString());
            map.put("stuId",report.getStuId().toString());
            map.put("grade",report.getGrade());
            map.put("createdtime",report.getCreatedtime().toString());
            map.put("remark",report.getRemark());
            map.put("content",report.getContent());
            listData.add(map);
        }
        return listData;
    }

}
