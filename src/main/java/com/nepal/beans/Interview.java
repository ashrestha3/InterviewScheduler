
package com.nepal.beans;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table
(name="interview", 
uniqueConstraints={@UniqueConstraint(columnNames={"interview_id"})})
public class Interview {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="interview_id", nullable=false, unique=true, length=11)
	private Long id;
	
	@Column(name="interview_type", length=50, nullable=true)
	private String type;
	
	@Column(name="date_time", nullable=true, length=50)
	private  Calendar dateTime;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "consultant_id")
	private Consultant consultant;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id")
	private  Client client;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendor_id")
	private  Vendor vendor;

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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the dateTime
	 */
	public Calendar getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(Calendar dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the consultant
	 */
	public Consultant getConsultant() {
		return consultant;
	}

	/**
	 * @param consultant the consultant to set
	 */
	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
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

}
