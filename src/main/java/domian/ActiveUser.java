package domian;

import lombok.Data;

@Data
public class ActiveUser {
	
	private String usercode;
	
	private String username;
	
	private Integer usertype;
	
	private Long userinfo;

	private Integer locked;
	
	private Integer isexp;
	
	private String img;
	
	//private List<SysPermission> menus;
	//private List<SysPermission> permissions;
	
}
