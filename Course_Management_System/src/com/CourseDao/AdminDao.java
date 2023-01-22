package com.CourseDao;

import com.Exception.AdminException;
import com.Model.*;

public interface AdminDao {
	//<-===================== Admin Login And Signup =================->
	public String login(String userName, String pwd);
	public String signUp(String userName, String pwd);
	
	//<-=============== Courses Section ================->
	public String createCourse(Course course);
	public Course viewCourse(int courseID);
	
	//<-------------- Update Course Section ------------->
	public String updateCourseName(int courseID, String newName) throws AdminException;
	public String updateCourseFee(int courseID, String newFee) throws AdminException;
	public String updateCourseDesc(int courseID, String newDesc) throws AdminException;
	
	
	
	//<-================== Batch Section ====================->
	public String createBatch(Batch batch);
	public Batch viewBatch(int BatchID);
	
	
	//<------------ Update batch info -------------->
	public String updateBatchFaculty(int BatchID, int facultyID);
	public String updateBatchStudentCount(int BatchID, int newStudCount);
	public String updateBatchStartDate(int BatchID, String newDate);
	public String updateBatchDuration(int BatchID, String newDuration);
	
	
	
	//<-==================== Faculty section ===========================->
	public String createFaculty(Faculty faculty);
	public Faculty viewFaculty(int FacultyID);
	
	
	//<--------------- update faculty funtions ---------------->
	public String updateFacultyName(int FacultyID, String newName, String pwd);
	public String updateFacultyAddress(int FacultyID, String newAddress, String pwd);
	public String updateFacultyMobile(int FacultyID, String newNumber, String pwd);
	public String updateFacultyEmail(int FacultyID, String newMail, String pwd);
	public String updateFacultyUserName (int FacultyID, String newUser, String pwd);
	public String updateFacultyPasword(int FacultyID, String newPwd, String pwd);
	
	
	//<-============== AllocateFacultyTOBatch ===============->
	public String allocateFacultyToBatch(int BatchID, int facultyId);
	
	
	//<-================= CoursePlan Section ================->
	public String createCoursePlan(CoursePlan plan);
	public CoursePlan viewCoursePlan(int PlanID);
	
	
	//<----------- Update course Section -------------->
	public String updateCourseBatchId(int PlanID, int BatchID);
	public String updateCourseDay(int PlanID, int day);
	public String updateCourseTopic(int PlanID, int topic);
	public String updateCourseStatus(int PlanID, int status);
	
	
	
}
