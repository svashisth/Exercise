package com.prob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You're given an array of integers (eg [3,4,7,1,2,9,8]), write a program to
 * find the Pair of values that satisfy A+B = C + D, where A,B,C & D are
 * integers values in the array.
 * 
 * Eg: Given [3,4,7,1,2,9,8] array the following, 3+7 = 1+ 9 satisfies A+B = C+D
 * 
 * Print: (0,2,3,5)
 * 
 * Input expected: comma separated integer values or integer values with space 
 * Output: integer index pairs with same sum
 * @author Sunil
 *
 */
public class ProbOne {

	public static void main(String[] args) {
		System.out.println("Input data is " + Arrays.asList(args));
		int[] integerArr = getIntegerArr(args);		//parse input
//		System.out.println("ProbOne.main " + Arrays.toString(integerArr));
		printPairs(integerArr);			//print the pairs
	}

	public static int[] getIntegerArr(String[] args) {
		int[] inpArr;
		if (args.length == 0) {
			throw new IllegalArgumentException("Invalid input. This program requires integer array as input");
		}
		if (args[0].contains(",")) {
			String input = args[0];
			String[] split = input.split(",");
			inpArr = new int[split.length];
			for (int i = 0; i < split.length; i++) {
				inpArr[i] = Integer.parseInt(split[i]);
			}
			return inpArr;
		} else {
			inpArr = new int[args.length];
			for (int i = 0; i < args.length; i++) {
				inpArr[i] = Integer.parseInt(args[i]);
			}
			return inpArr;
		}
	}

	/**
	 * Create integer pairs with same sum and put them in map with integer sum as key
	 * @param input
	 */
	public static Map printPairs(int[] input) {
		Map<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();
		List<Pair> list = new ArrayList<Pair>();

		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {

				Integer key = input[i] + input[j];
				list = map.get(key);
				if (list == null) {
					list = new ArrayList<Pair>();
					list.add(new Pair(i, j));
				} else {
					for (Pair Pair : list) {

						if (Pair.x != i && Pair.y != j && Pair.x != j && Pair.y != i) {
							System.out.println("(" + Pair.x + "," + Pair.y + "," + i + "," + j + ")");
						}

//						System.out.println("\t ==>> \t" + input[Pair.x] + " + " + input[Pair.y] + " = " + input[j] + " + " + input[i]);		//number sum
					}
					list.add(new Pair(i, j));
				}
				map.put(key, list);

			}
		}
		
		/*for(int i : map.keySet()) {
			System.out.println(i+" = " + map.get(i));
		}*/
		
		return map;
	}

	/**
	 * To hold the pair of integers with same sum
	 * @author Sunil
	 *
	 */
	final static class Pair {
		final int x, y;

		Pair(int a, int b) {
			x = a;
			y = b;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;
			Pair other = (Pair) obj;
			if (x != other.x) return false;
			if (y != other.y) return false;
			return true;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Pair [x=");
			builder.append(x);
			builder.append(", y=");
			builder.append(y);
			builder.append("]");
			return builder.toString();
		}

	}

}
