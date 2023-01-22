package com.CourseDao;

public interface FaculityDao {
	public String facultyLogin(String userName, String pwd);
	public void coursePlan(int CourseID);
	public void fillPlanner(int planID);
	public String updatePassword(String userName, String pwd);
}
