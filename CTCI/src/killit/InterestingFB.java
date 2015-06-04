package killit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class InterestingFB {

	public static void main(String[] args) {
		String words[] = {"caa", "aaa", "aab"};//{"baa", "abcd", "abca", "cab", "cad"};
		findNPrintOrderOfChars(words);
		System.out.println(findPattern(5));
		findPairsToDoubleSquareEfficient(1215306625);
		System.out.println(isEditDistance("abc", "def", 3));
		Set<String> dictionary = new HashSet<>();
		dictionary.add("world");
		dictionary.add("hello");
		dictionary.add("super");
		dictionary.add("hell");
		System.out.println(isWordConcatOfTwoStrings(dictionary, "superman"));
		
		LinkedNode node = new LinkedNode(1);
		node.next = new LinkedNode(2);
		node.next.next = new LinkedNode(3);
		node.next.next.next = new LinkedNode(4);
		node.next.next.next.next = new LinkedNode(5);
		
		node.random = node.next.next;
		node.next.random = node;
		node.next.next.random = node.next.next.next.next;
		node.next.next.next.random = node.next.next;
		node.next.next.next.next.random = node.next;
		
		//constructRandomList(node);
		//cloneLinkedList(node);
		
		int arr[] = {3,4,7,1,2,9,8};
		findSetsThatSatisfy(arr);
		System.out.println("-------------");
		allPossibleMappings("111");
		allPossibleMappings("11");
		allPossibleMappings("123");
		cloneLinkedListEfficient(node);
		System.out.println(fact(5));
		Random r = new Random();
		Set<String> uniqTriplets = new HashSet<>();
		for(int i=0; i<15;) {
			String s = getRandomTriplet("helloworld",r);
			if(!uniqTriplets.contains(s)) {
				System.out.println(s);
				uniqTriplets.add(s);
				i++;
			}
		}
		guessWordFromRandomTriplets(uniqTriplets);
		
		char[] set = {'a','b','c'};
		constructPowerSet(set);
		permutations(set);
		
		int ar1[] = {1, 12, 15, 26, 38};
	    int ar2[] = {2, 13, 17, 30, 45};
	    		  //{1, 12, 15, 26, 38};
	    medianTwoSortedArrays(ar1, ar2);
	    int unsorted[] = {9,2,4,1,4,6,7,3,2};
	    bubbleSort(unsorted);
	    System.out.println(Arrays.toString(unsorted));
	    printAllPossibleParanthesis(3,0,0,"");
	    int arr1[] = {1,0,2,0,0,3,4};
	    arrangeNonZeroToLeft(arr1);
	    System.out.println(lineReverseUsingStack("the boy ran"));
	    System.out.println(1^0);
	    System.out.println(1^1);
	    addTwoBinaryStrings("1100011", "10");
	    String[] animals = {"dog", "cat", "dog", "fish"};
	    uniqStable(animals);
	    System.out.println(Arrays.toString(animals));
	    printBinary(65);
	    System.out.println(printBinaryRecursive(65));
		
		Map<Character, Character> openCloseMap = new HashMap<>();
		openCloseMap.put('{', '}');
		openCloseMap.put('[', ']');
		openCloseMap.put('(', ')');
		
		System.out.println(isParanthesisInOrder("[{()}]", openCloseMap));
		System.out.println(isParanthesisInOrder("()[]{}", openCloseMap));
		System.out.println(isParanthesisInOrder("([)]", openCloseMap));
		System.out.println(isParanthesisInOrderBeauty("[{()}]"));
		System.out.println(isParanthesisInOrderBeauty("()[]{}"));
		System.out.println(isParanthesisInOrderBeauty("{{{{{{{{{{}}}}}}}}}}"));
		
		LinkedNode node1 = new LinkedNode(11);
		node1.next = new LinkedNode(12);
		node1.next.next = new LinkedNode(13);
		node1.next.next.next = new LinkedNode(14);
		node1.next.next.next.next = new LinkedNode(15);
		
		LinkedNode node2 = new LinkedNode(21);
		node2.next = new LinkedNode(22);
		node2.next.next = new LinkedNode(23);
		node2.next.next.next = new LinkedNode(24);
		node2.next.next.next.next = new LinkedNode(25);
		
		
		LinkedNode node3 = new LinkedNode(31);
		node3.next = new LinkedNode(32);
		node3.next.next = new LinkedNode(33);
		node3.next.next.next = new LinkedNode(34);
		node3.next.next.next.next = new LinkedNode(35);
		
		List<LinkedNode> linkedNodeList = new ArrayList<>();
		linkedNodeList.add(node);
		linkedNodeList.add(node1);
		linkedNodeList.add(node2);
		linkedNodeList.add(node3);
		
		mergeKSortedLinkedLists(linkedNodeList);
		iterativeReverse(node2);
		recursiveReverse(null, node3);
		System.out.println();
		LinkedNode revNode1 = recursiveReverseBetter(node1);
		printListNodeonly(revNode1);
		int[] pArr = {1,2,3};
		constructProductArr(pArr);
		
		ListOfLists<Integer> lists = new ListOfLists<>();
		
		List<Integer> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		
		list1.add(4);
		list1.add(5);
		list1.add(6);
		
		list2.add(7);
		list2.add(8);
		list2.add(9);
		
		lists.add(list);
		lists.add(list1);
		lists.add(list2);
		
		Iterator<Integer> iterator = lists.iterator();
		System.out.println("traversing the iterator... ");
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
			//iterator.remove();
		}
		System.out.println("Count and Say.....");
		for(int i=1; i<=5; i++) {
			System.out.print(countAndSay(i)+" ");
		}
	}
	
	static int countAndSay(int n) {
		if(n <= 0)
			return 0;
		
		if(n == 1)
			return 1;
		
		return count(countAndSay(n-1));
	}
	
	private static int count(int n) {
		if(n <=0 )
			return 0;
		
		String s = "";		
		int prev_x = 0;
		int count = 0;
		
		while(n > 0) {
			int x = n % 10;
			if(prev_x == 0) {
				prev_x = x;
				count = 1;
			} else {
				if(prev_x == x) {
					count++;
				} else {
					s = count+""+prev_x+s;
					count = 1;
					prev_x = x;
				}
			}
			n = n /10;
		}
		s = count+""+prev_x + s;
		return Integer.parseInt(s.toString());
	}
	
	// return array of products of remaining n-1 nums for every i
	// linear time
	// (1,2,3) => (6,3,2)
	static void constructProductArr(int arr[]) {
		int[] p1 =  new int[arr.length];
		int[] p2 = new int[arr.length];
		
		int p = 1;
		for(int i=0; i<p1.length; i++) {
			p1[i] = p;
			p = p*arr[i];
		}
		
		p = 1;
		for(int i=arr.length-1; i>=0; i--) {
			p2[i] =  p;
			p = p*arr[i];
		}
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = p1[i] * p2[i];
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	
	static LinkedNode recursiveReverseBetter(LinkedNode node) {
		if(node == null)
			return null;
		
		if(node.next == null)
			return node;
		
		LinkedNode next = node.next;
		node.next = null;
		LinkedNode reversedList = recursiveReverseBetter(next);
		next.next = node;
		return reversedList;
	}
	
	
	static LinkedNode head = null;
	
	static void recursiveReverse(LinkedNode prev, LinkedNode node) {
		if(node == null)
			return;
		
		if(node.next == null) {
			head = node;
			node.next = prev;
		} else { 
			recursiveReverse(node, node.next);
			node.next = prev;
		}

	}
	
	static void iterativeReverse(LinkedNode node) {
		if(node == null)
			return;
		
		LinkedNode next = node.next;
		LinkedNode nextNext = null;
		node.next = null;
		
		while(next != null) {
			nextNext = next.next;
			next.next = node;
			node = next;
			next = nextNext;
		}
		
		printListNodeonly(node);
	}
	
	static void mergeKSortedLinkedLists(List<LinkedNode> list) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(10, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 < o2)
					return -1;
				else if(o1 > o2)
					return 1;
				else
					return 0;
			}
		});
		
		for(int i=0; i<list.size(); i++) {
			LinkedNode node = list.get(i);
			while(node!= null) {
				queue.add(node.value);
				node = node.next;
			}
		}
		
		System.out.println(Arrays.toString(queue.toArray()));
	}
	
	static boolean isParanthesisInOrderBeauty(String str) {
		int prevLen = -1;
		while(str.length() != prevLen) {
			prevLen = str.length();
			str =str.replace("{}", "").replace("()", "").replace("[]", "");
		}
		return str.isEmpty();
	}
	
	static boolean isParanthesisInOrder(String str, Map<Character, Character> openCloseMap) {
		
		Stack<Character> stack = new Stack<>();
		char carr[] = str.toCharArray();
		for(char c: carr) {
			if(openCloseMap.containsKey(c)) {
				stack.push(c);
			} else { 
				if(stack.size() == 0)
					return false;
				
				char lastOpen = stack.pop();
				if(!openCloseMap.containsKey(lastOpen)) 
					return false;
				
				char expectedClose = openCloseMap.get(lastOpen);
				if(c != expectedClose)
					return false;
			}
		}
		
		return true;
	}
	
	
	static String printBinaryRecursive(int num) {
		if(num == 0)
			return "";
		
		return  printBinaryRecursive(num >> 1) + (num & 1);
		
	}
	
	static void printBinary(int num) {
		String res = "";
		while(num != 0) {
			res = (num & 1) + res;
			num = num >> 1;
		}
		System.out.println(res);
	}
	
	static void uniqStable(String[] animals) {
		int w = 0;
		Set<String> set = new HashSet<>();
		for(int i=0; i<animals.length; i++) {
			if(!set.contains(animals[i])) {
				set.add(animals[i]);
				animals[w++] = animals[i];
			}
		}
		for(; w<animals.length; w++) {
			animals[w] = null;
		}
	}
	
	static void addTwoBinaryStrings(String s1, String s2) {
		
		if(s1.length() != s2.length()) {
			if(s1.length() > s2.length()) {
				String temp = s1;
				s1 = s2;
				s2 = temp;
			}
			
			// s1 is smaller length in case lengths are diff
			int numOfZeroes = s2.length()-s1.length();
			while(numOfZeroes > 0) {
				s1 = "0" + s1;
				numOfZeroes--;
			}
		}
		String res = "";
		int carry = 0;
		Map<Character, Integer> map = new HashMap<>();
		map.put('0', 0);
		map.put('1', 1);
		
		for(int i=s1.length()-1; i>=0; i--) {
			res = ( map.get(s1.charAt(i)) ^ map.get(s2.charAt(i)) ^ carry) + res;
			carry = (map.get(s1.charAt(i)) & map.get(s2.charAt(i)) |  
					(map.get(s1.charAt(i)) & carry) | (map.get(s2.charAt(i)) & carry));
		}
		
		res = carry + res;
		System.out.println(res);
		
	}
	
	static String lineReverseUsingStack(String str) {
		Stack<Character> stack = new Stack<>();
		String res = "";
		char c[] = str.toCharArray();
		for(int i=0; i<c.length; i++) {
			stack.push(c[i]);
		}
		
		for(int i=0; i<c.length; i++) {
			res = res + stack.pop();
		}
		
		return res;
	}
	
	static String lineReverse(String str) {
		char c[] = str.toCharArray();
		int start = 0;
		for(int i=0; i<c.length; i++) {
			if(c[i] == ' ') {
				charReverse(c, start, i-1);
				start = i+1;
			}
		}
		if(start != c.length-1) {
			charReverse(c, start, c.length-1);
		}
		return new String(c);
	}
	
	static void charReverse(char c[], int begin, int end) {
		while(begin != end) {
			swap(c,begin,end);
			begin ++;
			end--;
		}
	}
	
	static void arrangeNonZeroToLeft(int arr[]) {
		int w = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != 0) {
				arr[w++] = arr[i];
			}
		}
		for(; w<arr.length; w++) {
			arr[w] = 0;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	
	static char OPEN = '(';
	static char CLOSE = ')';
	
	static void printAllPossibleParanthesis(int num, int open, int close, String str) {
		if(num == 0)
			return;
		
		if(num == open && num == close) {
			System.out.println(str);
			return;
		}
		if(open < num) {
			printAllPossibleParanthesis(num, open+1, close, str + OPEN);
			if(close < open) 
				printAllPossibleParanthesis(num, open, close+1, str + CLOSE);
		} else {
			printAllPossibleParanthesis(num, open, close+1, str+ CLOSE);
		}
	}
	
	static void bubbleSort(int arr[]) {
		if(arr.length == 1)
			return;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=1; j<arr.length; j++) {
				if(arr[j-1] > arr[j]) {
					swap(arr, j, j-1);
				}
			}
			System.out.println(Arrays.toString(arr));
		}
	}
	
	static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	static void insertionSort(int arr[]) {
		if(arr.length == 1)
			return;
		
		for(int i=1; i<arr.length; i++) {
			int temp = arr[i];
			int j = i-1;
			for(; j >= 0 && arr[j] > temp; j-- ) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp;
		}
	}
	
	static void medianTwoSortedArrays(int a[], int b[]) {
		System.out.println(median(a, b, 0, a.length-1, 0, b.length));
	}
	
	static int median(int a[], int b[], int a1, int a2, int b1, int b2) {
		
		if(a2-a1 == 1 && b2-b1 == 1) {
			return (Math.max(a[a1], b[b1]) + Math.min(a[a2], b[b2]) )/2;
		}
		
		int mid_a = (a1 + a2)/2;
		int mid_b = (b1 + b2)/2;
		
		if(a[mid_a] == b[mid_b]) {
			return a[mid_a];
		}
		
		if(a[mid_a] < b[mid_b]) {
			return median(a, b, mid_a, a2, b1, mid_b);
		} else { 
			return median(a, b, a1, mid_a, mid_b, b2);
		}
	}
	
	static void permutations(char[] set) {
		printPermutations(set, 0);
	}
	
	static void printPermutations(char[] set, int index) {
		if(index == set.length) {
			System.out.println(Arrays.toString(set));
			return;
		}
		for(int i=index; i<set.length; i++) {
			swap(set, i, index);
			printPermutations(set, index+1);
			swap(set, i, index);
		}
	}
	
	static void swap(char c[], int a ,int b) {
		char temp = c[a];
		c[a] = c[b];
		c[b] = temp;
	}
	
	static void constructPowerSet(char[] set) {
		boolean[] marker = new boolean[set.length];
		powerSet(set, marker, 0);
	}
	
	static void powerSet(char[] set, boolean[] marker, int start) {
		if(start == set.length) {
			System.out.print("{");
			for(int i=0; i<marker.length; i++) {
				if(marker[i]) {
					System.out.print(set[i]+" ");
				}
			}
			System.out.println("}");
			return;
		}
		
		marker[start] = false;
		powerSet(set, marker, start+1);
		marker[start] = true;
		powerSet(set, marker, start+1);
	}
	
	static void guessWordFromRandomTriplets(Set<String> uniqTriplets) {
		
	}
	
	static int fact(int n) {
		if(n == 0)
			return 1;
		else
			return n * fact(n-1);
	}
	
	
	static String getRandomTriplet(String str, Random r) {
		String s = "";
		int lastIndex = 0;
		int indexes[] = new int[3];
		int len = str.length();
		int i = 0;
		while(i<3) {
			int randVal = r.nextInt();
			int index = lastIndex + (randVal % (len - 2 - lastIndex));
			if(index > lastIndex && index < str.length()) {
				indexes[i++] = index;
				lastIndex = index;
				len++;
			}
		}
		for(i=0; i<indexes.length; i++) {
			s = s+str.charAt(indexes[i]);
		}
		return s;
	}
	
	
	static void cloneLinkedListEfficient(LinkedNode node) {
		LinkedNode copyList = null, tempCopy = null;
		LinkedNode temp = node;
		while(temp != null) {
			LinkedNode copy = new LinkedNode(temp.value);
			copy.next = temp.next; 
			temp.next = copy;
			temp = copy.next;
		}
		temp = node;
		while(temp != null) {
			temp.next.random = temp.random.next;
			temp = temp.next.next;
		}
		temp = node; 
		while(temp != null ) {
			if(copyList == null) {
				copyList = temp.next;
				tempCopy = copyList;
			} else { 
				tempCopy.next = temp.next;
				tempCopy = tempCopy.next;
			}
			temp.next = temp.next.next;
			temp = temp.next;
		}
		System.out.println("------- original -------------");
		printList(node);
		System.out.println("------- copy ----------");
		printList(copyList);
	}
	
//	Given any combination of the mapping numbers as string, return the number of ways in which the input string can be split into sub-strings and represented as character strings. For e.g. given 
//			"111" -> "AAA", "AK", "KA" -> 3 
//			Valid combinations are ({1,1,1}, {1,11},{11,1}) = 3 
//			"11" -> "AA", "K" -> 2 
//			Valid combinations are ({1,1},{11}) = 2 
//			"123" -> "ABC", "LC", "AW" -> 3 
//			Valid combinations are ({1,2,3},{1,23},{12,3}) = 3 
	
	static void allPossibleMappings(String str) {
		Map<Integer, Character> map = new HashMap<>();
		for(int i=0; i<26; i++) {
			map.put(i+1, (char)('A'+i));
		}
		mappings(map, str, 0, "");
	}
	
	static void mappings(Map<Integer, Character> map, String str, int start, String res) {
		if(start  == str.length()) {
			System.out.println(res);
			return;
		}
		for(int i=1; i + start <= str.length(); i++) {
			if(map.containsKey(Integer.parseInt(str.substring(start, start+i)))) {
				mappings(map, str, start+i, new String(res+map.get(Integer.parseInt(str.substring(start, start+i)))));
			}
			else { 
				return;
			}
		}
	}
	
	
//	You're given an array of integers(eg [3,4,7,1,2,9,8]) Find the index of values that satisfy A+B = C + D, where A,B,C & D are integers values in the array. 
//
//	Eg: Given [3,4,7,1,2,9,8] array 
//	The following 
//	3+7 = 1+ 9 satisfies A+B=C+D 
//	so print (0,2,3,5)
	
	static class TwoSet {
		int a;
		int b;
		public TwoSet(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	
	static void findSetsThatSatisfy(int arr[]) {
		Map<Integer, List<TwoSet>> map = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				int sum = i+j;
				if(map.containsKey(sum)) {
					List<TwoSet> list = map.get(sum);
					for(TwoSet set : list) {
						System.out.println("("+i+","+j+","+set.a+","+set.b+")");
					}
					list.add(new TwoSet(i, j));
				} else { 
					List<TwoSet> list = new ArrayList<>();
					list.add(new TwoSet(i, j));
					map.put(sum, list);
				}
			}
		}
	}
	
	
	static void cloneLinkedList(LinkedNode node) {
		Map<LinkedNode, LinkedNode> map = new HashMap<>();
		LinkedNode cloneList = null;
		LinkedNode cloneStart = null;
		LinkedNode temp = node;
		while(temp != null) {
			if(cloneList == null) {
				cloneList = new LinkedNode(temp.value);
				map.put(temp, cloneList);
				if(map.containsKey(temp.random)) {
					cloneList.random = map.get(temp.random);
				} else {
					cloneList.random = new LinkedNode(temp.random.value);
					map.put(temp.random, cloneList.random);
				}
				cloneStart = cloneList;
			} else {
				if(map.containsKey(temp)) {
					cloneList.next = map.get(temp);
				} else {
					cloneList.next = new LinkedNode(temp.value);
					map.put(temp, cloneList.next);
				}
				
				if(map.containsKey(temp.random)) {
					cloneList.next.random = map.get(temp.random);				
				} else {
					cloneList.next.random = new LinkedNode(temp.random.value);
					map.put(temp.random, cloneList.next.random);
				}
				cloneList = cloneList.next;
			}
			temp = temp.next;
		}
		
		printList(node);
		System.out.println();
		printList(cloneStart);
 		
	}
	
	static void constructRandomList(LinkedNode node) {
		LinkedNode currNode = node;
		LinkedNode randomNode = null; 
		LinkedNode currRandom = null;
		List<LinkedNode> list = new ArrayList<>();
		
		while(currNode != null) {
			list.add(currNode.random);
			currNode = currNode.next;
		}
		
		for(int i=0; i<list.size(); i++) {
			if(randomNode == null) {
				randomNode = list.get(i);
				currRandom = randomNode;
			} else {
				currRandom.next = list.get(i);
				currRandom = currRandom.next;
			}
		}
		currRandom.next = null;
		printList(randomNode);
	}
	
	static void printListNodeonly(LinkedNode node) {
		LinkedNode temp = node;
		while(temp != null) {
			System.out.print(temp.value+" -> ");
			temp = temp.next;
		}
	}
	static void printList(LinkedNode node) {
		LinkedNode temp = node;
		while(temp != null) {
			System.out.print(temp.value+" -> ");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("Random....");
		temp = node;
		while(temp != null) {
			System.out.print(temp.random.value+" -> ");
			temp = temp.next;
		}
	}
	
	
//	dictionary: "world", "hello", "super", "hell" 
//	key: "helloworld" --> return true 
//	key: "superman" --> return false 
//	key: "hellohello" --> return true
	
	static boolean isWordConcatOfTwoStrings(Set<String> dictionary, String word) {
		
		int start = 1;
		while(start < word.length()-1) {
			if(dictionary.contains(word.substring(0, start+1)) && dictionary.contains(word.substring(start+1,word.length())))
				return true;
			start++;
		}
		return false;
	}
	
	static boolean isEditDistance(String s1, String s2, int num) {
		return editDistance(s1, s2) == num;
	}
	
	static int editDistance(String s1, String s2) {
		if(s1.isEmpty() || s2.isEmpty()) {
			return Math.abs(s1.length() - s2.length());
		}
		
		if(s1.charAt(0) == s2.charAt(0)) {
			return editDistance(s1.substring(1), s2.substring(1));
		} else {
			return 1 + Math.min(Math.min(editDistance(s1.substring(1), s2), editDistance(s1, s2.substring(1))), editDistance(s1.substring(1), s2.substring(1)));
		}
	}
	
	static class Pairs { 
		int num1;
		int num2;
		public Pairs(int num1, int num2) {
			this.num1 = num1;
			this.num2 = num2;
		}
		
		@Override
		public String toString() {
			return "("+num1+":"+num2+")";
		}
	}
	
	static void findPairsToDoubleSquareEfficient(int num) {
		int sqrt = (int) Math.sqrt(num);
		int start = 1;
		int sum = 0;
		List<Pairs> list = new ArrayList<>();
		while(start < sqrt) {
			sum = sqrt*sqrt + start*start;
			if(sum == num) {
				list.add(new Pairs(start, sqrt));
				start++;
				sqrt--;
			} else if(sum > num) {
				sqrt--;
			} else {
				start++;
			}
		}
		System.out.println(list.size());
		System.out.println(Arrays.toString(list.toArray()));
	}
	
	
	static void findPairsToDoubleSquare(int num) {
		Set<Double> set = new HashSet<>();
		for(double i=1; i<num; i++)
			set.add(i);
		
		List<Pairs> list = new ArrayList<>();
		int sqrt = (int) Math.sqrt(num);
		while(sqrt >= 0) {
			double square = sqrt * sqrt;
			if(set.contains(num-square)) {
				if(set.contains(Math.sqrt(num-square))) {
					list.add(new Pairs(sqrt, (int)Math.sqrt(num-square)));
				}
			}
			sqrt--;
		}
		
		System.out.println(Arrays.toString(list.toArray()));
	}
	
//	0: 1 
//	1: 11 
//	2: 21 
//	3: 1211 
//	4: 111221 
//	5: 312211 
	
	static int findPattern(int i) {
		if(i == 0)
			return 1;
		
		return countOf(findPattern(i-1),0);
	}
	
	static int countOf(int pattern, int level) {
		int count = 1;
		int num = pattern % 10;
		int temp = num;
		while(temp == num && temp != 0) {
			pattern = pattern / 10;
			temp = pattern % 10;
			if(temp == num)
				count++;
		}
		
		int pat = (int) ((count*10 + num) * Math.pow(10,level));
		if(temp == 0)
			return pat;
		else {
			return countOf(pattern, level+2) + pat;
		}
		
	}
	
	static void findNPrintOrderOfChars(String words[]) {
		Map<Character, List<Character>> map  = new HashMap<Character, List<Character>>();
		char firstChar = '\0';
		for(int i=1; i<words.length; i++) {
			Map<Character, Character> charMap = getOneOrderTwoWords(words[i-1].toCharArray(), words[i].toCharArray());
			Iterator<Character> set = charMap.keySet().iterator();
			while(set.hasNext()) {
				char key = set.next();
				if(firstChar == '\0')
					firstChar = key;
				if(map.containsKey(key)) {
					map.get(key).add(charMap.get(key));
					map.put(key, map.get(key));
				} else {
					List<Character> list = new ArrayList<>();
					list.add(charMap.get(key));
					map.put(key, list);
				}
				
				if(!map.containsKey(charMap.get(key))) {
					map.put(charMap.get(key), new ArrayList<Character>());
				}
			}
		}
		
		if(firstChar == '\0')
		{
			System.out.println("No order found");
			return;
		}
		
		System.out.println(Arrays.toString(returnOrderOfChars(map, firstChar).toArray()));
		
	}
	
	static List<Character> returnOrderOfChars(Map<Character, List<Character>> map, char firstChar) {
		List<Character> order = new ArrayList<>();
		Set<Character> nodesTraveled = new HashSet<>();
		
		order.add(firstChar);
		nodesTraveled.add(firstChar);
		
		List<Character> neighbors = map.get(firstChar);
		for(int i=0; neighbors != null && i<neighbors.size(); i++) {
			if(!dfs(map, nodesTraveled, order, neighbors.get(i))) {
				continue;
			}
			else
				break;
		}
		return order;
	}
	
	static boolean dfs(Map<Character, List<Character>> graph, Set<Character> nodesTraveled, 
			List<Character> orderChars, char currentNode) {

		
		if(nodesTraveled.contains(currentNode)) {
			return false;
		}
		
		nodesTraveled.add(currentNode);
		orderChars.add(currentNode);
		
		if(nodesTraveled.size() == graph.size()) {
			return true;
		}
		
		List<Character> neighbors = graph.get(currentNode);
		for(int i=0; neighbors != null && i<neighbors.size(); i++) {
			if(!dfs(graph, nodesTraveled, orderChars, neighbors.get(i))) {
				continue;
			}
			else
				return true;
			
		}
		nodesTraveled.remove(currentNode);
		orderChars.remove(orderChars.size()-1);
		return false;
		
	}
	
	
	
	static Map<Character, Character> getOneOrderTwoWords(char[] c1, char[] c2) {
		Map<Character, Character> map = new HashMap<>();
		for(int i=0; i<c1.length && i<c2.length; i++) {
			if(c1[i] != c2[i]) {
				map.put(c1[i], c2[i]);
				break;
			}
		}
		return map;
	}

}

class ListOfLists<T> implements Iterable<T> {
	
	private List<List<T>> lists ;
	
	public ListOfLists() {
		this.lists = new ArrayList<>();
	}
	
	public void add(List<T> list) {
		lists.add(list);
	}
	
	@Override
	public Iterator<T> iterator() {
		
		return new Iterator<T>() {

			int currentList = 0;
			int currentRemoveList = 0;
			
			Iterator<T> iterator; 
			Iterator<T> removeIterator;
			
			@Override
			public boolean hasNext() {
				if(lists.size() == 0) {
					return false;
				}
				
				if(currentList >= lists.size()) {
					return false;
				}
				
				if(iterator == null) {
					iterator = lists.get(currentList).iterator();
				}
				
				if(!iterator.hasNext()) {
					currentList++;
					iterator = null;
					return hasNext();
				}
				
				return iterator.hasNext();
					
			}

			@Override
			public T next() {
				
				if(hasNext()) {
					return iterator.next();
				}
				return null;
			}
			
			public boolean hasNextRemove() {
				if(lists.size() == 0) {
					return false;
				}
				
				if(currentRemoveList >= lists.size()) {
					return false;
				}
				
				if(removeIterator == null) {
					removeIterator = lists.get(currentList).iterator();
				}
				
				if(!removeIterator.hasNext()) {
					currentRemoveList++;
					return hasNextRemove();
				} else {
					return removeIterator.hasNext();
				}
					
			}

			@Override
			public void remove() {
				
				if(hasNextRemove()) 
					removeIterator.remove();
				
			}
		};
	}
	
}


class LinkedNode { 
	int value;
	LinkedNode next;
	LinkedNode random;
	public LinkedNode(int value) {
		this.value = value;
	}
}
