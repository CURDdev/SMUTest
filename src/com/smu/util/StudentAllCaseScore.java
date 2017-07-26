package com.smu.util;

/**
 * Created by yuxi on 2017/4/20.
 */
public class StudentAllCaseScore {
    private String SNo;
    private String SName;
    private String SGrade;
    private String SClass;
    private String stationName;
    private String CaseName;
    private String TName;
    private Double score;

    public String getSNo() {
        return SNo;
    }

    public void setSNo(String SNo) {
        this.SNo = SNo;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public String getSGrade() {
        return SGrade;
    }

    public void setSGrade(String SGrade) {
        this.SGrade = SGrade;
    }

    public String getSClass() {
        return SClass;
    }

    public void setSClass(String SClass) {
        this.SClass = SClass;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getCaseName() {
        return CaseName;
    }

    public void setCaseName(String caseName) {
        CaseName = caseName;
    }

    public String getTName() {
        return TName;
    }

    public void setTName(String TName) {
        this.TName = TName;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
