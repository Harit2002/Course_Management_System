package com.CourseUseCases;

import java.util.Scanner;
import com.ConsoleColors.ConsoleColors;
import com.CourseDao.FaculityDao;
import com.CourseDao.FaculityDaoImpl;
import com.Main.Main;

public class FacultyUseCase {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		FacultyFunctionality();
	}
	
	public static void FacultyFunctionality() {
		
		
		
		System.out.print(ConsoleColors.GREEN_BOLD+
		 		 "+======================================+"+"\n"
		 		+"|      Welcome to Faculty Section      |"+"\n"
		 		+"+======================================+"+"\n"
		        +"|                                      |"+"\n"
				+"|  1. View Course Plan                 |"+"\n"
				+"|  2. Fill up the day wise planner     |"+"\n"
				+"|  3. Update password.                 |"+"\n"
				+"|  4. Go back to main menu             |"+"\n"
				+"|                                      |"+"\n"
				+"+======================================+"+"\n"
				+ConsoleColors.RESET
				);
		
		String out = sc.next();
		
		while(true) {
			if(out.equals("1")) ViewCourse();;
			
			if(out.equals("2")) ;
			
			if(out.equals("3")) ;
				
			
			else if(out.equals("4")) {
				
				Main.Main1();
				sc.close();
				break;
			}
			else {
				System.out.println(ConsoleColors.RED_BACKGROUND+"Invalid option !!!"+ConsoleColors.RESET);
				FacultyFunctionality();
			}
		}
		
	}
	public static void Login() {
			
		
		System.out.println(ConsoleColors.YELLOW_BOLD + "Enter faculty name" + ConsoleColors.RESET);
		String name = sc.next();
		
		System.out.println(ConsoleColors.YELLOW_BOLD + "Enter password" + ConsoleColors.RESET);
		String pwd = sc.next();
		
		FaculityDao faculity = new FaculityDaoImpl();
		
		String result = faculity.facultyLogin(name, pwd);
		
		System.out.println(ConsoleColors.GREEN_BACKGROUND+result+ConsoleColors.RESET);
		
		FacultyFunctionality();
		
	}
	
	public static void ViewCourse() {
		
		FaculityDao faculity = new FaculityDaoImpl();
		
		System.out.println(ConsoleColors.YELLOW_BOLD + "Enter facultyID" + ConsoleColors.RESET);
		
		faculity.coursePlan(sc.nextInt());
		
		FacultyFunctionality();
	}
	
	public static void UpdatePwd() {
		FaculityDao faculity = new FaculityDaoImpl();
		
		System.out.println(ConsoleColors.YELLOW_BOLD + "Enter faculty User Name" + ConsoleColors.RESET);
		String user = sc.next();
		
		System.out.println();
		String current = sc.next(ConsoleColors.YELLOW_BOLD + "Enter Current Password" + ConsoleColors.RESET);
		
		System.out.println(ConsoleColors.YELLOW_BOLD + "Enter New Password" + ConsoleColors.RESET);
		String newPwd = sc.next();
		
		String res = faculity.updatePassword(user, newPwd, current);
		
		System.out.println(ConsoleColors.GREEN_BACKGROUND + res + ConsoleColors.RESET);
		
		FacultyFunctionality();
		
	}
	
}
