package com.Configuration;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ty")
public class MyConfig {
	
	@Bean(name = "factory")
	public  EntityManagerFactory getEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("vikas");
	}
	
	@Bean(name = "manager")
	public EntityManager getEntityManager() {
		return getEntityManagerFactory().createEntityManager() ;
	}
	
	@Bean(name = "transaction")
	public EntityTransaction getEntityTransaction() {
		return getEntityManager().getTransaction();
	}
	
	@Bean(name = "scanner")
	public static Scanner getScanner() {
		return new Scanner(System.in);
	}
}
