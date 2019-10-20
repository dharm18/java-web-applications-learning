package com.neebal.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neebal.domain.DbTable;

public class DbConnect {
	Connection con;
	public List<DbTable> getTables(String dbname,String user,String pass){
		List<DbTable> li=new ArrayList<DbTable>();
		try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname,user,pass);
            
            String catalog = con.getCatalog();
            String schema = "test"; // name of the database
            String[] types = { "TABLE" };
                  
            DatabaseMetaData dmd = (DatabaseMetaData) con.getMetaData();
                   ResultSet rset = dmd.getTables(catalog, schema, null, types);
                   while (rset.next()) {
                     DbTable dbtable=new DbTable(); 
                     dbtable.setTname(rset.getString(3));
                     li.add(dbtable);
                   }
        } catch (SQLException | ClassNotFoundException e) {
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
