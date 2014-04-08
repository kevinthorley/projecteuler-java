package com.kevinthorley.projecteuler.problem1;

public class BruteForceSumMultiples implements SumMultiples {

	public long sumMultiples(int first, int second, int max, boolean printSteps) {
		int steps = 0;
		long sum = 0;
		
		for (int i = 1; i < max; i++) {
			if (isMultiple(i, first, second)) {
 				sum += i;
			}
			
			steps++;
		}
		
		if (printSteps) {
			System.out.println("Found a solution in " + steps + " steps.");
		}
		
		return sum;
	}
	
	private boolean isMultiple(int guess, int first, int second) {
		return (guess % first == 0) || (guess % second == 0);
	}
}
