package com.neebal.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
    Connection con;
    public test(){
            }
    
    public void printDbnames(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root", "");
            
            DatabaseMetaData dm=con.getMetaData();
            ResultSet rs=dm.getCatalogs();
            while(rs.next())
            {
                System.out.println(rs.getString("TABLE_CAT"));
            }
            }
            catch(Exception e){
                System.out.println("Error in connection" + e);
            }
        finally{
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        
    }
    public void printtable(String dbname)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname,"root", "");
            
            String catalog = con.getCatalog();
            String schema = "test"; // name of the database
            String[] types = { "TABLE" };
                   DatabaseMetaData dmd = (DatabaseMetaData) con.getMetaData();
                   ResultSet rset = dmd.getTables(catalog, schema, null, types);
                   while (rset.next()) {
                     System.out.println(rset.getString(3));
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

        
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        test t=new test();
       // t.printDbnames();
        t.printtable("practice");
    }

}