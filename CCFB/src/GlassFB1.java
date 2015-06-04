import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;


public class GlassFB1 {

	public static void main(String[] args) {
		RomanNumeral romanNumeral = new RomanNumeral();
		System.out.println(romanNumeral.numberToRoman(314));
		System.out.println(romanNumeral.romanToNumber("CCX"));
		
		int arr[] = {1,2,3,4,5,6,7};
		Page6 pg = new Page6();
		BNode node = new BNode(4);
		node.left = new BNode(2);
		node.left.left = new BNode(1);
		node.left.right = new BNode(3);
		node.right = new BNode(6);
		node.right.left = new BNode(5);
		node.right.right = new BNode(7);
		
		Iterator<Integer> iter = node.iterator();
		while(iter.hasNext())
			System.out.print(iter.next()+" ");
		
		String lineWithComments = "This is a /* test */ and / I want to check "
				+ "// what happends here123\n /* Is this system */ working? "
				+ "or not???//Testing new line\na";
		
		GlassFB1 fb = new GlassFB1();
		fb.printWithoutComments(lineWithComments);
		KeyPad keyPad = new KeyPad();
		List<String> list = keyPad.generatePossibleKeys(23);
		System.out.println(list.toString());
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		System.out.println(fb.hasUnbalancedParenthesis("for)has())", map));
		System.out.println(fb.sqrtRecur(20)+" "+Math.sqrt(20));
		fb.combinations(110124);
		
		int[]A = {2,3,1,1,4};
		int[] B= {3,2,1,0,4};
		System.out.println(fb.isEndReachable(A));
		System.out.println(fb.isEndReachable(B));
		fb.printAllPaths(node);
		System.out.println(fb.reverseSignedInteger(1534236469));
		System.out.println(fb.lcs("geksforgees","geeksquiz"));
//		System.out.println(fb.indexOfSmallestValGrEqX(arr, 0, arr.length-1, 8));
//		int s1[] = {1, 4, 8, 10, 13};
//		int s2[] = {2, 3, 5, 7, 10};
//		System.out.println(fb.intersectionVal(s1, s2));
//		int  A1[] = {3,6,8,9};
//		int B1[] = {4,5,6,9,10,11};
//		System.out.println(fb.intersectionVal(A1, B1));
		int[] maxSum = {-2, -3, -4, -1, -2, -1, -5, -3};
		System.out.println(fb.maxSumContiguos(maxSum));
		int[][] mat = {{-7,-2,0,8},{9,12,16,20}, {-4,1,4,11}, {-1,8,10,12}};
		fb.largestSumSubmatrix(mat);
		BNode lca = fb.lca(node, 1, 7);
		System.out.println(lca.val);
		fb.mergeKSortedArr(mat);
		System.out.println(divide(7, 42));
		System.out.println(4^2);
		System.out.println(6^4);
	}
	
	private static int add(int a , int b){

	    do{

	        a^=b;
	        b&=(a^b);
	        b<<=1;

	     }while(Math.abs(b)!=0);

	    return a;
	}
	
	private static int divide(int a, int b) {
	    boolean swapSign = a < 0 ^ b < 0;
	    a = Math.abs(a);
	    b = Math.abs(b);
	    int result = 0;
	    while (a >= b) {
	        a = add(a, -b);
	        result = add(result, 1);
	    }
	    return swapSign ? -result : result;
	}
	// without using +,- or *
	public void division(int a, int b) {
		
	}
	
	public Integer[] mergeKSortedArrBetter(List<List<Integer>> list) {
		if(list == null || list.size() == 0)
			return new Integer[0];
		
		if(list.size() == 1)
			return list.get(0).toArray(new Integer[list.get(0).size()]);
		
		Integer[] a = list.get(0).toArray(new Integer[list.get(0).size()]);
		Integer[] b = list.get(1).toArray(new Integer[list.get(1).size()]);
		Integer[] merge = merge(a, b, 0, a.length, 0, b.length);
		for(int i=2; i<list.size(); i++) {
			Integer[] c = list.get(i).toArray(new Integer[list.get(i).size()]);
			merge = merge(c, merge, 0, c.length-1, 0, merge.length-1);
		}
		
		return merge;
	}
	
	private Integer[] merge(Integer[] a, Integer[] b, int a1, int a2, int b1, int b2) {
		Integer res[] = new Integer[a2-a1+1 + b2-b1+1];
		merge(a, b, res, 0, a1, a2, b1, b2);
		return res;
	}
	
	
	private void merge(Integer[] a, Integer[] b, Integer res[], int index, int a1, int a2, int b1, int b2) {
		
		int a_mid = (a1 + a2) >>> 1;
		int bIndex = indexOfSmallestValGrEqX(b, b1, b2, a[a_mid]);
		if(bIndex == -1) {
			// all elements in b b/w b1 and b2 are less than a[a_mid]
		}
		int numOfElementsGrB = (b.length-1) - bIndex + 1;
		if(bIndex == b1) {
			// all of a1..a_mid are less than b[bIndex]
			for(int i=a1; i<=a_mid; i++) 
				res[index++] = a[i];
		}
		
	}
	
	public void mergeKSortedArr(int[][] mat) {
		int k = mat.length;
		int merge[] = new int[k*k];
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int w = 0;
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				queue.add(mat[j][i]);
			}
			merge[w++] = queue.poll();
		}
		while(!queue.isEmpty())
			merge[w++] = queue.poll();
		
		System.out.println(Arrays.toString(merge));
		
	}
	
	
	public BNode lca(BNode root, int a, int b) {
		if(root == null)
			return null;
		
		if(root.val == a || root.val == b)
			return root;
		
		BNode left = lca(root.left, a, b);
		BNode right = lca(root.right, a, b);
		if(left != null && right != null)
			return root;
		
		if(left != null) {
//			if(verify(left, a) && verify(left, b)) {
//				return left;
//			} else {
//				return null;
//			}
			return left;
		}
		
		if(right != null) {
//			if(verify(right, a) && verify(right, b)) {
//				return right;
//			} else {
//				return null;
//			}
			return right;
		}
		
		return null;
	}
	
	public boolean verify(BNode node, int a) {
		if(node == null)
			return false;
		
		if(node.val == a)
			return true;
		
		return verify(node.left, a) || verify(node.right, a);
	}
	
	public void largestSumSubmatrix(int[][] mat) {
		int maxSum = 0;
		int rows = mat.length; 
		int cols = mat[0].length;
		for(int i=0; i<rows; i++) {
			int temp[] = new int[cols];
			for(int j=i; j<rows; j++) {
				for(int k =0; k<cols; k++) {
					temp[k] += mat[j][k];
				}
				int sum = maxSumContiguos(temp);
				if(sum > maxSum)
					maxSum = sum;
			}
		}
		System.out.println("Max-Sum -->"+maxSum);
	}
	
	
	public int maxSumContiguos(int[] arr) {
		int sum = 0;
		int maxSum = 0;
		boolean allNeg = true;
		int maxNeg = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			sum = sum + arr[i];
			if(sum < 0)
				sum = 0;
			if(arr[i] > 0)
				allNeg = false;
			if(allNeg) {
				if(arr[i] > maxNeg)
					maxNeg= arr[i];
			}
			if(sum > maxSum)
				maxSum = sum;
		}
		
		return allNeg ? maxNeg : maxSum;
	}
	
	//{1, 4, 8, 10, 13} and {2, 3, 5, 7, 10}
//	public int intersectionVal(int[] a, int[] b) {
//		return intersectionVal(a, b, 0, a.length-1, 0, b.length-1);
//	}
//	
//	public int intersectionVal(int[] a, int[] b, int a1, int a2, int b1, int b2)  {
//		if(a1 > a2 || b1 > b2)
//			return -1;
//		int a_mid = (a1 + a2) >>> 1;
//		int bIndex = indexOfSmallestValGrEqX(b, b1, b2, a[a_mid]);
//		if(bIndex == -1)  {
//			// all values in b are greater than a_mid
//			return intersectionVal(a, b, a_mid+1, a2, b1, b2);
//		} else if(a[a_mid] == b[bIndex]) {
//			return a[a_mid];
//		} else {
//			// some values in b are greater than a_mid , some are less
//			int searchOnHigherSide = intersectionVal(a, b, a_mid+1, a2, bIndex, b2);
//			int searchOnlowerSide = intersectionVal(a, b, a1, a_mid-1, b1, bIndex);
//			if(searchOnHigherSide != -1)
//				return searchOnHigherSide;
//			if(searchOnlowerSide != -1)
//				return searchOnlowerSide;
//		}
//		return -1;
//	}
	// index of smallest val (first occurence in case of duplications) that is 
	// Greater than or Equal to X.
	public int indexOfSmallestValGrEqX(Integer[] arr, int low, int high, int x) {
		if(high < low)
			return -1;
		
		if(low == high) {
			if(arr[low] < x)
				return -1;
			else
				return low;
		}
		
		int mid = (low + high) >>> 1;
		if(arr[mid] == x) {
			int firstIndex = indexOfSmallestValGrEqX(arr, low, mid-1, x);
			if(firstIndex != -1)
				return firstIndex;
			else
				return mid;
		}
		
		if(arr[mid] < x) {
			return indexOfSmallestValGrEqX(arr, mid+1, high, x);
		} else {
			return indexOfSmallestValGrEqX(arr, low, mid-1, x);
		}
		

	}
	
	public int lcs(String s1, String s2) {
		if(s1 == null || s2 == null) 
			return 0;
		
		if(s1.isEmpty() || s2.isEmpty())
			return 0;
		
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for(int i=0; i<s1.length(); i++) {
			dp[i][0] = 0; // s2 is empty
		}
		
		for(int i=0; i<s2.length(); i++) {
			dp[0][i] = 0; // s1 is empty
		}
		
		for(int i=0; i<s1.length(); i++) {
			for(int j=0; j<s2.length(); j++) {
				if(s1.charAt(i) == s2.charAt(j))
					dp[i+1][j+1] = Math.max(dp[i][j]+1, dp[i][j+1]);
				else
					dp[i+1][j+1] = Math.max(dp[i][j], dp[i][j+1]);
			}
		}
		
		return dp[s1.length()][s2.length()];
	}
	
	public int reverseSignedInteger(int num) {
		boolean neg = num < 0 ;
		int temp = num;
		if(neg)
			temp = -temp;
		
		int rev = 0;
		while(temp > 0) {
			rev = rev*10 + (temp % 10); 
			temp = temp/10;
		}
		return neg ? -rev : rev;
	}
	
	public void printAllPaths(BNode node) {
		List<BNode> list = new ArrayList<>();
		printAllPaths(node, list);
	}
	
	private void printAllPaths(BNode node, List<BNode> list) {
		if(node == null)
			return;
		
		if(node.left == null && node.right == null) {
			list.add(node);
			System.out.println(list.toString());
			list.remove(list.size()-1);
			return;
		}
		
		list.add(node);
		printAllPaths(node.left, list);
		printAllPaths(node.right, list);
		list.remove(list.size()-1);
	}
	
	public boolean isEndReachable(int[] arr) {
		boolean[] dp = new boolean[arr.length];
		return isEndRech(arr);
	}
	//int[] B= {3,2,1,0,4};[2, 3, 1, 1, 4]
	private boolean isEndRech(int[] arr) {
		if(arr == null)
			return false;
		
		if(arr.length == 1)
			return true;
		
		int max = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(max <= i && arr[i] == 0) {
				return false;
			}
			
			if(i + arr[i] > max)
				max = arr[i] + i;
			
			if(max >= arr.length-1)
				return true;
		}
		
		return false;
	}
	
	private boolean isEndReachable(int[] arr, boolean[] dpExplored, int curr, int dest) {
		if(curr > dest)
			return false;

		if(curr == dest)
			return true;
			
		if(dpExplored[curr])
			return false;
		
		int val = arr[curr];
		boolean isReachable = false;
		while(val > 0 && !isReachable) {
			isReachable = isEndReachable(arr,dpExplored, curr+val, dest);
			if(curr+val < arr.length)
				dpExplored[curr+val] = true;
			val--;
		}
		
		return isReachable;
	}
	
	public void combinations(int num) {
		Map<Integer, Character> map = new HashMap<>();
		char c = 'A';
		for(int i=1; i<=26; i++) {
			map.put(i, c++);
		}
		
		String s = Integer.toString(num);
		List<String> list = new ArrayList<>();
		combinations(s.toCharArray(), 0, "", list, map);
		System.out.println(list.toString());
	}
	
	private void combinations(char[] c, int index, String s, List<String> list, Map<Integer, Character> map) {
		if(index == c.length) {
			list.add(s);
			return;
		}
		
		for(int len=1; index+len <= c.length; len++) {
			int num = Integer.parseInt(new String(c,index, len));
			if(map.containsKey(num)) {
				combinations(c, index+len, s + map.get(num), list, map);
			}
		}
	}
	
	public double sqrtRecur(double x) {
		if(x < 0)
			return Double.NaN;
		
		if(x == 0 || x == 1)
			return x;
		
		return sqrtRecur(x, 0, x);
	}
	
	private double sqrtRecur(double x, double low, double high) {
		if(low > high)
			return Double.NaN;
		
		double mid = (low+high)/2;
		if(Math.abs(mid*mid - x) < 0.00001)
			return mid;
		
		if(mid*mid > x) {
			return sqrtRecur(x, low, mid);
		} else
			return sqrtRecur(x, mid, high);
		
	}
	
	
	public boolean hasUnbalancedParenthesis(String s, Map<Character, Character> map) {
		if(s == null)
			return false;
		
		if(s.isEmpty())
			return true;
		
		char c[] = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		Set<Character> closed = new HashSet<>();
		Collection<Character> collection = map.values();
		for(Character ch : collection) 
			closed.add(ch);
		
		for(int i=0; i<c.length; i++) {
			if(map.containsKey(c[i])) {
				stack.push(c[i]);
			}
			
			if(closed.contains(c[i])) {
				if(stack.isEmpty())
					return false;
				
				char open = stack.pop();
				if(map.get(open) != c[i])
					return false;
			}
		}
		
		if(!stack.isEmpty())
			return false;
		
		return true;
		
	}
	
	enum State {
		None,
		SingleLine,
		Multiline;
	}
	
	public void printWithoutComments(String lineWithComments) {
		if(lineWithComments == null || lineWithComments.isEmpty())
			return;
		
		State state = State.None;
		StringBuilder sb = new StringBuilder();
		int len = lineWithComments.length();
		char c[] = lineWithComments.toCharArray();
		for(int i=0; i+1<len; i++) {
			if(c[i] == '/' && c[i+1] == '*') {
				if(state.equals(State.None)) {
					state = State.Multiline;
					i = i+1;
				} 
			} else if(c[i] == '/' && c[i+1] == '/') {
				if(state.equals(State.None)) {
					state = State.SingleLine;
					i = i+1;
				}
			} else if(c[i] == '*' && c[i+1] == '/') {
				if(state.equals(State.Multiline)) {
					state = State.None;
					i = i+1;
				}
			} else if(c[i] == '\n') {
				if(state.equals(State.SingleLine)) {
					state = State.None;
					i = i+1;
				}
			} else {
				if(state.equals(State.None)) {
					sb.append(c[i]);
				}
			}
		}
		
		if(state.equals(State.None)) {
			sb.append(c[c.length-1]);
		}
		
		System.out.println(sb.toString());
		
	}
	
	// 3999 //314 = CCCXIV
}

class BNode implements Iterable<Integer> {
	int val;
	public BNode(int val) {
		this.val = val;
	}
	BNode left;
	BNode right;
	
	@Override
	public String toString() {
		return ""+this.val;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		final BNode node = this;
		return new Iterator<Integer>() {
			BNode currNode = node;
			Stack<BNode> stack = new Stack<>();
			@Override
			public boolean hasNext() {
				if(currNode != null || !stack.isEmpty())
					return true;
				else
					return false;
			}
			
			@Override
			public Integer next() {
				while(currNode != null) {
					stack.push(currNode);
					currNode = currNode.left;
				}
				currNode = stack.pop();
				Integer ret = currNode.val;
				currNode = currNode.right;
				return ret;
			}
			
			@Override
			public void remove() {
				
			}
		};
	}
}


class RomanNumeral { 
	
	int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	String romans[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV","I"};
	Map<Character, Integer> map;
	
	public RomanNumeral() {
		map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
	}
	//CCCXIV
	public int romanToNumber(String roman) {
		if(roman == null || roman.isEmpty())
			throw new NumberFormatException();
		
		int prev = 0;
		int sum = 0;
		for(int i=0;i< roman.length(); i++) {
			if(!map.containsKey(roman.charAt(i)))
				throw new NumberFormatException();
			int val = map.get(roman.charAt(i));
			sum = sum + val;
			
			if(val > prev) {
				sum = sum - prev - prev ;
			}
			prev = val;
		}
		
		if(sum > 3999)
			throw new NumberFormatException();
		return sum;
	}
	
	public String numberToRoman(int num) {
		if(num <= 0 || num > 3999)
			throw new NumberFormatException();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<values.length; i++) {
			while(num >= values[i]) {
				sb.append(romans[i]);
				num = num - values[i];
			}
		}
		
		return sb.toString();
	}
}

class KeyPad { 
	Map<Integer, List<Character>> map;
	public KeyPad() {
		map = new HashMap<>();
		populate();
	}
	
	private void populate() {
		if(map == null) 
			map = new HashMap<>();
			
		char c = 'A';
		for(int i=2; i<=9; i++) {
			map.put(i, new ArrayList<Character>());
			map.get(i).add(c++);
			map.get(i).add(c++);
			map.get(i).add(c++);
			if(i == 9)
				map.get(i).add(c);
		}
	}
	
	public List<String> generatePossibleKeys(int num) {
		if(num <= 1)
			return new ArrayList<>();
		
		List<String> list=  new ArrayList<>();
		int len = length(num);
		char buf[] = new char[len];
		generatePossibleKeys(num, buf, len-1, list);
		return list;
	}
	
	private int length(int num) {
		int len = 0;
		for(int i=0; i<size.length; i++) {
			if(num < size[i]) {
				len++;
			}
		}
		return len;
	}
	
	private static int[] size = {9,99,999,9999,99999,999999,9999999, 99999999, 999999999, Integer.MAX_VALUE};
	
	private void generatePossibleKeys(int num, char buf[], int index, List<String> list) {
		if(num == 0) {
			list.add(new String(buf));
			return;
		}
		
		int digit = num % 10;
		if(map.containsKey(digit)) {
			List<Character> mappings = map.get(digit);
			for(char c : mappings) {
				buf[index] = c;
				generatePossibleKeys(num/10, buf, index-1, list);
			}
		}
	}
}
