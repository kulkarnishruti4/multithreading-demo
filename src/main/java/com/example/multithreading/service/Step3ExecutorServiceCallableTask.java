package com.example.multithreading.service;

import java.util.concurrent.Callable;

public class Step3ExecutorServiceCallableTask implements Callable<String>{
	
	
	private String name;

	public Step3ExecutorServiceCallableTask(String name) {
		this.name = name;
	}
	
	@Override
	public String call() throws InterruptedException {
		Thread.sleep(500);
		return "Welcome " + name;
		
	}

}
