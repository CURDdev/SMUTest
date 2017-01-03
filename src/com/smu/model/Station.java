package com.smu.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Station entity. @author MyEclipse Persistence Tools
 */

public class Station implements java.io.Serializable {

	// Fields

	private Integer stId;
	private Test test;
	private Integer stNumber;
	private String stName;
	private Set cases = new HashSet(0);
	private Set scores = new HashSet(0);

	// Constructors

	/** default constructor */
	public Station() {
	}

	/** minimal constructor */
	public Station(Test test, Integer stNumber, String stName) {
		this.test = test;
		this.stNumber = stNumber;
		this.stName = stName;
	}

	/** full constructor */
	public Station(Test test, Integer stNumber, String stName, Set cases,
			Set scores) {
		this.test = test;
		this.stNumber = stNumber;
		this.stName = stName;
		this.cases = cases;
		this.scores = scores;
	}

	// Property accessors

	public Integer getStId() {
		return this.stId;
	}

	public void setStId(Integer stId) {
		this.stId = stId;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Integer getStNumber() {
		return this.stNumber;
	}

	public void setStNumber(Integer stNumber) {
		this.stNumber = stNumber;
	}

	public String getStName() {
		return this.stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public Set getCases() {
		return this.cases;
	}

	public void setCases(Set cases) {
		this.cases = cases;
	}

	public Set getScores() {
		return this.scores;
	}

	public void setScores(Set scores) {
		this.scores = scores;
	}

}