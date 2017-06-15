package util;

import dataStructures.LinkedList;

public class Printer {
	public static void puts(Object obj){
		System.out.println(obj);
	}
	
	public static void puts(Object obj, int seperatorLength){
		System.out.println(obj);
		seperator(seperatorLength);
	}

	public static void print(int[] items, int size){
		System.out.print("[");
		for (int i = 0; i < size-1; i++) {
			System.out.print(items[i] + ", ");
		}
		System.out.println(items[size - 1] + "]");
	}
	
	public static void seperator(int length){
		String s = "=";
		String complete="";
		
		for (int i = 0; i < length; i++) {
			complete+=s;
		}
		
		puts(complete);
		
	}
}
