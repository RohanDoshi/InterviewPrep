import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

public class Page5 {

	public static void main(String[] args) {

		Graph graph = new Graph();
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');
		graph.addVertex('F');
		graph.addVertex('G');
		graph.addVertex('S');
		graph.addVertex('T');
		
		graph.addEdge('A','C');
		graph.addEdge('B','S');
		graph.addEdge('B','D');
		graph.addEdge('C','D');
		graph.addEdge('C','E');
		graph.addEdge('D','F');
		graph.addEdge('D','T');
		graph.addEdge('D','E');
		graph.addEdge('E','G');
		graph.addEdge('E','T');
		graph.addEdge('G','T');
		graph.addEdge('G','E');
		graph.addEdge('T','F');
		graph.addEdge('S','A');
		graph.addEdge('S','B');
		
		graph.printAllPaths('S', 'E');
		
		Graph g = new Graph();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addVertex('F');
		g.addVertex('G');
		g.addVertex('H');
		
		
		g.addEdge('A','E');
		g.addEdge('A','F');
		g.addEdge('B','G');
		g.addEdge('B','H');
		g.addEdge('C','G');
		g.addEdge('D','F');
		g.addEdge('D','H');
	
		System.out.println("isGraphBipartite --> "+g.isGraphBipartite());
		
		
		
		int a[] = {1,2,5}, b[] = new int[a.length*2];
		b[0] = 2;
		b[1] = 3;
		b[2] = 6;
		
		Page5 pg = new Page5();
		pg.mergeInPlace(a, b);
		System.out.println(Arrays.toString(b));
		
		Page6 pg6 = new Page6();
		int arr[] = {1,2,13,4,5,6,9,18};
		BinaryNode<Integer> node = pg6.constructBST(arr);
		System.out.println(pg.isBST(node));
		int[] prev = new int[1];
		prev[0] = Integer.MIN_VALUE;
		System.out.println(pg.isBST(node, prev));
		System.out.println(pg.numOfBitsSet(45));
		pg.game(21);
		int[] powerSetDups = {1,2,2};
		pg.printPowerSetForDuplicateElements(powerSetDups);
		int[] rotArr = {4,5,6,7,8,9,1,2,3};
		pg.rotatedSortedArr(rotArr, 9);
		pg.rotatedSortedArr(rotArr, 4);
		pg.rotatedSortedArr(rotArr, 5);
		pg.rotatedSortedArr(rotArr, 6);
		pg.rotatedSortedArr(rotArr, 3);
		pg.rotatedSortedArr(rotArr, 1);
		System.out.println(pg.sqrt(18));
		
		pg.editDistanceDP("abdxa", "axdba");
		pg.editDistanceDP("abaxbabax", "xababxaba");
		System.out.println(pg.isKPalindrome("abdxa", 1));
		int sumZero[] = {4, 2, -3, 1, 6, 0, -4};
		int tripletsZero[] = {-1,-3,5,4};
		pg.printAllSubarrSumZero(sumZero);
		Arrays.sort(tripletsZero);
		pg.printAllTripletsSum0(tripletsZero);
		pg.printAllPairsThatSumToK(sumZero, 3);
		pg.printAllPairsThatSumToKSort(sumZero, 3);
		pg.find_triplets(tripletsZero,0);
		pg.SumTripletsProblem(tripletsZero, 0);
		pg.SumTripletsProblemSorting(tripletsZero, 0);
		
		int[][] maze = new int[9][9];
		int arr1[] = {1,2,3,4,7};
		int arr2[] = {0,5,6,9};
		pg.median(arr1, arr2);
		
		int A[] = {900};
		int B[] = {5, 8, 10, 20};
		
		int A1[] = {5, 7, 9, 11, 15};
		int B1[] = {1, 8};
		pg.median(A, B);
		pg.median(A1, B1);
		
		
		int a1[] = {10,30,40,50,60};
		int b1[] = {110, 30,50,100,200, 115, 135, 150, 30};
		// 10 30 30 40 50 50 60 100 110 115 135 150 200
		//pg.median(a1, b1);
		
		int ar1[] = {1, 12, 15, 26, 38};
	    int ar2[] = {2, 13, 17, 30, 45};
	    pg.median(ar1, ar2);
	    pg.maxSumSubsequence(b1);
	    //string:aaab b, ab, aab, aaab, ab
//	    pattern:a+aabc 
//	    string:ab aabc, aaabc, aaaabc .. 
//	    output:0 
//
//	    pattern:aa*b*ab+ 
//	    string:aab aab, aabab, aaaabbab 
//	    output:1 
//
//	    pattern: a+a*b* 
//	    string: a ab, aab, aaabb 
//	    output: 1 
	    System.out.println(pg.patternMatching("aaab b", "a*b"));
	    System.out.println(pg.patternMatching("ab", "a*b"));
	    System.out.println(pg.patternMatching("aab", "a*b"));
	    System.out.println(pg.patternMatching("aaab", "a*b"));
	    System.out.println(pg.patternMatching("aaab b", "a*b"));
	    System.out.println("--------------------------------------");
	    System.out.println(pg.patternMatching("ab", "a+aabc"));
	    System.out.println(pg.patternMatching("aabc", "a+aabc"));
	    System.out.println(pg.patternMatching("aaabc", "a+aabc"));
	    System.out.println(pg.patternMatching("aaaabc", "a+aabc"));
	    System.out.println("--------------------------------------");
	    System.out.println(pg.patternMatching("aab", "aa*b*ab+"));
	    System.out.println(pg.patternMatching("aab", "aa*b*ab+"));
	    System.out.println(pg.patternMatching("aabab", "aa*b*ab+"));
	    System.out.println(pg.patternMatching("aaaabbab", "aa*b*ab+"));
	    System.out.println("--------------------------------------");
	    System.out.println(pg.patternMatching("a", "a+a*b*"));
	    System.out.println(pg.patternMatching("ab", "a+a*b*"));
	    System.out.println(pg.patternMatching("aab", "a+a*b*"));
	    System.out.println(pg.patternMatching("aaabb", "a+a*b*"));
	    System.out.println("--------------------------------------");
	    pg.generateAllAlphabetCodes("12");
	    pg.generateAllAlphabetCodes("112");
	    int dutch[] = {2,3,1,3,1};
	    pg.dutchflagSort(dutch);
	    int[] arr3= {1,1,2,1,1,3};
	    pg.printPowerSetForDuplicateElements(arr3);
	    pg.print3LenUniqSubsets(arr3);
	    
	    
	   char mat[][] = {{'S', 'M', 'E', 'F'}, 
	    {'R', 'A', 'T' ,'D'},
	    {'L', 'O', 'N' ,'I'},
	    {'K', 'A' ,'F' ,'B'}};
	   
	   pg.isWordExists(mat, "STAR");
	   pg.isWordExists(mat, "TONE");
	   pg.isWordExists(mat, "NOTE");
	   pg.isWordExists(mat, "SAND");
	   pg.isWordExists(mat, "NOTAN");
	   String palin = "A man, a plan, a canal: Panama.";
	   System.out.println(pg.isPalin(palin));
	   
	   String flt = "342.18E-10";
	   System.out.println(pg.aToi(flt));
	   
	   BinaryNode<Integer> root = new BinaryNode<Integer>(20);
	   root.left = new BinaryNode<Integer>(99);
	   root.right = new BinaryNode<Integer>(12);
	   root.left.left = new BinaryNode<Integer>(21);
	   root.left.right = new BinaryNode<Integer>(0);
	   root.right.left = new BinaryNode<Integer>(7);
	   pg.binaryTreeToList(root);
	   while(pg.head != null) {
		   System.out.print(pg.head.value+" ");
		   pg.head = pg.head.right;
	   }
	   
	   System.out.println("to char"+(char)(0+65));
	}
	
	
	
	BinaryNode<Integer> head = null;
	BinaryNode<Integer> tail = null;
	
	public void binaryTreeToList(BinaryNode<Integer> node) {
		if(node == null)
			return;
		
		BinaryNode<Integer> left = node.left;
		BinaryNode<Integer> right =  node.right;
		
		binaryTreeToList(left);
		addToList(node);
		binaryTreeToList(right);
	}
	
	private void addToList(BinaryNode<Integer> node) {
		if(head == null) {
			head = node;
			tail = node;
		} else if(node.value >= tail.value) {
			tail.right = node;
			node.left = tail;
			tail = node;
			tail.right = null;
		} else if(node.value <= head.value) {
			node.right = head;
			head.left = node;
			head = node;
			head.left = null;
		} else { 
			BinaryNode<Integer> temp = head;
			BinaryNode<Integer> prev = null;
			while(node.value > temp.value) {
				prev = temp;
				temp = temp.right;
			}
			prev.right = node;
			node.left = prev;
			node.right = temp;
			temp.left = node;
		}
	}
	
	public double aToi(String num) {
		int index = num.indexOf('E');
		if(index == -1)
			index = num.indexOf('e');
		if(index != -1) {
			return (aToiWithoutE(num.substring(0, index))*Math.pow(10,aToiWithoutE(num.substring(index+1))));
		}
		else
			return aToiWithoutE(num);
	}
	
	private float aToiWithoutE(String num) {
		int index = num.indexOf('.');
		if(index == -1) {
			return (float) stringToInt(num);
		} else { 
			int left = stringToInt(num.substring(0,index));
			int right = stringToInt(num.substring(index+1, num.length()));
			int temp = right;
			int count = 0;
			while(temp > 0) {
				count++;
				temp = temp/10;
			}
			return (float) (left + (right*Math.pow(10,-count)));
		}
	}
	
	
	public int stringToInt(String num) {
		if(num.charAt(0) == '-')
			return -stringToInt(num.substring(1));
		
		int res = 0;
		for(int i=0; i<num.length(); i++) {
			res = res*10 + (num.charAt(i) - '0');
		}
		
		return res;
	}
	
	
	public boolean isPalin(String s) {
		int i = 0;
		int j = s.length()-1;
		while(i < j) {
			if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' ) ||
					(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
				if((s.charAt(j) >= 'A' && s.charAt(j) <= 'Z' ) ||
						(s.charAt(j) >= 'a' && s.charAt(j) <= 'z')) {
					char charAti = (char) ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ? ('a' + s.charAt(i)-'A') : s.charAt(i));
					char charAtj = (char) ((s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') ? ('a' + s.charAt(j)-'A') : s.charAt(j));
					if(charAti != charAtj)
						return false;
					else {
						i++;
						j--;
					}
				} else {
					j--;
				}
			} else {
				i++;
			}
		}
		
		return true;
	}
	
	public void isWordExists(char mat[][], String word) {
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				if(mat[i][j] == word.charAt(0)) {
					boolean bmat[][] = new boolean[mat.length][mat[0].length];
					boolean b = isWordExistsCheck(mat, bmat, i, j, word, 0);
					if(b)
						System.out.println(word+" Found at "+i+", "+j);
				}
			}
		}
	}
	
	private boolean isWordExistsCheck(char[][] mat, boolean[][] bmat, int row, int col, String word, int index) {
		if(index > word.length())
			return false;
		
		if(index == word.length())
			return true;
		
		if(row >= mat.length || col >= mat[0].length || row < 0 || col < 0 )
			return false;
		
		if(bmat[row][col])
			return false;
		
		if(word.charAt(index) == mat[row][col])
			bmat[row][col] = true;
		
		return  bmat[row][col] && (
				isWordExistsCheck(mat, bmat, row+1, col, word, index+1) || 
				isWordExistsCheck(mat, bmat, row-1, col, word, index+1) ||
				isWordExistsCheck(mat, bmat, row, col+1, word, index+1) ||
				isWordExistsCheck(mat, bmat, row, col-1, word, index+1) ||
				isWordExistsCheck(mat, bmat, row-1, col-1, word, index+1) || 
				isWordExistsCheck(mat, bmat, row+1, col+1, word, index+1) || 
				isWordExistsCheck(mat, bmat, row-1, col+1, word, index+1) || 
				isWordExistsCheck(mat, bmat, row+1, col-1, word, index+1));
	}
	
	public void print3LenUniqSubsets(int[] arr) {
		Map<Integer, Integer> mapElementCount = new HashMap<>();
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<Integer>());
		for(int i=0; i<arr.length; i++) {
			if(mapElementCount.containsKey(arr[i])) {
				mapElementCount.put(arr[i], mapElementCount.get(arr[i])+1);
				int currCount = mapElementCount.get(arr[i]);
				int size = res.size();
				for(int j=0; j<size; j++) {
					List<Integer> list = res.get(j);
					int elementCount = 0;
					for(int k=0; k<list.size(); k++) {
						if(list.get(k) == arr[i])
							elementCount++;
					}
					if(elementCount == currCount-1 && list.size() <3) {
						ArrayList<Integer> newList = new ArrayList<>(list);
						newList.add(arr[i]);
						res.add(newList);
					}
				}
			} else { 
				mapElementCount.put(arr[i], 1);
				int size = res.size();
				for(int j=0; j<size && res.get(j).size() <3; j++) {
					List<Integer> list = new ArrayList<>(res.get(j));
					list.add(arr[i]);
					res.add(list);
				}
			}
		}
		System.out.println("print3LenUniqSubsets....");
		for(int i=0; i<res.size(); i++) {
			System.out.println(res.get(i).toString());
		}
	}
	
	// arr contains 1,2,3
	// Ex: Input [1, 3, 3, 2, 1] 
	// 2, 3, 1, 3, 1
	public void dutchflagSort(int[] arr) {
		int mid = 2;
		int i = 0; 
		int j = arr.length-1;
		int k = 0;
		while(k < j) {
			if(arr[k] > mid) {
				swap(arr, k, j);
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
	
	public void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public void generateAllAlphabetCodes(String n) {
		generateAllAlphabetCodes(n, 0, "");
	}
	// 1123
	private void generateAllAlphabetCodes(String s, int index, String res) {
		if(index > s.length())
			return;
		
		if(index == s.length()) {
			System.out.println(res);
			return;
		}
		
		int len = 1;
		for(int i=index; i+len<=s.length(); len++) {
			int val = Integer.parseInt(s.substring(index, i+len));
			if(val >= 1 && val <= 26) {
				generateAllAlphabetCodes(s, i+len, res + (char)('A' + (val-1)));
			}
		}
		
		
	}
	
	// #patternMatchingUltimate
	public boolean patternMatching(String str, String pattern) {
		if(str == null || pattern == null)
			return false;
		
		if(str.length() == 0) {
			return pattern.length() == 0 || (pattern.length() <= 2 && pattern.charAt(pattern.length()-1) == '*');
		}
		
		if(pattern.length() == 0) {
			return false;
		}
		
		Character pat = pattern.charAt(0);
		Character pat1 = pattern.length() >= 2 ? pattern.charAt(1) : null;
		
		Character s = str.charAt(0);
		if(pat1 != null && pat1 == '*') {
			return patternMatching(str.substring(1), pattern) || 
					patternMatching(str, pattern.substring(2));
		} else if(pat1 != null && pat1 == '+') {
			return s == pat && patternMatching(str.substring(1), ""+pat + '*' + pattern.substring(2));
		} else { 
			return s == pat && patternMatching(str.substring(1), pattern.substring(1));
		}
	}
	
	
	// sortedArr
	public int findNearestNum(int arr[], int n) {
		
		if(arr.length == 1)
			return arr[0];
		
		if(n < arr[0])
			return arr[0];
		
		if(n > arr[arr.length-1])
			return arr[arr.length-1];
		
		
		int low = 0;
		int high = arr.length -1;
		
		while(low < high) {
			int mid = (low + high) >>> 1;
			if(arr[mid] == n)
				return n;
			
			if(n > arr[mid])
				low = mid+1;
			else
				high = mid-1;
		}
		
		return Math.abs(arr[low] - n) < Math.abs(arr[high] - n) ? arr[low] : arr[high];
	}
	
	// #NoTwoConsecutive
	public void maxSumSubsequence(int[] arr) {
		System.out.println(maxSum(arr, 0));
	}
	
	private int maxSum(int arr[] , int index) {
		if(index >= arr.length)
			return 0;
		
		int max = Integer.MIN_VALUE;
		for(int i=index; i<arr.length; i++) {
			int sum = arr[i] + maxSum(arr, i+2);
			if(sum > max)
				max = sum;
		}
		
		return max;
	}
	
	public void median(int a[], int b[]) {
		int len = a.length + b.length;
		int medianIndex = (len-1) >>> 1;
		
		if(len % 2 == 0) {
			int median = (medianTwoSortedArr(a, b, medianIndex) + medianTwoSortedArr(a, b, medianIndex+1)) >>> 1;
			System.out.println(median);
		} else {
			System.out.println(medianTwoSortedArr(a, b, medianIndex));
		}
	}

	//A = [1, 2, 3, 4, 7] and B = [0, 5, 6, 9]
	public int medianTwoSortedArr(int a[], int b[], int medianIndex) {
		int len = a.length + b.length;
		int median = medianTwoSortedArr(a, 0, a.length-1, b, 0, b.length-1, medianIndex, len);
		if(median == -1)
			median = medianTwoSortedArr(b, 0, b.length-1, a, 0, a.length-1, medianIndex, len);
		return median;
		
	}
	
	private int medianTwoSortedArr(int[] a, int aStart, int aEnd, int[] b, int bStart, int bEnd, int medianIndex, int totalLen) {
		if(aStart > aEnd)
			return -1;
		
		int aMid = (aStart + aEnd) >>> 1;
		// starting index of smallest element that is greater than a[aMid];
		int bEstimate = estimateElementIndex(b, bStart, bEnd, a[aMid]);
		// num of elements in b greater than a[aMid];
		int numGreaterInB = (b.length -1) - bEstimate + 1;
		int numGreaterInA = (a.length -1) - aMid ;
		// num of elements greater than a[aMid] 
		int totalNumGr = numGreaterInA + numGreaterInB;
		
		if((totalLen -1) - totalNumGr == medianIndex) 
			return a[aMid];
		
		if(medianIndex > (totalLen-1) - totalNumGr) {
			return medianTwoSortedArr(a, aMid+1, aEnd, b, bStart, bEnd, medianIndex, totalLen);
		} else {
			return medianTwoSortedArr(a, aStart, aMid-1, b, bStart, bEnd, medianIndex, totalLen);
		}
		
		
	}
	
	private int estimateElementIndex(int arr[], int low, int high, int elem) {
		if(low > high)
			return -1;
		
		if(low == high) {
			if(elem <= arr[low])
				return low;
			else
				return high+1;
		}
		
		int mid = (low + high) >>> 1;
		
		if(arr[mid] <= elem) {
			return estimateElementIndex(arr, mid+1, high, elem);
		} else {
			return estimateElementIndex(arr, low, mid, elem);
		}
	}
	
	public void mazeOnlyRightNumOfSteps(int[][] maze, int n, int m) {
		
	}
	
	
	
	private class Values {
		int a;
		int b;
		public Values(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	
	Set<Vector<Integer> > find_triplets(int[] arr, int target) {
	  //Arrays.sort(arr);
	  Set<Vector<Integer>> triplets = new HashSet<>();
	  
	  int n = arr.length;
	  for (int i = 0;i < n; i++) {
	    int j = i + 1;
	    int k = n - 1;
	    while (j < k) {
	      int sum_two = arr[i] + arr[j];
	      if (sum_two + arr[k] < target) {
	        j++;
	      } else if (sum_two + arr[k] > target) {
	        k--;
	      } else {
	    	Vector<Integer> triplet = new Vector<>(3);
	        triplet.add(arr[i]);
	        triplet.add(arr[j]);
	        triplet.add(arr[k]);
	        triplets.add(triplet);
	        j++;
	        k--;
	      }
	    }
	  }
	  return triplets;
	}
	
	public void SumTripletsProblemSorting(int[] arr, int target) {
		System.out.println("SumTripletsProblemSorting....");
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) {
			int j=i+1; 
			int k=arr.length-1;
			while(j<k) {
				int sum = arr[i] + arr[j];
				if(sum + arr[k] == target) {
					System.out.println("["+arr[i]+", "+arr[j]+", "+arr[k]+"]");
					j++;
					k--;
				} else if(sum + arr[k] < target) {
					j++;
				} else {
					k--;
				}
			}
		}
	}
	// using hasshing
	public void SumTripletsProblem(int[] arr, int target) {
		System.out.println("SumTripletsProblem ..... ");
		Map<Integer, Integer> mapValueIndex = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			mapValueIndex.put(arr[i], i);
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				int sum = arr[i] + arr[j];
				if(mapValueIndex.containsKey(target - sum)) {
					int index = mapValueIndex.get(target-sum);
					if(index > j)
					System.out.println("["+arr[i]+", "+arr[j]+", "+arr[index]+"]");
				}
			}
		}
	}
	
	public void printAllPairsThatSumToKSort(int[] arr, int target) {
		Arrays.sort(arr);
		int i=0; 
		int j = arr.length-1;
		while(i < j) {
			if(arr[i] + arr[j] == target) {
				System.out.println("["+arr[i]+", "+arr[j]+"]");
				i++;
				j--;
			} else if(arr[i] + arr[j] < target) {
				i++;
			} else {
				j--;
			}
		}
	}
	
	public void printAllPairsThatSumToK(int[] arr, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(arr[i])) {
				System.out.println("["+map.get(arr[i])+", "+arr[i]+"]");
			} else {
				map.put(target-arr[i], arr[i]);
			}
		}
	}
	
	
	public void printAllTripletsSum0(int[] arr) {
		
		Set<Integer> set = new HashSet<>();
		Set<List<Integer>> res = new HashSet<>();
		for(int i=0; i<arr.length; i++) {
			set.add(arr[i]);
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				int sum = arr[i] + arr[j];
				if(set.contains(-sum)) {
					List<Integer> list = new ArrayList<>();
					list.add(arr[i]);
					list.add(arr[j]);
					list.add(-sum);
					res.add(list);
				}
			}
		}
		
		System.out.println(res.toString());
		
		
	}
	
	public void printAllSubarrSumZero(int[] arr) {
		List<Range> list = new ArrayList<>();
		int curr_sum = 0;
		Map<Integer, Integer> mapSumIndex = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			curr_sum = curr_sum + arr[i];
			if(curr_sum == 0 || arr[i] == 0 || mapSumIndex.containsKey(curr_sum)) {
				if(arr[i] == 0) {
					list.add(new Range(i,i));
				} else if(curr_sum == 0) {
					list.add(new Range(0, i));
				} else {
					int index = mapSumIndex.get(curr_sum);	
					list.add(new Range(index+1, i));
				}
			}
			mapSumIndex.put(curr_sum, i);
		}
		System.out.println(list.toString());
	}
	
	public boolean isKPalindrome(String s1, int k) {
		return isKPalindrome(s1, k, 0, s1.length()-1);
	}
	
	private boolean isKPalindrome(String s1, int k, int i, int j) {
		if(k < 0)
			return false;
		
		if(i > j)
			return false;
		
		while(i < j) {
			if(s1.charAt(i) != s1.charAt(j)) {
				boolean ret = isKPalindrome(s1, k-1, i, j-1);
				if(!ret) {
					ret = isKPalindrome(s1, k-1, i+1, j);
				}
				return ret;
			}
			i++;
			j--;
		}
		
		return true;
	}
	
	private int isKPalindromeEditDistance(String s1, String rev) {
		return -1;
	}
	public void editDistanceDP(String s1, String s2) {
		
		int dp[][] = new int[s1.length()+1][s2.length()+1];
		for(int i=0; i<=s2.length(); i++) {
			dp[0][i] = i; // insert
		}
		
		for(int i=0; i<=s1.length(); i++) {
			dp[i][0] = i; // delete
		}
		
		for(int i=0; i<s1.length(); i++) {
			for(int j=0; j<s2.length(); j++) {
				if(s1.charAt(i) == s2.charAt(j)) {
					dp[i+1][j+1] = dp[i][j];
				} else { 
					dp[i+1][j+1] = Math.min(dp[i][j], Math.min(dp[i][j+1], dp[i+1][j])) + 1;
				}
			}
		}
		
		System.out.println(dp[s1.length()][s2.length()]);
	}
	
	public double sqrt(int n) {
		double low = 0;
		double high = n;
		double mid = (low + high) /2;
		while(Math.abs(mid*mid-n) > 0.0001) {
			if(mid*mid > n) {
				high = mid;
			} else {
				low = mid;
			}
			mid = (low + high) /2;
		}
		
		return mid;
	}
	
	
	// 4,5,6,7,8,9,1,2,3
	public void rotatedSortedArr(int []arr, int elem) {
		System.out.println(rotatedSortedArr(arr, elem, 0, arr.length-1));
	}
	
	private int rotatedSortedArr(int []arr, int elem, int low, int high) {
		if(low > high)
			return -1;
		
		int mid = (low + high) >>> 1;
		if(arr[mid] == elem)
			return mid;
		
		if(arr[low] < arr[mid])  {
			if(elem >= arr[low] && elem < arr[mid]) 
				return rotatedSortedArr(arr, elem, low, mid-1);
			else
				return rotatedSortedArr(arr, elem, mid+1, high);
		} else if(arr[low] > arr[mid]) {
			if(elem > arr[mid] && elem <= arr[high])
				return rotatedSortedArr(arr, elem, mid+1, high);
			else
				return rotatedSortedArr(arr, elem, low, mid-1);
		} else {
			int search = rotatedSortedArr(arr, elem, mid+1, high);
			if(search == -1)
				return rotatedSortedArr(arr, elem, low, mid-1);
			else
				return search;
		}
	}
	
	
	public void printPowerSetForDuplicateElements(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<Integer>());
		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
				int size = res.size();
				for(int j=0; j<size; j++) {
					int elemCount = 0;
					List<Integer> list = new ArrayList<>(res.get(j));
					for(int k=0; k<list.size(); k++) {
						if(list.get(k) == arr[i]) {
							elemCount++;
						}
					}
					if(elemCount == map.get(arr[i])-1) {
						list.add(arr[i]);
						res.add(list);
					}
				}
			} else {
				int size = res.size();
				map.put(arr[i], 1);
				for(int j=0; j<size; j++) {
					List<Integer> list = new ArrayList<>(res.get(j));
					list.add(arr[i]);
					res.add(list);
				}
			}
		}
		
		for(int i=0; i<res.size(); i++) 
			System.out.println(res.get(i).toString());
		
	}
	
	public void game(int n) {
		int player = 0;
		game(n,player);
	}
	
	private void game(int n, int player) {
		
		int numOfBitsN = numOfBitsSet(n);
		int valk = -1;
		for(int k=0; Math.pow(2, k) < n; k++) {
			int num = numOfBitsSet(n - (int)Math.pow(2, k));
			if(num == numOfBitsN) {
				valk = k;
				break;
			}
		}
		
		if(valk == -1) {
			System.out.println("player "+ (player%2 == 0? "1" : "2" )+" loses");
			return;
		}
		
		game(n-(int)Math.pow(2, valk), player+1);
	}
	
	public int numOfBitsSet(int n) {
		int count = 0;
		while(n > 0) {
			int bit = n & 1;
			count = count + bit;
			n = n >>> 1;
		}
		return count;
	}
	
	public boolean isBST(BinaryNode<Integer> node, int[] prev) {
		if(node == null)
			return true;
		
		boolean left = isBST(node.left, prev);
		boolean check = false;
		if(prev[0] <= node.value)
			check = true;
		prev[0] = node.value;
		boolean right = isBST(node.right, prev);
		return left && right && check;
	}
	
	public boolean isBST(BinaryNode<Integer> node) {
		if(node == null)
			return true;
		
		boolean b[] = new boolean[1];
		b[0] = true;
		isBSTElem(node, b);
		return b[0];
	}
	
	private int isBSTElem(BinaryNode<Integer> node, boolean b[]) {
		if(node == null)
			return Integer.MIN_VALUE;
		
		int leftMax = Integer.MIN_VALUE;
		int rightMax = Integer.MAX_VALUE;
		
		if(node.left != null)
			leftMax = isBSTElem(node.left, b);
		if(node.right != null)
			rightMax = isBSTElem(node.right, b);
		
		if(node.value >= leftMax && node.value < rightMax) {
			b[0] = b[0] & true;
		} else {
			b[0] = false;
		}
		
		return node.right == null ? node.value : rightMax;
		
	}
	
	public void mergeInPlace(int a[] , int b[]) {
		int index = b.length-1;
		int i= a.length-1, j = a.length-1;
		while(i >= 0 && j >= 0) {
			if(a[i] > b[j]) {
				b[index--] = a[i];
				i--;
			} else {
				b[index--] = b[j];
				j--;
			}
		}
		
		while(i >= 0) {
			b[index--] = a[i];
			i--;
		}
		
	}

}


class Graph {
	
	private enum Color  {
		None,
		Red,
		Blue;
	}
	
	private class Vertex {
		public Vertex(char name) {
			this.name = name;
			this.neighbors = new ArrayList<>();
		}
		@Override
		public String toString() {
			return ""+this.name;
		}
		char name; 
		List<Vertex> neighbors;
		Color color = Color.None;
		
	}
	
	public boolean isGraphBipartite() {
		Vertex v = this.vertices.get(0);
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(v);
		queue.add(null);
		
		Vertex temp = null;
		Color color = Color.Red;
		int level = 0;
		while(queue.size() != 1) {
			temp = queue.poll();
			if(temp == null) {
				queue.add(null);
				level++;
				if(level % 2 == 1)
					color = Color.Blue;
				else
					color = Color.Red;
				continue;
			}
			
			temp.color = color;
			
			for(Vertex adj : temp.neighbors) {
				if(adj.color.equals(color))
					return false;
				
				queue.add(adj);
			}
		}
		
		return true;
	}
	
	
	public Graph() {
		this.vertices = new ArrayList<>();
		this.map = new HashMap<Character,Vertex>();
	}
	
	private List<Vertex> vertices;
	private Map<Character, Vertex> map;
	
	public void addVertex(char name) {
		if(map.containsKey(name))
			return;
		
		Vertex v = new Vertex(name);
		vertices.add(v);
		map.put(name, v);
	}
	
	public void addEdge(char from, char to) {
		if(map.containsKey(from) && map.containsKey(to)) {
			map.get(from).neighbors.add(map.get(to));
		}
	}
	
	public void printAllPaths(char source, char destination) {
		if(map.containsKey(source) && map.containsKey(destination)) { 
			Vertex s = map.get(source);
			Vertex d = map.get(destination);
			printAllPaths(s, d, new HashSet<Vertex>(), new LinkedList<Vertex>());
		}
	}
	
	private void printAllPaths(Vertex s, Vertex d, Set<Vertex> visited, List<Vertex> path) {
		if(s.equals(d)) {
			path.add(d);
			System.out.println(path.toString());
			path.remove(path.size()-1);
			return;
		}
		visited.add(s);
		path.add(s);
		List<Vertex> neighbors = s.neighbors;
		for(Vertex v : neighbors) {
			if(!visited.contains(v)) {
				printAllPaths(v, d, visited, path);
			}
		}
		visited.remove(s);
		path.remove(path.size()-1);
	}
}
