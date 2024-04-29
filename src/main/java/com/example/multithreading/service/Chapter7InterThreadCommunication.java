package com.example.multithreading.service;


/**
 * 
 * CHAPTER 7
 * 
 * 
 * We create a class X with set & get of a number which we will increment in upcoming classes.
 * 
 * We then created 2 classes, producer & consumer. Producer will keep calling set() method to keep changing num value 
 * and consumer will keep on getting latest num value. 
 * 
 * When we create 2 new Producer & consumer and print the outcome, we can see some anomalies.
 * 
 * PUT: 0
GET: 0
GET: 0
PUT: 1
PUT: 2
GET: 1
PUT: 3
 * 
 * its not always putting and getting correct incremented values. 
 * 
 * 
 * We need Consumer & Producer to run once one after another in tandem.
 * 
 * 
 * to achieve that we can make a boolean variable to keep track of that and ask it to wait()
 * then it will wait for consumer to consume once it has incremented.
 * 
 * Once it has consumer, it needs to notify() the thread that it can start again !!!! 
 * 
 * 
 * When we called wait() & notify() we didnt need to use Thread class bcos wait() & notify() belong to object class
 * 
 * bcos thread is waiting for an object.
 * 
 * 
 */
public class Chapter7InterThreadCommunication {
	
	
	public static void main(String[] args) {
		
		
		X x = new X();
		
		new Producer(x);
		
		new Consumer(x);
		
	}

}

//class X {
//	
//	int num;
//	
//	void set(int num) {
//		
//		System.out.println("PUT: "  +num);
//		this.num = num;
//	}
//	
//	void get() {
//		System.out.println("GET: "  +num);
//	}
//	
//}


class X {
	
	int num;
	
	boolean valueSet = false;
	
	public synchronized void set(int num) {
		
		
		while(valueSet) {
			try { 
				
				wait(); 
				
			} catch(Exception e) {}
		}
		
		System.out.println("PUT: "  +num);
		this.num = num;
		
		valueSet = true;
		
		notify();
	}
	
	public synchronized void get() {
		
		while(!valueSet) {
			
			try { 
				
				wait(); 
				
			} catch(Exception e) {}

		}
		
		System.out.println("GET: "  +num);
		
		valueSet = false;
		
		notify();
	}
	
}


class Producer implements Runnable {
	
	X x;
	
	Producer (X x) {
		this.x = x;
		Thread t = new Thread(this,"Producer-thread");
		t.start();
	}

	@Override
	public void run() {
		int i=0;
		while(true) {
			x.set(i++);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}


class Consumer implements Runnable {
	
	X x;
	
	Consumer(X x) {
		this.x=x;
		Thread t = new Thread (this, "Consumer-thread");
		t.start();
	}

	@Override
	public void run() {
		
		while(true) {
			
			x.get();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}

