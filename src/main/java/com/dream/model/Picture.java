package com.dream.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.annotation.Validated;

import com.dream.model.mysql.PicturelPrimaryKey;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.array.StringArrayType;

/**
 * Picture
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-20T06:48:47.165Z")

@TypeDefs({ @TypeDef(name = "string-array", typeClass = StringArrayType.class) })
@EnableAutoConfiguration
@Entity
@Table(name = "picture")
@IdClass(value = PicturelPrimaryKey.class)
public class Picture   {
	@JsonProperty("id")
	@Id
	@GeneratedValue(generator = "pid", strategy = GenerationType.AUTO)
	@GenericGenerator(strategy = "assigned", name = "pid")
	@Column(name = "\"pictureId\"")
  private String id = null;

	@JsonProperty("pictureTitle")
	@Column(name = "\"pictureTitle\"")
  private String title = null;

	@JsonProperty("pictureDesc")
	@Column(name = "\"pictureDesc\"")
  private String desc = null;
	@Id
  @JsonProperty("insertTime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(name = "\"insertTime\"")
	private Date insertTime = null;

	@JsonProperty("updateTime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(name = "\"updateTime\"")
	private Date updateTime = null;

	@JsonProperty("pictureTags")
  @Valid
	@Type(type = "string-array")
	@Column(name = "\"pictureTags\"", columnDefinition = "String[]")
	private String[] tags = null;

	@JsonProperty("picturePath")
	@Column(name = "\"picturePath\"")
  private String path = null;

	@JsonProperty("URL")
	@Column(name = "\"URL\"")
	private String url = null;
  @JsonProperty("docId")
	@Column(name = "\"docId\"")
  private String docId = null;

	@JsonProperty("albumId")
	@Column(name = "\"albumId\"")
  private String album = null;

  @JsonProperty("deleteFlag")
	@Column(name = "\"deleteFlag\"")
  private Integer deleteFlag = null;

  @JsonProperty("showFlag")
	@Column(name = "\"showFlag\"")
  private Integer showFlag = null;

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDesc() {
		return desc;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public String[] getTags() {
		return tags;
	}

	public String getPath() {
		return path;
	}

	public String getUrl() {
		return url;
	}

	public String getDocId() {
		return docId;
	}

	public String getAlbum() {
		return album;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public Integer getShowFlag() {
		return showFlag;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public void setShowFlag(Integer showFlag) {
		this.showFlag = showFlag;
	}


}

