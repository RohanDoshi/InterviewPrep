import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;



public class Page4 {

	public static void main(String[] args) {
		Page4 pg = new Page4();
		System.out.println(pg.isAnagramPresent("rot", "actor"));
		pg.printAllSubsetsLengthK(5, 3);
		pg.printAllSubsetsOfString("reema".toCharArray());
		pg.printAllUniqSubsetsOfString("reema".toCharArray());
		pg.printAllUniqSubsetsOfString("reeea".toCharArray());
		int[] arr = {1,1,1,2,4,4,3,4,4,4};//{2,1,1,1,3,4,4,4,5};
		pg.groupOfSizeMShouldNotHaveAllSameNums(arr, 2);
		
		Page6 pg6 = new Page6();
		BinaryNode<Integer> node = new BinaryNode<Integer>(0);
		node.left = new BinaryNode<Integer>(0);
		node.right = new BinaryNode<Integer>(0);
		node.left.left = new BinaryNode<>(1);
		node.left.right = new BinaryNode<Integer>(2);
		node.right.left = new BinaryNode<Integer>(3);
		node.right.right = new BinaryNode<Integer>(4);
		
		pg.sinkZeroBinaryTreeCorrectKickAss(node);
		pg.printLevelOrder(node);
		
		Map<Integer, List<Character>> map = new HashMap<>();
		char c = 'A';
		for(int i=1; i<=9; i++) {
			List<Character> list = new ArrayList<>();
			list.add(c++);
			list.add(c++);
			list.add(c++);
			map.put(i, list);
		}
		
		pg.generateAllPossibilities(map, 112);
		String[] input = {"star", "astr", "car", "rac", "st"};
		pg.groupAnagrams(input);
		System.out.println(pg.addBinaryStrings("1001010", "00101"));
		pg.generateAllValidParenthesis(3);
		pg.printAllPossibleSetsThatAddToN(4);
		pg.printAllPalindromes("abba");
		int ap[] = {1,3,5,7,9,11};
		System.out.println(pg.arithmeticProgression(ap));
		
		List<Point> points = new ArrayList<Point>();
        
        points.add(new Point(1, 2));
        points.add(new Point(3, 3));
        points.add(new Point(4, 1));
        points.add(new Point(-1, 3));
        points.add(new Point(0, -1));
        points.add(new Point(3, -1));
        points.add(new Point(5, -1));
        points.add(new Point(1, 3));
        points.add(new Point(2, 2));
        Point[] pointsArr = points.toArray(new Point[points.size()]);
		pg.findKPointsClosestOrigin(pointsArr, 5);
		int[] set = {1,2,3};
		pg.printPowerSetKickAss(set);
		int hist[] = {2,1,5,6,2,3};//{6,2,5,4,5,2,6};//{10,40,30,70,10,30,60};
		pg.maxAreaHistogram(hist);
		int nonZero[] = {1,0,2,0,0,3,4};
		pg.moveAllNonZeroToLeft(nonZero);
		pg.reverseEachWordInStringWithSpaces("the boy ran");
	}
	
	public void reverseEachWordInStringWithSpaces(String s) {
		char c[] = s.toCharArray();
		int start = 0;
		for(int i=0; i<c.length; i++) {
			if(c[i] == ' ') {
				reverse(c, start, i-1);
				start = i+1;
			}
		}
		
		System.out.println(c);
	}
	
	private void reverse(char c[], int from, int to) {
		while(from < to) {
			char temp = c[from];
			c[from] = c[to];
			c[to] = temp;
			from++;
			to--;
		}
	}
	
	public void moveAllNonZeroToLeft(int[] arr) {
		
		int i=arr.length-1;
		int j=0;
		while(i >j) {
			if(arr[i] > 0 || arr[i] < 0) {
				i--;
			} else {
				swap(arr, i, j);
				j++;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	public void maxAreaHistogram(int[] hist) {
		Stack<Integer> left = new Stack<>();
		Stack<Integer> right = new Stack<>();
		int[] width = new int[hist.length];
		
		for(int i=0; i<hist.length; i++) {
			width[i] = 0;
		}
		
		for(int i=0; i<hist.length; i++) {
			if(left.isEmpty()) {
				left.push(i);
			} else {
				while(!left.isEmpty() && hist[left.peek()] > hist[i])
					left.pop();
				
				if(left.isEmpty()) 
					width[i] = width[i] + i + 1;
				else {
					width[i] = width[i] + (i - left.peek());
				}
				left.push(i);
			}
		}
		
		
		for(int i=hist.length-1; i>=0; i--) {
			if(right.isEmpty()) {
				right.push(i);
			} else {
				while(!right.isEmpty() && hist[right.peek()] > hist[i])
					right.pop();
				
				if(right.isEmpty())
					width[i] = width[i] + (hist.length-i);
				else {
					width[i] = width[i] + (right.peek() -i) -1;
				}
				right.push(i);
			}
		}
		
		int max = 0;
		for(int i=0; i<hist.length; i++) {
			max = Math.max(max, hist[i]*width[i]);
		}
		
		System.out.println("Max Area ="+max);
	}
	
	public void printPowerSetKickAss(int[] arr) {
		for(int i=0; i<(1 << arr.length); i++) {
			System.out.print("{");
			for(int j=0; j<arr.length; j++) {
				if((i & (1 << j)) > 0) {
					System.out.print(arr[j]+" ");
				}
			}
			System.out.println("}");
		}
	}
	
	public boolean patternMatching(String s, String pattern) {
		if(s == null || pattern == null)
			return false;
		
		if(s.isEmpty()) 
			return pattern.isEmpty() ? true : (pattern.length() == 2 && pattern.charAt(1) == '*');
		
		Character pat = pattern.charAt(0);
		Character pat1 = pattern.length() >= 2 ? pattern.charAt(1) : null;
		Character c = s.charAt(0);
		
		if(pat1 == '*') {			// one or more							// zero chars match
			return patternMatching(s.substring(1), pattern) || patternMatching(s, pattern.substring(2));
		} else if(pat1 == '+') {
			return c == pat && patternMatching(s.substring(1), ""+pat+"*"+pattern.substring(2));
		} else {
			if(pat == '.')
				return patternMatching(s.substring(1), pattern.substring(1));
			else
				return c == pat && patternMatching(s.substring(1), pattern.substring(1));
		}
	}
	
	private static class Point {
		int x;
		int y;
		double distance;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return ""+distance;
		}
	}
	
	public void findKPointsClosestOrigin(Point[] points, int k) {
		for(int i=0; i<points.length; i++) {
			points[i].distance = Math.hypot(points[i].x, points[i].y);
		}
		
		// find kth closest point
		int low = 0;
		int high = points.length-1;
		while(low < high) {
			int index = partition(points, low, high);
			if(k-1 == index) {
				break;
			} else if (k - 1 > index) {
				low = index+1;
			} else {
				high = index-1;
			}
		}
		
		System.out.println(Arrays.toString(points));
		
	}
	// 1 2 3 4 0 // 0 2 3 4 1
	private int partition(Point[] points, int from, int to) {
		double pivot = points[from].distance;
		int pivotIndex = from;
		int lastSwap = from;
		for(int i=from+1; i<=to; i++) {
			if(points[i].distance < pivot) {
				swap(points, pivotIndex, i);
				lastSwap = i;
				pivotIndex++;
			}
		}
		swap(points, lastSwap, pivotIndex);
		return pivotIndex;
	}
	
	private void swap(Point[] points, int a, int b) {
		Point temp = points[a];
		points[a] = points[b];
		points[b] = temp;
	}
	
	public boolean isBST(BinaryNode<Integer> node) {
		if(node == null)
			return true;
		
		boolean b[] = new boolean[1];
		b[0] = true;
		isBST(node, b);
		return b[0];
	}
	
	private int isBST(BinaryNode<Integer> node, boolean b[] ) {
		if(node == null)
			return Integer.MIN_VALUE;
		
		int left = Integer.MIN_VALUE;
		int right = Integer.MAX_VALUE;
		
		if(node.left != null)
			left = isBST(node.left, b);
		if(node.right != null)
			right = isBST(node.right, b);
		
		if(node.value >= left && node.value < right)
			b[0] = b[0] & true;
		else
			b[0] = false;
		
		return (node.left == null && node.right == null)  
				|| (node.right == null )? node.value : right;
	}
	
	// find missing element in A.P.
	// Given the AP :-{1,3,5,9,11,13} find the missing value "which would be 5 here"
	public int arithmeticProgression(int[] arr) {
		int low = 0;
		int high = arr.length-1;
		int a = arr[0];
		int d = arr[1] - arr[0];
		int missingVal = -1;
		while(low <= high) {
			int mid = (low + high) >>> 1;
			int tVal = mid + 1;
			int expectedVal = (a + (tVal-1)*d);
			if(arr[mid] == expectedVal) {
				low = mid + 1;
			} else {
				missingVal = expectedVal;
				high = mid -1;
			}
		}
		
		return missingVal;
	}
	
	
	public void printAllPalindromes(String s) {
		List<String> palindromes = new ArrayList<>();
		char c[] = s.toCharArray();
		int len = c.length;
		boolean table[][] = new boolean[len+1][len+1];
		for(int i=0; i<c.length; i++) {
			palindromes.add(new String(c,i,1));
			table[i][i] = true;
		}
		for(int i=0; i+1<c.length; i++) {
			if(c[i] == c[i+1]) {
				palindromes.add(new String(c,i,2));
				table[i][i+1] = true;
			}
		}
		int currLen = 3;
		for(int l = currLen; l<= len; l++) {
			for(int i=0; i+l-1<len; i++) {
				int j = i+l-1;
				if(c[i] == c[j] && table[i+1][j-1]) {
					palindromes.add(new String(c,i,l));
					table[i][j] = true;
				}
			}
		}
		
		System.out.println(palindromes.toString());
	}
	
	public void printAllPossibleSetsThatAddToN(int N) {
		System.out.println("printAllPossibleSetsThatAddToN.....");
		if(N <= 0)
			return;
		
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		printAllUniqSetsThatSumToN(N, list, res, 1);
		for(int i=0; i<res.size(); i++)
			System.out.println(res.get(i).toString());
	}
	
	private void printAllPossibleSetsThatSumToN(int N, List<Integer> list, List<List<Integer>> res) {
		if(N < 0)
			return;
		
		if(N == 0) {
			res.add(new ArrayList<>(list));
			return;
		}
		
		for(int i=1; i<=N; i++) {
			list.add(i);
			printAllPossibleSetsThatSumToN(N-i, list, res);
			list.remove(list.size()-1);
		}
	}
	
	private void printAllUniqSetsThatSumToN(int N, List<Integer> list, List<List<Integer>> res, int num) {
		if(N < 0)
			return;
		
		if(N == 0) {
			res.add(new ArrayList<>(list));
			return;
		}
		
		for(int i=num; i<=N; i++) {
			list.add(i);
			printAllUniqSetsThatSumToN(N-i, list, res, i);
			list.remove(list.size()-1);
		}
	}
	
	public void generateAllValidParenthesis(int N) {
		generateAllValidParenthesis(N, 0, 0, "");
	}
	
	private void generateAllValidParenthesis(int N, int open, int close, String s) {
		if(open == N && close == N) {
			System.out.print(s+" ");
			return;
		}
		
		if(open < N) {
			generateAllValidParenthesis(N, open+1, close, s+"(");
			if(close < open) 
				generateAllValidParenthesis(N, open, close+1, s+")");
		} else {
			generateAllValidParenthesis(N, open, close+1, s+")");
		}
	}
	
	public String addBinaryStrings(String s1, String s2) {
		if(s1 == null || s2 == null)
			return null;
		
		if(s1.isEmpty() || s2.isEmpty())
			return s1.isEmpty() ? s2 : s1;
		
		if(s1.length() < s2.length()) {
			s1 = appendZeroes(s1, s2.length()-s1.length());
		} else if(s2.length() < s1.length()) {
			s2 = appendZeroes(s2, s1.length()-s2.length());
		}
		
		char res[] = new char[s1.length()+1];
		int carry = 0;
		for(int i=s1.length()-1; i>=0; i--) {
			int sum = ((s1.charAt(i)- '0')^(s2.charAt(i)- '0')); 
			sum = sum ^ carry;
			res[i+1] = (char)(sum + '0');
			carry = (carry & (s1.charAt(i)-'0')) | 
					(carry & (s2.charAt(i)-'0')) | 
					((s1.charAt(i) & s2.charAt(i))-'0');
		}
		res[0] = (char)(carry+'0');
		return new String(res);
	}
	
	
	private String appendZeroes(String s, int n) {
		char[] buf = new char[s.length()+n];
		int w = 0;
		while(n > 0) {
			buf[w++] = '0';
			n--;
		}
		int i=0;
		while(i < s.length()) {
			buf[w++] = s.charAt(i);
			i++;
		}
		return new String(buf);
	}
	
//	input = ["star, astr, car, rac, st"] 
//			output = [["star, astr"],["car","rac"],["st"]);
	public void groupAnagrams(String[] input) {
		System.out.println("groupAnagrams...");
		Map<Character, Integer> mapAlphabetPrime = assignPrimeNumberToAlphabets();
		Map<Integer, List<String>> res = new HashMap<>();
		int prod = 1;
		for(int i=0; i<input.length; i++) {
			prod = 1;
			String s = input[i];
			for(int j=0; j<s.length(); j++) {
				prod = prod * mapAlphabetPrime.get(s.charAt(j));
			}
			if(res.containsKey(prod)) {
				res.get(prod).add(s);
			} else {
				res.put(prod, new ArrayList<String>());
				res.get(prod).add(s);
			}
		}
		
		Collection<List<String>> result = res.values();
		System.out.println(result.toString());
	}
	
	public void generateAllPossibilities(Map<Integer, List<Character>> map, int num) {
		List<String> list = new ArrayList<>();
		generateAllPossibilities(map, num, "", list);
		System.out.println(list.toString());
	}
	
	private void generateAllPossibilities(Map<Integer, List<Character>> map, int num, String s, List<String> list) {
		if(num == 0) {
			list.add(s);
			return;
		}
		
		int digit = num % 10;
		List<Character> mappings = map.get(digit);
		for(char c : mappings) {
			generateAllPossibilities(map, num/10, c+s, list);
		}
	}
	
	public void printLevelOrder(BinaryNode<Integer> node) {
		
		Queue<BinaryNode<Integer>> queue = new LinkedList<>();
		queue.add(node);
		queue.add(null);
		while(queue.size() != 1) {
			BinaryNode<Integer> bn = queue.poll();
			if(bn == null) {
				System.out.println();
				queue.add(null);
				continue;
			}
			
			System.out.print(bn.value+" ");
			if(bn.left != null)
				queue.add(bn.left);
			
			if(bn.right != null)
				queue.add(bn.right);
			
		}
		
		
	}
	
	public void sinkZeroBinaryTreeCorrectKickAss(BinaryNode<Integer> node) {
		Stack<BinaryNode<Integer>> stack = new Stack<>();
		sinkZeroBinaryTreeCorrect(node, stack);
	}
	
	private void sinkZeroBinaryTreeCorrect(BinaryNode<Integer> node, Stack<BinaryNode<Integer>> stack) {
		if(node == null)
			return;
		
		if(node.value == 0) {
			stack.push(node);
		} else {
			if(!stack.isEmpty()) {
				BinaryNode<Integer> elem = stack.pop();
				elem.value = node.value;
				node.value = 0;
			}
		}
		sinkZeroBinaryTreeCorrect(node.left, stack);
		sinkZeroBinaryTreeCorrect(node.right, stack);
	}
	
	// INCORRECT
	public void sinkZeroBinaryTree(BinaryNode<Integer> node) {
		if(node == null)
			return;
		
		if(node.value == 0) {
			if(node.right != null) {
				if(node.right.value != 0) {
					node.value = node.right.value;
					node.right.value = 0;
				}
			}  
			
			if(node.value == 0 && node.left != null) {
				if(node.left != null) {
					node.value = node.left.value;
					node.left.value =0;
				}
			}
		}
		
		sinkZeroBinaryTree(node.left);
		sinkZeroBinaryTree(node.right);
	}
	
//	Input: 2,1,1,1,3,4,4,4,5 M = 2 
//			Output: 2,1,1,3,1,4,4,5,4
	public void groupOfSizeMShouldNotHaveAllSameNums(int[] arr, int m) {
		for(int i=0; i+m<arr.length; i++) {
			if(areAllSame(arr, i, i+m)) {
				// swap (i+m) , (i+m+1)
				if(i+m+1 < arr.length) {
					swap(arr, i+m, i+m+1);
				}
			}
		}
		if(areAllSame(arr, arr.length-m-1, arr.length-1)) {
			int elem = arr[arr.length-m-1];
			for(int i=0; i<arr.length-m-1; i++) {
				if(arr[i] != elem) {
					swap(arr, i, arr.length-1);
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	private void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	private boolean areAllSame(int[] arr, int a, int b) {
		int prev = arr[a];
		for(int i=a+1; i<=b; i++) {
			if(arr[i] != prev)
				return false;
		}
		return true;
	}
	
	public void printAllUniqSubsetsOfString(char[] c) {
		System.out.println("printAllUniqSubsetsOfString...");
		Map<Character, Integer> map = new HashMap<>();
		List<List<Character>> result = new ArrayList<>();
		result.add(new ArrayList<Character>());
		for(int i=0; i<c.length; i++) {
			if(map.containsKey(c[i])) {
				map.put(c[i], map.get(c[i])+1);
				int currCount = map.get(c[i]);
				int size = result.size();
				for(int j=0; j<size; j++) {
					List<Character> list = new ArrayList<>(result.get(j));
					int elemCount = 0;
					for(int k=0; k<list.size(); k++) {
						if(list.get(k) == c[i])
							elemCount++;
					}
					if(elemCount == currCount-1) {
						List<Character> newList = new ArrayList<>(list);
						newList.add(c[i]);
						result.add(newList);
					} else {
						System.out.print("");
					}
				}
			} else {
				map.put(c[i], 1);
				int size = result.size();
				for(int j=0; j<size; j++) {
					List<Character> list = new ArrayList<>(result.get(j));
					list.add(c[i]);
					result.add(list);
				}
			}
		}
		System.out.println("Result size ="+result.size());
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i).toString());
		}
	}
	
	public void printAllSubsetsOfString(char[] c) {
		System.out.println("printAllSubsetsOfString....");
		List<List<Character>> result = new ArrayList<>();
		result.add(new ArrayList<Character>());
		for(int i=0; i<c.length; i++) {
			int size = result.size();
			for(int j=0; j<size; j++) {
				List<Character> list = new ArrayList<>(result.get(j));
				list.add(c[i]);
				result.add(list);
			}
		}
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i).toString());
		}
	}
	
	
	public void printAllSubsetsLengthK(int N, int k) {
		List<List<Integer>> allSubsetList = new ArrayList<>();
		List<List<Integer>> kLenSubsets = new ArrayList<>();
		allSubsetList.add(new ArrayList<Integer>());
		for(int i=1; i<=N; i++) {
			int size = allSubsetList.size();
			for(int j=0; j<size; j++) {
				if(allSubsetList.get(j).size() < k) {
					List<Integer> list = new ArrayList<>(allSubsetList.get(j));
					list.add(i);
					if(list.size() == k) {
						kLenSubsets.add(list);
					} else {
						allSubsetList.add(list);
					}
				}
			}
		}
		
		for(int i=0; i<kLenSubsets.size(); i++) {
			System.out.println(kLenSubsets.get(i).toString());
		}
	}
	
	// if anagram of needle exists in haystack
	public boolean isAnagramPresent(String needle, String haystack) {
		int needleLen = needle.length();
		int haystackLen = haystack.length();
		Map<Character, Integer> mapAlphabetPrime = assignPrimeNumberToAlphabets();
		
		int needleProd = 1;
		for(int i=0; i<needle.length(); i++) {
			needleProd = needleProd * (mapAlphabetPrime.get(needle.charAt(i)));
		}
		
		int haystackProd = 1;
		int start = 0;
		for(int i=start; i < haystackLen; i++) {
			haystackProd = haystackProd * (mapAlphabetPrime.get(haystack.charAt(i)));
			if(i-start+1 == needleLen) {
				if(haystackProd == needleProd)
					return true;
				else { 
					haystackProd = haystackProd / mapAlphabetPrime.get(haystack.charAt(start));
					start++;
				}
			}
		}
		return false;
	}
	
	private Map<Character, Integer> assignPrimeNumberToAlphabets() {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int[] primes = generateNPrimeNum(26);
		for(int i=0; i<primes.length; i++) {
			map.put((char)('a'+i), primes[i]);
		}
		return map;
	}
	
	private int[] generateNPrimeNum(int N) {
		int prime = 2;
		int[] arr = new int[N];
		int i = 0;
		while(i < N) {
			if(isPrime(prime)) {
				arr[i] = prime;
				i++;
			}
			prime++;
		}
		return arr;
	}
	
	private boolean isPrime(int num) {
		if(num <= 1)
			return false;
		if(num == 2 || num == 3)
			return true;
		if(num % 2 == 0 || num % 3 == 0)
			return false;
		
		int sqrt = (int) Math.ceil(sqrt(num));
		for(int i=5; i<=sqrt; i+=6) {
			if(num % i == 0 || num % (i+2) == 0)
				return false;
		}
		return true;
		
	}
	
	private double sqrt(double num) {
		double low = 0;
		double high = num;
		double mid = (low + high)/2;
		while(Math.abs(mid*mid - num) > 0.00001) {
			if(mid*mid > num) {
				high = mid;
			} else {
				low = mid;
			}
			mid = (low + high)/2;
		}
		return mid;
	}

}
