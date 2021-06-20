package com.employee.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 
 * 
 * @author Vivekananda Murthy
 * 
 *         Employee Entity
 * 
 */

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long id;

	@Column(name = "first_name", nullable = false)
	@NotNull(message = "FirstName must not be null")
	@Size(min = 2, max = 12, message = "FirstName size must be between 2 and 12")
	@Pattern(regexp = "[a-zA-Z]+", message = "must not contain special characters and numbers")
	public String firstname;

	@Column(name = "empid", unique = true, nullable = false)
	@NotNull(message = "empid must not be null")
	@Size(min = 1, max = 12, message = "empid size must be between 1 and 12")
	@Pattern(regexp = "[a-zA-Z0-9]+", message = "must not contain special characters")
	public String empid;

	@Column(name = "last_name")
	@NotNull(message = "lastname must not be null")
	@Size(min = 2, max = 12, message = "lastname size must be between 2 and 12")
	@Pattern(regexp = "[a-zA-Z]+", message = "must not contain special characters and numbers")
	public String lastname;

	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "empid", referencedColumnName = "empid")
	private List<Address> address;

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
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

	public Employee() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

}
