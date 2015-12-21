package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.model.LoginVO;

public class LoginDao {
	
	static final String USER = "root";
	static final String PASS = "";
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/maps";

	public String loginCheck(LoginVO loginVO){
		Connection conn = null;
		Statement stmt = null;
		String msg = "";
		
		String retLoginId = "";
		String retLoginPwd = "";
		
		if(loginVO!=null && loginVO.getLoginId()!= null){
			try{
				
				Class.forName(JDBC_DRIVER);
				System.out.println("Connecting to the selected DB....");
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				System.out.println("Connected successfully ,");
				stmt= conn.createStatement();
				
				String condition = " where `email`='"+loginVO.getLoginId()+"' and password ='"+loginVO.getPassword()+"'";
				
				String query = "select * from `maps`.`register`"+condition;
				
				System.out.println("@LoginDao Query :> "+ query);
				ResultSet rs = stmt.executeQuery(query);
				
				if(rs.first()){
					rs.previous();
					while(rs.next()){
						
						retLoginId = rs.getString("email");
						retLoginPwd = rs.getString("password");
						
						System.out.println(retLoginId);
						System.out.println(retLoginPwd);
						
						msg = "success";
					}
				}
				else{
					System.out.println("Login Not found :");
					msg ="fail";
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
			
		return msg;
		
	}

	
	public String adminCheck(LoginVO loginVO){
		Connection conn = null;
		Statement stmt = null;
		String msg = "";
		
		String retLoginId = "";
		String retLoginPwd = "";
		
		if(loginVO!=null && loginVO.getLoginId()!= null){
			try{
				
				Class.forName(JDBC_DRIVER);
				System.out.println("Connecting to the selected DB....");
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				System.out.println("Connected successfully ,");
				stmt= conn.createStatement();
				
				String condition = " where `Adminemail`='"+loginVO.getLoginId()+"' and password ='"+loginVO.getPassword()+"'";
				
				String query = "select * from `maps`.`admin`"+condition;
				
				System.out.println("@LoginDao Query :> "+ query);
				ResultSet rs = stmt.executeQuery(query);
				
				if(rs.first()){
					rs.previous();
					while(rs.next()){
						
						retLoginId = rs.getString("Adminemail");
						retLoginPwd = rs.getString("password");
						
						System.out.println(retLoginId);
						System.out.println(retLoginPwd);
						
						msg = "success";
					}
				}
				else{
					System.out.println("Login Not found :");
					msg ="fail";
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
			
		return msg;
		
	}

}
