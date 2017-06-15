package hackerrank;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import CoinChange.NumberTrie;
import dataStructures.SortedList;
import util.Printer;

public class CoinChange {
	private List<Integer> options;
	private HashSet<Integer> optionsSet;
	public HashMap<Integer, List<List<Integer>>> waysToMake;
	public HashMap<Integer, List<List<Integer>>> combinedWays;
	public HashMap<Integer, NumberTrie> tries = new HashMap<Integer, NumberTrie>();

	public CoinChange(List<Integer> options){
		Collections.sort(options);
		this.options = options;
		this.optionsSet = new HashSet<Integer>(options);
		waysToMake = new HashMap<Integer, List<List<Integer>>>();
		combinedWays = new HashMap<Integer, List<List<Integer>>>();
	}

	private Set<Entry<Integer, Integer>> getPairs(int n){
		HashMap<Integer, Integer> pairs = new HashMap<Integer, Integer>();
		int smaller;
		int bigger;
		int complement;

		for (Integer option : options) {
			complement = n - option;

			if(complement < 1) {
				break;
			}

			smaller = Math.min(option, complement);
			bigger = Math.max(option, complement);

			if(!pairs.containsKey(smaller)){
				pairs.put(smaller, bigger);
			}
		}

		return pairs.entrySet();
	}

	private boolean hasWaysToMake(int amount){
		return waysToMake.containsKey(amount) && !waysToMake.get(amount).isEmpty();
	}

	private boolean isValidOption(int option){
		return optionsSet.contains(option);
	}

	public void addPairToMakeUp(int amount, int smaller, int bigger){

		if(isValidOption(smaller) && isValidOption(bigger)) {
			List<Integer> pair = new ArrayList<Integer>(2);
			pair.add(smaller);
			pair.add(bigger);

			tries.get(amount).add(pair);
			waysToMake.get(amount).add(pair);
		}
	}

	public int hashCodeOfTwo(int a, int b){
		return a+b*b;
	}

	public List<List<Integer>> combineWays(int amount1, int amount2){
		int hashCode = hashCodeOfTwo(amount1, amount2);

		if(combinedWays.containsKey(hashCode)){
			return combinedWays.get(hashCode);
		}

		List<List<Integer>> ways = new LinkedList<List<Integer>>();


		if (hasWaysToMake(amount1)) {
			combineWaysHelper(amount1, amount2, ways);
		}
		else if (hasWaysToMake(amount2)){
			combineWaysHelper(amount2, amount1, ways);
		}

		combinedWays.put(hashCode, ways);

		return ways;
	}

	public void combineWaysHelper(int amount1, int amount2, List<List<Integer>> ways){
		SortedList<Integer> uncheckedWay;

		for (List<Integer> wayA : waysToMake.get(amount1)) {
			if (isValidOption(amount2)) {
				uncheckedWay = new SortedList<Integer>(wayA.size() + 1);
				uncheckedWay.addAll(wayA);
				uncheckedWay.add(amount2);
				ways.add(uncheckedWay.toList());
			}

			if (hasWaysToMake(amount2)) {
				for (List<Integer> wayB : waysToMake.get(amount2)) {
					uncheckedWay = new SortedList<Integer>(wayA.size() + wayB.size());
					uncheckedWay.addAll(wayA);
					uncheckedWay.addAll(wayB);

					ways.add(uncheckedWay.toList());
				}
			}
		}
	}

	public synchronized void addWaysToMakeUp(int amount, List<List<Integer>> ways){
		NumberTrie trie = tries.get(amount);

		for (List<Integer> way : ways) {
			if(!trie.contains(way)){
				trie.add(way);
				waysToMake.get(amount).add(way);
			}
		}
	}

	public List<List<Integer>> findOrGetWaysToMake(int amount){
		if(!waysToMake.containsKey(amount)){
			waysToMake.put(amount, getWaysToMake(amount));
		}

		return waysToMake.get(amount);
	}

	public List<List<Integer>> getWaysToMake(int amount){
		if (!tries.containsKey(amount)) {
			tries.put(amount, new NumberTrie());
		}

		if (!waysToMake.containsKey(amount)) {
			waysToMake.put(amount, new LinkedList<List<Integer>>());
		}

		int smaller;
		int bigger;


		Set<Entry<Integer, Integer>>_pairs = getPairs(amount);

		for (Entry<Integer, Integer> pair : _pairs) {
			smaller = pair.getKey();
			bigger = pair.getValue();

			addPairToMakeUp(amount, smaller, bigger);

			findOrGetWaysToMake(smaller);
			findOrGetWaysToMake(bigger);

			List<List<Integer>> combinedWays = combineWays(smaller, bigger);

			addWaysToMakeUp(amount, combinedWays);
		}

		return waysToMake.get(amount);
	}

	public static long makeChange(int[] coins, int money) {
        long[] DP = new long[money + 1]; // O(N) space.
        DP[0] = (long) 1; 	// n == 0 case.
        for(int coin : coins) {
            for(int j = coin; j < DP.length; j++) {
//            	puts("coin: "+ coin + " j: "+j);
//            	puts("\tbefore DP["+j+"]: " +DP[j] + " DP["+j+" - "+coin+"]: " + DP[j - coin]);
            // The only tricky step.
                DP[j] += DP[j - coin];
//                puts("\tafter DP["+j+"]: " +DP[j]);
//                puts("\t"+Arrays.toString(DP));
            }
        }
        return DP[money];
    }

	public static void main(String[] args) {
//		File file = new File("data/CoinChange/input0"); // 4
//		File file = new File("data/CoinChange/input1"); // 5
//		File file = new File("data/CoinChange/input2"); // 96190959
//		File file = new File("data/CoinChange/input9"); // 15685693751
//		File file = new File("data/CoinChange/input13"); // 370927
//		File file = new File("data/CoinChange/input16"); // 5621927
		File file = new File("data/CoinChange/myInput2");
//		File file = new File("data/CoinChange/myInput3"); // 0
        Scanner in = null;
        CoinChange r;

        try{
        	in = new Scanner(file);
        }catch (Exception e) {
        	e.printStackTrace();
		}

        int amount = in.nextInt();
        int numDenominations = in.nextInt();
        int[] a = new int[numDenominations];
        ArrayList<Integer> denominations = new ArrayList<Integer>(numDenominations);

        for (int i = 0; i < numDenominations; i++) {
        	int d = in.nextInt();
			denominations.add(d);
			a[i] = d;
		}

        in.close();

        long s = makeChange(a, amount);
//
        puts(s);

        r = new CoinChange(denominations);

        r.getWaysToMake(amount);

//        puts(r.combinedWays);
//        puts(r.waysToMake);
        puts(r.waysToMake.get(amount).size());
	}

	public static void puts(Object obj){
		Printer.puts(obj);
	}

}
