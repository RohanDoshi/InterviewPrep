import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class Practice {
	public static void main(String args[]) throws Exception {
		Practice practice = new Practice();
		System.out.println(practice.pow(2.5, 6));
		System.out.println(Math.pow(2.5, 6));
		System.out.println(practice.editDistanceRecursion("doge", "dogger"));
		Integer [] array1 = {12, 34, 57, 61, 69, 80};
        Integer [] array2 = {27, 39, 48, 51, 79};
        System.out.println(practice.findMinDifference(array1, array2));
        int[] arr = {-1, 4, -5, 2, 1, -3};
        practice.twoSum(arr, -1);
        int[] tri = {3,6, 7,2 ,1,4,5 };
        System.out.println(Arrays.toString(practice.triangleSegmentIfAny(tri)));
        BinaryTree binaryTree = new BinaryTree(8);
        binaryTree.left = new BinaryTree(6);
        binaryTree.right = new BinaryTree(10);
        binaryTree.left.left = new BinaryTree(4);
        binaryTree.left.right = new BinaryTree(7);
        binaryTree.left.left.left = new BinaryTree(3);
        binaryTree.left.left.right = new BinaryTree(5);
        binaryTree.right.left = new BinaryTree(9);
        binaryTree.right.right = new BinaryTree(12);
        practice.printLevelByLevel(binaryTree);
        System.out.println("\n"+practice.sqrt(72));
        System.out.println(practice.evaluatePostFixExp("234+*6-"));
        practice.productArr(arr);
        System.out.println(practice.minStringContainingAll("acbbaca", "aba"));
        int sliding[] = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(practice.slidingMaxWin(sliding, 3)));
        System.out.println(practice.stringToInteger("-000123409101"));
        System.out.println(practice.integerToString(-123409101));
        System.out.println(practice.integerToString(Integer.MAX_VALUE));
//        BinaryTree mirror = practice.mirror(binaryTree);
//        practice.printLevelByLevel(mirror);
        System.out.println(practice.textJustification("This is an example of text justification.", 16).toString()); // does not work as expected... pain in the arse..
        
        int[] maxContig = {2,-1,3,-5,3};
        int[] maxContig1 = {0,8};
        int[] maxContig2 = {-1,8};
        int[] maxContig3 = {1, 2, -4, 1, 3, -2, 3, -1};
        System.out.println(practice.maxContiguosSum(maxContig));
        System.out.println(practice.maxContiguosSum(maxContig1));
        System.out.println(practice.maxContiguosSum(maxContig2));
        System.out.println(practice.maxContiguosSum(maxContig3));
        
        List<Pair> list = new ArrayList<>();
        list.add(new Pair(1, 3));
        list.add(new Pair(12, 14));
        list.add(new Pair(2, 4));
        list.add(new Pair(13, 15));
        list.add(new Pair(5, 10));
        
        practice.condenseToNonOverlapping(list.toArray(new Pair[list.size()]));
        System.out.println(practice.lca(binaryTree, binaryTree.left.left.left, binaryTree.right.right).val);
        practice.printUniqFactors(12); // kinda incomplete.. what about 3*2*2 ?
        printFactors(24, "", 24);
        System.out.println(practice.areIsomorphic("turtle", "tletur"));
        practice.printFactorsPractice(24);
        
        Buffer buffer = new Buffer(5);
        Producer prod = new Producer(buffer);
        Consumer cons = new Consumer(buffer);
//        prod.start();
//        cons.start();
        int[] dutch = new int[10];
        Random r = new Random();
        for(int i=0; i<dutch.length; i++) 
        	dutch[i] = r.nextInt(3);
        
        System.out.println(Arrays.toString(dutch));
        practice.threeWayPartition(dutch, 1);
        System.out.println(Arrays.toString(dutch));
        
        
        Set<String> dictionary = new HashSet<>();
        dictionary.add("geeks");
        dictionary.add("for");
        dictionary.add("quiz");
        dictionary.add("go");
        
        char[][] board = {{'g','i','z'}, {'u','e','k'}, {'q','s','e'}};
        Boggle boggle = new Boggle(dictionary, board);
        List<String> words = boggle.solveBoggle();
        System.out.println(words.toString());
        System.out.println((int) Math.ceil((double) 2/2) -1);
        
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
        myPriorityQueue.add(10);
        System.out.println(myPriorityQueue.toString());
        myPriorityQueue.add(20);
        System.out.println(myPriorityQueue.toString());
        myPriorityQueue.add(3);
        System.out.println(myPriorityQueue.toString());
        myPriorityQueue.add(5);
        System.out.println(myPriorityQueue.toString());
        myPriorityQueue.poll();
        System.out.println(myPriorityQueue.toString());
        myPriorityQueue.poll();
        System.out.println(myPriorityQueue.toString());
	}
	
	
	
	
	public void threeWayPartition(int[] arr, int mid) {
		int i = 0; 
		int j = arr.length-1;
		int k = 0;
		while(i <= j) {
			if(arr[i] < mid) {
				swap(arr, i, k);
				i++;
				k++;
			} else if(arr[i] > mid) {
				swap(arr, i, j);
				j--;
			} else {
				i++;
			}
		}
	}
	
	public void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public void printFactorsPractice(int num) {
		printFactorsPractice(num, num, "");
	}
	
	private void printFactorsPractice1(int num, int prev, String s) {
		for(int i=2; i<num; i++) {
			if(num % i == 0) {
				if(num/i <= prev && num/i <=i && i<=prev)
				System.out.println(s + i + "*" + num/i);
				if(i <= prev)
				printFactorsPractice(num/i, num/i, i+"*");
			}
		}
	}
	
	private void printFactorsPractice(int num, int prev, String s) {
		int val = prev;
		for(int i=num-1; i>=2; i--) {
			if(num % i == 0) {
				if(val > i)
					val = i;
				
				if(num/i <= prev && num/i <= i && i <= prev) {
					System.out.println(s + i + "*" + num/i);
					val = num/i;
				}
				
				if(i <= prev) {
					printFactorsPractice(num/i, val, s + i + "*");
				}
			}
		}
	}
	
	public boolean areIsomorphic(String s1, String s2) {
		if(s1 == null || s2 == null)
			return false;
		
		if(s1.length() != s2.length())
			return false;
		
		Map<Character, Character> map1 = new HashMap<>(); // you could do away with one map 
		Map<Character, Character> map2 = new HashMap<>();
		for(int i=0; i<s1.length(); i++) {
			if(!map1.containsKey(s1.charAt(i)) && !map2.containsKey(s2.charAt(i))) {
				map1.put(s1.charAt(i), s2.charAt(i));
				map2.put(s2.charAt(i), s1.charAt(i));
			} else if(map1.get(s1.charAt(i)) == s2.charAt(i) || map2.get(s2.charAt(i)) == s1.charAt(i)){
				continue;
			} else
				return false;
		}
		
		return true;
	}
	
	public static void printFactors(int number, String parentFactors, int parentVal) {
	    int newVal = parentVal;
	    for (int i = number - 1; i >= 2; i--) {

	        if (number % i == 0) {
	            if (newVal > i) {
	                newVal = i;
	            }
	            if (number / i <= parentVal && i <= parentVal
	                    && number / i <= i) {
	                System.out.println(parentFactors + i + "*" + number / i);
	                newVal = number / i;
	            } else {
	            	System.out.print("");
	            }

	            if (i <= parentVal) {
	                printFactors(number / i, parentFactors + i + "*", newVal);
	            }
	        }

	    }

	}

	
	public void printUniqFactors(int number) {
		for(int i=1; i<=Math.sqrt(number); i++) {
			if(number % i == 0)
				System.out.println("("+i+","+(number/i)+")");
		}
	}
	
	public BinaryTree lca(BinaryTree root, BinaryTree node1, BinaryTree node2) {
		if(root == null)
			return null;
		
		if(root == node1 || root == node2)
			return root;
		
		BinaryTree left = lca(root.left, node1, node2);
		BinaryTree right = lca(root.right, node1, node2) ;
		
		if(left != null && right != null)
			return root;
		
		if(left != null)
			return left;
		
		if(right != null)
			return right;
		
		return null;
	}
	
	public void condenseToNonOverlapping(Pair[] arr) {
		
		Comparator<Pair> comparator = new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if(o1.a < o2.a) 
					return -1;
				else if(o1.a > o2.a)
					return 1;
				else
					return 0;
			}
		};
		
		Arrays.sort(arr, comparator);
		System.out.println(Arrays.toString(arr));
		List<Pair> condensed = new ArrayList<>();
		condensed.add(arr[0]);
		for(int i=1; i<arr.length; i++) {
			Pair top = condensed.get(condensed.size()-1);
			if(arr[i].a-1 <= top.b) {
				top.b = arr[i].b;
			} else {
				condensed.add(arr[i]);
			}
		}
		System.out.println(condensed.toString());
	}
	
	public int maxContiguosSum(int []arr) {
		int maxSum = 0;
		int currSum = 0;
		for(int i=0; i<arr.length; i++) {
			currSum = currSum + arr[i];
			
			if(currSum > maxSum) 
				maxSum = currSum;
			
			if(currSum < 0) {
				currSum = 0;
			}
		}
		
		return maxSum;
	}
	
	public void mergeSortArr(int[] a, int b[]) {
		int res[] = new int[a.length + b.length];
		int i=0, j=0, k =0;
		while(i < a.length && j < b.length) {
			if(a[i] <= b[j]) {
				res[k++] = a[i++];
			} else {
				res[k++] = b[j++];
			}
		}
		
		while(i < a.length) {
			res[k++] = a[i++];
		} 
		
		while(j < b.length) {
			res[k++] = b[j++];
		}
	}

	
	private int findfirstIndexGrEqElem(int []arr, int start, int end, int elem) {
		if(start > end)
			return -1;
		
		if(start == end) {
			if(arr[start] < elem)
				return -1;
			else
				return start;
		}
		
		int mid = (start + end) >>> 1;
		if(elem == arr[mid]) {
			int firstIndex = findfirstIndexGrEqElem(arr, start, mid-1, elem);
			if(firstIndex != -1)
				return firstIndex;
			else
				return mid;
		}
		
		if(elem < arr[mid])
			return findfirstIndexGrEqElem(arr, start, mid-1, elem);
		else
			return findfirstIndexGrEqElem(arr, mid+1, end, elem);
		
	}
	
	//["This", "is", "an", "example", "of", "text", "justification."]
	public List<String> textJustification(String s, int len) {
		String[] arr = s.split(" ");
		List<String> res = new ArrayList<>();
		
		int index = 0;
		int start = 0;
		int tempLen = 0;
		int spaces = 0;
		while(index < arr.length) {
			tempLen += arr[index].length();
			spaces++;
			if(tempLen + spaces >= len) {
				String str = justify(arr, tempLen, len, start, index);
				res.add(str);
				start = index+1;
				tempLen = 0;
				spaces =0;
			} 
			index++;
		}
		
		return res;
	}
	
	private String justify(String words[], int wordsLen, int len, int start, int end) {
		StringBuilder builder = new StringBuilder();
		int curr = 0;
		int spacesReq = len - wordsLen;
		int avgSpace = spacesReq / (end-start+1);
		while(start <= end && curr <= len) {
			builder.append(words[start]);
			int s = 0;
			while(s < avgSpace) {
				builder.append(" ");
				s++;
			}
			
			curr = curr + words[start].length() + avgSpace;
			start++;
		}
		return builder.toString();
	}
	
	public BinaryTree mirror(BinaryTree tree) {
		if(tree == null)
			return null;
		
		tree.left = mirror(tree.left);
		tree.right = mirror(tree.right);
		BinaryTree temp = tree.left;
		tree.left = tree.right;
		tree.right = temp;
		return tree;
	}
	
	public String integerToString(int num) {
		if(num == Integer.MIN_VALUE)
			return "-2147483648";
		
		boolean neg = num < 0 ;
		num = neg ? -num : num;
		char buf[] = new char[getSizeBuffer(num)];
		int index = buf.length-1;
		while(num > 0) {
			int temp = num % 10;
			buf[index--] = (char) (temp + '0');
			num = num/10;
		}
		return neg ? "-"+(new String(buf)) : (new String(buf));
	}
	
	private int getSizeBuffer(int num) {
		int[] numbers = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
		for(int i=0; i<numbers.length; i++) {
			if(num <= numbers[i])
				return i+1;
		}
		return -1;
	}
	
	public int stringToInteger(String num) throws Exception {
		char c[] = num.toCharArray();
		boolean neg = c[0] == '-' ? true : false;
		int start = neg ? 1 : 0;
		int res = 0;
		for(; start < c.length; start++) {
			if(c[start] < '0' || c[start] > '9')
				throw new Exception("cannot be converted into int");
			res = res*10 + (c[start]-'0');
			if(res < 0)
				throw new Exception("overflow.. ");
		}
		return neg ? -res : res;
	}
	
	public int[] slidingMaxWin(int[] arr, int winSize) {
		int[] res = new int[arr.length-winSize+1];
		Comparator<Pair> comparator = new Comparator<Pair>() {
			
			@Override
			public int compare(Pair o1, Pair o2) {
				if(o1.a > o2.a)
					return -1;
				else if(o1.a < o2.a)
					return 1;
				else
					return 0;
			}
		};
		PriorityQueue<Pair> queue = new PriorityQueue<>(winSize, comparator);
		int i=0;
		for(; i<winSize; i++) {
			queue.add(new Pair(arr[i], i));
		}
		
		for(; i<arr.length; i++) {
			res[i-winSize] = queue.peek().a;
			while(!queue.isEmpty() && queue.peek().b <= i -winSize)
				queue.poll();
			queue.add(new Pair(arr[i], i));
		}
		res[res.length-1] = queue.peek().a;
		return res;
	}
	
	public String minStringContainingAll(String input, String target) {
		int ascii[] = new int[256];
		char[] carr = target.toCharArray();
		char[] inputArr = input.toCharArray();
		for(char c : carr) {
			ascii[c]++;
		}
		
		int start = 0, end = 0, count = 0, minLen = Integer.MAX_VALUE ;
		int winStart = 0, winEnd = 0;
		int win[] = new int[256];
		
		while(end < inputArr.length) {
			if(ascii[inputArr[end]] == 0) {
				end++;
				continue;
			}
			
			win[inputArr[end]]++;
			if(win[inputArr[end]] <= ascii[inputArr[end]])
				count++;
			
			if(count == target.length()) {
				while(ascii[inputArr[start]] == 0 || win[inputArr[start]] > ascii[inputArr[start]]) { 
					if(win[inputArr[start]] > ascii[inputArr[start]])
						win[inputArr[start]]--;
					start++;
				}
				
				int len = end - start+1;
				if(len < minLen) {
					minLen = len;
					winStart = start;
					winEnd = end;
				}
			} 
			
			end++;
		}
		
		return new String(inputArr, winStart, winEnd-winStart+1);
	}
	
	// {1,2,3}
	public void productArr(int[] arr) {
		int[] p1 = new int[arr.length];
		int[] p2 = new int[arr.length];
		int p = 1;
		for(int i=0; i<arr.length; i++) {
			p1[i] = p;
			p = p * arr[i];
		}
		p = 1;
		for(int i=arr.length-1; i>=0 ; i--) {
			p2[i] = p;
			p = p*arr[i];
		}
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = p1[i] * p2[i];
		}
		System.out.println(Arrays.toString(arr));
	}
	
	// infix = 2*3-4/5
	// postfix = 23*45/-
	public double evaluatePostFixExp(String exp) {
		char carr[] = exp.toCharArray();
		Stack<Double> stack = new Stack<>();
		for(char c: carr) {
			if(c >= '0' && c <= '9') {
				stack.add((double)c-'0');
			} else {
				if(c == '+') {
					double a = stack.pop();
					double b = stack.pop();
					stack.push(a+b);
				} else if(c == '-') {
					double a = stack.pop();
					double b = stack.pop();
					stack.push(b-a);
				} else if(c == '*') {
					double a = stack.pop();
					double b = stack.pop();
					stack.push(a*b);
				} else if(c == '/') {
					double a = stack.pop();
					double b = stack.pop();
					stack.push((double)a/b);
				}
			}
		}
		return stack.pop();
	}
	
	public double sqrt(double a) {
		double low = 0;
		double high = a;
		double mid = (low + high)/2;
		while(Math.abs(mid*mid - a) > 0.00001) {
			if(mid*mid < a) {
				low = mid;
			} else {
				high = mid;
			}
			
			mid = (low+high)/2;
		}
		
		return mid;
	}
	
	public void printLevelByLevel(BinaryTree tree) {
		if(tree == null)
			return ;
		
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.add(tree);
		queue.add(null);
		while(queue.size() != 1) {
			BinaryTree temp = queue.poll();
			
			if(temp == null) {
				System.out.println();
				queue.add(null);
				continue;
			}
			
			System.out.print(temp.val+" ");
			
			BinaryTree left = temp.left;
			if(left != null)
				queue.add(left);
			BinaryTree right = temp.right;
			if(right != null)
				queue.add(right);
			
		}
	}
	
	public double pow(double a, double b) {
		if(b == 0)
			return 1;
		
		if(b < 0)
			return pow((double)1/a, b);
		
		if(b == 1)
			return a;
		
		return a*pow(a, b-1);
	}
	
	
	public double powEfficient(double a, double b) {
		if(b == 0) 
			return 1;
		
		if(b < 0)
			return 1/powEfficient(a, -b);
		
		if(b == 1)
			return a;
		
		if(b % 2 == 0)
			return powEfficient(a*a, b/2);
		else
			return powEfficient(a*a, b/2)*a;
	}
	
	
	public int editDistance(String word1, String word2) {
		if(word1 == null || word2 == null)
			return -1;
		
		if(word1.length() == 0)
			return word2.length();
		
		if(word2.length() == 0)
			return word1.length();
		
		int[][] table = new int[word1.length()+1][word2.length()+1];
		
		for(int i=0; i<word1.length(); i++) {
			for(int j=0; j<word2.length(); j++) {
				
			}
		}
		
		return  table[word1.length()][word2.length()];
	}
	
	public int editDistanceRecursion(String word1, String word2) {
		if(word1 == null || word2 == null)
			return -1;
		
		int len1 = word1.length(); 
		int len2 = word2.length();
		
		if(len1 == 0)
			return len2;
		
		if(len2 == 0)
			return len1;
		
		if(word1.charAt(0) == word2.charAt(0))
			return editDistanceRecursion(word1.substring(1), word2.substring(1));
		else {
			int a = 1 + (editDistanceRecursion(word1.substring(1), word2.substring(1)));
			int b = 1 + (editDistanceRecursion(word1.substring(1), word2));
			int c = 1 + (editDistanceRecursion(word1, word2.substring(1)));
			return Math.min(a, Math.min(b, c));
		}
		
		
	}
	
	
	public int minDistanceBetTwoWords(String file, String word1, String word2) {
		if(file == null || word1 == null || word2 == null)
			return -1; 
		
		String[] words = file.split(" ");
		Map<String, List<Integer>> map = new HashMap<>();
		for(int i=0; i<words.length; i++) {
			if(map.containsKey(words[i])) {
				map.get(words[i]).add(i);
			} else {
				map.put(words[i], new ArrayList<Integer>());
				map.get(words[i]).add(i);
			}
		}
		
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);
		
		if(list1 == null || list2 == null)
			return -1;
		
		return findMinDifference(list1.toArray(new Integer[list1.size()]), list2.toArray(new Integer[list2.size()]));
	}
	
	private int findMinDifference(Integer[] arr1, Integer[] arr2) {
		int i = 0;
		int j = 0;
		int minDiff = Integer.MAX_VALUE;
		while(i < arr1.length && j < arr2.length) {
			int diff = Math.abs(arr1[i] - arr2[j]);
			if(diff == 0)
				return 0;
			
			if(diff < minDiff)
				minDiff= diff;
			
			if(arr1[i] < arr2[j])
				i++;
			else
				j++;
		}
		
		
		while(i < arr1.length) {
			int diff = Math.abs(arr1[i] - arr2[arr2.length-1]);
			
			if(diff < minDiff)
				minDiff = diff;
			
			i++;
		}
		
		while(j < arr2.length) {
			int diff = Math.abs(arr2[j] - arr1[arr1.length-1]);
			
			if(diff < minDiff)
				minDiff = diff;
			
			j++;
		}
		
		return minDiff;
	}
	
	
	public void twoSum(int[] arr, int sum) {
		List<Pair> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			map.put(arr[i], i);
		}
		
		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(sum-arr[i]) && map.get(sum-arr[i]) > i) {
				list.add(new Pair(arr[i], sum-arr[i]));
			}
		}
		
		System.out.println(list.toString());
	}
	
	public int maxProductSubarr(int[] arr) {
		int maxProdPos = arr[0];
		int maxProdNeg = arr[0];
		int maxProd = arr[0];
	
		for(int i=1; i<arr.length; i++) {
			int temp = maxProdPos;
			maxProdPos = Math.max(Math.max(maxProdPos*arr[i], arr[i]), maxProdNeg*arr[i]);
			maxProdNeg = Math.min(Math.min(temp*arr[i], arr[i]), arr[i]*maxProdNeg);
			maxProd = Math.max(maxProd, maxProdPos);
		}
		return maxProd;
	}
	
	public int[] triangleSegmentIfAny(int[] arr) {
		Arrays.sort(arr);
		for(int i=0; i<arr.length-2; i++) {
			int j = i+1;
			int k = j+1; 
			if(arr[i] + arr[j] > arr[k]) {
				int res[] = new int[3];
				res[0] = arr[i];
				res[1] = arr[j];
				res[2] = arr[k];
				return res;
			}
		}
		return new int[0];
	}
}

class Pair {
	int a, b;
	public Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
	@Override
	public String toString() {
		return "("+a+","+b+")";
	}
}

class BinaryTree { 
	int val;
	public BinaryTree(int val) {
		this.val = val;
	}
	
	BinaryTree left;
	BinaryTree right;
	BinaryTree parent;
}

class Buffer { 
	private int maxSize;
	private char[] buf;
	private int currIndex;
	public Buffer(int size) {
		this.maxSize = size;
		this.buf = new char[maxSize];
	}
	
	public synchronized void add(char ch) {
		try {
			while(currIndex == maxSize) {
				wait();
			}
			buf[currIndex++] = ch;
			notifyAll();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public synchronized char remove() {
		try {
			while(currIndex == 0) {
				wait();
			} 
			char c = buf[currIndex--];
			notifyAll();
			return c;
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return '\0';
		}
	}	
}

class Consumer extends Thread {
	private final Buffer b;
	private InputStreamReader reader = new InputStreamReader(System.in);
	public Consumer(Buffer b) {
		this.b = b;
	}
	@Override
	public void run() {
		while(!Thread.currentThread().interrupted()) {
			try {
				char ch = (char) reader.read();
				b.add(ch);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class Producer extends Thread {
	private final Buffer b;
	
	public Producer(Buffer b) {
		this.b = b;
	}
	@Override
	public void run() {
		while(!Thread.currentThread().interrupted()) {
			char c = b.remove();
			System.out.println(c);
		}
	}
}


class Boggle { 
	
	private Set<String> dictionary;
	private char[][] board;
	private boolean[][] visited;
	
	public Boggle(Set<String> dictionary, char[][] board) {
		this.dictionary = dictionary;
		this.board = board;
		this.visited = new boolean[board.length][board.length];
	}
	
	public List<String> solveBoggle() {
		List<String> list = new ArrayList<>();
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				solveBoggle(list, new StringBuffer(), i, j);
			}
		}
		return list;
	}
	
	private void solveBoggle(List<String> list, StringBuffer buffer, int row, int col) {
		
		if(row < 0 || row >= board.length || col < 0 || col >= board.length)
			return;
		
		if(visited[row][col])
			return;
		
		buffer.append(board[row][col]);
		visited[row][col] = true;
		
		if(dictionary.contains(buffer.toString())) {
			list.add(buffer.toString());
		}
		
		solveBoggle(list, buffer, row+1, col+1);
		solveBoggle(list, buffer, row-1, col-1);
		solveBoggle(list, buffer, row+1, col);
		solveBoggle(list, buffer, row, col+1);
		solveBoggle(list, buffer, row-1, col);
		solveBoggle(list, buffer, row, col-1);
		solveBoggle(list, buffer, row+1, col-1);
		solveBoggle(list, buffer, row-1, col+1);
		
		buffer.deleteCharAt(buffer.length()-1);
		visited[row][col] = false;
		
	}
}


class MyHashTable { 
	
}


class MyPriorityQueue { 
	
	private Object[] table;
	private int numOfElements;
	private Comparator<Object> comparator;
	
	public MyPriorityQueue() {
		this(11);
	}
	
	public MyPriorityQueue(int size) {
		this.table = new Object[size];
	}
	
	public MyPriorityQueue(int size, Comparator<Object> comparator) {
		this(size);
		this.comparator = comparator;
	}
	
	public Object poll() {
		if(numOfElements == 0)
			return null;
		
		Object o = table[0];
		table[0] = null;
		swap(table, 0, numOfElements-1);
		numOfElements--;
		siftDown(0);
		return o;
		
	}
	
	private int leftChild(int index) {
		return 2*index + 1;
	}
	
	private int rightChild(int index) {
		return 2*index + 2;
	}
	
	private void siftDown(int index) {
		if(index == numOfElements-1)
			return;
		
		Comparable<Object> parent = (Comparable<Object> )table[index];
		int leftIndex = leftChild(index);
		if(leftIndex < numOfElements) {
			Comparable<Object> left = (Comparable<Object>) table[leftIndex];
			if(left.compareTo(parent) < 0) {
				swap(table, index, leftIndex);
				siftDown(leftIndex);
			}
			
		}
		parent = (Comparable<Object>) table[index];
		int rightIndex = rightChild(index);
		if(rightIndex < numOfElements) {
			Comparable<Object> right = (Comparable<Object>) table[rightIndex];
			if(right.compareTo(parent) < 0) {
				swap(table, index, rightIndex);
				siftDown(rightIndex);
			}
		}
	}
	
	public void add(Object o) {
		if(numOfElements == table.length) {
			
		}
		
		table[numOfElements++] = o;
		siftUp(numOfElements-1);
	}
	
	private void siftUp(int index) {
		if(index == 0)
			return;
		
		if(comparator != null) {
			siftUpComparator(index);
		} else { 
			Comparable<Object> parent = (Comparable<Object>) table[parentIndex(index)];
			Comparable<Object> child = (Comparable<Object>) table[index];
			
			if(child.compareTo(parent) < 0) {
				swap(table, index, parentIndex(index));
				siftUp(parentIndex(index));
			}
		}
	}
	
	@Override
	public String toString() {
		return Arrays.toString(table);
	}
	
	private int parentIndex(int index) {
		return (int) Math.ceil((double) index/2) -1;
	}
	
	private void swap(Object[] table, int a, int b) {
		Object temp = table[a];
		table[a] = table[b];
		table[b] = temp;
	}
	
	private void siftUpComparator(int index) {
		
	}
	
	
}
