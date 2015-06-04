package careerCup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class CareerCupLinkedin {

	public static void main(String args[]) throws IOException {
		Triangle triangle = new TriangleImpl();
		int arr[] = {6,7,12,5,10,4};
		System.out.println(Arrays.toString(triangle.getTriangleSides(arr)));
		
		//Child Parent IsLeft 
		//15 20 true 
		//19 80 true 
		//17 20 false 
		//16 80 false 
		//80 50 false 
		//50 null false 
		//20 50 true 
		
		ChildParentProblem problem = new ChildParentProblem();
		problem.add(15, 20, true);
		problem.add(19, 80, true);
		problem.add(17, 20, false);
		problem.add(16, 80, false);
		problem.add(80, 50, false);
		problem.add(50, 0, false);
		problem.add(20, 50, true);
		
		problem.inOrder();
		
		TwoSum sum = new TwoSumImpl();
		sum.store(1);
		sum.store(4);
		sum.store(19);
		sum.store(11);
		sum.store(0);
		sum.store(7);
		sum.store(4);
		sum.store(6);
		System.out.println(sum.test(11));
		
		String[] s1 = {"5", "80", "40", "/", "+"};
		String[] s2 = {"4", "1", "+", "2.5", "*"};
		
		CareerCupLinkedin cup = new CareerCupLinkedin();
		cup.reversePolishNotation(s1);
		cup.reversePolishNotation(s2);
		
		int rs1[] = {3, 4, 5, 1, 2};
		int rs2[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		int rs3[] = {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1};
		int rs4[] = {2, 3, 0, 2, 2, 2, 2, 2, 2, 2};
		int rs5[] = {1, 2, 3, 4};
		System.out.println("****** rotated sorted arr *****");
		System.out.println(cup.rotatedSortedArr(rs1, 1) + "-"+cup.rotatedSortedArrPivot(rs1,1));
		System.out.println(cup.rotatedSortedArr(rs1, 3)+"-"+cup.rotatedSortedArr(rs1, 3));
		System.out.println(cup.rotatedSortedArr(rs2, 3)+"-"+cup.rotatedSortedArr(rs2, 3));
		System.out.println(cup.rotatedSortedArr(rs3, 0)+"-"+cup.rotatedSortedArr(rs3, 0));
		System.out.println(cup.rotatedSortedArr(rs4, 3)+"-"+cup.rotatedSortedArr(rs4, 3));
		System.out.println(cup.rotatedSortedArr(rs5, 3)+"-"+cup.rotatedSortedArr(rs5, 3));
		
		int[] tri = {9,8,10,7};
		System.out.println(cup.getTriangleTriplets(tri).toString());
		
		int[] values = {4,1,2,3,4,5,6,5,4,3,4,4,4,4,4,4,4};
		System.out.println(Interview.maxLengthPalindrome(values));
		
		NestedInteger integer1 = new NestedIntegerImpl(1);
		List<NestedInteger> list = new ArrayList<>();
		list.add(integer1);
		list.add(integer1);
		
		NestedInteger integer = new NestedIntegerImpl(list);
		
		NestedInteger integer2 = new NestedIntegerImpl(2);
		
		List<NestedInteger> superlist = new ArrayList<>();
		superlist.add(integer);
		superlist.add(integer2);
		superlist.add(integer);
		
		NestedInteger mainNestedInteger = new NestedIntegerImpl(superlist);
		System.out.println("*** NEST ***");
		System.out.println(mainNestedInteger.solve());
		
		// {1,{4,{6}}}
		
		NestedInteger nestedInteger4 = new NestedIntegerImpl(4);
		NestedInteger nestedInteger6 = new NestedIntegerImpl(6);
		
		List<NestedInteger> list6 = new ArrayList<>();
		list6.add(nestedInteger6);
		
		NestedInteger nestedIntegerList6 = new NestedIntegerImpl(list6);
		
		List<NestedInteger> l46 = new ArrayList<>();
		l46.add(nestedInteger4);
		l46.add(nestedIntegerList6);
		NestedInteger nestedIntegerList46 = new NestedIntegerImpl(l46);
		
		List<NestedInteger> l146 = new ArrayList<>();
		l146.add(integer1);
		l146.add(nestedIntegerList46);
		
		NestedInteger main = new NestedIntegerImpl(l146);
		System.out.println(main.solve());
		
		int[] num1234 = {1,1,2,2};
		System.out.println(cup.numberOfSequences(num1234));
		
		BinaryNode node = new BinaryNode(1);
		node.left = new BinaryNode(2);
		node.right = new BinaryNode(3);
		node.left.left = new BinaryNode(4);
		node.left.right = new BinaryNode(5);
		node.left.left.left = new BinaryNode(6);
		node.left.left.right = new BinaryNode(7);
		cup.inOrder(cup.flipTreeUpsideDown(node));

		String[] sarr = {"aghkafgklt", "dfghako", "qwemnaarkf"};
		System.out.println(cup.countOfCommonChars(sarr));
		
		String words[] = {"the", "quick", "brown", "fox", "quick"};
		WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList(words));
		System.out.println(finder.distance("fox", "the"));
		System.out.println(finder.distance("quick", "fox"));
		
		Range r1 = new Range(1, 3);
		Range r2 = new Range(2, 5);
		Range r3 = new Range(8, 9);
		Range[] ranges = {r1, r2, r3};
		System.out.println("Range ==>"+cup.getRange(ranges));
		
		
		Range r4 = new Range(3, 6);
		Range r5 = new Range(8, 9);
		Range r6 = new Range(1, 5);
		Range[] ranges1 = {r4, r5, r6};
		System.out.println("Range1 ==>"+cup.getRange(ranges1));
		
		int arr1[] = {1,2,3,4,5};
		System.out.println("modifiedBS ==>"+cup.getRangeNumber(arr1, 3));
		
		String justify[] = {"aaa", "bb", "cc", "ddddd" };
		String justify1[] = {"This", "is", "an", "example", "of", "text", "justification."};
		cup.stringJustification(justify, 5);
		cup.stringJustification(justify1, 16);
		
		int input[] = {3,1,4,2};
		System.out.println(Arrays.toString(cup.selfExcludingProduct(input)));
		int perm[] = {1,2,3};
		cup.permutations(perm);
		
		PointsOnAPlane points = new PointsOnAPlaneImpl();
		points.addPoint(new Point(0, 1));
		points.addPoint(new Point(0, 2));
		points.addPoint(new Point(0, 3));
		points.addPoint(new Point(0, 4));
		points.addPoint(new Point(0, 5));
		
		System.out.println(points.findNearest(new Point(0,0), 3));
		char carr[] = {'c','f','j','p','v'};
		System.out.println(cup.smallestChar(carr, 'a'));
		System.out.println(cup.smallestChar(carr, 'c'));
		System.out.println(cup.smallestChar(carr, 'k'));
		System.out.println(cup.smallestChar(carr, 'z'));
		char carr1[] = {'c','f','k'};
		System.out.println(cup.smallestChar(carr1, 'f'));
		System.out.println(cup.smallestChar(carr1, 'c'));
		System.out.println(cup.smallestChar(carr1, 'd'));
		
		WordDistanceFinder distanceFinder = new WordDistanceFinder(Arrays.asList("hello", "how", "are", "you"));
		System.out.println(distanceFinder.distance("hello", "you"));
		 distanceFinder = new WordDistanceFinder(Arrays.asList("hello", "how", "are", "hello", "you"));
		System.out.println(distanceFinder.distance("hello", "you"));
		 distanceFinder = new WordDistanceFinder(Arrays.asList("you", "are", "hello"));
		 System.out.println(distanceFinder.distance("hello", "you"));
		 System.out.println(cup.repeatingSubString("ABCCBABCDFS", 3));
		 System.out.println(cup.longestRepeatingSubString("ATCGATCGA"));
		 
		 System.out.println(cup.areIsomorphic("turtle", "tletur"));
		 int ass[] = {2,3,2,1,5,3,7,1,5,2,2,2,5};
		 System.out.println(cup.MoreThanHalfElem(ass));
		 
		 Node ll = new Node(1);
		 ll.next = new Node(2);
		 ll.next.next = new Node(3);
		 ll.next.next.next = new Node(4);
		 ll.next.next.next.next = new Node(5);
		 ll.next.next.next.next.next = new Node(6);
		 
		 System.out.println(cup.getKthNodeFromLast(ll, 4).val);
		 System.out.println(cup.getKthNodeFromLast(ll, 6).val);
		 
		 System.out.println("*** DEPTH ***");
		 System.out.println(cup.findDepth("(00)"));
		 System.out.println(cup.findDepth("((00)0)"));
		 System.out.println(cup.findDepth("((00)(00))"));
		 System.out.println(cup.findDepth("((00)(0(00)))"));
		 System.out.println(cup.findDepth("((00)(0(0(00))))"));
		 System.out.println(cup.findDepth("x"));
		 System.out.println(cup.findDepth("0"));
		 System.out.println(cup.findDepth("()"));
		 System.out.println(cup.findDepth("(0)"));
		 System.out.println(cup.findDepth("(00)x"));
		 System.out.println(cup.findDepth("(0p)"));
		 
		 BufferedReader br = new BufferedReader(new FileReader(new File("web2")));
		 String line = null;
		 StringBuffer document = new StringBuffer();
		 while((line = br.readLine()) != null) {
			 document.append(line);
			 document.append(" ");
		 }
		 String w[] = {"document", "decide"};
		 System.out.println(cup.smallestStringContainingAllWords(document.toString(), w));
		 System.out.println();
		 
		 System.out.println(cup.validNumbers("01abc11cd10.23").toString());
		 System.out.println(cup.decimalToHex("-3523"));
		 System.out.println(Integer.toBinaryString(3523)+" - "+cup.toBinary(3523)+" - "+cup.toUnsignedIntegerString(187, 4));
		 
		 int[] lis = {1,2,5,-1,9,2,4,7,3,8};
		 cup.longestIncrSeq(lis);
		 
		int set1[] = {1, 7, 10, 13, 14, 19};
	    int set2[] = {1, 7, 10, 15, 27, 29};
	    int set3[] = {2, 4, 6, 8, 10};
	    cup.longestIncrSeqInAP(set1);
	    cup.longestIncrSeqInAP(set2);
	    cup.longestIncrSeqInAP(set3);
	    
	    System.out.println(cup.lenghtOfLongestAP(set1, set1.length));
	    System.out.println(cup.lenghtOfLongestAP(set2, set2.length));
	    System.out.println(cup.lenghtOfLongestAP(set3, set3.length));
		
	    System.out.println(cup.longestPalindrome("abacdgfdcaba"));
	    System.out.println(cup.canIWin(15, 100));
	    
	    
	}
	
	public String longestPalindrome(String s) {
		if(s == null || s.isEmpty() || s.length() == 1 || s.length() == 2)
			return s;
		
		int len = s.length();
		char c[] = s.toCharArray();
		boolean[][] table = new boolean[len+1][len+1];
		int maxLen = 1;
		int st=0, en=0;
		for(int i=0; i<len; i++) {
			table[i][i] = true;
		}
		
		for(int i=1; i<len; i++) {
			if(c[i-1] == c[i]) {
				table[i-1][i] = true;
				maxLen = 2;
				st = i-1; en = i;
			}
		}
		
		for(int l=3; l<=len; l++) {
			for(int i=0; i+l<c.length; i++) {
				int j = i + (l -1);
				if(c[i] == c[j] && table[i+1][j-1]) {
					table[i][j] = true;
					maxLen = l;
					st = i;
					en = j;
				}
			}
		}
		System.out.println("Max Len Palin => "+maxLen);
		return s.substring(st, en+1);
	}
	
	int lenghtOfLongestAP(int set[], int n)
	{
	    if (n <= 2)  return n;
	 
	    // Create a table and initialize all values as 2. The value of
	    // L[i][j] stores LLAP with set[i] and set[j] as first two
	    // elements of AP. Only valid entries are the entries where j>i
	    int L[][] = new int[n][n];
	    int llap = 2;  // Initialize the result
	 
	    // Fill entries in last column as 2. There will always be
	    // two elements in AP with last number of set as second
	    // element in AP
	    for (int i = 0; i < n-1; i++)
	        L[i][n-1] = 2;
	 
	    // Consider every element as second element of AP
	    for (int j=n-2; j>=1; j--)
	    {
	        // Search for i and k for j
	        int i = j-1, k = j+1;
	        while (i >= 0 && k <= n-1)
	        {
	           if (set[i] + set[k] < 2*set[j])
	               k++;
	 
	           // Before changing i, set L[i][j] as 2
	           else if (set[i] + set[k] > 2*set[j])
	           {   L[i][j] = 2; i--;   }
	 
	           else
	           {
	               // Found i and k for j, LLAP with i and j as first two
	               // elements is equal to LLAP with j and k as first two
	               // elements plus 1. L[j][k] must have been filled
	               // before as we run the loop from right side
	               L[i][j] = L[j][k] + 1;
	 
	               // Update overall LLAP, if needed
	               llap = Math.max(llap, L[i][j]);
	 
	               // Change i and k to fill more L[i][j] values for
	               // current j
	               i--; k++;
	           }
	        }
	 
	        // If the loop was stopped due to k becoming more than
	        // n-1, set the remaining entties in column j as 2
	        while (i >= 0)
	        {
	            L[i][j] = 2;
	            i--;
	        }
	    }
	    return llap;
	}
	
	// my code vs geeks4geeks abv
	public void longestIncrSeqInAP(int[] arr) {
		if(arr.length <= 2) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		int[][] res = new int[arr.length][arr.length];
		int maxLen = 2;
		for(int i=0; i<arr.length-1; i++) {
			res[i][arr.length-1] = 2;
		}
		
		for(int j=arr.length-2; j>=0; j--) {
			int i = j-1;
			int k = j+1;
			while(i >= 0 && k <= arr.length-1) {
				if(arr[i] + arr[k] == 2*arr[j]) {
					res[i][j] = res[j][k] + 1;
					maxLen = Math.max(maxLen, res[i][j]);
					i--;
					k++;
				} else if(arr[i] + arr[k] > 2*arr[j]) {
					res[i][j] = 2;
					i--;
				} else {
					k++;
				}
			}
			
			while(i>0) {
				res[i][j] = 2;
				i--;
			}
		}
		
		
		System.out.println("Max len => "+maxLen);
	}
	
	
	
	public void longestIncrSeq(int[] arr) {
		int[] len = new int[arr.length];
		int[] seq = new int[arr.length];
		int maxLen = 1;
		int maxLenIndex = 0;
		
		for(int i=0; i<arr.length; i++) {
			len[i] = 1;
			seq[i] = i;
			int j = 0;
			while(j < i) {
				if(arr[j] < arr[i] && len[j] + 1 > len[i]) {
					len[i] = 1 + len[j];
					seq[i] = j;
					if(len[i] > maxLen) {
						maxLen = len[i];
						maxLenIndex = i;
					}
				}
				j++;
			}
		}
		
		int[] res = new int[maxLen];
		for(int i=res.length-1; i>= 0; i--) {
			res[i] = arr[maxLenIndex];
			maxLenIndex = seq[maxLenIndex];
		}
		
		System.out.println(Arrays.toString(res));
	}
	
	public String toUnsignedIntegerString(int num, int shift) {
		char[] res = new char[32];
		int index = res.length-1;
		int radix = 1 << shift;
		int mask = radix - 1;
		do {
			res[index--] = (char) ((num & mask) + '0');
			num = num >>> shift;
		} while(num != 0);
		
		return new String(res, index+1, res.length - (index+1));
	}
	
	public String toBinary(int num) {
		char c[] = new char[32];
		int index = c.length-1;
		while(num > 0) {
			c[index--] = (char)((num & 1) + '0');
			num = num >>> 1;
		}
		return new String(c, index+1, c.length-(index+1));
	}
	
	public String decimalToHex(String s) {
		return Integer.toHexString(Integer.parseInt(s));
	}
	
	public List<Double> validNumbers(String s) {
		List<Double> list = new ArrayList<>();
		
		if(s == null || s.isEmpty())
			return list;
		
		char c[] = s.toCharArray();
		for(int i=0; i<c.length; i++) {
			if(c[i] >= '0' && c[i] <= '9') {
				double num = 0;
				boolean floating = false;
				int afterPoint = 0;
				while( i < c.length && ((c[i] >= '0' &&  c[i] <= '9') || (c[i] == '.'))) {
					if(c[i] != '.') {
						num = num*10 + (c[i] - '0');
						if(floating)
							afterPoint++;
					} else {
						floating = true;
					}
					i++;
				}
				num =(num / (Math.pow(10, afterPoint)));
				list.add(num);
				i--;
			}
		}
		
		return list;
	}
	
	// O(n log k) operation
	
	public String smallestStringContainingAllWords(String document, String[] words) {
		int minLen = Integer.MAX_VALUE;
		int start = -1;
		
		String[] doc = document.split(" ");
		Map<String, Integer> map = new HashMap<>();
		for(String w : words) {
			map.put(w, -1);
		}
		for(int i=0; i<doc.length; i++) {
			if(map.containsKey(doc[i])) {
				// return min index can be done using a priority queue
				int minIndex = returnMinIndexExceptThisWord(map, doc[i]);
				if(minIndex != -1) {
					int len = i - minIndex;
					if(len < minLen) {
						start = minIndex;
						minLen = len;
					}
				}
				map.put(doc[i], i);
			}
		}
		
		StringBuffer buffer = new StringBuffer();
		for(int i = start; i<=start + minLen; i++) {
			buffer.append(doc[i]);
			buffer.append(" ");
		}
		return buffer.toString();
	}
	
	// if all but this word exists, then return the min index
	private int returnMinIndexExceptThisWord(Map<String, Integer> map, String word) {
		String[] keyset = map.keySet().toArray(new String[map.size()]);
		int min = Integer.MAX_VALUE;
		for(String w : keyset) {
			if(!w.equals(word)) {
				if(map.get(w) == -1)
					return -1;
				
				int index = map.get(w);
				if(index < min)
					min = index;
			}
		}
		
		return min;
	}
	
	
	
//	Consider this string representation for binary trees. Each node is of the form (lr), where l represents the left child and r represents the right child. If l is the character 0, then there is no left child. Similarly, if r is the character 0, then there is no right child. Otherwise, the child can be a node of the form (lr), and the representation continues recursively. 
//	For example: (00) is a tree that consists of one node. ((00)0) is a two-node tree in which the root has a left child, and the left child is a leaf. And ((00)(00)) is a three-node tree, with a root, a left and a right child. 
//
//	Write a function that takes as input such a string, and returns -1 if the string is malformed, and the depth of the tree if the string is well-formed. 
//
//	For instance: 
//
//	find_depth('(00)') -> 0 
//	find_depth('((00)0)') -> 1 
//	find_depth('((00)(00))') -> 1 
//	find_depth('((00)(0(00)))') -> 2 
//	find_depth('((00)(0(0(00))))') -> 3 
//	find_depth('x') -> -1 
//	find_depth('0') -> -1 
//	find_depth('()') -> -1 
//	find_depth('(0)') -> -1 
//	find_depth('(00)x') -> -1 
//	find_depth('(0p)') -> -1
	
	public int findDepth(String s) {
		Stack<Character> stack = new Stack<>();
		int maxDepth = -1;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			} else if(s.charAt(i) == ')') {
				if(stack.isEmpty() || stack.peek() != '(')
					return -1;
				if(stack.size() -1 > maxDepth)
					maxDepth = stack.size() -1;
				stack.pop();
			} else if(s.charAt(i) == '0'){
				
			} else {
				return -1;
			}
 		}
		return stack.size() == 0 ? maxDepth : -1;
	}
	
	public Node getKthNodeFromLast(Node node, int k) {
		int[] rank = new int[1];
		Node ret = getKthNodeFromLast(node, rank, k);
		if(rank[0] == k)
			return ret;
		else
			return null;
	}
	
	private Node getKthNodeFromLast(Node node, int[] rank, int k) {
		if(node == null)
			return null;
		
		Node kth = getKthNodeFromLast(node.next, rank, k);
		if(rank[0] == k)
			return kth;
		
		rank[0]++;
		return node;
	}
	
	// Moore's Voting Algorithm.. no additional storage allowed
	public int MoreThanHalfElem(int arr[]) {
	    int candidateIndex = 0;
	    int count = 1;
	    for(int i=1; i<arr.length; i++) {
	    	if(arr[i] == arr[candidateIndex])
	    		count++;
	    	else
	    		count--;
	    	
	    	if(count == 0) {
	    		candidateIndex = i;
	    		count=1;
	    	}
	    }
	    
	    count = 0;
	    for(int i=0; i<arr.length; i++) {
	    	if(arr[i] == arr[candidateIndex])
	    		count++;
	    }
	    
	    return count > Math.floor((double)arr.length/2) ? arr[candidateIndex] : -1;
	} 
	
//	Given two (dictionary) words as Strings, determine if they are isomorphic. Two words are called isomorphic 
//	if the letters in one word can be remapped to get the second word. Remapping a letter means replacing all 
//	occurrences of it with another letter while the ordering of the letters remains unchanged. No two letters 
//	may map to the same letter, but a letter may map to itself. 
//
//	Example: 
//	given "foo", "app"; returns true 
//	we can map 'f' -> 'a' and 'o' -> 'p' 
//	given "bar", "foo"; returns false 
//	we can't map both 'a' and 'r' to 'o' 
//
//	given "turtle", "tletur"; returns true 
//	we can map 't' -> 't', 'u' -> 'l', 'r' -> 'e', 'l' -> 'u', 'e' -'r' 
//
//	given "ab", "ca"; returns true 
//	we can map 'a' -> 'c', 'b'
	
	public boolean areIsomorphic(String s1, String s2) {
		if(s1 == null || s2 == null)
			return false;
		
		if(s1.length() != s2.length())
			return false;
		
		Map<Character, Character> map = new HashMap<>();
		char c1[] = s1.toCharArray();
		char c2[] = s2.toCharArray();
		
		for(int i=0; i<c1.length; i++) {
			if(!map.containsKey(c1[i]) && !map.containsKey(c2[i])) {
				map.put(c1[i], c2[i]);
				map.put(c2[i], c1[i]);
			} else {
				if(map.get(c1[i]) != c2[i] && map.get(c2[i]) != c1[i])
					return false;
			}
		}
		
		return true;
	}
	
	public String longestRepeatingSubString(String s) {
		Trie trie = new Trie();
		for(int i=s.length()-1; i>=0; i--) {
			trie.insert(s.substring(i));
		}
		for(int i=0; i<s.length(); i++) {
			trie.insert(s.substring(i));
		}
		return trie.longestRepeatingSubstring();
	}
	
	public String repeatingSubString(String s, int len) {
		
		for(int i=0; i+len <= s.length(); i++) {
			String sub = s.substring(i, i+len);
			int count = 0;
			for(int j=i+len; j< s.length(); j++) {
				if(sub.charAt(count) == s.charAt(j)) 
					count++;
				else {
					count = 0;
				}
				if(count == len) {
					return sub;
				}
			}
		}
		
		return "";
	}
	
	/** 
	* Return the smallest character that is strictly larger than the search character, 
	* If no such character exists, return the smallest character in the array 
	* @param sortedStr : sorted list of letters, sorted in ascending order. 
	* @param c : character for which we are searching. 
	* Given the following inputs we expect the corresponding output: 
	* ['c', 'f', 'j', 'p', 'v'], 'a' => 'c' 
	* ['c', 'f', 'j', 'p', 'v'], 'c' => 'f' 
	* ['c', 'f', 'j', 'p', 'v'], 'k' => 'p' 
	* ['c', 'f', 'j', 'p', 'v'], 'z' => 'c' // The wrap around case 
	* ['c', 'f', 'k'], 'f' => 'k' 
	* ['c', 'f', 'k'], 'c' => 'f' 
	* ['c', 'f', 'k'], 'd' => 'f' 
	*/
	
	private char EMPTY_CHAR = '\0';
	
	public char smallestChar(char[] arr, char c) {
		return binarySearch(arr, 0, arr.length-1, c);
	}
	
	private char binarySearch(char[] arr, int low, int high, char c) {
		if(low > high)
			return EMPTY_CHAR;
		
		int mid = (low + high) >>>1;
		if(arr[mid] == c) {
			if(mid == arr.length-1) {
				return arr[0];
			} else {
				return arr[mid+1];
			}
		} else if(arr[mid] < c) {
			char ec = binarySearch(arr, mid+1, high, c);
			if(ec != EMPTY_CHAR && ec > c)
				return ec;
			else
				return arr[0];
		} else {
			char ec = binarySearch(arr, low, mid-1, c);
			if(ec != EMPTY_CHAR && ec > c)
				return ec;
			else
				return arr[mid];
		}
	}
	
	public void permutations(int []arr) {
		permutations(arr, 0);
	}
	
	private void permutations(int[] arr, int index) {
		
		if(index == arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for(int i=index; i<arr.length; i++) {
			swap(arr, i, index);
			permutations(arr, index+1);
			swap(arr, i, index);
		}
		
	}
	
	private void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public int[] selfExcludingProduct(int[] input) {
		int p1[] = new int[input.length];
		int p2[] = new int[input.length];
		
		int p = 1;
		for(int i=0; i<input.length; i++) {
			p1[i] = p;
			p = p * input[i];
		}
		
		p = 1;
		for(int i=input.length-1; i>=0; i--) {
			p2[i] = p;
			p = p * input[i];
		}
		
		for(int i=0; i<input.length; i++) {
			input[i] = p1[i] * p2[i];
		}
		
		return input;
	}
	
	
	public void stringJustification(String[] str, int len) {
		if(len <= 0)
			return;
		
		List<String> list = new ArrayList<>();
		int totalLen = 0;
		for(int i=0; i <= str.length;) {
			
			if(i == str.length) {
				int j = 0;
				StringBuffer buffer = new StringBuffer();
				int numOfChars = 0;
				while(j < list.size()) {
					String word = list.get(j);
					if(numOfChars + word.length() <= len) {
						buffer.append(word);
						numOfChars += word.length();
						if(numOfChars == len) {
							System.out.println(buffer.toString());
							buffer = new StringBuffer();
							numOfChars = 0;
						}
						j++;
					} else {
						while(numOfChars != len) {
							buffer.append(" ");
							numOfChars++;
						}
						System.out.println(buffer.toString());
						buffer = new StringBuffer();
						numOfChars = 0;
					}
				}
				break;
			}
			
			if(totalLen > len) {
				String lastStr = list.remove(list.size()-1);
				totalLen -= lastStr.length();
				i=i-1;
				int M = len - totalLen;
				if(M == i+1) {
					String space = "  ";
					for(int j=0; j<list.size(); j++) {
						if(list.get(j).equals(" ")) {
							list.set(j, space);
						}
					}
				}
				
				if(M < i+1) {
					int temp = M;
					while(temp > 0) {
						for(int j=0; j<list.size(); j++) {
							if(list.get(j).contains(" ")) {
								list.set(j, list.get(j)+" ");
								temp--;
							}
							if(temp == 0)
								break;
						}
					}
				}
				
				if(M > i+1) {
					int addSpaces = M / (i);
					StringBuffer buffer = new StringBuffer();
					while(addSpaces > 0) {
						buffer.append(" ");
						addSpaces--;
					}
					
					for(int j=0; j<list.size(); j++) {
						if(list.get(j).equals(" ")) {
							list.set(j, " "+buffer.toString());
						}
					}
				}
				
				printLine(list);
				list = new ArrayList<>();
				totalLen = 0;
				
			} else if(totalLen == len) {
				printLine(list);
				list = new ArrayList<>();
				totalLen = 0;
			} else {
				totalLen += str[i].length();
				if(totalLen < len)
					totalLen += 1;
				
				list.add(str[i]);
				if(totalLen-1 < len)
					list.add(" ");
				i++;
			}
			
			
		}
		
	}
	
	private void printLine(List<String> list) {
		StringBuffer buffer = new StringBuffer();
		for(String s : list) {
			buffer.append(s);
		}
		System.out.println(buffer.toString());
	}
	
	public Range getRangeNumber(int[] arr, int num) {
		Range r = new Range(Integer.MAX_VALUE, Integer.MIN_VALUE);
		firstOccurrenceBinarySearch(arr, 0, arr.length-1, num, r);
		return r;
	}
	
	private void firstOccurrenceBinarySearch(int[] arr, int start, int end, int num, Range r) {
		if(start > end)
			return ;
		
		int mid = (start + end) >>> 1;
		if(arr[mid] == num) {
			if(mid == start || (mid > start && arr[mid-1] != arr[mid])) {
				if(start < r.a)
					r.a = mid;
			}
			
			if(mid == end || (mid < end && arr[mid+1] != arr[mid])) {
				if(end > r.b)
					r.b = mid;
			}
			
			if(mid < end && arr[mid+1] == arr[mid]) {
				firstOccurrenceBinarySearch(arr, mid+1, end, num, r);
			}
			
			if(mid > start && (arr[mid-1] == arr[mid])) {
				firstOccurrenceBinarySearch(arr, start, mid-1, num, r);
			}
			
		}
		
		if(num < arr[mid]) {
			firstOccurrenceBinarySearch(arr, start, mid-1, num, r);
		} else {
			firstOccurrenceBinarySearch(arr, mid+1, end, num,r );
		}
	}
	
	public int getRange(Range[] ranges) {
		Arrays.sort(ranges);
		Range res = ranges[0];
		List<Range> list = new ArrayList<>();
		for(int i=1; i<ranges.length; i++) {
			if(ranges[i].a <= res.b) {
				res.b = ranges[i].b;
			} else {
				list.add(res);
				res = ranges[i];
			}
		}
		list.add(res);
		
		int result = 0;
		for(int i=0; i<list.size(); i++) {
			result += list.get(i).b - list.get(i).a;
		}
		
		return result; 
	}
	
	public int countOfCommonChars(String[] arr) {
		
		int[] charset = new int[256];
		
		for(String s : arr) {
			Set<Character> uniq = new HashSet<>();
			for(char c : s.toCharArray()) {
				if(!uniq.contains(c)) {
					uniq.add(c);
					charset[c]++;
				}
			}
		}
		int count = 0;
		System.out.println();
		for(int i=0; i<256; i++) {
			if(charset[i] == arr.length) {
				count++;
				System.out.print((char)i);
				System.out.print(" ");
			}
		}
		
		return count;
	}
	
	public void inOrder(BinaryNode node) {
		if(node == null)
			return;
		
		inOrder(node.left);
		System.out.print(node.id+" ");
		if(node.id == 4) {
			System.out.print("");
		}
		inOrder(node.right);
	}
	
	public BinaryNode flipTreeUpsideDown(BinaryNode node) {
		if(node == null)
			return null;
		
		BinaryNode[] root = new BinaryNode[1];
		flipTreeUpsideDown(node, root);
		return root[0];
	}
	
	private BinaryNode flipTreeUpsideDown(BinaryNode node, BinaryNode[] root) {
		if(node == null)
			return null;
		
		BinaryNode prevRoot = flipTreeUpsideDown(node.left, root);
		if(node.left == null && root[0] == null) {
			root[0] = node;
			return node;
		}
		
		if(prevRoot != null) {
			prevRoot.right = node;
			prevRoot.left = node.right;
			node.left = null;
			node.right = null;
		}
		
		return node;
	}
	
	// DIFFICULT.. GAME THEORY // Incorrect solution
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i< maxChoosableInteger; i++)
			list.add(i+1);
		
		int turns = 0;
		int currVal = 0;
		
		while(!(currVal >= desiredTotal)) {
			turns++;
			int picked = pickANumber(list, currVal, desiredTotal);
			System.out.println("Player "+(turns % 2 == 0 ? 2 : 1)+" => "+picked);
			currVal += picked;
		}
		return turns%2 == 1;
	}
	
	private int pickANumber(List<Integer> list, int currVal, int desiredTotal) {
		
		int maxIndex = list.size()-1;
		// currMax val
		int max = list.get(maxIndex);
				
		if(max + currVal >= desiredTotal)
			return extract(list, maxIndex);
		
		for(int i=list.size()-2; i>= 0; i--) {
			int nextMax = list.get(i);
			if(nextMax + list.get(maxIndex) + currVal >= desiredTotal) {
				maxIndex = maxIndex-2;
			} else {
				return extract(list, maxIndex);
			}
		}
		
		return extract(list, list.size()-1);
		
	}
	
	private int extract(List<Integer> list, int index) {
		int num = list.get(index);
		list.remove(index);
		return num;
	}
	
	public int numberOfSequences(int[] arr) {
		return numberOfSequences(arr, -1);
	}
	
	private int numberOfSequences(int[] arr, int prevIndex) {
		int total = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > 0 && i != prevIndex) {
				arr[i]--;
				total += 1 + numberOfSequences(arr, i);
				arr[i]++;
			} else {
				
			}
		}
		
		return total;
	}
	
	// 7 8 9 10
	// buggy.. looks like O(n^3) is the way
	public List<Triplets> getTriangleTriplets(int[] arr) {
		Arrays.sort(arr);
		List<Triplets> list = new ArrayList<>();
		int i=0;
		int j = i+1;
		int k = j+1;
		for(; i<arr.length; ) {
			if(k < arr.length && isTriplet(arr[i], arr[j], arr[k])) {
				list.add(new Triplets(arr[i], arr[j], arr[k]));
				k++;
			} else {
				i++;
				j = i+1;
				k = j+1;
			}
		}
		return list;
	}
	
	public boolean isTriplet(int a, int b, int c) {
		return (a+b) > c && (a+c) > b && (b+c) > a;
	}
	
	class Triplets { 
		int a;
		int b;
		int c;
		public Triplets(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "["+a+","+b+","+c+"]";
		}
	}
	
	
	public int rotatedSortedArrPivot(int[] arr, int x) {
		int pivot = rotatedSortedArrPivot(arr, 0, arr.length-1);
		if(pivot == -1) {
			return binarySearch(arr, 0, arr.length-1, x);
		} else {
			if(arr[0] <= x)
				return binarySearch(arr, 0, pivot, x);
			else
				return binarySearch(arr, pivot+1, arr.length-1, x);
		}
	}
	
	private int binarySearch(int[] arr, int start, int end, int x) {
		if(start > end) 
			return -1;
		
		int mid = (start + end) >>> 1;
		if(arr[mid] == x)
			return mid;
		
		if(x < arr[mid]) {
			return binarySearch(arr, start, mid-1, x);
		} else {
			return binarySearch(arr, mid+1, end, x);
		}
		
	}
	
	
	private int rotatedSortedArrPivot(int[] arr, int start, int end) {
		if(start > end)
			return -1;
		
		if(start == end)
			return start;
		
		int mid = (start + end) >>> 1;
		if(mid < end && arr[mid] > arr[mid+1])
			return mid;
		
		if(mid > start && arr[mid] > arr[mid-1])
			return mid-1;
		
		if(arr[start] >= arr[mid])
			return rotatedSortedArrPivot(arr, start, mid-1);
		else
			return rotatedSortedArrPivot(arr, mid+1, end);
	}


	public int rotatedSortedArr(int[] arr, int x) {
		return rotatedSortedArr(arr, 0, arr.length-1, x);
	}
	
	private int rotatedSortedArr(int[] arr, int start, int end, int x) {
		if(start > end)
			return -1;
		
		int mid = (start + end) >>> 1;
		if(arr[mid] == x)
			return mid;
		
		if(arr[mid] > arr[start]) {
			// left side sorted
			if(x < arr[mid] && x >= arr[start])
				return rotatedSortedArr(arr, start, mid-1, x);
			else
				return rotatedSortedArr(arr, mid+1, end, x);
		} else if(arr[mid] < arr[start]) {
			// right side sorted
			if(x > arr[mid] && x <= arr[end]) 
				return rotatedSortedArr(arr, mid+1, end, x);
			else 
				return rotatedSortedArr(arr, start, mid-1, x);
		} else {
			if(arr[mid] == arr[end]) {
				// right or left side sorted
				int ret = rotatedSortedArr(arr, start, mid-1, x);
				if(ret == -1)
					ret = rotatedSortedArr(arr, mid+1, end, x);
				return ret;
			} else {
				return rotatedSortedArr(arr, mid+1, end, x);
			}
		}
	}
	
	

/** Compute the value of an expression in Reverse Polish Notation. Supported operators are "+", "-", "*" and "/". 
* Reverse Polish is a postfix mathematical notation in which each operator immediately follows its operands. 
* Each operand may be a number or another expression. 
* For example, 3 + 4 in Reverse Polish is 3 4 + and 2 * (4 + 1) would be written as 4 1 + 2 * or 2 4 1 + * 
* 
* @param ops a sequence of numbers and operators, in Reverse Polish Notation 
* @return the result of the computation 
* @throws IllegalArgumentException ops don't represent a well-formed RPN expression 
* @throws ArithmeticException the computation generates an arithmetic error, such as dividing by zero 
* 
* <p>Some sample ops and their results: 
* ["4", "1", "+", "2.5", "*"] -> ((4 + 1) * 2.5) -> 12.5 
* ["5", "80", "40", "/", "+"] -> (5 + (80 / 40)) -> 7 
*/
	
	public void reversePolishNotation(String[] seq) {
		Stack<Float> stack = new Stack<>();
		Stack<Character> operator = new Stack<>();
		
		
		for(String s : seq) {
			try { 
				if(!operator.isEmpty()) {
					float num2 = stack.pop();
					float num1 = stack.pop();
					char op = operator.pop();
					float res = solve( op,  num1,  num2);
					stack.push(res);
				}
				float num = Float.parseFloat(s);
				stack.add(num);
				
			} catch(NumberFormatException e) {
				char c  = s.charAt(0);
				operator.add(c);
			} catch(EmptyStackException e) {
				throw new IllegalArgumentException();
			}
		}
		
		if(!operator.isEmpty()) {
			float num2 = stack.pop();
			float num1 = stack.pop();
			char op = operator.pop();
			float res = solve( op,  num1,  num2);
			stack.push(res);
		}
		
		System.out.println(stack.pop());
	}
	
	private float solve(char op, float num1, float num2) {
		if(op == '+')
			return num1 + num2;
		
		if(op == '-')
			return num1 - num2;
		
		if(op == '*')
			return num1 * num2;
		
		if(op == '/')
			return num1 / num2;
		
		return -1;
	}
}

class TwoSumImpl implements TwoSum {

	private int[] arr = null;
	private int numOfElements;
	
	public TwoSumImpl() {
		arr = new int[11];
	}
	
	@Override
	public void store(int input) {
		if(numOfElements == arr.length) {
			grow(numOfElements+1);
		}
		
		arr[numOfElements++] = input;
	}
	
	private void grow(int minCapacity) {
		int oldCapacity = arr.length;
		int newCapacity = oldCapacity + (oldCapacity >>> 1);
		if(newCapacity - minCapacity < 0)
			newCapacity = minCapacity;
		if(newCapacity - (Integer.MAX_VALUE - 8) > 0) {
			newCapacity = hugeCapacity(minCapacity);
		}
		Arrays.copyOf(arr, newCapacity);
	}
	
	private int hugeCapacity(int minCapacity) {
		if(minCapacity < 0)
			throw new OutOfMemoryError();
		else
			return minCapacity > (Integer.MAX_VALUE-8) ? Integer.MAX_VALUE : (Integer.MAX_VALUE-8);
	}

	@Override
	public boolean test(int val) {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<arr.length; i++)
			map.put(arr[i], i);
		
		List<Sum> list = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(val-arr[i]) && map.get(val-arr[i]) > i) {
				list.add(new Sum(arr[i], val-arr[i]));
			}
		}
		
		System.out.println(list.toString());
		return list.size() > 0 ? true : false;
	}
	
	private class Sum {
		int a;
		int b;
		public Sum(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public String toString() {
			return "["+a+","+b+"]";
		}
	}
	
}

class ChildParentProblem {
	Map<Integer, BinaryNode> map ;
	public ChildParentProblem() {
		map = new HashMap<Integer, BinaryNode>();
	}
	
	private BinaryNode root;
	
	public void add(int child, int parent, boolean isLeft) {
		BinaryNode childNode, parentNode;
		if(map.containsKey(child))
			childNode = map.get(child);
		else {
			childNode = new BinaryNode(child);
			map.put(child, childNode);
		}
		
		if(parent == 0) 
		{
			root = childNode;
			return;
		}
		
		if(map.containsKey(parent))
			parentNode = map.get(parent);
		else {
			parentNode = new BinaryNode(parent);
			map.put(parent, parentNode);
		}
		
		if(isLeft)
			parentNode.left= childNode;
		else
			parentNode.right = childNode;
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	private void inOrder(BinaryNode root) {
		if(root == null) 
			return;
		
		inOrder(root.left);
		System.out.print(root.id+" ");
		inOrder(root.right);
	}
}




class Relation {
	BinaryNode child;
	BinaryNode parent;
	boolean isLeft;
	public Relation(BinaryNode child, BinaryNode parent, boolean isLeft) {
		this.child = child;
		this.parent = parent;
		this.isLeft = isLeft;
	}
}

class BinaryNode {
	int id; 
	BinaryNode left;
	BinaryNode right;
	public BinaryNode(int id) {
		this.id = id;
	}
}

class TriangleImpl implements Triangle {

	@Override
	public int[] getTriangleSides(int[] segments) {
		if(segments.length <= 2)
			return new int[0];
		
		Arrays.sort(segments);
		int i = 0; 
		int j = 1;
		for(int k=2; k< segments.length; k++) {
			if(isTriplet(segments[i++], segments[j++], segments[k]))
			{
				int[] res = new int[3];
				res[0] = segments[i-1];
				res[1] = segments[j-1];
				res[2] = segments[k];
				return res;
			}
		}
		
		return new int[0];
	}
	
	private boolean isTriplet(int a, int b, int c) {
		return (a+b) > c && (a+c) > b && (b+c) > a;
	}
	
}

/* Write a function to compute the maximum length palindromic sub-sequence of an array. 
A palindrome is a sequence which is equal to its reverse. 
A sub-sequence of an array is a sequence which can be constructed by removing elements of the array. 
Ex: Given [4,1,2,3,4,5,6,5,4,3,4,4,4,4,4,4,4] should return 10 (all 4's) */ 
class Interview { 
	public static int maxLengthPalindrome(int[] values) { 
		Integer tab[][] = new Integer[values.length][values.length];
		return maxLengthPalindrome(values, 0, values.length-1, tab);
	}
	
	private static int maxLengthPalindrome(int[] values, int i, int j, Integer[][] tab) {
		
		if(j == i)
			return 1;
		
		if(j < i)
			return 0;
		
		if(tab[i][j] != null)
			return tab[i][j];
		
		if(values[i] == values[j])
			tab[i][j] = 2 + maxLengthPalindrome(values, i+1, j-1,tab);
		else {
			tab[i][j] = Math.max(maxLengthPalindrome(values, i+1, j,tab), maxLengthPalindrome(values, i, j-1,tab));
		}
		
		return tab[i][j];
	}
}


class NestedIntegerImpl implements NestedInteger {
	
	public void add(NestedInteger nestedInteger) {
		if(list == null)
			list = new ArrayList<>();
		list.add(nestedInteger);
	}
	
	public NestedIntegerImpl(Integer integer) {
		this.integer = integer;
	}
	
	public NestedIntegerImpl(List<NestedInteger> list) {
		this.list = list;
	}
	
	private List<NestedInteger> list;
	
	private Integer integer;

	@Override
	public boolean isInteger() {
		return integer != null;
	}

	@Override
	public Integer getInteger() {
		return integer;
	}

	@Override
	public List<NestedInteger> getList() {
		return list;
	}
	
	@Override
	public int solve() {
		NestedInteger nestedInteger = this;
		return solve(nestedInteger, 0);
	}
	
	private int solve(NestedInteger nestedInteger, int depth) {
		if(nestedInteger.isInteger())
			return nestedInteger.getInteger() * depth;
		else {
			int total = 0;
			for(NestedInteger temp : nestedInteger.getList()) {
				total += solve(temp, depth+1);
			}
			return total;
		}
		
	}
	
}

class WordDistanceFinder { 
	private Map<String, List<Integer>> mapWordIndexes;
	
	public WordDistanceFinder(List<String> words) {
		mapWordIndexes = new HashMap<>();
		populate(words);
	}
	
	private void populate(List<String> words) {
		for(int i=0; i<words.size(); i++) {
			if(mapWordIndexes.containsKey(words.get(i))) {
				mapWordIndexes.get(words.get(i)).add(i);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				mapWordIndexes.put(words.get(i), list);
			}
		}
	}
	
	public int distance(String word1, String word2) {
		List<Integer> list1 = mapWordIndexes.get(word1);
		List<Integer> list2 = mapWordIndexes.get(word2);
		return findMinDistance(list1.toArray(new Integer[list1.size()]), list2.toArray(new Integer[list2.size()]));
	}
	
	private int findMinDistance(Integer[] arr1, Integer[] arr2) {
		int i = 0;
		int j = 0;
		
		int minDiff = Integer.MAX_VALUE;
		while(i < arr1.length && j < arr2.length) {
			int diff = Math.abs(arr1[i] - arr2[j]);
			if(diff < minDiff)
				minDiff = diff;
			if(arr1[i] > arr2[j]) {
				j++;
			} else {
				i++;
			}
		}
		
		while(i < arr1.length) {
			int diff = Math.abs(arr1[i] - arr2[arr2.length-1]);
			if(diff < minDiff)
				minDiff = diff;
			
			i++;
		}
		
		while(j < arr2.length) {
			int diff = Math.abs(arr1[arr1.length-1] - arr2[j]);
			if(diff < minDiff)
				minDiff = diff;
			
			j++;
		}
		
		return minDiff;
	}
}

class Range implements Comparable<Range> {
	int a; 
	int b;
	public Range(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public int compareTo(Range o) {
		if(this.b < o.b)
			return -1;
		else if(this.b > o.b)
			return 1;
		else
			return 0;
	}
	
	@Override
	public String toString() {
		return "["+a+","+b+"]";
	}
}

class InfluenceFinderImpl implements InfluencerFinder {

	@Override
	public int getInfluencer(boolean[][] followingMatrix) {
		int[] in = new int[followingMatrix.length];
		int[] out = new int[followingMatrix.length];
		
		for(int i=0; i<followingMatrix.length; i++) {
			for(int j=0; j <followingMatrix.length; j++) {
				if(followingMatrix[i][j]) {
					out[i]++;
					in[j]++;
				}
			}
		}
		
		for(int i=0; i<in.length; i++) {
			if(in[i] == in.length-1 && out[i] == 0)
				return i;
		}
		
		return -1;
	}
	
	// Brilliant.. O(n) solution...
	public int getInfluencerBetter(boolean[][] followingMatrix) {

		int influencer = 0; 
		
		for(int i=0; i<followingMatrix.length; i++) {
			if(followingMatrix[influencer][i] || !followingMatrix[i][influencer]) {
				influencer = i;
			}
		}
		
		for(int i=0; i<followingMatrix.length; i++) {
			if(i == influencer)
				continue;
			if(followingMatrix[influencer][i] || !followingMatrix[i][influencer])
				return -1;
		}
		
		return influencer;
		
	}
	
}

class PointsOnAPlaneImpl implements PointsOnAPlane {

	private List<Point> points ;
	
	private class PointDistance {
		Point p;
		double distance; 
		public PointDistance(Point p, double d) {
			this.p = p;
			this.distance = d;
		}
	}
	
	public PointsOnAPlaneImpl() {
		points = new ArrayList<>();
	}
	
	@Override
	public void addPoint(Point point) {
		points.add(point);
	}

	@Override
	public Collection<Point> findNearest(Point center, int m) {
		
		Comparator<PointDistance> comparator = new Comparator<PointDistance>() {

			@Override
			public int compare(PointDistance o1, PointDistance o2) {
				if(o1.distance < o2.distance)
					return -1;
				else if(o1.distance > o2.distance) 
					return 1;
				else
					return 0;
			}
		};
		
		PriorityQueue<PointDistance> queue = new PriorityQueue<>(points.size(),comparator);
		for(Point point : points) {
			queue.add(new PointDistance(point, Math.hypot(point.x-center.x, point.y-center.y)));
		}
		
		List<Point> list = new ArrayList<>();
		while(m > 0) {
			list.add(queue.poll().p);
			m--;
		}
		
		return list;
		
	}
	
}

class Point {
	int x; 
	int y; 
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
}

class Node {
	int val;
	Node next;
	public Node(int val) {
		this.val = val;
	}
}

class PowersImpl implements Powers {

	private final int m = 2;
	private int n = 2;
	private long lastComputedVal = m;
	
	@Override
	public boolean hasNext() {
		if(lastComputedVal*2 > 0 && lastComputedVal * 2 < Long.MAX_VALUE)
			return true;
		return false;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long next() {
		if(hasNext()) {
			n++;
			return lastComputedVal*2;
		}
		return null;
	}

	@Override
	public void reset() {
		n = 2;
		lastComputedVal = m;
	}
	
}