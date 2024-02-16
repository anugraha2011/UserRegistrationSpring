package com.UserDao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Configuration.MyConfig;
import com.Entity.UserInfo;

public class UserDao {

	static ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
	static Scanner sc = (Scanner) context.getBean("scanner");
	static EntityManager manager = (EntityManager) context.getBean("manager");
	static EntityTransaction transaction = (EntityTransaction) context.getBean("transaction");

	public static void saveUser(UserInfo user) {

		System.out.println("Enter the user name: ");
		String name = sc.next();

		System.out.println("Enter the password: ");
		String pwd = sc.next();

		System.out.println("Enter the email: ");
		String email = sc.next();

		user.setUserName(name);
		user.setEmail(email);
		user.setPassword(pwd);

		transaction.begin();
		manager.persist(user);
		manager.flush();
		transaction.commit();
		System.out.println("User data saved");
	}

	public static void updateUser() {

		System.out.println("1. Update Email\n2. Update Password");

		System.out.println("Choose the field to be updated: ");
		int choice = sc.nextInt();

		System.out.println("Enter the user id: ");
		int id = sc.nextInt();

		UserInfo user = manager.find(UserInfo.class, id);

		if (user != null) {

			switch (choice) {
			case 1: {
				System.out.println("Enter the updated email: ");
				String email = sc.next();

				user.setEmail(email);

				transaction.begin();
				manager.merge(user);
				transaction.commit();
				System.out.println("User email updated");
			}
				break;
			case 2: {
				System.out.println("Enter the updated password: ");
				String pwd = sc.next();

				user.setPassword(pwd);

				transaction.begin();
				manager.merge(user);
				transaction.commit();
				System.out.println("User password updated");
			}
				break;
			}
		} else {
			System.out.println("User id does not exist");
		}
	}
	
	public static void removeUser() {
		
		System.out.println("Enter the user id: ");
		int id = sc.nextInt();

		UserInfo user = manager.find(UserInfo.class, id);
		
		if(user!=null) {
			transaction.begin();
			manager.remove(user);
			transaction.commit();
			System.out.println("User removed successfully");
		} else {
			System.out.println("User id does not exist");
		}
	}
	
	public static void findUser() {
		System.out.println("Enter the user id: ");
		int id = sc.nextInt();

		UserInfo user = manager.find(UserInfo.class, id);
		
		if(user!=null) {
			System.out.println("Id: "+user.getUserId());
			System.out.println("Name: "+user.getUserName());
			System.out.println("Email: "+user.getEmail());
			System.out.println("Password: "+user.getPassword());
		}else {
			System.out.println("User id does not exist");
		}
	}
	
	public static void displayAll() {
		String qy="select u from UserInfo u";
		Query query=manager.createQuery(qy);
		
		List<UserInfo> userList= query.getResultList();
		
		if(userList!=null) {
			for(UserInfo user:userList) {
				System.out.println("Id: "+user.getUserId());
				System.out.println("Name: "+user.getUserName());
				System.out.println("Email: "+user.getEmail());
				System.out.println("Password: "+user.getPassword());
				System.out.println();
			}
		} else {
			System.out.println("No data is available in the database");
		}
	}
}
