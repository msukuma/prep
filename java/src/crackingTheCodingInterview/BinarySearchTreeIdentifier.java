package crackingTheCodingInterview;

import dataStructures.BinarySearchTree;
import dataStructures.Tree;

public class BinarySearchTreeIdentifier {
	
	@SuppressWarnings("unchecked")
	public static <T> boolean isBinarySearchTree(Tree<T> tree) {
		boolean answer = true;
		
		if (tree.getLeft() != null) {
			answer = answer && ((Comparable<T>) tree.getLeft().getValue()).compareTo(tree.getValue()) < 1 && isBinarySearchTree(tree.getLeft());
		}
		
		if(tree.getRight() != null){
			answer = answer && ((Comparable<T>) tree.getRight().getValue()).compareTo(tree.getValue()) == 1 && isBinarySearchTree(tree.getRight());
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		class MyTree<T> implements Tree<T>{
			T value;
			MyTree left;
			MyTree right;
			
			public MyTree(T value){
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

			@SuppressWarnings("unchecked")
			@Override
			public void add(T value) {
				if(left == null){
					left = new MyTree<T>(value);
				}
				else if(right != null){
					right.add(value);
				}
				else {
					right = new MyTree<T>(value);
				}
				
			}
			
			public void addAll(T ...args){
				for (T value : args) {
					add(value);
				}
			}

			@Override
			public T getValue() {
				return value;
			}
		}
		
		Tree<Integer> t = new MyTree<Integer>(0);
		
		((MyTree<Integer>)t).addAll(50,20,4,8,34,33,90,29);
		System.out.println(BinarySearchTreeIdentifier.isBinarySearchTree(t));
		
		t = BalancedBinarySearchTreeCreator.create(new int[] {1,2,3,4,5,6,7,8,9,10});
		System.out.println(BinarySearchTreeIdentifier.isBinarySearchTree(t));
	}
}
