package com.example.multithreading.service;


/**
 * 
 * CHAPTER 6
 * 
 * 
 * we have a class Counter which has method increment which increments count!
 * Lets call this in main().
 * We call c.increment() once output is Count: 1
 * we call it 10000 times then count is 10000.
 * 
 * Now we can do this by creating 2 threads which will count 5000 times each.
 * 
 * We created t1 & looped it to run 1000 times but when i run it, count is still 0 ????
 * 
 * bcos while my thread t1 is working correctly, main thread has nothing to do so it goes ahead and prints the count
 * which is 0 initially. If you run this multiple times cont, u can see count changing.
 * 
 * To stop this from happening, to stop main thread , we can ask it to wait for t1 to complete implementation. 
 * t1.join() does the job as shown before. 
 * 
 * lets create t2 now and do the same. t2.start & t2.join
 * 
 * BUT now even tho we incremented 2000 times with 2 threads, count is not 2000!!!
 * 
 * count is randomly below 2000???
 * 
 * somewhere by the time t1 is adding the value, t2 has also fetched the count value at the same time!!
 * example: somewhere at 600, both t1 & t2 incremented and instead of becoming 602, it became 601.
 * 
 * ROOT CAUSE - both threads using same method at the time.
 * 
 * how to stop t1 & t2 from interfering with eachother?? By making the method SYNCHRONIZED!!!!!
 * 
 * Our class was NOT THREAD SAFE so we made the method synchronized to make it thread safe
 * 
 */
public class Chapter6SynchronizedKeyword {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Counter c = new Counter();
	//	c.increment();
		
		//System.out.println("Count: " + c.count);
		
		Thread t1 = new Thread(  ()  ->  {
			
			for(int i=0; i<1000; i++) {
				c.increment();
			}
			
		});
		
		Thread t2 = new Thread(  ()  ->  {
			
			for(int i=0; i<1000; i++) {
				c.increment();
			}
			
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Count: " + c.count);
	}
	

}

class Counter {
	
	int count;
	
	public synchronized void increment() {
		count++;
	}
}
