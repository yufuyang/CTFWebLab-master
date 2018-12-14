package domian;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Student {
    private Long id;

    private Long number;

    private String college;

    private String classname;

    private String img;

    private String tdescribe;

    private String location;

    private Date jointime;

    private String realname;

    //private List<Course> courses;
}