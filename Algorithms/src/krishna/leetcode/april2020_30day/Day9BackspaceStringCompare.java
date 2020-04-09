package krishna.leetcode.april2020_30day;

/**
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character.
 * 
 * Input: S = "ab#c", T = "ad#c" Output: true Explanation: Both S and T become
 * "ac".
 * 
 * Input: S = "ab##", T = "c#d#" Output: true Explanation: Both S and T become
 * "".
 *
 * Input: S = "a##c", T = "#a#c" Output: true Explanation: Both S and T become
 * "c".
 * 
 * Input: S = "a#c", T = "b" Output: false Explanation: S becomes "c" while T
 * becomes "b".
 * 
 * 
 * 1 <= S.length <= 200 1 <= T.length <= 200 S and T only contain lowercase
 * letters and '#' characters.
 * 
 * Follow up : Can you solve it in O(N) time and O(1) space?
 * 
 * 
 * @author krishna_kumar
 *
 */
public class Day9BackspaceStringCompare {
	public boolean backspaceCompare(String S, String T) {
		int i = S.length() - 1;
		int j = T.length() - 1;
		int sCount = 0;
		int tCount = 0;
		while (true) {
			while (i >= 0) {
				if(S.charAt(i) == '#') {
					sCount++;
				}else {
					if(sCount == 0) {
						break;
					}else {
						sCount--;
					}
				}
				i--;
			}
			while (j >= 0) {
				if(T.charAt(j) == '#') {
					tCount++;
				}else {
					if(tCount == 0) {
						break;
					}else {
						tCount--;
					}
				}
				j--;
			}
			if (i == j && i == -1) {
				return true; // nothing left to compare
			}
			if (i == -1 || j == -1) {
				return false; // above both nothing to compare have been considered hence this case is only one string is
								// empty
			}
			if(S.charAt(i) != T.charAt(j)) {
				return false;
			}
			i--;
			j--;
		}
	}

}
