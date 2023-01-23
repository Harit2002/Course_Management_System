package com.CourseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import com.Exception.*;
import com.DBUtil.DBUtil;
import com.Model.*;


public class AdminDaoImpl implements AdminDao{

	@Override
	public String login(String userName, String pwd) {
		String res = "Invalid id or password";
		
		

		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from  admin where username= ? And  password =?");
			
			ps.setString(1,userName);
			ps.setString(2,pwd);
			
			ResultSet x = ps.executeQuery();
			
			
			if(x.next())
				
				res ="Welcome  " + x.getString("username");
	
	    	} 
               
          catch (Exception e) { 
                  System.out.println(e.getMessage()); 
			
          }

		
		return res;
	}
	
	@Override
	public String signUp(String userName, String pwd) {
		String res = "Invalid Admin id or password";
		
		

		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into admin values(?,?)");
			
			ps.setString(1,userName);
			ps.setString(2,pwd);
			
			int x = ps.executeUpdate();
			
			
			if(x > 0)
				
				res =userName+" succesfully registered as admin";
	
	    	} 
               
          catch (Exception e) { 
                  System.out.println(e.getMessage()); 
			
          }
		
		
		return res;
	}

	@Override
	public String createCourse(Course course) {
		
		String res = "Invalid course details";
		
		

		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into course(course_name, fee, course_desc) values(?,?,?)");
			

			ps.setString(1, course.getCoursename());
			ps.setString(2,course.getFee());
			ps.setString(3, course.getCourseDesc());
			
			int x = ps.executeUpdate();
			
			
			if(x > 0)
				
				res = course.getCoursename()+" course succesfully created";
	
	    	} 
               
          catch (Exception e) { 
                  System.out.println(e.getMessage()); 
			
          }
		
		return res;
	}



	@Override
	public Course viewCourse(int courseID) {
		
		Course course = new Course();
		
		

		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from course where course_Id=?");
			ps.setInt(1, courseID);
			
			
			ResultSet result = ps.executeQuery();
			
			if(result.next()) {
			
				int cID = result.getInt("course_ID");
				course.setCourseid(cID);
				
				String cName = result.getString("course_Name");
				course.setCoursename(cName);
				
				String fee = result.getString("fee");
				course.setFee(fee);
				
				String course_desc = result.getString("course_desc");
				course.setCourseDesc(course_desc);
			 }
			}
			
               
          catch (Exception e) { 
                  System.out.println(e.getMessage()); 
			
          }

		return course;
	}

	@Override
	public String createBatch(Batch batch) {
		String res = "Invalid course details";
		
		

		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into batch(course_id, facultyid, total_stud, start_date, duration) values(?,?,?,?,?)");
			

			ps.setInt(1, batch.getCourseID() );
			ps.setInt(2, batch.getFacultyID());
			ps.setInt(3, batch.getStudentCount());
			ps.setString(4, batch.getBatchStartDate());
			ps.setString(5, batch.getDuration());
			
			int x = ps.executeUpdate();
			
			
			if(x > 0)
				
				res = " Batch succesfully created";
	
	    	} 
               
          catch (Exception e) { 
                  System.out.println(e.getMessage()); 
			
          }
		
		return res;
	}


	@Override
	public Batch viewBatch(int BatchID) {
		Batch batch = new Batch();
		
		

		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from batch where batchID=?");
			ps.setInt(1, BatchID);
			
			
			ResultSet result = ps.executeQuery();
			if(result.next()) {
			int bID = result.getInt("batch_ID");
			batch.setBatchID(bID);
			
			int cID = result.getInt("cours_Id");
			batch.setCourseID(cID);
			
			int fID = result.getInt("facultyID");
			batch.setFacultyID(fID);
			
			int stud = result.getInt("total_stud");
			batch.setStudentCount(stud);
			
			Date str_date = result.getDate("start_date");
			batch.setBatchStartDate(str_date+"");
			
			  }
			else throw new AdminException();
			
		}
			
               
          catch (Exception e) { 
                  System.out.println(e.getMessage()); 
			
          }

		return  batch;
	}

	@Override
	public String createFaculty(Faculty faculty) {
	String res = "Invalid faculty details";
		
		

		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into faculty(faculyName, facultyAddress, mobile, userName, password) values(?,?,?,?,?)");
			

			ps.setString(1, faculty.getFacultyName() );
			ps.setString(2, faculty.getAddress() );
			ps.setString(3, faculty.getMobile());
			ps.setString(4, faculty.getUserName());
			ps.setString(5, faculty.getPassword());
			
			int x = ps.executeUpdate();
			
			
			if(x > 0)
				
				res = faculty.getFacultyName()+" succesfully created";
	
	    	} 
               
          catch (Exception e) { 
                  System.out.println(e.getMessage()); 
			
          }
		
		return res;
	}



	@Override
	public Faculty viewFaculty(int FacultyID) {
		Faculty faculty = new Faculty();
		
		

		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from faculty where batchID=?");
			ps.setInt(1, FacultyID);
			
			
			ResultSet result = ps.executeQuery();
			
			if(result.next()) {
			int fID = result.getInt("facultyID");
			faculty.setFacultyID(fID);;
			
			String facName  = result.getString("facultyName");
			faculty.setFacultyName(facName);
			
			String facAdd = result.getString("facultyAddress");
			faculty.setAddress(facAdd);
			
			String mobile = result.getString("mobil");
			faculty.setMobile(mobile);
			
			String uName = result.getString("userName");
			faculty.setUserName(uName);
			
			String pwd = result.getString("password");
			faculty.setPassword(pwd);
			
			
			  }
			else throw new AdminException();
			}
			
               
          catch (Exception e) { 
                  System.out.println(e.getMessage()); 
			
          }

		return faculty;
	}

	@Override
	public String allocateFacultyToBatch(int BatchID, int facultyId) {
		
		String res = "Invalid batch/faculty details";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE batch SET facultyID = ? where batchID=?");
			
			ps.setInt(1, facultyId);
			ps.setInt(2, BatchID);
			
			
			int x = ps.executeUpdate();
			
			if(x > 0)
				res = facultyId+" Faculty  succesfully allocated to Batch";
			
			}
			
               
          catch (Exception e) { 
                  System.out.println(e.getMessage()); 
			
          }
		
		
		return res;
	}

	@Override
	public String createCoursePlan(CoursePlan plan) {
		String res = "Invalid course details";
		
		

		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into course(batchId, daynumber, topic, status) values(?,?,?,?)");
			

			ps.setInt(1, plan.getBatchID() );
			ps.setInt(2, plan.getDayNumber());
			ps.setString(3, plan.getTopic());
			ps.setString(4, plan.getStatus());

			
			int x = ps.executeUpdate();
			
			
			if(x > 0)
				
				res = plan.getTopic()+" succesfully created";
	
	    	} 
               
          catch (Exception e) { 
                  System.out.println(e.getMessage()); 
			
          }
		
		return res;
	}
    
	@Override
	public CoursePlan viewCoursePlan(int PlanID) {
		CoursePlan plan = new CoursePlan();
		
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from CoursePlan PlanID=?");
			ps.setInt(1, PlanID);
			
			
			ResultSet result = ps.executeQuery();
			
			if(result.next()) {
			
				int planID = result.getInt("planId");
				plan.setPlanID(planID);
				
				int bID = result.getInt("batchId");
				plan.setBatchID(bID);
				
				int dCount = result.getInt("dayNumber");
				plan.setDayNumber(dCount);
				
				String topic = result.getString("topic");
				plan.setTopic(topic);
				
				String status = result.getString("status");
				plan.setStatus(status);
			
			  }
			else throw new AdminException();
			}
			
               
          catch (Exception e) { 
                  System.out.println(e.getMessage()); 
			
          }

		return plan;
	}

	
	
	//<---=============== Update course info ===============--->
	
	@Override
	public String updateCourseName(int courseID, String newName) {
		
		String res = "Error occured";
		
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE Course SET course_name = ? WHERE courseID = ? ");
			
			ps.setString(1, newName);
			ps.setInt(2, courseID);
			
			int x = ps.executeUpdate();
			
			if(x > 0) 
				res = "Course name updated to "+newName;
			}
			
               
          catch (Exception e) { 
                  System.out.println(e.getMessage()); 
			
          }

		return res;
	}

	@Override
	public String updateCourseFee(int courseID, String newFee) {
		String res = "Error occured";
		
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE Course SET fee = ? WHERE courseID = ? ");
			
			ps.setString(1, newFee);
			ps.setInt(2, courseID);
			
			int x = ps.executeUpdate();
			
			if(x > 0) 
				res = "Course fee updated to "+newFee;
			}
			
               
          catch (Exception e) { 
                  System.out.println(e.getMessage()); 
			
          }

		return res;
	}

	@Override
	public String updateCourseDesc(int courseID, String newDesc) throws AdminException {
		String res = "Error occured";
		
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE Course SET course_desc = ? WHERE courseID = ? ");
			
			ps.setString(1, newDesc);
			ps.setInt(2, courseID);
			
			int x = ps.executeUpdate();
			
			if(x > 0) 
				res = "Course description updated to "+newDesc;
			}
			
               
          catch (Exception e) { 
                  
        	  throw new AdminException(e.getMessage()); 
			
          }

		return res;
	}

	@Override
	public String updateBatchFaculty(int BatchID, int facultyID) throws AdminException {
		String res = "Error occured";
		
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE Course SET facultyId = ? WHERE batchID = ? ");
			
			ps.setInt(1, facultyID);
			ps.setInt(2, BatchID);
			
			int x = ps.executeUpdate();
			
			if(x > 0) 
				res = "Batch faculty updated to "+facultyID;
			}
			
               
          catch (Exception e) { 
                  
        	  throw new AdminException(e.getMessage()); 
			
          }

		return res;
	}

	@Override
	public String updateBatchStudentCount(int BatchID, int newStudCount) throws AdminException {
		String res = "Error occured";
		
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE Course SET total_stud = ? WHERE batchID = ? ");
			
			ps.setInt(1, newStudCount);
			ps.setInt(2, BatchID);
			
			int x = ps.executeUpdate();
			
			if(x > 0) 
				res = "Batch Count updated to "+newStudCount;
			}
			
               
          catch (Exception e) { 
                  
        	  throw new AdminException(e.getMessage()); 
			
          }

		return res;
	}

	@Override
	public String updateBatchStartDate(int BatchID, String newDate) throws AdminException{
		String res = "Error occured";
		
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE Course SET start_Date = ? WHERE batchID = ? ");
			
			ps.setString(1, newDate);
			ps.setInt(2, BatchID);
			
			int x = ps.executeUpdate();
			
			if(x > 0) 
				res = "Batch start date updated to "+newDate;
			}
			
               
          catch (Exception e) { 
                  
        	  throw new AdminException(e.getMessage()); 
			
          }

		return res;
	}

	@Override
	public String updateBatchDuration(int BatchID, String newDuration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateFacultyName(int FacultyID, String newName, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateFacultyAddress(int FacultyID, String newAddress, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateFacultyMobile(int FacultyID, String newNumber, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateFacultyEmail(int FacultyID, String newMail, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateFacultyUserName(int FacultyID, String newUser, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateFacultyPasword(int FacultyID, String newPwd, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateCourseBatchId(int PlanID, int BatchID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateCourseDay(int PlanID, int day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateCourseTopic(int PlanID, int topic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateCourseStatus(int PlanID, int status) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
