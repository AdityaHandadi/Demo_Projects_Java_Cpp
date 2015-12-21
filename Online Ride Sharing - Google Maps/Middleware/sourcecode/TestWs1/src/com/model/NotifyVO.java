package com.model;

public class NotifyVO {
	
	private String source;
	
	private String destination;
	
	private String dateTime;

	public NotifyVO(String source, String destination, String dateTime) {
		super();
		this.source = source;
		this.destination = destination;
		this.dateTime = dateTime;
	}
	
	

	public String getSource() {
		return source;
	}

	public NotifyVO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	

}
