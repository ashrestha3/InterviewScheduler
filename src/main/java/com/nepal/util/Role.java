package com.nepal.util;

public enum Role {
	ADMINISTRATOR("Admin"),SALESREP("SalesRep"),CONSULTANT("Consultant");
	
	private final String role;
	
	Role(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
}
