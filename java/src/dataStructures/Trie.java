package dataStructures;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;


public class Trie {
	private static char nullChar = '\u0000';
	
	public static class Node {
		private char character;
		private Node parent;
		private HashMap<Character, Node> childrenMap;
		private boolean wordEnder;
		private int numWords; 
		
		public Node(char character, Node parent){
			this.character = character;
			this.parent = parent;
			childrenMap = new HashMap<Character, Node>();
			wordEnder = false;
			numWords = 0;
			
		}
		
		public Node(char character){
			this.character = character;
			parent = null;
			childrenMap = new HashMap<Character, Node>();
			wordEnder = false;
			numWords = 0;
		}
		
		public char getCharacter(){
			return character;
		}
		
		public Node getParent(){
			return parent;
		}
		
		public void setparent(Node parent){
			this.parent = parent;
		}
		
		public boolean hasChild(char c){
			return childrenMap.containsKey(c);
		}
		
		public void addChild(char c){
			Node child = new Node(c, this);
			childrenMap.put(c, child);
		}
		
		public Node getChild(char c){
			return childrenMap.get(c);
		}
		
		public Collection<Node> getChildren(){
			return childrenMap.values();
		}
		
		public boolean endsWord(){
			return wordEnder;
		}
		
		public void setEndsWord(String word){
			wordEnder = true;
			numWords++;
			
			Node parent = this.parent;
			
			while(parent.getCharacter() != nullChar){
				parent.addWord();
				parent = parent.getParent();
			}
			
		}
		
		public LinkedList<Node> getWordEnders(LinkedList<Node> wordEnders){
			if(this.endsWord()){
				wordEnders.add(this);
			}
			
			for (Node child : getChildren()) {				
				child.getWordEnders(wordEnders);
			}
			
			return wordEnders;
		}
		
		public void addWord(){
			numWords++;
		}
		
		public int getNumWords(){
			return numWords;
		}

	}
	
	private Node root;
	
	public Trie(){
		root = new Node(nullChar);
	}	
	
	public void add(String word){
		Node current = root;
		
		for(char c : word.toCharArray()){
			if(!current.hasChild(c)){
				current.addChild(c);
			}
			
			current = current.getChild(c);
		}
		
		current.setEndsWord(word);

	}
	
	private Node getPartialEnd(String partial){
		Node current = root;
		
		for(char c : partial.toCharArray()){
			if(!current.hasChild(c)){
				return null;
			}
			
			current = current.getChild(c);
		}
		return current;
		
	}
	
	public int find(String partial){
		Node partialEnd = getPartialEnd(partial);
		
		if(partialEnd == null){
			return 0;
		}
		
		return partialEnd.getNumWords();
	}
}
