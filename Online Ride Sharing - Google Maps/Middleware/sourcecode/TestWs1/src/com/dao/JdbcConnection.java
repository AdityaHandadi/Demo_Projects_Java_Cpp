package com.dao;


public class JdbcConnection {
	
	public static void main(String args[]){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			System.out.println("Created DB connection"); 
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
