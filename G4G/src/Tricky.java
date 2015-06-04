import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

class Range implements Comparable<Range>{
	int from;
	int to;
	public Range(int from, int to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public String toString() {
		return "("+from+","+to+")";
	}

	@Override
	public int compareTo(Range o) {
		if(to < o.to)
			return -1;
		else if(to > o.to)
			return 1;
		else
			return 0;
	}
}

public class Tricky {

	public static void main(String[] args) throws Exception {
		Tricky tricky = new Tricky();
		int arr[] = {1,2,3,4,6,7,7,8};
		tricky.findMissingNumBw1andN(arr, 8);
		int arr1[] = {1, 3, 2, 5, 4, 9}; // 1 2 3 4 5 9
		System.out.println(tricky.findNumOfSubsetsThatSumTo(arr1, 9));
		int arr2[] = {2,1,1,0,2,1,0,1,2,0};
		tricky.threePartition(arr2, 1);
		System.out.println(Arrays.toString(arr2));
		int[][] grid = {{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		System.out.println(tricky.minStepsToReach(grid, 1, 1));
		String spaceStr = "  Aol  stands for America     Online";
		String[] splits = spaceStr.split(" ");
		System.out.println(Arrays.toString(splits));
		System.out.println(tricky.countWordsInSentenceWithSpaces(spaceStr));
		char removeDups[] = "/remove///// Duplicate/Slashes//top//".toCharArray();
		tricky.removeDuplicateSlashes(removeDups);
		System.out.println(removeDups);
		System.out.println(tricky.lcm(192,368));
		System.out.println(tricky.gcd(192, 368));
		
		Range[] dates = new Range[10];
		Random r = new Random();
		for(int i=0; i<dates.length; i++) {
			int from = r.nextInt(31);
			int to = r.nextInt(31);
			if(from <= to) {
				dates[i] = new Range(from, to);
			} else {
				i--;
			}
		}
		System.out.println(Arrays.toString(dates));
		Range eventDates = tricky.eventDatesSuchThatAllEmployeesAttend(dates);
		System.out.println(eventDates);
		tricky.groupAnagrams("the rat fell in the tar");
		int arr3[] = {1,2,3};
		//tricky.printAllSubsets(arr3);
		List<List<Integer>> list = tricky.subsets(arr3);
		for(int i=0; i<list.size(); i++) {
			System.out.println(Arrays.toString(list.get(i).toArray()));
		}
		Map<Integer,Set<Integer>> exclusionMap = new HashMap<>();
		int uniqElem[] = {1,2,3,4,5};
		Set<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(3);
		exclusionMap.put(1, set1);
		Set<Integer> set2 = new HashSet<>();
		set2.add(2);
		set2.add(4);
		set2.add(5);
		exclusionMap.put(2, set2);
		List<List<Integer>> listOfSets = tricky.printAllValidSubsets(uniqElem, exclusionMap);
		System.out.println("With exclusion rules....");
		for(int i=0; i<listOfSets.size(); i++) {
			System.out.println(Arrays.toString(listOfSets.get(i).toArray()));
		}
		
		tricky.asciiToNum("12345".toCharArray());
		int[] lis = {1,2,3,8,10,5,6,7,12,9,4,0};
		tricky.longestPossibleIncreasingSequence(lis);
		int[] histogram = {6,2,5,4,5,1,6};
		System.out.println(tricky.maxRectangleAreaHistogram(histogram));
		int[] arr4 = {1,2,3,4,5,0};
		tricky.findPairsThatAddToSum(arr4, 4);
		for(int i=0; i<5; i++) {
			System.out.println(tricky.countAndSay(i));
		}
		
		System.out.println("a.b*".matches("a*b*"));
		System.out.println(tricky.patternMatching("a.b*", "a*b*"));
		
		Color[][] carpet = {{Color.White, Color.Black, Color.White, Color.White}, {Color.White, Color.Black, Color.White, Color.White}, 
				{Color.White, Color.White, Color.White, Color.Black}, {Color.White, Color.Black, Color.White, Color.Black}};
		
		tricky.isCarpetBlackOrWhite(carpet);
		System.out.println(tricky.countNumOfSubstring("00100101"));
		System.out.println(tricky.countNumWaysScoreCorrect(13));
		System.out.println(tricky.countNumWaysScoreCorrect(11));
		
		System.out.println(Math.floor(2.73));
		System.out.println(Math.ceil(2.73));
		System.out.println(tricky.sqrt(60));
		System.out.println(tricky.isPrime(63));
		System.out.println(tricky.isPrime(65));
		System.out.println(tricky.isPrime(60));
		System.out.println(tricky.isPrime(61));	
		Integer arr5[] = {2,3,5};
		tricky.printUglyNumEfficient(150, arr5);
		System.out.println(Arrays.toString(tricky.factors(20)));
		System.out.println(tricky.sqrt(25));
		int mat[][] = {{0, 1, 0, 0, 1},{1, 0, 1, 1, 0}, {0, 1, 0, 0, 1}, {1, 1, 1, 0, 0}};
		System.out.println("uniq rows...");
		tricky.printUniqRows(mat);
		tricky.printUniqRowsPerfect(mat);
		tricky.printUglySmart(150, arr5);
		int arr6[]={6, -3, -10, -2, 2};
		tricky.maxProductSubarr(arr6);
		String rev = "i like this program very much";
		tricky.reverseWordsInString(rev);
		tricky.reverseWordsInStringNoSpace(rev);
		
		int[] sumTo = {1, 3, 2, 5,4, 10};
		tricky.findSubsetsSumTo(sumTo, 9);
		System.out.println("with sum ===> "+tricky.subArrWithSumExists(sumTo,9));
		
		int[] set = {9,-1,1,-9};// 
		int maxSum[] = {4, 3, 1, 1, -3};
		tricky.findContiguousSetsThatSumTo(set, 0);
		tricky.findMaxContiguousSum(maxSum);
		tricky.findContiguousSetsThatSumToBetter(sumTo, 9);
		System.out.println("with sum ===> "+tricky.subArrWithSumExists(maxSum,0));
		
		Stack<Integer> tower1 = new Stack<>();
		Stack<Integer> tower2 = new Stack<>();
		Stack<Integer> tower3 = new Stack<>();
		
		for(int i=7; i>=1; i--)
			tower1.add(i);
//		tricky.towerOfHanoi(tower1, tower2, tower3);
//		System.out.println(Arrays.toString(tower3.toArray()));
		tricky.generatingNBitGrayCodes(3);
		tricky.towerOfHanoiIter(tower1, tower2, tower3);
		System.out.println(Arrays.toString(tower3.toArray()));
		
		int hist[] = {6,2,5,4,5,2,6};//{5,4,3,2,1};//{1,2,3,4,5};//
		
		tricky.largestAreaHistogram(hist);
	}
	
	// find biggest interval that contains current bar bar[i]
	public void largestAreaHistogram(int hist[] ) {
		Stack<Integer> left = new Stack<>();
		Stack<Integer> right = new Stack<>();
		int[] width = new int[hist.length];
		Arrays.fill(width, 1);
		for(int i=0; i<hist.length; i++) {
			while(!left.isEmpty() && hist[i] <= hist[left.peek()])
				left.pop();
			
			if(left.isEmpty()) {
				width[i]+=i;
			} else {
				width[i] += i - left.peek() -1;
			}
			left.push(i);
		}
		
		for(int i=hist.length-1; i>=0; i--) {
			while(!right.isEmpty() && hist[i] <= hist[right.peek()])
				right.pop();
			
			if(right.isEmpty()) {
				width[i]+= hist.length-i-1;
			} else {
				width[i]+= right.peek() - i-1;
			}
			right.push(i);
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<width.length; i++) {
			max = Math.max(max, hist[i] * width[i]);
		}
		
		System.out.println("Max area => "+max);
	}
	
	public void towerOfHanoiIter(Stack<Integer> s1, Stack<Integer> s2, Stack<Integer> s3) {
		Map<Integer, Stack<Integer>> mapDiskTower = new HashMap<>();
		int n = s1.size();
		mapDiskTower.put(1, s1);
		
		
		// alternate move between smallest and non smallest piece
		for(int i=1; i< (1 << n); i++) {
			if(i % 2 == 0) {
				if(s1.size() != 0 && s1 != mapDiskTower.get(1)) {
					if(s2.size() == 0 || (s1.peek() < s2.peek())) {
						s2.push(s1.pop());
						continue;
					} else if(s3.size() == 0 || (s1.peek() < s3.peek())) {
						s3.push(s1.pop());
						continue;
					}
				} 
				if(s2.size() != 0 && s2 != mapDiskTower.get(1)) {
					if(s1.size() == 0 || (s2.peek() < s1.peek())) {
						s1.push(s2.pop());
						continue;
					} else if(s3.size() == 0 || (s2.peek() < s3.peek())) {
						s3.push(s2.pop());
						continue;
					}
				}
				if(s3.size() != 0 && s3 != mapDiskTower.get(1)) {
					if(s1.size() == 0 || (s3.peek() < s1.peek())) {
						s1.push(s3.pop());
						continue;
					} else if(s2.size() == 0 || (s3.peek() < s2.peek())) {
						s2.push(s3.pop());
						continue;
					}
				}
			} else { 
				// move smallest piece counter clockwise since we need to move to s3
				Stack<Integer> stack = mapDiskTower.get(1);
				Stack<Integer> countClockwiseStack = null;
				if(n % 2 != 0)
					countClockwiseStack = stack.equals(s1) ? s3 : stack.equals(s2) ? s1 : stack.equals(s3) ? s2 : null;
				else 
					countClockwiseStack = stack.equals(s1) ? s2 : stack.equals(s2) ? s3 : stack.equals(s3) ? s1 : null;
				countClockwiseStack.push(stack.pop());
				mapDiskTower.put(1, countClockwiseStack);
			}
		}
	}
	
	public void generatingNBitGrayCodes(int n) {
		System.out.println("generatingNBitGrayCodes .....");
		for(int i=0; i< (1 << n); i++) {
			System.out.print(((i >>> 1) ^ i)+", ");
		}
	}
	
	
	public void towerOfHanoi(Stack<Integer> s1, Stack<Integer> s2, Stack<Integer> s3) {
		int n = s1.size();
		move(n, s1, s2, s3);
	}
	
	private void move(int n,Stack<Integer> s1, Stack<Integer> s2, Stack<Integer> s3 ) {
		if(n > 0) {
			move(n-1, s1, s3, s2);
			s3.push(s1.pop());
			move(n-1, s2, s1, s3);
		}
	}
	
	  public Boolean subArrWithSumExists(int arr[], int targetSum)
	    {
	        // Creates an empty hashMap hM
	        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
	         
	        // Initialize sum of elements
	        int sum = 0;        
	         
	        // Traverse through the given array
	        for (int i = 0; i < arr.length; i++)
	        {   
	            // Add current element to sum
	            sum += arr[i];
	             
	            // Return true in following cases
	            // a) Current element is 0
	            // b) sum of elements from 0 to i is 0
	            // c) sum is already present in hash map
	            if (arr[i] == targetSum || sum == targetSum || hM.get(sum) != null)                            
	               return true;
	             
	            // Add sum to hash map
	            hM.put(sum, i);
	        }    
	         
	        // We reach here only when there is no subarray with 0 sum
	        return false;
	    } 
	
	public void findMaxContiguousSum(int arr[]) {
		int max_sum = 0;
		int max_ending_here = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(max_ending_here + arr[i] > 0) {
				max_ending_here = max_ending_here + arr[i];
			} else {
				max_ending_here = 0;
			}
			
			if(max_ending_here > max_sum)
				max_sum = max_ending_here;
		}
		
		System.out.println("maxSum --->"+max_sum);
	}
	
	public void findContiguousSetsThatSumToBetter(int arr[], int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		int currSum = 0;
		List<Range> list = new LinkedList<>();
		for(int i=0; i<arr.length; i++) {
			currSum = currSum + arr[i];
			
			if(currSum == sum)
				list.add(new Range(0, i));
			
			if(arr[i] == sum)
				list.add(new Range(i, i));
			
			if(currSum > sum) {
				if(map.containsKey(currSum-sum)) {
					int at = map.get(currSum-sum);
					list.add(new Range(at+1, i));
				}
			}
			
			map.put(currSum, i);
		}
		
		System.out.println("Kick Ass ---->"+Arrays.toString(list.toArray()));
	}
	
	// 1 4 6 11 15 24 34 33	
	// contains neg numbers //{9,-1,1,-9} //{4, -1, 2, -2, -1, -3} //{1, 3, 2, 5, 4, 9, 10,-1}
	public void findContiguousSetsThatSumTo(int arr[], int sum) {
		
		List<Range> list = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			int curr_sum = arr[i];
			if(curr_sum == sum) {
				list.add(new Range(i, i));
			}
			for(int j=i+1; j<arr.length; j++) {
				curr_sum = curr_sum + arr[j];
				if(curr_sum == sum) {
					list.add(new Range(i, j));
				}
			}
		}
		
		
		System.out.println("Range --->" +Arrays.toString(list.toArray()));
	}
	
	public void findSubsetsSumTo(int arr[], int sum) {
		
		List<List<Integer>> list = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			List<Integer> l = new ArrayList<>();
			boolean matched = findSubsetsSumTo(arr, 0, i, sum, l);
			if(matched)
			list.add(l);
		}
		System.out.println("---- subsets that sum to-----");
		System.out.println(Arrays.toString(list.toArray()));
	}
	
	private boolean findSubsetsSumTo(int arr[], int currSum, int index, int sum, List<Integer> list) {
		if(index >= arr.length)
			return false;
		
		currSum = currSum + arr[index];
		list.add(arr[index]);
		
		if(currSum == sum) {
			return true;
		}
		
		for(int i=index+1; i<arr.length; i++) {
			boolean matched = findSubsetsSumTo(arr, currSum, i, sum, list);
			if(matched)
				return true;
		}
		list.remove(list.size()-1);
		return false;
	}
	
	public void reverseWordsInStringNoSpace(String s) {
		char arr[] = s.toCharArray();
		for(int i=0; i<=arr.length/2; i++) {
			char temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		System.out.println(Arrays.toString(arr));
		int start = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == ' ') {
				revPart(arr, start, i-1);
				start = i+1;
			}
		}
		
		System.out.println("rev ---->"+new String(arr));
		
	}
	
	private void revPart(char[] c, int start, int end) {
		while(start != end && start < end) {
			char temp = c[start];
			c[start] = c[end];
			c[end] = temp;
			start++;
			end--;
		}
	}
	
	public void reverseWordsInString(String s) {
		String arr[] = s.split(" ");
		Stack<String> stack = new Stack<String>();
		for(int i=0; i<arr.length; i++){
			stack.push(arr[i]);
		}
		StringBuilder sb = new StringBuilder();
		while(stack.size() != 0) {
			sb.append(stack.pop());
			if(stack.size() != 0)
				sb.append(" ");
		}
		System.out.println(sb);
	}
	
	// {6, -3, -10, 0, 2} // {-1, -3, -10, 0, 60} // {-6, -3 , -10}
	public void maxProductSubarr(int[] arr) {
		
		int max_pos_prod = 1;
		int min_neg_prod = 1;
		int max_prod = 1;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > 0) {
				max_pos_prod = max_pos_prod*arr[i];
				min_neg_prod = Math.min(min_neg_prod*arr[i], 1);
			} else if(arr[i] < 0) {
				int temp = max_pos_prod;
				max_pos_prod = Math.max(min_neg_prod*arr[i], 1);
				min_neg_prod = temp * arr[i];
			} else {
				min_neg_prod=1;
				max_pos_prod=1;
			}
			
			max_prod = Math.max(max_prod, Math.max(max_pos_prod, min_neg_prod));
		}
		System.out.println(max_prod);
	}
	
	public void printUniqRowsPerfect(int[][] mat) {
		String s = "";
		Trie trie = new Trie('\0');
		
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[i].length; j++) {
				s = s + mat[i][j];
			}
			trie.add(s);
			s = "";
		}
		
		trie.print();
		
	}
	
	// if num of cols is greater than 32... integer overflow 
	public void printUniqRows(int[][] mat) {
		Map<Integer,Integer> sumRow = new HashMap<>();
		for(int i=0; i<mat.length; i++) {
			int sum = 0;
			for(int j=0; j<mat[i].length; j++) {
				sum = sum + (int) (mat[i][j] *(Math.pow(2, j)));
			}
			sumRow.put(sum, i);
		}
		
		Integer[] keys = sumRow.keySet().toArray(new Integer[sumRow.size()]);
		for(int i=0; i<keys.length; i++) {
			System.out.println(sumRow.get(keys[i]));
		}
	}
	
	public void printUglySmart(int N, Integer arr[]) {
		int ugly[] = new int[N];
		ugly[0] = 1;
		int i2 = 0, i3 = 0, i5 = 0;
		int next_2 = 2 * ugly[i2];
		int next_3 = 3 * ugly[i3];
		int next_5 = 5 * ugly[i5];
		
		for(int i=1; i<N; i++) {
			int min = Math.min(next_2, Math.min(next_3, next_5));
			ugly[i] = min;
			if(min == next_2) {
				i2++;
				next_2 = 2 * ugly[i2];
			}
			
			if(min == next_3) {
				i3++;
				next_3 = 3 * ugly[i3];
			}
			
			if(min == next_5) {
				i5++;
				next_5 = 5 * ugly[i5];
			}
		}
		
		System.out.println(Arrays.toString(ugly));
	}
	
	private int minIndex(int arr[]) {
		int min = 0;
		for(int i=1; i<arr.length; i++) {
			if(arr[i] < arr[min]) {
				min = i;
			}
		}
		return min;
	}
 	
	
	public void printUglyNumEfficient(int N, Integer arr[]) {
		if(N<=0)
			return;
		
		int i = 1;
		int count = 1;
		
		while(count <= N) {
			if(isUgly(i)) {
				System.out.print(count+"-"+i+" ");
				count++;
			}
			
			i++;
		}
		System.out.println();
	}
	
	private boolean isUgly(int n) {
		n = divide(n, 2);
		n = divide(n, 3);
		n = divide(n, 5);
		return n == 1 ? true : false;
	}
	
	private int divide(int a, int b) {
		while(a % b == 0)
			a = a/b;
		return a;
	}
	
	public Integer[] factors(int x) {
		
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=(x/2); i++) {
			if(x%i == 0) {
				list.add(i);
			}
		}
		list.add(x);
		return list.toArray(new Integer[list.size()]);
	}
	
	// ugly numbers are those who only prime factors are 2,3,5 (35 is not a ugly num)
	// bad algorithm... exponential time.. takes mins to print 150 numbers..
	public void printUglyNum(int N, Integer arr[]) {
		if(N<=0)
			return;
		
		Set<Integer> primeFactorsAllowed = new HashSet<Integer>(Arrays.asList(arr));
		int count = 1;
		int num = 1;
		while(count <= N) {
			if(num == 14)
				System.out.print("");
			Integer[] factors = factors(num);
			boolean flag = false;
			for(int i=0; i<factors.length; i++) {
				if(isPrime(factors[i])) {
					if(!primeFactorsAllowed.contains(factors[i])) {
						flag = true;
						break;
					}
				}
			}
			if(!flag) {
				System.out.print(count+"-"+num+" ");
				count++;
			}
			num++;
		}
		
	
		System.out.println();
	}
	
	public boolean isPrime(int x) {
		if(x <= 1)
			return false;
		
		if(x % 2 == 0 || x % 3 == 0)
			return false;
		
		int sqrt = (int) Math.ceil(sqrt(x));
		for(int i=5; i<=sqrt; i=i+6) {
			if(x % i == 0 || x % (i+2) == 0)
				return false;
		}
		
		return true;
	}
	
	public double sqrt(double x) {
		if(x == 0 || x == 1)
			return x;
		
		double low = 0;
		double high = x;
		
		double mid = (low+high)/2;
		
		while(Math.abs(mid*mid -x) > 0.00001) {
			if(mid*mid < x)
				low = mid;
			else if(mid*mid > x)
				high = mid;
			
			mid = (low+high)/2;
		}
		
		return mid;
	}
	
	
	// 13
	// 3 5 5
	// 3 10
	
	// Num of ways in this case are not unique (3,5,5) , (5,5,3), (5,3,5) are all taken....
	public int countNumWaysScore(int score) {
		if(score < 0)
			return 0;
		
		if(score == 0)
			return 1;
		
		return countNumWaysScore(score-3) + countNumWaysScore(score-5) + countNumWaysScore(score-10);
	}
	
	public int countNumWaysScoreCorrect(int score) {
		if(score <= 0)
			return 0;
		
		
		int table[] = new int[score+1];
		table[0] = 1;
		
		for(int i=3; i<=score; i++) 
			table[i] = table[i-3]+table[i];
		
		for(int i=5; i<=score; i++)
			table[i] = table[i-5]+table[i];
		
		for(int i=10; i<=score; i++)
			table[i] = table[i-10] + table[i];
		
		return table[score];
	}
	
	// that start and end with 1
	// 001010011
	public int countNumOfSubstring(String s) {
		int[] count = new int[1];
		countNumOfOnes(s.toCharArray(), 0, s.length(), count);
		return count[0];
	}
	
	
	public int countNumOfOnes(char[] s, int start, int end, int count[]) {
		
		while(start < s.length) {
			if(s[start] == '1')
				break;
			else
				start ++;
		}
		
		if(start == s.length)
			return 0;
		
		int n = countNumOfOnes(s, start+1, end, count);
		count[0] = count[0] + n;
		return 1 + n;
		
	}
	
	enum Color {
		White,
		Black;
	}
	
	public void isCarpetBlackOrWhite(Color[][] n) {
		// for each of the colors, 
			// for each of the unvisited cells,
				// do a dfs, get the count
		
		// return max of counts to be the color of the carpet
		Color[] colors = Color.values();
		boolean[][] visited = new boolean[n.length][n.length];
		int count[] = new int[colors.length];
		
		for(int i=0; i<n.length; i++) {
			for(int j=0; j<n.length; j++) {
				if(!visited[i][j]) {
					count[n[i][j].ordinal()]++;
					isCarpetBlackOrWhite(n, visited, i, j, colors[n[i][j].ordinal()]);
				}
			}
		}
		System.out.println(Arrays.toString(count));
		
	}
	
	public void isCarpetBlackOrWhite(Color[][] n, boolean[][] visited, int currRow, int currCol, Color color) {
		if(currRow < 0 || currRow >= n.length || currCol < 0 || currCol >= n.length)
			return;
		
		if(n[currRow][currCol].equals(color) && !visited[currRow][currCol]) {
			visited[currRow][currCol] = true;
			isCarpetBlackOrWhite(n, visited, currRow+1, currCol, color);
			isCarpetBlackOrWhite(n, visited, currRow-1, currCol, color);
			isCarpetBlackOrWhite(n, visited, currRow, currCol+1, color);
			isCarpetBlackOrWhite(n, visited, currRow, currCol-1, color);
			isCarpetBlackOrWhite(n, visited, currRow+1, currCol+1, color);
			isCarpetBlackOrWhite(n, visited, currRow-1, currCol-1, color);
			
		}
	}
	
	// ********************* INCORRECT ALGO **********************//
//	public void isCarpetBlackOrWhite(Color[][] n) {
//		boolean[][] visited = new boolean[n.length][n.length];
//		int[] countSpots = new int[2];
//		isCarpetBlackOrWhite(n, visited, 0, 0, countSpots , null);
//		System.out.println(Arrays.toString(countSpots));
//	}
//	
//	public void isCarpetBlackOrWhite(Color[][] n, boolean[][] visited, int currRow, int currCol, int[] countSpots, Color prevColor) {
//		
//		if(currRow < 0 || currRow >= n.length || currCol < 0 || currCol >= n.length)
//			return;
//		
//		if(!visited[currRow][currCol]) {
//			visited[currRow][currCol] = true;
//			
//			if(prevColor == null) {
//				prevColor = n[currRow][currCol];
//				countSpots[n[currRow][currCol].ordinal()]++;
//			} else if(prevColor != n[currRow][currCol]) {
//				countSpots[n[currRow][currCol].ordinal()]++;
//				prevColor = n[currRow][currCol];
//			}
//			
//			isCarpetBlackOrWhite(n, visited, currRow, currCol+1, countSpots, prevColor);
//			isCarpetBlackOrWhite(n, visited, currRow+1, currCol, countSpots, prevColor);
//			isCarpetBlackOrWhite(n, visited, currRow+1, currCol+1, countSpots, prevColor);
//			isCarpetBlackOrWhite(n, visited, currRow-1, currCol-1, countSpots, prevColor);
//		}
//		
//	}
	
	// abc
	// ab*
	
	// abbb
	// ab*
	public boolean patternMatching1(String str, String pattern) {
		
		return patternMatching(str, pattern);
		
	}
	
	public boolean patternMatching(String str, String pattern) {
		
		if(str == null ||  pattern == null)
			return false;
		
		if(str.isEmpty() && pattern.isEmpty())
			return true;
		
		if(str.isEmpty() || pattern.isEmpty())
			return false;
		
		
		// start from end
		int l1 = str.length();
		int l2 = pattern.length();
		
		if(str.charAt(l1-1) == pattern.charAt(l2-1)) 
			return patternMatching(str.substring(0, l1-1), pattern.substring(0,l2-1));
		else { 
			if(pattern.charAt(l2-1) == '*') {
			
				char c = pattern.charAt(l2-2);
				while(l1>0 && str.charAt(l1-1) == c)
					l1--;
				
				if(l1 == 0)
					return true;
				
				return patternMatching(str.substring(0, l1), pattern.substring(0, l2-2));
				
			} else if(pattern.charAt(l1-1) == '.') {
				return patternMatching(str.substring(0, l1-1), pattern.substring(0,l2-1));
			} else {
				return false;
			}
		}
		
		
	}
	// 1 11 21 1211
	public int countAndSay(int n) {
		if(n <= 0)
			return 1;
		
		return count(countAndSay(n-1));
	}
	
	public int count(int str) {
		int n = str;
		int c = 0;
		String s = "";
		int prev = -1;
		while(n > 0) {
			int curr = n % 10;
			if(prev != curr) {
				if(prev != -1) {
					s = c+""+prev+s;
					c = 0;
				}
			} 
			c++;
			prev = curr;
			n = n/10;
		}
		if(c != 0) {
			s = c+""+prev+s;
			c=0;
		}
		if(s.isEmpty())
			return 0;
		
		return Integer.parseInt(s);
	}
	
	
	public void findPairsThatAddToSum(int[] arr, int sum) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(arr[i])) {
				int count = map.get(arr[i]);
				count++;
				map.put(arr[i], count);
			} else {
				map.put(arr[i], 1);
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(sum-arr[i])) {
				int count = map.get(sum-arr[i]);
				count--;
				if(count >= 0) {
					map.put(arr[i], count);
					System.out.println("("+arr[i]+","+(sum-arr[i])+")");
				}
			}
		}
	}
	
	public int maxRectangleAreaHistogram(int arr[]) {
		return maxRectangleAreaHistogram(arr, 0, arr.length-1);
	}
	
	private int maxRectangleAreaHistogram(int[] arr, int start, int end) {
		if(start > end)
			return -1;
		
		if(start == end)
			return arr[start]*1;
		
		int mid = (start+end)/2;
		int leftArea = maxRectangleAreaHistogram(arr, start, mid-1);
		int rightArea = maxRectangleAreaHistogram(arr,mid+1, end);
		
		int to_start = mid-1;
		int to_end = mid +1;
		int count = 1;
		
		while(to_start >= start && arr[mid] <= arr[to_start]) {
			count++;
			to_start--;
		}
		
		while(to_end <= end && arr[mid] <= arr[to_end]) {
			count++;
			to_end++;
		}
		
		
		return Math.max(leftArea, Math.max(rightArea, arr[mid] * count));
	}

	// 16 20 15 25
	public void longestPossibleIncreasingSequence(int arr[]) {
		int len[] = new int[arr.length];
		int seq[] = new int[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			len[i] = 1;
			seq[i] = i;
			int j=0;
			while(j<i) {
				if( arr[j] < arr[i] && len[j]+1 > len[i]) {
					len[i] = len[j] + 1;
					seq[i] = j;
				 }
				j++;
			}
		}
		
		System.out.println("Len ->"+Arrays.toString(len));
		System.out.println("Seq ->"+Arrays.toString(seq));
	}
	
	public void asciiToNum(char c[]) {
		int num = 0;
		
		for(int i=0; i<c.length; i++) {
			num = num*10 + (c[i]-'0');
		}
		
		System.out.println(num);
	}
	
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		ans.add(new ArrayList<Integer>());
		for(int i=0; i<S.length; i++) {
			int size = ans.size();
			for(int j=0; j<size; j++) {
				List<Integer> list = new ArrayList<>(ans.get(j));
				list.add(S[i]);
				ans.add(list);
			}
		}
		return ans;

	}
	
	// exclusion rules
	public List<List<Integer>> printAllValidSubsets(int uniqElem[], Map<Integer, Set<Integer>> exclusionMap) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		for(int i=0; i<uniqElem.length; i++) {
			int size = res.size();
			for(int j=0; j<size; j++) {
				List<Integer> list = new ArrayList<Integer>(res.get(j));
				if(list.size() == 0) {
					list.add(uniqElem[i]);
					res.add(list);
				} else {
					Iterator<Integer> iterator = list.iterator();
					boolean excluded = false;
					while(iterator.hasNext()) {
						int element = iterator.next();
						if (exclusionMap.containsKey(element) && exclusionMap.get(element).contains(uniqElem[i])) {
							excluded = true;
							break;
						}
					}
					if(!excluded) {
						list.add(uniqElem[i]);
						res.add(list);
					}
				}
			}
		}
		return res;
	}
	
	
	
	public void groupAnagrams(String s) {
		String[] arr = s.split(" ");
		Map<String, List<String>> map = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			char c[] = arr[i].toCharArray();
			Arrays.sort(c);
			String sortedStr = new String(c).toLowerCase();
			if(map.containsKey(sortedStr)) {
				List<String> list = map.get(sortedStr);
				list.add(arr[i]);
			} else {
				List<String> list = new LinkedList<String>();
				list.add(arr[i]);
				map.put(sortedStr, list);
			}
		}
		
		String[] str = map.keySet().toArray(new String[map.size()]);
		for(int i=0; i<str.length; i++) {
			System.out.println(Arrays.toString(map.get(str[i]).toArray()));
		}
		
	}
	
	// Reversi Game
	public void othelloValidation(char mat[][] , int x, int y, char c) {
		
	}
	
	// 16 17 19 21 22 26 28 30
	public Range eventDatesSuchThatAllEmployeesAttend(Range[] dates) {
		if(dates == null)
			return null;

		Arrays.sort(dates); // should use counting sort for linear time
		System.out.println(Arrays.toString(dates));
		int last1 = dates[0].to;
		int last2 = dates[0].to-1;
		int minDays = 2;
		for(int i=1; i<dates.length; i++) {
			if(dates[i].from > last1) {
				last1 = dates[i].to;
				last2 = dates[i].to-1;
				minDays += 2;
			} else if(dates[i].from > last2) {
				last2 = last1;
				last1 = dates[i].to;
				minDays +=1;
			}
		}
		System.out.println("min days => "+minDays);
		return new Range(last2, last1);
		
	}
	
	public int lcm(int a, int b) {
		return a*b /gcd(a,b);
	}
	
	public int gcd(int a, int b) {
		if(a == 0)
			return b;
		
		if(b == 0)
			return a;
		
		int r = a % b;
		return gcd(b,r);
	}
	
	public void removeDuplicateSlashes(char[] c) {
		int w = 0;
		char prev_char = c[0];
		for(int i=1; i <c.length; i++) {
			if(prev_char == '/' && c[i] == '/') {
				
			} else {
				c[w++] = prev_char;
			}
			prev_char = c[i];
		}
		if(prev_char == '/')
			c[w++] = '/';
		
		for(;w <c.length;)
			c[w++] = '\0';
	}
	
	public int countWordsInSentenceWithSpaces(String spaceStr) {
		int count = 0;
		char c[] = spaceStr.toCharArray();
		char prev_char = c[0];
		if(prev_char != ' ')
			count = 1;
		for(int i=1; i<c.length; i++) {
			if(prev_char == ' ' && c[i] != ' ') {
				count++;
			}
			prev_char = c[i];
		}
		return count;
	}
	
	public int minStepsToReach(int[][] grid, int m, int n) throws Exception {
		int row = 1;
		int col = 1;
		
		int min =  minStepsToReach(grid, row, col, m, n, 0);
		if(min == -1)
			throw new Exception("Route not found");
		
		return min;
	}
	
	public int minStepsToReach(int[][] grid, int currRow, int currCol, int m, int n, int numOfSteps) throws Exception {
		
		if(currRow == m && currCol == n)
			return numOfSteps;
		
		if(currRow >= grid.length || currCol >= grid[0].length) 
			return -1;
		
		int right = minStepsToReach(grid, currRow, currCol+1, m, n, numOfSteps+1);
		int down = minStepsToReach(grid, currRow+1, currCol, m, n, numOfSteps+1);
		
		if(right == -1)
			return down;
		
		if(down == -1)
			return right;
		
		return Math.min(right, down);
	}
	
	public void threePartition(int[] arr, int mid) {
		int j =0;
		int i =0;
		int n = arr.length-1;
		
		while(i <= n) {
			if(arr[i] < mid) {
				swap(arr, i, j);
				i++;
				j++;
			} else if(arr[i] > mid) {
				swap(arr, i, n);
				n--;
			} else {
				i++;
			}
		}
	}
	
	private void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public int findNumOfSubsetsThatSumTo(int arr[], int sum) {
		return findNumOfSubsetsThatSumTo(arr, 0, 0, sum, new ArrayList<Integer>());
	}
	
	private int findNumOfSubsetsThatSumTo(int arr[], int index, int curr_sum, int sum, List<Integer> list) { 
		if(curr_sum > sum)
			return 0;
		
		if(curr_sum == sum) {
			System.out.println(Arrays.toString(list.toArray()));
			return 1;
		}
		
		int numOfWays = 0;
		for(int i=index; i<arr.length; i++) {
			list.add(arr[i]);
			numOfWays += findNumOfSubsetsThatSumTo(arr, i+1, curr_sum+arr[i], sum, list);
			list.remove(list.size()-1);
		}
		
		return numOfWays;
	}
	
	public void findMissingNumBw1andN(int arr[], int N) {
		int sum = 0;
		double prod = 1;
		for(int i:arr) {
			sum = sum + i;
			prod = prod * i;
		}
		
		int sumToN = N*(N+1)/2;
		System.out.println(sum);
		System.out.println(sumToN);
		
		double prodToN = fact(N);
		System.out.println(prod);
		System.out.println(prodToN);
		
		double dup = (sumToN-sum)/((prodToN/prod) -1);
		double missing = ((sumToN - sum) *(prodToN / prod) )/ ((prodToN/prod) -1);
		System.out.println(dup);
		System.out.println(missing);
	}
	
	public int fact(int n) {
		if(n <= 0)
			return 1;
		
		return n*fact(n-1);
	}

}

class QueueUsingStacks<T> {
	
	Stack<T> stack1;
	Stack<T> stack2;
	
	
}