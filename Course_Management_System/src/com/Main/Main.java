package com.Main;

import java.util.Scanner;

import com.CourseUseCases.AdminUseCase;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		
		
		System.out.println("Welcome to Course Management System ");
		System.out.println("====================================\n");
		
		while(true) {
			System.out.print(
							"+-----------------------------+"+"\n"+
							 "| 1. Login as Admin		    |"+"\n"
							+"| 2. Login/SignUp as  Faculty |"+"\n"
							+"| 3. Exit                     |"+"\n"
							+"+-----------------------------+"
							);
			String out = sc.next();
			
			
			
			if(out.equals("1")) {
				System.out.print(
						"+-------------------------------------+"+"\n"+
						 "| 1. Add another Admin	            |"+"\n"
						+"| 2. Create, read, update course      |"+"\n"
						+"| 3. Create, read, update batch       |"+"\n"
						+"| 4. Create, read, update faculty	   	|"+"\n"
						+"| 5. Create, read, update Course plan	|"+"\n"
						+"| 6. Allocate faculty to batch 		|"+"\n"
						+"| 7. Back to main menu          		|"+"\n"
						+"| 7. Exit				          		|"+"\n"
						+"+-------------------------------------+"
						);
				
				if(out.equals("1"))
		   		 AdminUseCase.AdminLogin();
		   	 }
			
			
			
			
			
			else if(out.equals("2")) {
				
				
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
