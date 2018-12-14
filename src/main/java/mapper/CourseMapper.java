package mapper;

import domian.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Course record);

    Course selectByPrimaryKey(Long id);

    List<Course> selectByTchId(Long id);
    
    List<Course> selectByStuId(Long id);

    List<Course> selectByPage(@Param("beginIndex")Integer beginIndex,@Param("pageSize")Integer pageSize);

    List<Course> selectAll();

    int countCourse();

    int checkIsJonined(@Param("stuId")Long stuId,@Param("couId")Long couId);

    int updateByPrimaryKey(Course record);

    int handleTmpRelation(@Param("courseId") Long courseId, @Param("tmpId") Long tmpId);

    int deleteTmpRelation(Long courseId);
}