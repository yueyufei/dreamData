package com.dream.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AlbumQueryResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-20T05:59:46.542Z")

public class AlbumQueryResponse   {
  @JsonProperty("status")
  private StatusResult status = null;

  @JsonProperty("Albums")
  @Valid
  private List<Album> albums = null;

  public AlbumQueryResponse status(StatusResult status) {
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

  public AlbumQueryResponse albums(List<Album> albums) {
    this.albums = albums;
    return this;
  }

  public AlbumQueryResponse addAlbumsItem(Album albumsItem) {
    if (this.albums == null) {
      this.albums = new ArrayList<Album>();
    }
    this.albums.add(albumsItem);
    return this;
  }

  /**
   * Get albums
   * @return albums
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Album> getAlbums() {
    return albums;
  }

  public void setAlbums(List<Album> albums) {
    this.albums = albums;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlbumQueryResponse albumQueryResponse = (AlbumQueryResponse) o;
    return Objects.equals(this.status, albumQueryResponse.status) &&
        Objects.equals(this.albums, albumQueryResponse.albums);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, albums);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlbumQueryResponse {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    albums: ").append(toIndentedString(albums)).append("\n");
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

