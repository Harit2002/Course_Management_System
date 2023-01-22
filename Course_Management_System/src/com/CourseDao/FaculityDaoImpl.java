package com.CourseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.DBUtil.DBUtil;

public class FaculityDaoImpl implements FaculityDao {

	@Override
	public String facultyLogin(String userName, String pwd) {
		
		String res = "Invalid id or password";
		
		

		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from  course where facultyname= ? And  password =?");
			
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
	public void coursePlan(int courseID) {

		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from  course where courseId=?");
			
			ps.setInt(1, courseID);
						
			ResultSet x = ps.executeQuery();
			
			
			if(x.next())
				
				System.out.println("Welcome  " + x.getString("username"));
	
	    	} 
               
          catch (Exception e) { 
                  System.out.println(e.getMessage()); 
			
          }

	}

	@Override
	public void fillPlanner(int planID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String updatePassword(String userName, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

}
