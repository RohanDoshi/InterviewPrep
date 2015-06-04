import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class RequestNode { 
	long timeStamp ;
	public RequestNode(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	RequestNode next;
	RequestNode prev;
}


class API { 
	RequestNode start;
	RequestNode end;
	
	int reqCountSec = 0;
	int reqCountMin = 0;
	int reqCountHr = 0;
	RequestNode secNode;
	RequestNode minNode;
	RequestNode hourNode;
	
	public void addRequest(RequestNode node) {
		if(start == null) {
			start = node;
			end = node;
			secNode = node;
			minNode = node;
			hourNode = node;
		} else { 
			node.next = start;
			start.prev = node;
			start = node;
		}
		reqCountHr++;
		reqCountMin++;
		reqCountSec++;
		setOtherNodesLogic(node);
	}
	
	private void setOtherNodesLogic(RequestNode mostRecent) {
		while(secNode != null && mostRecent.timeStamp - secNode.timeStamp > 1000) {
			secNode = secNode.prev;
			reqCountSec--;
		}
		
		while(minNode != null && mostRecent.timeStamp - minNode.timeStamp > 1000*60) {
			minNode = minNode.prev;
			reqCountMin--;
		}
		
		while(hourNode != null && hourNode.timeStamp - hourNode.timeStamp > 1000*60*60) {
			hourNode = hourNode.prev;
			hourNode.next = null;
			reqCountHr--;
		}
		
	}
	
	public int getReqCountLastSec() {
		return reqCountSec;
	}
	
	
	public int getReqCountLastMin() {
		return reqCountMin;
	}
	
	public int getReqCountLastHour() {
		return reqCountHr;
	}
}

public class Page6 implements Iterable<Integer> {

	public static void main(String[] args) {
		Page6 pg = new Page6();

		int stocks[] =  {100, 180, 260, 310, 40, 535, 695};//{80, 2, 6, 3, 100};//{ 7, 9, 5, 6, 3, 2 };//{2, 3, 10, 6, 4, 8, 1};////
	    int stcks[] = { 7, 9, 5, 6, 3, 2 };
	    int stks[] = {80, 2, 6, 3, 100};
	    pg.findBuySellDates(stocks);
	    int[] set = {1,2,3};
	    pg.printPowerSet(set);
	    pg.returnPowerSet(set);
	    pg.printPowerSetKickAss(set);
	    pg.returnPowerSetKickAss(set);
	    
	    int arr[] = {1,2,3,4,5,6,7,8,9,10};
	    BinaryNode<Integer> root = pg.constructBST(arr);
	    pg.kthLargestElemBST(root, 4);
	    pg.convertRomanToInteger("MCMXCIX");
	    pg.printBitsInOrderDiffByOne(3);
	    System.out.println("Gray code....");
	    pg.printGrayCodesConcatenate(3);
	    //4x+13(x-(4x+x/3))=9
	    pg.evaluateEquationForX("4*x+13*(x-(4*x+x/3))=9");
	    int arr1[] = {1,5,5};
		char symbols[] = {'+','-','*','/'};
		pg.checkIfExpressionEvaluatesToN(arr1, symbols, 9);
		pg.checkIfExpressionEvaluatesToNSmart(arr1, symbols, 9);
		pg.permutations(symbols);
		Set<Integer> s1 = new HashSet<>();
		s1.add(1);
		s1.add(2);
		Set<Integer> s2 = new HashSet<>();
		s2.add(2);
		s2.add(1);
		System.out.println(s1.hashCode()+" "+s2.hashCode());
		pg.combinationsLengthN(symbols, 2);
		int comb[] = {1,3,2,1,4};
		pg.combinationsLengthNHandleRepetitions(comb, 2);
		String s = "fab";
		Map<Character, List<Character>> map = new HashMap<>();
		map.put('f', new ArrayList<Character>());
		map.put('b', new ArrayList<Character>());
		map.get('f').add('F');
		map.get('f').add('4');
		map.get('b').add('B');
		map.get('b').add('8');
		System.out.println(" ************************* ");
		pg.mappingToSubstituteCharsEasier(s, map);
		double[] darr= {24,2,1,4,6,4};
		int ind = pg.partition(darr, 0, darr.length-1);
		System.out.println(ind+" "+Arrays.toString(darr));
		
		double []kth = {0.5,2.5,1};
		System.out.println("kth largest --->"+pg.kthLargest(kth, 1));
		System.out.println((char)('1'-0) ^ ('0'-0));
		pg.addBinaryNum("110", "01101");
		pg.returnAllSequencesThatSumToN(4);
		System.out.println("Sequences that sum to..... DP");
		List<List<Integer>> seq = pg.returnAllSequencesThatSumToNDP(4);
		for(List<Integer> l : seq) {
			System.out.println(l.toString());
		}
		
		Date d1 = new Date();
		int[] packOf = {6,9};
		System.out.println("McNuggets....");
		System.out.println(pg.mcNuggetsPossibleBottomUp(packOf, 15));
		System.out.println(pg.mcNuggetsPossibleBottomUp(packOf, 40));
		System.out.println(pg.laceStringRecur("rohan", "facebook"));
		System.out.println(pg.toRoman("IVX"));
		pg.convertRomanToInteger("IVX");
	}
	
//	You are given an input form such as the following 
//	(1, (2, 3), (4, (5, 6), 7)) 
	
	public int toRoman(String s) {
		
		if(s == null || s.isEmpty())
			return -1;
		
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int sum = 0, pre = 0;
		for(int i=0; i<s.length(); i++) {
			int val =  map.get(s.charAt(i));
			sum = sum + val;
			if(i != 0 && val > pre * 10)
				return -1;
			if(val > pre) {
				sum = sum - pre - pre;
			}
			pre = val;
		}
		
		return sum;
		
	}
	
	public String laceStringRecur(String s1, String s2) {
		if(s1 == null)
			return s2;
		if(s2 == null)
			return s1;
		if(s1.isEmpty())
			return s2;
		if(s2.isEmpty())
			return s1;
		
		return ""+s1.charAt(0) + s2.charAt(0) + laceStringRecur(s1.substring(1), s2.substring(1));
	}
	
	public boolean mcNuggetsPossibleBottomUp(int packOf[], int n) {
		if(n <= 0)
			return false;
		
		boolean[] possible = new boolean[n+1];
		for(int i=0; i<packOf.length; i++) {
			if(packOf[i] <= n) {
				possible[packOf[i]] = true;
			}
		}
		
		for(int i=1; i<=n; i++) {
			if(!possible[i])
			for(int j=0; j<packOf.length && packOf[j] <= i; j++) {
				possible[i] = possible[i] || (possible[i-packOf[j]] && possible[packOf[j]]);
			}
		}
		
		return possible[n];
	}
	
	
	public List<List<Integer>> returnAllSequencesThatSumToNDP(int N) {
		List<List<Integer>> result = new ArrayList<>();
		
		if(N == 0) {
			List<Integer> list = new LinkedList<>();
			result.add(list);
			return result;
		}
		
		if(N == 1) {
			List<Integer> list = new LinkedList<>();
			list.add(1);
			result.add(list);
			return result;
 		}
		
		
		for(int i=1; i<=N; i++) {
			List<List<Integer>> res = returnAllSequencesThatSumToNDP(N-i);
			for(List<Integer> l : res) {
				l.add(i);
			}
			result.addAll(res);
		}
		return result;
	}
	
	public void returnAllSequencesThatSumToN(int N) {
		if(N <= 0)
			return;
		
		List<List<Integer>> list = returnAllSequencesThatSumToNRecur(N);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
	
	private List<List<Integer>> returnAllSequencesThatSumToNRecur(int N) { 
		if(N == 0) {
			List<List<Integer>> list = new LinkedList<>();
			list.add(new LinkedList<Integer>());
			return list;
		}
		List<List<Integer>> finalRes = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			List<List<Integer>> res = returnAllSequencesThatSumToNRecur(N-i);
			for(List<Integer> l : res) {
				l.add(i);
				finalRes.add(l);
			}
		}
		return finalRes;
	}
	
	
	public void addBinaryNum(String s1, String s2) {
		
		while(s1.length() < s2.length()) {
			s1 = '0' + s1;
		}
		
		while(s2.length() < s1.length()) {
			s2 = '0' + s2;
		}
		
		char[] res = new char[s1.length()+1];
		int carry = 0;
		for(int i=s1.length()-1; i>=0; i--) {
			int sum = carry ^ (s1.charAt(i)-'0') ^ (s2.charAt(i) - '0');
			res[i+1] = sum == 0? '0' : '1';
			carry = ((s1.charAt(i)-'0') & (s2.charAt(i) - '0')) |
					((s1.charAt(i)-'0') & carry) | ((s2.charAt(i)-'0') & carry);
			
		}
		res[0] = carry == 0 ? '0': '1';
		
		System.out.println(res);
	}
	
	//k=0 is the largest, k = n-1 is the smallest
	public double kthLargest(double[] arr, int k) {
		int kthSmallest = arr.length-1-k;
		int low = 0;
		int high = arr.length-1;
		while(low < high) {
			int index = partition(arr, low, high);
			if(index == kthSmallest)
				return arr[index];
			
			if(kthSmallest < index) {
				high = index-1;
			} else {
				low = index+1;
			}
		}
		
		return -1;
		
	}
	// 3 5 0 1 4 // 0 5 3 1 4 // 0 1 3 5 4 
	private int partition(double[] arr, int from, int to) {
		
		double pivot = arr[from];
		for(int i=from+1; i<=to; i++) {
			if(arr[i] < pivot) {
				swap(arr, from, i);
				from++;
			}
		}
		return from;
	}
	
	private void swap(double d[], int a, int b) {
		double temp = d[a];
		d[a] = d[b];
		d[b] = temp;
	}
	
	
	String s = "";
	 Map<Character,List<Character>> mapSubstitute;
	
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			List<List<Character>> list = mappingToSubstituteChars(s, mapSubstitute);
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
	public List<List<Character>> mappingToSubstituteChars(String s, Map<Character,List<Character>> mapSubstitute) {
		List<List<Character>> list = new ArrayList<>();
		for(int i=0; i<s.length(); i++) {
			List<Character> temp = new ArrayList<>();
			temp.add(s.charAt(i));
			if(mapSubstitute.containsKey(s.charAt(i)))
				temp.addAll(mapSubstitute.get(s.charAt(i)));
			list.add(temp);
		}
		return list;
	}
	
	public void mappingToSubstituteCharsEasier(String s, Map<Character,List<Character>> mapSubstitute) { 
		Set<String> resultList = new HashSet<>();
		resultList.add(s);
		mappingToSubstituteChars(s.toCharArray(), s.toCharArray(), 0, mapSubstitute, resultList);
		System.out.println(Arrays.toString(resultList.toArray()));
	}
	
	private void mappingToSubstituteChars(char[] original, char[] c, int index, Map<Character, List<Character>> mapSubstitute, Set<String> resultList) {
		if(index >= c.length)
			return;
		
		char currentChar = c[index];
		if(mapSubstitute.containsKey(currentChar)) {
			List<Character> list = mapSubstitute.get(currentChar);
			for(char ch : list) {
				original[index] = ch;
				resultList.add(new String(original));
				original[index] = currentChar;
				c[index] = ch;
				resultList.add(new String(c));
				mappingToSubstituteChars(original, c, index+1, mapSubstitute, resultList);
			}
			c[index] = currentChar;
		} else { 
			mappingToSubstituteChars( original, c, index+1, mapSubstitute, resultList);
		}
	}
	
	public void combinationsLengthNHandleRepetitions(int[] arr, int len) {
		System.out.println("\n combinationsLengthNHandleRepetitions...");
		Arrays.sort(arr);
		int data[] = new int[len];
		combinationsLengthNHandleRepetitions(arr, data, 0, 0);
	}
	
	private void combinationsLengthNHandleRepetitions(int[] arr, int[] data, int index, int dataIndex) {
		if(index > arr.length)
			return;
		
		if(dataIndex == data.length) {
			System.out.println(Arrays.toString(data));
			return;
		}
		
		if(index == arr.length)
			return;
		
		data[dataIndex] = arr[index];
		
		while(index+1 < arr.length && arr[index] == arr[index+1]) {
			index++;
		}
		
		combinationsLengthNHandleRepetitions(arr, data, index+1, dataIndex+1);
		combinationsLengthNHandleRepetitions(arr, data, index+1, dataIndex);
		
	}
	
	public void combinationsLengthN(char[] sym, int len) {
		Character perm[] = new Character[len];
		System.out.println("permutationsLengthN....");
		List<List<Character>> list = new ArrayList<>();
		combinationsLengthN(sym, perm, 0, 0, list);
	}
	
	private void combinationsLengthN(char[] sym, Character[] perm, int index, int permIndex, List<List<Character>> list) {
		if(index > sym.length)
			return;
		
		if(permIndex == perm.length) {
			List<Character> newList = new ArrayList<>(Arrays.asList(perm));
			list.add(newList);
			return;
		}
		
		if(index == sym.length)
			return;
		
		perm[permIndex] = sym[index];
		combinationsLengthN(sym, perm, index+1, permIndex+1, list);
		combinationsLengthN(sym, perm, index+1, permIndex, list);
		
	}
	
	
	public void checkIfExpressionEvaluatesToN(int[] arr, char[] symbols, int N) {
		Set<Character> sym = new HashSet<>();
		for(char c: symbols) {
			sym.add(c);
		}
		
		boolean check = checkIfExpressionEvaluatesToTarget(arr, sym, 0, 0, N);
		System.out.println("checkIfExpressionEvaluatesToN ----> "+check);
	}
	
	public void checkIfExpressionEvaluatesToNSmart(int[] arr, char[] symbols, int N) {
		int numOfSym = arr.length-1;
		Character[] symPerm = new Character[numOfSym];
		List<List<Character>> list = new ArrayList<>();
		combinationsLengthN(symbols, symPerm, 0, 0, list);
		for(int i=0; i<=symbols.length/2; i++) {
			swap(symbols, i, symbols.length-1-i);
		}
		combinationsLengthN(symbols, symPerm, 0, 0, list);
		for(int i=0; i<list.size(); i++) {
			String s = "";
			for(int j=0; j<arr.length; j++) {
				List<Character> charList = list.get(i);
				if(j == 0)
					s = s + arr[j];
				else {
					s = s + charList.get(j-1) + arr[j];
				}
			}
			double val = evaluateExp(s, 0);
			if(val == N)
				System.out.println("YOOOOOOOOOOOOOOOO");
		}
	}
	
	private void permutations(char[] sym) {
		permutations(sym, 0);
	}
	
	private void permutations(char[] sym, int index) {
		if(index > sym.length)
			return;
		
		if(index == sym.length) {
			System.out.println(Arrays.toString(sym));
			return;
		}
		
		for(int i=index; i<sym.length; i++) {
			swap(sym, i, index);
			permutations(sym, index+1);
			swap(sym, i, index);
		}
	}
	
	private void swap(char[] c, int a, int b) {
		char temp = c[a];
		c[a] = c[b];
		c[b] = temp;
	}
	
	public void evaluateEquationForX(String equation) {
		if(equation == null)
			return;
		
		String[] exp = equation.split("=");
		double leftVal_0 = evaluateExp(exp[0], 0);
		double rightVal_0 = evaluateExp(exp[1], 0);
		
		double leftVal_1 = evaluateExp(exp[0], 1);
		double rightVal_1 = evaluateExp(exp[1], 1);
		
		double coeffLeft = leftVal_1 - leftVal_0;
		double coeffRight = rightVal_1 - rightVal_0;
		double coeffToRight = coeffRight - coeffLeft ;
		double valToLeft = leftVal_0 - rightVal_0;
		System.out.println(valToLeft/coeffToRight);
		
	}
	
	// #YO_I_DID_IT.. 
	private boolean checkIfExpressionEvaluatesToTarget(int[] arr, Set<Character> sym, int currIndex ,int totalVal, int target) {
		if(currIndex > arr.length)
			return false;
		
		if(currIndex == arr.length) {
			if(totalVal == target)
				return true;
			else
				return false;
		}
		int val = arr[currIndex];
		
		boolean checkAdd, checkSub, checkDiv, checkMul;
		if(sym.contains('+')) {
			checkAdd = checkIfExpressionEvaluatesToTarget(arr, sym, currIndex+1, totalVal + val, target);
			if(checkAdd)
				return true;
		}
		if(sym.contains('-')) {
			checkSub = checkIfExpressionEvaluatesToTarget(arr, sym, currIndex+1, totalVal - val, target);
			if(checkSub)
				return true;
		}
		if(sym.contains('*')) {
			checkMul = checkIfExpressionEvaluatesToTarget(arr, sym, currIndex+1, totalVal == 0 ? 1 * val : totalVal * val, target);
			if(checkMul)
				return true;
		}
		if(sym.contains('/')) {
			checkDiv = checkIfExpressionEvaluatesToTarget(arr, sym, currIndex+1, val != 0 ? totalVal / val : Integer.MIN_VALUE, target);
			if(checkDiv)
				return true;
		}
		
		return false;
		
	}
	
	
	private double evaluateExp(String exp, double value) {
		Stack<Character> operators  = new Stack<>();
		Stack<Double> operands = new Stack<>();
		
		for(int i=0; i<exp.length(); i++) {
			 char c = exp.charAt(i);
			 if(isDigit(c)) {
				 double val = 0;
				 while(i<exp.length() && isDigit(exp.charAt(i))) {
					 c = exp.charAt(i);
					 val = val*10 + (c - '0');
					 i++;
				 }
				 operands.add(val);
			 }
			 
			 if(i == exp.length())
				 break;
			 
			 c = exp.charAt(i);
			 if(c == '+' || c == '-' || c == '/' || c == '*') {
				 if(operators.size() == 0) {
					 operators.add(c);
					 continue;
				 } else { 
					 while(operators.size() != 0 && hasPrecedence(operators.peek(), c)) {
						 char oper = operators.pop();
						 double d2 = operands.pop();
						 double d1 = operands.pop();
						 double res = calculate(d1, oper, d2);
						 operands.add(res);
					 }
					 operators.add(c);
				 }
			 } else if(c == '(' || c == ')') {
				 
				 if(c == '(') {
					 operators.add(c);
					 continue;
				 } else { 
					 char oper = '\0';
					 while(operators.size() != 0 && (oper = operators.pop()) != '(') {
						 double d2 = operands.pop();
						 double d1 = operands.pop();
						 double res = calculate(d1, oper, d2);
						 operands.add(res);
					 }
				 }
			 
				
			 } else  if(c == 'x') {
				 operands.add(value);
			 }
		}
		
		while(operands.size() != 1) {
			 char oper = operators.pop();
			 double d2 = operands.pop();
			 double d1 = operands.pop();
			 double res = calculate(d1, oper, d2);
			 operands.add(res);
		}
		
		return operands.pop();
	}
	
	private double calculate(double d1, char oper, double d2) {
		if(oper == '+')
			return d1 + d2;
		if(oper == '-')
			return d1 - d2;
		if(oper == '*')
			return d1 * d2;
		if(oper == '/')
			return d1 / d2;
		
		return 0;
	}
	
	private boolean hasPrecedence(char op1, char op2) {
		if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return true;
		else
			return false;
	}
	
	private boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}
	
	public void printGrayCodesConcatenate(int n) {
		if(n <= 0)
			return;
		
		List<String> list = new ArrayList<>();
		list.add("0");
		list.add("1");
		
		for(int i=2; i<=n; i++) {
			int size1 = list.size();
			for(int j=size1-1; j>=0; j--) {
				list.add(list.get(j));
			}
			int size = list.size();
			for(int j=0; j<size1; j++) {
				list.set(j, "0"+list.get(j));
			}
			
			for(int j=size1; j<size; j++) {
				list.set(j, "1"+list.get(j));
			}
		}
		
		System.out.println(Arrays.toString(list.toArray()));
	}
	
	// 0 to (2^N-1)
	public void printBitsInOrderDiffByOne(int n) {
		
		System.out.println();
		for(int i=0; i< (1 << n); i++) { 
			System.out.print(binaryToGray(i)+" ");
		}
		System.out.println();
		for(int i=0; i<(1<<n); i++) {
			int j = n;
			int temp = binaryToGray(i);
			String s = "";
			while(j > 0) {
				s = ( 1 & temp) + s;
				temp = temp >>> 1;
				j--;
			}
			System.out.print(s+" ");
		}
	}
	
	public int binaryToGray( int num) { 
		 return (num >> 1) ^ num; 
	}
	
	// IVX == VI == 6
	// XIV 
	// roman rules : a val cannot precede one that is more than 10 times larger than itself
	// roman rules : the preceding val, if smaller, should be a multiple of 10
	public void convertRomanToInteger(String roman) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int pre = 1001;
		int curr = 0;
		int sum = 0;
		for(int i=0; i<roman.length(); i++) {
			curr = map.get(roman.charAt(i));
			if(curr <= pre) 
				sum = sum + curr;
			else {
				sum = sum - pre - pre + curr;
			}
			pre = curr;
		}
		System.out.println("Roman to Int --> "+sum);
	}
	
	public BinaryNode<Integer> constructBST(int arr[]) {
		return constructBST(arr, 0, arr.length-1);
	}
	
	private BinaryNode<Integer> constructBST(int arr[], int low, int high) {
		if(low > high)
			return null;
		
		int mid = (low + high)/2;
		BinaryNode<Integer> root = new BinaryNode<Integer>(arr[mid]);
		root.left = constructBST(arr, low, mid-1);
		root.right = constructBST(arr, mid+1, high);
		return root;
		
	}
	
	public void kthLargestElemBST(BinaryNode<Integer> node, int k){
		int currNum[] = new int[1];
		BinaryNode<Integer> kthElem = kthLargestElem(node, currNum, k);
		if(kthElem != null)
			System.out.println("Kth Largest -> "+kthElem.value);
	}
	
	private BinaryNode<Integer> kthLargestElem(BinaryNode<Integer> node, int[] currNum, int k) {
		if(node == null)
			return null;
		
		BinaryNode<Integer> right = kthLargestElem(node.right, currNum, k);
		if(right != null)
			return right; 
		
		currNum[0]++;
		if(currNum[0] == k) {
			return node;
		}
		BinaryNode<Integer> left = kthLargestElem(node.left, currNum, k);
		if(left != null)
			return left;
		return null;
	}
	
	public void returnPowerSetKickAss(int[] arr) {
		System.out.println("\nreturnPowerSetKickAss....");
		List<List<Integer>> res = new ArrayList<>();
		for(int i=0; i< (1<<arr.length); i++) {
			List<Integer> list = new ArrayList<>();
			for(int j=0; j<arr.length; j++) {
				if((i & (1 << j)) > 0) {
					list.add(arr[j]);
				}
			}
			res.add(list);
		}
		
		for(int i=0; i<res.size(); i++) {
			System.out.println(Arrays.toString(res.get(i).toArray()));
		}
	}
	
	public void printPowerSetKickAss(int[] arr) {
		for(int i=0; i<(1<<arr.length); i++) {
			System.out.print("{");
			for(int j=0; j<arr.length; j++) {
				if((i&(1<<j)) > 0) {
					System.out.print(arr[j]+" ");
				}
			}
			System.out.print("}");
			System.out.print(" ");
		}
	}
	
	public void returnPowerSet(int[] arr) {
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
			System.out.println(Arrays.toString(res.get(i).toArray()));
		}
	}
	
	public void printPowerSet(int[] arr) {
		boolean[] bool = new boolean[arr.length];
		printPowerSet(arr, bool, 0);
	}
	
	private void printPowerSet(int[] arr, boolean[] bar, int start) {
		if(start > arr.length)
			return;
		
		if(start == arr.length) {
			System.out.print("{");
			for(int i=0; i<arr.length; i++) {
				if(bar[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println("}");
			return;
		}
		
		bar[start] = false;
		printPowerSet(arr, bar, start+1);
		bar[start] = true;
		printPowerSet(arr, bar, start+1);
	}

	public void findBuySellDates(int[] arr) {
		List<Range> list = new ArrayList<>();
		int diff[] = new int[arr.length-1];
		for(int i=0; i<diff.length; i++) {
			diff[i] = arr[i+1] - arr[i];
 		}
		
		int curr_sum = 0;
		int start = 0;
		for(int i=0; i<diff.length; i++) {
			if(curr_sum + diff[i] > curr_sum) {
				curr_sum = curr_sum + diff[i];
			} else {
				if(curr_sum > 0) {
					list.add(new Range(start, i));
				}
				start = i+1;
				curr_sum = 0;
			}
		}
		if(curr_sum > 0) {
			list.add(new Range(start, diff.length));
		}
		System.out.println(Arrays.toString(list.toArray()));
	}
}

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
		if(from < o.from)
			return -1;
		else if(from > o.from)
			return 1;
		else
			return 0;
	}
}


class BinaryNode<T> { 
	public BinaryNode(T value) {
		this.value = value;
	}
	BinaryNode<T> left;
	BinaryNode<T> right;
	T value;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.value.toString();
	}
}
