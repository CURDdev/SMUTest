package com.smu.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Class entity. @author MyEclipse Persistence Tools
 */

public class Class implements java.io.Serializable {

	// Fields

	
	private String className;
	private Set students = new HashSet(0);

	// Constructors

	/** default constructor */
	public Class() {
	}

	/** full constructor */
	public Class(String className, Set students) {
		this.className = className;
		this.students = students;
	}

	// Property accessors

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

}