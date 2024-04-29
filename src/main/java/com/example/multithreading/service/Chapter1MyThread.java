package com.example.multithreading.service;

/**
 * 
 * CHAPTER 1
 * 
 * First we created 2 classes Hi & Hello. Both have a method show(); It prints Hi & Hello resp.
 * We create objects of these class and call show. It print Hi 5 times then Hello 5 times.
 * 
 * It means only 1 thread is working on it, its called the main thread so its happening synchronously. 
 * 
 * Now if we want to print Hi Hello Hi HEllo... then we need to create 2 threads. 
 * 
 * I tried to create 2 threads by calling Thread t1 = new Thread(); That didnt work.
 * 
 * So we made both Hi & Hello class extend Thread class and then called start() method instead of show()
 * 
 * That also didnt work. It was still printing synch.
 * 
 * So we renamed show() to run(). And we called these obj run method. It works now. 
 * 
 * Now instead of making these classes extend we can also use interface bcos in case my class wants to extend another class A
 * But it is already extending Thread class, then it cant extend more. (cos no multiple inheritance.) So instead we will implement
 * RUNNABLE interface .
 * 
 * 
 */
public class Chapter1MyThread {
	
	public static void main(String[] args) {
		
		Hi3 hi = new Hi3();
		Hello3 hello = new Hello3();

		//hi.show();
		//hello.show();
		
		hi.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hello.start();
		
		
		// JUST FYI, hi.run() is not the same as hi.start(). Bcos start will start the thread but run will run method notmally.
		
		//Thread t1 = new Thread();
//		Thread t2 = new Thread();
		
//		t1.start();
//		t2.start();
		
/* LOOKUP SCHEDULER*/
		
		
		
	}
}

class Hi3 extends Thread{
	
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


class Hello3 extends Thread {
	
	 public void run() {
		
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
