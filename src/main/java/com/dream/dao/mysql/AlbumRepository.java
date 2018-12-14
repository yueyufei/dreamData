package com.dream.dao.mysql;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.dream.model.Album;

public interface AlbumRepository extends JpaRepository<Album, String> {
	
	@Modifying
	@Transactional
	@Query(value = "update album set \"deleteFlag\" = 1 where \"albumId\"=?1 ", nativeQuery = true)
	public void deleteByAlbumId(String albumid);

	@Query(value = "select * from album where \"albumId\"=?1", nativeQuery = true)
	public Album findByAlbumId(String albumid);

	@Query(value = "select * from  album where \"albumName\" =?1", nativeQuery = true)
	public Album findAlbumByName(String albumName);

	@Query(value = "select * from  album  limit ?1 offset ?2", nativeQuery = true)
	public List<Album> findAlbumsByLimit(Integer limit, Integer offset);
	
	

}
