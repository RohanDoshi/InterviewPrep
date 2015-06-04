
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Stack;
import java.util.Vector;


public class TrickyMore {

	public static void main(String[] args) {
		TrickyMore trickyMore = new TrickyMore();
		
//		long l1 = System.currentTimeMillis();
//		List<List<Integer>> list = trickyMore.printWaysToClimbNStairsWithoutDP(30);
//		System.out.println(list.size());
//		long l2 = System.currentTimeMillis();
//		System.out.println("time -->"+(l2-l1));
////		list = trickyMore.printWaysToClimbNStairs(2);
////		System.out.println(Arrays.toString(list.toArray()));
////		list = trickyMore.printWaysToClimbNStairs(3);
////		System.out.println(Arrays.toString(list.toArray()));
//		l1 = System.currentTimeMillis();
//		list = trickyMore.printWaysToClimbNStairs(30);
//		System.out.println(list.size());
//		l2 = System.currentTimeMillis();
//		System.out.println("time -->"+(l2-l1));
//		l1 = System.currentTimeMillis();
//		List<String> res = trickyMore.climbNStairsDP(30);
//		System.out.println(res.size());
//		l2 = System.currentTimeMillis();
//		System.out.println("time -->"+(l2-l1));
//		int arr[] = {-5, 25, -20, 3, -2, -1};
//		List<Range> result = trickyMore.findSubsetsThatSumToZero(arr, 0);
//		System.out.println(Arrays.toString(result.toArray()));
//		trickyMore.printAllParenthesisOpenClose(3);
//		int arr1[] = {1,2,3,4};
//		trickyMore.printAllSubsets(arr1);
//		System.out.println();
//		trickyMore.printAllSubsets2(arr1);
//		int[] cards = new int[52];
//		for(int i=1; i<=52; i++) {
//			cards[i-1] = i;
//		}
//		System.out.println("shuffle cards....");
//		trickyMore.shuffleCards(cards);
//		System.out.println(Arrays.toString(cards));
//		System.out.println(-2>>>1);
//		System.out.println(-2>>1);
		Bits bits = new Bits();
		System.out.println(2+"---"+bits.bitString(-2));
		System.out.println((-2 >> 1) + "---"+bits.bitString(-2 >> 1));
		System.out.println((-2 >>> 1) +"---"+bits.bitString(-2 >>> 1));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(trickyMore.power(2, 4));
		System.out.println(Math.pow(0, 2));
		System.out.println(trickyMore.powerBetter(2, 4));
		System.out.println(9^8);
		System.out.println(9&8);
		System.out.println(2<<1);
		System.out.println(trickyMore.addTwoNumbersWithoutUsingPlus(7, 7));
		System.out.println(7<<1);
		
		Heap<Integer> heap = new Heap<>();
		heap.add(0);
		heap.add(1);
		heap.add(4);
		heap.add(3);
		heap.add(2);
		heap.add(5);
		
		heap.print();
		
		System.out.println("--- heap poll----");
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println("--- heap print----");
		heap.print();
		System.out.println("--- heap poll----");
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println("--- heap print----");
		heap.print();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.add(0);
		queue.add(1);
		queue.add(4);
		queue.add(3);
		queue.add(2);
		queue.add(5);
		System.out.println(Arrays.toString(queue.toArray()));
		System.out.println("--- queue poll----");
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println("--- queue print----");
		System.out.println(Arrays.toString(queue.toArray()));
		System.out.println("--- queue poll----");
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println("--- queue print----");
		System.out.println(Arrays.toString(queue.toArray()));
		System.out.println(2147483647+" -- "+Integer.MAX_VALUE);
		int[] partition = {6,5,1,3,7,0,2,4};
		//System.out.println(trickyMore.partition(partition, 0, partition.length-1));
		System.out.println(Arrays.toString(partition));
		System.out.println(trickyMore.findKthSmallest(partition, 8));
		System.out.println(trickyMore.maxNumOfA(7));
		String lwr = "abccddelfjc";
		System.out.println(trickyMore.longestSubstringWithoutRepeatingChars(lwr));
		
		int ar1[] = {2, 3, 7, 10, 12, 15, 30, 34}, ar2[] = {1, 5, 7, 8, 10, 15, 16, 19};
		System.out.println(trickyMore.maxSumPath(ar1, ar2));
		trickyMore.excelColumnName(705);
		System.out.println(trickyMore.findNextGrNumSameDigits("534976"));
		String test[] = "1234=12".split("=");
		System.out.println(Arrays.toString(test));
		trickyMore.expressionEvaluation("10+2*6");
		trickyMore.expressionEvaluation("10*2+6");
		trickyMore.expressionEvaluation("100*(2+12)/14");
		
		int[] flipSort = {18, 40, 35, 12, 30, 35, 20, 6, 90, 80};
		int[] flipSort1 = {1,4,0,6,7};
		trickyMore.pancakeSort(flipSort);
		System.out.println(Arrays.toString(flipSort));
		trickyMore.pancakeSort(flipSort1);
		System.out.println(Arrays.toString(flipSort1));
	}
	
	// assume O(1) on a hypothetical m/c
	private void flip(int[] arr, int index) {
		int j = arr.length -1;
		for(int i=index; i < arr.length && i<=(index + (arr.length-1 - index)/2); i++) {
			swap(arr, i, j);
			j--;
		}
	}
	
	//{1,4,0,6,7}
	//{18, 40, 35, 12, 30, 35, 20, 6, 90, 80}
	public void pancakeSort(int[] arr) {
		
		for(int i=arr.length-2; i>=0; i--) {
			int index = greatestElementSmallerThanI(arr, i);
			if(index != -1) {
				flip(arr, index+1);
				flip(arr, i+1);
				flip(arr, i);
				flip(arr, index);
			}
		}
	}
	// 4 (0 6 7)
	private int greatestElementSmallerThanI(int[] arr, int index) {
		int element = arr[index];
		int from = index + 1;
		int low = from;
		int high = arr.length-1;
		while(low <= high) {
			int mid = (int) Math.ceil((double)(low + high)/2);
			if(arr[mid] > element) {
				high = mid-1;
			} else if(arr[mid] < element){
				while(mid +1 <= high && arr[mid +1] < element)
					mid++;
				return mid;
			}
		}
		return -1;
	}
	
	//100 * ( 2 + 12 ) / 14
	// 10 + 2 * 6
	// 10 * 2 + 6
	public void expressionEvaluation(String s) {
		Stack<Double> values=  new Stack<>();
		Stack<Character> operators = new Stack<>();
		double val = 0;
		char c = '\0';
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				while(i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
					c = s.charAt(i);
					val = val*10 + (c-'0');
					i++;
				}
				values.add(val);
				val = 0;
			}
			if(i == s.length())
				break;
			
			c = s.charAt(i);
			if(c == '*' || c == '+' || c == '/' || c == '-') {
				if(operators.size() == 0) {
					operators.add(c);
					continue;
				}
				if(hasHigherPrecedence(operators.peek(), c)) { // does c have a higher precedence than operators.peek ?
					operators.add(c);
				} else {
					char oper = operators.pop();
					double[] operands = new double[2];
					operands[0] = values.pop();
					operands[1] = values.pop();
					double res = solveOperatorOperands(oper, operands);
					values.add(res);
					operators.add(c);
				}
				
			} else if(c == '(') {
				operators.add(c);
			} else if(c == ')') {
				char oper = '\0';
				while((oper = operators.pop())!= '(') {
					double[] operands = new double[2];
					operands[0] = values.pop();
					operands[1] = values.pop();
					double res = solveOperatorOperands(oper, operands);
					values.add(res);
				}
			}
		}
		
		while(values.size() != 1) {
			char oper = operators.pop();
			double[] operands = new double[2];
			operands[0] = values.pop();
			operands[1] = values.pop();
			double res = solveOperatorOperands(oper, operands);
			values.add(res);
		}
		
		System.out.println("Res = "+values.pop());
	}
	
	// * and / have higher precendence than + -
	private boolean hasHigherPrecedence(char op1, char op2) {
		if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}
	
	public double solveOperatorOperands(char operator, double[] operands) {
		if(operator == '+') {
			return operands[0] + operands[1];
		} else if(operator == '*') {
			return operands[0] * operands[1];
		} else if(operator == '-') {
			return operands[0] - operands[1];
		} else if(operator == '/') {
			return operands[0] / operands[1];
		}
		return 0;
	}
	
	//8+5+x+3*x=10-x+4*3*x
	public void solveLinearEq(String eq) {
		String[] splitOn = {"=", "/+"};
		solveLinearEq(eq, splitOn, 0);
	}
	
	private String solveLinearEq(String eq, String[] splitOn, int index) {
		if(index > splitOn.length)
			return "";
		
		if(index == splitOn.length) {
			return solve(eq);
		}
		String equations[] = eq.split(splitOn[index]);
		
		for(int i=0; i<equations.length; i++) {
			String solution = solveLinearEq(equations[i], splitOn, index+1);
		}
		
		return null;
	}
	
	private String solve(String s) {
		int value = 0;
		String res = "";
		for(int i=s.length()-1; i>=0; i--) {
			
		}
		return res;
	}
	public int findNextGrNumSameDigits(String num) {
		char c[] = num.toCharArray();
		int prev =  c[c.length-1] - '0';
		int smallestDigitIndex = c.length-1;
		
		for(int i=c.length-2; i>=0 ; i--) {
			if(c[i] >= '0' && c[i] <= '9') {
				int digit = c[i] - '0';
				if(digit < prev) {
					swap(c,i,smallestDigitIndex);
					//Arrays.sort(c, i+1, c.length); // sort using counting sort
					sortDigits(c, i+1, c.length-1);
					return Integer.parseInt(new String(c));
				}
			} else {
				return Integer.MIN_VALUE;
			}
			
			if(c[smallestDigitIndex] > c[i])
				smallestDigitIndex = i;
			
			prev = c[i] - '0';
		}
		System.out.println("Not possible....");
		return Integer.MIN_VALUE;
	}
	
	private void sortDigits(char c[], int from, int to) {
		int[] digits = new int[10];
		for(int i=from; i<=to; i++) {
			digits[c[i]-'0']++;
		}
		int j = from;
		for(int i=0; i<digits.length; i++) {
			while(j <= to && digits[i] > 0) {
				c[from++] = (char) ('0'+ i);
				digits[i]--;
			}
		}
	}
	
	private void swap(char c[], int a, int b) { 
		char temp = c[a];
		c[a] = c[b];
		c[b] = temp;
	}
	
	
	public void excelColumnName(int columnNum) {
		String sb = "";
		Map<Integer, Character> map = new HashMap<>();
		for(int i=1; i<=26; i++) {
			map.put(i, (char)('A'+(i-1)));
		}
		while(columnNum > 0) {
			int num = columnNum % 26;
			sb = map.get(num) + sb;
			columnNum = columnNum /26;
		}
		
		System.out.println("excel col name -->" +sb.toString());
	}
	
	public int maxSumPath(int[] ar1, int[] ar2) {
		int sum1 = 0;
		int sum2 = 0;
		int maxSum = 0;
		int i =0, j =0;
		while(i < ar1.length && j < ar2.length) {
			if(ar1[i] < ar2[j]) {
				sum1 = sum1 + ar1[i];
				i++;
			} else if(ar1[i] > ar2[j]) {
				sum2 = sum2 + ar2[j];
				j++;
			} else if(ar1[i] == ar2[j]) {
				if(sum1 > sum2) {
					maxSum = maxSum + sum1;
				} else {
					maxSum = maxSum + sum2;
				}
				maxSum = maxSum + ar1[i];
				sum1 = 0;
				sum2 = 0;
				i++;
				j++;
			}
		}
		
		while(i <ar1.length) {
			sum1 = sum1 + ar1[i];
			i++;
		}
		
		while(j < ar2.length) {
			sum2 = sum2 + ar2[j];
			j++;
		}
		
		if(sum1 > sum2) {
			maxSum = maxSum + sum1;
		} else {
			maxSum = maxSum + sum2;
		}
		
		return maxSum;
	}
	
	public int longestSubstringWithoutRepeatingChars(String s) {
		int maxLen = 1;
		int start = 0;
		int ascii[] = new int[256];
		char c[] = s.toCharArray();
		ascii[c[start]]++;
		for(int i=1; i<c.length; i++) {
			if(ascii[c[i]] == 1) {
				int len = i-start;
				if(len > maxLen)
					maxLen = len;
				start = i;
				ascii = new int[256];
				ascii[c[start]]++;
			} else {
				ascii[c[i]]++;
			}
		}
		int len = (c.length-1)-start+1;
		if(len > maxLen)
			maxLen = len;
		return maxLen;
		
	}
	
	
	public int maxNumOfA(int keys) {
		if(keys <= 0)
			return 0;
		
		if(keys <= 6)
			return keys;
		
		int max = 0;
		for(int i = keys-3; i>=1; i--) {
			int curr = (keys-i-1)*maxNumOfA(i);
			if(curr > max)
				max = curr;
		}
		return max;
	}
	
	public int findKthSmallest(int arr[], int k) {
		if(k <= 0 || k > arr.length)
			return Integer.MIN_VALUE;
		int from = 0;
		int to = arr.length-1;
		while(from <= to) {
			int partitionIndex = partition(arr, from, to);
			if(partitionIndex == k-1)
				return arr[partitionIndex];
			else if(k - 1 < partitionIndex) {
				to = partitionIndex-1;
			} else {
				from = partitionIndex+1;
			}
		}
		
		return -1;
	}
	
	private int partition(int arr[], int from, int to) {
		Random r = new Random();
		int pivotIndex = from + r.nextInt(to-from + 1);
		int pivotValue = arr[pivotIndex];
		swap(arr, from, pivotIndex);
		int w = from + 1;
		for(int i=from+1; i<=to; i++) {
			if(arr[i] <= pivotValue) {
				swap(arr, w, i);
				w++;
			}
		}
		swap(arr,from,w-1);
		return w-1;
	}
	
	private void swap(int arr[] , int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public int addTwoNumbersWithoutUsingPlus(int a, int b) {
		if(b == 0)
			return a;
		
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return addTwoNumbersWithoutUsingPlus(sum, carry);
	}
	
	public int powerBetter(int a, int n) {
		
		if(a == 0)
			return 1;
		
		if(n == 1)
			return a;
		
		if( n % 2 == 0)
			return powerBetter(a*a, n/2);
		else
			return powerBetter(a*a, n/2)*a;
	}
	
	public int power(int a, int b) {
		if(a == 0)
			return 1;
		
		if(b == 1)
			return a;
		
		return a * power(a,b-1);
	}
	
	public void shuffleCards(int[] cards) {
		shuffleCards(cards, cards.length-1);
	}
	
	private void shuffleCards(int[] cards, int num) {
		if(num == 0)
			return;
		
		shuffleCards(cards, num-1);
		int index = randomIndex(cards, 0, num);
		int temp = cards[index];
		cards[index] = cards[num];
		cards[num] = temp;
	}
	
	private int randomIndex(int []arr, int from, int to) {
		Random r = new Random();
		return from + r.nextInt(to-from+1);
	}
	
	public void printAllParenthesisOpenClose(int N) {
		printAllParenthesisOpenClose(N, 0, 0, "");
	}
	
	private void printAllParenthesisOpenClose(int N, int open, int close, String s) {
		if(open == N && close == N) {
			System.out.println(s);
			return;
		}
		
		if(open < N) {
			printAllParenthesisOpenClose(N, open+1, close, s+"(");
			if(close < open)
				printAllParenthesisOpenClose(N, open, close+1, s+")");
		} else {
			printAllParenthesisOpenClose(N, open, close+1, s+")");
		}
		
	}
	
	public void printAllSubsets2(int arr[]) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<Integer>());
		for(int i=0; i<arr.length; i++) {
			int size = res.size();
			for(int j=0; j<size; j++) {
				List<Integer> temp = new ArrayList<>(res.get(j));
				temp.add(arr[i]);
				res.add(temp);
			}
		}
		for(int i=0; i<res.size(); i++) {
			System.out.print(Arrays.toString(res.get(i).toArray())+" ");
		}
	}
	
	public void printAllSubsets(int arr[]) {
		boolean b[] = new boolean[arr.length];
		printAllSubsets(arr, b, 0);
	}
	
	private void printAllSubsets(int arr[], boolean barr[], int index) {
		if(index > arr.length)
			return;
		
		if(index == arr.length) {
			System.out.print("{");
			for(int i=0; i<arr.length; i++) {
				if(barr[i])
					System.out.print(arr[i]+" ");
			}
			System.out.print("}");
			return;
		}
		barr[index] = false;
		printAllSubsets(arr, barr, index+1);
		barr[index] = true;
		printAllSubsets(arr, barr, index+1);
	}
	
	//5-   25    20-    3     2-    1-
	public List<Range> findSubsetsThatSumToZero(int arr[], int sum) {
		Map<Integer, Integer> mapSumAtIndex = new HashMap<>();
		int curr_sum = 0;
		int start = 0;
		List<Range> list = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			curr_sum = curr_sum + arr[i];
			if(curr_sum == sum) {
				list.add(new Range(start, i));
				start = i+1;
			} else if(arr[i] == 0) {
				list.add(new Range(i, i));
			} else if(mapSumAtIndex.containsKey(sum-curr_sum)) {
				list.add(new Range(start, i));
			}
		}
		return list;
	}
	
	public List<String> printWaysToClimbNStairsBest(int N) {
		List<String> list = new Vector<>();
		printWaysToClimbNStairsBest(N, "",list);
		return list;
	}
	
	public List<String> climbNStairsDP(int N) {
		Map<Integer,List<String>> list = new HashMap<>();
		printWaysToClimbNStairsBestDP(N, list);
		return list.get(N);
	}
	
	private List<String> printWaysToClimbNStairsBestDP(int N, Map<Integer,List<String>> map) {
		
		if(N < 1)
			return null;
		
		if(map.containsKey(N))
			return map.get(N);
		
		if(N == 1) {
			List<String> res = new LinkedList<String>();
			res.add("1");
			map.put(N, res);
			return res;
		}
		
		if(N == 2) {
			List<String> res = new LinkedList<String>();
			res.add("11");
			res.add("2");
			map.put(N, res);
			return res;
		}
		
		
		List<String> res1 = printWaysToClimbNStairsBestDP(N-1, map);
		List<String> res2 = printWaysToClimbNStairsBestDP(N-2, map);
		List<String> res = new LinkedList<>();
		if(res1 != null) {
			for(String s : res1) {
				res.add("1"+s);
			}
		}
		
		if(res2 != null) {
			for(String s : res2) {
				res.add("2"+s);
			}
		}
		
		map.put(N, res);
		
		return res;
		
		
	}
	
	private void printWaysToClimbNStairsBest(int N, String s, List<String> list) {
		if(N < 0)
			return;
		
		if(N == 0) {
			list.add(s);
			return;
		}
		
		printWaysToClimbNStairsBest(N-1, s+"1", list);
		printWaysToClimbNStairsBest(N-2, s+"2", list);
	}
	
	public List<List<Integer>> printWaysToClimbNStairsWithoutDP(int N) {
		List<List<Integer>> res = new ArrayList<>();
		getWaysToClimbNStairs(N, new ArrayList<Integer>(), res);
		return res;
	}
	
	public List<List<Integer>> printWaysToClimbNStairs(int N) {
		Map<Integer, List<List<Integer>>> map = new HashMap<>();
		return getWaysToClimbNStairsDP(N,map);
	}
	
	private List<Integer> getWaysToClimbNStairs(int N, List<Integer> list, List<List<Integer>> res) {		
		if(N < 0)
			return null;
		
		if(N == 0) {
			res.add(list);
			return list;
		}
	
		List<Integer> oneStep = new ArrayList<>(list);
		oneStep.add(1);
		
		List<Integer> twoStep = new ArrayList<>(list);
		twoStep.add(2);
		
		oneStep = getWaysToClimbNStairs(N-1, oneStep, res);
		twoStep = getWaysToClimbNStairs(N-2, twoStep, res);
		
		if(oneStep != null)
			return oneStep;
		else
			return twoStep;
		
	}
	
	private List<List<Integer>> getWaysToClimbNStairsDP(int N, Map<Integer, List<List<Integer>>> map) {
		
		if(N < 1)
			return null;
		
		if(map.containsKey(N))
			return map.get(N);
		
		if(N == 1) {
			List<Integer> list = new ArrayList<>();
			list.add(1);
			List<List<Integer>> res = new ArrayList<>();
			res.add(list);
			map.put(N, res);
			return res;
		}
		
		if(N == 2) {
			List<Integer> list1 = new ArrayList<>();
			list1.add(2);
			List<Integer> list2 = new ArrayList<>();
			list2.add(1);
			list2.add(1);
			List<List<Integer>> res = new ArrayList<>();
			res.add(list1);
			res.add(list2);
			map.put(N, res);
			return res;
		}
		
		
		List<List<Integer>> res1 = getWaysToClimbNStairsDP(N-1, map);
		List<List<Integer>> res2 = getWaysToClimbNStairsDP(N-2, map);
		List<List<Integer>> res = new ArrayList<>();
		
		if(res1 != null) {
			for(List<Integer> list : res1) {
				list.add(1);
			}
		}
		
		if(res2 != null) {
			for(List<Integer> list : res2) {
				list.add(2);
			}
		}

		res.addAll(res1);
		res.addAll(res2);
		map.put(N, res);
		return res;
		
	}

}

class Bits { 
	
	public String bitString(int num) {
		String s = "";
		int i = 31;
		while(i >= 0) {
			s = (num & 1) + s;
			num = num >> 1;
			i--;
		}
		return s;
	}
}
