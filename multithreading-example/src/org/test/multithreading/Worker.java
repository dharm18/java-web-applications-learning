package org.test.multithreading;

import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

import com.google.gson.Gson;
import com.test.MakeAPICall;
import com.test.Quote;

public class Worker {

	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	private Random random = new Random();
	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();
	
	public  void stageOne(){
		Worker a = new Worker();
		synchronized(lock1){
			try {
				/*MakeAPICall m = new MakeAPICall();
				String reponse = m.makeHttpGetCall("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en", "");
				System.out.println(reponse);*/
				//a.createPopup(reponse);
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
	}
	
	public synchronized void stageTwo(){
		synchronized(lock2){
			try {
				/*MakeAPICall m = new MakeAPICall();
				System.out.println(m.makeHttpGetCall("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en", ""));*/
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}
	
	public void process(){
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}
	
	private void start(){
		System.out.println("starting......");
		long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println("list1 = " + list1.size() + " list2 = " + list2.size());
	}
	
	public static void main(String[] args) throws IOException {
		Worker a = new Worker();
		//a.start();
		MakeAPICall m = new MakeAPICall();
		String reponse = m.makeHttpGetCall("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en", "");
		System.out.println(reponse);
		Quote quote = new Gson().fromJson(reponse,Quote.class);
		a.createPopup(quote.getQuoteText(),quote.getQuoteAuthor());
	}
	
	private void createPopup(String txt,String txt2){
		
		 if (SystemTray.isSupported()) {
	            try {
					displayTray(txt,txt2);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        } else {
	            System.err.println("System tray not supported!");
	        }
	}
	 public void displayTray(final String txt,final String txt2) throws AWTException, java.net.MalformedURLException {
	        //Obtain only one instance of the SystemTray object
		 Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				SystemTray tray = SystemTray.getSystemTray();

		        //If the icon is a file
		        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
		        //Alternative (if the icon is on the classpath):
		        //Image image = Toolkit.getToolkit().createImage(getClass().getResource("icon.png"));
		        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
		        //Let the system resizes the image if needed
		        trayIcon.setImageAutoSize(true);
		        //Set tooltip text for the tray icon
		        trayIcon.setToolTip("System tray icon demo");
		        try {
					tray.add(trayIcon);
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        trayIcon.displayMessage(txt2, txt, MessageType.INFO);
		        
		        try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	        
	 }
	
}
