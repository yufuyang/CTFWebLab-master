package mapper;

import domian.Admin;

import java.util.List;

public interface AdminMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    Admin selectByPrimaryKey(Long id);

    List<Admin> selectAll();

    int updateByPrimaryKey(Admin record);
    
}