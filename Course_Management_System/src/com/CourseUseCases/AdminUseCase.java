package com.CourseUseCases;


import java.util.Scanner;
import com.CourseDao.AdminDao;
import com.CourseDao.AdminDaoImpl;
import com.Model.Batch;


public class AdminUseCase {
	
	
	public static void CreateBatch() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter courseID");
		int cId = sc.nextInt();
		
		System.out.println("Enter Faculty ID");
		int fID = sc.nextInt();
		
		System.out.println("Enter total number of students");
		int totalStud = sc.nextInt();
		
		System.out.println("Enter batch Start date YYYY-MM-DD");
		
		String startDate = sc.next();
		
		sc.nextLine();
		
		
		System.out.println("Enter batch duration");
		String duration = sc.nextLine();
		
		
		AdminDao admin = new AdminDaoImpl();
		
		Batch batch = new Batch();
		
		batch.setBatchStartDate(startDate);
		batch.setCourseID(cId);
		batch.setFacultyID(fID);
		batch.setStudentCount(totalStud);
		batch.setDuration(duration);
		
		sc.close();
		
		
		String result = admin.createBatch(batch);
		
		System.out.println(result);
	}
	
	public static void AdminLogin() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Admin User Name");
		String userName = sc.next();
		
		System.out.println("Enter password");
		String pwd = sc.next();
		
		AdminDao admin = new AdminDaoImpl();
		
		String result = admin.login(userName, pwd);
		System.out.println(result);
		
		
		
		sc.close();
		
		
	}
}
