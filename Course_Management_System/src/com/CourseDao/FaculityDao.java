package com.CourseDao;

public interface FaculityDao {
	public String facultyLogin(String userName, String pwd);
	public void coursePlan();
	public void fillPlanner();
	public String updatePassword(String userName, String pwd);
}
