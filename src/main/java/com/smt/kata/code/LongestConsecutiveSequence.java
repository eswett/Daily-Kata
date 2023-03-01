package com.smt.kata.code;

/****************************************************************************
 * <b>Title</b>: LongestConsecutiveSequence.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Longest Consecutive Sequence
 * 
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * 
 * You may only use primitives and standard Java.  Collections, Arrays.class, etc .. are not permitted
 * There should be NO imports in your class
 * 
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 24, 2021
 * @updates:
 ****************************************************************************/
public class LongestConsecutiveSequence {
	
	public static void main(String[] args) {
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		int [] nums = {100,4,200,1,3,2};
		int [] newArr = lcs.bubbleSort(nums);
		System.out.print(lcs.calculate(newArr));
	}
	
	/**
	 * Function that performs bubble sort on an array of size N
	 * @param arr
	 * @return
	 */
	public int[] bubbleSort(int[] arr) {
		int N = arr.length;
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < N - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	
	/**						
	 * Finds the longest sequence of numbers on the array
	 * @param items Items to be calculated against
	 * @return Largest sequence of numbers in the array
	 */
	public int calculate(int[] items) {
		int [] newArr = bubbleSort(items);
		int left = 0, right = 1, maxLength = 0, currMax = 0;
		while(left < newArr.length - 1) {
			if(newArr[left] == newArr[right] + (right - left)) {
				right++;
				currMax = right - left + 1;
				maxLength = Math.max(currMax, maxLength);
			} else {
				left++;
				right++;
			}
		}
		return maxLength;
	}
	
	
}
