package mapper;

import domian.Logininfo;

import java.util.List;

public interface LogininfoMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(Logininfo record);

    Logininfo selectByPrimaryKey(Long id);
    
    Logininfo selectByUsercode(Long usercode);

    List<Logininfo> selectAll();

    int updateByPrimaryKey(Logininfo record);
    
}