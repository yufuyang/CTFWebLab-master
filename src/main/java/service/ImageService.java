package service;


import domian.Imagelocal;

import java.util.List;

public interface ImageService {
	
	void add(Imagelocal i);
	
	void update(Imagelocal i);
	
	Imagelocal select(Long id);
	
	void delete(Long id);
	
	List<Imagelocal> list();
}
