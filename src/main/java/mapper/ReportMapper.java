package mapper;

import domian.Report;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReportMapper {
	
    void deleteByPrimaryKey(Long id);

    void insert(Report record);

    Report selectByPrimaryKey(Long id);

    List<Report> selectAll();

    List<Report> selectByStuId(Long stuid);
    /**
     * @Author:Rider yufuyang
     * @Description: 更改了mapper中sql语句的字段content
     * @Date: 22:25 2018/12/13
    */
    void updateByPrimaryKey(Report record);
/**
 * @Author:Rider yufuyang
 * @Description: 老师评估实验报告
 * @Date: 22:10 2018/12/13
*/
    void updateByTeacher(Report record);
}