package CoinChange;

import java.util.HashMap;

import util.Printer;

public class Node {
	private int number;
	private HashMap<Integer, Node> children;
	private Node parent;
	private boolean end;
	
	public Node(int n, Node p){
		number = n;
		children = new HashMap<Integer, Node>();
		parent = p;
		end = false;
	}
	
	public int getNumber(){
		return number;
	}
	
	public HashMap<Integer, Node> getChildren(){
		return children;
	}
	
	public void addChild(int number, Node parent){
		addChild(new Node(number, parent));
	}
	
	public void addChild(Node child){
		children.put(child.getNumber(), child);
	}
	
	public boolean hasChild(int child){
		return children.containsKey(child);
	}
	
	public Node getChild(int child){
		return children.get(child);
	}
	
	public boolean isEnd(){
		return end;
	}
	
	public void makeEnd(){
		end = true;
	}
	
	static void puts(Object o){
		Printer.puts(o);
	}
}
