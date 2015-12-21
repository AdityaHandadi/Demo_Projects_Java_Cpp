package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PrepStatement {

	//Step 1
		static final String USER = "root";
		static final String PASS = "";
		
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://localhost:3306/test";
		
		public static void main(String args[]){
			Connection conn = null;
			//Statement stmt = null;
			PreparedStatement prst;
			
			try{
				//Step 2
				Class.forName(JDBC_DRIVER);
				System.out.println("Connecting to the selected DB....");
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				System.out.println("Connected successfully ,");
				
				//stmt= conn.createStatement();
				String query = "insert into product (`id`,`desc`) values (?,?)";
				prst = conn.prepareStatement(query);
				
				prst.setLong(1, 13);
				prst.setString(2,"Prst");
				
				int count = prst.executeUpdate();
				System.out.println("Noof recs updated"+count);
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
}
