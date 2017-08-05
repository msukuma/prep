package util;

import java.util.Arrays;

import dataStructures.LinkedList;

public class Printer {
	public static void puts(Object obj){
		System.out.println(obj);
	}
	
	public static void puts(Object obj, int seperatorLength){
		System.out.println(obj);
		seperator(seperatorLength);
	}
	
	public static  void printMatrix(int[][] m){
		for (int i = 0; i < m.length; i++) {
			System.out.println(Arrays.toString(m[i]));
		}
		
		seperator(m.length * 5);
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
