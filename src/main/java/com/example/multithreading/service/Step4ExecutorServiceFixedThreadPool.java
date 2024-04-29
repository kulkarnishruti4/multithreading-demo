package com.example.multithreading.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Step4ExecutorServiceFixedThreadPool {
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		ExecutorService es = Executors.newFixedThreadPool(5);
		
		Future<String> future =   es.submit(new Step3ExecutorServiceCallableTask("SHRUTI"));
		
		System.out.println("Callable Task Executed");
		
		String result = future.get();
		
		System.out.println(result);
		
		System.out.println("Main Thread Executed");
		
		es.shutdown();
		
	}
	

}
