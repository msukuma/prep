package other;

import java.sql.Time;
import java.util.Arrays;

public class Testing {
	static class Task implements Runnable{
		int[] a;
		int[] b;
		int i;
		
		public Task(int[] a, int[] b, int i){
			this.a = a;
			this.b = b;
			this.i = i;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			b[i] = a[i]*a[i];
		}
		
	}
	int[] a;

	public Testing(int[] array){
		a = array;
	}
	
	public void squareS(){
		int[] b = new int[a.length];
		
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i]*a[i];
		}
		
		System.out.println(Arrays.toString(b));
		
	}
	
	public void squareP(){
		int[] b = new int[a.length];
		
		for (int i = 0; i < a.length; i++) {
			(new Task(a, b, i)).run();
		}
		
		System.out.println(Arrays.toString(b));
	}
	
	public static void main(String[] args) {
		int[]a = {1,2,3,4,5,6};
		
		Testing t = new Testing(a);
		long s = System.currentTimeMillis();
		t.squareP();
		long e = System.currentTimeMillis();
	
		System.out.println(e-s);
		
		s = System.currentTimeMillis();
		t.squareS();
		e = System.currentTimeMillis();
		System.out.print(e-s);
	}
}
