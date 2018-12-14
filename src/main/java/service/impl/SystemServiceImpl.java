package service.impl;

import domian.Course;
import domian.SysPermision;
import mapper.SysPermisionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.SystemService;

import java.util.List;

@Service
public class SystemServiceImpl implements SystemService {
	
	@Autowired
	SysPermisionMapper syspermisionmapper;
	
	@Override
	public void add(SysPermision p) {
		
	}

	@Override
	public void update(SysPermision c) {
		
	}

	@Override
	public Course select(Long id) {
		return null;
	}

	@Override
	public void delete(Long id) {
		
	}

	@Override
	public List<SysPermision> list() {
		return null;
	}

	@Override
	public List<SysPermision> selectByUserType(int usertype) {
		List<SysPermision> sysPermisions = syspermisionmapper.selectByUserType(usertype);
		return sysPermisions;
	}

}
