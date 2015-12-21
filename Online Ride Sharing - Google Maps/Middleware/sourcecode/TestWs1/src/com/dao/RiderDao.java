package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.model.DateTime_;
import com.model.MapLocation;
import com.model.RideVO;
import com.model.RiderVO;
import com.model.Waypoint;

public class RiderDao {
	
	static final String USER = "root";
	static final String PASS = "";
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/maps";
	
	public String saveRide(RideVO rideVO){
		
		Connection conn = null;
		PreparedStatement prst;
		String msg = "";
		
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to the selected DB....");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connected successfully ,");
			
			String query = "insert into rider (`email`,`sourcelocation`,`wp1`,`wp2`,`wp3`,`wp4`,`wp5`,`wp6`,`wp7`,`wp8`,`destinationloc`,`ridedate`,`seatlimit`,`sourcestr`,`deststr`) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			prst = conn.prepareStatement(query);
			
			//prst.setLong(1, rideVO.getRouteId());
			prst.setString(1, rideVO.getEmail());
			prst.setString(2, rideVO.getSource());
			prst.setString(3, rideVO.getWp1());
			prst.setString(4, rideVO.getWp2());
			prst.setString(5, rideVO.getWp3());
			prst.setString(6, rideVO.getWp4());
			prst.setString(7, rideVO.getWp5());
			prst.setString(8, rideVO.getWp6());
			prst.setString(9, rideVO.getWp7());
			prst.setString(10, rideVO.getWp8());
			prst.setString(11, rideVO.getDestination());
			
			prst.setString(12, rideVO.getRideDate());
			prst.setInt(13, rideVO.getRideLimit());
			prst.setString(14, rideVO.getSourceStr());
			prst.setString(15, rideVO.getDestStr());
			
			int count = prst.executeUpdate();
			System.out.println(" Noof recs inserted : "+count);
			
			msg = "success";
			
		}catch(Exception e){
			e.printStackTrace();
			msg = "fail";
		}
		
		return msg;
	}
	
	public String saveRiderObject(RiderVO riderVO){
		
		RideVO rideVO = new RideVO();
		
		MapLocation src = riderVO.getSource();
		MapLocation dest = riderVO.getDestination();
		
		String source = src.getG().toString()+","+src.getK().toString();
		String destination = dest.getG()+","+dest.getK().toString();
		rideVO.setEmail(riderVO.getEmail());
		rideVO.setSource(source);
		rideVO.setDestination(destination);
		
		String[] myWaypoints = new String[8];
		List<Waypoint> waypointList =riderVO.getWaypoints();
		Iterator<Waypoint> it = waypointList.iterator();
		int idx = 0;
		while(it.hasNext()){
			Waypoint waypoint = it.next();
			myWaypoints[idx++] = waypoint.getLocation();
			
		}
		
		rideVO.setWp1(myWaypoints[0]);
		rideVO.setWp2(myWaypoints[1]);
		rideVO.setWp3(myWaypoints[2]);
		rideVO.setWp4(myWaypoints[3]);
		rideVO.setWp5(myWaypoints[4]);
		rideVO.setWp6(myWaypoints[5]);
		rideVO.setWp7(myWaypoints[6]);
		rideVO.setWp8(myWaypoints[7]);
		
		rideVO.setRideLimit(riderVO.getSeatLimit());
		String riderDT ="";
		
		if(riderVO.getDateTime()!=null){
			String[] str = riderVO.getDateTime().split("T");
			riderDT = str[0]+" "+str[1]+":00.0";
		}
		
		rideVO.setRideDate(riderDT);
		System.out.println(riderDT);
	    
	    rideVO.setDestStr(riderVO.getDestStr());
	    rideVO.setSourceStr(riderVO.getSourceStr());
		
		return saveRide(rideVO);
	}
	
	public List<RiderVO> getRiders(DateTime_ dateTime){
		Connection conn = null;
		Statement stmt = null;
		
		List<RiderVO> riderList = new ArrayList<RiderVO>();
		
		try{
			

			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to the selected DB....");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connected successfully ,");
			stmt= conn.createStatement();
			Statement stmt2 = conn.createStatement();
			
			String riderDT ="";
			if(dateTime.getDateTime()!=null){
				String[] str = dateTime.getDateTime().split("T");
				riderDT = str[0]+" "+str[1]+":00.0";
			}
			
			String hour = getHourString(dateTime.getHours());
			
			
			String condition = " WHERE DATE_SUB(ridedate,INTERVAL "+hour+" HOUR_MINUTE) <= '"+riderDT+"'"+
								" AND DATE_ADD(ridedate,INTERVAL "+hour+" HOUR_MINUTE) >= '"+riderDT+"' ";
			String condition2 = " AND seatlimit>0";
			
			String query = "select * from `maps`.`rider`"+condition+condition2;
			
			System.out.println("@RiderDao Query :> "+ query);
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				RiderVO riderVO = new RiderVO();
				
				riderVO.setRouteId(rs.getInt("routeid"));
				riderVO.setEmail(rs.getString("email"));
				
				String sourceStr = rs.getString("sourcelocation");
				String[] source = sourceStr.split(",");
				MapLocation sourceLoc = new MapLocation();
				sourceLoc.setG(Double.valueOf(source[0]));
				sourceLoc.setK(Double.valueOf(source[1]));
				riderVO.setSource(sourceLoc);
				
				String destStr = rs.getString("destinationloc");
				String[] dest = destStr.split(",");
				MapLocation destLoc = new MapLocation();
				destLoc.setG(Double.valueOf(dest[0]));
				destLoc.setK(Double.valueOf(dest[1]));
				riderVO.setDestination(destLoc);
				
				List<Waypoint> waypoints = new ArrayList<Waypoint>();
				int idx = 1;
				while(idx < 9){
					Waypoint waypoint1 = new Waypoint();
					waypoint1.setLocation(rs.getString("wp"+idx));
					if(waypoint1.getLocation()!=null){
						waypoint1.setStopover(true);
						waypoints.add(waypoint1);
					}
					idx++;
				}
				
				//GET FNAME and LNAME is here
				String email = riderVO.getEmail();
				String query2 = "select fname,lname from `maps`.`register` where `email`='"+email+"'";
				System.out.println("@RiderDao Query :> "+ query2);
				ResultSet rs2 = stmt2.executeQuery(query2);
				while(rs2.next()){
					riderVO.setFname(rs2.getString("fname"));
					riderVO.setLname(rs2.getString("lname"));
				}
				rs2.close();
				
				riderVO.setWaypoints(waypoints);
				riderVO.setTravelMode("DRIVING");
				riderVO.setOptimizeWaypoints(true);
				
				String ridetime = rs.getString("ridedate");
				ridetime = ridetime.substring(0, ridetime.length()-5);
				riderVO.setDateTime(ridetime);
				
				riderVO.setSeatLimit(rs.getInt("seatlimit"));
				
				riderList.add(riderVO);
				
			}
		
		rs.close();
		stmt.close();
		stmt2.close();
		conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return riderList;
	}

	private String getHourString(String hours) {
		String retMsg = "";
		if(hours!=null){
			switch(hours){
				case "1":
					retMsg = "'01:00'";
					break;
				case "2":
					retMsg = "'02:00'";
					break;
				case "3":
					retMsg = "'03:00'";
					break;
				case "4":
					retMsg = "'04:00'";
					break;
			}
		}
	
		return retMsg;
	}
	
	

	public List<RiderVO> getSpecificRider(String emailId){
		Connection conn = null;
		Statement stmt = null;
		
		List<RiderVO> riderList = new ArrayList<RiderVO>();
		
		try{
			
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to the selected DB....");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connected successfully ,");
			stmt= conn.createStatement();
			Statement stmt2 = conn.createStatement();
	
			String condition = " WHERE email = '"+emailId+"' AND ridedate is not null";
			
			String query = "select * from `maps`.`rider`"+condition;
			
			System.out.println("@RiderDao Query :> "+ query);
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				RiderVO riderVO = new RiderVO();
				
				riderVO.setRouteId(rs.getInt("routeid"));
				riderVO.setEmail(rs.getString("email"));
				
				String sourceStr = rs.getString("sourcelocation");
				String[] source = sourceStr.split(",");
				MapLocation sourceLoc = new MapLocation();
				sourceLoc.setG(Double.valueOf(source[0]));
				sourceLoc.setK(Double.valueOf(source[1]));
				riderVO.setSource(sourceLoc);
				
				String destStr = rs.getString("destinationloc");
				String[] dest = destStr.split(",");
				MapLocation destLoc = new MapLocation();
				destLoc.setG(Double.valueOf(dest[0]));
				destLoc.setK(Double.valueOf(dest[1]));
				riderVO.setDestination(destLoc);
				
				List<Waypoint> waypoints = new ArrayList<Waypoint>();
				int idx = 1;
				while(idx < 9){
					Waypoint waypoint1 = new Waypoint();
					waypoint1.setLocation(rs.getString("wp"+idx));
					if(waypoint1.getLocation()!=null){
						waypoint1.setStopover(true);
						waypoints.add(waypoint1);
					}
					idx++;
				}
				
				riderVO.setWaypoints(waypoints);
				riderVO.setTravelMode("DRIVING");
				riderVO.setOptimizeWaypoints(true);
				
				String ridetime = rs.getString("ridedate");
				ridetime = ridetime.substring(0, ridetime.length()-5);
				riderVO.setDateTime(ridetime);
				
				riderVO.setSeatLimit(rs.getInt("seatlimit"));
				riderVO.setDestStr(rs.getString("deststr"));
				riderVO.setSourceStr(rs.getString("sourcestr"));
				
				riderList.add(riderVO);
				
			}
		
		rs.close();
		stmt.close();
		stmt2.close();
		conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return riderList;
	}
	
	public String deleteRider(Integer routeId){
		
		Connection conn = null;
		Statement stmt = null;
		try{	
				Class.forName(JDBC_DRIVER);
				System.out.println("Connecting to the selected DB....");
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				System.out.println("Connected successfully ,");
				stmt= conn.createStatement();
					
				String query = "DELETE FROM `maps`.`rider` WHERE routeid ="+routeId;
				stmt.execute(query);
					
				stmt.close();
				conn.close();
					
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
		
		return "success";
	}
	
	
	public List<RiderVO> getAllRider(){
		Connection conn = null;
		Statement stmt = null;
		
		List<RiderVO> riderList = new ArrayList<RiderVO>();
		
		try{
			
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to the selected DB....");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connected successfully ,");
			stmt= conn.createStatement();
			Statement stmt2 = conn.createStatement();
	
			String condition = " ";
			
			String query = "select * from `maps`.`rider`"+condition;
			
			System.out.println("@RiderDao Query :> "+ query);
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				RiderVO riderVO = new RiderVO();
				
				riderVO.setRouteId(rs.getInt("routeid"));
				riderVO.setEmail(rs.getString("email"));
				
				String sourceStr = rs.getString("sourcelocation");
				String[] source = sourceStr.split(",");
				MapLocation sourceLoc = new MapLocation();
				sourceLoc.setG(Double.valueOf(source[0]));
				sourceLoc.setK(Double.valueOf(source[1]));
				riderVO.setSource(sourceLoc);
				
				String destStr = rs.getString("destinationloc");
				String[] dest = destStr.split(",");
				MapLocation destLoc = new MapLocation();
				destLoc.setG(Double.valueOf(dest[0]));
				destLoc.setK(Double.valueOf(dest[1]));
				riderVO.setDestination(destLoc);
				
				List<Waypoint> waypoints = new ArrayList<Waypoint>();
				int idx = 1;
				while(idx < 9){
					Waypoint waypoint1 = new Waypoint();
					waypoint1.setLocation(rs.getString("wp"+idx));
					if(waypoint1.getLocation()!=null){
						waypoint1.setStopover(true);
						waypoints.add(waypoint1);
					}
					idx++;
				}
				
				riderVO.setWaypoints(waypoints);
				riderVO.setTravelMode("DRIVING");
				riderVO.setOptimizeWaypoints(true);
				
				String ridetime = rs.getString("ridedate");
				ridetime = ridetime.substring(0, ridetime.length()-5);
				riderVO.setDateTime(ridetime);
				
				riderVO.setSeatLimit(rs.getInt("seatlimit"));
				riderVO.setDestStr(rs.getString("deststr"));
				riderVO.setSourceStr(rs.getString("sourcestr"));
				
				riderList.add(riderVO);
				
			}
		
		rs.close();
		stmt.close();
		stmt2.close();
		conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return riderList;
	}
	

}
