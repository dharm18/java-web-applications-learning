package org.test.multithreading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class IntrruptThreadExample {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Starting ...");
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		Future<?> future = executorService.submit(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				Random random = new Random();
				
				for (int i = 0; i < 1E8; i++) {
					
					if(Thread.currentThread().isInterrupted()){
						System.out.println("Intrrupted.....!");
						break;
					}
					
					Math.sin(random.nextDouble());
				}
				return null;
			}
		});

		executorService.shutdown();

		Thread.sleep(500);
		
		//executorService.shutdownNow(); //kills the managerial thread.
		future.cancel(true); // sets the interrupted flag.
		
		executorService.awaitTermination(1, TimeUnit.DAYS);
		
		System.out.println("Finished ...");
	}

}
