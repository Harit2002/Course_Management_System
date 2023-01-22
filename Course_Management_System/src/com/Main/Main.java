package com.Main;

import java.util.Scanner;

import com.ConsoleColors.ConsoleColors;
import com.CourseUseCases.AdminUseCase;
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
			
			else if(out.equals("2")) {		
				
				System.out.print(ConsoleColors.GREEN_BOLD+
						 		 "+======================================+"+"\n"
						 		+"|      Welcome to Faculty Section      |"+"\n"
						 		+"+======================================+"+"\n"
						        +"|                                      |"+"\n"
								+"|  1. Login as Faculty                 |"+"\n"
								+"|  2. SignUp as  Faculty               |"+"\n"
								+"|  3. Go back to main menu             |"+"\n"
								+"|                                      |"+"\n"
								+"+======================================+"+"\n"
								+ConsoleColors.RESET
								);
				out = sc.next();
				
				while(true) {
					if(out.equals("1")) {
						Main.main(null);
						Main1();
					}
					
					else if(out.equals("2")) {
						
					}
					else if(out.equals("3")) {
						Main1();
						break;
					}
					else System.out.println(ConsoleColors.RED_BACKGROUND+"Invalid Selection !!!"+ConsoleColors.RESET);
					
				} 
		   	 }
			
		   	else if(out.equals("3")) {
			    
			    		System.out.println(ConsoleColors.RED_BOLD+"Exited..."+ConsoleColors.RESET);
			    		break;
		   	 }
			
		   	 else {
		   		 System.out.println(ConsoleColors.RED_BACKGROUND+"!!!Invalid selection!!!"+ConsoleColors.RESET);
		   		 continue;
		   	 }
		}
		
		sc.close();
		
	}
}
