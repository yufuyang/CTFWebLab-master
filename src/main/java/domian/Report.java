package domian;

import java.util.Date;

import lombok.Data;

@Data
public class Report {

    private Long id;

    private String cname;

    private Long tmpId;

    private Long stuId;

    private String grade;

    private Date createdtime;

    private String remark;

    private String content;

    private CourseTemplete courseTemplete;

    private Student student;
   
}