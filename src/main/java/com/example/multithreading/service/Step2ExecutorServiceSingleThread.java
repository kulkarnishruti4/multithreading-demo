package com.example.multithreading.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Step2ExecutorServiceSingleThread {
	
	
	public static void main(String[] args) {
		
		
		ExecutorService es = Executors.newSingleThreadExecutor();
		
		es.execute(new Step1ExecutorServiceRunnableTask());
		
		es.execute(new Thread( () -> {
			System.out.println("I am here now!");
		}));
		
		es.execute(new Thread( () -> {
			System.out.println("Executed task 3!");
		},"thread03"));
		
		es.shutdown();
		
		//we can see all tasks are executed one by one
	}
	

}
