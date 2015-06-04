package killit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class ToughFB {
	public static void main(String[] v) throws IOException {
//			List<Point> points = new ArrayList<Point>();
	        Point origin = new Point(0, 0);
//	        points.add(new Point(1, 1, origin));
//	        points.add(new Point(1, 3, origin));
//	        points.add(new Point(-1, 1, origin));
//	        points.add(new Point(-1, 3, origin));
//	        points.add(new Point(1, -1, origin));
//	        points.add(new Point(3, -1, origin));
//	        points.add(new Point(-1, -1, origin));
//	        points.add(new Point(-1, 3, origin));
//	        points.add(new Point(2, 2, origin));
//	        Point[] arr = points.toArray(new Point[points.size()]);
//	        Arrays.sort(arr);
//	        for(int i=0; i<arr.length; i++) {
//	        	System.out.println("point = ("+arr[i].x+", "+arr[i].y+") and distance is "+arr[i].distance);
//	        }
//	        
//	        System.out.println("======================================================");
	        PriorityQueue<Point> queue = new PriorityQueue<>();
	        queue.add(new Point(1, 1, origin));
	        queue.add(new Point(1, 3, origin));
	        queue.add(new Point(-1, 1, origin));
	        queue.add(new Point(-1, 3, origin));
	        queue.add(new Point(1, -1, origin));
	        queue.add(new Point(3, -1, origin));
	        queue.add(new Point(-1, -1, origin));
	        queue.add(new Point(-1, 3, origin));
	        queue.add(new Point(2, 2, origin));
	        
	        System.out.println(Arrays.toString(queue.toArray()));
//	        
//	        
//	        System.out.println("======================================================");
//	        
//	        ConstructBoard cb = new ConstructBoard(4);
//	        cb.fillItUpRandomly();
//	        cb.print();
//	        
//	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	        String word = br.readLine();
//	        System.out.println(cb.isWordExists(word));
//	        
//	        char[] person = {'A','B','C','D','E','F','G'};
	        
	        Node root1 = new Node('a');
			
	        root1.left = new Node('b');
			
			root1.right = new Node('c');
			
			root1.left.left = new Node('d');
			
			root1.left.right = new Node('e');
			
			root1.right.right = new Node('f');
			
			
			convertBinaryToCircularDoublyLL(root1);
	     
//	        System.out.println(checkIsPalindrome("race c a r"));
			// {5,5,2}
			int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
			dutchFlagProblem(arr);
			System.out.println(areAnagrams("trees", "steer"));
			String str[] = {"trees", "bike", "cars", "steer", "arcs"};
			findSetsOfAnagrams(str);
			int arr1[] = {1,2,5,7,8,10};
			findMissingSortedArr(arr1);
			List<Integer> result = new ArrayList<>();
			findMissingSortedArrNoRepetitions(arr1, 0, arr1.length-1, result);
			System.out.println(Arrays.toString(result.toArray()));
			int array[] = {1,2,0,1,1,0};
			isEndReachable(array);
			moveAllNonZeroToLeftOfZeroBrilliant(array);
			moveAllNonZeroToLeftOfZero(array);
			
			String words[] = {"baa", "abcd", "abca", "cab", "cad"};
			// b-> a, a-> c, d-> a, b -> d
			String colorOrder[] = {"v", "i", "b", "g", "y", "o","r"};
			String colors[] = {"", "", "", "", "", "", "", ""};
			
			int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
		    int A2[] = {2, 1, 8, 3};
		    A1 = sortArrayBasedOnOrderArrayBetter(A1, A2);
		    System.out.println(Arrays.toString(A1));
		    System.out.println(1^0);
		    int[] array1 = {2, 3, 10, 4, 5};
		    cconvertArrToProductArr(array1);
		   
		    int a[] ={2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
		    int order[] ={2, 1, 8, 3};
		    sortArrAccToGivenOrder(a, order);
		    int arry1[] = {1,5, 4, 6, 9, 3, 0, 0, 1, 3};
		    System.out.println("min jumps");
		    System.out.println(minJumpsByFrogToReachEnd(arry1));
		    int arry2[] = {2, 8, 3, 6, 9, 3, 0, 0, 1, 3};
		    System.out.println(minJumpsByFrogToReachEnd(arry2));
	}
	
	
//	Input: A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
//    A2[] = {2, 1, 8, 3}
//Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}
	
	
	static void sortArrAccToGivenOrder(int a[], int order[]) {
		int temp[] = Arrays.copyOf(a, a.length);
		boolean visited[] = new boolean[a.length]; 
		Arrays.sort(temp);
		int[] replaceAt = new int[1];
		for(int i=0; i<order.length; i++) {
			binarySearchAndReplace(a, temp, order[i], replaceAt);
		}
		System.out.println(Arrays.toString(a));
	}
	
	static private void binarySearchAndReplace(int original[], int temp[], int searchFor, int[] replaceAt) {
		int firstMatch = binarySearch(temp, 0, temp.length-1, searchFor);
		if(firstMatch != -1) {
			while(temp[firstMatch] == searchFor) {
				original[replaceAt[0]++] = searchFor;
				firstMatch++;
			}
		}
	}
	
	static private int binarySearch(int arr[], int from, int to, int searchFor) {
		if(from > to)
			return -1;
		
		int mid = (from+to)/2;
		if(arr[mid] == searchFor) {
			int temp = mid;
			while(temp >= 0) {
				if(arr[temp] == searchFor)
					temp--;
				else
					break;
			}
			
			if(temp != mid)
				return temp + 1;
		}
		
		if(arr[mid] < searchFor) {
			return binarySearch(arr, mid+1, to, searchFor);
		} else {
			return binarySearch(arr, from, mid-1, searchFor);
		}
		
	}
	
//	Given an integer array, write a program that returns an array with elements = 
	//product of the integers in input array except the one in its position.
	//Ex: Given input: [2, 3, 10, 4, 5], output: [600, 400, 120, 300, 240]
	
	static void cconvertArrToProductArr(int arr[]) {
		if(arr == null)
			return;
		
		if(arr.length == 1)
			return;
		
		int p =1;
		int p1[] = new int[arr.length];
		int p2[] = new int[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			p1[i] = p;
			p = p * arr[i];
		}
		p = 1;
		for(int i=arr.length-1; i>=0 ;i--) {
			p2[i] = p;
			p = p * arr[i];
		}
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = p1[i] * p2[i];
		}
		
		System.out.println(Arrays.toString(arr));
		
	}
			
			
	static int[ ] sortArrayBasedOnOrderArrayBetter(int[] arr, int order[]) {
		Map<Integer, Integer> mapCount = new HashMap<>();
		for(int i:arr) {
			if(mapCount.containsKey(i)) {
				int count = mapCount.get(i);
				count++;
				mapCount.put(i, count);
			} else {
				mapCount.put(i, 1);
			}
		}
		
		int res[] = new int[arr.length];
		int w = 0;
		for(int i=0; i<order.length; i++) {
			if(mapCount.containsKey(order[i])) {
				int count = mapCount.get(order[i]);
				while(count > 0) {
					res[w++] = order[i];
					count--;
				}
				mapCount.remove(order[i]); // Awesome move
			}
		}
		
		Iterator<Integer> iterator = mapCount.keySet().iterator();
		while(iterator.hasNext()) {
			res[w++] = iterator.next();
		}
		return res;
	}
	
	// inefficient shot
	static int[] sortArrayBasedOnOrderArray(int[] arr, int order[]) {
		int[] res = new int[arr.length];
		int curr = 0;
		for(int i=0; i<order.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[j] == order[i]) {
					res[curr++] = arr[j];
					arr[j] = Integer.MIN_VALUE;
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != Integer.MIN_VALUE) {
				res[curr++] = arr[i];
			}
		}
		
		return res;
	}
	
	
	static void moveAllNonZeroToLeftOfZeroBrilliant(int arr[]) {
		int w = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != 0) {
				arr[w++] = arr[i];
			}
		}
		for(;w<arr.length; w++) {
			arr[w] = 0;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	static void moveAllNonZeroToLeftOfZero(int arr[]) {
		int lastNonZeroIndex = getLastNonZeroIndexFrom(arr, arr.length-1);
		if(lastNonZeroIndex == -1)
			return;
		
		for(int i=0; i<lastNonZeroIndex; i++) {
			if(arr[i] == 0) {
				swap(arr, i, lastNonZeroIndex);
				lastNonZeroIndex = getLastNonZeroIndexFrom(arr, lastNonZeroIndex-1);
				if(lastNonZeroIndex == -1)
					return;
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	static int getLastNonZeroIndexFrom(int arr[], int from) {
		int lastNonZeroIndex = -1;
		for(int i=from; i>=0; i--) {
			if(arr[i] != 0) {
				lastNonZeroIndex = i;
				break;
			}
		}
		return lastNonZeroIndex;
	}
	
//	Example:[1 5 4 6 9 3 0 0 1 3] answer is 3 for this. 
//	[2 8 3 6 9 3 0 0 1 3] answer is 2 for this.
	
	static int minJumpsByFrogToReachEnd(int[] arr) {
		return minJumpsByFrogToReachEnd(arr, 0, arr.length-1);
	}
	
	static int minJumpsByFrogToReachEnd(int[] arr, int from, int to) {
		
		if(from > to)
			return -1;
		
		if(from == to)
			return 0;
		
		int val = arr[from];
		if(from  + val == to)
			return 1;
		
		int minJumps = Integer.MAX_VALUE;
		if(from + val < to) {
			while(val != 0) {
				int jumps = minJumpsByFrogToReachEnd(arr, from+val, to);
				if(jumps != -1) {
					if(minJumps > 1 + jumps) 
						minJumps = 1 + jumps;
				}
				val--;
			}
		}
		if(minJumps != Integer.MAX_VALUE)
			return minJumps;
		else
			return -1;
	}
	
	static void isEndReachable(int arr[]) {
		System.out.println(isEndReachable(arr, 0, arr.length-1));
	}
	//[1, 2, 0, 1, 1, 0]
	static boolean isEndReachable(int arr[], int start, int goal) {
		
		if(start > goal)
			return false;
		
		if(start == goal)
			return true;
		
		if(arr[start] == 0)
			return false;
		
		boolean isReachable = false;
		for(int i=1; i<=arr[start]; i++) {
			isReachable = isEndReachable(arr, start+i, goal);
			if(isReachable)
				return true;
		}
		
		return false;
	}
	
	
	
	// logn // 1 2 5 5 6 7
	static void findMissingSortedArr(int[] arr) {
		List<Integer> missing = new ArrayList<>();
		findMissingSortedArr(arr, 0, arr.length-1, missing);
		System.out.println(Arrays.toString(missing.toArray()));
		
	}
	
	static void findMissingSortedArr(int[] arr, int start, int end, List<Integer> missing) {
		if(start < end) {
			if(end-start == 1) {
				if(arr[end] - arr[start] > 1) {
					int temp = arr[start] + 1;
					while(temp != arr[end]) {
						missing.add(temp);
						temp = temp+1;
					}
				}
			} else { 
				findMissingSortedArr(arr, start, (start+end)/2, missing);
				findMissingSortedArr(arr, (start+end)/2 , end, missing);
			}
			
		}
		
	}
	
	// assuming no repetitions
	static void findMissingSortedArrNoRepetitions(int arr[], int start, int end, List<Integer> missing) {
		if(start < end) {
			if(arr[end] - arr[start] == end - start) {
				return ;
			} else { 
				if(end - start == 1) {
					int temp = arr[start] + 1;
					while(temp != arr[end]) {
						missing.add(temp);
						temp = temp+1;
					}
				} else {
					findMissingSortedArrNoRepetitions(arr, start, (start+end)/2, missing);
					findMissingSortedArrNoRepetitions(arr, (start+end)/2, end, missing);
				}
			}
		}
	}
	
	static void findSetsOfAnagrams(String[] strings) {
		Map<String, List<String>> map = new HashMap<>();
		for(int i=0; i< strings.length; i++) {
			char c[] = strings[i].toCharArray();
			Arrays.sort(c);
			String s = new String(c);
			if(map.containsKey(s)) {
				map.get(s).add(strings[i]);
			} else {
				List<String> list = new ArrayList<>();
				list.add(strings[i]);
				map.put(s, list);
			}
		}
		Set<String> keys = map.keySet();
		Iterator<String> iterator= keys.iterator();
		while(iterator.hasNext()) {
			System.out.println(Arrays.toString(map.get(iterator.next()).toArray()));
		}
	}
	
	static boolean areAnagrams(String s1, String s2) {
		int ascii1[] = new int[256];
		int ascii2[] = new int[256];
		char c1[] = s1.toCharArray();
		char c2[] = s2.toCharArray();
		for(int i=0; ;) {
			if(i >= c1.length && i>=c2.length) {
				break;
			}
			
			if(i < c1.length) {
				ascii1[c1[i]]++;
			}
			
			if(i < c2.length) {
				ascii2[c2[i]]++;
			}
			i++;
		}
		
		for(int i=0; i<ascii1.length; i++) {
			if(ascii1[i] != ascii2[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	static void dutchFlagProblem(int arr[]) {
		int count[] = new int[3];
		for(int i=0; i<arr.length; i++) {
			count[arr[i]]++;
		}
		int j = 0;
		int numOfOccur = 0;
		int i = 0;
		while(j<count.length) {
			numOfOccur = count[j];
			while(numOfOccur > 0) {
				arr[i++] = j;
				numOfOccur--;
			}
			j++;
		}
		
		System.out.println(Arrays.toString(arr));
	}
	// string ignoring spaces Ex: race car
	static boolean checkIsPalindrome(String str) {
		char[] arr = str.toCharArray();
		int start = 0, end = str.length()-1;
		while(start != end) {
			if(arr[start] == ' ') {
				start++;
				continue;
			}
			
			if(arr[end] == ' ') {
				end--;
				continue;
			}
			
			if(arr[start] != arr[end]) 
				return false;
			
			start++;
			end--;
				
		}
		
		return true;
	}
	
	static Node start;
	static Node end; 
	
	static Node convertBinaryToCircularDoublyLL(Node node) {
		if(node == null)
			return null;
		
		convertBinaryToCircularDoublyLinkedLlist(node);
		end.right = start;
		start.left = end;
		Node temp = start;
		System.out.print(temp.value+" ");
		temp = temp.right;
		while(temp != start) {
			System.out.print(temp.value+" ");
			temp = temp.right;
		}
		return start;
		
	}
	
	private static Node convertBinaryToCircularDoublyLinkedLlist(Node node) {
		if(node == null)
			return null;
		
		if(node.value == 'f') 
			System.out.println("");
		
		convertBinaryToCircularDoublyLinkedLlist(node.left);
		if(start == null) {
			start = node;
			end = start;
		} else { 
			node.left = end;
			end.right = node;
			end = node;
		}
		convertBinaryToCircularDoublyLinkedLlist(node.right);
		return node;
	}
	
	
	static CircularDoublyLinkedList constructFrom(Node node) {
		if(node == null)
			return null;
		
		CircularDoublyLinkedList circularDoublyLinkedList = new CircularDoublyLinkedList();
		Queue<Node> queue = new LinkedBlockingQueue<>(10);
		queue.add(node);
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			circularDoublyLinkedList.add(curr.value);
			if(curr.left != null)
				queue.add(curr.left);
			if(curr.right != null)
				queue.add(curr.right);
		}
		
		return circularDoublyLinkedList;
		
	}
	
	
	
}

class CircularDoublyLinkedList {
	DoublyLinkedList start;
	DoublyLinkedList end;
	
	public CircularDoublyLinkedList() {
		
	}
	
	public void add(char value) {
		
		if(start == null) {
		
			start = new DoublyLinkedList(value);
			end = start;
			end.next = start;
			start.prev = end;
			
		} else { 
			
			DoublyLinkedList temp = start;
			while(temp.next != start) {
				temp = temp.next;
			}
			// temp == end
			temp.next = new DoublyLinkedList(value);
			temp = temp.next;
			temp.prev = end;
			temp.next = start;
			start.prev = temp;
			end = temp;	
		}
	}
	
	public void print() {
		DoublyLinkedList temp = start;
		while(temp.next != start) {
			System.out.print(temp.value+" ");
			temp = temp.next;
		}
		System.out.print(temp.value+" ");
		System.out.println();
	}
}

class DoublyLinkedList { 
	DoublyLinkedList prev;
	DoublyLinkedList next;
	char value;
	public DoublyLinkedList(char value) {
		this.value = value;
	}
}

class FindCelebrity { 
	 
	char[] person = null;
	public FindCelebrity(char[] person) {
		this.person = person;
	}
	
	public void findCeleb() {
		char celeb = person[0];
		for(int i=1; i<person.length; i++) {
			if(knows(celeb, person[i])) {
				celeb = person[i];
			}  
			if(knows(person[i], celeb)){
				
			} else { 
				if(i+1 < person.length) {
					celeb = person[i+1];
					i = i+1;
				}
			}
		}
	}
	
	private boolean knows(char p1, char p2) {
		return false;
		
	}
	
}


class Point implements Comparable<Point> {
	int x;
	int y;
	double distance;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, Point origin) {
		this.x = x;
		this.y = y;
		this.distance = Math.hypot(x-origin.x, y-origin.y);
	}

	@Override
	public int compareTo(Point o) {
		if(this.distance > o.distance)
			return 1;
		else if(this.distance < o.distance)
			return -1;
		else
			return 0;
	}
	
	@Override
	public String toString() {
		return "point = ("+x+", "+y+") and distance is "+distance+"";
	}
}


class ConstructBoard {
	
	char[][] board;
	int size;
	public ConstructBoard(int size) {
		this.size = size;
		this.board = new char[size][size];
	}
	
	public void fillItUpRandomly() {
		Random r = new Random();
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				board[i][j] = (char)((int)'A' + r.nextInt(26));
			}
		}
	}
	
	public void print() {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public boolean isWordExists(String word) {
		char[] str = word.toCharArray();
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(board[i][j] == str[0]) {
					if(isWordExists(str, 0, i, j))
						return true;
				}
			}
		}
		return false;
	}
	
	private boolean isWordExists(char[] arr, int currIndex, int row, int col) {
		
		if(currIndex >= arr.length)
			return true;
		
		if(row < 0 || row >= size || col < 0 || col >=size)
			return false; 
		
		if(arr[currIndex] == board[row][col]) {
				
			// next char can be above, below, left, right, diag
			return isWordExists(arr, currIndex+1, row-1, col) || isWordExists(arr, currIndex+1, row+1, col) || isWordExists(arr, currIndex+1, row, col-1)
					|| isWordExists(arr, currIndex+1, row, col+1) || isWordExists(arr, currIndex+1, row-1, col-1) || isWordExists(arr, currIndex+1, row+1, col+1)
					|| isWordExists(arr, currIndex+1, row+1, col-1) || isWordExists(arr, currIndex+1, row-1, col+1);
			
		}
		
		return false;
	}
}
