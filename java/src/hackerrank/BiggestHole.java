package hackerrank;

import util.Printer;

public class BiggestHole {

	static int[] initA(int l){
		int[] array = new int[l];
		
		for (int i = 0; i < l; i++) {
			array[i] = 1;
		}
		
		return array;
	}
	
	static int[] makeChanges(int[] array, int[] changes){
		for (int i = 0; i < changes.length; i++) {
			int c = changes[i];
			array[c] += array[c - 1];
//			array[c - 1] = 0;
		}
		
		return array;
	}
	
	static int getMax(int[] array){
		if(array.length < 1) throw new IllegalStateException();
		int max = array[0];
		
		for (int i = 0; i < array.length; i++) {
			if(array[i] > max){
				max = array[i];
			}
		}
		
		return max;
	}
	
	static int solution(int n, int m, int[] h, int[] v){
		int[] rows = makeChanges(initA(n+1), h);
		int[] cols = makeChanges(initA(m+1), v);
		
		return  getMax(rows) * getMax(cols); 
	}
	
	public static void main(String[] args) {
		
		int[] hChanges = {3};
		int[] vChanges = {1,2};
		
		int solution = solution(3,3,hChanges, vChanges);  
		
		Printer.puts(solution);
	}
}
