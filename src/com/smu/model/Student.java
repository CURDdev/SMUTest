package com.smu.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private String SNo;
	private Class mclass;
	private String SName;
	private String SGrade;
	private Set scores = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(Class mclass, String SName, String SGrade) {
		this.mclass = mclass;
		this.SName = SName;
		this.SGrade = SGrade;
	}

	/** full constructor */
	public Student(Class mclass, String SName, String SGrade, Set scores) {
		this.mclass = mclass;
		this.SName = SName;
		this.SGrade = SGrade;
		this.scores = scores;
	}

	// Property accessors

	public String getSNo() {
		return this.SNo;
	}

	public void setSNo(String SNo) {
		this.SNo = SNo;
	}

	public Class getMclass() {
		return this.mclass;
	}

	public void setMclass(Class mclass) {
		this.mclass = mclass;
	}

	public String getSName() {
		return this.SName;
	}

	public void setSName(String SName) {
		this.SName = SName;
	}

	public String getSGrade() {
		return this.SGrade;
	}

	public void setSGrade(String SGrade) {
		this.SGrade = SGrade;
	}

	public Set getScores() {
		return this.scores;
	}

	public void setScores(Set scores) {
		this.scores = scores;
	}

}