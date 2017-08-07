package dataStructures;

public class Counter {
	private int c;
	
	public Counter() {
		c = 0;
	}
	
	public int getCount(){
		return c;
	}
	
	public void setCount(int count){
		c = count;
	}
	
	public void increment() {
		c += 1;
	}
	
	public void decrement() {
		c -= 1;
	}
	
	public void incrementBy(int change){
		c += change;
	}
	
	public void decrementBy(int change) {
		c -= change;
	}
}
