package service.impl;

import domian.Imagelocal;
import mapper.ImagelocalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ImageService;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	ImagelocalMapper imagelocalMapper;

	@Override
	public void add(Imagelocal i) {
		imagelocalMapper.insert(i);
	}

	@Override
	public void update(Imagelocal i) {
		imagelocalMapper.updateByPrimaryKey(i);
	}

	@Override
	public Imagelocal select(Long id) {
		Imagelocal imagelocal = imagelocalMapper.selectByPrimaryKey(id);
		return imagelocal;
	}

	@Override
	public void delete(Long id) {
		imagelocalMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Imagelocal> list() {
		List<Imagelocal> imagelocals = imagelocalMapper.selectAll();
		return imagelocals;
	}
	
	
}
