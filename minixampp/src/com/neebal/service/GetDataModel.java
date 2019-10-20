package com.neebal.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neebal.domain.ColumnData;
import com.neebal.domain.DbTable;

public class GetDataModel {
	Connection con;
	public GetDataModel(){
		
	}
	public GetDataModel(String dbname,String user,String pass){
		try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname,user,pass);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public List<ColumnData> getHeader(String table){
		List<ColumnData> li=new ArrayList<ColumnData>();
		try {
            String query="select * from "+table;
            PreparedStatement ps;
            
            ps=con.prepareStatement(query);
            //ps.setString(1, table);
            
            System.out.println(query);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
			  int col = md.getColumnCount();
			  System.out.println("Number of Column : "+ col);
			  System.out.println("Columns Name: ");
			  String a[]=new String[col];
			  for (int i = 1; i <= col; i++){
				  String col_name = md.getColumnName(i);
				  System.out.println(col_name);
				  a[i-1]=col_name;
				  ColumnData cd=new ColumnData();
				  cd.setCdata(col_name);
				  li.add(cd);
			  }
		}catch(Exception e){
			e.printStackTrace();
		}
	return li;
	}
	
	public List<ColumnData> getData(String table){
		System.out.println(table);
		List<ColumnData> li=new ArrayList<ColumnData>();
		try {
            String query="select * from "+table;
            PreparedStatement ps;
            
            ps=con.prepareStatement(query);
            //ps.setString(1, table);
            
            System.out.println(query);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
			  int col = md.getColumnCount();
			  System.out.println("Number of Column : "+ col);
			  System.out.println("Columns Name: ");
			  String a[]=new String[col];
			  for (int i = 1; i <= col; i++){
				  String col_name = md.getColumnName(i);
				  System.out.println(col_name);
				  a[i-1]=col_name;
				 // ColumnData cd=new ColumnData();
				 // cd.setCdata(col_name);
				 // li.add(cd);
			  }
			  while(rs.next()){
				
				for (int i = 0; i < col; i++){
				ColumnData cd=new ColumnData();
				cd.setCdata(rs.getString(a[i]));
				System.out.println(rs.getString(a[i]));
				li.add(cd);
			}
				
				  
			}
			return li;
		} catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //finally{
          //  try {
           //     con.close();
           // } catch (SQLException e) {
                // TODO Auto-generated catch block
           //     e.printStackTrace();
           // }
       // }
		return null;
	}
		
	
	
}
