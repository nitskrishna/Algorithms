package krishna.extras;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * @author krishna_kumar
 *
 */
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		int N = nums.length;
		List<List<Integer>> result = new ArrayList<>();
		permute(nums,new boolean[N],N,new int[N],0,result);
		return result;
	}
	public List<Integer> arrayToList(int[] arr){
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i < arr.length; i++) {
			result.add(arr[i]);
		}
		return result;
	}
	private void permute(int[] nums,boolean[] included, int N, int[] permutation, int index, List<List<Integer>> result) {
		if(index == N) {
			result.add(arrayToList(permutation));
			return;
		}
		for(int i = 0; i < N; i++) {
			if(included[i] == false) {
				permutation[index] = nums[i];
				included[i] = true;
				permute(nums,included,N,permutation, index+1,result);
				included[i] = false;
			}
		}
	}
}
