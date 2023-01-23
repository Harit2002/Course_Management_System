package com.Main;

import java.util.Scanner;

import com.ConsoleColors.ConsoleColors;
import com.CourseUseCases.AdminUseCase;
import com.CourseUseCases.FacultyUseCase;
import com.Exception.AdminException;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main1();
	}
	
	public static void Main1() {
		
		
		while(true) {
			System.out.print(ConsoleColors.GREEN_BOLD+
					 		 "+========================================+"+"\n"
					 	    +"|  Welcome to  Course Management System  |"+"\n"
					 	    +"+========================================+"+"\n"
					        +"|                                        |"+"\n"
							+"|  1. Login as Admin                     |"+"\n"
							+"|  2. Login/SignUp as  Faculty           |"+"\n"
							+"|  3. Exit                               |"+"\n"
							+"|                                        |"+"\n"
							+"+========================================+"+"\n"
							+ConsoleColors.RESET);
			
			String out = sc.next();
			
						
			if(out.equals("1")) {
				
				try {
					AdminUseCase.AdminLogin();
				} catch (AdminException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		   	 		
			
			else if(out.equals("2")) FacultyUseCase.Login();		
				
			
		   	else if(out.equals("3")) {
			    
			    		System.out.println(ConsoleColors.GREEN_BACKGROUND+"Thank you for visiting..."+ConsoleColors.RESET);
			    		sc.close();
			    		break;
		   	 }
			
		   	 else {
		   		 System.out.println(ConsoleColors.RED_BACKGROUND+"!!!Invalid selection!!!"+ConsoleColors.RESET);
		   		 Main1();
		   	 }
		}
		
	}
}
