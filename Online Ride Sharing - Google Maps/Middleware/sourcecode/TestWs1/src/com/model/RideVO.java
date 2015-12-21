package com.model;


public class RideVO {
	
	private Long routeId;
	
	private String email;
	
	private String source;
	
	private String wp1;
	
	private String wp2;

	private String wp3;
	
	private String wp4;
	
	private String wp5;
	
	private String wp6;
	
	private String wp7;
	
	private String wp8;
	
	private String destination;
	
	private String rideDate;
	
	private Integer rideLimit;
	
	private String sourceStr;
	
	private String destStr;
	
	
	
	public RideVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	
	public RideVO(Long routeId, String email, String source, String wp1,
			String wp2, String wp3, String wp4, String wp5, String wp6,
			String wp7, String wp8, String destination, String rideDate,
			Integer rideLimit, String sourceStr, String destStr) {
		super();
		this.routeId = routeId;
		this.email = email;
		this.source = source;
		this.wp1 = wp1;
		this.wp2 = wp2;
		this.wp3 = wp3;
		this.wp4 = wp4;
		this.wp5 = wp5;
		this.wp6 = wp6;
		this.wp7 = wp7;
		this.wp8 = wp8;
		this.destination = destination;
		this.rideDate = rideDate;
		this.rideLimit = rideLimit;
		this.sourceStr = sourceStr;
		this.destStr = destStr;
	}





	public Integer getRideLimit() {
		return rideLimit;
	}



	public void setRideLimit(Integer rideLimit) {
		this.rideLimit = rideLimit;
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



	public String getRideDate() {
		return rideDate;
	}

	public void setRideDate(String rideDate) {
		this.rideDate = rideDate;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getWp1() {
		return wp1;
	}

	public void setWp1(String wp1) {
		this.wp1 = wp1;
	}

	public String getWp2() {
		return wp2;
	}

	public void setWp2(String wp2) {
		this.wp2 = wp2;
	}

	public String getWp3() {
		return wp3;
	}

	public void setWp3(String wp3) {
		this.wp3 = wp3;
	}

	public String getWp4() {
		return wp4;
	}

	public void setWp4(String wp4) {
		this.wp4 = wp4;
	}

	public String getWp5() {
		return wp5;
	}

	public void setWp5(String wp5) {
		this.wp5 = wp5;
	}

	public String getWp6() {
		return wp6;
	}

	public void setWp6(String wp6) {
		this.wp6 = wp6;
	}

	public String getWp7() {
		return wp7;
	}

	public void setWp7(String wp7) {
		this.wp7 = wp7;
	}

	public String getWp8() {
		return wp8;
	}

	public void setWp8(String wp8) {
		this.wp8 = wp8;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	
	

}
