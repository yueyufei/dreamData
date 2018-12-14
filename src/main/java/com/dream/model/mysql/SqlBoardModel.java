package com.dream.model.mysql;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Board
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-10-26T10:10:33.924Z")
@EnableAutoConfiguration
@Entity
@Table(name = "board")
public class SqlBoardModel   {
  @JsonProperty("id")
	@Id
	@GeneratedValue(generator = "id", strategy = GenerationType.IDENTITY)
	@GenericGenerator(strategy = "assigned", name = "id")
	@Column(name = "id", nullable = true, length = 50)
  private String id = null;

	@JsonProperty("boardName")
	@Column(name = "boardName", nullable = true, length = 50)
	private String name = null;

	@JsonProperty("boardDesc")
	@Column(name = "boardDesc", nullable = true, length = 255)
	private String desc = null;

  @JsonProperty("author")
	@Column(name = "author", nullable = true, length = 50)
  private String author = null;

	@JsonProperty("createTime")
	@Column(name = "createTime", nullable = true, length = 255)
	private String createTime = null;

	@JsonProperty("updateTime")
	@Column(name = "updateTime", nullable = true, length = 255)
	private String updateTime = null;

  @JsonProperty("tags")
  @Valid
	@Column(name = "tags", length = 255)
	private String tags = null;

  @JsonProperty("deleteFlag")
	@Column(name = "deleteFlag", length = 2)
  private Integer deleteFlag = 0;

  public SqlBoardModel id(String id) {
    this.id = id;
    return this;
  }

  /**
   * 板块id
   * @return id
  **/
  @ApiModelProperty(value = "板块id")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

	public SqlBoardModel name(String name) {
		this.name = name;
    return this;
  }

  /**
   * 板块名称
   * @return title
  **/
  @ApiModelProperty(value = "板块名称")


	public String getName() {
		return name;
  }

	public void setName(String name) {
		this.name = name;
  }

	public SqlBoardModel desc(String desc) {
		this.desc = desc;
    return this;
  }

  /**
   * 板块描述
   * @return content
  **/
  @ApiModelProperty(value = "板块描述")


	public String getdesc() {
		return desc;
  }

	public void setDesc(String desc) {
		this.desc = desc;
  }

  public SqlBoardModel author(String author) {
    this.author = author;
    return this;
  }

  /**
   * 创建时间
   * @return author
  **/
  @ApiModelProperty(value = "创建时间")


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

	public SqlBoardModel createTime(String createTime) {
		this.createTime = createTime;
    return this;
  }

  /**
   * 创建人
   * @return publishTime
  **/
  @ApiModelProperty(value = "创建人")


	public String getCreateTime() {
		return createTime;
  }

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
  }

	public SqlBoardModel updateTime(String updateTime) {
		this.updateTime = updateTime;
    return this;
  }

  /**
   * 更新时间
   * @return insertTime
  **/
  @ApiModelProperty(value = "更新时间")


	public String getUpdateTime() {
		return updateTime;
  }

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
  }


	public SqlBoardModel tags(String tags) {
    this.tags = tags;
    return this;
  }


  /**
   * 板块标签
   * @return tags
  **/
  @ApiModelProperty(value = "板块标签")


	public String getTags() {
    return tags;
  }

	public void setTags(String tags) {
    this.tags = tags;
  }

  public SqlBoardModel deleteFlag(Integer deleteFlag) {
    this.deleteFlag = deleteFlag;
    return this;
  }

  /**
   * 删除标记，0未删除，1删除
   * @return deleteFlag
  **/
  @ApiModelProperty(value = "删除标记，0未删除，1删除")


  public Integer getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(Integer deleteFlag) {
    this.deleteFlag = deleteFlag;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SqlBoardModel board = (SqlBoardModel) o;
    return Objects.equals(this.id, board.id) &&
				Objects.equals(this.name, board.name) && Objects.equals(this.desc, board.desc) &&
        Objects.equals(this.author, board.author) &&
				Objects.equals(this.createTime, board.createTime) &&
				Objects.equals(this.updateTime, board.updateTime) &&
        Objects.equals(this.tags, board.tags) &&
        Objects.equals(this.deleteFlag, board.deleteFlag);
  }

  @Override
  public int hashCode() {
		return Objects.hash(id, name, desc, author, createTime, updateTime, tags, deleteFlag);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Board {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    title: ").append(toIndentedString(name)).append("\n");
		sb.append("    content: ").append(toIndentedString(desc)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
		sb.append("    publishTime: ").append(toIndentedString(createTime)).append("\n");
		sb.append("    insertTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    deleteFlag: ").append(toIndentedString(deleteFlag)).append("\n");
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

