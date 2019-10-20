package com.neebal;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neebal.domain.DbTable;
import com.neebal.domain.UserLoginData;
import com.neebal.service.DbConnect;

/**
 * Servlet implementation class DbConnectServlet
 */
@WebServlet("/DbConnectServlet")
public class DbConnectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DbConnectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dbname=request.getParameter("dname");
		String user=request.getParameter("username");
		String pass=request.getParameter("pass");
		
		DbConnect dbconnect=new DbConnect();
		List<DbTable> dbtable=dbconnect.getTables(dbname,user,pass);
		//System.out.println(dbtable); need to be validated if no result is returned.
		if(!dbtable.isEmpty()){
			UserLoginData uld=new UserLoginData();
			uld.setDbname(dbname);
			uld.setUsername(user);
			uld.setPass(pass);
			
			HttpSession session=request.getSession();
			session.setAttribute("loggedindb",uld);
			request.setAttribute("table", dbtable);
			RequestDispatcher rd=request.getRequestDispatcher("/dbhome.jsp");
			//RequestDispatcher rd=request.getRequestDispatcher("/header.jsp");
			rd.forward(request, response);
		}
		else
		{
			response.sendRedirect("/minixampp/GetDbNameServlet");
		}
		
	}

}
