package dataStructures;

public class LinkedList<T> {
	public static class Node<T> {
		private T value;
		private Node<T> previous;
		private Node<T> next;

		public Node(T value) {
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

	protected Node<T> first;
	protected Node<T> last;
	protected int size;

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
	
	public Node<T> getFirstNode() throws IllegalStateException {
		if(isEmpty()) throw new IllegalStateException();

		return first;
	}

	public T getLast() throws IllegalStateException {
		if(isEmpty()) throw new IllegalStateException();

		return last.getValue();
	}
	
	public Node<T> getLastNode() throws IllegalStateException {
		if(isEmpty()) throw new IllegalStateException();

		return last;
	}

	public void add(T value){
		addNode(new Node<T>(value));
		
	}
	
	public void addNode(Node<T> node){
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
		addNodeFirst(new Node<T>(value));
	}
	
	public void addNodeFirst(Node<T> node){
		if (!isEmpty()) {			
			first.setPrevious(node);
			node.setNext(first);
		}

		first = node;
		size++;
	}
	
	public void addLast(T value){
		add(value);
	}
	
	public void addNodeLast(Node<T> node){
		addNode(node);
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
	
	public String toString (){
		String s = "[";
		
		if(size > 0){
			Node<T> node = first;
			
			while(node.hasNext()){
				s += node.getValue() + ", ";
				node = node.getNext();
			}
			
			s += node.getValue();
		}
		
		s += "]";
		
		return s;
	}
	
	public void print(){
		System.out.println(toString());
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
