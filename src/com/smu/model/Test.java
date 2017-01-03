package com.smu.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Test entity. @author MyEclipse Persistence Tools
 */

public class Test implements java.io.Serializable {

	// Fields

	private Integer testId;
	private String testName;
	private Timestamp testCreateTime;
	private Timestamp testBeginTime;
	private Timestamp testEndTime;
	private Set stations = new HashSet(0);

	// Constructors

	/** default constructor */
	public Test() {
	}

	/** minimal constructor */
	public Test(String testName, Timestamp testCreateTime,
			Timestamp testBeginTime,Timestamp testEndTime) {
		this.testName = testName;
		this.testCreateTime = testCreateTime;
		this.testBeginTime = testBeginTime;
		this.testEndTime = testEndTime;
	}

	/** full constructor */
	public Test(String testName, Timestamp testCreateTime,
			Timestamp testBeginTime, Timestamp testEndTime,Set stations) {
		this.testName = testName;
		this.testCreateTime = testCreateTime;
		this.testBeginTime = testBeginTime;
		this.testEndTime = testEndTime;
		this.stations = stations;
	}

	// Property accessors

	public Integer getTestId() {
		return this.testId;
	}

	public Timestamp getTestEndTime() {
		return testEndTime;
	}

	public void setTestEndTime(Timestamp testEndTime) {
		this.testEndTime = testEndTime;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return this.testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Timestamp getTestCreateTime() {
		return this.testCreateTime;
	}

	public void setTestCreateTime(Timestamp testCreateTime) {
		this.testCreateTime = testCreateTime;
	}

	public Timestamp getTestBeginTime() {
		return this.testBeginTime;
	}

	public void setTestBeginTime(Timestamp testBeginTime) {
		this.testBeginTime = testBeginTime;
	}

	public Set getStations() {
		return this.stations;
	}

	public void setStations(Set stations) {
		this.stations = stations;
	}

}