package dataStructures;

import util.Printer;

public class LinkedList<T> {
	public static class Node<T> {
		private T value;
		private Node<T> previous;
		private Node<T> next;

		public Node(T value){
			this.value = value;
		}

		public T getValue(){
			return value;
		}

		public void setValue(T value){
			this.value = value;
		}

		public Node<T> getNext(){
			return next;
		}
		
		public void setNext(Node<T> next){
			this.next = next;
		}
		
		public void setNext(T value){
			Node<T> next = new Node<T>(value);
			setNext(next);
		}
		
		public boolean hasNext(){
			return next != null;
		}

		public Node<T> getPrevious(){
			return previous;
		}
		
		public void setPrevious(Node<T> previous){
			this.previous = previous;
		}
		
		public boolean hasPrevious(){
			return previous != null;
		}
		
		public void setPrevious(T value){
			Node<T> previous = new Node<T>(value);
			setNext(previous);
		}
		
		public String toString(){
			return value.toString();
		}
	}

	private Node<T> first;
	private Node<T> last;
	private int size;

	public LinkedList(){
		size = 0;
	}

	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	
	public T getFirst() throws IllegalStateException {
		if(isEmpty()) throw new IllegalStateException();

		return first.getValue();
	}

	public T getLast() throws IllegalStateException {
		if(isEmpty()) throw new IllegalStateException();

		return last.getValue();
	}

	public void add(T value){
		Node<T> node = new Node<T>(value);

		if (size == 0) {
			first = node;
		}
		else {
			last.setNext(node);
			node.setPrevious(last);
		}

		last = node;
		size++;
	}
	
	public void addFirst(T value){
		Node<T> node = new Node<T>(value);

		if (!isEmpty()) {			
			Printer.puts(node);
			Printer.puts(first);
			
			first.setPrevious(node);
			node.setNext(first);
		}

		first = node;
		size++;
	}
	
	public void addLast(T value){
		add(value);
	}
	
	public void addAll(T...args){
		for (int i = 0; i < args.length; i++) {
			add(args[i]);
		}
	}
	
	public void removeFirst(){
		if (!isEmpty()) {
			first = first.getNext();
			size--;
		}
	}
	
	public void removeLast(){
		if (!isEmpty()) {
			last = last.getPrevious();
			size--;
		}
	}
	
	public void print(){
		System.out.print("[");
		
		if(size > 0){
			Node<T> node = first;
			
			while(node.hasNext()){
				System.out.print(node.getValue() + ", ");
				node = node.getNext();
			}
			
			System.out.print(node.getValue());
		}
		
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		
		l.addAll(1,2,3,4,5,6);
		l.addFirst(0);
		l.addLast(7);
		l.print();
		l.removeFirst();
		l.removeLast();
		l.print();
		l.removeFirst();
		l.print();
	}

}
