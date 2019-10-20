package com.neebal.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neebal.domain.DatabaseName;

public class GetDbName {
	Connection con;
	public GetDbName(){
		 try{
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root", "");
		 }
		 catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<DatabaseName> getDatabaseName(){
		List<DatabaseName> li=new ArrayList<DatabaseName>();
		DatabaseMetaData dm;
		try {
			dm = con.getMetaData();
			ResultSet rs=dm.getCatalogs();
	        while(rs.next())
	        {	
	        	DatabaseName dbname=new DatabaseName();
	        	dbname.setName(rs.getString("TABLE_CAT"));
	        	li.add(dbname);
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
       return li;
	}
}
