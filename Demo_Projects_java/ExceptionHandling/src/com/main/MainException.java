package com.main;


public class MainException {

	public static void main(String args[]){
		
		try{
			throw new RuntimeException("Random exception thrown");
		}
		catch(IllegalArgumentException foe){
			System.out.println("IllegalArguement Found");
		}catch(RuntimeException ioe){
			System.out.println("Runtime ioe");
		}catch(Exception ee){
			System.out.println("Exception ee");
		}
		
	}
}
