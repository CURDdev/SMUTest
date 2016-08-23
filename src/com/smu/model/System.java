package com.smu.model;

/**
 * System entity. @author MyEclipse Persistence Tools
 */

public class System implements java.io.Serializable {

	// Fields

	private String adminId;
	private String adminPassword;
	

	// Constructors

	/** default constructor */
	public System() {
	}

	/** minimal constructor */
	public System(String adminId) {
		this.adminId = adminId;
	}

	/** full constructor */
	public System(String adminId, String adminPassword) {
		this.adminId = adminId;
		this.adminPassword = adminPassword;
		
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	// Property accessors

	
}