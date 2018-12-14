package com.dream.dao.mysql;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.dream.model.mysql.SqlBoardModel;

public interface BoardRepository extends JpaRepository<SqlBoardModel, String> {
	@Modifying
	@Transactional
	@Query(value = "update board set delete_flag = ?1  where id in (?2)", nativeQuery = true)
	public void updateByIdIn(Integer deleteFlag, List<String> ids);

	@Query(value = "select * from board order by ?4 ?3 limit ?2,?1", nativeQuery = true)
	public List<SqlBoardModel> BoardLimit(@Valid Integer count, @Valid Integer page, @Valid String order,
			@Valid String sort);

	@Query(value = "select * from board where in (?1) order by ?5 ?4 limit ?3,?2", nativeQuery = true)
	public List<SqlBoardModel> BoardLimitIn(@Valid List<String> ids, @Valid Integer count, @Valid Integer page,
			@Valid String order, @Valid String sort);

	@Query(value = "select * from board where id = ?1", nativeQuery = true)
	public SqlBoardModel findBoardById(String id);

}
