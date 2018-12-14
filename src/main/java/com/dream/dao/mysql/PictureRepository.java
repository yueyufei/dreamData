package com.dream.dao.mysql;


import java.util.Collection;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.dream.model.Picture;
import com.dream.model.mysql.PicturelPrimaryKey;

public interface PictureRepository extends JpaRepository<Picture, PicturelPrimaryKey> {
	
	/**
	 * 根据相册id查询出相册下的所有图片
	 * @param albumid
	 * @return
	 */
	@Query(value = "select * from picture where album_id=?1 ", nativeQuery = true)
	public List<Picture> findByAlbumId(String albumid);

	/**
	 * 查询出所有未被删除的图片
	 * @param deleteFlag
	 * @return
	 */
	@Query(value = "select * from picture where delete_flag=?1 ", nativeQuery = true)
	public List<Picture> findbyDeleteFlag(@Valid Integer deleteFlag);

	/**
	 * 根据id删除图片
	 * @param ids
	 */
	@Modifying
	@Transactional
	@Query(value = "update picture set delete_flag = ?1  where id in (?2)", nativeQuery = true)
	public void batchByIdIn(Integer deleteFlag,Collection<String> ids);

	/**
	 * 根据轮播状态列出图片
	 * @param showflag
	 * @return
	 */
	@Query(value = "select * from picture where show_flag=?1 ", nativeQuery = true)
	public List<Picture> findByShowFlag(@NotNull @Valid Integer showflag);
	
	/**
	 * 更新轮播状态
	 * @param status
	 * @param ids
	 */
	@Modifying
	@Transactional
	@Query(value = "update picture set show_flag = ?1  where id in (?2)", nativeQuery = true)
	public void updateByIdIn(Integer status,Collection<String> ids);

	@Modifying
	@Transactional
	@Query(value = "update picture set path = null,delete_flag = 1  where id = ?1", nativeQuery = true)
	public void deleteBySingleid(String id);
	
	@Modifying
	@Transactional
	@Query(value = "update picture set delete_flag = 1  where album_id = ?1", nativeQuery = true)
	public void deletePictureByAlbumId(String albumid);

}
