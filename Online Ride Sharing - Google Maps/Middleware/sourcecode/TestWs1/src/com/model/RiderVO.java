package com.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class RiderVO {
	
	
	private String email;
	
	private MapLocation source;
	
	private MapLocation destination;
	
	private List<Waypoint> waypoints;
	
	private Boolean optimizeWaypoints;
	
	private String travelMode;
	
	private Integer seatLimit;
	
	private String dateTime;
	
	private String fname;
	
	private String lname;

	private Integer routeId;
	
	private String sourceStr;
	
	private String destStr;

	public RiderVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	
	
	public RiderVO(String email, MapLocation source, MapLocation destination,
			List<Waypoint> waypoints, Boolean optimizeWaypoints,
			String travelMode, Integer seatLimit, String dateTime,
			String fname, String lname, Integer routeId, String sourceStr,
			String destStr) {
		super();
		this.email = email;
		this.source = source;
		this.destination = destination;
		this.waypoints = waypoints;
		this.optimizeWaypoints = optimizeWaypoints;
		this.travelMode = travelMode;
		this.seatLimit = seatLimit;
		this.dateTime = dateTime;
		this.fname = fname;
		this.lname = lname;
		this.routeId = routeId;
		this.sourceStr = sourceStr;
		this.destStr = destStr;
	}





	public String getSourceStr() {
		return sourceStr;
	}


	public void setSourceStr(String sourceStr) {
		this.sourceStr = sourceStr;
	}


	public String getDestStr() {
		return destStr;
	}


	public void setDestStr(String destStr) {
		this.destStr = destStr;
	}


	public Integer getRouteId() {
		return routeId;
	}


	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}


	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("source")
	public MapLocation getSource() {
		return source;
	}

	public void setSource(MapLocation source) {
		this.source = source;
	}

	@JsonProperty("destination")
	public MapLocation getDestination() {
		return destination;
	}

	public void setDestination(MapLocation destination) {
		this.destination = destination;
	}

	@JsonProperty("waypoints")
	public List<Waypoint> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(List<Waypoint> waypoints) {
		this.waypoints = waypoints;
	}

	public Boolean getOptimizeWaypoints() {
		return optimizeWaypoints;
	}

	public void setOptimizeWaypoints(Boolean optimizeWaypoints) {
		this.optimizeWaypoints = optimizeWaypoints;
	}

	public String getTravelMode() {
		return travelMode;
	}

	public void setTravelMode(String travelMode) {
		this.travelMode = travelMode;
	}

	public Integer getSeatLimit() {
		return seatLimit;
	}

	public void setSeatLimit(Integer seatLimit) {
		this.seatLimit = seatLimit;
	}

	
	

}
