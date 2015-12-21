package com.classes;

import java.io.File;
import java.io.FileOutputStream;

public class OutputStreamEx {
	
	public static void main(String args[]){
		File file;
		
		//int ch;
		//StringBuffer strContent =  new StringBuffer();
		
		FileOutputStream fop = null;
		
		String content = "jlkfjlakfjlkafjlkfdjla";
		
		try{
			
			file = new File("/Users/adityahandadi/Documents/Junk/Write.txt");
			fop = new FileOutputStream(file);
			
			if(!file.exists()){
				file.createNewFile();
			}
			
			byte[] contentInBytes = content.getBytes();
			
			fop.write(contentInBytes);
			fop.close();
			
			System.out.println("Done");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
