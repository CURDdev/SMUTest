package com.smu.model;



/**
 * Requirement entity. @author MyEclipse Persistence Tools
 */

public class Requirement  implements java.io.Serializable {


    // Fields    

     private Integer RId;
     private Case CName;
     private String RContent;
     private String RScore;
     private String RName;


    // Constructors

    /** default constructor */
    public Requirement() {
    }

    
    /** full constructor */
    public Requirement(Case CName,String RContent, String RScore,String RName) {
    	
        this.CName = CName;
        this.RContent = RContent;
        this.RScore = RScore;
        this.RName = RName;
    }

   
    // Property accessors

    public Integer getRId() {
        return this.RId;
    }
    
    public String getRName() {
		return RName;
	}


	public void setRName(String rName) {
		RName = rName;
	}


	public void setRId(Integer RId) {
        this.RId = RId;
    }

   

    public Case getCName() {
		return CName;
	}


	public void setCName(Case CName) {
		this.CName = CName;
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
    
    public void setRScore(String RScore) {
        this.RScore = RScore;
    }
   








}