package hackerrank;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import dataStructures.MaxHeap;
import dataStructures.MinHeap;
import dataStructures.SortedList;
import util.Printer;

public class RunningMedian {
				
	public static float median(SortedList<Integer> list){
		if(list.isEmpty()){
			throw new IllegalStateException();
		}
		else {
			int size = list.size();
			int mid = size/2;
			
			if(size % 2 == 0){
				return (float)(((int)list.get(mid) + (int)list.get(mid - 1))/2.0);
			}
			else {
				return (float)list.get(mid);
			}
		}
	}
	
	public static void main(String[] args) {
		File file = new File("data/RunningMedian/input0");
        Scanner in = null;
        
        try{
        	in = new Scanner(file);
        }catch (Exception e) {
        	e.printStackTrace();
		}
        
        int capacity = in.nextInt();
        SortedList<Integer> order = new SortedList<Integer>(capacity);

        
        
        for(int a_i=0; a_i < capacity; a_i++){
        	int n = in.nextInt();
            order.add(n);
            Printer.puts(median(order));
        }		
        
        
    }
}
