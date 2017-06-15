package CoinChange;

import java.util.List;

public class ListAddAllTask implements Runnable{
	int index;
	List<Integer> a;
	int e;
	
	public ListAddAllTask(int index, List<Integer> a, int e){
		this.index = index;
		this.a = a;
		this.e = e;
	}

	@Override
	public void run() {
		a.add(index, e);
	}
}
