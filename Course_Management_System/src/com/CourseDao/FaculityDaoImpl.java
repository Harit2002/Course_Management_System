package com.CourseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ConsoleColors.ConsoleColors;
import com.DBUtil.DBUtil;
import com.Model.Faculty;

public class FaculityDaoImpl implements FaculityDao {

	@Override
	public String facultyLogin(String userName, String pwd) {
		
		String res = "Invalid id or password";
		
		

		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from  faculty where facultyname= ? And  password =?");
			
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
		
		Faculty faculty = new Faculty();

		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from  faculty where facultyId=?");
			
			ps.setInt(1, courseID);
						
			ResultSet res = ps.executeQuery();
			
			
			if(res.next())
				
				faculty.setFacultyID(res.getInt(1));
			
				faculty.setFacultyName(res.getString(2));
				
				faculty.setAddress(res.getString(3));
				
				faculty.setMobile(res.getString(4));
				
				faculty.setEmail(res.getString(5));
				
				faculty.setUserName(res.getString(6));
				
				faculty.setPassword(res.getString(7));
	
				System.out.println(ConsoleColors.CYAN_BOLD+ faculty+ConsoleColors.RESET);
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
	public String updatePassword(String userName, String pwd, String oldPwd) {
		String res = "Invalid id or password";
		
		

		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE faculty Set password =? where username= ? And  password =?");
			
			ps.setString(1, pwd);
			ps.setString(2,userName);
			ps.setString(3,oldPwd);
			
			int x = ps.executeUpdate();
			
			
			if(x > 0)
				
				res = "you password has been updated Succesfully";
	
	    	} 
               
          catch (Exception e) { 
                  System.out.println(e.getMessage()); 
			
          }

		
		return res;
	}

}
