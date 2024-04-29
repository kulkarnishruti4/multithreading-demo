package com.example.multithreading.service;


/**
 * 
 * CHAPTER 4 
 * 
 * I want to print "bye" after my hi,hello is printed. But when I put sysout(bye) at the end, bye is print right in the beginning??
 * 
 * Bcos t1 & t2 are executing hi & hello resp. But what is main thread doing? Nothing. So it picks up that task!!!!
 * 
 * So how to print bye? Here comes join() method. This will make main thread wait.
 * 
 * Join will wait for t1 & t2 to join then it will continue execution
 * 
 * isAlive() is a methos using which u can detect if your thread is alive 
 * Once threads job is done it will die.
 * 
 */
public class Chapter4JoinAndIsAliveMethods {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(() -> {
			for(int i=0; i<5;i++) {
				System.out.println("Hi");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}); 
		
		
		Thread t2 = new Thread(() -> {
			for(int i=0; i<5;i++) {
				System.out.println("Hello");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
	});
		
		
		t1.start();
			Thread.sleep(10);
		t2.start();
		
	//	System.out.println("bye");
		
		System.out.println("Is t1 alive????" + t1.isAlive());
		
		t1.join();
		t2.join();
		
		System.out.println("Is t1 alive????" + t1.isAlive());
		
		System.out.println("bye");
		
		System.out.println("Is t1 alive????" + t1.isAlive());
	}

}
