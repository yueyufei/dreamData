package com.dream.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dream.api.PicAndAlbumV1Api;
import com.dream.model.Album;
import com.dream.model.AlbumQueryResponse;
import com.dream.model.Picture;
import com.dream.model.PicturesQueryResponse;
import com.dream.model.RequestAlbum;
import com.dream.model.StatusResult;
import com.dream.service.PicAndAlbumV1ApiImpl;
import com.dream.utils.Pair;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-22T01:36:12.369Z")

@Controller
public class PicAndAlbumV1ApiController implements PicAndAlbumV1Api {

	@Autowired
	PicAndAlbumV1ApiImpl apiImpl;

	public ResponseEntity<AlbumQueryResponse> v1AlbumCreatePost(
			@ApiParam(value = "相册名称") @Valid @RequestParam(value = "albumName", required = false) String albumName,
			@ApiParam(value = "相册标签列表") @Valid @RequestParam(value = "albumTags", required = false) List<String> albumTags,
			@ApiParam(value = "相册描述") @Valid @RequestParam(value = "albumDesc", required = false) String albumDesc,
			@ApiParam(value = "相册作者") @Valid @RequestParam(value = "albumAuthor", required = false) String albumAuthor,
			@ApiParam(value = "图片列表") @Valid @RequestParam(value = "picList", required = false) List<MultipartFile> picList) {
		AlbumQueryResponse result = null;
		RequestAlbum reAlbumBody = new RequestAlbum();
		reAlbumBody.setAlbumAuthor(albumAuthor);
		reAlbumBody.setAlbumDesc(albumDesc);
		reAlbumBody.setAlbumName(albumName);
		reAlbumBody.setAlbumTags(albumTags);
		Map<String, StatusResult> picresult = apiImpl.pictureUpload(picList);
		reAlbumBody.setPicList(picList);
		if (reAlbumBody != null) {
			result = apiImpl.albumCreate(reAlbumBody);
		}
		return new ResponseEntity<>(result,HttpStatus.OK);
	}

	public ResponseEntity<AlbumQueryResponse> v1AlbumIdDeletePost(
			@ApiParam(value = "相册id", required = true) @PathVariable("id") String id) {
		AlbumQueryResponse result = null;
		if (id != null && !id.isEmpty()) {
			result = new AlbumQueryResponse();
			StatusResult status = apiImpl.deleteAlbum(id);
			Album album = null;
			if (status.getStatus() == 0) {
				album = apiImpl.queryAlbumById(id);
			}
			ArrayList<Album> albums = new ArrayList<Album>();
			albums.add(album);
			result.setAlbums(albums);
			result.setStatus(status);
		} else {
			result = new AlbumQueryResponse();
			StatusResult status = new StatusResult();
			status.setStatus(1);
			status.setMessage("请求参数异常");
			result.setAlbums(new ArrayList<>());
			result.setStatus(status);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	public ResponseEntity<AlbumQueryResponse> v1AlbumIdSearchGet(
			@ApiParam(value = "相册id", required = true) @PathVariable("id") String id) {
		AlbumQueryResponse result = null;
		result = new AlbumQueryResponse();
		List<Album> albums = new ArrayList<>();
		StatusResult status = new StatusResult();
		if (id != null && !id.isEmpty()) {
			Album album = apiImpl.queryAlbumById(id);
			if (album != null) {
				albums.add(album);
				status.setStatus(0);
				status.setMessage("返回相册成功");
			} else {
				status.setStatus(1);
				status.setMessage("返回相册失败");
			}
		} else {
			status.setStatus(1);
			status.setMessage("请求参数异常");
		}
		result.setStatus(status);
		result.setAlbums(albums);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	public ResponseEntity<AlbumQueryResponse> v1AlbumSearchGet(
			@NotNull @ApiParam(value = "页数", required = true) @Valid @RequestParam(value = "page", required = true) String page) {
		AlbumQueryResponse result = null;
		try {
			Integer pageNum = Integer.parseInt(page);
			if (pageNum > 0) {
				result = apiImpl.findAlbumsByLimit(pageNum);
				return new ResponseEntity<>(result, HttpStatus.OK);
			} else {
				result = new AlbumQueryResponse();
				StatusResult status = new StatusResult();
				status.setStatus(1);
				status.setMessage("请求参数异常");

			}
		} catch (Exception e) {
			result = new AlbumQueryResponse();
			StatusResult status = new StatusResult();
			status.setStatus(1);
			status.setMessage("请求参数异常");
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	public ResponseEntity<PicturesQueryResponse> v1CarouselBatchQueryGet(
			@NotNull @ApiParam(value = "展示标记，0为轮播图展示，1为非展示", required = true) @Valid @RequestParam(value = "showflag", required = true) Integer showflag,
			@ApiParam(value = "页数") @Valid @RequestParam(value = "page", required = false) String page) {
		return null;
	}

	public ResponseEntity<PicturesQueryResponse> v1PicAlbumidSearchGet(
			@ApiParam(value = "相册id列表,支持多个,以英文逗号分隔", required = true) @PathVariable("albumid") List<String> albumid,
			@ApiParam(value = "页数") @Valid @RequestParam(value = "page", required = false) String page) {
		return null;
	}

	public ResponseEntity<PicturesQueryResponse> v1PicInsertPost(
			@ApiParam(value = "图片标题") @Valid @RequestParam(value = "title", required = false) String title,
			@ApiParam(value = "图片描述") @Valid @RequestParam(value = "desc", required = false) String desc,
			@ApiParam(value = "图片标签") @Valid @RequestParam(value = "tags", required = false) List<String> tags,
			@ApiParam(value = "所属相册") @Valid @RequestParam(value = "albumId", required = false) String albumId,
			@ApiParam(value = "图片") @Valid @RequestParam(value = "file", required = false) MultipartFile file) {
		PicturesQueryResponse result = new PicturesQueryResponse();
		StatusResult status = new StatusResult();
		String[] array =new String[tags.size()];
		tags.toArray(array);
		Pair<StatusResult, Map<String, Picture>> resultPair = apiImpl.pictureUpload(title, desc, array, albumId, file);
		if (resultPair != null) {
			status = resultPair.getKey();
			Map<String, Picture> picresult = resultPair.getValue();
			result.setPictures(picresult);
		} else {
			status.setStatus(1);
			status.setMessage("图片上传失败");
			result.setPictures(new HashMap<>());
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	public ResponseEntity<PicturesQueryResponse> v1PicSearchGet(
			@ApiParam(value = "相册id列表,支持多个,以英文逗号分隔", required = true) @PathVariable("albumid") List<String> albumid,
			@ApiParam(value = "页数") @Valid @RequestParam(value = "page", required = false) String page) {
		return null;
	}

	public ResponseEntity<PicturesQueryResponse> v1SingleIdDeletePost(
			@ApiParam(value = "", required = true) @PathVariable("id") String id) {
		return null;
	}

}
