package com.example.multithreading.service;


/**
 * 
 * CHAPTER 2
 * 
 * RUNNABLE is a functional interface with only one method run()
 * Functional Interface means we can use Lambda expression.
 * 
 * So if Runnable doesnt have start() method then from where will start() come??
 * Bcos earlier Thread had start() method.
 * 
 * how to create thread now if hi.start() doesnt exist? so we created Threads t1 & t2.
 * 
 * But now t1.start & t2.start is still not working bcos these threads are still not linked to hi & hello objects. So we 
 * cannot initialise Thread by just new Thread();
 * 
 * 
 * 
 */
public class Chapter2MyThreadImplementsRunnable {

	public static void main(String[] args) {
		
//		Hi4 hi = new Hi4();
//		Hello4 hello = new Hello4();
//		
//		Thread t1 = new Thread();
//		Thread t2 = new Thread();
//		t1.start();
//		t2.start();
		
		
		Runnable hi = new Hi4();
		Runnable hello = new Hello4();
		
		Thread t1 = new Thread(hi);  //correct way
		Thread t2 = new Thread(hello);
		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		
		
	}
}

class Hi4 implements Runnable {
	 public void run(){
			
		for(int i=0; i<5;i++) {
			System.out.println("Hi");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class Hello4 implements Runnable {
	 public void run(){
			
		for(int i=0; i<5;i++) {
			System.out.println("Hello");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
