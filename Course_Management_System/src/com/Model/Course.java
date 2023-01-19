package com.Model;

public class Course {
	private int courseid;
	private String coursename;
	private String fee;
	private String courseDesc;
	
	public Course() {
		super();
	}
	
	public Course(int courseid, String coursename, String fee, String courseDesc) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.fee = fee;
		this.courseDesc = courseDesc;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	
}
