package com.dream.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * RequestAlbum
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-20T05:59:46.542Z")

public class RequestAlbum   {
  @JsonProperty("albumName")
  private String albumName = null;

  @JsonProperty("albumTags")
  @Valid
  private List<String> albumTags = null;

  @JsonProperty("albumDesc")
  private String albumDesc = null;

  @JsonProperty("albumAuthor")
  private String albumAuthor = null;

	@JsonProperty("picList")
	@Valid
	private List<MultipartFile> picList = null;

  public RequestAlbum albumName(String albumName) {
    this.albumName = albumName;
    return this;
  }

  /**
   * 相册名称
   * @return albumName
  **/
  @ApiModelProperty(value = "相册名称")


  public String getAlbumName() {
    return albumName;
  }

  public void setAlbumName(String albumName) {
    this.albumName = albumName;
  }

  public RequestAlbum albumTags(List<String> albumTags) {
    this.albumTags = albumTags;
    return this;
  }

  public RequestAlbum addAlbumTagsItem(String albumTagsItem) {
    if (this.albumTags == null) {
      this.albumTags = new ArrayList<String>();
    }
    this.albumTags.add(albumTagsItem);
    return this;
  }

  /**
   * 相册标签列表
   * @return albumTags
  **/
  @ApiModelProperty(value = "相册标签列表")


  public List<String> getAlbumTags() {
    return albumTags;
  }

  public void setAlbumTags(List<String> albumTags) {
    this.albumTags = albumTags;
  }

  public RequestAlbum albumDesc(String albumDesc) {
    this.albumDesc = albumDesc;
    return this;
  }

  /**
   * 相册描述
   * @return albumDesc
  **/
  @ApiModelProperty(value = "相册描述")


  public String getAlbumDesc() {
    return albumDesc;
  }

  public void setAlbumDesc(String albumDesc) {
    this.albumDesc = albumDesc;
  }

  public RequestAlbum albumAuthor(String albumAuthor) {
    this.albumAuthor = albumAuthor;
    return this;
  }

  /**
   * 相册作者
   * @return albumAuthor
  **/
  @ApiModelProperty(value = "相册作者")


  public String getAlbumAuthor() {
    return albumAuthor;
  }

  public void setAlbumAuthor(String albumAuthor) {
    this.albumAuthor = albumAuthor;
  }

	public RequestAlbum picList(List<MultipartFile> picList) {
		this.picList = picList;
		return this;
	}

	public RequestAlbum addPicListItem(MultipartFile picListItem) {
		if (this.picList == null) {
			this.picList = new ArrayList<MultipartFile>();
		}
		this.picList.add(picListItem);
		return this;
	}

  /**
   * 图片列表
   * @return picList
  **/
	@ApiModelProperty(value = "图片列表")

	public List<MultipartFile> getPicList() {
		return picList;
	}

	public void setPicList(List<MultipartFile> picList) {
		this.picList = picList;
	}


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestAlbum requestAlbum = (RequestAlbum) o;
    return Objects.equals(this.albumName, requestAlbum.albumName) &&
        Objects.equals(this.albumTags, requestAlbum.albumTags) &&
        Objects.equals(this.albumDesc, requestAlbum.albumDesc) &&
        Objects.equals(this.albumAuthor, requestAlbum.albumAuthor) &&
        Objects.equals(this.picList, requestAlbum.picList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(albumName, albumTags, albumDesc, albumAuthor, picList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestAlbum {\n");
    
    sb.append("    albumName: ").append(toIndentedString(albumName)).append("\n");
    sb.append("    albumTags: ").append(toIndentedString(albumTags)).append("\n");
    sb.append("    albumDesc: ").append(toIndentedString(albumDesc)).append("\n");
    sb.append("    albumAuthor: ").append(toIndentedString(albumAuthor)).append("\n");
    sb.append("    picList: ").append(toIndentedString(picList)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

