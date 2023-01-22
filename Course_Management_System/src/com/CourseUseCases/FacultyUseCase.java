package com.CourseUseCases;

import java.util.Scanner;
import com.ConsoleColors.ConsoleColors;
import com.CourseDao.FaculityDao;
import com.CourseDao.FaculityDaoImpl;

public class FacultyUseCase {
	
	public static void main(String[] args) {
		Login();
	}
	
	public static void FacultyFunctionality() {
		
		Scanner sc = new Scanner(System.in);
		
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
			if(out.equals("1")) {
				
			}
			else if(out.equals("4")) {
				break;
			}
			else {
				System.out.println(ConsoleColors.RED_BACKGROUND+"Invalid option !!!"+ConsoleColors.RESET);
				FacultyFunctionality();
			}
		}
		sc.close();
	}
	public static void Login() {
		
		Scanner sc = new Scanner(System.in);
		
		String name = sc.next();
		
		String pwd = sc.next();
		
		sc.close();
		
		FaculityDao faculity = new FaculityDaoImpl();
		
		String result = faculity.facultyLogin(name, pwd);
		
		System.out.println(ConsoleColors.GREEN_BACKGROUND+result+ConsoleColors.RESET);
		
		FacultyFunctionality();
		
	}
}
