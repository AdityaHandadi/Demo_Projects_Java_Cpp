package com.classes;

public class EmailManipulator {

	private String name;
	private String emailID;
	
	
	
	public EmailManipulator(String name, String emailID) {
		super();
		this.name = name;
		this.emailID = emailID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String addNametoEmail(){
		return name+"-"+emailID;
	}
	
	public String extractStringBeforeAt(){
		String [] strarr = new String[2];
		strarr = emailID.split("@");
		return strarr[0];
	}
	
	public String insertMidName(String midName){
		String strarr[] = new String[2];
		StringBuffer strbuf = new StringBuffer();
		
		if(name.contains(" ")){
			strarr = name.split(" ");
			strbuf.append(strarr[0]);
			strbuf.append(" "+midName+" ");
			strbuf.append(strarr[1]);
			
			return strbuf.toString();
		}
		else{
			return null;
		}
	}
	
	public String removeMidName(String midName){
		return name.replaceAll(midName, " ");
	}
	
	public String replaceName(String newName){
		setName(newName);
		
		return name;
	}
	
}
