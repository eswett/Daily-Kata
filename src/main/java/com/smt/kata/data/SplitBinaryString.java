package com.smt.kata.data;

/****************************************************************************
 * <b>Title</b>: SplitBinaryString.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Number of Ways to Split a String
 * 
 * Given a binary string s, you can split s into 3 non-empty strings s1, s2, and s3 
 * where s1 + s2 + s3 = s.
 * 
 * Return the number of ways s can be split such that the number of ones is the 
 * same in s1, s2, and s3. Since the answer may be too large, return it modulo 109 + 7.
 * 
 * Example 1:
 * Input: s = "10101"
 * Output: 4
 * Explanation: There are four ways to split s in 3 parts where each part contain the same number of letters '1'.
 * "1|010|1"
 * "1|01|01"
 * "10|10|1"
 * "10|1|01"
 * 
 * Example 2:
 * Input: s = "1001"
 * Output: 0
 * 
 * Example 3:
 * Input: s = "0000"
 * Output: 3
 * Explanation: There are three ways to split s in 3 parts.
 * "0|0|00"
 * "0|00|0"
 * "00|0|0"
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 3, 2022
 * @updates:
 ****************************************************************************/
public class SplitBinaryString {

	/**
	 * Splits a string into 3 parts and counts the "1"s to ensure they have the same number
	 * @param s String to evaluate
	 * @return Count of matches when split
	 */
	public int split(String s) {
		return s.length();
	}

}
