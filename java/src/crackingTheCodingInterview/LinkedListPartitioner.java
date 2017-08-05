package crackingTheCodingInterview;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import dataStructures.LinkedList;

public class LinkedListPartitioner<T> extends LinkedList<T> {
	public LinkedListPartitioner() {
		super();
	}

	public void partition(T partitioner) throws IllegalClassFormatException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (!implementsComparable(partitioner)) {
			throw new IllegalClassFormatException("LinkedList generic type does not implement Comparable interface");
		}

		System.out.println(this);

		Node<T> pivot = null;
		Node<T> previous = null;
		Node<T> curr = first;
		Method m;
		int c, i = 0;

		m = partitioner.getClass().getMethod("compareTo", new Class<?>[] { Object.class });

		while (i < size) {
			c = (int) m.invoke(partitioner, curr.getValue());

			if (c < 0) {
				last.setNext(curr);
				last = curr;
				System.out.println("bigger: " + curr);

				if (previous == null) {
					first = curr.getNext();
					curr = first;
				} else {
					previous.setNext(curr.getNext());
					curr = previous.getNext();
				}

				last.setNext((T) null);

			} else if (c == 0) {
				System.out.println("equal: " + curr);
				System.out.println(previous);
				if (pivot == null) {
					pivot = curr;
					previous = curr;
					curr = curr.getNext();
				} else {

					if ((int) m.invoke(curr.getValue(), previous.getValue()) == 0) {
						previous = curr;
						curr = curr.getNext();
					} else {
						previous.setNext(curr.getNext());
						curr.setNext(pivot.getNext());
						pivot.setNext(curr);
						curr = previous.getNext();
					}
				}
			} else {
				System.out.println("smaller: " + curr);
				if (previous == null) {
					previous = curr;
					curr = curr.getNext();
				} else {
					previous.setNext(curr.getNext());
					curr.setNext(first);
					first = curr;
					curr = previous.getNext();
				}
			}

			i++;
		}

		System.out.println(this);
		System.out.println(last.hasNext());
	}

	private boolean implementsComparable(T v) {
		Class<?>[] interfaces = v.getClass().getInterfaces();
		List<T> l = (List<T>) Arrays.asList(interfaces);

		return l.indexOf(Comparable.class) > -1;
	}

	public static void main(String[] args) {

		LinkedListPartitioner<String> ls = new LinkedListPartitioner<String>();
		LinkedListPartitioner<Integer> l = new LinkedListPartitioner<Integer>();

		ls.addAll("hi", "hello", "salut", "oi");
		l.addAll(1, 4, 2, 3, 4, 5, 3, 6, 4, 3, 2, 1);
		l.addAll(4, 3, 2, 1);
		// l.addAll(1,2,3,4);

		try {
			ls.partition("hi");
			l.partition(4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
