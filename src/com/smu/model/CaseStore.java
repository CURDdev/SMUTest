package com.smu.model;

import java.util.HashSet;
import java.util.Set;

/**
 * CaseStore entity. @author MyEclipse Persistence Tools
 */

public class CaseStore implements java.io.Serializable {

	// Fields

	private Integer CId;
	private String CName;
	private String CContent;
	private Set requirementStores = new HashSet(0);

	// Constructors

	/** default constructor */
	public CaseStore() {
	}

	/** minimal constructor */
	public CaseStore(String CName, String CContent) {
		this.CName = CName;
		this.CContent = CContent;
	}

	/** full constructor */
	public CaseStore(String CName, String CContent, Set requirementStores) {
		this.CName = CName;
		this.CContent = CContent;
		this.requirementStores = requirementStores;
	}

	// Property accessors

	public Integer getCId() {
		return this.CId;
	}

	public void setCId(Integer CId) {
		this.CId = CId;
	}

	public String getCName() {
		return this.CName;
	}

	public void setCName(String CName) {
		this.CName = CName;
	}

	public String getCContent() {
		return this.CContent;
	}

	public void setCContent(String CContent) {
		this.CContent = CContent;
	}

	public Set getRequirementStores() {
		return this.requirementStores;
	}

	public void setRequirementStores(Set requirementStores) {
		this.requirementStores = requirementStores;
	}

}