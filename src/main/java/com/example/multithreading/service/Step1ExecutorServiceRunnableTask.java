package com.example.multithreading.service;

public class Step1ExecutorServiceRunnableTask implements Runnable{
	
	
	public void run() {
		
		for(int i=0; i<10; i++) {
			System.out.println("Hi");
		}
	}

}
