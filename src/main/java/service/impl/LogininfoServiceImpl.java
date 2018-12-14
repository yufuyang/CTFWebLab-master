package service.impl;

import domian.Logininfo;
import mapper.LogininfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.LogininfoService;

import java.util.List;

@Service
public class LogininfoServiceImpl implements LogininfoService {
	
	@Autowired
	LogininfoMapper logininfomapper;

	@Override
	public void add(Logininfo l) {
		logininfomapper.insert(l);
	}

	@Override
	public void update(Logininfo l) {
		logininfomapper.updateByPrimaryKey(l);
	}

	
	@Override
	public Logininfo select(Long usercode) {
		Logininfo logininfo = logininfomapper.selectByUsercode(usercode);
		return logininfo;
	}

	@Override
	public void delete(Long id) {
		logininfomapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Logininfo> list() {
		List<Logininfo> logininfos = logininfomapper.selectAll();
		return null;
	}
	

}
