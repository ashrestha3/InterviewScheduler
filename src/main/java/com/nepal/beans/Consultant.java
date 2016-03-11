package com.nepal.beans;

import java.sql.Blob;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

@Entity
@Table(name="consultant", 
uniqueConstraints={@UniqueConstraint(columnNames={"consultant_id", "ssn","phone", "email"})})
public class Consultant {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="consultant_id", nullable=false, unique=true)
	private Long id;

	@Column(name="consultant_name", length=30, nullable=false)
	private String name;

	@Column(name="ssn", length=12, nullable=true, unique=true)
	private String ssn;

	@Column(name="dob", length=10, nullable=true)
	@Type(type="date")
	private Date dob;

	@Column(name="email", length=50, nullable=true, unique=true)
	private String email;

	@Column(name="phone", length=20, nullable=true, unique=true)
	private String phone;

	@Column(name="yrs_exp", length=10, nullable=true)
	private Double yrsExp;
	
	@Column(name="resume_Docu", nullable = true)
	private Blob resumeDocu;

	@OneToMany(mappedBy = "consultant", fetch = FetchType.LAZY)
	private Set<ConsultantClient> consultantClient = new HashSet<ConsultantClient>();
	
	@OneToMany(mappedBy = "consultant", fetch = FetchType.LAZY)
	private Set<Interview> interview = new HashSet<Interview>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sales_rep_id")
	@Cascade({CascadeType.ALL})
	private SalesRepresentative salesRep;

	@OneToOne(mappedBy = "consultant", fetch = FetchType.LAZY)
	@Cascade({CascadeType.ALL})
	private EducationDetail educationDetail;
	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="consultant_vendor", 
			joinColumns={@JoinColumn(name="consultant_id")}, 
			inverseJoinColumns={@JoinColumn(name="vendor_id")}
			)
	@Cascade({CascadeType.ALL})
	private Set<Vendor> vendors = new HashSet<Vendor>();


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
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}


	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}


	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}


	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
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
	 * @return the yrsExp
	 */
	public Double getYrsExp() {
		return yrsExp;
	}


	/**
	 * @param yrsExp the yrsExp to set
	 */
	public void setYrsExp(Double yrsExp) {
		this.yrsExp = yrsExp;
	}


	public Blob getResumeDocu() {
		return resumeDocu;
	}


	public void setResumeDocu(Blob resumeDocu) {
		this.resumeDocu = resumeDocu;
	}


	/**
	 * @return the consultantClient
	 */
	public Set<ConsultantClient> getConsultantClient() {
		return consultantClient;
	}
	/**
	 * @param consultantClient the consultantClient to set
	 */
	public void setConsultantClient(Set<ConsultantClient> consultantClient) {
		this.consultantClient = consultantClient;
	}
	/**
	 * @return the interview
	 */
	public Set<Interview> getInterview() {
		return interview;
	}
	/**
	 * @param interview the interview to set
	 */
	public void setInterview(Set<Interview> interview) {
		this.interview = interview;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * @return the salesRep
	 */
	public SalesRepresentative getSalesRep() {
		return salesRep;
	}
	/**
	 * @param salesRep the salesRep to set
	 */
	public void setSalesRep(SalesRepresentative salesRep) {
		this.salesRep = salesRep;
	}
	/**
	 * @return the educationDetail
	 */
	public EducationDetail getEducationDetail() {
		return educationDetail;
	}
	/**
	 * @param educationDetail the educationDetail to set
	 */
	public void setEducationDetail(EducationDetail educationDetail) {
		this.educationDetail = educationDetail;
	}
	/**
	 * @return the vendors
	 */
	public Set<Vendor> getVendors() {
		return vendors;
	}
	/**
	 * @param vendors the vendors to set
	 */
	public void setVendors(Set<Vendor> vendors) {
		this.vendors = vendors;
	}
	@Override
	public String toString() {
		return "Consultant [id=" + id + ", name=" + name + ", ssn=" + ssn
				+ ", dob=" + dob + ", email=" + email + ", phone=" + phone
				+ ", yrsExp=" + yrsExp + "]";
	}

}
