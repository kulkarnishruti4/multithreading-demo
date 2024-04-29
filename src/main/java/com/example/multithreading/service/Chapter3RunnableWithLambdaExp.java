package com.example.multithreading.service;

/**
 * 
 * CHAPTER 3
 * 
 * In previous examples we had class Hi & Hello only for one purpose, which is to implement class Runnable
 * and define run() method. 
 * 
 * So this class will be used only once. Just like anonymous class.
 * 
 * So we can  cut out enitre class Hi & define it inside Runnable initialization itself using lambda expression
 * In Lambda we removed entire part of  "new Runnable @Override run" etc
 * 
 */
public class Chapter3RunnableWithLambdaExp {

	public static void main(String[] args) {
		
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
		
		
		///////////////  ALTERNATIVELY WRITE THE ABOVE w/o LAMBDA LIKE BELOW/////////
		
		
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<5;i++) {
					System.out.println("Hi-t3");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<5;i++) {
					System.out.println("Hello-t4");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t3 = new Thread(r1);  //correct way
		Thread t4 = new Thread(r2);
		t3.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t4.start();
	
	
	
	///////////////  ALTERNATIVELY WRITE THE ABOVE *WITH* LAMBDA LIKE BELOW/////////
	
	
	Runnable r3 = () -> {
			for(int i=0; i<5;i++) {
				System.out.println("Hi-t5");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	};
	
	Runnable r4 = () -> {
			for(int i=0; i<5;i++) {
				System.out.println("Hello-t6");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	};
	
	Thread t5 = new Thread(r3);  //correct way
	Thread t6 = new Thread(r4);
	t5.start();
	try {
		Thread.sleep(10);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	t6.start();
	
	///////////////  ALTERNATIVELY WRITE THE ABOVE WITH LAMBDA WITHOUT RUNNABLE DECLARATION!!!!!! /////////
	
//	
//	Runnable r5 = () -> {
//			for(int i=0; i<5;i++) {
//				System.out.println("Hi");
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//	};
//	
//	Runnable r6 = () -> {
//			for(int i=0; i<5;i++) {
//				System.out.println("Hello");
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//	};
	
	Thread t7 = new Thread(() -> {
		for(int i=0; i<5;i++) {
			System.out.println("Hi-t7");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}); 
	
	
	Thread t8 = new Thread(() -> {
		for(int i=0; i<5;i++) {
			System.out.println("Hello-t8");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
});
	
	
	t7.start();
	try {
		Thread.sleep(10);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	t8.start();
}
	
}

//class Hi4 implements Runnable {
//	 public void run(){
//			
//		for(int i=0; i<5;i++) {
//			System.out.println("Hi");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	
//}

//class Hello4 implements Runnable {
//	 public void run(){
//			
//		for(int i=0; i<5;i++) {
//			System.out.println("Hello");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	
//}

