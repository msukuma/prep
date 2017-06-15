package dataStructures;

import java.util.LinkedList;

import util.Printer;

public class Queue<T> {
	private LinkedList<T> list;
	
	public Queue(){
		list = new LinkedList<T>();
	}
	
	public int size(){
		return list.size();
	}
	
	public boolean isEmpty(){
		return list.size() == 0;
	}
	
	public T dequeue() throws IllegalStateException {
		if(isEmpty()) throw new IllegalStateException();
		return list.removeFirst();
	}
	
	public void enqueue(T item){
		list.addLast(item);
	}
	
	public void enqueueAll(T... items){
		for (T item : items) {
			enqueue(item);
		}
	}
	
	public void print(){
		Printer.puts(list.toString());
	}
	
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.enqueueAll(1,2,3,4,5,6,7);
		q.print();
		int n = q.dequeue();
		Printer.puts(n);
		q.print();
		
	}
}
