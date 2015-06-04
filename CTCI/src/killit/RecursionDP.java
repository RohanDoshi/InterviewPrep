package killit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import killit.DP.Color;

public class RecursionDP {

	public static void main(String[] args) {
		DP dp = new DP();
		System.out.println(dp.fib(1234));
		System.out.println(dp.numOfPossibleWaysDP(20, new HashMap<Integer, Integer>()));
		// 1111 112 13 211 22 31 
		System.out.println(dp.numOfWaysToReach(2, 2));
		int arr[] = {-1, 0 , 1, 3, 5, 8, 10, 12};
		int arr1[] = {-10,-5,2,2,2,3,4,7,9,12,13};
		System.out.println(dp.findMagicIndex(arr));
		System.out.println(dp.findMagicIndexWithDuplicates(arr1, 0, arr1.length-1));
		int set[]= {1,2,3};
		dp.printAllSubsets(set);
		dp.printAllStringPermutations("Rohan");
		dp.printAllParanthesis(3);
		System.out.println(dp.numOfWaysRepNCents(5));
		Set<Integer> denom = new HashSet<>();
		denom.add(1);
		denom.add(5);
		denom.add(10);
		denom.add(25);
		System.out.println(dp.makeChangeWithLeastNumCoins(20, denom));
		dp.paintFillPrint(1, 2, Color.Yellow, Color.Brown);
		
//		Box arr[] = { {4, 6, 7}, {1, 2, 3}, {4, 5, 6}, {10, 12, 32} }
		Box b1 = new Box(4, 6, 7);
		Box b2 = new Box(1, 2, 3);
		Box b3 = new Box(4, 5, 6);
		Box b4 = new Box(10, 12, 32);
		
		Box[] boxes = {b1, b2, b3, b4};
		System.out.println(dp.returnStackWithMaxHeight(boxes));
		System.out.println(0^0);
		dp.parenthesizeExpressionToMatchResult("1^0|0|1", 0);
		dp.longestCommonSubsequence("ABCDGH", "AEDFHR");
		dp.longestCommonSubsequence("AGGTAB", "GXTXAYB");
		dp.lengthOfLCS("ABC", "ABD");
		dp.lengthOfLCS("AGGTAB", "GXTXAYB");
		dp.longestCommonSubsequence("AGGTAB", "GXTXAYB");
		dp.longestCommonSubstr("ABCBDEF", "ABDEF");
		int arr2[] = {-1,10, 9, 33, 21, 50, 41, 60, 80, 51, 52, 53, 54, 2, 99 } ;
		dp.longestIncreasingSubsequence(arr2);
		System.out.println("-----------------------");
		dp.liseq(arr2);
		int arrMaxSum[] = {-2,-3,4,-1,-2,1,5,-3};
		dp.maxContiguosSum(arrMaxSum);
		dp.maxContiguosSumSeq(arrMaxSum);
	}

}


class DP { 
	int fibStore[] = null;
	public int fib(int n) {
		
		if(fibStore == null) {
			fibStore = new int[n+1];
		}
		
		if(fibStore[n] != 0)
			return fibStore[n];
		
		if(n <= 0) {
			fibStore[0] = 0;
			return 0;
		}
		
		if(n == 1) {
			fibStore[1] = 1;
			return 1;
		}
		
		fibStore[n] = fib(n-1) + fib(n-2);
		return fibStore[n];
	}
	
	// child can take 1, 2 or 3 steps
	public int numOfPossibleWays(int n) {
		
		if(n < 0)
			return 0;
		
		if(n == 0)
			return 1;
		
		return numOfPossibleWays(n-1) + numOfPossibleWays(n-2) + numOfPossibleWays(n-3);
	}
	
	public int numOfPossibleWaysDP(int n, Map<Integer, Integer> map) {
		
		if(map.containsKey(n))
			return map.get(n);
		
		if(n < 0)
			return 0;
		
		if(n == 0)
			return 1;
		
		map.put(n, numOfPossibleWaysDP(n-1, map) + numOfPossibleWaysDP(n-2, map) + numOfPossibleWaysDP(n-3, map));
		return map.get(n);
	}
	
	public int numOfWaysToReach(int x, int y) {
		return numOfWaysToReachGrid(0, 0, x, y);
	}
	
	private int numOfWaysToReachGrid(int fromX, int fromY, int toX ,int toY) {
		
		if(fromX > toX || fromY > toY)
			return 0;
		
		if(fromX == toX && fromY == toY) {
			return 1;
		}
		
		return numOfWaysToReachGrid(fromX+1, fromY, toX, toY) + 
					numOfWaysToReachGrid(fromX, fromY+1, toX, toY);
		
	}
	
	// a[i] = i
	public int findMagicIndex(int[] arr) {
		return findMagicIndex(arr, 0, arr.length-1);
	}
	// assumes distinct elements in the arr
	public int findMagicIndex(int[] arr, int start, int end) {
		
		if(end < start || start < 0 || end >= arr.length) {
			return -1;
		}
		
		int mid = (start + end)/2;
		if(arr[mid] == mid)
			return mid;
		
		if(arr[mid] < mid)
			return -1;
		
		int ret1 = findMagicIndex(arr, start, mid);
		int ret2 = findMagicIndex(arr, mid+1, end);
		
		return ret1 != -1 ? ret1 : ret2;
	}
	//{-10,-5,2,2,2,3,4,7,9,12,13};
	public int findMagicIndexWithDuplicates(int[] arr, int start, int end) {
		
		if(end < start || start < 0 || end >= arr.length) {
			return -1;
		}
		
		int mid = (start + end)/2;
		if(arr[mid] == mid)
			return mid;
		
		int ret1 = -1, ret2 = -1;
		
		if(arr[mid] < mid) {
			ret1= findMagicIndexWithDuplicates(arr, start, arr[mid]);
			ret2= findMagicIndexWithDuplicates(arr, mid+1, end);
		
		} else {
			ret1= findMagicIndexWithDuplicates(arr, start, mid-1);
			ret2= findMagicIndexWithDuplicates(arr, arr[mid], end);
			
		}
		
		return ret1 != -1 ? ret1 : ret2;
	}
	
	public void printAllSubsets(int arr[]) {
		boolean[] barr = new boolean[arr.length];
		List<Set<Integer>> list = new ArrayList<Set<Integer>>();
		printSubsets(arr, barr, 0, list );
		for(Set<Integer> set : list) {
			System.out.println(Arrays.toString(set.toArray()));
		}
 	}
	
	private void printSubsets(int arr[], boolean[] barr, int start, List<Set<Integer>> list) {
		if(start > arr.length) 
			return;
		
		if(start == arr.length) {
			Set<Integer> set = new HashSet<>();
			System.out.print("{");
			for(int i=0; i<arr.length; i++) {
				if(barr[i]) {
					System.out.print(arr[i]+" ");
					set.add(arr[i]);
				}
			}
			list.add(set);
			System.out.println("}");
			return;
		}
		
		barr[start] = false;
		printSubsets(arr, barr, start+1, list);
		barr[start] = true;
		printSubsets(arr, barr, start+1, list);
		
	}
	
	
	public void printAllStringPermutations(String str) {
		permute(str.toCharArray(), 0, new int[1]);
	}
	
	private void permute(char[] arr, int index, int[] count) {
		if(index == arr.length) {
			count[0]++;
			System.out.println(new String(arr)+" - "+count[0]);
			return;
		}
		for(int i=index; i<arr.length; i++) {
			swap(arr, i, index);
			permute(arr, index+1, count);
			swap(arr, i, index);
		}
	}
	
	private void swap(char c[], int a, int b) {
		char temp = c[a];
		c[a] = c[b];
		c[b] = temp;
	}
	
	
	public void printAllParanthesis(int n) {
		printParanthesis(n, "", n, n);
	}
	
	private void printParanthesis(int n, String str, int open, int close) {
		if(open < 0 || close < 0)
			return;
		
		if(open == 0 && close == 0) {
			System.out.print(str+" ");
		}
		if(open > 0) {
			printParanthesis(n, str+"(", open-1, close);
			if(open < close)
				printParanthesis(n, str+")", open, close-1);
		} else {
			printParanthesis(n, str+")", open, close-1);
		}
	}
	
	public int numOfWaysRepNCents(int n) {
		if(n == 0)
			return 1;
		
		if(n < 0)
			return 0;
		
		return numOfWaysRepNCents(n-25) + numOfWaysRepNCents(n-10) + numOfWaysRepNCents(n-5) +
				numOfWaysRepNCents(n-1);
	}
	
	public int makeChangeWithLeastNumCoins(int n, Set<Integer> denom) {
		if(n <= 0) 
			return 0;
		
		if(denom.contains(n))
			return 1;
		
		Integer[] denominations = denom.toArray(new Integer[denom.size()]);
		int minNumOfCoinsReq = Integer.MAX_VALUE;
		for(Integer den : denominations) {
			int numOfCoins =  makeChangeWithLeastNumCoins(n-den, denom);
			if(numOfCoins == 0)
				continue;
			
			if(numOfCoins + 1 < minNumOfCoinsReq)
				minNumOfCoinsReq = numOfCoins + 1;
		}
		
		return minNumOfCoinsReq;
	}
	
	public enum Color {
		Black, White, Yellow, Brown, Pink;
	}
	
	private Color colors[][] = {{Color.Black, Color.White, Color.Yellow},
								{Color.Black, Color.White, Color.Yellow},
								{Color.Black, Color.White, Color.White}};
	
	public void paintFillPrint(int x, int y, Color oldColor, Color newColor) {
		paintFill(x, y, oldColor, newColor);
		for(int i=0; i<colors.length; i++) {
			for(int j=0; j<colors[i].length; j++) {
				System.out.print(colors[i][j].name()+" ");
			}
			System.out.println();
		}
	}
	
	public void paintFill(int x, int y, Color oldColor, Color newColor) {
		if(x < 0 || x >= colors.length || y < 0 || y >= colors[0].length) {
			return;
		}
		
		if(colors[x][y] == oldColor) {
			colors[x][y] = newColor;
			paintFill(x+1, y, oldColor, newColor);
			paintFill(x, y+1, oldColor, newColor);
			paintFill(x-1, y, oldColor, newColor);
			paintFill(x, y-1, oldColor, newColor);
		}
 		
	}
	
	public int returnStackWithMaxHeight(Box[] boxes) {
		int maxHeight = 1;
		Stack<Box> maxStack = null;
		for(int i=0; i<boxes.length; i++) {
			Stack<Box> stack = new Stack<>();
			stack.push(boxes[i]);
			int height = 1 + stackTheBoxes(boxes, i, 0, stack);
			if(height > maxHeight) {
				maxHeight = height;
				maxStack = stack;
			}
		}
		System.out.println(Arrays.toString(maxStack.toArray()));
		return maxHeight;
	}
	
	private int stackTheBoxes(Box[] boxes, int baseBoxIndex, int currBoxIndex, Stack<Box> stack) {
		if(currBoxIndex >= boxes.length)
			return 0;
		
		if(boxes[currBoxIndex].l < stack.peek().l && boxes[currBoxIndex].w < stack.peek().w
				&& boxes[currBoxIndex].h < stack.peek().h) {
			stack.push(boxes[currBoxIndex]);
			return 1 + stackTheBoxes(boxes, baseBoxIndex, currBoxIndex+1, stack);
		} else {
			return stackTheBoxes(boxes, baseBoxIndex, currBoxIndex+1, stack);
		}
		
		
	}
	
	// 1^0|0|1
	public void parenthesizeExpressionToMatchResult(String exp, int result) {
		char c[] = exp.toCharArray();
		parenthesizeExpressionToMatchResult(c, 0, '|',0,  result, "");
	}
	
	private void parenthesizeExpressionToMatchResult(char c[], int from, char lastSymbol, int lastRes, int result, String parameterizedString) {
		
		if(from >= c.length) {
			if(lastRes == result) {
				System.out.println(parameterizedString);
			}
			return;
		}
		
		String s = "";
		for(int len=3; from + len<=c.length; len=len+2) {
			s = "("+new String(c,from,len)+")";
			char sym = from + len == c.length ? '|' : c[(from+len)/2];
			s = s + sym;
			
			if(lastSymbol == '|')
				lastRes = lastRes | parseStringReturnResult(c, from, len);
			
			if(lastSymbol == '&')
				lastRes = lastRes & parseStringReturnResult(c, from, len);
			
			if(lastSymbol == '^')
				lastRes = lastRes ^ parseStringReturnResult(c, from, len);
			
			parenthesizeExpressionToMatchResult(c, from+len+1, from+len < c.length ? c[from+len] : '|', lastRes , result, parameterizedString + s);
		}
	}
		
	
	
	private int parseStringReturnResult(char c[] , int from, int len) {
		
		if(from + len>= c.length)
			return 0;
		
		if(len <= 0)
			return 0;
		
		if(len == 1) {
			
			return c[from] - '0';
		
		} else {
			
			if(c[from+1] == '|')
				return (c[from] - '0') | (c[from+2] - '0')| parseStringReturnResult(c, from+3, len-3) ;
		
			if(c[from+1] == '&')
				return (c[from] - '0') & (c[from+2] - '0') | parseStringReturnResult(c, from+3, len-3);
		
			if(c[from+1] == '^')
				return (c[from] - '0') ^ (c[from+2] - '0') | parseStringReturnResult(c, from+3, len-3);
		}
		
		return 0;
	}
	
	private String returnMaxString(String l1, String l2, String l3) {
		if(l1.length() >= l2.length() && l1.length() >= l3.length() )
			return l1;
		
		if(l2.length() >= l1.length() && l2.length() >= l3.length() )
			return l2;
		
		if(l3.length() >= l1.length() && l3.length() >= l2.length() )
			return l3;
		
		return "";
	}
	
	public void lengthOfLCS(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		int L[][] = new int[l1+1][l2+1];
		for(int i=0; i<=l1; i++) {
			for(int j=0; j<=l2; j++) {
				if(i == 0 || j == 0) {
					L[i][j] = 0;
				} else if(s1.charAt(i-1) == s2.charAt(j-1)) {
					L[i][j] = L[i-1][j-1] + 1;
				} else {
					L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
				}
			}
		}
		
		System.out.println(L[l1][l2]);
	}
	
	public void longestCommonSubsequence(String s1, String s2) {
		System.out.println(lcsSubseq(s1, s2, 0, 0));
	}
	
	public String lcsSubseq(String s1, String s2, int currIndex1, int currIndex2) {
		if(currIndex1 >= s1.length() || currIndex2 >= s2.length()) 
			return "";
		
		String l1 = "", l2 = "", l3= "";
		if(s1.charAt(currIndex1) == s2.charAt(currIndex2)) {
			l1 = s1.charAt(currIndex1) + lcsSubseq(s1, s2, currIndex1+1, currIndex2+1);
		} else { 
			l2 = lcsSubseq(s1, s2, currIndex1+1, currIndex2);
			l3 = lcsSubseq(s1, s2, currIndex1, currIndex2+1);
		}
		
		return returnMaxString(l1, l2, l3);
	}
	
	
	public void longestCommonSubstr(String s1, String s2) {
		System.out.println("LCSubstr -> "+lcsSubstr(s1, s2, 0, 0));
	}
	
	
	public String lcsSubstr(String s1, String s2, int currIndex1, int currIndex2) {
		if(currIndex1 >= s1.length() || currIndex2 >= s2.length()) 
			return "";
		
		String l1 = "", l2 = "", l3= "";
		if(s1.charAt(currIndex1) == s2.charAt(currIndex2)) {
			int temp1 = currIndex1, temp2 = currIndex2;
			while(temp1 < s1.length() && temp2 < s2.length() && s1.charAt(temp1) == s2.charAt(temp2)) {
				l1 = l1 + s1.charAt(temp1);
				temp1++;
				temp2++;
			}
			
		} 
		
		l2 = lcsSubstr(s1, s2, currIndex1+1, currIndex2);
		l3 = lcsSubstr(s1, s2, currIndex1, currIndex2+1);
		
		
		return returnMaxString(l1, l2, l3);
	}
	// Len Arr -> [1, 2, 2, 3, 3, 4, 4, 5, 6, 5, 6, 7, 8, 2, 9]
	// -1 10 33 50 51 52 53 54 99
	// {-1,10, 9, 33, 21, 50, 41, 60, 80, 51, 52, 53, 54, 2, 99 } ;
	public void longestIncreasingSubsequence(int arr[]) {
		int maxLen = 1;
		int bestEnd = -1;
		int[] lenSoFar = new int[arr.length];
		int[] seqSoFar = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			lenSoFar[i] = 1;
			seqSoFar[i] = -1;
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i] && lenSoFar[j] + 1 > lenSoFar[i]) {
					lenSoFar[i] = lenSoFar[j] + 1;
					seqSoFar[i] = j;
				}
			}
			if(lenSoFar[i] > maxLen) {
				maxLen = lenSoFar[i];
				bestEnd = i;
			}
		}
		System.out.println("Len Arr -> "+Arrays.toString(lenSoFar));
		System.out.println("Seq Arr -> "+Arrays.toString(seqSoFar));
		System.out.println("maxLen = "+maxLen);
		System.out.println("best end ->"+bestEnd);
	}
	
	
	public void liseq(int arr[]) {
		int maxLength = 1, bestEnd = 0;
		int[] DP = new int[arr.length];
		int[] prev = new int[arr.length];
		DP[0] = 1;
		prev[0] = -1;

		for (int i = 1; i < arr.length; i++)
		{
		   DP[i] = 1;
		   prev[i] = -1;

		   for (int j = i - 1; j >= 0; j--)
		      if (DP[j] + 1 > DP[i] && arr[j] < arr[i])
		      {
		         DP[i] = DP[j] + 1;
		         prev[i] = j;
		      }

		   if (DP[i] > maxLength)
		   {
		      bestEnd = i;
		      maxLength = DP[i];
		   }
		}
		
		System.out.println("Len Arr -> "+Arrays.toString(DP));
		System.out.println("Seq Arr -> "+Arrays.toString(prev));
		System.out.println("Orig Arr-> "+Arrays.toString(arr));
		System.out.println("maxLen = "+maxLength);
		System.out.println("best end ->"+bestEnd);
	}
	
//	int arrMaxSum[] = {-2,-3,4,-1,-2,1,5,-3};
//	// -2 -3 4 3 1 2 7 4
	
	public void maxContiguosSum(int arr[]) {
		int sumSoFar = 0;
		int maxSumSoFar =0; 
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < 0)
				sumSoFar = 0;
			else 
				sumSoFar = sumSoFar + arr[i];
			if(sumSoFar > maxSumSoFar) 
				maxSumSoFar = sumSoFar;
		}
		
		System.out.println("max contiguous sum ->"+maxSumSoFar);
	}
	
	public void maxContiguosSumSeq(int arr[]) {
		int sumSoFar = 0;
		int maxSumSoFar =0; 
		List<Integer> list = new ArrayList<>();
		List<Integer> maxList = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < 0) {
				sumSoFar = 0;
				list = new ArrayList<>();
			}
			else { 
				sumSoFar = sumSoFar + arr[i];
				list.add(arr[i]);
			}
			if(sumSoFar > maxSumSoFar) {
				maxSumSoFar = sumSoFar;
				maxList = list;
			}
		}
		
		System.out.println(Arrays.toString(maxList.toArray()));
	}
	
}


class Box {
	int h;
	int w; 
	int l;
	public Box(int h, int w, int l) {
		this.h = h;
		this.w = w;
		this.l = l;
	}
	
	@Override
	public String toString() {
		return "h->"+h+", w->"+w+", d->"+l;
	}
}
