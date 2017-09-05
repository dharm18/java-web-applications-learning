package org.dharam.logviewer.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class LogViewerController
 */
@WebServlet("/logViewer.htm")
public class LogViewerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String FILE_TO_WATCH = "D:/Dharam";
    //private static final String FILE_TO_WATCH = "/app/apache-tomcat-7.0.70/logs";
    public LogViewerController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final File logsDir = new File(FILE_TO_WATCH);
        if (logsDir.exists() && logsDir.isDirectory()) {
            File[] logs = logsDir.listFiles();
            List<String> files = new ArrayList<String>();
            for (File file : logs) {
				files.add(file.getName());
			}
            response.getWriter().append(new Gson().toJson(files));
        } else {
            System.out.println("either logsDir doesn't exist or is not a folder");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
