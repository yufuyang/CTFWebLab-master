package domian;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Logininfo {
	
    private Long id;

    private Integer usertype;

    private Long usercode;

    private String username;
    
    private String password;

    private String salt;

    private Integer locked;

    private Integer isexp;

    private Long userid;

    private String img;
}