package com.classes;

import java.util.Comparator;

public class SizeComparator implements Comparator<HDTV>{


	@Override
	public int compare(HDTV o1, HDTV o2) {
		int size1 = ((HDTV) o1).getSize();
		int size2 = ((HDTV) o2).getSize();
		
		if(size1 > size2){
			return 0;
		}
		else{
			return -1;
		}
		
		//return 0;
	}
	
	
}