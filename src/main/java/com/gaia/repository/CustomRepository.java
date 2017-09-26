package com.gaia.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import com.gaia.utils.Groups;
import com.gaia.utils.PageObj;


@NoRepositoryBean
public interface CustomRepository<T, ID extends Serializable> extends JpaRepository<T, ID>{
	
	PageObj<T> findEntityPageByGroups(Groups groups, PageObj<T> page);
	
	List<T> findEntityByGroups(Groups groups);
	
	long findTotalCountByGroups(Groups groups);
	
	T find(Long id);

}
