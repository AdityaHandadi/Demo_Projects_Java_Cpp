package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
		String strbuff = new String(br.readLine().toLowerCase());
		
		Map<Character,Integer> aphMap = new HashMap<Character,Integer>();
		
		int i=0;
		for(i=0;i<26;i++)
			aphMap.put((char) ('a'+i), 0);
		
		int lngth = strbuff.length()-1;
		
		try{
			while(lngth >= 0){
				 if(strbuff.charAt(lngth)!= ' '){
					if(aphMap.get(strbuff.charAt(lngth)) == 0){
						aphMap.put(strbuff.charAt(lngth), 1);
					}
				 }
				lngth--;
			}
			
			lngth = 0;
			Iterator<Character> it = aphMap.keySet().iterator();
			while(it.hasNext()){
				if(aphMap.get(it.next()) == 1)
					lngth++;
			}
			
			
			if(lngth == 26){
				System.out.println("pangram");
			}
			else
				System.out.println("not pangram");
		}
		catch(java.lang.NullPointerException ne){
			ne.printStackTrace();
			System.out.println("not pangram");
		}
	}

}
