package mapper;

import domian.Student;

import java.util.List;

public interface StudentMapper {
	
    int deleteByPrimaryKey(Long id);

    int deleteRelation(Long id);
    
    int insert(Student record);

    Student selectByPrimaryKey(Long id);

    List<Student> selectAll();

    int updateByPrimaryKey(Student record);
}