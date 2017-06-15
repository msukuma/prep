package CoinChange;

import java.util.List;

import hackerrank.CoinChange;

public class Runner implements Runnable{
	private CoinChange register;
	private int amount1;
	private int amount2;
	
	public Runner(CoinChange register, int amount1, int amount2){
		this.register = register;
		this.amount1 = amount1;
		this.amount2 = amount2;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int total = amount1 + amount2;
		
		register.addPairToMakeUp(total, amount1, amount2);
		
		register.findOrGetWaysToMake(amount1);
		register.findOrGetWaysToMake(amount2);
		
		List<List<Integer>> combinedWays = register.combineWays(amount1, amount2);
		
		register.addWaysToMakeUp(total, combinedWays);
	}

}
