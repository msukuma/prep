package other;

public class Equilibrium {
	public static int sum(int[] A, int from, int to){
        int s = 0;
        
        for(int i = from; i <= to; i++){
            s += A[i];        
        }
        System.out.println(s);
        return s;
    }
    public int solution(int[] A) {
        // write your code in Java SE 8
        int lastIndex = A.length - 1;
        int sumLeft = sum(A, 0, lastIndex);
        int sumRight = 0;
        int prev = 0;
        int i;
        
        for(i = lastIndex; i >= 0 ; i--){
            sumLeft -= A[i];
            sumRight += prev;
            prev = A[i];
            
            if(sumLeft == sumRight){
                break;
             }
        }
        System.out.println(i);
        return i;
    }
    public static void main(String[] args) {
    	int[] A ={-1,3,-4,5,1,-6,2,1};
    	
    	new Equilibrium().solution(A);
		
	}
}
