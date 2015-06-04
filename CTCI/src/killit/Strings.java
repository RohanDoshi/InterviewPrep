package killit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Strings {

	public static void main(String[] args) {
	
		String str = "ADOBECODEBANC", str1 = "acbbaca";
		char[] ch = {'A','B','C'}, ch1 = {'a','b','a'};
		smallestSubstrContainingAllChars(ch, str);
		getLongestConsecutiveChar("111010110101010000010010100000000000111");
		smallestSubstrContainingAllCharsEfficientDuplicate(ch1, str1);
		getLongestConsecutiveCharEfficient("111010110101010000010010100000000000111");
//		'this is a test sentence' => [t, h, i, s, i, s, a, t, e, s, t, s, e, n, t, e, n, c, e]
//				'thiis iss a teest seentennce' => [i, s, e, e, n]
//				'thiiis iss aa teeest seentennnce' => [i, e, n]
//				'thiiiis iss a teeest seeentennncccce' => [i, c]
		returnAsAskedFor("this is a test sentence");
		returnAsAskedFor("thiis iss a teest seentennce");
		returnAsAskedFor("thiiis iss aa teeest seentennnce");
		returnAsAskedFor("thiiiis iss a teeest seeentennncccce");
		
		
		int arr[] = {1, 5, 8, 7, 9, -5, 15, 21};//{10, 3, 6, 8, 9, 4, 3} ;
		findMaxDifferenceSecondMinusFirst(arr);
		findMaxDifferenceSecondMinusFirstEfficient(arr);
		substrMaxOccurences("BLADDASADLOAD");
		maximumRepeatingSubstring("BLABADBADX");
		
		SpecialStack s = new SpecialStack();
		s.push(10);
	    s.push(20);
	    s.push(30);
	    System.out.println(s.getMin());
	    System.out.println(s.pop());
	    System.out.println(s.getMin());
	    printAllPalindromes("adamadam");
	    
	    int arrMaxSum[] = {-2,-3,4,-1,-2,1,5,-3};
		// -2 -3 4 3 1 2 7 4
	    maxContiguousSum(arrMaxSum);
	    int arrMaxWinSliding[] = {1,3,-1,-3, 5,3,6,7};
	    maxWindowSliding(arrMaxWinSliding, 3);
	    
	    Stack<Integer> tower1 = new Stack<>();
	    Stack<Integer> tower2 = new Stack<>();
	    Stack<Integer> tower3 = new Stack<>();
	    
	    tower1.add(1);
	    tower1.add(2);
	    tower1.add(3);
	    tower1.add(4);
	    tower1.add(5);
	    tower1.add(6);
	    tower1.add(7);
	    
	    move(7, tower1, tower2, tower3);
	    System.out.println(Arrays.toString(tower3.toArray()));
	    
	    int lis[] = {  9, 33, 21, 50, 41, 60, 80, 51, 52, 53, 54 } ;
	    int lisTemp[] = {9,5,2,8,7,3,1,6,4};
	    System.out.println(longestIncreasingSubseq(lisTemp, 0, 1));
	    System.out.println(longestIncreasingSubseqIter(lis));
	    int[] empty = {};
	    Arrays.sort(empty);
	    System.out.println(isSubstring("bca", "a"));
	    System.out.println("bcs".contains("cs"));
	    System.out.println(indexOf("bcs".toCharArray(), "s".toCharArray()));
	    System.out.println(indexOf("bcs".toCharArray(), -3, "s".toCharArray()));
	    System.out.println(indexOf("bcssat".toCharArray(), 1, "sa".toCharArray()));
	    Set<Character> set = new HashSet<>();
	    set.add('a');
	    set.add('b');
	    set.add('c');
	    System.out.println(findMin("abbcbcba", set));
	}
	
	
	public static String findMin (String s, Set<Character> set){
		int len = set.size() , count = 0 , tail = 0 , minLen = Integer.MAX_VALUE;
		String result = "" ;
		HashMap<Character, Integer> map = new HashMap<> ();
		for (int i = 0 ; i < s.length() ; ++i) {
			char ch = s.charAt(i) ;
			if (set.contains(ch)) {
				int c = map.containsKey(ch) ? map.get(ch) + 1 : 1 ;
				if (c == 1) count++;
				map.put(ch, c) ;
			}
			while (count == len) {					
				if (set.contains(s.charAt(tail))) {
				  	int v = map.get(s.charAt(tail));				  
				  	if (v - 1 == 0) {					  		
				  		count--;
				  	}
				  	map.put(s.charAt(tail), v - 1) ;					 
				}							
			 	if (i - tail + 1 < minLen) {
			  		minLen = i - tail + 1 ;
			  		result = s.substring(tail, i + 1) ;
			  	}	
				tail++;
			}
		}				
		return result;
		
	}
	
	// (abc, bc) , (abc, bcd) , (abc, abcd)
	static int indexOf(char[] haystack, char[] needle) {
		return indexOf(haystack, 0, needle);
	}
	
	static int indexOf(char[] haystack, int fromIndex, char[] needle) {
		if(fromIndex >= haystack.length)
			return (needle.length == 0 ? haystack.length : -1);
		
		if(fromIndex < 0)
			fromIndex = 0;
		
		if(needle.length == 0)
			return haystack.length;
		
		if(needle.length > haystack.length - fromIndex)
			return -1;
		
		char first = needle[0];
		int maxFrom = haystack.length - needle.length + 1;
		for(int i=fromIndex; i<= maxFrom; i++) {
			if(haystack[i] == first) {
				int tempHaystack = i;
				int tempNeedle = 0;
				
				while(tempNeedle < needle.length && haystack[tempHaystack] == needle[tempNeedle]) {
					tempHaystack ++;
					tempNeedle++;
				}
				
				if(tempNeedle == needle.length) {
					return i;
				}
			}
		}
		
		return -1;
	}
	
	
	static boolean isSubstring(String haystack, String needle) {
		Set<String> set = new HashSet<String>();
		set.add(needle);
		
		int n = haystack.length();
		int m = needle.length();
		char c[] = haystack.toCharArray();
		for(int i=0; i<= n-m+1; i++) {
			if(c[i] == needle.charAt(0)) {
				String sub = new String(c,i,m);
				if(set.contains(sub))
					return true;
			}
		}
		
		return false;
	}
	
//	Input : [1, 2, 3, 4, 5]
//	Output: [(2*3*4*5), (1*3*4*5), (1*2*4*5), (1*2*3*5), (1*2*3*4)]
//			      = [120, 60, 40, 30, 24]
			    		
// 1 2 6 24 120
	
	// longest increasing subsequence
	static int longestIncreasingSubseqIter(int arr[]) {
		int len[] = new int[arr.length];
		int seq[] = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			len[i] = 1;
			seq[i] = 0;
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i] && len[j] + 1 > len[i]) {
					len[i] = len[j] + 1;
					seq[i] = j;
				}
			}
		}
		
		System.out.println("Len Arr -> "+Arrays.toString(len));
		return 0;
		
	}

	
	// lis { 10, 22, 9, 33, 21, 50, 41, 60, 80 } // does not work
	static int longestIncreasingSubseq(int arr[], int start, int curr) {
		if(start >= arr.length || curr >= arr.length) 
			return 0;
		
		if(arr[start] < arr[curr]) {
			return 1 + longestIncreasingSubseq(arr, start+1, curr+1);
		} else {
			return Math.max(longestIncreasingSubseq(arr, start, curr+1),
					longestIncreasingSubseq(arr, start+1, curr));
		}
	}
	
	
	public String pwd(String absolutePath, String relativePath) {
	      String path = absolutePath + "/" + relativePath;
	      String[] s = path.split("/");
	      Stack<String> st = new Stack<String>();
	      StringBuilder sb = new StringBuilder();
	      for (int i = 0; i < s.length; i++) {
	         if (s[i].isEmpty() || s[i].equals("."))
	            continue;
	         else if (s[i].equals("..")){
	            if (st.isEmpty())
	               throw new NullPointerException("Invalid Path");
	            else
	               st.pop();
	         }else
	            st.push(s[i]);
	      }
	      while (!st.isEmpty())
	         sb.insert(0, "/" + st.pop());
	      return sb.toString();
	}
	
	private static void move(int n, Stack<Integer> tower1, 
			Stack<Integer> tower2, Stack<Integer> tower3 ) {
		if(n > 0) {
			move(n-1, tower1, tower3, tower2);
			tower3.add(tower1.pop());
			move(n-1, tower2, tower1, tower3);
		}
	}
	
	static void rollTheDie() {
		
	}
	static void maxWindowSliding(int arr[], int w) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;
		int temp = w;
		for(int i=0; i<arr.length; i++) {
			queue.add(arr[i]);
			currSum = currSum+arr[i];
			temp--;
			if(temp == 0) {
				if(currSum > maxSum) {
					maxSum = currSum;
				}
				currSum = currSum  - queue.poll();
				temp = 1;
			}
		}
		
		System.out.println("max window --> "+maxSum);
	}
	
	static void maxContiguousSum(int arr[]) {
		
		int maxSoFar = 0;
		int maxEndingHere = 0;
		for(int i=0; i<arr.length; i++) {
			maxEndingHere = maxEndingHere + arr[i];
			if(maxEndingHere < 0) {
				maxEndingHere = 0;
			}
			
			if(maxEndingHere > maxSoFar) {
				maxSoFar = maxEndingHere;
			}
		}
		
		System.out.println("MaxSum -> "+maxSoFar);
 		
	}
	
	static void printAllPalindromes(String str) {
		boolean palindromeTable[][] = new boolean[str.length()+1][str.length()+1];
		char arr[] = str.toCharArray();
		// len=1 all are palindromes.
		for(int i=0; i<str.length(); i++) {
			palindromeTable[i][i] = true;
		}
		
		// len=2 
		int len = 2;
		for(int i=0; i+len<str.length(); i++) {
			if(arr[i] == arr[i+len]) {
				palindromeTable[i][i+len] = true;
				System.out.println(str.substring(i, i+len+1));
			}
		}
		len = 3;
		while(len < str.length()) {
			for(int i=0; i+len <str.length(); i++) {
				if(arr[i] == arr[i+len] && palindromeTable[i+1][i+len-1]) {
					palindromeTable[i][i+len] = true;
					System.out.println(str.substring(i, i+len+1));
				}
			}
			len++;
		}
		
		// split string such that both splits are palindromes
		for(int i=0; i<str.length(); i++) {
			if(palindromeTable[0][i] && palindromeTable[i+1][str.length()-1]) {
				System.out.println(str.substring(0, i+1)+" - "+str.substring(i+1,str.length()));
			}
		}
	}
	
	
	// #BruteForce
	static void maximumRepeatingSubstring(String str) {
		
		String maxSubstr = str.substring(0,1);
		int maxRepeatingCount = 1;
		
		int len = 1;
		while(len <= str.length()/2) {
			for(int i=0; i+len <= str.length(); i++) {
				String sub = str.substring(i, i+len);
				int numOfRepeatitions = 1 + numOfConsecutiveRepeatitions(str.toCharArray(), sub.toCharArray(), i+len);
				if(numOfRepeatitions > maxRepeatingCount) {
					maxRepeatingCount = numOfRepeatitions;
					maxSubstr = sub;
				}
			}
			len++;
		}
		
		System.out.println("Max consecutive repeating substr -> "+maxSubstr+" for "+maxRepeatingCount);
	}
	
	static int numOfConsecutiveRepeatitions(char[] str, char[] sub, int from) {	
		int count = 0;
		for(int i=from; i<str.length; i++) {
			int j =0;
			while(i<str.length && j<sub.length && str[i] == sub[j]) {
				i++;
				j++;
			}
			if(j == sub.length) {
				count++;
			} else {
				break;
			}
		}
		return count;
		
	}
	
	
	
	
	// below is trial and error random substring stuff
	static void substrMaxOccurences(String str) {
		
		String substr = str.substring(0,1);
		int maxNumOfOccurences = 1;
		
		int currLen = 2;
		while(currLen < str.length()) {
			for(int i=0; i+currLen<str.length(); i++) {
				String sub = str.substring(i, i+currLen);
				int numOfOccurences = numOfOccurencesOfSubstr(str.toCharArray(), sub.toCharArray());
				if(numOfOccurences > maxNumOfOccurences) {
					substr = sub;
					maxNumOfOccurences = numOfOccurences;
				}
			}
			currLen++;
		}
		
		System.out.println("Max num of times --->> "+substr+" "+maxNumOfOccurences);
	}
	
	static int numOfOccurencesOfSubstr(char[] arr, char[] sub) {
		if(sub.length == 0)
			return 0;
		
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			int temp = i, j=0;
			while(temp < arr.length && j < sub.length && arr[temp] == sub[j]) {
				temp++;
				j++;
			}
			if(j == sub.length) {
				count++;
			}
		}
		return count;
	}
	
	
	static void findMaxDifferenceSecondMinusFirstEfficient(int[] arr) {
		int maxDiff = 0; 
		int tempDiff; 
		int max = 0;
		for(int i=arr.length-1; i>=0; i--) {
			if(arr[i] > max)
				max = arr[i];
			
			tempDiff = max - arr[i];
			if(tempDiff > maxDiff) 
				maxDiff = tempDiff;
		}
		
		System.out.println(maxDiff);
	}
	
	static void findMaxDifferenceSecondMinusFirst(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j]-arr[i] > max) {
					max = arr[j]-arr[i];
				}
			}
		}
		System.out.println(max);
	}
	
	static void returnAsAskedFor(String str) {
		List<CharCount> list = new ArrayList<>();
		String[] arr = str.split(" ");
		int maxCount = 0;
		for(String s : arr) {
			list.addAll(getConsecutiveCharsOfSameMaxLen(s));
		}
		Map<Integer, List<Character>> map = new HashMap<>();
		for(int i=0; i<list.size(); i++) {
			CharCount c = list.get(i);
			if(c.count > maxCount) {
				maxCount = c.count;
			}
			if(map.containsKey(c.count)) {
				map.get(c.count).add(c.c);
			} else {
				List<Character> l = new ArrayList<>();
				l.add(c.c);
				map.put(c.count, l);
			}
		}
		
		System.out.println(Arrays.toString(map.get(maxCount).toArray()));
		
	}
	
	static List<CharCount> getConsecutiveCharsOfSameMaxLen(String str) {
		char c[] = str.toCharArray();
		int count = 1, maxCount = 1;
		int[] ascii = new int[256];
		for(int i=1; i<c.length; i++) {
			if(c[i] == c[i-1]) {
				count++;
			} else {
				
				if(count>ascii[c[i-1]]) {
					ascii[c[i-1]] = count;
				}
				if(count > maxCount) {
					maxCount = count;
				}
				count=1;
				if(i == c.length-1 && count > ascii[c[c.length-1]]) {
					ascii[c[c.length-1]] = 1;
				}
			}
		}
		List<CharCount> list = new ArrayList<>();
		if(ascii[c[0]] == maxCount)
		list.add(new CharCount(c[0], maxCount));
		for(int i=1; i<c.length; i++) {
			if(ascii[c[i]] == maxCount && c[i] != c[i-1]) {
				list.add(new CharCount(c[i], maxCount));
			}
		}
		return list;
	}
	
	private static class CharCount {
		char c;
		int count;
		public CharCount(char c, int count) {
			this.c = c;
			this.count = count;
		}
	}
	
	//	111010110101010000010010100000000000111
	static void getLongestConsecutiveCharEfficient(String str) {
		char[] ch = str.toCharArray();
		char longestChar = ch[0];
		int count = 1,  maxCount = 1;
		for(int i=1; i<ch.length; i++) {
			if(ch[i] == ch[i-1]) {
				count++;
			} else {
				if(count > maxCount) {
					longestChar = ch[i-1];
					maxCount = count;
				}
				count = 1;
			}
		}
		System.out.println("longestChar = "+longestChar+" and count = "+maxCount);
	}
	
	// acbbaca, {a,b,a}
	static void smallestSubstrContainingAllCharsEfficientDuplicate(char ch[], String str) {
		Map<Character, Integer> charCount = new HashMap<>();
		for(int i=0; i<ch.length; i++) {
			if(charCount.containsKey(ch[i])) {
				charCount.put(ch[i], charCount.get(ch[i]) + 1);
			} else {
				charCount.put(ch[i], 1);
			}
		}
		
		int[] ascii = new int[256];
		int winStart = 0;
		int winEnd = 0;
		ascii[str.charAt(0)]++;
		for(int i=1; i<str.length(); i++) {
			ascii[str.charAt(i)]++;
			if(charCount.containsKey(str.charAt(i)) && (ascii[str.charAt(i)] > charCount.get(str.charAt(i)) && str.charAt(winStart) == str.charAt(i))) {
				boolean ok = true;
				while(ok) {
					winStart++;
					if(charCount.containsKey(str.charAt(winStart))) {
						if(ascii[str.charAt(winStart)] > charCount.get(str.charAt(winStart))) {
							ascii[str.charAt(winStart)]--;
						} else {
							ok = false;
						}
					} else {
						
					}
				}
			}
			if(charCount.containsKey(str.charAt(i))) {
				winEnd = i;
			}
		}
		
		System.out.println("smallest substr = "+str.substring(winStart, winEnd+1));
	}
	
	static void getLongestConsecutiveChar(String str) {
		Map<Character, Integer> mapCharConscount = new HashMap<Character, Integer>();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			int count = 1;
			int j = i+1;
			while(j<str.length()) {
				if(str.charAt(j) == c) {
					count++;
					j++;
				} else { 
					if(mapCharConscount.containsKey(c)) {
						if(mapCharConscount.get(c) < count) 
							mapCharConscount.put(c, count);
					} else {
						mapCharConscount.put(c, count);
					}
					i = j-1;
					break;
				}
			}
		}
		
		int maxCount = 0;
		char maxChar = 0;
		Character c[] = mapCharConscount.keySet().toArray(new Character[mapCharConscount.size()]);
		for(int i=0; i<c.length; i++) {
			if(mapCharConscount.get(c[i]) > maxCount) {
				maxCount = mapCharConscount.get(c[i]);
				maxChar = c[i];
			}
		}
		System.out.println("Longest Consecutive Char =  "+maxChar);
	}
		

	// Unique Chars in ch[] and not very efficient.. O(n^2) 
	static void smallestSubstrContainingAllChars(char[] ch, String str) {
		int minLengthExpected = ch.length;
		String smallestSub = null;
		for(int i=0; i<str.length(); i++) {
			for(int j=minLengthExpected; i+j<=str.length(); j++) {
				String sub = str.substring(i, i+j);
				if(stringContainsAllChars(ch, sub)) {
					if(smallestSub == null) {
						smallestSub = sub;
					} else {
						if(sub.length() < smallestSub.length()) 
							smallestSub = sub;
					}
					break;
				}
			}
		}
		System.out.println("Smallest sub containing all chars = "+smallestSub);
	}
	
	private static boolean stringContainsAllChars(char[] c, String str) {
		int[] ascii = new int[256];
		for(int i=0; i<str.length(); i++) {
			ascii[str.charAt(i)] = 1;
		}
		
		for(int i=0; i<c.length; i++) {
			if(ascii[c[i]] != 1) 
				return false;
		}
		
		return true;
	}
}

class SpecialStack  {
	
	private Stack<Integer> stack ;
	private Stack<Integer> minStack;
	
	public SpecialStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}
	
	public void push(int item) {
		stack.push(item);
		if(!minStack.isEmpty()) {
			int top = minStack.peek();
			if(item < top) 
				minStack.push(item);
			else
				minStack.push(top);
		} else {
			minStack.push(item);
		}
	}
	
	public Integer pop() {
		if(!stack.isEmpty()) {
			minStack.pop();
			return stack.pop();
		}
		return null;
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public boolean isFull() {
		return !stack.isEmpty();
	}
	
	
	public int getMin() {
		if(!minStack.isEmpty())
			return minStack.peek();
		else
			return Integer.MIN_VALUE;
	}
}
