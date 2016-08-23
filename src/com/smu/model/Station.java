package com.smu.model;

import java.util.HashSet;
import java.util.Set;


/**
 * Station entity. @author MyEclipse Persistence Tools
 */

public class Station  implements java.io.Serializable {


    // Fields    

     private String stId;
     private Integer stNumber;
     private String stName;
     private Integer stType;
  
     private Set scores = new HashSet(0);
     private Set cases = new HashSet(0);


    // Constructors

    /** default constructor */
    public Station() {
    }

	/** minimal constructor */
    public Station(String stId,Integer stNumber, String stName, Integer stType) {
    	this.stId = stId;
        this.stNumber = stNumber;
        this.stName = stName;
        this.stType = stType;
    }
    
    /** full constructor */
    public Station(String stId,Integer stNumber, String stName, Integer stType, Set scores, Set cases) {
    	this.stId = stId;
        this.stNumber = stNumber;
        this.stName = stName;
        this.stType = stType;
       
        this.scores = scores;
        this.cases = cases;
    }

   
    // Property accessors

    public String getStId() {
        return this.stId;
    }
    
    public void setStId(String stId) {
        this.stId = stId;
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

    public Integer getStType() {
        return this.stType;
    }
    
    public void setStType(Integer stType) {
        this.stType = stType;
    }

   

    public Set getScores() {
        return this.scores;
    }
    
    public void setScores(Set scores) {
        this.scores = scores;
    }

    public Set getCases() {
        return this.cases;
    }
    
    public void setCases(Set cases) {
        this.cases = cases;
    }
   








}