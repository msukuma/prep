package crackingTheCodingInterview;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Stack;

import dataStructures.LinkedList;
import dataStructures.LinkedList.Node;

public class LinkedListPalindrome {
	/*
	 * Size is known
	 * */
	public static <T> boolean isPalindromeS(LinkedList<T> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IllegalStateException, NoSuchMethodException, SecurityException {
		if(list.size() == 0){
			return false;
		}
		else if(list.size() == 1) {
			return true;
		} 
		else{
			Method compareTo = list.getFirst().getClass().getMethod("compareTo", new Class<?>[] {Object.class});;
			
			if(list.size() == 2){
				return (int) compareTo.invoke(list.getFirst(), list.getLast()) == 0;
			} else {
				HashMap<Integer, T> p;
				Node<T> curr = list.getFirstNode();
				int i = 0;
				int mid = list.size()/2;
				
				p = new HashMap<Integer, T>();
				
				while(i < mid){
					p.put(i, curr.getValue());
					curr = curr.getNext();
					i++;
				}
				if(list.size() % 2 == 0){
					while(i < list.size()){
						if((int) compareTo.invoke(curr.getValue(), p.get(list.size() - 1 - i )) == 0) return false;
						curr = curr.getNext();
						i++;
					}
				}
				else {
					i += 1;
					curr = curr.getNext();
					
					while(i < list.size()){
						if((int) compareTo.invoke(curr.getValue(), p.get(list.size() - 1 - i )) == 0) return false;
						curr = curr.getNext();
						i++;
					}
				}
				
				return true;
			}
		}
			
	}
	
	public static <T> boolean isPalindomeNoSize(Node<T> head) {
		Node<T> slow, fast;
		Stack<Node<T>> stack = new Stack<LinkedList.Node<T>>();
		
		slow = head;
		fast = head;
		
		while(fast != null && fast.hasNext()){
			stack.push(slow);
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		
		if(fast != null){
			slow = slow.getNext();
		}
		
		while(slow != null){
			if(stack.pop().getValue() != slow.getValue()) return false;
			slow = slow.getNext();
		}
			
		
		return true;
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list;
		LinkedList<String> listS;
		
		listS = new LinkedList<String>();
		listS.addAll("h", "e","l" ,"e", "h"); 
		System.out.println(isPalindomeNoSize(listS.getFirstNode()));
		
//		list = new LinkedList<Integer>();
//		list.addAll(1,2);
//		System.out.println(LinkedListPalindrome.isPalindrome(list));
//		list = new LinkedList<Integer>();
//		list.addAll(2,2);
//		System.out.println(LinkedListPalindrome.isPalindrome(list));
//		
//		list = new LinkedList<Integer>();
//		list.addAll(1,2,2,1);
//		System.out.println(LinkedListPalindrome.isPalindrome(list));
//		list = new LinkedList<Integer>();
//		list.addAll(1,2,3,1);
//		System.out.println(LinkedListPalindrome.isPalindrome(list));
//		list = new LinkedList<Integer>();
//		list.addAll(1,2,2,3);
//		System.out.println(LinkedListPalindrome.isPalindrome(list));
//
//		list = new LinkedList<Integer>();
//		list.addAll(1,2,3,2,1);
//		System.out.println(LinkedListPalindrome.isPalindrome(list));
//		list = new LinkedList<Integer>();
//		list.addAll(1,2,3,3,1);
//		System.out.println(LinkedListPalindrome.isPalindrome(list));
//		list = new LinkedList<Integer>();
//		list.addAll(1,2,3,2,3);
//		System.out.println(LinkedListPalindrome.isPalindrome(list));
	}
}
