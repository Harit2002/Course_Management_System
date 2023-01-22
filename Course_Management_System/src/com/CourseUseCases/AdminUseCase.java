package com.CourseUseCases;


import java.util.Scanner;

import com.ConsoleColors.ConsoleColors;
import com.CourseDao.AdminDao;
import com.CourseDao.AdminDaoImpl;
import com.Exception.AdminException;
import com.Model.Batch;


public class AdminUseCase {
	
	public static void main(String[] args) {
		Main();
	}
	public static void Main() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print(ConsoleColors.GREEN_BOLD+
				 "+==========================================+"+"\n"
				+"|         Welcome to Admin Section         |"+"\n"
				+"+==========================================+"+"\n"
				+"|                                          |"+"\n"
				+"|  1. Register new Admin                   |"+"\n"
				+"|  2. Create, read, update course          |"+"\n"
				+"|  3. Create, read, update batch           |"+"\n"
				+"|  4. Create, read, update faculty         |"+"\n"
				+"|  5. Create, read, update Course plan     |"+"\n"
				+"|  6. Allocate faculty to batch            |"+"\n"
				+"|  7. Back to main menu                    |"+"\n"
				+"|  8. Exit                                 |"+"\n"
				+"|                                          |"+"\n"
				+"+==========================================+"+"\n"
				+ConsoleColors.RESET
				);
		String out = sc.next();
		
		while(true) {
			if(out.equals("1")) {
				
			}
			else if(out.equals("2")) {
				
			}
			else if(out.equals("3")) {
				CreateBatch();
			}
			else {
				break;
			}
		}
		
		sc.close();
		
	}
	
	public static void CreateBatch() {
		
	
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
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
			
			String result = null;
			
			try {
				result = admin.createBatch(batch);
			} catch (AdminException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(result);
			
			System.out.println("Do you want to create anoteher batch (Y/N");
			
			if(sc.next().equalsIgnoreCase("N")) {
				Main();
				break;
			}
		}
		
		sc.close();
				
	}
	
	public static void AdminLogin() throws AdminException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(ConsoleColors.YELLOW_BOLD + "Enter Admin User Name" + ConsoleColors.RESET);
		String userName = sc.next();
		
		System.out.println(ConsoleColors.YELLOW_BOLD+"Enter password" + ConsoleColors.RESET);
		String pwd = sc.next();
		
		AdminDao admin = new AdminDaoImpl();
		
		String result = admin.login(userName, pwd);
		
		System.out.println(ConsoleColors.GREEN_BACKGROUND+result + ConsoleColors.RESET);
		
		sc.close();
		
		Main();
	}
}
