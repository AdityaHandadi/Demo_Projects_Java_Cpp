package com.main;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringBufEx {

	public static void main(String args[]){
		String str_  = "hello";
		
		//Scanner s = new Scanner(System.in);
		StringBuffer strbuf = new StringBuffer(str_);
		
		//strbuf.append(str_);
		
		System.out.println(strbuf);
		
		System.out.println("Length is l:"+ str_.length());
		strbuf.delete(1, 3);
		System.out.println("After deletion : "+ strbuf);
		
		strbuf.append("Hello");
		strbuf.append("World");
		System.out.println(strbuf);
		
		strbuf.insert(5, "Java");
		
		System.out.println(strbuf);
		
		strbuf.reverse();
		System.out.println(strbuf);

		strbuf.setCharAt(5,' ');
		System.out.println(strbuf);
		
		System.out.println(strbuf);
		System.out.println(strbuf.charAt(6));
		
		
		System.out.println(strbuf.substring(3,7));
		System.out.println(strbuf.capacity());
		strbuf.delete(6,strbuf.length());
		System.out.println(strbuf);
		
		
		//String tokenizer
		String stt = "Hello String tokenizer";
		StringTokenizer stt_token = new StringTokenizer(stt);
		
		while(stt_token.hasMoreElements()){
			System.out.println(stt_token.nextElement());
		}
		
		
	}
	
}
