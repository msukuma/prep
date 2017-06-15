package CoinChange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import util.Printer;

public class CombinerTask2 implements Runnable{
	private List<Integer> wayA;
	private List<Integer> wayB;
	private List<List<Integer>> ways;
	private List<Integer> uncheckedWay;
	
	public CombinerTask2(List<Integer> wayA, List<Integer> wayB, List<List<Integer>> ways){
		this.wayA= wayA;
		this.wayB= wayB;
		this.ways = ways;
		uncheckedWay = new ArrayList<Integer>(wayA.size() + wayB.size());
	}
	
	private void addAll(int start, List<Integer> list){
		ExecutorService service = Executors.newFixedThreadPool(list.size());
		int listIndex = 0;
		
		for (int i = start; listIndex < list.size(); i++, listIndex++) {
			service.submit(new ListAddAllTask(i, uncheckedWay, list.get(listIndex)));
//			(new Thread(new ListAddAllTask(i, uncheckedWay, list.get(listIndex)))).start();
		}
		service.shutdown();
		try {
			service.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void run() {
		addAll(0, wayA);
		addAll(wayA.size(), wayB);
//		uncheckedWay.addAll(wayA);
//		uncheckedWay.addAll(wayB);
//		Printer.puts("wayA: "+wayA);
//		Printer.puts("wayB: "+wayB);
//		Printer.puts("uncheckedWay: "+ uncheckedWay);
		ways.add(uncheckedWay);
	}
}
