package org.test.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class NProcessor implements Runnable{

	private java.util.concurrent.CountDownLatch latch;
	public NProcessor(java.util.concurrent.CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		System.out.println("Starting...");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed.");
		latch.countDown();
	}
	
}

public class CountDownLatch {

	public static void main(String[] args) {
		
		java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(3);
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		for (int i = 0; i < 3; i++) {
			executorService.submit(new NProcessor(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("All jobs are done.");
	}

}

