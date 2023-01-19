package com.CourseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.DBUtil.DBUtil;
import com.Model.Batch;
import com.Model.Course;
import com.Model.CoursePlan;
import com.Model.Faculty;

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
			
			PreparedStatement ps = conn.prepareStatement("insert into course values(?,?,?,?)");
			
			ps.setInt(1,course.getCourseid());
			ps.setString(2, course.getCoursename());
			ps.setString(3,course.getFee());
			ps.setString(4, course.getCourseDesc());
			
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Course viewCourse(int courseID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createBatch(Batch batch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBatch(int BatchID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Course viewBatch(int BatchID) {
		// TODO Auto-generated method stub
		return null;
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
	public Course viewFaculty(int FacultyID) {
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
	public Course viewCoursePlan(int PlanID) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
