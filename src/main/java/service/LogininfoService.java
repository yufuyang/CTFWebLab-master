package service;


import domian.Logininfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogininfoService {
	
	void add(Logininfo l);
	
	void update(Logininfo l);
	
	Logininfo select(Long usercode);
	
	void delete(Long id);
	
	List<Logininfo> list();
	/**
	 * @Author:Rider yufuyang
	 * @Description: 老师评估实验报告
	 * @Date: 22:10 2018/12/13
	 */
	void updateByTeacher( String grade, String remark, Long id);
}
