package service;


import domian.Experimentlog;

import java.util.List;

public interface ExpLogService {

	void add(Experimentlog e);

	void update(Experimentlog e);

	Experimentlog select(Long id);

	void delete(Long id);

	List<Experimentlog> list();

}
