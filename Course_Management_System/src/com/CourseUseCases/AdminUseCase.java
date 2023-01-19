package com.CourseUseCases;

import java.util.Scanner;
import com.CourseDao.AdminDao;
import com.CourseDao.AdminDaoImpl;


public class AdminUseCase {
	public static void main(String[] args) {
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
