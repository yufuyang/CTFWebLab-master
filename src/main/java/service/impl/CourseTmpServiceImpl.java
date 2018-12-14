package service.impl;

import domian.CourseTemplete;
import domian.Imagelocal;
import mapper.CourseTempleteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CourseTmpService;

import java.util.List;

@Service
public class CourseTmpServiceImpl implements CourseTmpService {

	@Autowired
	CourseTempleteMapper courseTempleteMapper;
	
	@Override
	public void add(CourseTemplete c) {
		courseTempleteMapper.insert(c);
		List<Imagelocal> imagelocals = c.getImagelocals();
		for (Imagelocal imagelocal : imagelocals) {
			courseTempleteMapper.addRelation(c.getId(), imagelocal.getId());
		}
	}

	@Override
	public void update(CourseTemplete c) {
		courseTempleteMapper.updateByPrimaryKey(c);
		courseTempleteMapper.deleteByPrimaryKey(c.getId());
		List<Imagelocal> imagelocals = c.getImagelocals();
		for (Imagelocal imagelocal : imagelocals) {
			courseTempleteMapper.addRelation(c.getId(), imagelocal.getId());
		}
	}

	@Override
	public CourseTemplete select(Long id) {
		CourseTemplete courseTemplete = courseTempleteMapper.selectByPrimaryKey(id);
		return courseTemplete;
	}

	@Override
	public void delete(Long id) {
		courseTempleteMapper.deleteByPrimaryKey(id);
		courseTempleteMapper.deleteRelation(id);
	}

	@Override
	public List<CourseTemplete> list() {
		List<CourseTemplete> courseTempletes = courseTempleteMapper.selectAll();
		return courseTempletes;
	}
	

	
	
}
