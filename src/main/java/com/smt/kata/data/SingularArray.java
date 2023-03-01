package com.smt.kata.data;
import java.util.ArrayList;
/****************************************************************************
 * <b>Title</b>: SingularArray.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Singular Array
 * Given an array of integers in which two elements appear exactly once and all 
 * other elements appear exactly twice, find the two elements that appear only once.
 * For example, given the array [2, 4, 6, 8, 10, 2, 6, 10], return 4 and 8. The order does not matter.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 27, 2021
 * @updates:
 ****************************************************************************/
public class SingularArray {
	ArrayList<Integer> list = new ArrayList<Integer>();
	int count;
	
	
	public static void main(String[] args) {
		Integer[] arr = {2, 4, 6, 8, 10, 2, 6, 10};
		SingularArray sa = new SingularArray();
		;
		System.out.println(sa.findUnmatched(arr));
	}

	/**
	 * Finds all of the unmatched elements in the array
	 * @param values Array of numbers ot evaluate
	 * @return Array of non-matched elements
	 */
	public ArrayList<Integer> findUnmatched(Integer[] values) {
		//validate data / check if empty or if there's two different values
		for(int i = 0; i < values.length; i++) {
			count = 1;
			for(int j = i + 1; j < values.length; j++) {
				if(values[i] == values[j]) {
					break;
				}
			}
			if(count == 2) {
				list.add(values[i]);
			}
		}
		return list;
	}
}
