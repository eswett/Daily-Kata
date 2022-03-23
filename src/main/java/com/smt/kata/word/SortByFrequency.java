package com.smt.kata.word;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: SortByFrequency.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Sort Characters By Frequency Kata
 * 
 * Given a string s, sort it in decreasing order based on the frequency of the 
 * characters. The frequency of a character is the number of times it appears in the string.
 * 
 * Return the sorted string in reverse order of the count
 * 
 * Example 1
 * input "HelloWorld"
 * output: "lordewh"
 * explanation: When grouped the counts are:
 * l : 3
 * o : 2
 * r : 1
 * d : 1
 * e : 1
 * w : 1
 * h : 1
 * 
 * For elements with the same count, the order does not matter
 * 
 * ----- NOTE: This must be accomplished as a single line code.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 25, 2021
 * @updates:
 ****************************************************************************/
public class SortByFrequency {

	/**
	 * Sorts the characters by the number of times it is in the word
	 * @param word Word to sort the characters as lower case
	 * @return characters sorted by the number of times they appear in the word
	 */
	public String sort(String word) {
		
		return StringUtil.defaultString(word, "").toLowerCase() //Perform Validation
			.chars()	//Convert to character stream
			.boxed()	//Promote Primitive values to Boxed Object Values
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))	//Group in a map of <Char, Char Count>
			.entrySet()	//Get the Entry Set of Character Counts
			.stream()	//Make a stream we can work with.
			.sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
			.map(entry -> Character.toString(entry.getKey())) //Map to just the Character we want now that it's sorted
			.reduce("", String::concat);	//Reduce all letters to a String.
	}
	
	

}