package com.nepal.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="consultant_client", 
uniqueConstraints={@UniqueConstraint(columnNames={"consultant_client_id"})})
public class ConsultantClient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="consultant_client_id", nullable=false, unique=true, length=11)
	private Long id;

	@Column(name="start_date", length=12, nullable=false)
	private Date startDate;

	@Column(name="end_date", length=12, nullable=false)
	private Date endDate;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "consultant_id")
	private Consultant consultant;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private Client client;

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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

}
