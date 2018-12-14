package com.dream.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * PicturesQueryResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-20T06:48:47.165Z")

public class PicturesQueryResponse   {
  @JsonProperty("status")
  private StatusResult status = null;

  @JsonProperty("pictures")
  @Valid
	private Map<String, Picture> pictures = null;

  public PicturesQueryResponse status(StatusResult status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public StatusResult getStatus() {
    return status;
  }

  public void setStatus(StatusResult status) {
    this.status = status;
  }

	public PicturesQueryResponse pictures(Map<String, Picture> pictures) {
    this.pictures = pictures;
    return this;
  }

	public PicturesQueryResponse addPicturesItem(String pId, Picture pic) {
    if (this.pictures == null) {
			this.pictures = new HashMap<>();
    }
		this.pictures.put(pId, pic);
    return this;
  }

  /**
   * Get pictures
   * @return pictures
  **/
  @ApiModelProperty(value = "")

  @Valid

	public Map<String, Picture> getPictures() {
    return pictures;
  }

	public void setPictures(Map<String, Picture> pictures) {
    this.pictures = pictures;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PicturesQueryResponse picturesQueryResponse = (PicturesQueryResponse) o;
    return Objects.equals(this.status, picturesQueryResponse.status) &&
        Objects.equals(this.pictures, picturesQueryResponse.pictures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, pictures);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PicturesQueryResponse {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    pictures: ").append(toIndentedString(pictures)).append("\n");
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

