package crackingTheCodingInterview;

import dataStructures.BinarySearchTree;
import dataStructures.Counter;
import dataStructures.Tree;

public class TreeBalanceChecker {
	
	private static int depth(Tree t){
//		System.out.println(1 + depth(t, new Counter()));
		if(t != null){
			return 1 + depth(t, new Counter());
		}
		else {
			return 0;
		}
	}
	
	private static  int depth(Tree t, Counter dc){
		Counter lc = null;
		Counter rc = null;
		
		if(t.getLeft() != null){
			lc = new Counter();
			lc.increment();
			depth(t.getLeft(), lc);
		} 
		
		if(t.getRight() != null) {
			rc = new Counter();
			rc.increment();
			depth(t.getRight(), rc);
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
	
	public static boolean isBalanced(Tree tree) {
		return Math.abs(depth(tree.getLeft()) - depth(tree.getRight())) < 2;

	}
	
	public static void main(String[] args) {
		BinarySearchTree bst;
	
		bst = new BinarySearchTree(5);
		bst.addAll(1,6,8,9,10);
		System.out.println(isBalanced(bst));

		bst = new BinarySearchTree(5);
		bst.addAll(1,6);
		System.out.println(isBalanced(bst));
	}
}
