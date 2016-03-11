package com.nepal.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table
(name="sales_representative", 
uniqueConstraints={@UniqueConstraint(columnNames={"sales_rep_id", "email", "phone" })})
public class SalesRepresentative {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sales_rep_id", nullable=false, unique=true, length=11)
	private Long id;
	
	@Column(name="name", length=50, nullable=true)
	private String name;
	
	@Column(name="email", length=50, nullable=true, unique=true)
	private String email;

	@Column(name="phone", length=20, nullable=true, unique=true)
	private String phone;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "salesRep" )
	private Set<Consultant> consultants = new HashSet<Consultant>();

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the consultant
	 */
	public Set<Consultant> getConsultants() {
		return consultants;
	}

	/**
	 * @param consultant the consultant to set
	 */
	public void setConsultants(Set<Consultant> consultants) {
		this.consultants = consultants;
	}

}
