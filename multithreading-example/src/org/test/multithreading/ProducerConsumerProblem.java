package org.test.multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerProblem {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(new Runnable() {
			
			@Override
			public void run() {
				try {
					procedure();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		executorService.submit(new Runnable() {
			
			@Override
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		executorService.shutdown();

		
	}
	
	public static void procedure() throws InterruptedException{
		Random random = new Random();
		while(true) {
			System.out.println("producer");
			queue.put(random.nextInt(100));
		}
	}
	
	public static void consumer() throws InterruptedException {
		Random random = new Random();
		System.out.println("consumer");
		while(true){
			Thread.sleep(100);
			if(random.nextInt(10) == 0){
				Integer value = queue.take();
				System.out.println("Value : " + value + " ; Queue size : " + queue.size() );
			}
		}
	}

}
