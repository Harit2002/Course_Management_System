package com.Model;

import java.sql.Date;

public class Batch {
	private int BatchID;
	private int courseID;
	private int facultyID;
	private int studentCount;
	private Date batchStartDate;
	private String duration;
	
	
	public Batch() {
		super();
	}

	public Batch(int batchID, int courseID, int facultyID, int studentCount, Date batchStartDate, String duration) {
		super();
		BatchID = batchID;
		this.courseID = courseID;
		this.facultyID = facultyID;
		this.studentCount = studentCount;
		this.batchStartDate = batchStartDate;
		this.duration = duration;
	}

	public int getBatchID() {
		return BatchID;
	}

	public void setBatchID(int batchID) {
		BatchID = batchID;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public int getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(int facultyID) {
		this.facultyID = facultyID;
	}

	public int getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}

	public Date getBatchStartDate() {
		return batchStartDate;
	}

	public void setBatchStartDate(Date batchStartDate) {
		this.batchStartDate = batchStartDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
}
