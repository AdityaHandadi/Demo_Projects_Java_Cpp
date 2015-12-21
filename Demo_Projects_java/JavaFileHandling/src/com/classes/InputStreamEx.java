package com.classes;

import java.io.File;
import java.io.FileInputStream;

public class InputStreamEx {

	public static void main(String args[]){
		File file = new File("/Users/adityahandadi/Documents/Junk/ReadFile.txt");
		
		int ch;
		StringBuffer strContent =  new StringBuffer();
		FileInputStream fin = null;
		
		try{
			fin = new FileInputStream(file);
			while((ch = fin.read())!= -1){
				strContent.append((char) ch);

			}

			
			System.out.println(strContent);
			 
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
