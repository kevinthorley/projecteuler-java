package com.kevinthorley.projecteuler.problem1;

public class InclusionExclusionSumMultiples implements SumMultiples {

	@Override
	public long sumMultiples(int first, int second, int max, boolean printSteps) {
		long sum = 0;
		
		sum += multiples(first,  max);
		sum += multiples(second, max);
		sum -= multiples(first * second, max);
		
		if (printSteps) {
			System.out.println("Found a solution in 1 step.");
		}
		
		return sum;
	}
	
	private int multiples(int n, int max) {
		int m = (max - 1) / n;
	    return n * m * (m + 1) / 2;
	}
}
