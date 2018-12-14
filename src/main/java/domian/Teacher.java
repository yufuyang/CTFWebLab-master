package domian;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Teacher {
    private Long id;

    private String tname;

    private Long phone;

    private String email;

    private String img;

    private Date jointime;

    private Long qq;
    
    //private List<Course> courses;

}