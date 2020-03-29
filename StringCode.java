// CS108 HW1 -- String static methods

import java.util.HashSet;

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		if (str.length() == 0)
			return 0;
		int currMax = 0;
		int currLength = 0;
		char prevChar = str.charAt(0);
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) == prevChar) {
				currLength++;
			} else {
				currMax = Math.max(currLength, currMax);
				prevChar = str.charAt(i);
				currLength = 1;
			}
		}
		return currMax;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		str += " ";
		int length = str.length();
		char currChar;
		char nextChar;
		String res = "";
		for (int i=0; i<length-1; i++) {
			currChar = str.charAt(i);
			nextChar = str.charAt(i+1);
			if (Character.isDigit(currChar)){
				if (i!=length-2)
					res += getNewPart (currChar, nextChar);
			} else {
				res += currChar;
			}
		}
		return res;
	}

	private static String getNewPart(char currChar, char nextChar) {
		String res="";
		int size = Integer.parseInt(currChar + "");
		for (int i=0; i<size; i++) {
			res+=nextChar;
		}
		return res;
	}

	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		HashSet<String> substringsA = new HashSet<String>();
		HashSet<String> substringsB = new HashSet<String>();
		getSubstrings(a, substringsA, len);
		getSubstrings(b, substringsB, len);
		substringsA.retainAll(substringsB);
		return !substringsA.isEmpty();
	}

	private static void getSubstrings(String s, HashSet<String> substrings, int len) {
		for (int i=0; i<s.length(); i++) {
			if (i+len <= s.length()) {
				substrings.add(s.substring(i, i+len));
			}
		}
	}
}
