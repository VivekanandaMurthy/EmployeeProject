package com.employee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 
 * 
 * @author Vivekananda Murthy
 * 
 *         Address Entity
 * 
 */

@Entity
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@Column(name = "addressline")
	@Pattern(regexp = "^[a-zA-Z0-9\\s,'-]*$", message = "Allows only Alphanumerics, spaces and -")
	public String addressline;

	@Column(name = "city")
	@Size(min = 2, max = 12, message = "city size must be between 2 and 12")
	@Pattern(regexp = "[a-zA-Z]+", message = "must not contain special characters and numbers")
	public String city;

	@Column(name = "state")
	@Size(min = 2, max = 12, message = "state size must be between 2 and 12")
	@Pattern(regexp = "[a-zA-Z]+", message = "must not contain special characters and numbers")
	public String state;

	@Column(name = "country")
	@Size(min = 2, max = 12, message = "country size must be between 2 and 12")
	@Pattern(regexp = "[a-zA-Z]+", message = "must not contain special characters and numbers")
	public String country;

	@Column(name = "pin_Code")
	@Size(min = 6, max = 6, message = "pinCode size must be 6")
	@Pattern(regexp = "[0-9]+", message = "must be in numbers")
	public String pinCode;

	@Column(name = "empid")
	public String empid;

	public Long getId() {
		return id;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address() {

	}

	public String getAddressline() {
		return addressline;
	}

	public void setAddressline(String addressline) {
		this.addressline = addressline;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [addressline=" + addressline + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", pinCode=" + pinCode + "]";
	}

}
