package com.CourseDao;

import com.Model.Admin;
import com.Model.Batch;
import com.Model.Course;
import com.Model.Faculty;

public interface AdminDao {
	public String login(Admin admin);
	public String createCourse(Course course);
	public int updateCourse(int courseID);
	public Course viewCourse(int courseId);
	public String createBatch(Batch batch);
	public int updateBatch(int BatchID);
	public Course viewBatch(int BatchId);
	public String createFaculty(Faculty faculty);
	public int updateFaculty(int FacultyID);
	public Course viewFaculty(int FacultyId);
	
	
}
