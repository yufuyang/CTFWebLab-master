package domian;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
public class Imagelocal {

    private Long id;

    private String iname;

    private String size;

    private String ports;

    private Date createdtime;

    private String idescribe;

    private String imageid;

}