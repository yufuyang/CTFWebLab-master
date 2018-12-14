package mapper;

import domian.SysPermision;

import java.util.List;

public interface SysPermisionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysPermision record);

    SysPermision selectByPrimaryKey(Long id);

    List<SysPermision> selectAll();

    List<SysPermision> selectByUserType(Integer usertype);
    
    int updateByPrimaryKey(SysPermision record);
}