package com.mrd.yourwebproject.model.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Length;

import com.mrd.framework.data.NoIDEntity;
import com.mrd.yourwebproject.model.entity.enums.AddressType;


@Entity
@Table(name = "group_address")
public class GroupAddress extends NoIDEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9099753512846501890L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "addressId", unique = true, updatable = false)
	private String addressId;

	@Column
	@Enumerated(EnumType.STRING)
	private AddressType addressType;	

	@Column 
	@Length(max = 25)
	private String poBox;
	
	@Column 
	@Length(max = 50)
    private String streetAddress;
	
	@Column 
	@Length(max = 25)
    private String suburb;
	
	@Column 
	@Length(max = 25)
    private String state;
	
	@Column 
	@Length(max = 25)
    private String country;
	
	@Column 
	@Length(max = 10)
    private String zipCode;

	@ManyToOne(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)	
	@JoinColumn(name = "groupId")
	private Groups group;
	
/*	@ManyToOne(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)	
	@JoinColumn(name = "clientId")
	private GroupClient groupClient;*/
	
	@Column
	private String clientId ;

/*	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "serialNumber")
	private GroupMember groupMember;
*/
    /**
	 * @return the addressId
	 */
	public String getAddressId() {
		return addressId;
	}


	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}


	/**
	 * @return the addressType
	 */
	public AddressType getAddressType() {
		return addressType;
	}


	/**
	 * @param addressType the addressType to set
	 */
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}


	/**
	 * @return the poBox
	 */
	public String getPoBox() {
		return poBox;
	}


	/**
	 * @param poBox the poBox to set
	 */
	public void setPoBox(String poBox) {
		this.poBox = poBox;
	}


	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}


	/**
	 * @param streetAddress the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}



	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}


	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}


	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
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
	
	/**
	 * @return the suburb
	 */
	public String getSuburb() {
		return suburb;
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


	/**
	 * @param suburb the suburb to set
	 */
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}


	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}


	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	@Override public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", suburb='" + suburb + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
