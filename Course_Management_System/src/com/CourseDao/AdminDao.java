package com.CourseDao;

import com.Model.Batch;
import com.Model.Course;
import com.Model.CoursePlan;
import com.Model.Faculty;

public interface AdminDao {
	public String login(String userName, String pwd);
	public String signUp(String userName, String pwd);
	public String createCourse(Course course);
	public int updateCourse(int courseID);
	public Course viewCourse(int courseID);
	public String createBatch(Batch batch);
	public int updateBatch(int BatchID);
	public Course viewBatch(int BatchID);
	public String createFaculty(Faculty faculty);
	public int updateFaculty(int FacultyID);
	public Course viewFaculty(int FacultyID);
	public String allocateFacultyToBatch();
	public String createCoursePlan(CoursePlan plan);
	public int updateCoursePlan(int PlanID);
	public Course viewCoursePlan(int PlanID);
	
	
}
