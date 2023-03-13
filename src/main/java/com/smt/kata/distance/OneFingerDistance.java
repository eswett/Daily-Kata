package com.smt.kata.distance;

import java.util.Stack;
import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title:</b> OneFingerDistance.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> One-Finger Distance
 * 
 * Given a linear , alphabetic keyboard of the letters of the alphabet,
 * how many letters in total does your finger have to jump over in order to
 * type a given word?
 * 
 * Consider the linear keyboard of the upper case letters of the alphabet laid
 * out like this:
 * 
 * | A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S |
 * T | U | V | W | X | Y | Z |
 * 
 * The word "boost" has a one-finger distance of 15 because there are 12, 0, 3,
 * 0
 * letters between b and o, o and o, o and s, s and t, respectively.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 30, 2021
 *        <b>updates:</b>
 * 
 ****************************************************************************/
public class OneFingerDistance {

	String alphabet = "abcdefghijklmnopqrstuvwxyz";

	public static void main(String[] args) {
		OneFingerDistance ofd = new OneFingerDistance();
		System.out.println(ofd.calculate("Thisisthetimeforallgoodmen"));
	}

	/**
	 * Calculates the finger distance on the keyboard
	 * 
	 * @param word Word to calculate against
	 * @return distance between the letters
	 */
	public int calculate(String word) {
		// edge cases
		if (word == null || word.equals("") || word.equals(" ") || word.length() == 1
				|| StringUtils.isAlpha(word) == false) {
			return 0;
		}

		// to ensure we're comparing to the right values
		word = word.toLowerCase();

		// make a stack and push each character in the string into it
		Stack<Character> stack = new Stack<>();
		int result = 0; // initialize return variable

		for (int i = 0; i < word.length(); i++) {
			stack.push(word.charAt(i));
		}

		char right = stack.pop();

		while (!stack.isEmpty()) {

			char left = stack.pop();
			if ((left == ' ' || right == ' ') || (left == right)) {
				continue;
			} else {
				result += Math.max(0, Math.abs((alphabet.indexOf(right) - alphabet.indexOf(left)) - 1));
			}
			right = left;
		}

		// set a result variable to zero

		// pop the first item before entering loop? check if word is empty or only has
		// one character -> return 0 or negative 1?

		// start a loop that runs while the stack still has items in it // maybe
		// while(stack.pop())

		// calculate the difference between the two indexes using the indexOf String
		// function, add to the total.

		return result;
	}
}
