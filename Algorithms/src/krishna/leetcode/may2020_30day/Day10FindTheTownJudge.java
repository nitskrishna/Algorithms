package krishna.leetcode.may2020_30day;

/**
 * In a town, there are N people labelled from 1 to N. There is a rumor that one
 * of these people is secretly the town judge.
 * 
 * If the town judge exists, then:
 * 
 * The town judge trusts nobody. Everybody (except for the town judge) trusts
 * the town judge. There is exactly one person that satisfies properties 1 and
 * 2. You are given trust, an array of pairs trust[i] = [a, b] representing that
 * the person labelled a trusts the person labelled b.
 * 
 * If the town judge exists and can be identified, return the label of the town
 * judge. Otherwise, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: N = 2, trust = [[1,2]] Output: 2 
 * 
 * Example 2:
 * 
 * Input: N = 3, trust = [[1,3],[2,3]] Output: 3 
 * 
 * Example 3:
 * 
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]] Output: -1 
 * 
 * Example 4:
 * 
 * Input: N = 3, trust = [[1,2],[2,3]] Output: -1 
 * 
 * Example 5:
 * 
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]] Output: 3
 * 
 * 
 * Note:
 * 
 * 1 <= N <= 1000 
 * 
 * trust.length <= 10000 
 * 
 * trust[i] are all different 
 * 
 * trust[i][0]!= trust[i][1] 
 * 
 * 1 <= trust[i][0], trust[i][1] <= N
 * 
 * @author krishna_k
 *
 */
public class Day10FindTheTownJudge {
	public int findJudge(int N, int[][] trust) {
		boolean[] doesIthPersonTrusts = new boolean[N + 1];
		int[] ithPersonTrustCount = new int[N + 1];
		int len = trust.length;
		for (int i = 0; i < len; i++) {
			// a trusts b
			int a = trust[i][0];
			int b = trust[i][1];// trusted
			doesIthPersonTrusts[a] = true;
			ithPersonTrustCount[b]++;
		}
		boolean isNonTrustFound = false;
		int judge = -1;
		// finding the one person who trusts no one (propable judge)
		for (int i = 1; i < N + 1; i++) {
			// judge does not trusts any one
			if (!doesIthPersonTrusts[i]) {
				if (!isNonTrustFound) {
					isNonTrustFound = true;
					judge = i;
				} else {
					// there is only one judge=> there was already a person found who trusted no one
					// every one atleast trusts the judge, (except judge)
					return -1;
				}
			}
		}
		if (judge != -1) {
			// judge is trusted by every1 (except judge himself/herself)
			judge = (ithPersonTrustCount[judge] == N - 1) ? judge : -1;
		}

		return judge;
	}
}
