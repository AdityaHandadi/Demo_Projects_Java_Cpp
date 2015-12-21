package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertRec {

	//Step 1
	static final String USER = "root";
	static final String PASS = "";
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	
	public static void main(String args[]){
		Connection conn = null;
		Statement stmt = null;
		
		try{
			//Step 2
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to the selected DB....");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connected successfully ,");
			
			stmt= conn.createStatement();
			
			String sql = "INSERT INTO product VALUES (10,'abd')";
			stmt.executeUpdate(sql);
			
			//String sql2 = "INSERT INTO product VALUES (8,'def')";
			//stmt.executeUpdate(sql2);
			
			//UPDATE `test`.`product` SET `desc`='fff3' WHERE `id`='2';
			String sql3 = "UPDATE `test`.`product` SET `desc`='fff3' WHERE `id`='2'";
			stmt.executeUpdate(sql3);
			
			String sql4 = "DELETE from `test`.`product` where `id`=3";
			stmt.executeUpdate(sql4);
			
			System.out.println("Data Entered Successfully");
			
			String sql5 = "SELECT id,desc from product where id > 2";
			ResultSet rs = stmt.executeQuery(sql5);
			
			while(rs.next()){
				int id= rs.getInt("id");
				String desc = rs.getString("desc");
				System.out.println("ID: "+id+" DESC:"+desc);
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
