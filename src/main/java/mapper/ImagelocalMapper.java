package mapper;

import domian.Imagelocal;

import java.util.List;

public interface ImagelocalMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Imagelocal record);

    Imagelocal selectByPrimaryKey(Long id);

    List<Imagelocal> selectAll();

    int updateByPrimaryKey(Imagelocal record);
}