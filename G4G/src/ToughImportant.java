import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;


public class ToughImportant {

	// x=1 => 17 , 21
	// x=0 => 13 , 10 ( 3 , 0 )
	
	public static void main(String[] args) {
		String eq = "x+9-2-4+x=x+5-1+3-x";//"2*x+5=4*x+9";//"8+5+x+3*x=10-x+4*3*x"; //
		ToughImportant tough = new ToughImportant();
		tough.solveLinearEquation(eq,'x');
		int A[] = {2, 6, 3, 4, 1, 2, 9, 5, 8};
				//{ 2, 5, 3, 1, 11, 8, 10, 13, 6 }; 
			//{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		tough.longestIncrSubseqBest(A);
		int arr6[]={6, 3, -10, -2, -2};
		tough.maxProductSubarr(arr6);
		int[] sumTo = {1, 3, 2, 5, 4, 10,-1};
		tough.subArrWithSumExists(sumTo, 9);
		
		int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		tough.findSubarrWithLargestSum(arr);
		
		int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
	    int A2[] = {2, 1, 8, 3};
	    tough.sortArrBasedOnOther(A1, A2);
	    
	    int[] partition = {1,1,0,1,2,2,0,1,0,1,2};
	    tough.threeWayPartition(partition);
	    System.out.println(tough.isPalindrome("madame"));//madamabaaibohphobia
	    System.out.println(tough.minSplitsCollPalindromes("rohan"));
	    System.out.println(tough.maxLengthPalindrome("madac"));
	    int input[] = {2, 3, 10, 4, 5};
	    tough.constructProductArr(input);
	    System.out.println("rohan".hashCode());
	    
	    System.out.println(tough.toString(Integer.MAX_VALUE));
	    int mid = (Integer.MAX_VALUE - 2 + Integer.MAX_VALUE -1) / 2;
	    System.out.println(mid);
	    int[] arr1 = {-5, -2, -1, 2, 4, 5};
	    System.out.println(tough.findSpot(arr1));
	    System.out.println((Integer.MAX_VALUE + Integer.MAX_VALUE) >>> 1);
	    
	    String[] prob = {"1/6", "1/6", "1/6", "1/6", "1/6", "1/6"};
	    int[] faces = {1,2,3,4,5,6};
	    Random r = new Random();
	    for(int i=0; i<10; i++) {
	    	System.out.print(tough.rollFairDie(faces)+" ");
	    }
	    
	    System.out.println("Loaded dice.....");
	    String[] probLoaded = {"1/2","1/3","1/12","1/12"};
	    for(int i=0; i<10; i++) {
	    	System.out.print(tough.rollLoadedDie(probLoaded)+" ");
	    }
	    System.out.println("indexOf-----");
	    System.out.println(tough.indexOf("aaaaaaaaabf", "aaaaaaaaabf"));
	    String input1 = "This is a test This is a programming test a programming test this is".toLowerCase();
	    String keys = "this test a programming";
	    tough.smallestSubstringThatContainsAllWords(input1, Arrays.asList(keys.split(" ")));
	    
	    Point p1 = new Point(1, 1);
	    Point p2 = new Point(10, 1);
	    Point p3 = new Point(1, 2);
	    Point p4 = new Point(10, 2);
	    
	    Line l1 = new Line(p1, p2);
	    Line l2 = new Line(p3, p4);
	    System.out.println(tough.doLinesIntersect(l1, l2));
	    
	    p1 = new Point(-5, -5);
	    p2 = new Point(0, 0);
	    p3 = new Point(1, 1);
	    p4 = new Point(10, 10);
	    
	    l1 = new Line(p1, p2);
	    l2 = new Line(p3, p4);
	    System.out.println(tough.doLinesIntersect(l1, l2));
	    
	    p1 = new Point(10, 0);
	    p2 = new Point(0, 10);
	    p3 = new Point(0, 0);
	    p4 = new Point(10, 10);
	    
	    l1 = new Line(p1, p2);
	    l2 = new Line(p3, p4);
	    System.out.println(tough.doLinesIntersect(l1, l2));
	    
	}
	
	public void maxDiffBet2ElementsTricky(int[] arr) {
		int aux[] = new int[arr.length-1];
		for(int i=0; i<aux.length; i++) {
			aux[i] = arr[i+1] - arr[i];
		}
		
		int maxContiguosSum = 0;
		int curr_sum = 0;
		for(int i=0; i<aux.length; i++) {
			if(curr_sum + aux[i] > curr_sum) {
				curr_sum = curr_sum + aux[i];
			} else {
				curr_sum = 0;
			}
			
			if(curr_sum > maxContiguosSum) 
				maxContiguosSum = curr_sum;
		}
		
		System.out.println("Max Diff => "+maxContiguosSum);
	}

	public void maxDiffBet2Elements(int[] arr) {
		
		int min = arr[0];
		int max = arr[0];
		
		int maxDiff = 0;
		int diff = 0;
		for(int i=1; i<arr.length; i++) {
			if(arr[i] < min) {
				if(diff > maxDiff)
					maxDiff = diff;
				diff = 0;
				min = arr[i];
			} else { 
				if(arr[i] > max) {
					diff = arr[i] - min;
					max = arr[i];
				}
			}
		}
		
		if(diff != 0) {
			if(diff > maxDiff)
				maxDiff = diff;
		}
		
		System.out.println("Max Diff ==> "+maxDiff);
	}
    
	private static class Line {
		Point a;
		Point b;
		public Line(Point a, Point b) {
			this.a = a;
			this.b = b;
		}
	}
	
	private static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public boolean doLinesIntersect(Line l1, Line l2 ) {
		Point a = l1.a;
		Point b = l1.b;
		Point c = l2.a;
		Point d = l2.b;
		int o1 = getOrientation(a,b,c);
		int o2 = getOrientation(a,b,d);
		int o3 = getOrientation(c, d, a);
		int o4 = getOrientation(c, d, b);
		if(o1 != o2 && o3 != o4)
			return true;
		
		// either they are parallel to each other or one point is collinear with a line
		if(o1 == 0 && onLineSegment(l1, c))
			return true;
		
		if(o2 == 0 && onLineSegment(l1, d))
			return true;
		
		if(o3 == 0 && onLineSegment(l2, a))
			return true;
		
		if(o4 == 0 && onLineSegment(l2, b))
			return true;
		
		return false; // they are parallel to each other
	}
	
	public boolean onLineSegment(Line l, Point p) {
		if(p.x >= Math.min(l.a.x, l.b.x) && p.x <= Math.max(l.a.x, l.b.x) &&
				p.y >= Math.min(l.a.y, l.b.y) && p.y <= Math.max(l.a.y, l.b.y))
			return true;
		
		return false;
	}
	
	public int getOrientation(Point p1, Point p2, Point p3) {
//		double slope1 = (p2.y -p1.y) / (p2.x - p1.x);
//		double slope2 = (p3.y -p2.y) / (p3.x - p2.x);
		int val = (p2.y -p1.y)*(p3.x - p2.x) - (p2.x - p1.x)*(p3.y -p2.y);
		if(val == 0)
			return val;
		
		if(val > 0)
			return 1; // clockwise
		else
			return 2; // anti-clockwise
	}
	
//	Input: This is a test. This is a programming test. a programming test this is
//
//	Looking for: this, test, a, programming
	public void smallestSubstringThatContainsAllWords(String input, List<String> keys) {
		String[] words = input.split(" ");
		int tab[][] = new int[keys.size()][words.length];
		int minLen = words.length;
		Map<String, Integer> mapKeyIndex = new HashMap<>();
		for(int i=0; i<words.length; i++) {
			for(int j=0; j<keys.size(); j++) {
				String keyWord = keys.get(j);
				if(words[i].equals(keyWord)) {
					tab[j][i] = i+1;
					mapKeyIndex.put(keyWord, tab[j][i]);
				}
				if(mapKeyIndex.size() == keys.size()) {
					// maxIndex - minIndex + 1;
					Collection<Integer> list = mapKeyIndex.values();
					Iterator<Integer> iter = list.iterator();
					int min = Integer.MAX_VALUE;
					int max = Integer.MIN_VALUE;
					while(iter.hasNext()) {
						int val = iter.next();
						if(val > max)
							max = val;
						if(val < min)
							min = val;
					}
					int len = max-min+1;
					if(len < minLen)
						minLen = len;
				}
			}
		}
		System.out.println("min len => "+minLen);
	}
	
	public int indexOf(String haystack, String needle) {
		if(haystack == null || needle == null)
			return -1;
		
		if(needle.isEmpty())
			return 0;
		
		if(haystack.isEmpty())
			return -1;
		
		if(haystack.length() < needle.length())
			return -1;
		
		char hay[] = haystack.toCharArray();
		char need[] = needle.toCharArray();
		char firstChar = need[0];
		int needLen = need.length;
		int hayLen = hay.length;
		
		for(int i=0; i<=hayLen-needLen; i++) {
			if(hay[i] == firstChar) {
				int start = i;
				int j = 0;
				while(j < needLen && hay[start+j] == need[j]) {
					j++;
				}
				
				if(j == needLen)
					return start;
			}
		}
		return -1;
	}
	
	public int rollLoadedDie(String[] probLoaded) {
		int[] faces = new int[probLoaded.length];
		int lcm = lcm(probLoaded);
		int loadedFaces[] = new int[lcm];
		int num = 1, j =0;
		for(int i=0; i<probLoaded.length; i++) {
			int val = (Integer.parseInt(probLoaded[i].split("/")[0]) * lcm)/ Integer.parseInt(probLoaded[i].split("/")[1]);
			while(val > 0) {
				loadedFaces[j++] = (i+1);
				val--;
			}
		}
		return loadedFaces[rollFairDie(loadedFaces)];
	}
	
	public int lcm(String[] probLoaded) {
		Set<Integer> denom =new HashSet<Integer>();
		for(int i=0; i<probLoaded.length; i++) {
			denom.add(Integer.parseInt(probLoaded[i].split("/")[1]));
		}
		
		return lcm(denom.toArray(new Integer[denom.size()]));
	}
	
	public int lcm(Integer arr[]) {
		int lcm = arr[0];
		for(int i=1; i<arr.length; i++) {
			lcm = lcmTwoNum(lcm, arr[i]);
		}
		return lcm;
	}
	
	public int gcd(Integer arr[]) {
		Arrays.sort(arr);
		int gcd = arr[0];
		for(int i=1; i<arr.length; i++) {
			gcd = gcdTwoNum(gcd, arr[i]);
		}
		return gcd;
	}
	
	public int lcmTwoNum(int a, int b) {
		return a*b/gcdTwoNum(a, b);
	}
	
	// 26 % 16
	public int gcdTwoNum(int a, int b) {
		if(b == 0)
			return a;
		
		if(a == 0)
			return b;
		
		int rem = a % b;
		return gcdTwoNum(b, rem);
	}
	
	public int rollFairDie(int[] faces) {
		Random r = new Random();
		return (int)Math.ceil((r.nextDouble() % 1)*(faces.length-1));
	}
	
	public int findSpot(int arr[]) {
		int low = 0;
		int high = arr.length-1;
		int minMid = arr.length;
		while(low <= high) {
			int mid = (low+high) >>> 1;
			if(mid == arr[mid]) {
				if(mid < minMid)
					minMid = mid;
				high = mid-1;
			} else if(mid > arr[mid]) {
				low = mid+1;
			} else {
				high = mid-1;
			}
		}
		
		return minMid == arr.length ? -1 : minMid;
	}
	
	
	
	
	private int[] sizeTab = {9,99,999,9999,99999,999999,9999999,99999999, 999999999, Integer.MAX_VALUE};
	public String toString(int num) {
		if(num == 0)
			return "0";
		
		if(num == Integer.MIN_VALUE) {
			return "";
		}
		
		int size = 0;
		boolean neg = num < 0;
		int temp = neg ? -num : num;
		for(int i=0; i<sizeTab.length; i++) {
			if(temp <= sizeTab[i]) {
				size = i+1;
				break;
			}
		}
		
		char c[] = null;
		c = neg ? new char[size+1] : new char[size];
		
		int i = c.length-1;
		while(temp > 0) {
			int a = temp % 10;
			c[i--] = (char) ('0' + a);
			temp = temp / 10;
		}
		
		if(neg) {
			c[0] = '-';
		}
		
		return new String(c);
		
	}
	// Given input: [2, 3, 10, 4, 5], output: [600, 400, 120, 300, 240]
	public void constructProductArr(int arr[]) {
		int[] p1 = new int[arr.length];
		int[] p2 = new int[arr.length];
		int prod = 1;
		
		for(int i=0; i<p1.length; i++) {
			p1[i] = prod;
			prod = prod * arr[i];
		}
		prod = 1;
		for(int i=arr.length-1; i>=0; i--) {
			p2[i] = prod;
			prod = prod * arr[i];
		}
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = p1[i] * p2[i];
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public int maxLengthPalindrome(String s) {
		if(s == null)
			return 0;
		
		if(s.isEmpty())
			return 0;
		
		if(s.length() == 1)
			return 1;
		
		char c[] = s.toCharArray();
		int maxLen[][] = new int[c.length][c.length];
		for(int i=0; i<c.length; i++) {
			maxLen[i][i] = 1;
		}
		
		for(int i=1; i<c.length; i++) {
			if(c[i-1] == c[i]) {
				maxLen[i-1][i] = 2;
				maxLen[i][i-1] = 2;
			}
		}
		int res = 1;
		for(int len=3; len<=c.length; len++) {
			for(int i=0; i+len-1<c.length; i++) {
				if(c[i] == c[i+len-1] && maxLen[i+1][i+len-2] != 0) {
					maxLen[i][i+len-1] = maxLen[i+1][i+len-2] +2;
					maxLen[i+len-1][i] = maxLen[i+1][i+len-2] +2;
					res = maxLen[i][i+len-1];
				}
			}
		}
		int[] mat = new int[c.length];
		for(int i=0; i<c.length; i++) {
			if(maxLen[0][i] != 0)
				mat[i] = 0;
			else {
				mat[i] = Integer.MAX_VALUE;
				for(int j=0; j<i; j++ ) {
					if(maxLen[j+1][i] != 0 && 1 + mat[j] < mat[i]) {
						mat[i] = mat[j] + 1;
					}
				}
			}
		}
		
		return res;
	}
	
	public int minSplitsCollPalindromes(String s) {
		if(s == null)
			return -1;
		
		if(s.isEmpty() || s.length() == 1)
			return 0;
		
		char c[] = s.toCharArray();
		return minSplitsCollPalindromes(c, 0, c.length-1);
	}
	
	private int minSplitsCollPalindromes(char c[], int from, int to) {
		if(isPalindrome(c, from, to))
			return 0;
		
		int min = to - from ;
		for(int i=to; i>from; i--) {
			if(isPalindrome(c, i, to)) {
				int splits = 1 + minSplitsCollPalindromes(c, from, i-1);
				if(splits < min)
					min = splits;
			}
		}
		return min;
	}
	
	public boolean isPalindrome(char c[], int from ,int to) {
		if(from > to)
			return false;
		
		while(from < to) {
			if(c[from] != c[to])
				return false;
			from++;
			to--;
		}
		return true;
	}
	
	
	public boolean isPalindrome(String s) {
		if(s == null)
			return false;
		
		if(s.isEmpty() || s.length() == 1)
			return true;
		
		for(int i=0; i<=s.length()/2; i++) {
			if(s.charAt(i) != s.charAt(s.length()-1-i)) 
				return false;
		}
		return true;
	}
	
	public void threeWayPartition(int [] arr) {
		int mid = 1;
		int i = 0;
		int j = arr.length-1;
		int k = 0;
		while(k < j) {
			if(arr[k] > mid) {
				swap(arr, k , j);
				j--;
			} else if(arr[k] < mid) {
				swap(arr, i, k);
				i++;
			} else {
				k++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	private void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	//http://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/
	public void sortArrBasedOnOther(int arr[], int sort[]) {
		Map<Integer, Integer> mapItemCount = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			if(mapItemCount.containsKey(arr[i])) {
				int count = mapItemCount.get(arr[i]);
				count++;
				mapItemCount.put(arr[i], count);
			} else {
				mapItemCount.put(arr[i], 1);
			}
		}
		int w = 0;
		for(int i=0; i<sort.length; i++) {
			if(mapItemCount.containsKey(sort[i])) {
				int count = mapItemCount.get(sort[i]);
				while(count > 0) {
					arr[w++] = sort[i];
					count--;
				}
				mapItemCount.remove(sort[i]);
			}
		}
		Integer[] remaining = mapItemCount.keySet().toArray(new Integer[mapItemCount.size()]);
		int i=0;
		while(w < arr.length) {
			arr[w++] = remaining[i++];
		}
		System.out.println(Arrays.toString(arr));
	}
	// three way partition
	
	
	
	//−2, 1, −3, 4, −1, 2, 1, −5, 4
	public void findSubarrWithLargestSum(int[] arr) {
		int max_sum_so_far = arr[0];
		int max_sum_ending_here = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			max_sum_ending_here = Math.max(arr[i], max_sum_ending_here + arr[i]);
			max_sum_so_far = Math.max(max_sum_so_far, max_sum_ending_here);
		}
		
		System.out.println("maxSum -->"+max_sum_so_far);
	}

	
	//"8+5+x+3*x = 10-x+4*3*x"
	public void solveLinearEquation(String eq, char var) {
		String[] expressions = eq.split("=");
		double exp1_0 = evaluateExpression(expressions[0], var, 0);
		double exp2_0 = evaluateExpression(expressions[1], var, 0);
		System.out.println("left -->"+exp1_0+ " " + "right --> "+exp2_0);
		double exp1_1 = evaluateExpression(expressions[0], var, 1);
		double exp2_1 = evaluateExpression(expressions[1], var, 1);
		System.out.println("left -->"+exp1_1+ " " + "right --> "+exp2_1);
		double leftCoef = exp1_1 - exp1_0;
		double rightCoef = exp2_1 - exp2_0;
		double coefToRight = rightCoef - leftCoef;
		double valToLeft = exp1_0 - exp2_0;
		System.out.println("RESULT --> "+(valToLeft/coefToRight));		
	}
	
	//int[] sumTo = {1, 3, 2, 5, 4, 10,-1}
	public void subArrWithSumExists(int arr[], int sum) {
		int curr_sum = 0;
		Map<Integer, Integer> mapSumAtIndex = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			curr_sum = curr_sum + arr[i];
			if(curr_sum == sum || arr[i] == sum || mapSumAtIndex.containsKey(sum-arr[i])) {
				System.out.println("Yooo");
			}
			mapSumAtIndex.put(curr_sum, i);
		}
	}
	
	public void maxProductSubarr(int[] arr) {
		int neg_till_here = 1;
		int pos_till_here = 1;
		int max_prod = 1;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > 0) {
				neg_till_here = Math.min(neg_till_here * arr[i], 1);
				pos_till_here = pos_till_here * arr[i];
			} else if(arr[i] < 0) {
				int temp = pos_till_here ;
				pos_till_here = Math.max(neg_till_here * arr[i], 1);
				neg_till_here = temp * arr[i];
			} else {
				neg_till_here = 1;
				pos_till_here = 1;
			}
			
			max_prod =  Math.max(max_prod, Math.max(pos_till_here, neg_till_here));
		}
		
		System.out.println("Max Prod => "+max_prod);
	}
	
	//{ 2, 5, 3, 1, 11, 8, 10, 13, 6 }
	//{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}
	//{2, 6, 3, 4, 1, 2, 9, 5, 8} (2,3,4,5,8)
	public void longestIncrSubseqBest(int[] arr) {
		int tab[] = new int[arr.length];
		int indices[] = new int[arr.length];
		
		tab[0] = arr[0];
		indices[0] = 1;
		int len = 1;
		for(int i=1; i<arr.length; i++) {
			if(arr[i] < tab[0]) {
				tab[0] = arr[i];
				indices[0] = i;
			} else if(arr[i] > tab[len-1]) {
				tab[len] = arr[i];
				indices[len] = i;
				len++;
			} else {
				int val = -1;
				tab[val = smallestValLargerThanElem(tab, 0, len-1, arr[i])] = arr[i];
				indices[val] = i;
			}
		}
		System.out.println(Arrays.toString(tab));
		System.out.println(Arrays.toString(indices));
	}
	
	private int smallestValLargerThanElem(int arr[], int from, int to, int elem) {
		int low = from;
		int high = to;
		while(low <= high) {
			int mid = (int) Math.ceil((double)(low+high)/2);
			if(arr[mid] > elem) {
				while(mid-1 >= 0 && arr[mid-1] > elem)
					mid=mid-1;
				return mid;
			} else {
				low = mid+1;
			}
		}
		return -1;
	}
	
	public double evaluateExpression(String exp, char var, int replaceBy) {
		char c[] = exp.toCharArray();
		double val = 0;
		Stack<Double> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();
		boolean appendNeg = false;
		for(int i=0; i<exp.length(); i++) {
			if(isDigit(c[i])) {
				while(i<c.length && isDigit(c[i])) {
					val = val*10 + (c[i] - '0');
					i++;
				}
				operands.add(appendNeg ? -val : val);
				val = 0;
				appendNeg = false;
				if(i == c.length)
					break;
			}  
			if(c[i] == '-') {
				operators.add('+');
				appendNeg = true;
				continue;
			}
			if(c[i] == '+' || c[i] == '*') {
				if(operators.size() == 0) {
					operators.add(c[i]);
				} else {
					if(hasPrecedence(operators.peek(), c[i])) {
						double result = solveOneSet(operands, operators);
						operands.add(result);
					}
					operators.add(c[i]);
				}
			}
			
			if(c[i] == var) {
				operands.add(appendNeg ? -(double)replaceBy : (double)replaceBy);
			}
		}
		
		while(operands.size() != 1) {
			double result = solveOneSet(operands, operators);
			operands.add(result);
		}
		
		return operands.pop();
	}
	
	private boolean hasPrecedence(char op1, char op2) {
		if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return true;
		else
			return false;
	}
	
	private double solveOneSet(Stack<Double> operands, Stack<Character> operators) {
		double num[] = new double[2];
		num[1] = operands.pop();
		num[0] = operands.pop();
		return calculate(num[0], operators.pop(), num[1]);
	}
	
	private double calculate(double a, char oper, double b) {
		if(oper == '*')
			return a * b;
		
		if(oper == '-')
			return a - b;
		
		if(oper == '+')
			return a + b;
		
		if(oper == '/')
			return a / b;
		
		return Integer.MIN_VALUE;
	}

	private boolean isDigit(char c) {
		return (c >= '0' && c <= '9');
	}
}
