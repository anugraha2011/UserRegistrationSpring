package com.Controller;

import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Configuration.MyConfig;
import com.Entity.UserInfo;
import com.UserDao.UserDao;

public class UserController {
	static ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
	static Scanner sc = (Scanner) context.getBean("scanner");
	
	public static void main(String[] args) {
		System.out.println("-------WELCOME-------");
		boolean flag=true;
		
		while(flag) {
			System.out.println("1. Save user details\n2. Update user details\n3. Retrieve user details\n4. Remove user\n5. Display all users\n6. Exit");
			
			System.out.println("Enter your choice: ");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1: {
				UserDao.saveUser(new UserInfo());
			}break;
			case 2: {
				UserDao.updateUser();
			}break;
			case 3: {
				UserDao.findUser();
			}break;
			case 4: {
				UserDao.removeUser();
			}break;
			case 5: {
				UserDao.displayAll();
			}break;
			case 6: {
				System.out.println("THANK YOU......!!");
				flag=false;
			}
			}
		}
	}

}
