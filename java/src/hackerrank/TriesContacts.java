package hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import dataStructures.Trie;


public class TriesContacts {
	
	public static void main(String[] args) {
		Trie t = new Trie();
		Scanner s;
		File f = new File("data/TriesContacts/input12");
		
        try {
			s = new Scanner(f);

			long start = System.currentTimeMillis();
			int numOps = s.nextInt();
	        for(int n = 0; n < numOps; n++){
	            String op = s.next();
	            String contact = s.next();
	                  
	            if(op.equals("add")){
	                t.add(contact);
	            } else if(op.equals("find")){
	                System.out.println((n+1) +" -> "+contact+": " + t.find(contact));
	            }
	        }
			long end= System.currentTimeMillis();
			System.out.println("Duration: "+ (end - start));
	        s.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
        	
	}
}
