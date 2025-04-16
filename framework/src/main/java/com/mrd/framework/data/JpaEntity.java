package com.mrd.framework.data;

import com.mrd.framework.common.Key;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

import java.io.Serializable;
import java.util.Date;

/**
 * JpaEntity to declare fields to be in each entity table
 *
 * @author: Y Kamesh Rao
 */
@MappedSuperclass
public class JpaEntity<T extends Serializable> implements Entity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@XmlElement(type = Object.class)
	@XStreamAlias(value = Key.id)
	protected T id;

	@XStreamOmitField
	//@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	protected Date createdAt;

	@XStreamOmitField
	//@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	protected Date updatedAt;

	@Column
	protected String createdBy;

	@Column
	protected String updatedBy;

	public JpaEntity() {
		createdAt = new Date();
		updatedAt = new Date();
	}

	/**
	 * To make XStream deserialization assign values to base class fields of
	 * createdAt and updatedAt
	 *
	 * @return
	 */
	public Object readResolve() {
		if (this.createdAt == null) {
			this.createdAt = new Date();
			this.updatedAt = createdAt;
		}

		return this;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy
	 *            the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
