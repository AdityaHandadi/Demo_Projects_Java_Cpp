package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import com.classes.Fruit;
import com.classes.HDTV;
import com.classes.SizeComparator;

public class ComparatorEx {
	
	public static void main(String aargs[]){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		arr.add(90);
		arr.add(90);
		arr.add(80);
		arr.add(7);
		arr.add(790);
		arr.add(5);
		arr.add(0);
		
		System.out.println("Ascending");
		
		Collections.sort(arr);
		
		System.out.println(arr);
		
		System.out.println(" Descending with Comparator ");
		
		Comparator<Integer> com = Collections.reverseOrder();
		//List in reverse order
		Collections.sort(arr,com);
		
		System.out.println(arr);
		
		//Comparator and Comparable
				Fruit pineapple = new Fruit("Pineapple", "sweet	", 70);
				Fruit apple = new Fruit("Apple ", "healthy" , 90);
				Fruit orange = new Fruit("Orange","sour ",100);
				
				Fruit[] fruits = new Fruit[3];
				//fruits.add(pineapple);
				//fruits.add(apple);
				//fruits.add(orange);
				
				fruits[0] = pineapple;
				fruits[1] = apple;
				fruits[2] = orange;
				
				Arrays.sort(fruits);
				
				for(Fruit f:fruits){
					System.out.println("Fruit: "+f.getFruitName()+" Quantity:"+f.getQuantity());
				}
				
				ArrayList<Fruit> fruitArr = new ArrayList<Fruit>();
				fruitArr.add(orange);
				fruitArr.add(pineapple);
				fruitArr.add(apple);
				
				Collections.sort(fruitArr);
				for(Fruit f:fruitArr){
					System.out.println("Fruit: "+f.getFruitName());
				}
		
				//Compare to - comparable
				HDTV samsung = new HDTV(21,"Samsung");
				HDTV sony = new HDTV(40,"Sony");
				HDTV panasonic = new HDTV(45,"Panasonic");
				
				ArrayList<HDTV> al = new ArrayList<HDTV>();
				al.add(panasonic);
				al.add(sony);
				al.add(samsung);
				
				Collections.sort(al,new SizeComparator());
				
				for(HDTV tv:al){
					System.out.println(tv.getBrand());
				}
				
	}

}
