package mapper;

import domian.CourseTemplete;

import java.util.List;

public interface CourseTempleteMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(CourseTemplete record);
    
    int addRelation(Long tmpId, Long imgId);
    
    int deleteRelation(Long id);

    CourseTemplete selectByPrimaryKey(Long id);

    List<CourseTemplete> selectAll();

    int updateByPrimaryKey(CourseTemplete record);
}