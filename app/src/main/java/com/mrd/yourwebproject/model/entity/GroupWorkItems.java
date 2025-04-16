/**
 * 
 */
package com.mrd.yourwebproject.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.mrd.framework.data.JpaEntity;

/**
 * @author dsouzam5
 *
 */

@Entity
@Table(name = "group_work_item")
public class GroupWorkItems extends JpaEntity<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 847783431936182339L;

	@Column
	private String testMethod;

	@Column
	private String itrDocument;

	@Column(columnDefinition = "TEXT")
	private String testStandard;

	@Column(columnDefinition = "TEXT")
	private String acceptanceCriteria;

	@Column(columnDefinition = "TEXT")
	private String itemProcedure;
	
	@Column
	private String nataClassTest;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "groupWorkInstructionRecordId")
	@JsonIgnore
	private GroupWorkInstructionRecord groupWorkInstructionRecord;
	/**
	 * @return the testMethod
	 */
	public String getTestMethod() {
		return testMethod;
	}

	/**
	 * @param testMethod the testMethod to set
	 */
	public void setTestMethod(String testMethod) {
		this.testMethod = testMethod;
	}

	/**
	 * @return the itrDocument
	 */
	public String getItrDocument() {
		return itrDocument;
	}

	/**
	 * @param itrDocument the itrDocument to set
	 */
	public void setItrDocument(String itrDocument) {
		this.itrDocument = itrDocument;
	}

	/**
	 * @return the testStandard
	 */
	public String getTestStandard() {
		return testStandard;
	}

	/**
	 * @param testStandard the testStandard to set
	 */
	public void setTestStandard(String testStandard) {
		this.testStandard = testStandard;
	}

	/**
	 * @return the acceptanceCriteria
	 */
	public String getAcceptanceCriteria() {
		return acceptanceCriteria;
	}

	/**
	 * @param acceptanceCriteria the acceptanceCriteria to set
	 */
	public void setAcceptanceCriteria(String acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}


	/**
	 * @return the itemProcedure
	 */
	public String getItemProcedure() {
		return itemProcedure;
	}

	/**
	 * @param itemProcedure the itemProcedure to set
	 */
	public void setItemProcedure(String itemProcedure) {
		this.itemProcedure = itemProcedure;
	}

	/**
	 * @return the nataClassTest
	 */
	public String getNataClassTest() {
		return nataClassTest;
	}

	/**
	 * @param nataClassTest the nataClassTest to set
	 */
	public void setNataClassTest(String nataClassTest) {
		this.nataClassTest = nataClassTest;
	}

	/**
	 * @return the groupWorkInstructionRecord
	 */
	public GroupWorkInstructionRecord getGroupWorkInstructionRecord() {
		return groupWorkInstructionRecord;
	}

	/**
	 * @param groupWorkInstructionRecord the groupWorkInstructionRecord to set
	 */
	public void setGroupWorkInstructionRecord(GroupWorkInstructionRecord groupWorkInstructionRecord) {
		this.groupWorkInstructionRecord = groupWorkInstructionRecord;
	}


	
	
}
