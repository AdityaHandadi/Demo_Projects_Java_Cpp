package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.RiderDao;
import com.model.DateTime_;
import com.model.EmailData;
import com.model.MapLocation;
import com.model.RideVO;
import com.model.RiderVO;
import com.model.RouteIDVO;
import com.model.Waypoint;

@Path("riderservice")
public class RiderService {
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public String saveRide(RideVO rideVO){
		
		RiderDao riderDao = new RiderDao();
		String msg = "";
		
		if(rideVO.getEmail()!=null && rideVO.getSource()!=null && rideVO.getDestination()!=null){
			msg = riderDao.saveRide(rideVO);
		}
		
		return msg;
	}
	
	@POST
	@Path("saveAll")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String saveRideJson(RiderVO riderVO){
		String msg = "";
		RiderDao riderDao = new RiderDao();
		
		System.out.println("HERE");
		
		if(riderVO.getEmail()!=null && riderVO.getSource()!=null && riderVO.getDestination()!=null){
			msg = riderDao.saveRiderObject(riderVO);
		}
		
		return msg;
	}
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public RiderVO testJSON(){
		RiderVO riderVO = new RiderVO();
		
		riderVO.setEmail("aditya@123.com");
		
		MapLocation src = new MapLocation();
		src.setG(33.2470567);
		src.setK(-95.89996559999997);
		
		MapLocation dest = new MapLocation();
		dest.setG(33.0198431);
		dest.setK(-96.69888559999998);
		
		List<Waypoint> waypoints = new ArrayList<Waypoint>();
		
		Waypoint waypoint = new Waypoint();
		waypoint.setLocation("Greenville, TX, USA");
		waypoints.add(waypoint);
		
		Waypoint waypoint2 = new Waypoint();
		waypoint2.setLocation("McKinney, TX, USA");
		waypoints.add(waypoint2);
		
		riderVO.setSource(src);
		riderVO.setDestination(dest);
		riderVO.setWaypoints(waypoints);
	
		return riderVO;
	}
	
	@POST
	@Path("getrider")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<RiderVO> retrieveRides(DateTime_ dateTime){
		RiderDao riderDao = new RiderDao();
		
		return riderDao.getRiders(dateTime);
	}
	
	@POST
	@Path("getriderlist")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<RiderVO> retrieveRider(EmailData emailData){
		RiderDao riderDao = new RiderDao();
		
		return riderDao.getSpecificRider(emailData.getEmail());
	}
	
	@POST
	@Path("getAllriders")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<RiderVO> retrieveAllRider(RouteIDVO routeId){
		RiderDao riderDao = new RiderDao();
		return riderDao.getAllRider();
	}
	
	@POST
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteRider(RouteIDVO routeId){
		RiderDao riderDao = new RiderDao();
		
		return riderDao.deleteRider(routeId.getRouteId());
	}

}
