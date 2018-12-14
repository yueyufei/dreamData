package com.dream.model.mysql;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PicturelPrimaryKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6016976081171020471L;
	private String id = null;
	private String insertTime = null;
	public PicturelPrimaryKey() {
	}
	public PicturelPrimaryKey(String id, String insertTime) {
		this.id = id;
		this.insertTime = insertTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((insertTime == null) ? 0 : insertTime.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PicturelPrimaryKey other = (PicturelPrimaryKey) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (insertTime == null) {
			if (other.insertTime != null)
				return false;
		} else if (!insertTime.equals(other.insertTime))
			return false;
		return true;
	}
	

}
