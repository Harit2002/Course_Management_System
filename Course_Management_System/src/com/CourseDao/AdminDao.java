package com.CourseDao;

import com.Exception.AdminException;
import com.Model.*;

public interface AdminDao {
	//<-===================== Admin Login And Signup =================->
	public String login(String userName, String pwd) throws AdminException;
	public String signUp(String userName, String pwd) throws AdminException;
	
	//<-=============== Courses Section ================->
	public String createCourse(Course course) throws AdminException;
	public Course viewCourse(int courseID) throws AdminException;
	
	//<-------------- Update Course Section ------------->
	public String updateCourseName(int courseID, String newName) throws AdminException;
	public String updateCourseFee(int courseID, String newFee) throws AdminException;
	public String updateCourseDesc(int courseID, String newDesc) throws AdminException;
	
	
	
	//<-================== Batch Section ====================->
	public String createBatch(Batch batch) throws AdminException;
	public Batch viewBatch(int BatchID) throws AdminException;
	
	
	//<------------ Update batch info -------------->
	public String updateBatchFaculty(int BatchID, int facultyID) throws AdminException;
	public String updateBatchStudentCount(int BatchID, int newStudCount) throws AdminException;
	public String updateBatchStartDate(int BatchID, String newDate) throws AdminException;
	public String updateBatchDuration(int BatchID, String newDuration) throws AdminException;
	
	
	
	//<-==================== Faculty section ===========================->
	public String createFaculty(Faculty faculty) throws AdminException;
	public Faculty viewFaculty(int FacultyID) throws AdminException;
	
	
	//<--------------- update faculty funtions ---------------->
	public String updateFacultyName(int FacultyID, String newName, String pwd) throws AdminException;
	public String updateFacultyAddress(int FacultyID, String newAddress, String pwd) throws AdminException;
	public String updateFacultyMobile(int FacultyID, String newNumber, String pwd) throws AdminException;
	public String updateFacultyEmail(int FacultyID, String newMail, String pwd) throws AdminException;
	public String updateFacultyUserName (int FacultyID, String newUser, String pwd) throws AdminException;
	public String updateFacultyPasword(int FacultyID, String newPwd, String pwd) throws AdminException;
	
	
	//<-============== AllocateFacultyTOBatch ===============->
	public String allocateFacultyToBatch(int BatchID, int facultyId) throws AdminException;
	
	
	//<-================= CoursePlan Section ================->
	public String createCoursePlan(CoursePlan plan) throws AdminException;
	public CoursePlan viewCoursePlan(int PlanID) throws AdminException;
	
	
	//<----------- Update course Section -------------->
	public String updateCourseBatchId(int PlanID, int BatchID) throws AdminException;
	public String updateCourseDay(int PlanID, int day) throws AdminException;
	public String updateCourseTopic(int PlanID, int topic) throws AdminException;
	public String updateCourseStatus(int PlanID, int status) throws AdminException;
	
	
	
}
