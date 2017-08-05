package crackingTheCodingInterview;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListAdder {
	private static int makeIntFromList(LinkedList<Integer> list) {
		System.out.println(list);
		int place = (int) Math.pow(10, list.size())/10;

		
		int n = 0;
		Iterator<Integer> i = list.iterator();
		
		while(i.hasNext()){
			System.out.println("n b4: " + n);
			System.out.println("place b4: " + place);
			n += i.next() * place;
			place /= 10;
			System.out.println("n 4f: " + n);
			System.out.println("place 4f: " + place);
		}
		return n;
	}
	
	private static int makeIntFromBackWardsList(LinkedList<Integer> list) {
		int place = 1;
		int n = 0;
		Iterator<Integer> i = list.iterator();
		
		while(i.hasNext()){
			n += i.next() * place;
			place *= 10;
		}
		
		return n;
	}
	
	public static int addLists(LinkedList<Integer> a, LinkedList<Integer> b) {
		return makeIntFromList(a) + makeIntFromList(b);
	}
	
	public static int addBackWardsLists(LinkedList<Integer> a, LinkedList<Integer> b) {
		return makeIntFromBackWardsList(a) + makeIntFromBackWardsList(b);
	}
	public static void main(String[] args) {
		
		LinkedList<Integer> a = new LinkedList<Integer>(Arrays.asList(7,1,6));
		LinkedList<Integer> b = new LinkedList<Integer>(Arrays.asList(5,9,2));
		
		System.out.println(LinkedListAdder.addBackWardsLists(a, b));
		
		a = new LinkedList<Integer>(Arrays.asList(6,1,7));
		b = new LinkedList<Integer>(Arrays.asList(2,9,5));
		
		System.out.println(LinkedListAdder.addLists(a, b));
		
	}
}
