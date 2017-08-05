package crackingTheCodingInterview;

import java.util.Arrays;

public class BlanksReplacer {
	char BLANK = ' ';
	char[] r;
	char[] s;
	public BlanksReplacer(String replacer){
		r = replacer.toCharArray();
	}
	
	private boolean isBlank(int i){
		return s[i] == BLANK;
	}
	
	private void insertReplacements(int i){
		for (int j = 0; j < r.length; j++, i++) {
			s[i] = r[j];
		}
	}
	
	private void shift(int blankIndex) throws IllegalArgumentException{
		int lastIndex = s.length - 1;
		
		if(blankIndex + (r.length - 1) > lastIndex) throw new IllegalArgumentException();
		
		for(int i = lastIndex; i >= blankIndex; i--){
			s[i] = s[i - (r.length - 1)];
		}
	}
	
	private int nextNonBlankIndex(int i){
		while(i < s.length && isBlank(i) ){
			i++;
		}
		
		return i;
	}
	
	private int nextBlankIndex(int i){
		while(i < s.length && !isBlank(i)){
			i++;
		}
		
		return i;
	}
	
	private int indexOfLastNoneBlank(){
		int i;
		
		for (i = s.length - 1; i < 0 ; i--) {
			if(!isBlank(s[i])){
				return i;
			}
		}
		
		return i;
	}
	
	public String replaceBlanks(String string){
		s = string.toCharArray();
		if (s.length == 0)  return new String(s);
		
		for (int i = nextBlankIndex(0); i < s.length; i = nextBlankIndex(i)) {
			shift(i);
			insertReplacements(i);
		}

		System.out.println(new String(s));
		return new String(s);
	}
	
	public static void main(String[] args) {
		BlanksReplacer br = new BlanksReplacer("%20");
		
		br.replaceBlanks("Mr John Smith    ");
		br.replaceBlanks("Mr  John  Smith        ");
		br.replaceBlanks("");
		
		br = new BlanksReplacer("*");
		br.replaceBlanks("Mr John Smith    ");
		br.replaceBlanks("Mr  John  Smith        ");
		br.replaceBlanks("");
	}
	
	
}
