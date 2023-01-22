package com.Main;

import java.util.Scanner;

import com.ConsoleColors.ConsoleColors;
import com.CourseUseCases.AdminUseCase;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		
		
		
		
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
							+ConsoleColors.RESET
							);
			String out = sc.next();
			
			
			
			if(out.equals("1")) {
				
				
				if(out.equals("1"))
		   		 AdminUseCase.AdminLogin();
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
				
		   		 break;
		   	 }
			
		   	else if(out.equals("3")) {
			    
			    		System.out.println("Exited...");
			    		break;
		   	 }
			
		   	 else {
		   		 System.out.println("!!!Invalid selection!!!");
		   		 continue;
		   	 }
		}
		
		sc.close();
		
	}
}
