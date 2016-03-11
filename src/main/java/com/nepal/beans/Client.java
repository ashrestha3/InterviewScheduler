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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="client", 
uniqueConstraints={@UniqueConstraint(columnNames={"client_id"})})
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_id", nullable=false, unique=true, length=11)
	private Long id;

	@Column(name="client_name", length=30, nullable=false)
	private String name;

	@Column(name="location", length=40, nullable=false)
	private String location;

	@OneToMany(mappedBy = "client")
	private Set<ConsultantClient> consultantClient = new HashSet<ConsultantClient>();
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "client")
	@Cascade({CascadeType.ALL})
	private Interview interview;

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
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
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
	public Interview getInterview() {
		return interview;
	}

	/**
	 * @param interview the interview to set
	 */
	public void setInterview(Interview interview) {
		this.interview = interview;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", location=" + location
				+ ", consultantClient=" + consultantClient + ", interview="
				+ interview + "]";
	}

	

	
	


}
