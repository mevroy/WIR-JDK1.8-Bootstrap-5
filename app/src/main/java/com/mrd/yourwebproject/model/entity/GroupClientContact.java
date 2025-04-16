/**
 * Group Member
 */
package com.mrd.yourwebproject.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.mrd.framework.data.NoIDEntity;

/**
 * @author mevan.d.souza
 *
 */
@Entity
@Table(name = "group_client_contact")
public class GroupClientContact extends NoIDEntity implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4926584791461610424L;



	/*
	 * @GeneratedValue(generator = "uuid")
	 * 
	 * @GenericGenerator(name = "uuid", strategy = "uuid2")
	 */
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "clientContactId", unique = true, updatable = false)
	private String clientContactId;


	
	@Column
	@NotNull
	@NotBlank
	@Length(max = 25)
	private String firstName;

	@Column
	@Length(max = 25)
	private String lastName;

	@Column
	private String email;

	@Column
	private boolean primaryEmailVerified;

	@Column
	@Length(max = 15)
	private String mobilephone;

	@Column
	@Length(max = 15)
	private String fax;
	
	@Column
	@Length(max = 15)
	private String otherPhone;
	
	@Column( nullable = true)
	private String comments;
	
	
	@ManyToOne
	@LazyCollection(LazyCollectionOption.FALSE)	
	@JoinColumn(name = "groupId")
	private Groups group;
	
/*	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "groupClientId")
	private GroupClient groupClient;*/
	
	@Column
	private String clientId ;

	/**
	 * @return the clientContactId
	 */
	public String getClientContactId() {
		return clientContactId;
	}

	/**
	 * @param clientContactId the clientContactId to set
	 */
	public void setClientContactId(String clientContactId) {
		this.clientContactId = clientContactId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * @return the mobilephone
	 */
	public String getMobilephone() {
		return mobilephone;
	}

	/**
	 * @param mobilephone the mobilephone to set
	 */
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
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
	 * @return the otherPhone
	 */
	public String getOtherPhone() {
		return otherPhone;
	}

	/**
	 * @param otherPhone the otherPhone to set
	 */
	public void setOtherPhone(String otherPhone) {
		this.otherPhone = otherPhone;
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

/*	*//**
	 * @return the groupClient
	 *//*
	public GroupClient getGroupClient() {
		return groupClient;
	}

	*//**
	 * @param groupClient the groupClient to set
	 *//*
	public void setGroupClient(GroupClient groupClient) {
		this.groupClient = groupClient;
	}
	
	*/
	
}
