package com.example.multithreading.service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Step5ExecutorServiceMultipleCallableThreads {
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		//lets call multiple tasks
		
		ExecutorService es = Executors.newFixedThreadPool(5);
		
		Long startTime = System.currentTimeMillis();
		
		List<Step3ExecutorServiceCallableTask> tasks = 
				
				List.of(new Step3ExecutorServiceCallableTask("India"), new Step3ExecutorServiceCallableTask("Home"), 
				new Step3ExecutorServiceCallableTask("You"), new Step3ExecutorServiceCallableTask("Shruti"), 
				new Step3ExecutorServiceCallableTask("Harsh"), new Step3ExecutorServiceCallableTask("Nice"), 
				new Step3ExecutorServiceCallableTask("boy"), new Step3ExecutorServiceCallableTask("girl"), 
				new Step3ExecutorServiceCallableTask("to all"), new Step3ExecutorServiceCallableTask("to you"));
		
		
		//es.submit(new Step3ExecutorServiceCallableTask("Home"));
		
		List<Future<String>> resultList =  es.invokeAll(tasks);
		
		for(Future<String> f : resultList)
			System.out.println(f.get());
		
		Long endTime = System.currentTimeMillis();
		
		System.out.println(endTime - startTime);
		
		es.shutdown();
		
	}
	

}
