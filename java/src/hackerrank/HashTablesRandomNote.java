package hackerrank;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class HashTablesRandomNote {
	public static void yes(){
        System.out.println("Yes");
    }
    
    public static void no(){
        System.out.println("No");
    }

    public static void main(String[] args) {
    	File file = new File("data/HashTablesRandomNote/input8");
//    	File file = new File("data/HashTablesRandomNote/myInput");
        Scanner in = null;
        
        try{
        	in = new Scanner(file);
        }catch (Exception e) {
        	e.printStackTrace();
		}
        
        int m = in.nextInt();
        int n = in.nextInt();
        
        if(n > m){
            no();
            return;
        }
        
        HashMap<String, Integer> magazine = new HashMap<String, Integer>();
        String word;
        
        for(int i=0; i < m; i++){
        	word = in.next();
        	if(magazine.containsKey(word)){
        		magazine.put(word, magazine.get(word)+1);
        	}
        	else {
        		magazine.put(word, 1);
        	}
        }
        

        for(int j=0; j < n; j++){
        	word = in.next();
            
        	if(magazine.containsKey(word) && magazine.get(word) > 0){
        		magazine.put(word, magazine.get(word) - 1);               
            }
            else {
            	no();
            	return;
            }
        }
        
        yes();
    }
}
