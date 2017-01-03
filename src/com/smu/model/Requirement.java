package com.smu.model;



/**
 * Requirement entity. @author MyEclipse Persistence Tools
 */

public class Requirement  implements java.io.Serializable {


    // Fields    

     private Integer RId;
     private Case cas;
     private String RName;
     private String RContent;
     private String RScore;


    // Constructors

    /** default constructor */
    public Requirement() {
    }

    
    /** full constructor */
    public Requirement(Case cas, String RName, String RContent, String RScore) {
        this.cas = cas;
        this.RName = RName;
        this.RContent = RContent;
        this.RScore = RScore;
    }

   
    // Property accessors

    public Integer getRId() {
        return this.RId;
    }
    
    public void setRId(Integer RId) {
        this.RId = RId;
    }

    public Case getCas() {
        return this.cas;
    }
    
    public void setCas(Case cas) {
        this.cas = cas;
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
    
    public void setRScore(String RScore) {
        this.RScore = RScore;
    }
   








}