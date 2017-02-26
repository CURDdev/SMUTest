package com.smu.model;

/**
 * Score entity. @author MyEclipse Persistence Tools
 */

public class Score implements java.io.Serializable {

	// Fields

	private Integer scId;
	private Teacher teacher;
	private Station station;
	private Student student;
	private String scScore;
	private Double scTotalScore;
    private int TId;
    private String errors;
    private String status;
    private int CId;
	// Constructors

	/** default constructor */
	public Score() {
	}

	/** full constructor */
	public Score(Teacher teacher, Station station, Student student,
			String scScore, Double scTotalScore,int TId,String errors,String status,int CId) {
		this.teacher = teacher;
		this.station = station;
		this.student = student;
		this.scScore = scScore;
		this.scTotalScore = scTotalScore;
		this.TId = TId;
		this.errors = errors;
		this.status = status;
		this.CId = CId;
	}

	// Property accessors


	public int getCId() {
		return CId;
	}

	public void setCId(int CId) {
		this.CId = CId;
	}

	public int getTId() {
		return TId;
	}

	public void setTId(int TId) {
		this.TId = TId;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getScId() {
		return this.scId;
	}

	public void setScId(Integer scId) {
		this.scId = scId;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Station getStation() {
		return this.station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getScScore() {
		return this.scScore;
	}

	public void setScScore(String scScore) {
		this.scScore = scScore;
	}

	public Double getScTotalScore() {
		return this.scTotalScore;
	}

	public void setScTotalScore(Double scTotalScore) {
		this.scTotalScore = scTotalScore;
	}

}