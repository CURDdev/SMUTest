package com.smu.model;

import java.util.HashSet;
import java.util.Set;


/**
 * Case entity. @author MyEclipse Persistence Tools
 */

public class Case  implements java.io.Serializable {


    // Fields    
     private Station station;
     private String CName;
     private String CContent;
     private Set requirements = new HashSet(0);


    // Constructors

    /** default constructor */
    public Case() {
    }

	/** minimal constructor */
    public Case(Station station, String CName, String CContent,Set requirements) {
    	
        this.station = station;
        this.CName = CName;
        this.CContent = CContent;
        this.requirements = requirements;
    }
    
  
   
    // Property accessors

  

    public Station getStation() {
        return this.station;
    }
    
    public void setStation(Station station) {
        this.station = station;
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

	public Set getRequirements() {
		return requirements;
	}

	public void setRequirements(Set requirements) {
		this.requirements = requirements;
	}

 
   








}