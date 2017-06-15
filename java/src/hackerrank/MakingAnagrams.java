package hackerrank;

import java.util.HashMap;
import java.util.Map.Entry;

import util.Printer;

public class MakingAnagrams {
	static HashMap<Character, Integer> toMap(String str){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(map.containsKey(c)){
				map.put(c, map.get(c) + 1);
			}
			else {
				map.put(c, 1);
			}
		}
		
		return map;
	}
	static int numberNeeded(String first, String second) {
		int count = 0;
		HashMap<Character, Integer> mapF = toMap(first);
		HashMap<Character, Integer> mapS = toMap(second);
		
		HashMap<Character, Integer> bigger = mapF.size() > mapS.size() ? mapF : mapS;
		HashMap<Character, Integer> smaller = mapF.size() > mapS.size() ? mapS : mapF;
		
		
		for (Entry<Character, Integer> set : smaller.entrySet()) {
			char key = set.getKey();
			int value = set.getValue();
			
			if(bigger.containsKey(key)){
				bigger.put(key, Math.abs(value - bigger.get(key)));
			}
			else {
				bigger.put(key, value);
			}
			
		}
		
		for (int value : bigger.values()) {
			count += value;
		}
		
		return count;
    }
	
	public static void main(String[] args) {
		Printer.puts(numberNeeded("abbc", "cnblmnode"));
	}
}
