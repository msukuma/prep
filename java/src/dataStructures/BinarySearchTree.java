package dataStructures;

public class BinarySearchTree implements Tree{
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
	private int value;
	private BinarySearchTree right;
	private BinarySearchTree left;
	private BinarySearchTree parent;

	public BinarySearchTree(int value){
		this.value = value;
	}
	
	@Override
	public Tree getLeft() {
		return left;
	}

	@Override
	public Tree getRight() {
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

	public int getValue(){
		return value;
	}

	public void setValue(int value){
		this.value = value;
	}
	
	private void setParent(BinarySearchTree parent){
		this.parent = parent;
	}

	public void add(int value){
		if (this.value > value) {
			if(hasLeft()){
				left.add(value);
			}
			else {
				left = new BinarySearchTree(value);
				left.setParent(this);
			}
		}
		else {
			if(hasRight()){
				right.add(value);
			}
			else {
				right = new BinarySearchTree(value); 
				right.setParent(this);
			}
		}

	}
	
	public void addAll(int ...args){
		for (int i : args) {
			add(i);
		}
	}
	
	public boolean contains(int value){
		if(this.value == value){
			return true;
		}
		else if (this.value > value) {
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
		BinarySearchTree bst = new BinarySearchTree(5);
		bst.addAll(1,6,8,9,3,2,0,4,10);
		System.out.println(bst.depth());
	}
}
