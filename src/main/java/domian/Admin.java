package domian;

import lombok.Data;

import java.util.Date;

@Data
public class Admin {

    private Long id;

    private String aname;

    private String pwd;

    private Date lastlogin;

}