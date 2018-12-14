package com.dream.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dream.dao.MysqlDaoRepository;
import com.dream.model.Album;
import com.dream.model.AlbumQueryResponse;
import com.dream.model.Picture;
import com.dream.model.RequestAlbum;
import com.dream.model.StatusResult;
import com.dream.utils.FileUtil;
import com.dream.utils.Pair;

@Service
public class PicAndAlbumV1ApiImpl {

	@Value("${dream.pics.path}")
	private String picsRootPath;

	@Value("${dream.pics.url}")
	private String picsRootURL;

	@Autowired
	MysqlDaoRepository mysqlDaoRepository;

	public AlbumQueryResponse albumCreate(@Valid RequestAlbum reAlbumBody) {
		AlbumQueryResponse result = new AlbumQueryResponse();
		StatusResult status = new StatusResult();
		List<Album> albums = new ArrayList<>();
		String albumAuthor = reAlbumBody.getAlbumAuthor();
		String albumDesc = reAlbumBody.getAlbumDesc();
		String albumName = reAlbumBody.getAlbumName();
		List<String> albumTags = reAlbumBody.getAlbumTags();
		List<MultipartFile> pics = reAlbumBody.getPicList();
		Album resultAlbum = mysqlDaoRepository.findAlbumbyName(albumName);
		if (albumName != null && !albumName.isEmpty()) {
			if (resultAlbum == null) {
				Album album = new Album();
				album.setAlbumAuthor(albumAuthor);
				album.setAlbumDesc(albumDesc);
				album.setAlbumName(albumName);
				String[] tags = new String[] {};
				tags = albumTags.toArray(tags);
				album.setAlbumTags(tags);
				album.setDeleteFlag(0);
				List<String> picList = new ArrayList<>();
				for (MultipartFile multipartFile : pics) {
					picList.add(multipartFile.getOriginalFilename());
				}
				String[] pis = new String[] {};
				pis = picList.toArray(pis);
				album.setPicList(pis);
				// album.setInsertTime(new Date(System.currentTimeMillis()));
				// TODO
				// 多个图片插入返回图片的url地址

				Album createAlbum = mysqlDaoRepository.createAlbum(album);
				if (createAlbum != null) {
					status.setStatus(0);
					albums.add(createAlbum);
					status.setMessage("相册创建成功");
					result.setStatus(status);
					result.setAlbums(albums);
				} else {
					status.setStatus(1);
					status.setMessage("相册创建失败");
					result.setStatus(status);
					result.setAlbums(albums);
				}
			} else {
				status.setStatus(1);
				status.setMessage("相册名已经存在");
				albums.add(resultAlbum);
				result.setStatus(status);
				result.setAlbums(albums);
			}
		} else {
			status.setStatus(1);
			status.setMessage("相册名为空");
			albums.add(resultAlbum);
			result.setStatus(status);
			result.setAlbums(albums);
		}
		return result;
	}

	public StatusResult deleteAlbum(String id) {
		StatusResult status = new StatusResult();
		// Boolean picResult = mysqlDaoRepository.deletepictureByAlbumId(id);
		Boolean albumResult = mysqlDaoRepository.deleteAlbumById(id);
		if (albumResult) {
			// if (picResult && albumResult) {
			status.setStatus(0);
			status.setMessage("相册删除成功");
		} else {
			status.setStatus(1);
			status.setMessage("相册删除失败");
		}
		return status;
	}

	public Album queryAlbumById(String id) {
		return mysqlDaoRepository.finAlbumById(id);

	}

	public AlbumQueryResponse findAlbumsByLimit(Integer pageNum) {
		AlbumQueryResponse result = new AlbumQueryResponse();
		StatusResult status = new StatusResult();
		List<Album> albums = mysqlDaoRepository.findAlbumsByLimit(pageNum);
		if (albums != null) {
			status.setStatus(0);
			status.setMessage("返回数据成功");
			result.setAlbums(albums);
		} else {
			status.setStatus(1);
			status.setMessage("返回数据失败");
			result.setAlbums(new ArrayList<>());
		}
		result.setStatus(status);
		return result;
	}

	public Map<String, StatusResult> pictureUpload(@Valid List<MultipartFile> picList) {
		Map<String, StatusResult> resultMap = new HashMap<>();
		for (MultipartFile file : picList) {
			String oPicName = file.getOriginalFilename();
			String pathFileName = FileUtil.getFileName(oPicName);
			String picPath = picsRootPath + "/" + pathFileName;
		}

		return null;
	}

	public Pair<StatusResult, Map<String, Picture>> pictureUpload(@Valid String title, @Valid String desc,
			@Valid String[] tags,
			@Valid String albumId, @Valid MultipartFile file) {
		Map<String, Picture> picMap = new HashMap<>();
		StatusResult status = new StatusResult();
		Picture picModel = new Picture();
		String oPicName = file.getOriginalFilename();
		String pathFileName = FileUtil.getFileName(oPicName);
		String picPath = picsRootPath + "/" + pathFileName;
		String picUrl = picsRootURL + "/" + pathFileName;
		picModel.setAlbum(albumId);
		picModel.setDeleteFlag(0);
		picModel.setDesc(desc);
		picModel.setDocId("");
		picModel.setId("");
		long time = System.currentTimeMillis();
		picModel.setInsertTime(new Date(time));
		picModel.setPath(picPath);
		picModel.setShowFlag(1);
		picModel.setTags(tags);
		picModel.setTitle(title);
		picModel.setUpdateTime(new Date(time));
		picModel.setUrl(picUrl);
		Boolean isSave = mysqlDaoRepository.savaPicture(picModel);
		if (isSave) {
			boolean isUpload = FileUtil.upload(file, picsRootPath, pathFileName);
			if (isUpload) {
				status.setMessage("图片上传成功");
				status.setStatus(0);
			} else {
				status.setMessage("图片上传失败");
				status.setStatus(1);
			}
		} else {
			status.setMessage("图片上传失败");
			status.setStatus(1);
		}
		picMap.put(picUrl, picModel);
		return new Pair<StatusResult, Map<String, Picture>>(status, picMap);
	}

}
