package domian;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class CourseTemplete {
    private Long id;

    private String cname;

    private Date createtime;

    private String cdescribe;

    private String img;

    private String createdby;

    private List<Imagelocal> imagelocals;
}