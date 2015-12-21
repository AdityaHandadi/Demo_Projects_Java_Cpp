package com.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.model.Strings;
import com.model.Test;
//import javax.ws.rs.core.Response;

@Path("/service")
public class JSONService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Test getTrackInJSON() {
		
		String key = "Hi Aditya";
		Test test = new Test();
		test.setName(key);
		test.setCwid(50135734);
		List<Strings> its = new ArrayList<Strings>();
		for(int i=0;i<5;i++){
			Strings data1 = new Strings();
			data1.setData("Hello");
			
			its.add(data1);
		}
		test.setIntegers(its);
			
		return test;
 
	}
 
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createTrackInJSON(Test tst) {
		
		if(tst!=null){
			System.out.println(tst.getName());
			
			if(tst.getIntegers()!=null){
				Iterator<Strings> it = tst.getIntegers().iterator();
				while(it.hasNext()){
					Strings data = it.next();
					System.out.println(data.getData());
				}
				
			}
			
			
		}
		else
			System.out.println("Nothing found");
 
		return "success";
	}
 
	
	
}
