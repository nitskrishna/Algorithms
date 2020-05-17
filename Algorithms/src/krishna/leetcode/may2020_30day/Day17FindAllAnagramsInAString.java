package krishna.leetcode.may2020_30day;

import java.util.ArrayList;
import java.util.List;

/**
 * URL :
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/
 * 
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input: s: "cbaebabacd" p: "abc"
 * 
 * Output: [0, 6]
 * 
 * Explanation: The substring with start index = 0 is "cba", which is an anagram
 * of "abc". The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 * 
 * Example 2:
 * 
 * Input: s: "abab" p: "ab"
 * 
 * Output: [0, 1, 2]
 * 
 * Explanation: The substring with start index = 0 is "ab", which is an anagram
 * of "ab". The substring with start index = 1 is "ba", which is an anagram of
 * "ab". The substring with start index = 2 is "ab", which is an anagram of
 * "ab".
 * 
 * @author krishna_k
 *
 */
public class Day17FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
		char[] sArr = s.toCharArray();
		char[] pArr = p.toCharArray();
		int[] pCount = new int[26];
		for (int i = 0; i < pArr.length; i++) {
			pCount[pArr[i] - 'a']++;
		}
		int[] slider = new int[26];
		int sliderCount = 0;
		for (int i = 0; i < sArr.length; i++) {
			if (pCount[sArr[i] - 'a'] > 0) {
				// accepted char
				slider[sArr[i] - 'a']++;
				sliderCount++;
				if (sliderCount == pArr.length) {
					boolean isAnagramFound = true;
					for (int k = 0; k < 26; k++) {
						if (pCount[k] != slider[k]) {
							isAnagramFound = false;
							break;
						}
					}
					if (isAnagramFound) {
						list.add(i - pArr.length + 1);
					}
					slider[sArr[i - pArr.length + 1] - 'a']--;
					sliderCount--;
				}
			} else {
				// rejected char
				for (int x = 0; x < 26; x++) {
					slider[x] = 0;
				}
				sliderCount = 0;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		Day17FindAllAnagramsInAString o = new Day17FindAllAnagramsInAString();
		System.out.println(o.findAnagrams(s, p));
	}
}
