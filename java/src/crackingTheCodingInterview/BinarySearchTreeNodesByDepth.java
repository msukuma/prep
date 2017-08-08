package crackingTheCodingInterview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

import dataStructures.BinarySearchTree;

public class BinarySearchTreeNodesByDepth {
	public static HashMap<Integer, LinkedList<BinarySearchTree>> mapNodeByDepth(BinarySearchTree bst) {
		HashMap<Integer, LinkedList<BinarySearchTree>> map = new HashMap<Integer, LinkedList<BinarySearchTree>>();
		int depth = 1;
		LinkedList<BinarySearchTree> parents;
		LinkedList<BinarySearchTree> children = new LinkedList<BinarySearchTree>();
		int treesWithOutLeaves = 0;
		
		
		children.add(bst);
		map.put(0, children);
		
		while(true){
			parents = map.get(depth - 1);
			children = new LinkedList<BinarySearchTree>();
			
			for (BinarySearchTree parent : parents) {
				if(parent.getLeft() != null){
					children.add((BinarySearchTree) parent.getLeft());
				}
				
				if (parent.getRight() != null) {
					children.add((BinarySearchTree) parent.getRight());
				}
				
				if(parent.getLeft() == null && parent.getRight() == null) {
					treesWithOutLeaves += 1;
				}
			}
			
			if(treesWithOutLeaves == parents.size()){
				break;
			}
			
			map.put(depth, children);
			
			treesWithOutLeaves = 0;
			depth++;
		}
		
		for(Entry<Integer, LinkedList<BinarySearchTree>> entry : map.entrySet()){
			System.out.println(""+ entry.getKey() + " = " + entry.getValue().size());
		}
		return map;
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst;
		bst = BalancedBinarySearchTreeCreator.create(new int[] {1,2,3,4,5,6,7,8,9,10,11});
		
		BinarySearchTreeNodesByDepth.mapNodeByDepth(bst);
	}
}
