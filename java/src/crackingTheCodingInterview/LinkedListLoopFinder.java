package crackingTheCodingInterview;

import java.util.Arrays;
import java.util.HashSet;

import dataStructures.LinkedList;
import dataStructures.LinkedList.Node;

public class LinkedListLoopFinder {
	public static <T> Node<T> findLoop(Node<T> head) {
		HashSet<Node<T>> visited = new HashSet<Node<T>>();
		Node<T> curr =  head;
		while(curr != null){
			if(visited.contains(curr)){
				return curr;
			}
			visited.add(curr);
			curr = curr.getNext();
		}
		
		return null;
	}
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addAll(1,2,3);
		Node<Integer> first = list.getFirstNode();
		list.addNodeLast(first);
		System.out.println(LinkedListLoopFinder.findLoop(first));
	}

	
}
