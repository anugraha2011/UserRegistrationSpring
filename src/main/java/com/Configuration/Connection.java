package com.Configuration;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Connection {
	
	@Autowired
	public static EntityManagerFactory factory;
	
	@Autowired
	public static EntityManager manager;
	
	@Autowired
	public static EntityTransaction transaction;
	
	@Autowired
	public static Scanner sc;
	
}
