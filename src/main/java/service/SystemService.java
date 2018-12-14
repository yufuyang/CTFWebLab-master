package service;


import domian.Course;
import domian.SysPermision;

import java.util.List;

public interface SystemService {
	
	void add(SysPermision p);
	
	void update(SysPermision c);
	
	Course select(Long id);
	
	void delete(Long id);
	
	List<SysPermision> list();
	
	List<SysPermision> selectByUserType(int usertype);
}
