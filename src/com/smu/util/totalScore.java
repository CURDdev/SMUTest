package com.smu.util;

import java.util.List;

/**
 * Created by yuxi on 2017/5/2.
 */
public class totalScore {
    private String studentNum;
    private String studentName;
    private String stduentClassName;
    private List<Double> allCasesScores;
    private int stationNums;
    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStduentClassName() {
        return stduentClassName;
    }

    public void setStduentClassName(String stduentClassName) {
        this.stduentClassName = stduentClassName;
    }

    public List<Double> getAllCasesScores() {
        return allCasesScores;
    }

    public void setAllCasesScores(List<Double> allCasesScores) {
        this.allCasesScores = allCasesScores;
    }

    public int getStationNums() {
        return stationNums;
    }

    public void setStationNums(int stationNums) {
        this.stationNums = stationNums;
    }
}
