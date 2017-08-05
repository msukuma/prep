package other;

import java.util.HashMap;

public class TopTalCodality {
	static boolean oneSwap(int[] a){
		int e,n;
		int p = 0;
		int x = 0;
		
		for (int i = 0; i < a.length - 1; i++) {
			e = a[i];
			n = a[i+1];
			
			if(e > n){
				a[i] = n;
				a[i+1] = e;
			}
			
			if(i > 0 && p != n){
				x++;
			}
			
			if(x > 2){
				return false;
			}
			
			p = n;
		}
		
		return true;
	}
	
	static class Tree{
		Tree left;
		Tree right;
	}
	
	static HashMap<Tree, Integer> parentToDirection = new HashMap<Tree, Integer>();
	
	static boolean hasParent(Tree t){
		return parentToDirection.get(t) != 0;
	}
	
	static boolean parentOnleft(Tree t){
		return parentToDirection.get(t) == -1;
	}
	
	static boolean parentOnRight(Tree t){
		return parentToDirection.get(t) == 1;
	}
	
	static int zigzag(Tree t){
		if(hasParent(t)){
			
		}else {
			
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int[] a= {1,3,5,3,7};
		
		System.out.println(oneSwap(a));
	}
}
