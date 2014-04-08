package com.kevinthorley.projecteuler.problem1;

public class SimpleOptimizedSumMultiples implements SumMultiples {

	@Override
	public long sumMultiples(int first, int second, int max, boolean printSteps) {
		int low = first < second ? first : second;
		int high = low == first ? second : first;
		
		int steps = 0;
		long sum = 0;
		
		int multiple = 1;
		int lowMultiple = 0;
		int highMultiple = 0;
		
		while (lowMultiple < max || highMultiple < max) {
			lowMultiple = low * multiple;
			highMultiple = high * multiple;
			
			if (highMultiple < max) { 
				sum += highMultiple;
			}
			
			if (lowMultiple < max
					&& lowMultiple % high != 0) {
				sum += lowMultiple;
			}
			
			steps++;
			multiple++;
		}
		
		if (printSteps) {
			System.out.println("Found a solution in " + steps + " steps.");
		}
		
		return sum;
	}
}
