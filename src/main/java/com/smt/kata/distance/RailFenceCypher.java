package com.smt.kata.distance;

/****************************************************************************
 * <b>Title:</b> RailFenceCypher.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Rail Fence Cypher
 * Implement encoding and decoding for the rail fence cipher.
 * 
 * The Rail Fence cipher is a form of transposition cipher that gets its name from 
 * the way in which it's encoded. It was already used by the ancient Greeks.
 * 
 * In the Rail Fence cipher, the message is written downwards on successive "rails" 
 * of an imaginary fence, then moving up when we get to the bottom (like a zig-zag). 
 * Finally the message is then read off in rows.
 * 
 * For example, using three "rails" and the message "WE ARE DISCOVERED FLEE AT ONCE", 
 * the cipherer writes out:
 * 
 * W . . . E . . . C . . . R . . . L . . . T . . . E
 * . E . R . D . S . O . E . E . F . E . A . O . C .
 * . . A . . . I . . . V . . . D . . . E . . . N . .
 * Then reads off:
 * 
 * WECRLTEERDSOEEFEAOCAIVDEN
 * To decrypt a message you take the zig-zag shape and fill the ciphertext along the rows.
 * 
 * ? . . . ? . . . ? . . . ? . . . ? . . . ? . . . ?
 * . ? . ? . ? . ? . ? . ? . ? . ? . ? . ? . ? . ? .
 * . . ? . . . ? . . . ? . . . ? . . . ? . . . ? . .
 * The first row has seven spots that can be filled with "WECRLTE".
 * 
 * W . . . E . . . C . . . R . . . L . . . T . . . E
 * . ? . ? . ? . ? . ? . ? . ? . ? . ? . ? . ? . ? .
 * . . ? . . . ? . . . ? . . . ? . . . ? . . . ? . .
 * Now the 2nd row takes "ERDSOEEFEAOC".
 * 
 * W . . . E . . . C . . . R . . . L . . . T . . . E
 * . E . R . D . S . O . E . E . F . E . A . O . C .
 * . . ? . . . ? . . . ? . . . ? . . . ? . . . ? . .
 * Leaving "AIVDEN" for the last row.
 * 
 * W . . . E . . . C . . . R . . . L . . . T . . . E
 * . E . R . D . S . O . E . E . F . E . A . O . C .
 * . . A . . . I . . . V . . . D . . . E . . . N . .
 * 
 * If you now read along the zig-zag shape you can read the original message.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 22, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class RailFenceCypher {
	
	/**
	 * 
	 */
	public RailFenceCypher() {
		super();
	}

	public String encodePhrase(String phrase) {

        if(phrase == null || phrase.isEmpty()) return null;

        phrase = phrase.replaceAll("\\s", "").toUpperCase();

        String r1 = "";
        String r2 = "";
        String r3 = "";

        for(int i = 0; i < phrase.length(); i++)
        {
            if(i % 4 == 0 || i == 0) {
                r1 += phrase.charAt(i);
            } else if (i % 2 == 0) {
                r3 += phrase.charAt(i);
            } else {
                r2 += phrase.charAt(i);
            }
        }
        return r1 + r2 + r3;
    }
    
    /**
     * Returns the matrix of the phrase
     * @param phrase Phrase ot encode into the matrix
     * @return Matrix of the cypher
     */
    public char[][] getMatrixFromPhrase(String phrase) {
        char [][] matrix = new char[3][phrase.length()];
        return new char[0][];
    }

    public static void main(String[] args) {
        RailFenceCypher rfc = new RailFenceCypher();
        System.out.println(rfc.encodePhrase("we are discovered flee at once"));
    }
}
