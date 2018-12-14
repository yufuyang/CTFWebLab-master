package domian;

import lombok.Data;

import java.util.Date;

@Data
public class Experimentlog {

    private Long id;

    private String cname;

    private Date operatetime;

    private Long chapter;

    private Long userid;

}