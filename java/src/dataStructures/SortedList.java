package dataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import util.Printer;

public class SortedList<E> {
	private Object[] items;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;

	public SortedList(){
		size = 0;
		items = new Object[DEFAULT_CAPACITY];
	}

	public SortedList(int capacity){
		size = 0;
		items = new Object[capacity];
	}

	public int lastIndex(){
		if (isEmpty()) {
			return size;
		}

		return size - 1;
	}

	public void shift(int stop) throws IndexOutOfBoundsException{
		for(int i = size; i>0 && i>=stop; i--){
			items[i] = items[i-1];
		}

	}

	public boolean isEmpty(){
		return size == 0;
	}

	public int size(){
		return size;
	}

	public List<E> toList(){
		List<E> list = new ArrayList<E>(size);

		for (int i = 0; i < size; i++) {
			list.add(get(i));
		}

		return list;
	}

	@SuppressWarnings("unchecked")
	public E get(int index) throws IndexOutOfBoundsException{
		return (E) items[index];
	}

	@SuppressWarnings("unchecked")
	private int getIndex(E n){
		if(isEmpty()){
			return size;
		}

		int l = 0;
		int h = lastIndex();
		int mid;
		int compareResult;
		E item;

		while(h > l){
			mid = (h+l)/2;
			item = (E) items[mid];
			compareResult = compare(item, n);

			if(compareResult == 0){
				return mid;
			}
			else if(compareResult > 0){
				h = mid - 1;
			}
			else {
				l = mid + 1;
			}
		}

		if(h < 0){
			h = 0;
		}

		item = (E) items[h];

		if(compare(item,n) < 0){
			h+=1;
		}

		return h;
	}

	@SuppressWarnings("unchecked")
	private int compare(E a, E b){
		return ((Comparable<E>) a).compareTo(b);
	}

	private void checkCapacity(){
		int l = items.length == 0 ? DEFAULT_CAPACITY: items.length * 2;
		if(size == items.length){
			items = Arrays.copyOf(items, l);
		}
	}

	public void add(E toAdd){
		checkCapacity();
		int index = getIndex(toAdd);
		shift(index);
		items[index] = toAdd;

		size++;
	}

	public void addAll(@SuppressWarnings("unchecked") E...items){
		for (E e : items) {
			add(e);
		}
	}

	public void addAll(Collection<E> c){
		for (E e : c) {
			add(e);
		}
	}

	public String toString(){
		return Arrays.toString(items);

	}

	public static void main(String[] args) {
		SortedList<Integer> s = new SortedList<Integer>(3);
//		SortedList<String> s = new SortedList<String>(3);

//		s.addAll(200, 9,9,9,99,9,4,3,8,2,1,9,4,7);
//		s.addAll(3,2,1,4,3,3,3,7);
		Integer[] numbers = {12,11,10,9,8,7,6,5,4,3,2,1};
//		s.addAll(12,11,10,9,8,7,6,5,4,3,2,1);
		s.addAll(numbers);


//		s.addAll("g","l","d","a","adb", "abc");
		Printer.puts(s.toList());
	}
}
