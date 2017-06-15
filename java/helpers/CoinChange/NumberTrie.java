package CoinChange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dataStructures.SortedList;

import java.util.Map.Entry;

import util.Printer;

public class NumberTrie {
	private Node top;
	private long size;
	
	public NumberTrie(){
		top = new Node(-1, null);
		size = 0;
	}
	
	public long size(){
		return size;
	}
	
	public void adjustSizeBy(long a){
		size += a;
	}
	
	public Node getTop(){
		return top;
	}
	
	private Node updateCurr(Node curr, int c){
		if(curr.hasChild(c)){
			curr = curr.getChild(c);
		}
		else {
			Node child = new Node(c, curr);
			curr.addChild(child);
			curr = child;
		}
		
		return curr;
	}
	
	private void incrementSize(Node curr){
		if(!curr.isEnd()){
			curr.makeEnd();
			size++;
		}
	}
	
	public boolean contains(List<Integer> makeUp){
		int first = makeUp.get(0);
		
		if(!top.hasChild(first)){
			return false;
		}
		
		Node curr = top.getChild(first);
		
		for (int i = 1; i < makeUp.size(); i++) {
			int c = makeUp.get(i);
			
			if(curr.hasChild(c)){
				curr = curr.getChild(c);
			}
			else {
				return false;
			}
		}

		return curr.isEnd();
	}
	
	public boolean contains(Integer...chain){
		int first = chain[0];
		
		if(!top.hasChild(first)){
			return false;
		}
		
		Node curr = top.getChild(first);
		
		for (int i = 1; i < chain.length; i++) {
			int c = chain[i];
			
			if(curr.hasChild(c)){
				curr = curr.getChild(c);
			}
			else {
				return false;
			}
		}

		return curr.isEnd();
		
	}
	
	public void add(Entry<Integer, Integer> entry){
		add(entry.getKey(), entry.getValue());
	}
	
	public void add(SortedList<Integer> chain){
		
	}
	
	public void add(List<Integer> chain){
		int first = chain.get(0);
		Node curr;
		
		if(top.hasChild(first)){
			curr = top.getChild(first);
		}
		else {
			curr = new Node(first, top);
			top.addChild(curr);
		}
		
		for (int i = 1; i < chain.size(); i++) {
			curr = updateCurr(curr, chain.get(i));
		}
		
		incrementSize(curr);
	}
	
	public void add(Integer...chain){
		int first = chain[0];
		Node curr;
		
		if(top.hasChild(first)){
			curr = top.getChild(first);
		}
		else {
			curr = new Node(first, top);
			top.addChild(curr);
		}
		
		for (int i = 1; i < chain.length; i++) {
			curr = updateCurr(curr, chain[i]);
		}
		
		incrementSize(curr);
	}
	
	

	static void puts(Object o){
		Printer.puts(o);
	}
	
	public static void main(String[] args) {
		NumberTrie t = new NumberTrie();
		
		
//		t.add(1,2,3,4,5);
//		t.add(1,2,2,3,3);
//		t.add(1,2,2,3,4);
//		t.add(3,1,2,3,4);
//		
//		puts(t.contains(1,2,3,4,5));
//		puts(t.contains(1,2,2,3,3));
//		puts(t.contains(1,2,2,3,4));
//		puts(t.contains(3,1,2,3,4));
	}
}
