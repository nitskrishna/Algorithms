package krishna.leetcode.may2020_30day;

/**
 * You're given strings J representing the types of stones that are jewels, and
 * S representing the stones you have. Each character in S is a type of stone
 * you have. You want to know how many of the stones you have are also jewels.
 * 
 * The letters in J are guaranteed distinct, and all characters in J and S are
 * letters. Letters are case sensitive, so "a" is considered a different type of
 * stone from "A".
 * 
 * Input: J = "aA", S = "aAAbbbb" Output: 3
 * 
 * Input: J = "z", S = "ZZ" Output: 0
 * 
 * @author krishna_k
 *
 */
public class Day2JewelsAndStones {
	public int numJewelsInStones(String J, String S) {
		int lowerCaseMarker = 0;
		int upperCaseMarker = 0;
		int nJ = J.length();
		int nS = S.length();
		for (int i = 0; i < nJ; i++) {
			char c = J.charAt(i);
			int checker = 0;
			if(c <= 'Z' && c >= 'A') {
				checker = (1 << c-'A');
				upperCaseMarker = upperCaseMarker | checker;
			}else {
				checker = (1 << c-'a');
				lowerCaseMarker = lowerCaseMarker | checker;
			}
		}
		int count = 0;
		for (int i = 0; i < nS; i++) {
			char c = S.charAt(i);
			int checker = 0;
			if(c <= 'Z' && c >= 'A') {
				checker = (1 << c-'A');
				if ((checker & upperCaseMarker) == checker) {
					count++;
				}
			}else {
				checker = (1 << c-'a');
				if ((checker & lowerCaseMarker) == checker) {
					count++;
				}
			}
		}
		return count;
	}
}
