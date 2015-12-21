package com.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class MapLocation {
	
	
	private Double G;
	
	private Double K;

	@JsonProperty("G")
	public Double getG() {
		return G;
	}

	public void setG(Double g) {
		G = g;
	}

	@JsonProperty("K")
	public Double getK() {
		return K;
	}

	public void setK(Double k) {
		K = k;
	}

	
	
	

}
