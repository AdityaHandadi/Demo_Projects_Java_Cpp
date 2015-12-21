package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.classes.Fruit;

public class Main {

	public static void main(String args[]){
		ArrayList list = new ArrayList();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		List<Integer> arrList_3 = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		
		list.add('a');
		list.add("2");
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		
		
		arrList.add(1);
		arrList.add(2);
		arrList.add(3);
		arrList.add(5);
		
		//arrList.add(7,9);
		
		//System.out.println(arrList.get(6));
		
		linkedList.add(1);
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(2);
		
		//System.out.println("List"+ list);
		//System.out.println("ArrList"+arrList);
		//System.out.println("Linked List "+linkedList);
		
		
	}
}
