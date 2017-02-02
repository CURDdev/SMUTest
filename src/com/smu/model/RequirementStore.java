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
	private String RScore;
    private String errors;
	// Constructors

	/** default constructor */
	public RequirementStore() {
	}

	/** full constructor */
	public RequirementStore(CaseStore caseStore, String RName, String RContent,
			String RScore,String errors) {
		this.caseStore = caseStore;
		this.RName = RName;
		this.RContent = RContent;
		this.RScore = RScore;
		this.errors = errors;
	}

	// Property accessors

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

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

	public String getRScore() {
		return this.RScore;
	}

	public void setRScore(String RSocre) {
		this.RScore = RSocre;
	}

}