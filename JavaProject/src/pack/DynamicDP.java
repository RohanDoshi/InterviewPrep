package pack;

import java.util.Date;

public class DynamicDP {

	public static void main(String args[]) {
//		LCSubsequence subsequence = new LCSubsequence();
//		String s1 = "ABCDGH" ;
//		String s2 = "AEDFHR";
//		System.out.println(subsequence.lcs(s1, s2));
//		
//		long d1 = new Date().getTime();
//		//System.out.println(subsequence.lcs("AGGTABDDDKWLKDDKKKD", "GXTXAYBKKSSHJKI"));
//		long d2 =  new Date().getTime();
//		//System.out.println(d2 - d1);
//		
//		 d1 = new Date().getTime();
//		System.out.println(subsequence.lcsDP("AGGTABDDDKWLKDDKKKD", "GXTXAYBKKSSHJKI"));
//		 d2 =  new Date().getTime();
//		System.out.println(d2 - d1);
//		
//		LCString lcString = new LCString();
//		System.out.println(lcString.longestCommonSubstr("OldSite:Geeksfor", "NewSite:GeeksQui"));
		
//		LongestIncSubseq incSubseq = new LongestIncSubseq();
//		incSubseq.longestIncSubsequence();
//		
//		KeyPadProblem keyPadProblem = new KeyPadProblem();
//		keyPadProblem.findPossibleNum(1);
//		keyPadProblem.findPossibleNum(2);
//		keyPadProblem.findPossibleNum(3);
//		keyPadProblem.findPossibleNum(4);
		
//		EditDistance distance = new EditDistance();
//		distance.findEditDistance();
//		distance.editDistanceDP("zeil", "trails");
//		System.out.println(minDistance("zeil", "trails"));
//		
//		MinCostPath costPath = new MinCostPath();
//		System.out.println(costPath.minCostToCell(2, 2));
		
//		CoinChange coinChange = new CoinChange();
//		System.out.println(coinChange.numOfCoins(4));
		
//		MatrixChainMultiplication chainMultiplication = new MatrixChainMultiplication();
//		chainMultiplication.minNumOperations();
		
		MinSubSet minSubSet = new MinSubSet();
		minSubSet.minSubSet(43);
	}
	
	
	public static void printNumOfParan(int n) {
		
	}
	
	public static void printParan(int open, int close, )
	
	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
	 
		// len1+1, len2+1, because finally return dp[len1][len2]
		int[][] dp = new int[len1 + 1][len2 + 1];
	 
		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}
	 
		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}
	 
		//iterate though, and check last char
		for (int i = 0; i < len1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < len2; j++) {
				char c2 = word2.charAt(j);
	 
				//if last two chars equal
				if (c1 == c2) {
					//update dp value for +1 length
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int replace = dp[i][j] + 1;
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;
	 
					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[i + 1][j + 1] = min;
				}
			}
		}
	 
		return dp[len1][len2];
	}
}

class LCSubsequence {
	
	public String lcs(String s1, String s2) {
		
		int l1 = s1.length();
		int l2 = s2.length();
		
		if(l1 <= 0 || l2 <= 0) 
			return "";
		
		String r1 = "", r2 = "", r3 = "" ;
		if(s1.charAt(0) == s2.charAt(0)) {
			r1 = s1.substring(0, 1) + lcs(s1.substring(1, l1), s2.substring(1, l2));
		} else { 
			r2 = lcs(s1, s2.substring(1, l2));
			r3 = lcs(s1.substring(1, l1), s2);
		}
		
		String max = "";
		
		if(r1.length() > r2.length()) {
			if(r1.length() > r3.length()) {
				max = r1;
			} else {
				max = r3;
			}
		} else if(r2.length() > r3.length()) {
			max = r2;
		} else {
			max = r3;
		}
		
		return max;
	}
	
	public String lcsDP(String s1, String s2) {
		String matrix[][] = new String[s1.length() + 1][s2.length() + 1];
		return lcsDPChar(matrix, s1.toCharArray(), 0, s2.toCharArray(), 0);
	}
	
	private String lcsDPChar(String[][] matrix , char[] c1, int a, char[] c2, int b) {
		
		if(a >= c1.length || b >= c2.length)
			return "";
		
		String r1 = "", r2 = "", r3 = "" ;
		if(c1[a] == c2[b]) {
			r1 = new Character(c1[a]) + lcsDPChar(matrix, c1, a+1, c2, b+1);
		} else {
			
			if(matrix[a][b+1] != null)
				r2 = matrix[a][b+1];
			else
				r2 = lcsDPChar(matrix, c1, a, c2, b+1);
			
			if(matrix[a+1][b] != null) 
				r3 = matrix[a+1][b];
			else
				r3 = lcsDPChar(matrix, c1, a+1, c2, b);
		}
		
		String max = "";
		
		if(r1.length() > r2.length()) {
			if(r1.length() > r3.length()) {
				max = r1;
			} else {
				max = r3;
			}
		} else if(r2.length() > r3.length()) {
			max = r2;
		} else {
			max = r3;
		}
		
		matrix[a][b] = max;
		return max;
	}
}

class LCString {
	
	String s1 = "ABCDGH" ;
	String s2 = "AEDFHR";
	
	public String longestCommonSubstr(String s1, String s2) {
		
		int l1 = s1.length();
		int l2 = s2.length();
		
		if(l1 <= 0 || l2 <= 0) 
			return "";
		
		String r1 = "", r2 = "", r3 = "" ;
		if(s1.charAt(0) == s2.charAt(0)) {
			r1 = s1.substring(0, 1) + longestCommonSubstrContinuous(s1.substring(1, l1), s2.substring(1, l2));
		} else { 
			r2 = longestCommonSubstr(s1, s2.substring(1, l2));
			r3 = longestCommonSubstr(s1.substring(1, l1), s2);
		}
		
		String max = "";
		
		if(r1.length() > r2.length()) {
			if(r1.length() > r3.length()) {
				max = r1;
			} else {
				max = r3;
			}
		} else if(r2.length() > r3.length()) {
			max = r2;
		} else {
			max = r3;
		}
		
		return max;
	}
	
	private String longestCommonSubstrContinuous(String s1, String s2) {
		if(s1.length() == 0 || s2.length() == 0) 
			return "";
		
		if(s1.charAt(0) == s2.charAt(0)) {
			return s1.substring(0, 1) + longestCommonSubstrContinuous(s1.substring(1), s2.substring(1));
		} else 
			return "";
	}
	
}


class LongestIncSubseq {
	int a[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
	
	public void longestIncSubsequence() {
		int max = 0;
		for(int i=0; i<a.length; i++) {
			max = Math.max(max, 1 + longestIncSubsequence(a,i, i+1));
		}
		
		System.out.println("longestIncSubsequence = "+max);
	}
	
	private int longestIncSubsequence(int[] a, int index, int with) {
		
		if(with > a.length -1)
			return 0;
		
		int len = 0;
		if(a[index] <= a[with]) {
			len = 1 + longestIncSubsequence(a, with, with+1);
		} else { 
			len = longestIncSubsequence(a, index, with+1);
		}
		
		return len;
		
	}
	
}


class KeyPadProblem { 
	
	int keyPad[][] = new int[4][3];
	
	public void findPossibleNum(int len) {
		
		int res = 0;
		for(int i=0; i<keyPad.length; i++) {
			for(int j=0; j<keyPad[i].length; j++) {
				res = res +  getPossibleNum(keyPad,  i,  j,  len-1);
			}
		}
		
		System.out.println("Length = "+len+" Count ="+res);
	}
	
	private int getPossibleNum(int[][] keypad, int i, int j, int len) {
	
		if( i<0 || j <0)
			return 0;
		
		if((i == 3 && j == 0) || (i == 3 && j == 2))
			return 0;
		
		if(i>=keypad.length || j>=keypad[0].length) 
			return 0;
		
		if(len == 0)
			return 1;
		
		// for 11 22 33.. etc
		int count = 0;
		// same char len times 
		count = count + getPossibleNum(keypad,  i,  j,  len-1);
		// move up
		count = count + getPossibleNum(keypad,  i-1,  j,  len-1);
		// move down
		count = count + getPossibleNum(keypad,  i+1,  j,  len-1);
		// move left
		count = count + getPossibleNum(keypad,  i,  j-1,  len-1);
		// move right
		count = count + getPossibleNum(keypad,  i,  j+1,  len-1);
		
		return count;
	}
	
	
}


 class EditDistance { 
	 String s1 = "Zeil";
	 String s2 = "trails";
	 
	 public void findEditDistance() {
		 int dist = editDist(s1.toCharArray(), 0, s2.toCharArray(), 0);
		 System.out.println("Edit Dist ---> "+dist);
	 }
	 
	 private int editDist(char[] c1, int a, char[] c2, int b) { 
		if(a == c1.length)
			return c2.length - b ; // insertion
		
		if(b == c2.length)
			return c1.length - a; // deletion
		
		if(c1[a] == c2[b]) {
			return editDist(c1, a+1, c2, b+1);
		} else { 
			
			int min = Math.min(editDist(c1, a+1, c2, b+1) , editDist(c1, a+1, c2, b)); 
			min = Math.min(min, editDist(c1, a, c2, b+1));
			return 1 + min;
		}
	 }
	 
	 public void editDistanceDP(String s1, String s2) {
		 int[][] d = new int[s1.length()+1][s2.length()+1];
		 
		 for(int i=0; i<=s1.length(); i++) {
			 d[i][0] = i; // i deletes
		 }
		 
		 for(int i=0; i<=s2.length(); i++) {
			 d[0][i] = i; // i inserts
		 }
		 
		 for(int i=0; i<s1.length(); i++) {
			 char c1 = s1.charAt(i);
			 for(int j=0; j<s2.length(); j++) {
				 char c2 = s2.charAt(j);
				 
				 if(c1 == c2) {
					 d[i+1][j+1] = d[i][j]; 
				 } else {
					 int insert = 1 + d[i][j+1];
					 int delete = 1 + d[i+1][j];
					 int subs = 1 + d[i][j];
					 d[i+1][j+1] = Math.min(insert, Math.min(delete, subs));
				 }
			 }
		 }
		 
		 System.out.println(d[s1.length()][s2.length()]);
	 }
 }

 
 class MinCostPath {
	 
	 int costs[][] = {{1,2,3}, {4,8,2}, {1,5,3}};
	 
	 public int minCostToCell(int a, int b) {
		 if(a <0 || b <0)
			 return Integer.MAX_VALUE;
		 
		 if(a == 0 && b == 0)
			 return costs[0][0];
		 
		 int m1 = minCostToCell(a-1, b-1);
		 int m2 = minCostToCell(a, b-1);
		 int m3 =  minCostToCell(a-1, b);
		 return costs[a][b] + Math.min(m1, Math.min(m2, m3));
	 }
 }

class CoinChange { 
	int denom[] = {1,2,3};
	
	public int numOfCoins(int sum) {
		
		if(sum <= 0)
			return 0;
		
		if(isDenom(sum))
			return 1;
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<denom.length; i++) {
			if(denom[i] < sum) {
				int minCoins = 1 + numOfCoins(sum - denom[i]);
				min = Math.min(min, minCoins);
			}
		}
		
		if(min != Integer.MAX_VALUE)
			return min;
		else
			return 0;
	}
	
	public boolean isDenom(int val) {
		
		for(int i=0; i<denom.length; i++) {
			if(denom[i] == val)
				return true;
		}
		
		return false;
	}
	
}


class MatrixChainMultiplication {
	int p[] = {10, 20, 30, 40, 30} ;
	
	public void minNumOperations() {
		int res = MatrixChainOrder(p, 1, p.length-1);
		System.out.println(res);
	}
	
//	private int minNum(int a[], int i, int from, int to) {
//		
//		int prod = 1; 
//		
//	}
	
	
	int MatrixChainOrder(int p[], int i, int j)
	{
	    if(i == j)
	        return 0;
	    int k;
	    int min = Integer.MAX_VALUE;
	    int count;
	 
	    // place parenthesis at different places between first and last matrix,
	    // recursively calculate count of multiplcations for each parenthesis 
	    // placement and return the minimum count
	    for (k = i; k <j; k++)
	    {
	        count = MatrixChainOrder(p, i, k) +
	                MatrixChainOrder(p, k+1, j) +
	                p[i-1]*p[k]*p[j];
	 
	        if (count < min)
	            min = count;
	    }
	 
	    // Return minimum count
	    return min;
	}
}


class MinSubSet {
	int set[] = {3, 34, 4, 12, 5, 2};
	
	public void minSubSet(int sum) {
		
		int len = Integer.MAX_VALUE;
		for(int i=0; i<set.length; i++) {
			int res = subset(set, i, sum-set[i], 1);
			len = Math.min(res, len);
		}
		
		System.out.println(len);
	}
	
	private int subset(int a[], int index, int sum, int len) {
		if(sum < 0)
			return Integer.MAX_VALUE;
		
		if(sum == 0)
			return len;

		int minLen = Integer.MAX_VALUE;
		
		for(int i= index+1; i<a.length; i++) {
			int length = subset(a, i, sum - a[i], len +1);
			if(length != Integer.MAX_VALUE) {
				minLen = length;
				break;
			}
		}
		
		return minLen;
	}
}










