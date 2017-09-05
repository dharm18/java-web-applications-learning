package org.dharam.logviewer.websocket;

import java.io.*;
import java.util.*;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;

@ServerEndpoint("/fetchlogs")
public class LogViewerSocket implements LogFileTailerListener {

	//private List<String> watchableLogs = null;
	private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
	private static final String FILE_TO_WATCH = "D:\\Dharam";
	//private static final String FILE_TO_WATCH = "/app/apache-tomcat-7.0.70/logs";
	private LogFileTailer tailer;
	public LogViewerSocket() {
		/*final File logsDir = new File(FILE_TO_WATCH);
		System.out.println(logsDir.exists());
		System.out.println(logsDir.isDirectory());
		if (logsDir.exists() && logsDir.isDirectory()) {
			File[] logs = logsDir.listFiles();
			for (File file : logs) {
				watchableLogs.add(file.getName());
			}
		} else {
			System.out.println(">>>>>>>>>>either logsDir doesn't exist or is not a folder");
		}*/
	}
	
	/*static {
		final LogViewerSocket l = new LogViewerSocket();
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Random r = new Random();
				while(r.nextInt(100000) != 0)
					l.newLogFileLine(r.nextInt(100000)+"");
			}
		});
		
		t.start();
		
	}*/
	

	@OnMessage
	public void onMessage(Session session, String message) {
		
		try {   
			System.out.println("received msg "+message+" from "+session.getId());
			/*if(message != null){
				tailer = new LogFileTailer( new File(FILE_TO_WATCH + File.separator + message ), 1000, false );
				tailer.addLogFileTailerListener( this );
				tailer.start();
			}
			else{
				System.out.println("file name is null");
			}
				System.out.println("asdasdadsa");*/
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@OnOpen
	public void onOpen(Session session) throws IOException, EncodeException {
		sessions.add(session);
		System.out.println("New session opened: " + session.getId());
		
		/*watchableLogs = Collections.synchronizedList(new LinkedList<String>());
		final File logsDir = new File(FILE_TO_WATCH);
		if (logsDir.exists() && logsDir.isDirectory()) {
			File[] logs = logsDir.listFiles();
			for (File file : logs) {
				watchableLogs.add(file.getName());
			}
		} else {
			System.out.println(">>>>>>>>>>either logsDir doesn't exist or is not a folder");
		}*/
		
		//session.getBasicRemote().sendText(new Gson().toJson(watchableLogs));
		
		
	}

	@OnClose
	public void onClose(Session session) throws IOException, EncodeException {
		System.out.println("session closed: " + session.getId());
		sessions.remove(session);
	}

	@OnError
	public void error(Session session, Throwable t) {
		sessions.remove(session);
		System.err.println("Error on session " + session.getId());
		System.out.println(t);
	}
	

	@Override
	public void newLogFileLine(String line) {
		System.out.println("aaaaaa");
		try {
		List<Session> closedSessions = new ArrayList<Session>();
		
			for (Session openSession : sessions) {
				if(!openSession.isOpen()){
					System.err.println("Closed Session: "+openSession.getId());
					closedSessions.add(openSession);
				}
				else{
					System.out.println("open session -----> " + openSession);
					openSession.getBasicRemote().sendText(line);
				}
			}
			
			sessions.removeAll(closedSessions);
			System.out.println("Sending msg to "+sessions.size()+" clients");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
