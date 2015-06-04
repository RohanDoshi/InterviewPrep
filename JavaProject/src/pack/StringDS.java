package pack;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringDS {
	public static void main(String args[]) {
//		StringClass str= new StringClass("xgksrek");
//	//	System.out.println(str.isPalindrome());
//	//	System.out.println(str.longestPalindrome());
//		//System.out.println(str.longestPalinDP());
//		System.out.println(str.isSubsequence("geeksforgeeks"));
//		System.out.println(str.isSubsequenceIterative("gkwrek", "geeksforgeeks"));
		
//		ConvertNumberToWords convertNumberToWords = new ConvertNumberToWords();
//		convertNumberToWords.convert(123456789);
		String words[] = {"baa", "abcd", "abca", "cab", "cad"};//{"caa", "aaa", "aab"};
		FindOrderCharacters order = new FindOrderCharacters(words);
		//order.findOrder();
		
//		PrintAllPossibleParanthesis paranthesis = new PrintAllPossibleParanthesis();
//		paranthesis.print(3);
		
//		System.out.println();
//		char c [] = "abcba".toCharArray();
//		char repeatingChar = '\0';
//		Set<Character> set = new HashSet<Character>();
//		for(int i=c.length-1; i>=0 ; i--) {
//			if(set.contains(c[i])) {
//				repeatingChar = c[i];
//			}
//			
//			set.add(c[i]);
//		}
//		System.out.println(repeatingChar);
//		
//		LongestPalin longestPalin = new LongestPalin("forgeeksskeegfor");
//		longestPalin.longestPalin();
		
//		Compress comp = new Compress();
//		comp.compress2();
//		
//		numOfOccurences("geeksforgeeks", "eeks");
//		
//		perm("abc");
//		
//		System.out.println(numOfWays(25, 3));
//		
//		List<List<Integer>> lists = getAllWays(25);
//		for(List<Integer> l : lists) {
//			System.out.println(l.toString());
//		}
		
		PrintAllPossibleParanthesis paranthesis = new PrintAllPossibleParanthesis();
		paranthesis.print(3);
	}
	
	static int[] denom = {1,5,10,25};
	
	static int numOfWays(int sum, int maxDenomIndex) {
		if(sum < 0)
			return 0;
		
		if(sum == 0)
			return 1;
		
		int count = 0;
		
		for(int i = maxDenomIndex ; i >= 0 ; i--) 
			count += numOfWays(sum - denom[i], i) ;
		
		
		return count;
		
	}
	
	static List<List<Integer>> getAllWays(int sum) {
		
		return getAllWays(sum, denom.length-1, new ArrayList<Integer>());
	}
	
	static List<List<Integer>> getAllWays(int sum, int maxDenomIndex, List<Integer> change) {
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		if(sum < 0)
			return list;
		
		if(sum == 0) {
			list.add(change);
			return list;
		}
		
		for(int i=maxDenomIndex; i>=0; i--) {
			change.add(denom[i]);
			List<List<Integer>> res = getAllWays(sum-denom[i], i, change);
			if(res.size() == 0) {
				change.remove(change.size()-1);
			} else {
				List<Integer> arr = new ArrayList<Integer>();
				for(int j=0; j<change.size()-1; j++) {
					arr.add(change.get(j));
				}
				change = arr;
			}
			list.addAll(res);
			
		}
		
		return list;
			
	}
	
	
	
	
	static void perm(String s) {
		char[] c = s.toCharArray();
		permute(c, 0);
	}
	
	static void permute(char[] c, int index) {
		if(index == c.length) {
			System.out.println(new String(c));
			return;
		}
		
		for(int i=index; i<c.length; i++) {
			swap(c, index , i);
			permute(c, index+1);
			swap(c, index, i);
		}
	}
	
	
	static void swap(char[] c, int a, int b) {
		char temp = c[a];
		c[a] = c[b];
		c[b] = temp;
	}
	static void numOfOccurences(String s, String sub) {
		char[] a = s.toCharArray();
		char[] b = sub.toCharArray();
		int count = 0;
		int bIndex = 0;
		for(int i=0; i<a.length; i++) {
			if(a[i] == b[bIndex]) {
				while( i< a.length && bIndex < b.length && a[i] == b[bIndex] ){
					i++;
					bIndex++;
				}
				if(bIndex == b.length) {
					count++;
				}
				bIndex =0;
			}
		}
		
		System.out.println(count);
	}
}

class LongestPalin { 
	
	private String str = null;
	public LongestPalin(String str) {
		this.str = str;
	}
	
	public void longestPalin() {
		int len = str.length();
		boolean[][] table = new boolean[len][len];
		
		char c[] = str.toCharArray();
		int fromIndex = 0;
		int toIndex = 0;
		int maxLen = 0;
		// length 1 palindromes 
		for(int i=0; i<c.length; i++) {
			table[i][i] = true;
			fromIndex = toIndex = i;
			maxLen = 1;
		}
		
		// length 2 palindromes
		for(int i=1; i<c.length; i++) {
			if(c[i] == c[i-1]) {
				table[i-1][i] = true;
				fromIndex = i-1;
				toIndex = i;
				maxLen = 2;
			}
		}
		
		for(int l=3; l<=len; l++) {
			for(int i=0; i<=len - l; i++) {
				if(c[i] == c[i+l-1] && table[i+1][i+l-2]) {
					table[i][i+l-1] = true;
					fromIndex = i;
					toIndex = i+l-1;
					maxLen = l;
				}
			}
		}
		
		System.out.println(str.substring(fromIndex, toIndex+1));
		
	}
}

class Compress {
	String s = "aabbbccc";
	public void compress() {
		int[] table = new int[256];
		char c[] = s.toCharArray();
		for(int i=0; i<c.length; i++) {
			table[c[i]]++;
		}
		int curr = 0;
		for(int i=1; i<c.length; i++) {
			int count = table[c[i-1]];
			if(count > 0) {
				c[curr] = c[i-1]; 
				c[curr+1] = (char)(((int)'0')+count);;
				curr = curr + 2;
			} else {
				
			}
		}
		
		System.out.println(new String(c));
	}
	
	
	public void compress2() { 
		
		char c[] = s.toCharArray();
		char ch = c[0];
		int count = 1;
		String com = "";
		for(int i=1; i <c.length; i++) {
			if(c[i] == ch) {
				count++;
			} else { 
				com = com + ch;
				if(count != 1)
					com = com + count;
				ch = c[i];
				count = 1;
			}
		}
		System.out.println(com);
	}
}

class PrintAllPossibleParanthesis  {
	
	String p = "((()))";
	public void print(int n) {
		print(n,n,"");
	}
	
	private void print(int open, int close, String s) {
		if(close == 0) {
			System.out.print(s);
 			return;
		}
		if(open > 0) {
			print(open-1, close, s+"(");
			if(open < close) {
				print(open, close-1, s+")");
			}
		} else { 
			print(open, close-1, s+")");
		}
	}
}

class FindOrderCharacters { 
		private String[] words = null;
		private char[] c = {'a','b','c','d','e'};
		private Graph graph = null;
		public FindOrderCharacters(String[] words) {
			this.words = words;
			graph = new Graph(true);
		}
		
		public void findOrder() { 
			for(int i=0 ; i<words.length-1; i++) {
				String w1 = words[i];
				String w2 = words[i+1];
				for(int j=0; j<Math.min(w1.length(), w2.length()); j++) {
					if(w1.charAt(j) != w2.charAt(j)) {
						if(!graph.containsVertex(w1.charAt(j))) {
							graph.addVertex(w1.charAt(j));
						}
						if(!graph.containsVertex(w2.charAt(j))) {
							graph.addVertex(w2.charAt(j));
						}
						
						graph.addEdge(w1.charAt(j), w2.charAt(j),0);
					}
				}
			}
			
			graph.topologicalSort();
		}
		
		
		
		
}

class StringClass {
	String str;
	public StringClass(String str) {
		this.str = str;
	}
	
	public boolean isSubsequence(String s2) {
		return isSubsequence(str,s2) ;
	}
	
	public boolean isSubsequenceIterative(String s1, String s2) {
		if(s1 == null || s2 == null) {
			return false;
		}
		
		int j = 0;
		for(int i=0; i<s2.length() && j<s1.length(); i++) {
			if(s2.charAt(i) == s1.charAt(j)) {
				j++;
			}
		}
		
		if(j == s1.length())
			return true;
		else
			return false;
	}
	
	private boolean isSubsequence(String str2, String s2) {
		int l1 = str2.length(); 
		int l2 = s2.length();
		if(l1 == 0 && l2 == 0) {
			return true;
		}
		if(l1 == 0) {
			return false;
		}
		if(l2 == 0) {
			return false;
		}
		boolean b1 = false, b2 = false, b3 = false;
		if(str2.charAt(l1-1) == s2.charAt(l2-1)) {
			b1 = true && isSubsequence(str2.substring(0, l1-1), s2.substring(0, l2-1));
		} else { 
			b2 = isSubsequence(str2, s2.substring(0, l2-1));
			b3 = isSubsequence(str2.substring(0, l1-1), s2);
		}
		return b1 || b2 || b3;
	}

	boolean isPalindrome() {
		return isPalindrome(str);
	}
	
	boolean isPalindrome(String str) {
		char c[] = str.toCharArray();
		for(int i=0; i<c.length/2; i++) {
			if(c[i] != c[(c.length-1)-i]) {
				return false;
			}
		}
		return true;
	}
	
	String longestPalindrome() {
		String longestPal = "";
		char ch[] = str.toCharArray();
		StringBuffer buffer= null;
		for(int i=0; i<ch.length; i++) {
			buffer = new StringBuffer();
			buffer.append(ch[i]);
			for(int j=i+1; j<ch.length; j++) {
				buffer.append(ch[j]);
				if(isPalindrome(buffer.toString()) && buffer.length() > longestPal.length()) {
					longestPal = buffer.toString();
				}
			}
		}
		
		return longestPal;
	}
	
	String longestPalinDP() {
		
		char ch[] = str.toCharArray();
		boolean table[][] = new boolean[ch.length][ch.length];
		for(int i=0; i<ch.length; i++) {
			table[i][i] = true;
		}
		int longIndex = -1, longLen = -1;
		for(int i=0; i<ch.length -1; i++) {
			if(ch[i] == ch[i+1]) {
				table[i][i+1] = true;
				longIndex = i;
				longLen =2;
			}
		}
		// ababa
		for(int len=3; len<=ch.length; len++) {
			for(int i=0; i<= ch.length - len; i++) {
				int j = i+len-1;
				if(ch[i] == ch[j] && table[i+1][j-1] ) {
					table[i][j] = true;
					longIndex = i;
					longLen = len;
				}
			}
		}
		
		return str.substring(longIndex, longIndex + longLen); 
	}
}


class ConvertNumberToWords { 

	  private static final String[] tensNames = {
	    "",
	    " ten",
	    " twenty",
	    " thirty",
	    " forty",
	    " fifty",
	    " sixty",
	    " seventy",
	    " eighty",
	    " ninety"
	  };

	  private static final String[] numNames = {
	    "",
	    " one",
	    " two",
	    " three",
	    " four",
	    " five",
	    " six",
	    " seven",
	    " eight",
	    " nine",
	    " ten",
	    " eleven",
	    " twelve",
	    " thirteen",
	    " fourteen",
	    " fifteen",
	    " sixteen",
	    " seventeen",
	    " eighteen",
	    " nineteen"
	  };
	  
	  
	  public void convert(int number) {
		  String mask = "000000000";
		  DecimalFormat df = new DecimalFormat(mask);
		  String str = df.format(number);
		  
		  String million = str.substring(0, 3);
		  
		  String thousand = str.substring(3,6);
		  
		  String hundred = str.substring(6,9);
		  
		  String res = "";
		  if(!million.equals("000")) {
			  res = res + convertToHundred(million);
			  res = res + " million";
		  }
		  
		  if(!thousand.equals("000")) {
			  res = res + convertToHundred(thousand);
			  res = res + " thousand";
		  }
		  
		  if(!hundred.equals("000")) {
			  res = res + convertToHundred(hundred);
		  }
		  
		  System.out.println(res);
		  
	  }
	  
	  private String convertToHundred(String str) {
		  int n = Integer.parseInt(str);
		  String res = "";
		  if(n < numNames.length) {
			  return numNames[n];
		  }
		  if(n / 100 != 0 ) {
			  res = res + numNames[n/100];
			  res = res +" hundred and ";
		  }
		  
		  n = n % 100;
		  if(n / 10 != 0) {
			  res = res + tensNames[n/10];
		  }
		  
		  n = n % 10;
		  if(n != 0) {
			  res = res + numNames[n];
		  }
		  
		  return res;
		  
	  }
}
