package com.neebal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neebal.domain.ColumnData;
import com.neebal.domain.UserLoginData;
import com.neebal.service.GetDataModel;

/**
 * Servlet implementation class DisplayTableServlet
 */
@WebServlet("/DisplayTableServlet")
public class DisplayTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayTableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String table=request.getParameter("table");
		HttpSession session=request.getSession();
		UserLoginData uld=(UserLoginData) session.getAttribute("loggedindb");
		GetDataModel gdm=new GetDataModel(uld.getDbname(),uld.getUsername(),uld.getPass());
		List<ColumnData> data=gdm.getData(table);
		List<ColumnData> header=gdm.getHeader(table);
		session.setAttribute("tabledata", data);
		//List list=new ArrayList();
		//list.add(header);
		//list.add(data);
		request.setAttribute("showtable", header);
		
		RequestDispatcher rd=request.getRequestDispatcher("/tabledetails.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
