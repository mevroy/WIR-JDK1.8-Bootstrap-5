/**
 * 
 */
package com.mrd.yourwebproject.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.mrd.framework.data.JpaEntity;

/**
 * @author dsouzam5
 *
 */
@Entity
@Table(name = "group_work_instruction_record")
public class GroupWorkInstructionRecord extends JpaEntity<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6008784753076695261L;

	@Column(unique = true)
	private String jobNumber;

	@Column
	private String orderNumber;

	@Column
	private String clientName;

	@Column
	private Date jobStart;

	@Column
	private Date jobEnd;
	
	@Column
	private Date travelStart;

	@Column
	private Date travelEnd;
	
	@Column
	private String quoteNumber;

	@Column
	private String material;

	@Column
	private boolean power;

	@Column
	private boolean suitableAccess;

	@Column
	private String email;
	
	@Column
	private String mobilePhone;
	
	@Column
	private boolean ewpAccessEquipment;
	
	@Column(columnDefinition = "TEXT")
	private String surfacePrepartion;
	
	@Column
	private boolean lighting;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "serialNumber")
	private GroupMember groupMember;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "groupId")
	private Groups group;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "clientId")
	private GroupClient groupClient;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "clientContactId")
	private GroupClientContact groupClientContact;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "addressId")
	private GroupAddress groupAddress;
	
	@Column(columnDefinition = "TEXT")
	private String additionalRequirements;

	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = GroupWorkItems.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "groupWorkInstructionRecordId", referencedColumnName = "id")
	private List<GroupWorkItems> groupWorkItems;
	
	/**
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * @param material
	 *            the material to set
	 */
	public void setMaterial(String material) {
		this.material = material;
	}


	/**
	 * @return the power
	 */
	public boolean isPower() {
		return power;
	}

	/**
	 * @param power
	 *            the power to set
	 */
	public void setPower(boolean power) {
		this.power = power;
	}

	/**
	 * @return the suitableAccess
	 */
	public boolean isSuitableAccess() {
		return suitableAccess;
	}

	/**
	 * @param suitableAccess
	 *            the suitableAccess to set
	 */
	public void setSuitableAccess(boolean suitableAccess) {
		this.suitableAccess = suitableAccess;
	}


	/**
	 * @return the ewpAccessEquipment
	 */
	public boolean isEwpAccessEquipment() {
		return ewpAccessEquipment;
	}

	/**
	 * @param ewpAccessEquipment the ewpAccessEquipment to set
	 */
	public void setEwpAccessEquipment(boolean ewpAccessEquipment) {
		this.ewpAccessEquipment = ewpAccessEquipment;
	}

	/**
	 * @return the additionalRequirements
	 */
	public String getAdditionalRequirements() {
		return additionalRequirements;
	}

	/**
	 * @param additionalRequirements
	 *            the additionalRequirements to set
	 */
	public void setAdditionalRequirements(String additionalRequirements) {
		this.additionalRequirements = additionalRequirements;
	}


	/**
	 * @return the jobNumber
	 */
	public String getJobNumber() {
		return jobNumber;
	}

	/**
	 * @param jobNumber
	 *            the jobNumber to set
	 */
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	/**
	 * @return the orderNumber
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber
	 *            the orderNumber to set
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}


	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the jobStart
	 */
	public Date getJobStart() {
		return jobStart;
	}

	/**
	 * @param jobStart the jobStart to set
	 */
	public void setJobStart(Date jobStart) {
		this.jobStart = jobStart;
	}

	/**
	 * @return the jobEnd
	 */
	public Date getJobEnd() {
		return jobEnd;
	}

	/**
	 * @param jobEnd the jobEnd to set
	 */
	public void setJobEnd(Date jobEnd) {
		this.jobEnd = jobEnd;
	}

	/**
	 * @return the quoteNumber
	 */
	public String getQuoteNumber() {
		return quoteNumber;
	}

	/**
	 * @param quoteNumber
	 *            the quoteNumber to set
	 */
	public void setQuoteNumber(String quoteNumber) {
		this.quoteNumber = quoteNumber;
	}

	/**
	 * @return the groupWorkItems
	 */
	public List<GroupWorkItems> getGroupWorkItems() {
		return groupWorkItems;
	}

	/**
	 * @param groupWorkItems
	 *            the groupWorkItems to set
	 */
	public void setGroupWorkItems(List<GroupWorkItems> groupWorkItems) {
		this.groupWorkItems = groupWorkItems;
	}

	/**
	 * @return the groupMember
	 */
	public GroupMember getGroupMember() {
		return groupMember;
	}

	/**
	 * @param groupMember the groupMember to set
	 */
	public void setGroupMember(GroupMember groupMember) {
		this.groupMember = groupMember;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @param mobilePhone the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * @return the travelStart
	 */
	public Date getTravelStart() {
		return travelStart;
	}

	/**
	 * @param travelStart the travelStart to set
	 */
	public void setTravelStart(Date travelStart) {
		this.travelStart = travelStart;
	}

	/**
	 * @return the travelEnd
	 */
	public Date getTravelEnd() {
		return travelEnd;
	}

	/**
	 * @param travelEnd the travelEnd to set
	 */
	public void setTravelEnd(Date travelEnd) {
		this.travelEnd = travelEnd;
	}

	/**
	 * @return the groupClient
	 */
	public GroupClient getGroupClient() {
		return groupClient;
	}

	/**
	 * @param groupClient the groupClient to set
	 */
	public void setGroupClient(GroupClient groupClient) {
		this.groupClient = groupClient;
	}

	/**
	 * @return the groupClientContact
	 */
	public GroupClientContact getGroupClientContact() {
		return groupClientContact;
	}

	/**
	 * @param groupClientContact the groupClientContact to set
	 */
	public void setGroupClientContact(GroupClientContact groupClientContact) {
		this.groupClientContact = groupClientContact;
	}

	/**
	 * @return the groupAddress
	 */
	public GroupAddress getGroupAddress() {
		return groupAddress;
	}

	/**
	 * @param groupAddress the groupAddress to set
	 */
	public void setGroupAddress(GroupAddress groupAddress) {
		this.groupAddress = groupAddress;
	}

	/**
	 * @return the surfacePrepartion
	 */
	public String getSurfacePrepartion() {
		return surfacePrepartion;
	}

	/**
	 * @param surfacePrepartion the surfacePrepartion to set
	 */
	public void setSurfacePrepartion(String surfacePrepartion) {
		this.surfacePrepartion = surfacePrepartion;
	}

	/**
	 * @return the lighting
	 */
	public boolean isLighting() {
		return lighting;
	}

	/**
	 * @param lighting the lighting to set
	 */
	public void setLighting(boolean lighting) {
		this.lighting = lighting;
	}


}
