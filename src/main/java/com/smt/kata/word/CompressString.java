package com.smt.kata.word;

import java.util.*;

/****************************************************************************
 * <b>Title</b>: CompressString.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Compress a string such that 'AAABCCDDDD' becomes 
 * 'A3BCCD4'. Only compress the string if it saves space.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 7, 2021
 * @updates:
 ****************************************************************************/
public class CompressString {
	
	/**
	 * Compress the string by combining a character with the number of characters when concurrent 
	 * characters exceeds 2 characters
	 * @param startNumber
	 * @return
	 */
	public String compress(String val){

		if(val.isEmpty() || val.length() <= 1) return "no can do";

		val = val.replaceAll(" ", "");

		//declare and instantiate the hashmap
		HashMap<Character, Integer> map = new HashMap<>();

		//String builder with constructor because the compressed string will only be as
		StringBuilder str = new StringBuilder(val.length()); // The string wont be longer than the input
		
		// Loop through each character of the string and add it to map with number of instances
		for(char c: val.toCharArray())
		{
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		
		for(Map.Entry<Character,Integer> entry: map.entrySet())
		{
			if(entry.getValue() > 2) {
				str.append(entry.getKey()).append(entry.getValue());
			} else if (entry.getValue() == 2) {
				str.append(entry.getKey()).append(entry.getKey());
			} else {
				str.append(entry.getKey());
			}
		}

		return str.toString();
	}

	public static void main(String[] args) {
		CompressString cs = new CompressString();
		System.out.println(cs.compress("AAAABBBCCCSSSS"));
	}
}
