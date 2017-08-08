package dataStructures;

public class BinarySearchTree<T> implements Tree<T>{
	public static class DepthCounter{
		private int c;
		
		public DepthCounter() {
			c = 0;
		}
		
		public int getCount(){
			return c;
		}
		
		public void setCount(int count){
			c = count;
		}
		
		public void increment() {
			c += 1;
		}
		
		public void decrement() {
			c -= 1;
		}
		
		public void incrementBy(int change){
			c += change;
		}
		
		public void decrementBy(int change) {
			c -= change;
		}
	}
	private T value;
	private BinarySearchTree<T> right;
	private BinarySearchTree<T> left;
	private BinarySearchTree<T> parent;

	public BinarySearchTree(T value){
		this.value = value;
	}
	
	@Override
	public Tree<T> getLeft() {
		return left;
	}

	@Override
	public Tree<T> getRight() {
		return right;
	}

	public boolean hasRight(){
		return right != null;
	}

	public boolean hasLeft(){
		return left != null;
	}
	
	public boolean hasParent(){
		return parent != null;
	}

	public T getValue(){
		return value;
	}

	public void setValue(T value){
		this.value = value;
	}
	
	private void setParent(BinarySearchTree<T> parent){
		this.parent = parent;
	}
	
	@SuppressWarnings("unchecked")
	private boolean greaterThan(T value){
		return ((Comparable<T>) this.value).compareTo(value) > 0;
	}

	public void add(T value){
		if (greaterThan(value)) {
			if(hasLeft()){
				left.add(value);
			}
			else {
				left = new BinarySearchTree<T>(value);
				left.setParent(this);
			}
		}
		else {
			if(hasRight()){
				right.add(value);
			}
			else {
				right = new BinarySearchTree<T>(value); 
				right.setParent(this);
			}
		}

	}
	
	@SuppressWarnings("unchecked")
	public void addAll(T ...args){
		for (T i : args) {
			add(i);
		}
	}
	
	public boolean contains(T value){
		if(this.value == value){
			return true;
		}
		else if (greaterThan(value)) {
			if(hasLeft()){
				return left.contains(value);
			}
			return false;
		}
		else {
			if(hasRight()){
				return right.contains(value);
			}
			return false;
		}

	}
	
	public int depth(){
		return 1 + depth(new DepthCounter());
	}
	
	private int depth(DepthCounter dc){
		DepthCounter lc = null;
		DepthCounter rc = null;
		
		if(hasLeft()){
			lc = new DepthCounter();
			lc.increment();
			left.depth(lc);
		} 
		
		if(hasRight()) {
			rc = new DepthCounter();
			rc.increment();
			right.depth(rc);
		}
		
		if(lc != null && rc != null){
			dc.incrementBy(lc.getCount() > rc.getCount() ? lc.getCount() : rc.getCount());
		} 
		else if (lc != null) {
			dc.incrementBy(lc.getCount());
		}
		else if (rc != null) {
			dc.incrementBy(rc.getCount());
		}
		
		return dc.getCount();
	}
	
	public String toString(){
		String s = "";
		
		if(hasLeft()){
			s += left.toString() + ", ";
		}
		
		s += value;
		
		if(hasRight()){
			s += ", "+ right.toString();
		}
		
		
		return s;
	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(5);
		bst.addAll(1,6,8,9,3,2,0,4,10);
		System.out.println(bst);
		System.out.println(bst.depth());
	}
}
