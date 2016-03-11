package com.nepal.dto;

public class EducationDetailDto{

	private Long id;
	private String institutionName;
	private String location;
	private Long graduateYear;
	
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getGraduateYear() {
		return graduateYear;
	}
	public void setGraduateYear(Long graduateYear) {
		this.graduateYear = graduateYear;
	}
}