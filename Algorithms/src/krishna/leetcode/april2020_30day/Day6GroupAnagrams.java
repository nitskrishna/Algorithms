package krishna.leetcode.april2020_30day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.
 * 
 * Input: ["eat","tea","tan", "ate", "nat", "bat"],
 * 
 * Output: [ ["ate","eat","tea"], ["nat","tan"],["bat"] ]
 * 
 * All inputs will be in lower-case. The order of your output does not matter.
 * 
 * @author krishna_kumar
 *
 */
public class Day6GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String,List<String>> map = new HashMap<>();
		int langSize = 26;
		int[] sorter = new int[langSize];
		for(String str : strs) {
			char[] cStr = str.toCharArray();
			String sortedString = sort(cStr, langSize, sorter);
			List<String> list = map.get(sortedString);
			if(list == null) {
				list = new ArrayList<>();
				map.put(sortedString, list);
			}
			list.add(str);
		}
		return new ArrayList<>(map.values());
	}
	private String sort(char[] cStr, int langSize, int[] sorter) {
		
		char[] stringBuilder = new char[cStr.length];
		int strBuilderIndex = 0;
		for(char c : cStr) {
			sorter[c-'a']++;
		}
		for(int i = 0 ; i < langSize; i++) {
			while(sorter[i] > 0) {
				char c = (char) ('a'+i);
				stringBuilder[strBuilderIndex] = c;
				strBuilderIndex++;
				sorter[i]--;
			}
		}
		return new String(stringBuilder);
	}
}
