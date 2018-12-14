package service.impl;

import java.util.List;

import domian.Report;
import mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportMapper reportMapper;

	@Override
	public void add(Report c) {
		reportMapper.insert(c);
	}

	@Override
	public void update(Report c) {
		reportMapper.updateByPrimaryKey(c);
	}

	@Override
	public Report select(Long id) {
		Report report = reportMapper.selectByPrimaryKey(id);
		return report;
	}

	@Override
	public void delete(Long id) {
		reportMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Report> list() {
		List<Report> reports = reportMapper.selectAll();
		return reports;
	}

	@Override
	public List<Report> selectByStuId(Long stuid) {
		List<Report> reports = reportMapper.selectByStuId(stuid);
		return reports;
	}


	
		
}
