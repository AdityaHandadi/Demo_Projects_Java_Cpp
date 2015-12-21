package com.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Waypoint {
	
	private String location;
	
	private Boolean stopover;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Boolean getStopover() {
		return stopover;
	}

	public void setStopover(Boolean stopover) {
		this.stopover = stopover;
	}
	
	

}
