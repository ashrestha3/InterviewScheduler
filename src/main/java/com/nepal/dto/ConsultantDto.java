package com.nepal.dto;

import java.util.Date;
import java.sql.Blob;
import com.nepal.beans.SalesRepresentative;


public class ConsultantDto{
	
	private Long id;
	private String name;
	private String ssn;
	private String email;
	private Date dob;
	private String phone;
	private Double yearsExp;
	private SalesRepDto salesRepDto;
	private String educationName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Double getYearsExp() {
		return yearsExp;
	}
	public void setYearsExp(Double yearsExp) {
		this.yearsExp = yearsExp;
	}

	public String getEducationName() {
		return educationName;
	}
	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}
	public SalesRepDto getSalesRepDto() {
		return salesRepDto;
	}
	public void setSalesRepDto(SalesRepDto salesRepDto) {
		this.salesRepDto = salesRepDto;
	}
	
	@Override
	public String toString() {
		return "ConsultantDto [id=" + id + ", name=" + name + ", ssn=" + ssn + ", email=" + email + ", dob=" + dob
				+ ", phone=" + phone + ", yearsExp=" + yearsExp + ", salesRepDto=" + salesRepDto + ", educationName="
				+ educationName + ", getId()=" + getId() + ", getName()=" + getName() + ", getSsn()=" + getSsn()
				+ ", getEmail()=" + getEmail() + ", getDob()=" + getDob() + ", getPhone()=" + getPhone()
				+ ", getYearsExp()=" + getYearsExp() + ", getEducationName()=" + getEducationName()
				+ ", getSalesRepDto()=" + getSalesRepDto() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}