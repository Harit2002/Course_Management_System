package com.CourseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import com.Exception.*;
import com.DBUtil.DBUtil;
import com.Model.*;
import com.mysql.cj.protocol.Resultset;

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
		String res = "Invalid id or password";
		
		

		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into admin values(?,?)");
			
			ps.setString(1,userName);
			ps.setString(2,pwd);
			
			int x = ps.executeUpdate();
			
			
			if(x > 0)
				
				res ="admin succesfully registered";
	
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
			
			PreparedStatement ps = conn.prepareStatement("insert into course values(?,?,?)");
			

			ps.setString(1, course.getCoursename());
			ps.setString(2,course.getFee());
			ps.setString(3, course.getCourseDesc());
			
			int x = ps.executeUpdate();
			
			
			if(x > 0)
				
				res = course.getCourseid()+" succesfully created";
	
	    	} 
               
          catch (Exception e) { 
                  System.out.println(e.getMessage()); 
			
          }
		
		return res;
	}

	@Override
	public int updateCourse(int courseID) {
   
			
		
		return 0;
	}

	@Override
	public Course viewCourse(int courseID) {
		Course course = new Course();
		
		

		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from course where courseId=?");
			ps.setInt(1, courseID);
			
			
			ResultSet result = ps.executeQuery();
			
			int cID = result.getInt("course_ID");
			course.setCourseid(cID);
			
			String cName = result.getString("cours_Name");
			course.setCoursename(cName);
			
			String fee = result.getString("fee");
			course.setFee(fee);
			
			String course_desc = result.getString("course_desc");
			course.setCourseDesc(course_desc);
			
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
				
				res = batch.getBatchID()+" batch ID succesfully created";
	
	    	} 
               
          catch (Exception e) { 
                  System.out.println(e.getMessage()); 
			
          }
		
		return res;
	}

	@Override
	public int updateBatch(int BatchID) {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateFaculty(int FacultyID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Faculty viewFaculty(int FacultyID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String allocateFacultyToBatch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createCoursePlan(CoursePlan plan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCoursePlan(int PlanID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CoursePlan viewCoursePlan(int PlanID) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
