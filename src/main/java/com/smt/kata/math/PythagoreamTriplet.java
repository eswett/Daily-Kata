package com.smt.kata.math;

import java.util.HashSet;

/****************************************************************************
 * <b>Title</b>: PythagoreamTriplet.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Pythagorean Triplet Kata
 * 
 * Given an array of integers, determine whether it contains a Pythagorean triplet. 
 * Recall that a Pythogorean triplet (a, b, c) is defined by the equation a2 + b2 = c2.
 * 
 * Example:
 * input: [9, 3, 7, 5, 4]
 * result: true (3sq + 4sq = 5sq)
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 22, 2021
 * @updates:
 ****************************************************************************/
public class PythagoreamTriplet {
	HashSet<Integer> tripleSet = new HashSet<>();

	/**
	 * Checks to see if any of the triplets in the values array make a 
	 * pythagoream theory equate to true
	 * @param values Array of numbers to evaluate
	 * @return True if 3 values match pythagoreams thereom.  False otherwise
	 */
	public boolean hasMatch(int[] values) {
		for(int val: values) {
			tripleSet.add(val * val);
		}
		for(int i = 0; i < values.length; i++)
		{
			for(int j = i + 1; j < values.length; j++) {
				if(tripleSet.contains(values[i] * values[i] + values[j] * values[j])) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		PythagoreamTriplet pt = new PythagoreamTriplet();
		int[] values = {9, 3, 7, 5, 4};
		System.out.println(pt.hasMatch(values));
	}
}
