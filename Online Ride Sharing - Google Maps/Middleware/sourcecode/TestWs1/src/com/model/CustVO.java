package com.model;



public class CustVO {

	private Long custrouteId;
	
	private String email;
	
	private Long routeId;
	
	private String sourceLoc;
	
	private String destLoc;
	
	private String rideDate;
	

	public CustVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustVO(Long custrouteId, String email, Long routeId,
			String sourceLoc, String destLoc, String rideDate) {
		super();
		this.custrouteId = custrouteId;
		this.email = email;
		this.routeId = routeId;
		this.sourceLoc = sourceLoc;
		this.destLoc = destLoc;
		this.rideDate = rideDate;
	}

	public Long getCustrouteId() {
		return custrouteId;
	}

	public void setCustrouteId(Long custrouteId) {
		this.custrouteId = custrouteId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public String getSourceLoc() {
		return sourceLoc;
	}

	public void setSourceLoc(String sourceLoc) {
		this.sourceLoc = sourceLoc;
	}

	public String getDestLoc() {
		return destLoc;
	}

	public void setDestLoc(String destLoc) {
		this.destLoc = destLoc;
	}

	public String getRideDate() {
		return rideDate;
	}

	public void setRideDate(String rideDate) {
		this.rideDate = rideDate;
	}
	
	
	
	
}
