package dataStructures;

import java.util.LinkedList;

import util.Printer;

public class Stack<T> {
	private LinkedList<T> list;
	
	public Stack(){
		list = new LinkedList<T>();
	}
	
	public int size(){
		return list.size();
	}
	
	public boolean isEmpty(){
		return list.size() == 0;
	}
	
	public void push(T item){
		list.addFirst(item);
	}
	
	public void pushAll(T...items){
		for (T item : items) {
			push(item);
		}
	}
	
	public T pop(){
		if(isEmpty()) throw new IllegalStateException();
		return list.removeFirst();
	}
	
	public T peak(){
		if(isEmpty()) throw new IllegalStateException();
		return list.getFirst();
	}
	
	public void print(){
		Printer.puts(list.toString());
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		
		s.pushAll(1,2,3,4,5,6,7);
		s.print();
		int n = s.pop();
		Printer.puts(n);
		s.print();
	}
}	
