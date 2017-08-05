package crackingTheCodingInterview;

import java.util.HashMap;

public class StringPermutation {
	String s;
	HashMap<Character, Integer> m;
	
	public StringPermutation(String s){
		this.s = s;
		indexString();
	}
	
	private void indexString(){
		char c;
		m = new HashMap<Character, Integer>();
		
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			
			if(m.containsKey(c)){
				m.put(c, m.get(c) + 1);
			}
			else{
				m.put(c, 1);
			}
		}
	}
	
	public boolean isPermutationOf(String someString){
		if (s.length() != someString.length()) {
			System.out.println(false);
			return false;
		}
		
		StringPermutation sp = new StringPermutation(someString);
		
		for(Character c : m.keySet()){
			if(m.get(c) != sp.m.get(c) ){
				System.out.println(false);
				return false;
			}
		}
		
		System.out.println(true);
		return true;
	}
	
	public static void main(String[] args) {
		StringPermutation sp = new StringPermutation("abc");
		sp.isPermutationOf("abc");
		sp.isPermutationOf("cba");
		sp.isPermutationOf("bac");
		sp.isPermutationOf("abd");
		sp.isPermutationOf("bacd");
		
	}
}
