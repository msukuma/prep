package crackingTheCodingInterview;

import dataStructures.BinarySearchTree;
import dataStructures.Tree;

public class BalancedBinarySearchTreeCreator {
	public static BinarySearchTree<Integer> create(int[] array) {
		BinarySearchTree<Integer> bst;
		
		int mid = array.length / 2;
		int l = mid;
		int h = mid;
		int step = array.length > 3 ? 2 : 1;
		
		bst = new BinarySearchTree<Integer>(array[l]);
		
		while(l - step >= 0){
			bst.add(array[l - step]);
			
			if ((l - step) + 1 != mid ) {
				bst.add(array[(l - step) + 1]);
			}
			
			l -= step;
			
			if(h + step < array.length){
				bst.add(array[h + step]);
				
				if(h + step - 1 != mid){
					bst.add(array[h + step - 1]);
				}
				
				h += step;
			}
		}
		
		if(l == 1){
			bst.add(array[--l]);
		}
		
		if(h == array.length - 2){
			bst.add(h + 2);
		}
		
		
		System.out.println(bst);
		System.out.println("balanced?: " + TreeBalanceChecker.isBalanced(bst));
		return bst;
	}
	public static void main(String[] args) {
		BalancedBinarySearchTreeCreator.create(new int[] {1,2,3,4,5,6,7,8,9,10,11});
		BalancedBinarySearchTreeCreator.create(new int[] {1,2,3});
		BalancedBinarySearchTreeCreator.create(new int[] {1,2});
		BalancedBinarySearchTreeCreator.create(new int[] {1});
	}
}
