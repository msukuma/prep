package crackingTheCodingInterview;

import dataStructures.BinarySearchTree;
import dataStructures.Counter;
import dataStructures.Tree;

public class ZigZagCounter {
	private static class Direction{
		private boolean left;
		private boolean right;
		private boolean atRoot;
		
		public Direction(boolean atRoot){
			this.atRoot = atRoot;
		}
		
		public Direction(boolean left, boolean right){
			this.left = left;
			this.right = right;
		}
		
		public boolean comingFromLeft(){
			return !atRoot && left;
		}
		
		public boolean comingFromRight(){
			return !atRoot && right;
		}
		
		public boolean atRoot(){
			return atRoot;
		}
		
		public String toString(){
			return "left: " + left + " right: " + right + " atRoot: " + atRoot;
		}
	}
	
	private static int countZigZag(Tree t, Direction d, Counter c){
		Counter leftZigZagCounter =  null;
		Counter rightZigZagCounter = null;
//		System.out.println("entry t:" + ((BinarySearchTree) t).getValue() + " d: "+ d + " c: " + c.getCount());
		
		if (t.getLeft() != null){ 
			leftZigZagCounter = new Counter();

			if (d.atRoot()){
				countZigZag(t.getLeft(), new Direction(true, false), leftZigZagCounter);
			}
			else if(d.comingFromRight()){
				leftZigZagCounter.increment();
				countZigZag(t.getLeft(), new Direction(true, false), leftZigZagCounter);
			} 
			else {
				countZigZag(t.getLeft(), d, leftZigZagCounter);
			}
		}
		
		if (t.getRight() != null) {
			rightZigZagCounter = new Counter();

			if (d.atRoot()){
				countZigZag(t.getRight(), new Direction(false, true), rightZigZagCounter);
			}
			else if(d.comingFromLeft()){
				rightZigZagCounter.increment();
				countZigZag(t.getRight(), new Direction(false, true), rightZigZagCounter);
			} 
			else {
				countZigZag(t.getRight(), d, rightZigZagCounter);
			}
		}
		
		
		if (leftZigZagCounter != null && rightZigZagCounter != null) {
			c.incrementBy(leftZigZagCounter.getCount() > rightZigZagCounter.getCount() ? leftZigZagCounter.getCount() : rightZigZagCounter.getCount());
		}
		else if (leftZigZagCounter != null) {
			c.incrementBy(leftZigZagCounter.getCount());
		}
		else if (rightZigZagCounter != null) {
			c.incrementBy(rightZigZagCounter.getCount());
		}
		
//		System.out.println("exit t:" + ((BinarySearchTree) t).getValue() + " d: "+ d + " c: " + c.getCount());
		return c.getCount();
	}
	public static int longestZigZag(Tree tree) {
		
		return countZigZag(tree, new Direction(true), new Counter());
	}
	public static void main(String[] args) {
		Tree tree;
		tree = BalancedBinarySearchTreeCreator.create(new int[] {1,2,3,4,5,6,7,8,9,10,11});
		System.out.println("longest zigzag: " + ZigZagCounter.longestZigZag(tree));
		
		BinarySearchTree bst = new BinarySearchTree(1);
		bst.addAll(20,5,10,6,9,7,8,40,30,35,39,36,37);
		tree = bst;
		System.out.println("longest zigzag: " + ZigZagCounter.longestZigZag(tree));
	}
}
