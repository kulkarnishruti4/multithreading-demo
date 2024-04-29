package com.example.multithreading.service;


/**
 * 
 * CHAPTER 5
 * 
 * Print thread names by getName()!!!!!
 * By default first thread will be Thread-0
 * We can also set our own name to thread by setName()
 * Thread names are important in big applications where we might forget what t1 & t2 is
 * 
 * We can also check the priority of thread.
 * Initially when I print t1.getPriority() & t2.getPriority(), both will have priority 5!!!
 * 
 * 1- least priority
 * 10- highest priority
 * 5- default/normal priority
 */
public class Chapter5MyThreadNameAndPriority {
	
	
	
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
						e.printStackTrace();
					}
			}
	});
		
		t1.setName("Hi Thread");
		t2.setName("Hello Thread");
		
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		
		t1.start();
		Thread.sleep(10);
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("bye");
		
		
		// Thread Constructor - Runnable Object & name - So we can give a name while initializing thread also!!!!
		
		Thread t3 = new Thread(() -> {
			for(int i=0; i<5;i++) {
				System.out.println("Hello");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
	}, "Third-Thread");
		
		System.out.println(t3.getName());
		
		
		// Priority
		
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(t3.getPriority());
		
		
		t1.setPriority(1); 
		// OR
		t1.setPriority(Thread.MIN_PRIORITY);
		
		t2.setPriority(10);
		//OR
		t2.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(t3.getPriority());
		
		// It will not get printed now since its already dead
		
	}

}
