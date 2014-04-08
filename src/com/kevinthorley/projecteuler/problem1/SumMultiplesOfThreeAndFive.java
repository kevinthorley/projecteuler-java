package com.kevinthorley.projecteuler.problem1;

public class SumMultiplesOfThreeAndFive {

	public static void main(String[] args) {
		int first = 3;
		int second = 5;
		int max = 1000;
		int iterations = (int) 1e6;
		
		SumMultiples bruteForce = new BruteForceSumMultiples();
		System.out.println(String.format("Starting %s tests.", bruteForce.getClass().getSimpleName()));
		runTest(bruteForce, first, second, max);
		runPerformanceTest(bruteForce, first, second, max, iterations);
		System.out.println("");
		
		SumMultiples optimized = new SimpleOptimizedSumMultiples();
		System.out.println(String.format("Starting %s tests.", optimized.getClass().getSimpleName()));
		runTest(optimized, first, second, max);
		runPerformanceTest(optimized, first, second, max, iterations);
		System.out.println("");
		
		SumMultiples incExc = new InclusionExclusionSumMultiples();
		System.out.println(String.format("Starting %s tests.", incExc.getClass().getSimpleName()));
		runTest(incExc, first, second, max);
		runPerformanceTest(incExc, first, second, max, iterations);
		System.out.println("");
	}
	
	private static void runTest(SumMultiples target, int first, int second, int max) {
		System.out.println(String.format("Sum of multiples of 3 and 5 is %d",
				target.sumMultiples(first, second, max, true)));
	}
	
	private static void runPerformanceTest(SumMultiples target, int first, int second, int max, int iterations) {
		long start = System.nanoTime();
		for (int i = 0; i < iterations; i++) {
			target.sumMultiples(first, second, max, false);
		}
		
		long end = System.nanoTime();
		
		System.out.println(String.format("Time to run %d iterations is %.2f ms",
				iterations, (end - start) / 1e6));
	}
}
