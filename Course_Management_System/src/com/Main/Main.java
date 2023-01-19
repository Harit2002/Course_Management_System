package com.Main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		
		
		System.out.println("Welcome to Course Management System ");
		System.out.println("====================================\n");
		
		while(true) {
			System.out.print(
							"+-----------------------------+"+"\n"+
							 "| 1. Login/SignUp as Admin    |"+"\n"
							+"| 2. Login/SignUp as  Faculty |"+"\n"
							+"| 3. Exit                     |"+"\n"
							+"+-----------------------------+"
							);
			String out = sc.next();
			
			if(out.equals("1")) {
		   		 Main.main(args);
		   	 }
			
			else if(out.equals("2")) {
		   		 break;
		   	 }
			
		   	else if(out.equals("3")) {
			    		sc.close();
			    		System.out.println("Exited...");
			    		break;
		   	 }
			
		   	 else {
		   		 System.out.println("!!!Invalid selection!!!");
		   		 continue;
		   	 }
		}
		
		//sc.close();
		
	}
}
