package dataStructures;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import util.Printer;

public class MaxHeap {
	private int capacity;
	private int size;
	private int[] items;
	
	public MaxHeap(int capacity){
		this.capacity = capacity;
		size = 0;
		items = new int[capacity];
	}
	
	private int getLeftChildIndex(int parentIndex){ return 2 * parentIndex + 1; }
	private int getRightChildIndex(int parentIndex){ return 2 * parentIndex + 2; }
	private int getParentIndex(int childIndex){ return (childIndex - 1)/2; }
	
	private boolean hasLeftChild(int parentIndex) { return getLeftChildIndex(parentIndex) < size; }
	private boolean hasRightChild(int parentIndex) { return getRightChildIndex(parentIndex) < size; }
	private boolean hasParent(int childIndex) { return getParentIndex(childIndex) >= 0; }
	
	private int leftChild(int parentIndex) { return items[getLeftChildIndex(parentIndex)]; }
	private int rightChild(int parentIndex) { return items[getRightChildIndex(parentIndex)]; }
	private int parent(int childIndex) { return items[getParentIndex(childIndex)]; }
	
	private void ensureCapacity(){
		if(size == capacity){
			capacity = capacity << 1;
			items = Arrays.copyOf(items, capacity);
		}
	}
	
	private void swap(int a, int b){
		int tmp = items[a];
		items[a] = items[b];
		items[b] = tmp;
	}
	
	
	private void heapifyDown(){
		int parentIndex = 0;
		int smallerChildIndex;
		
		while(hasLeftChild(parentIndex)){
			smallerChildIndex = getLeftChildIndex(parentIndex);
			
			if (hasRightChild(parentIndex) && leftChild(parentIndex) < rightChild(parentIndex)) {
				smallerChildIndex = getRightChildIndex(parentIndex);
			}
			
			if(items[parentIndex] > items[smallerChildIndex]){
				swap(parentIndex, smallerChildIndex);
			} else {
				break;
			}
			
			parentIndex = smallerChildIndex;
		}
	}
	
	private void heapifyUp(){
		int childIndex = size - 1;
		int parentIndex;
		while(hasParent(childIndex) && items[childIndex] > parent(childIndex)){
			parentIndex = getParentIndex(childIndex);
			swap(childIndex, parentIndex);
			childIndex = parentIndex;
		}
	}
	
	public int peak(){
		if(size < 1) { throw new IllegalStateException(); }
		return items[0];
	}
	
	public int poll(){
		if(size < 1) { throw new IllegalStateException(); }
		
		int item  = items[0];
		items[0] = items[size -1];
		size--;
		heapifyDown();
		return item;
	}
	
	public void add(int n){
		ensureCapacity();
		items[size] = n;
		size++;
		heapifyUp();
	};
	
	public void addAll(int ...args){
		for (int i = 0; i < args.length; i++) {
			add(args[i]);
		}
	}
	
	public void print(){
		Printer.print(items, size);
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
        MaxHeap max = new MaxHeap(capacity);
        
        for(int a_i=0; a_i < capacity; a_i++){
            max.add(in.nextInt());
            max.print();
        }		
	}

}
