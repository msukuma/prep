package crackingTheCodingInterview;

public class StringCompressor {
	char[] s;
	public StringCompressor(){
		
	}
	
	private int count(int i){
		
		return 0;
	}
	
	public String compress(String string){
		if(string.length() < 1) return string;
		
		s = string.toCharArray();
		String cmp = "";
		int c = 1;
		char p = s[0];
		char ch;
		
		for (int i = 1; i < s.length; i++) {
			ch = s[i];
			
			if(p == ch){
				c++;
			} else {
				cmp += "" + p + c;
				
				if(cmp.length() >= s.length){
					System.out.println(string);
					return string;
				} 
				
				c = 1;
			}
			p = ch;
		}
		
		cmp += "" + p + c;
		
		if(cmp.length() >= s.length){
			System.out.println(string);
			return string;
		} 
		
		System.out.println(new String(cmp));
		return new String(cmp);

	}
	
	public static void main(String[] args) {
		StringCompressor sc = new StringCompressor();
		
		
		
		sc.compress("aabcccccaaa");
		sc.compress("aabccccca");
		sc.compress("abc");
		sc.compress("a");
		
	}
}
// a2b1c5a3
