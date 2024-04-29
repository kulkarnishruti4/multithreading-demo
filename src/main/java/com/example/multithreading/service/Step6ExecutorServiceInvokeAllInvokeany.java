package com.example.multithreading.service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Step6ExecutorServiceInvokeAllInvokeany {

	
	public static void main(String[] args) throws Exception {
		
		
		ExecutorService es  = Executors.newFixedThreadPool(10);
		
List<Step3ExecutorServiceCallableTask> tasks = 
				
				List.of(new Step3ExecutorServiceCallableTask("India"), new Step3ExecutorServiceCallableTask("Home"), 
				new Step3ExecutorServiceCallableTask("You"), new Step3ExecutorServiceCallableTask("Shruti"), 
				new Step3ExecutorServiceCallableTask("Harsh"), new Step3ExecutorServiceCallableTask("Nice"), 
				new Step3ExecutorServiceCallableTask("boy"), new Step3ExecutorServiceCallableTask("girl"), 
				new Step3ExecutorServiceCallableTask("to all"), new Step3ExecutorServiceCallableTask("to you"));
		
		

//		List<Future<String>>  resultList =  es.invokeAll(tasks);
//		
//		for(Future<String> future : resultList)
//			System.out.println(future.get());
//		
		
		String result =  es.invokeAny(tasks);
		
		System.out.println(result);
		
		es.shutdown();
		
	}
	
	
}
