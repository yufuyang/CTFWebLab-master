package mapper;

import domian.Experimentlog;
import java.util.List;

public interface ExperimentlogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Experimentlog record);

    Experimentlog selectByPrimaryKey(Long id);

    List<Experimentlog> selectAll();

    int updateByPrimaryKey(Experimentlog record);
}