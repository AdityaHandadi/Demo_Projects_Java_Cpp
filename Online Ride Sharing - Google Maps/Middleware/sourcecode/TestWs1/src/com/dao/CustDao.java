package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.CustVO;
import com.model.EmailData;
import com.model.NotifyVO;

public class CustDao {
	
	static final String USER = "root";
	static final String PASS = "";
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/maps";
	
	public String saveCust(CustVO custVO){
		
		Connection conn = null;
		PreparedStatement prst;
		String msg = "";
		Statement stmt = null;
		
		
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to the selected DB....");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connected successfully ,");
			stmt = conn.createStatement();
	
			String query = "insert into customer (`email`,`routeid`,`sourcelocation`,`destinationloc`,`ridedate`) values (?,?,?,?,?)";
			prst = conn.prepareStatement(query);
			
			//prst.setLong(1, custVO.getCustrouteId());
			prst.setString(1, custVO.getEmail());
			prst.setLong(2, custVO.getRouteId());
			prst.setString(3, custVO.getSourceLoc());
			prst.setString(4, custVO.getDestLoc());
			
			String custDT ="";
			
			if(custVO.getRideDate()!=null){
				String[] str = custVO.getRideDate().split("T");
				custDT = str[0]+" "+str[1]+":00.0";
			}
			prst.setString(5, custDT);
			
			int count = prst.executeUpdate();
			System.out.println("Noof recs inserted :"+count);
			
			//UPDATE RIDER DB
			String query2 = "select seatlimit from rider where routeid = "+custVO.getRouteId();
			System.out.println("@CustDao query-->"+query2);
			ResultSet rs = stmt.executeQuery(query2);
			int seatLimit = 0;
			while(rs.next()){
				seatLimit = rs.getInt("seatlimit");
			}
			String query3 = "update rider set seatlimit = "+--seatLimit+" WHERE routeid = "+custVO.getRouteId();
			stmt.execute(query3);
			System.out.println("@CustDao query-->"+query3);
			
			msg="success";
			
			
		}catch(Exception e){
			e.printStackTrace();
			msg="fail";
		}
		
		return msg;
	}
	

	public List<CustVO> getSpecificRider(String emailId){
		Connection conn = null;
		Statement stmt = null;
		
		List<CustVO> custList = new ArrayList<CustVO>();
		
		try{
			

			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to the selected DB....");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connected successfully ,");
			stmt= conn.createStatement();
			Statement stmt2 = conn.createStatement();
	
			String condition = " WHERE email = '"+emailId+"' ";
			
			String query = "select * from `maps`.`customer`"+condition;
			
			System.out.println("@RiderDao Query :> "+ query);
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				CustVO customer = new CustVO();
				customer.setEmail(rs.getString("email"));
				
				String ridetime = rs.getString("ridedate");
				ridetime = ridetime.substring(0, ridetime.length()-5);
				customer.setRideDate(ridetime);
				customer.setSourceLoc(rs.getString("sourcelocation"));
				customer.setDestLoc(rs.getString("destinationloc"));
			
				custList.add(customer);
			}
		
		rs.close();
		stmt.close();
		stmt2.close();
		conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return custList;
	}

	
	
public String advanceBook(CustVO custVO){
		
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement prst;
		String msg = "";
		//Statement stmt = null;
		
		
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to the selected DB....");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connected successfully ,");
			//stmt = conn.createStatement();
			
			
			//stmt= conn.createStatement();
			String query = "insert into advancedbooking (`email`,`routeid`,`sourcelocation`,`destinationloc`,`ridedate`) values (?,?,?,?,?)";
			prst = conn.prepareStatement(query);
			
			//prst.setLong(1, custVO.getCustrouteId());
			prst.setString(1, custVO.getEmail());
			prst.setLong(2, custVO.getRouteId());
			prst.setString(3, custVO.getSourceLoc());
			prst.setString(4, custVO.getDestLoc());
			
			String custDT ="";
			
			if(custVO.getRideDate()!=null){
				String[] str = custVO.getRideDate().split("T");
				custDT = str[0]+" "+str[1]+":00.0";
			}
			prst.setString(5, custDT);
			
			int count = prst.executeUpdate();
			System.out.println("Noof recs inserted :"+count);
			
			
			msg="success";
			
			
		}catch(Exception e){
			e.printStackTrace();
			msg="fail";
		}
		
		return msg;
	}


public List<EmailData> notifyEmails(NotifyVO notify){
	Connection conn = null;
	Statement stmt = null;
	
	List<EmailData> emailList = new ArrayList<EmailData>();
	
	try{
		Class.forName(JDBC_DRIVER);
		System.out.println("Connecting to the selected DB....");
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		System.out.println("Connected successfully ,");
		stmt= conn.createStatement();
		
		String riderSrc = notify.getSource();
		String riderDest = notify.getDestination();
		
		String custDT ="";
		
		if(notify.getDateTime()!=null){
			String[] str = notify.getDateTime().split("T");
			custDT = str[0]+" "+str[1]+":00.0";
		}
		
		String condition = " WHERE sourcelocation='"+riderSrc+"' AND destinationloc = '"+riderDest+"' ";
		String condition2 = " AND DATE_SUB(ridedate,INTERVAL '01:00' HOUR_MINUTE) <= '"+custDT+"'"+
				" AND DATE_ADD(ridedate,INTERVAL '01:00' HOUR_MINUTE) >= '"+custDT+"' ";
		
		String 	query = " select * from `maps`.`advancedbooking` "+condition+condition2;
		
		System.out.println("@RiderDao Query :> "+ query);
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
			String email = rs.getString("email");
			EmailData emailData = new EmailData();
			emailData.setEmail(email);
			emailList.add(emailData);
		}
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
	return emailList;
}

}
