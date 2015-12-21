package com.thread;

public class ThreadImpl extends Thread{

	public void run(){
		System.out.println("running...");
		 for(int i=1;i<5;i++){  
			    try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
			    System.out.println(i);  
			  }  
		 
	}
	
	public static void main(String args[]){
		ThreadImpl t1 = new ThreadImpl();
		ThreadImpl t2 = new ThreadImpl();
		ThreadImpl t3 = new ThreadImpl();
		//ThreadImpl t4 = new ThreadImpl();
		//t1.run();
		//t2.run();
		
		t1.start();
		//t2.start();
		//t1.start();
		try{  
			  t1.join(1500);  
			 }catch(Exception e){System.out.println(e);}  
			  
		t2.start();  
		t3.start(); 
	}
	
}
