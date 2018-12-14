package service;


import domian.Report;

import java.util.List;

public interface ReportService {
	
	void add(Report c);
	
	void update(Report c);
	
	Report select(Long id);
	
	void delete(Long id);
	
	List<Report> list();
	
	List<Report> selectByStuId(Long stuid);


}
