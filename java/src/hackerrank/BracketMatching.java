package hackerrank;

import java.util.*;

import util.Printer;

public class BracketMatching {
	public static class Pair{
		Opener opener;
		Closer closer;
		
		public Pair(char oc, char cc){
			opener = new Opener(oc);
			closer = new Closer(cc);
			
			opener.setCloser(closer);
			closer.setOpener(opener);
		}
		
	}

	public static class Opener{
		static List<Character> openersArray = Arrays.asList('(', '{', '[', '<');
		static HashSet<Character> openersSet = new HashSet<Character>(openersArray);
		char character;
		Closer closer;
		
		public Opener (char c){
			character = c; 
		}
		
		public void setCloser(Closer closer){
			this.closer = closer;
		}
	}
	
	public static class Closer{
		static List<Character> closersArray = Arrays.asList(')', '}', ']', '>');
		static HashSet<Character> closersSet = new HashSet<Character>(closersArray);
		char character;
		Opener opener;
		
		public Closer (char c){
			character = c; 
		}
		
		public void setOpener(Opener opener){
			this.opener = opener;
		}
	}
	
	public static class Helpers{
		
		public static Pair createPair(char c){
			Pair pair;
			switch (c) {
			case '(':
				pair = new Pair('(', ')');
				break;
				
			case '[':
				pair = new Pair('[', ']');
				break;
				
			case '{':
				pair = new Pair('{', '}');
				break;

			case '<':
				pair = new Pair('<', '>');
				break;
			
			default:
				pair = null;
				break;
			}
			
			
			return pair;
		}
		
		public static boolean isOpener(char c){
			return Opener.openersSet.contains(c);
		}
		
		public static boolean isCloser(char c){
			return Closer.closersSet.contains(c);
		}
    }
    
    public static boolean isBalanced(String expression) {
       boolean answer = true;
			char[] charsArray = expression.toCharArray();
			Stack<Opener> order = new Stack<Opener>();
	
			
			for (int i = 0; i < charsArray.length; i++) {
				char c = charsArray[i];
				Pair pair = Helpers.createPair(c);
				
				if(Helpers.isOpener(c)){
					order.push(pair.opener);
				}
				else if (Helpers.isCloser(c)) {
					Opener mustMatch;
					
					if(order.isEmpty()) {
						answer = false;
						break;
					}
					
					mustMatch= order.pop();
					
					if(mustMatch.closer.character != c) {
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
		isBalanced("hel[l]o)");
	}

}
