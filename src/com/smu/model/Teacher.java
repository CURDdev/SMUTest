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
     private Set scores = new HashSet(0);


    // Constructors

    /** default constructor */
    public Teacher() {
    }

	/** minimal constructor */
    public Teacher(String TId,String TName, String TPassword) {
    	this.TId = TId;
        this.TName = TName;
        this.TPassword = TPassword;
    }
    
    /** full constructor */
    public Teacher(String TId,String TName, String TPassword, Set scores) {
    	this.TId = TId;
        this.TName = TName;
        this.TPassword = TPassword;
        this.scores = scores;
    }

   
    // Property accessors

    public String getTId() {
        return this.TId;
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