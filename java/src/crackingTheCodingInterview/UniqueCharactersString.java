package crackingTheCodingInterview;

public class UniqueCharactersString {
	static boolean hasUniqueChars(String s){
		s = s.toLowerCase();
		int[] chars = new int[255];
		int x;
		
		for (int i = 0; i < s.length(); i++) {
			x = s.charAt(i);
			
			if(chars[x] == 1){
				System.out.println("false");
				return false;
			}
			else {
				chars[x] = 1;
			}
		}
		System.out.println("true");
		return true;
	}
	public static void main(String[] args) {
		hasUniqueChars("hello");
		hasUniqueChars("helo");
		hasUniqueChars("helo;!");
	}
	
}