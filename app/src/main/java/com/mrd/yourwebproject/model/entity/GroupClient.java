/**
 * Group Member
 */
package com.mrd.yourwebproject.model.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;







import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;







import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTimeUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.mrd.framework.data.NoIDEntity;
import com.mrd.yourwebproject.model.entity.embedded.Address;

/**
 * @author mevan.d.souza
 *
 */
@Entity
@Table(name = "group_clients")
public class GroupClient extends NoIDEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4914777399296610047L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "clientId", unique = true, updatable = false)
	private String clientId;


	@Column
	@Length(max = 25)
	private String clientABN;

	@Column
	@NotNull
	@NotBlank
	@Length(max = 50)
	private String clientName;
	
	@Column
	@Email
	private String email;

	@Column
	private boolean primaryEmailVerified;

	@Column
	@Length(max = 13)
	private String phone;

	@Column
	@Length(max = 20)
	private String fax;


	@OneToMany(cascade = CascadeType.ALL, targetEntity = GroupAddress.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "clientId")
	private List<GroupAddress> groupAddress;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = GroupClientContact.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "clientId")
	private List<GroupClientContact> groupClientContact;
	
	
	@Column( nullable = true)
	private String comments;
		
	@ManyToOne(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "groupId")
	private Groups group;

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the clientABN
	 */
	public String getClientABN() {
		return clientABN;
	}

	/**
	 * @param clientABN the clientABN to set
	 */
	public void setClientABN(String clientABN) {
		this.clientABN = clientABN;
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
	 * @return the primaryEmailVerified
	 */
	public boolean isPrimaryEmailVerified() {
		return primaryEmailVerified;
	}

	/**
	 * @param primaryEmailVerified the primaryEmailVerified to set
	 */
	public void setPrimaryEmailVerified(boolean primaryEmailVerified) {
		this.primaryEmailVerified = primaryEmailVerified;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return the groupAddress
	 */
	public List<GroupAddress> getGroupAddress() {
		return groupAddress;
	}

	/**
	 * @param groupAddress the groupAddress to set
	 */
	public void setGroupAddress(List<GroupAddress> groupAddress) {
		this.groupAddress = groupAddress;
	}

	/**
	 * @return the groupClientContact
	 */
	public List<GroupClientContact> getGroupClientContact() {
		return groupClientContact;
	}

	/**
	 * @param groupClientContact the groupClientContact to set
	 */
	public void setGroupClientContact(List<GroupClientContact> groupClientContact) {
		this.groupClientContact = groupClientContact;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
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

	
	


}
