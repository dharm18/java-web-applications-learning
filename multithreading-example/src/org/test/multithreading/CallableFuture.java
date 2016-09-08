package org.test.multithreading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFuture {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		Future<Integer> future = executorService.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				
				System.out.println("Started Executing.");
				Random random = new Random();
				int duration = random.nextInt(4000);
				
				if(duration > 2000)
					throw new Exception("too much time to run");
				
				Thread.sleep(duration);
				
				System.out.println("Random number generated = " + duration);
				
				System.out.println("Done Executing.");
				return duration;
			}
		});

		executorService.shutdown();
		
		try {
			System.out.println("Future response = " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
