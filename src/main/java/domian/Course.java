package domian;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Course {
    private Long id;

    private String cname;

    private Long tchId;

    private Integer count;
    
    private Boolean isjoined;

    private Date createdtime;

    private Integer state;

    private String cdescribe;

    private String tag;

    private String img;

    private Teacher teacher;

   private List<CourseTemplete> courseTempletes;
}