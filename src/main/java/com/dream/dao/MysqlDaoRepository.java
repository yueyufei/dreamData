package com.dream.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dream.dao.mysql.AlbumRepository;
import com.dream.dao.mysql.BoardRepository;
import com.dream.dao.mysql.PictureRepository;
import com.dream.model.Album;
import com.dream.model.Picture;

@Component
public class MysqlDaoRepository {

	@Autowired
	AlbumRepository albumRepository;

	@Autowired
	PictureRepository pictureRepository;

	@Autowired
	BoardRepository boardRepository;

	public Album findAlbumbyName(String albumName) {
		try {
			Album album = albumRepository.findAlbumByName(albumName);
			return album;
		} catch (Exception e) {
			return null;
		}

	}

	public Album createAlbum(Album album) {
		try {
			albumRepository.save(album);
			Integer id = album.getAlbumId();
			Album result = albumRepository.findByAlbumId(id + "");
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	public Boolean deleteAlbumById(String id) {
		try {
			albumRepository.deleteByAlbumId(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Boolean deletepictureByAlbumId(String id) {
		try {
			pictureRepository.deletePictureByAlbumId(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Album finAlbumById(String id) {
		try {
			return albumRepository.findByAlbumId(id);
		} catch (Exception e) {
			return null;
		}
	}

	public List<Album> findAlbumsByLimit(Integer pageNum) {
		try {
			Integer limit = 16;
			Integer offset = (pageNum - 1) * limit;
			return albumRepository.findAlbumsByLimit(limit, offset);
		} catch (Exception e) {
			return null;
		}
	}

	public Boolean savaPicture(Picture picModel) {
		try {
			pictureRepository.save(picModel);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
