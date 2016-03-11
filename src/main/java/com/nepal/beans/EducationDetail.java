package com.nepal.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity
@Table(name="education_detail", 
uniqueConstraints={@UniqueConstraint(columnNames={"consultant_id"})})
public class EducationDetail {

	@GenericGenerator(name = "generator", strategy = "foreign", 
	parameters = @Parameter(name = "property", value = "consultant"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "consultant_id", unique = true, nullable = false)
	private Long id;

	@Column(name="institution_name", length=40, nullable=false)
	private String institutionName;

	@Column(name="location", length=40, nullable=false)
	private String location;

	@Column(name="graduated_year", length=4, nullable=false)
	private Long graduateYear;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private  Consultant consultant;

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
	 * @return the institutionName
	 */
	public String getInstitutionName() {
		return institutionName;
	}

	/**
	 * @param institutionName the institutionName to set
	 */
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
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
	 * @return the graduateYear
	 */
	public Long getGraduateYear() {
		return graduateYear;
	}

	/**
	 * @param graduateYear the graduateYear to set
	 */
	public void setGraduateYear(Long graduateYear) {
		this.graduateYear = graduateYear;
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

}
