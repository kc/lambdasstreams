package com.example.streams.pubsdb.domain.model;

import java.io.Serializable;

/**
 * The primary key class for the titleauthor database table.
 * 
 */

public class TitleAuthorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	
	private String authorId;

	
	private String titleId;

	public TitleAuthorPK() {
	}
	public TitleAuthorPK(String authorId, String titleId) {
		this.authorId=authorId;
		this.titleId=titleId;
	}
	public String getAuthorId() {
		return this.authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public String getTitleId() {
		return this.titleId;
	}
	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TitleAuthorPK)) {
			return false;
		}
		TitleAuthorPK castOther = (TitleAuthorPK)other;
		return 
			this.authorId.equals(castOther.authorId)
			&& this.titleId.equals(castOther.titleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.authorId.hashCode();
		hash = hash * prime + this.titleId.hashCode();
		
		return hash;
	}
	
	//An enormous hack! See if we can save the day with this monstrum! (and loose the week.)
	public String toString() {
		return authorId + "_" + titleId;
	}
}
