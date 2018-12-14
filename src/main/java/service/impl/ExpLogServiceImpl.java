package service.impl;

import domian.Experimentlog;
import mapper.ExperimentlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ExpLogService;

import java.util.List;

@Service
public class ExpLogServiceImpl implements ExpLogService {

	@Autowired
    ExperimentlogMapper experimentlogMapper;

	@Override
	public void add(Experimentlog e) {
        experimentlogMapper.insert(e);
	}

	@Override
	public void update(Experimentlog e) {
        experimentlogMapper.updateByPrimaryKey(e);
	}

	@Override
	public Experimentlog select(Long id) {
		return experimentlogMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delete(Long id) {
        experimentlogMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Experimentlog> list() {
		return experimentlogMapper.selectAll();
	}

		
}
