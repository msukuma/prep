package hackerrank;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

import util.Printer;

public class Queue2Stack {
	public static class MyQueue<T> {
		int size = 0;
        Stack<T> oldest = new Stack<T>();
        Stack<T> newest = new Stack<T>();
        
        public boolean isEmpty(){
        	return size == 0;
        }
        
        public void enqueue(T value) { // Push onto newest stack
        	if(isEmpty()){
        		oldest.push(value);
        	}
        	else {
        		newest.push(value);
        	}
            size++;
        }

        public T peek() {
             return oldest.peek();
        }
        
        private void transfer(){
        	while(!newest.isEmpty()){
        		oldest.push(newest.pop());
        	}
        }
        public T dequeue() {
        	T v = oldest.pop();
        	
        	if(oldest.isEmpty()){
        		transfer();
        	}
        	
        	size--;
            return v;
        }
        
        public void addAll(@SuppressWarnings("unchecked") T...values){
        	for (T v : values) {
				enqueue(v);
			}
        }
        
        
    }

    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        File file = new File("data/Queue2Stack/input7"); //
        Scanner in = null;
        
        try{
        	in = new Scanner(file);
        }catch (Exception e) {
        	e.printStackTrace();
		}
        int numOperations = in.nextInt();
        
        for (int i = 0; i < numOperations; i++) {
            int operation = in.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(in.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        in.close();
       
    }
}
