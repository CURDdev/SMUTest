package com.smu.model;

/**
 * RequirementStore entity. @author MyEclipse Persistence Tools
 */

public class RequirementStore implements java.io.Serializable {

	// Fields

	private Integer RId;
	private CaseStore caseStore;
	private String RName;
	private String RContent;
	private String RSocre;

	// Constructors

	/** default constructor */
	public RequirementStore() {
	}

	/** full constructor */
	public RequirementStore(CaseStore caseStore, String RName, String RContent,
			String RSocre) {
		this.caseStore = caseStore;
		this.RName = RName;
		this.RContent = RContent;
		this.RSocre = RSocre;
	}

	// Property accessors

	public Integer getRId() {
		return this.RId;
	}

	public void setRId(Integer RId) {
		this.RId = RId;
	}

	public CaseStore getCaseStore() {
		return this.caseStore;
	}

	public void setCaseStore(CaseStore caseStore) {
		this.caseStore = caseStore;
	}

	public String getRName() {
		return this.RName;
	}

	public void setRName(String RName) {
		this.RName = RName;
	}

	public String getRContent() {
		return this.RContent;
	}

	public void setRContent(String RContent) {
		this.RContent = RContent;
	}

	public String getRSocre() {
		return this.RSocre;
	}

	public void setRSocre(String RSocre) {
		this.RSocre = RSocre;
	}

}