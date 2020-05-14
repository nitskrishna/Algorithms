package krishna.leetcode.may2020_30day;

/**
 * URL :
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3329/
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Example:
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * 
 * trie.search("apple"); // returns true
 * 
 * trie.search("app"); // returns false
 * 
 * trie.startsWith("app"); // returns true
 * 
 * trie.insert("app");
 * 
 * trie.search("app"); // returns true
 * 
 * Note:
 * 
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * All inputs are guaranteed to be non-empty strings.
 * 
 * @author krishna_k
 *
 */
public class Day14ImplementTriePrefixTree {

	public static class Trie {
		static class Node {
			Node[] children = new Node[26];
			boolean isWordCompleted = false;
		}

		Node root;

		/** Initialize your data structure here. */
		public Trie() {
			root = new Node();
		}

		/** Inserts a word into the trie. */
		public void insert(String word) {
			if (word == null || word.length() == 0) {
				return;
			}
			Node current = root;
			for (char c : word.toCharArray()) {
				if (current.children[c - 'a'] == null) {
					current.children[c - 'a'] = new Node();
				}
				current = current.children[c - 'a'];
			}
			current.isWordCompleted = true;
		}

		/** Returns if the word is in the trie. */
		public boolean search(String word) {
			if (word == null || word.length() == 0) {
				return false;
			}
			Node current = root;
			for (char c : word.toCharArray()) {
				Node next = current.children[c - 'a'];
				if (next != null) {
					current = next;
				} else {
					return false;
				}
			}
			return current.isWordCompleted;
		}

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {
			if (prefix == null || prefix.length() == 0) {
				return false;
			}
			Node current = root;
			for (char c : prefix.toCharArray()) {
				Node next = current.children[c - 'a'];
				if (next != null) {
					current = next;
				} else {
					return false;
				}
			}
			return true;
		}

	}

	public static void main(String[] args) {

		Trie obj = new Trie();
		obj.insert("app");
		obj.insert("apple");
		boolean param2 = obj.search("app");
		boolean param3 = obj.startsWith("app");
		System.out.println(param2 + " " + param3);
	}
}
