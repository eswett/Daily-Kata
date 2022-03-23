package com.smt.kata.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.ArrayUtils;

/****************************************************************************
 * <b>Title</b>: WeakestRow.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> The K Weakest Rows in a Matrix Kata
 * 
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and 
 * 0's (representing civilians). The soldiers are positioned in front of the 
 * civilians. That is, all the 1's will appear to the left of all the 0's in each row.
 * 
 * A row i is weaker than a row j if one of the following is true:
 * 
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 * 
 * Example 1:
 * Input: mat = 
 * [[1,1,0,0,0],
 *  [1,1,1,1,0],
 *  [1,0,0,0,0],
 *  [1,1,0,0,0],
 *  [1,1,1,1,1]], 
 * k = 3
 * Output: [2,0,3]
 * Explanation: 
 * The number of soldiers in each row is: 
 * - Row 0: 2 
 * - Row 1: 4 
 * - Row 2: 1 
 * - Row 3: 2 
 * - Row 4: 5 
 * The rows ordered from weakest to strongest are [2,0,3,1,4].
 * 
 * Example 2:
 * Input: mat = 
 * [[1,0,0,0],
 *  [1,1,1,1],
 *  [1,0,0,0],
 *  [1,0,0,0]], 
 * k = 2
 * Output: [0,2]
 * Explanation: 
 * The number of soldiers in each row is: 
 * - Row 0: 1 
 * - Row 1: 4 
 * - Row 2: 1 
 * - Row 3: 1 
 * The rows ordered from weakest to strongest are [0,2,3,1].
 * 
 * **** Note, rows that are similarly weak will be sorted by the row index
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 16, 2021
 * @updates:
 ****************************************************************************/
public class WeakestRow {

	/**
	 * Finds the weakest rows
	 * @param matrix Matrix to search for the weakest rows
	 * @param k Number of weakest elements to return
	 * @return int array with the row ids of the weakest rows
	 */
	public int[] find(int[][] matrix, int k) {
		if(matrix == null || ArrayUtils.isEmpty(matrix) || matrix[0] == null || ArrayUtils.isEmpty(matrix[0]) || matrix.length < 2) {
			return new int[0];
		} else {
			Map<Integer, List<Integer>> rows = mapData(matrix);
			return processWeakest(rows, k);
		}
	}

	private int[] processWeakest(Map<Integer, List<Integer>> rows, int k) {
		int [] weakest = new int[k];
		int index = 0;
		for(List<Integer> indexes : rows.values()) {
			for(int i : indexes) {
				if(index < k) {
					weakest[index++] = i;
				} else {
					return weakest;
				}
			}
		}
		return weakest;
	}

	private Map<Integer, List<Integer>> mapData(int[][] matrix) {
		Map<Integer, List<Integer>> rows = new TreeMap<>();
		for(int i = 0; i < matrix.length; i++) {
			int count = 0;
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == 1) {
					count++;
				} else {
					break;
				}
			}
			List<Integer> indexes = rows.getOrDefault(count, new ArrayList<>());
			indexes.add(i);
			rows.put(count, indexes);
		}
		return rows;
	}
}