package com.dream.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;

/**
 * Album
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-20T05:59:46.542Z")
@TypeDefs({ @TypeDef(name = "string-array", typeClass = StringArrayType.class),
		@TypeDef(name = "int-array", typeClass = IntArrayType.class) })
@EnableAutoConfiguration
@Entity
@Table(name = "album")
public class Album   {
	@JsonProperty("albumId")
	@Id
	@GeneratedValue(generator = "aid", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "aid", sequenceName = "\"albumSeq\"", allocationSize = 1)
	@Column(name = "\"albumId\"")
	private Integer albumId = null;

  @JsonProperty("albumName")
	@Column(name = "\"albumName\"")
  private String albumName = null;

  @JsonProperty("albumTags")
  @Valid
	@Type(type = "string-array")
	@Column(name = "\"albumTags\"", columnDefinition = "String[]")
	private String[] albumTags = null;

  @JsonProperty("insertTime")
	@Column(name = "\"insertTime\"")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date insertTime = null;

	@JsonProperty("updateTime")
	@Column(name = "\"updateTime\"")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime = null;

  @JsonProperty("albumDesc")
	@Column(name = "\"albumDesc\"")
  private String albumDesc = null;

  @JsonProperty("albumAuthor")
	@Column(name = "\"albumAuthor\"")
  private String albumAuthor = null;

  @JsonProperty("picList")
  @Valid
	@Type(type = "string-array")
	@Column(name = "\"picList\"", columnDefinition = "String[]")

	private String[] picList = null;

  @JsonProperty("deleteFlag")
	@Column(name = "\"deleteFlag\"")
  private Integer deleteFlag = null;

	public Integer getAlbumId() {
		return albumId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public String[] getAlbumTags() {
		return albumTags;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public String getAlbumDesc() {
		return albumDesc;
	}

	public String getAlbumAuthor() {
		return albumAuthor;
	}

	public String[] getPicList() {
		return picList;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public void setAlbumTags(String[] albumTags) {
		this.albumTags = albumTags;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public void setAlbumDesc(String albumDesc) {
		this.albumDesc = albumDesc;
	}

	public void setAlbumAuthor(String albumAuthor) {
		this.albumAuthor = albumAuthor;
	}

	public void setPicList(String[] picList) {
		this.picList = picList;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}

