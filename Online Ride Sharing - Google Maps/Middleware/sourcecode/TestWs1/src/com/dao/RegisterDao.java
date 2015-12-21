package com.dao;

import com.model.RegisterVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegisterDao {
	
	//Step 1
			static final String USER = "root";
			static final String PASS = "";
			
			static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
			static final String DB_URL = "jdbc:mysql://localhost:3306/maps";
			
			public String registerRec(RegisterVO regVO){
				Connection conn = null;
				//Statement stmt = null;
				PreparedStatement prst;
				String msg = "";
				
				//System.out.println(regVO.getEmail().length());
				
				if(regVO.getEmail()!=null && !(regVO.getEmail().isEmpty()) && regVO.getEmail().length() > 5){
				
							try{
								//Step 2
								Class.forName(JDBC_DRIVER);
								System.out.println("Connecting to the selected DB....");
								conn = DriverManager.getConnection(DB_URL,USER,PASS);
								System.out.println("Connected successfully ,");
								
								
								//stmt= conn.createStatement();
								String query = "insert into register (`fname`,`lname`,`email`,`password`,`purpose`) values (?,?,?,?,?)";
								prst = conn.prepareStatement(query);
								
								System.out.println(query);
								
								prst.setString(1, regVO.getFname());
								prst.setString(2, regVO.getLname());
								prst.setString(3, regVO.getEmail());
								prst.setString(4, regVO.getPassword());
								prst.setString(5, regVO.getUserType());
								
								int count = prst.executeUpdate();
								System.out.println("Noof recs inserted :"+count);
								
								msg="success";
							}
							catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ive){
								ive.printStackTrace();
								msg="emailExist";
							}
							catch(Exception e){
								e.printStackTrace();
								msg="fail";
							}
						
				}
				else{
					System.out.println("EMail field invalid");
					msg="noemail";
				}
				return msg;
			}
	

}
