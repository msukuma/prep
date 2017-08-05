package dataStructures;

public class BinarySearchTree {
	public static class Node {
		private int value;
		private Node right;
		private Node left;

		public Node(int value){
			this.value = value;
		}

		public boolean hasRight(){
			return right != null;
		}

		public boolean hasLeft(){
			return left != null;
		}

		public int getValue(){
			return value;
		}

		public void setValue(int value){
			this.value = value;
		}

		public void add(int value){
			if (this.value > value) {
				if(hasLeft()){
					left.add(value);
				}
				else {
					left = new Node(value);
				}
			}
			else {
				if(hasRight()){
					right.add(value);
				}
				else {
					right = new Node(value); 
				}
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
	}

	private Node root;
	
	public BinarySearchTree(int rootValue){
		root = new Node(rootValue);
	}

	public void add(int value){
		root.add(value);
	}

	public boolean contains(int value){
		return root.contains(value);
	}
	
}
