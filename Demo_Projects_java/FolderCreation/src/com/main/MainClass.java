package com.main;

import java.io.File;
import java.io.IOException;

public class MainClass {
	
	public static void main(String args[]){
		
		File file = new File("//Users//adityahandadi//Documents//Karthick");
		//boolean flag = false;
		
		if(!file.exists()){
			System.out.println("New Directory Created");
			new File("//Users//adityahandadi//Documents//Karthick").mkdir();
		}
		else{
			System.out.println("Directory already exists");
		}
		
		try{
			delete(file);
		}catch(IOException ioe){
			
		}
	}
	
	public static void delete(File file)
	    	throws IOException{
	 
	    	if(file.isDirectory()){
	    		//directory is empty, then delete it
	    		if(file.list().length==0){
	    		   file.delete();
	    		   System.out.println("Directory is deleted : "  + file.getAbsolutePath());	
	    		}else{
	    			//list all the directory contents
	        	   String files[] = file.list();
	     
	        	   for (String temp : files) {
	        	      //construct the file structure
	        	      File fileDelete = new File(file, temp);
	        		 
	        	      //recursive delete
	        	     delete(fileDelete);
	        	   }
	        		
	        	   //check the directory again, if empty then delete it
	        	   if(file.list().length==0){
	           	     file.delete();
	        	     System.out.println("Directory is deleted : " 
	                                                  + file.getAbsolutePath());
	        	   }
	    		}
	    		
	    	}else{
	    		//if file, then delete it
	    		file.delete();
	    		System.out.println("File is deleted : " + file.getAbsolutePath());
	    	}
	    }

}
