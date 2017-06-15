package hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MergeSortCountInversions {

    public static long numInversions;
	
	public static long countInversions(int[] array){
		numInversions = 0;
		mergeSort(array);
		return numInversions;
	}
	public static void mergeSort(int[] array){
		mergeSort(array, new int[array.length], 0, array.length - 1);
	}

	public static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
		if(leftStart >= rightEnd) return;
		
		int mid = (leftStart + rightEnd)/2;
		mergeSort(array, temp,leftStart, mid);
		mergeSort(array, temp, mid + 1, rightEnd);
		mergeHalves(array, temp, leftStart, rightEnd);
	}
	
	public static void mergeHalves(int[] array, int[] temp,int leftStart, int rightEnd){
		int leftEnd = (leftStart + rightEnd)/2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;
		int leftSize = leftEnd - leftStart + 1;
		int leftIndex = leftStart;
		int rightIndex = rightStart;
		int tempIndex = leftStart;
		
		while(leftIndex <= leftEnd && rightIndex <= rightEnd){
			if(array[leftIndex] <= array[rightIndex]){
				temp[tempIndex] = array[leftIndex];
				leftIndex++;
				leftSize--;
			}
			else {
				temp[tempIndex] = array[rightIndex];
				numInversions += leftSize;
				rightIndex++;
			}
			tempIndex++;
		}
		
		if (rightIndex > rightEnd){
			System.arraycopy(array, leftIndex, temp, tempIndex, leftEnd - leftIndex + 1);
		} 
		else if (leftIndex > leftEnd) {
			System.arraycopy(array, rightIndex, temp, tempIndex, rightEnd - rightIndex + 1);
		}
		
		System.arraycopy(temp, leftStart, array, leftStart, size);
	}
  
    public static void main(String[] args) {
    	File file = new File("data/MergeSortCountInversions/input1");
        Scanner in = null;
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        int t = in.nextInt();
        
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(countInversions(arr));
        }
        
        in.close();
    }
    
    
}
