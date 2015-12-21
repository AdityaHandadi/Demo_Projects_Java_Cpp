package com.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.classes.User;

public class Main {

	public static void main(String args[]) throws Exception{
		
		//serialization
		User userWrite = new User(1,"John","abc@123.com","123131231231");
		
		FileOutputStream fos = new FileOutputStream("/Users/adityahandadi/Documents/Junk/Write.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(userWrite);
		oos.flush();
		oos.close();
		
		//deserialization
		User userRead;
		FileInputStream fis = new FileInputStream("/Users/adityahandadi/Documents/Junk/Write.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		userRead = (User)ois.readObject();
		ois.close();
		
		System.out.println("id"+userRead.getId());
		System.out.println("username"+userRead.getUsername());
		System.out.println("user Email"+userRead.getUsername());
		System.out.println("user phone "+userRead.getPhoneno());
		
		
		
	}
}
