package com.dream.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * StatusResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-20T05:59:46.542Z")

public class StatusResult   {
  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("message")
  private String message = null;

  public StatusResult status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * 状态码，0表示success，1表示出现问题
   * @return status
  **/
  @ApiModelProperty(required = true, value = "状态码，0表示success，1表示出现问题")
  @NotNull


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public StatusResult message(String message) {
    this.message = message;
    return this;
  }

  /**
   * 状态描述
   * @return message
  **/
  @ApiModelProperty(required = true, value = "状态描述")
  @NotNull


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatusResult statusResult = (StatusResult) o;
    return Objects.equals(this.status, statusResult.status) &&
        Objects.equals(this.message, statusResult.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatusResult {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

