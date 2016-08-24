package com.smu.model;

import java.util.HashSet;
import java.util.Set;


/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher  implements java.io.Serializable {


    // Fields    

     private String TId;
     private String TName;
     private String TPassword;
     private String Role;
     private Set scores = new HashSet(0);


    // Constructors

    /** default constructor */
    public Teacher() {
    }

	/** minimal constructor */
    public Teacher(String TId,String TName, String TPassword,String Role) {
    	this.TId = TId;
        this.TName = TName;
        this.TPassword = TPassword;
        this.Role = Role;
    }
    
    /** full constructor */
    public Teacher(String TId,String TName, String TPassword,String Role, Set scores) {
    	this.TId = TId;
        this.TName = TName;
        this.TPassword = TPassword;
        this.Role = Role;
        this.scores = scores;
    }

   
    // Property accessors

    public String getTId() {
        return this.TId;
    }
    
    public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public void setTId(String TId) {
        this.TId = TId;
    }

    public String getTName() {
        return this.TName;
    }
    
    public void setTName(String TName) {
        this.TName = TName;
    }

    public String getTPassword() {
        return this.TPassword;
    }
    
    public void setTPassword(String TPassword) {
        this.TPassword = TPassword;
    }

    public Set getScores() {
        return this.scores;
    }
    
    public void setScores(Set scores) {
        this.scores = scores;
    }
   








}