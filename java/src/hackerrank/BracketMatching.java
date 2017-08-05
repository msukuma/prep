package hackerrank;

import java.util.*;

import util.Printer;

public class BracketMatching {
	public static class Helpers{
		
		public static HashMap<Character, Character> getPairs(){
			HashMap<Character, Character> pairs = new HashMap<Character, Character>();
			pairs.put('(', ')');
			pairs.put('{', '}');
			pairs.put('[', ']');
			pairs.put('<', '>');
			
			return pairs;
		}
    }
    
    public static boolean isBalanced(String expression) {
       boolean answer = true;
       char[] charsArray = expression.toCharArray();
       HashMap<Character, Character> pairs = Helpers.getPairs();
       Stack<Character> order = new Stack<Character>();
       
       for (char c : charsArray) {
    	   if(pairs.containsKey(c)){
    		   order.push(c);
    	   } 
    	   else if (pairs.values().contains(c)){
    		   if(order.isEmpty()) {
    			   answer = false;
    			   break;
				}
    		   
    		   if(!pairs.containsKey(order.pop())){
    			   answer = false;
    			   break;
    		   }
    	   }
       }
       
       if(!order.isEmpty()){
			answer = false;
		}

		Printer.puts(answer);
		return answer;
    }
	
	
	public static void main(String[] args) {
		isBalanced("hel]");
	}

}
