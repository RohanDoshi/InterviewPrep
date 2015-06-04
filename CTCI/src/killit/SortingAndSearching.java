package killit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class SortingAndSearching {

	public static void main(String args[]) {
		SortingAndSearching ss = new SortingAndSearching();
		int a[] = {0,2,4,6,8,10, 0, 0, 0};
		int b[] = {1,3,5};
		ss.mergeSortedArrIntoA(a, b);
		System.out.println(Arrays.toString(a));
		String arr[] = {"crak", "kar", "nar", "mac", "run", "ran", "rack", "ark", "cam", "nur", "crak"};
		//ss.sortStringAnagrams(arr);
		
		//Arrays.sort(arr, ss);
		System.out.println(Arrays.toString(arr));
		int shifted[] = {2,2,2,2,-1,0,1,2};
		ss.shiftedArrfindelem(shifted, 0); // does not work
		
		String[] things = {"at", "", "", "", "ball","","", "car","","","dad","",""};
		System.out.println("location of str -> "+ss.findLocationOfString(things, "ball"));
		int mat[][] = {{7,6,10},{9,12,15},{11,18,20}};
		ss.rowColSortedMatrix(mat, 19);
		ss.rowColSortedMatrixExcellent(mat, 20);
		//(65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
		Person p1 = new Person(65, 100);
		Person p2 = new Person(70, 150);
		Person p3 = new Person(76, 90);
		Person p4 = new Person(75, 190);
		Person p5 = new Person(80, 95);
		Person p6 = new Person(68, 110);
		Comparator<Person> comparator = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if(o1.height < o2.height)
					return 1;
				else if(o1.height > o2.height)
					return -1;
				else 
					return 0;
			}
		};
		Person[] persons = {p1, p2, p3, p4, p5, p6};
		Arrays.sort(persons, comparator);
		System.out.println(Arrays.toString(persons));
		ss.arrangeCircusStack(persons);
		int[] arr1= {1,2,3};
		ss.printAllSubsets(arr1);
	}
	
	public void printAllSubsets(int[] arr) {
		int n = arr.length;
		int comb = 1 << n;
		for(int i=0; i<comb; i++) {
			System.out.print("{");
			for(int j=0; j<arr.length; j++) {
				if((i & (1 << j)) > 0) {
					System.out.print(arr[j]+" ");
				}
			}
			System.out.print("}\n");
		}
	}
	
	public void rowColSortedMatrixExcellent(int[][] arr, int element) {
		if(arr == null || arr.length == 0)
			return;
		
		int row = 0;
		int col = arr[0].length-1;
		
		while(row < arr.length && col >= 0) {
			if(arr[row][col] == element)  {
				System.out.println("row="+row+" and col="+col);
				break;
			} else if(element < arr[row][col]) {
				col--;
			} else {
				row++;
			}
		}
	}
	
	
	public void rowColSortedMatrix(int[][] arr, int element) {
		int row = -1, col = -1;
		
		for(int i=0; i<arr.length; i++) {
			int index = rowBinarySearch(arr, i, 0, arr[i].length-1, element);
			if(index != -1) {
				row = i;
				col = index;
				break;
			}
		}
		if(row == -1 || col == -1)
			System.out.println("Not found");
		else
			System.out.println("row="+row+" and col="+col);
	}
	
	private int rowBinarySearch(int[][] arr, int row, int colStart, int colEnd, int element) {
		if(colStart > colEnd) 
			return -1;
		
		int mid = (colStart + colEnd)/2;
		if(arr[row][mid] == element)
			return mid;
		
		if(arr[row][mid] < element) 
			return rowBinarySearch(arr, row, mid+1, colEnd, element);
		else
			return rowBinarySearch(arr, row, colStart, mid-1, element);
	}
	
	
	private int colBinarySearch(int[][] arr, int rowStart, int rowEnd, int col, int element) {
		if(rowStart > rowEnd) 
			return -1;
		
		int mid = (rowStart + rowEnd)/2;
		if(arr[mid][col] == element)
			return mid;
		
		if(arr[mid][col] < element)
			return colBinarySearch(arr, mid+1, rowEnd, col, element);
		else
			return colBinarySearch(arr, rowStart, mid-1, col, element);
	}
	
	// array interspersed with empty ones
	public int findLocationOfString(String[] arr, String str) {
		return findLocationOfString(arr, 0, arr.length-1, str);
	}
	
	private int findLocationOfString(String[] arr, int start, int end, String str) {
		if(start > end)
			return -1;
		
		int mid = (start+end)/2;
		
		if(arr[mid] == "") {
			int temp = mid;
			while(temp <= end && arr[temp] == "") {
				temp++;
			}
			
			if(temp > end) {
				return -1;
			} else { 
				mid = temp;
			}
		}
		
		if(arr[mid].compareTo(str) == 0)
			return mid;
		
		if(str.compareTo(arr[mid]) < 0) {
			return findLocationOfString(arr, start, mid-1, str);
		} else { 
			return findLocationOfString(arr, mid+1, end, str);
		}
	}
	
	// 1 2 3 4 5
	// 5 1 2 3 4
	// 3 4 5 1 2
	
	public void shiftedArrfindelem(int[] arr, int elem) {
		int index = bs(arr, 0, arr.length-1, elem);
		System.out.println("Found at --> "+index);
	}
	
	private int bs(int[] arr, int start, int end, int elem ) {
		if(start > end)
			return -1;
		
		if(arr[start] == elem)
			return start;
		
		if(arr[end] == elem)
			return end;
		
		if(arr[start] <= arr[end]) {
			// arr sorted
			if(elem < arr[start])
				return -1;
			
			if(elem > arr[end]) 
				return -1;
			
			int mid = (start+end)/2;
			
			if(arr[mid] == elem)
				return mid;
			
			if(elem < arr[mid]) {
				return bs(arr, start, mid-1, elem);
			} else {
				return bs(arr, mid+1, end, elem);
			}
		} else {
			int mid = (start+end)/2;
			
			if(arr[mid] == elem)
				return mid;
			
			if(elem < arr[mid] && elem >= arr[start]) {
				return bs(arr, start, mid-1, elem);
			}
			
			if(elem < arr[mid] && elem < arr[start]) {
				return bs(arr, start+1, end, elem);
			}
			
			if(elem > arr[mid] && elem <= arr[end]) {
				return bs(arr, mid+1, end, elem);
			}
			
			if(elem > arr[mid] && elem > arr[end]) {
				return bs(arr, start, mid-1, elem);
			}
			
			return -1;
		}
	}
	
	// sort an array of strings so anagrams are each other
	
	public void sortStringAnagrams(String[] arr) {
		Map<String, List<String>> map = new HashMap<>();
		for(String s : arr) {
			char c[]  = s.toCharArray();
			Arrays.sort(c);
			String sort = new String(c);
			if(map.containsKey(sort)) {
				map.get(sort).add(s);
			} else {
				List<String> list = new ArrayList<>();
				list.add(s);
				map.put(sort, list);
			}
		}
		
		String[] keys = map.keySet().toArray(new String[map.keySet().size()]);
		int i = 0;
		for(String k : keys) {
			List<String> list = map.get(k);
			for(String l : list) {
				arr[i++] = l;
			}
		}
		
		System.out.println("anagram groups = "+map.size()+" "+Arrays.toString(arr));
	}
	
	public void mergeSortedArrIntoA(int[] a, int[] b) {
		int aLen = a.length;
		int bLen = b.length;
		
		int aEnd = aLen - bLen -1;
		int bEnd = bLen - 1;
		int placeFrom = aLen-1;
		
		while(aEnd >= 0 && bEnd >= 0) {
			if(a[aEnd] > b[bEnd]) {
				a[placeFrom] = a[aEnd];
				aEnd--;
			} else {
				a[placeFrom] = b[bEnd];
				bEnd--;
			}
			placeFrom--;
		}
		
		for(; placeFrom >= 0; placeFrom--) {
			if(aEnd >= 0) {
				a[placeFrom] = a[aEnd];
				aEnd--;
			} else if(bEnd >=0 ) {
				a[placeFrom] = b[bEnd];
				bEnd--;
			}
		}
	}

	
	
	public String sort(String o1) {
		char c[] = o1.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	public void arrangeCircusStack(Person[] arr) {
		int maxStack = 0;
		for(int i=0; i<arr.length; i++) {
			Stack<Person> stack = new Stack<>();
			stack.push(arr[i]);
			int max = arrangeCircusStackBuild(arr, arr[i], 0, stack);
			if(max > maxStack) 
				maxStack = max;
		}
		System.out.println("Max Height = "+maxStack);
	}
	//
	//(65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)	
	private int arrangeCircusStackBuild(Person[] arr, Person basePerson, int checkFrom, Stack<Person> stack) {
		
		int maxHeight = stack.size();
		for(int i=checkFrom; i<arr.length; i++) {
			if(!stack.contains(arr[i]) && arr[i].height < stack.peek().height && arr[i].weight < stack.peek().weight) {
				stack.push(arr[i]);
				int stackSize = arrangeCircusStackBuild(arr, basePerson, 0, stack);
				if(stackSize > maxHeight)
					maxHeight = stackSize;
				stack.pop();
			}
		}
		if(maxHeight == 4)
			System.out.println(Arrays.toString(stack.toArray()));
		return maxHeight;
	}
}

class Person {
	int height;
	int weight;
	
	public Person(int weight, int height) {
		this.height = height;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "("+weight+","+height+")";
	}
}


class BinarySearchTree { 
	private class Node { 
		Node left;
		Node right;
		int val;
		int leftSize;
		
		public Node(int val) {
			this.val = val;
		}
	}
	
	private Node root; 
	
	public BinarySearchTree(int val) {
		this.root = new Node(val);
	}
	
	public void add(int val) {
		this.root = add(this.root, val);
	}
	
	private Node add(Node node, int val) {
		if(node == null)
			return new Node(val);
		
		if(val >= node.val) 
			node.right =  add(node.right, val);
		else {
			node.leftSize++;
			node.left = add(node.left, val);
		}
		
		return node;
	}
	
	public int getRank(int val) {
		return getRank(root,val);
	}
	
	private int getRank(Node node, int val) {
		if(node == null)
			return -1;
		
		if(node.val == val)
			return node.leftSize;
		
		if(val < node.val)
			return getRank(node.left, val);
		else {
			int found =  getRank(node.right, val);
			if(found == -1)
				return -1;
			else
				return  node.leftSize + 1 + found;
		}
	}
	
	
}

