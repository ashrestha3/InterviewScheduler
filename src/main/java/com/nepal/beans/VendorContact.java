package com.nepal.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="vendor_contact", 
uniqueConstraints={@UniqueConstraint(columnNames={"vendor_contact_id","phone","email"})})
public class VendorContact {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vendor_contact_id", nullable=false, unique=true, length=11)
	private Long id;

	@Column(name="vendor_contact_name", length=30, nullable=false)
	private String name;

	@Column(name="email", length=50, unique=true, nullable=false)
	private String email;

	@Column(name="phone", length=20, unique=true, nullable=false)
	private String phone;

	@ManyToOne
	@JoinColumn(name = "vendor_id", insertable = false, updatable = false)
	@Cascade({CascadeType.ALL})
	private Vendor vendor;

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
	 * @return the vendor
	 */
	public Vendor getVendor() {
		return vendor;
	}

	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(Vendor vendor) {


		this.vendor = vendor;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VendorContact [id=" + id + ", name=" + name + ", email="
				+ email + ", phone=" + phone + ", vendor=" + vendor + "]";
	}


}
