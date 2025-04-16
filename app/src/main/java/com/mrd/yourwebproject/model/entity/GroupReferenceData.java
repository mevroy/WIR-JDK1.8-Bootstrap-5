/**
 * 
 */
package com.mrd.yourwebproject.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.mrd.framework.data.JpaEntity;

/**
 * @author dsouzam5
 *
 */
@Entity
@Table(name = "group_reference_data")
public class GroupReferenceData extends JpaEntity<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 760160412186159557L;

	@Column(unique = true)
	@NotNull
	private String referenceDataType;
	
	@Column
	@NotNull
	private String referenceDataValue;
	
	@Column
	private String prefix;
	
	@Column
	private String suffix;
	
	@Column
	private int size;
	
	@Column
	private String paddingCharacter;
	
	@Transient
	private String referenceDataString;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "groupId")
	private Groups group;

	/**
	 * @return the referenceDataType
	 */
	public String getReferenceDataType() {
		return referenceDataType;
	}

	/**
	 * @param referenceDataType the referenceDataType to set
	 */
	public void setReferenceDataType(String referenceDataType) {
		this.referenceDataType = referenceDataType;
	}

	/**
	 * @return the referenceDataValue
	 */
	public String getReferenceDataValue() {
		return referenceDataValue;
	}

	/**
	 * @param referenceDataValue the referenceDataValue to set
	 */
	public void setReferenceDataValue(String referenceDataValue) {
		this.referenceDataValue = referenceDataValue;
	}

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * @param suffix the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	/**
	 * @return the group
	 */
	public Groups getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(Groups group) {
		this.group = group;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the paddingCharacter
	 */
	public String getPaddingCharacter() {
		return paddingCharacter;
	}

	/**
	 * @param paddingCharacter the paddingCharacter to set
	 */
	public void setPaddingCharacter(String paddingCharacter) {
		this.paddingCharacter = paddingCharacter;
	}

	/**
	 * @return the referenceDataString
	 */
	public String getReferenceDataString() {
		return StringUtils.trimToEmpty(prefix)+referenceDataValue+StringUtils.trimToEmpty(suffix);
	}
	
	
}
