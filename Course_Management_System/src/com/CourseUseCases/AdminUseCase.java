package com.CourseUseCases;


import java.util.Scanner;

import com.ConsoleColors.ConsoleColors;
import com.CourseDao.AdminDao;
import com.CourseDao.AdminDaoImpl;
import com.Exception.AdminException;
import com.Model.Batch;
import com.Model.Course;


public class AdminUseCase {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main();
	}
	
	public static void Main() {
		
		
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
				+"|  8. Logout                               |"+"\n"
				+"|                                          |"+"\n"
				+"+==========================================+"+"\n"
				+ConsoleColors.RESET
				);
		String out = sc.next();
		
		while(true) {
			if(out.equals("1"))   AdminSignUp();
			
			else if(out.equals("2"))	courseMenu();
			
			else if(out.equals("3")) 	batchMenu();
			
			else if(out.equals("4"))	facMenu();
			
			else if(out.equals("5"))	coursePlanMenu();
			
			else if(out.equals("6"))	AllocateFacToBatch();
			
			else if(out.equals("7")) {
				com.Main.Main.Main1();
				sc.close();
				break;
			}
			
			else if(out.equals("8")) {
				System.out.println(ConsoleColors.RED_BACKGROUND+"Logout Successfull"+ConsoleColors.RESET+"\n");
				
				com.Main.Main.Main1();
				
				sc.close();
				break;
			}
			
			else {
				System.out.println(ConsoleColors.RED_BACKGROUND+"Invalid Selection !!!"+ConsoleColors.RESET+"\n");
				Main();
			}
		}
		
		sc.close();
		
	}
	
	
	public static void AdminLogin() throws AdminException {
		
		System.out.println(ConsoleColors.YELLOW_BOLD + "Enter Admin User Name" + ConsoleColors.RESET);
		String userName = sc.next();
		
		System.out.println(ConsoleColors.YELLOW_BOLD+"Enter password" + ConsoleColors.RESET);
		String pwd = sc.next();
		
		AdminDao admin = new AdminDaoImpl();
		
		String result = admin.login(userName, pwd);
		
		System.out.println(ConsoleColors.GREEN_BACKGROUND+result + ConsoleColors.RESET);
		
		Main();
	}
	
	public static void AdminSignUp() {
		
		AdminDao admin = new AdminDaoImpl();
		
		System.out.println(ConsoleColors.YELLOW+"Enter new Admin UserName/email"+ConsoleColors.RESET);
		String email = sc.next();
		
		System.out.println(ConsoleColors.YELLOW+"Enter Password"+ConsoleColors.RESET);
		String pwd = sc.next();
		
		try {
			
			String res = admin.signUp(email, pwd);
			System.out.println(ConsoleColors.GREEN_BACKGROUND+res+ConsoleColors.RESET);
			
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Main();
	}
	
	public static void AllocateFacToBatch() {
		AdminDao admin=new AdminDaoImpl();
		
		System.out.println(ConsoleColors.YELLOW+"Enter BatchId"+ConsoleColors.RESET);
		int batchID = sc.nextInt();
		
		System.out.println(ConsoleColors.YELLOW+"Enter FaculityId you want to allocate"+ConsoleColors.RESET);
		int facID = sc.nextInt();
		
		try {
			
			String res = admin.allocateFacultyToBatch(batchID, facID);
			System.out.println(ConsoleColors.GREEN_BACKGROUND+res+ConsoleColors.RESET+"\n");
			
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Main();
	}
	
	public static void courseMenu() {
		
		System.out.print(ConsoleColors.CYAN_BOLD+
		 		 "+======================================+"+"\n"
		 		+"|      Welcome to Course Section       |"+"\n"
		 		+"+======================================+"+"\n"
		        +"|                                      |"+"\n"
				+"|  1. Create Course                    |"+"\n"
				+"|  2. View Course                      |"+"\n"
				+"|  3. Update Course details            |"+"\n"
				+"|  4. Go back to main menu             |"+"\n"
				+"|                                      |"+"\n"
				+"+======================================+"+"\n"
				+ConsoleColors.RESET
				);
		
		String out = sc.next();
		
		while(true) {
			
			if(out.equals("1")) 
				 CreateCourse();
			
			else if(out.equals("2")) 
							viewCourses();
			
			else if(out.equals("3")) {
				
			}
			else if(out.equals("4")) {
				Main();
				break;
			}
			else {
				System.out.println(ConsoleColors.RED_BACKGROUND+"Invalid Selection !!!"+ConsoleColors.RESET);
				courseMenu();
			}
		}	
	}
	
	public static void CreateCourse() {
		
		AdminDao admin=new AdminDaoImpl();
		
		Course course = new Course();
		
		System.out.println(ConsoleColors.YELLOW+"Enter Course Name"+ConsoleColors.RESET);
		course.setCoursename(sc.next());
		
		System.out.println(ConsoleColors.YELLOW+"Enter Course Fee"+ConsoleColors.RESET);
		course.setFee(sc.next());
		
		System.out.println(ConsoleColors.YELLOW+"Enter Course Description"+ConsoleColors.RESET);
		course.setCourseDesc(sc.next());
		
		try {
			String res = admin.createCourse(course);
			
			System.out.println(ConsoleColors.GREEN_BACKGROUND+res+ConsoleColors.RESET);
			
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		courseMenu();
		
	}
	public static void viewCourses() {
		
		AdminDao admin=new AdminDaoImpl();
		
		Course c = null;
		
		try {
			
			System.out.println(ConsoleColors.YELLOW+"Enter CourseID "+ConsoleColors.RESET);
			
			c =	admin.viewCourse(sc.nextInt());
			
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(c);
		
		courseMenu();
	}
	
	public static void batchMenu() {
		
		System.out.print(ConsoleColors.CYAN_BOLD+
		 		 "+======================================+"+"\n"
		 		+"|      Welcome to Batch  Section       |"+"\n"
		 		+"+======================================+"+"\n"
		        +"|                                      |"+"\n"
				+"|  1. Create Batch                     |"+"\n"
				+"|  2. View Batch                       |"+"\n"
				+"|  3. Update Batch details             |"+"\n"
				+"|  4. Go back to main menu             |"+"\n"
				+"|                                      |"+"\n"
				+"+======================================+"+"\n"
				+ConsoleColors.RESET
				);
		
		String out = sc.next();
		
		while(true) {
			
			if(out.equals("1")) 
				 creBatch();
			
			else if(out.equals("2")) 
				ViewBatch();
			
			else if(out.equals("3")) {
				
			}
			else if(out.equals("4")) {
				Main();
				break;
			}
			
			else {
				System.out.println(ConsoleColors.RED_BACKGROUND+"Invalid Selection !!!"+ConsoleColors.RESET);
				batchMenu();
			}
		}
	}
	
	public static void creBatch() {

		AdminDao admin=new AdminDaoImpl();
 
		Batch batch = new Batch();
		
		System.out.println(ConsoleColors.YELLOW+"Enter CourseID"+ConsoleColors.RESET);
		batch.setCourseID(sc.nextInt());
		
		System.out.println(ConsoleColors.YELLOW+"Enter FacultyID"+ConsoleColors.RESET);
		batch.setFacultyID(sc.nextInt());
		
		System.out.println(ConsoleColors.YELLOW+"Enter Student count"+ConsoleColors.RESET);
		batch.setStudentCount(sc.nextInt());
		
		System.out.println(ConsoleColors.YELLOW+"Enter Batch Start Date in YYYY-MM-DD format"+ConsoleColors.RESET);
		batch.setBatchStartDate(sc.next());
		
		sc.nextLine();
		
		System.out.println(ConsoleColors.YELLOW+"Enter Batch Duration"+ConsoleColors.RESET);
		batch.setDuration(sc.nextLine());
		
		try {
			String res = admin.createBatch(batch);
			
			System.out.println(ConsoleColors.GREEN_BACKGROUND+res+ConsoleColors.RESET);
			
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		courseMenu();
	}
	
	public static void ViewBatch() {
		AdminDao admin=new AdminDaoImpl();
		
		Batch batch = null;
		
		try {
			System.out.println(ConsoleColors.YELLOW+"Enter BatchID"+ConsoleColors.RESET);
			
			batch = admin.viewBatch(sc.nextInt());
			
			System.out.println(ConsoleColors.BLUE_BRIGHT+batch+ConsoleColors.RESET+"\n");
			
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		batchMenu();
	}
	
	
	
	public static void facMenu() {
		System.out.print(ConsoleColors.CYAN_BOLD+
		 		 "+======================================+"+"\n"
		 		+"|     Welcome to Faculty  Section      |"+"\n"
		 		+"+======================================+"+"\n"
		        +"|                                      |"+"\n"
				+"|  1. Create Faculty                   |"+"\n"
				+"|  2. View Faculty                     |"+"\n"
				+"|  3. Update Faculty details           |"+"\n"
				+"|  4. Go back to main menu             |"+"\n"
				+"|                                      |"+"\n"
				+"+======================================+"+"\n"
				+ConsoleColors.RESET
				);
		
		String out = sc.next();
		
		while(true) {
			
			if(out.equals("1")) 
				 creBatch();
			
			else if(out.equals("2")) 
				ViewBatch();
			
			else if(out.equals("3")) {
				
			}
			else if(out.equals("4")) {
				Main();
				break;
			}
			
			else {
				System.out.println(ConsoleColors.RED_BACKGROUND+"Invalid Selection !!!"+ConsoleColors.RESET);
				batchMenu();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void coursePlanMenu() {
		System.out.print(ConsoleColors.CYAN_BOLD+
		 		 "+======================================+"+"\n"
		 		+"|    Welcome to CoursePlan  Section    |"+"\n"
		 		+"+======================================+"+"\n"
		        +"|                                      |"+"\n"
				+"|  1. Create CoursePlan                |"+"\n"
				+"|  2. View CoursePlan                  |"+"\n"
				+"|  3. Update CoursePlan details        |"+"\n"
				+"|  4. Go back to main menu             |"+"\n"
				+"|                                      |"+"\n"
				+"+======================================+"+"\n"
				+ConsoleColors.RESET
				);
		
		String out = sc.next();
		
		while(true) {
			
			if(out.equals("1")) 
				 ;
			
			else if(out.equals("2")) 
				;
			
			else if(out.equals("3")) {
				
			}
			else if(out.equals("4")) {
				Main();
				break;
			}
			
			else {
				System.out.println(ConsoleColors.RED_BACKGROUND+"Invalid Selection !!!"+ConsoleColors.RESET);
				batchMenu();
			}
		}
	}
}
