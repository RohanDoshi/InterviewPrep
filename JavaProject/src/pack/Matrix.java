package pack;

import java.util.Arrays;

public class Matrix {

	public static void main(String[] args) {
		int a[][] ={{10, 20, 30, 40}, {15, 25, 35, 45}, {24, 29, 37, 48}, {32, 33, 39, 50}};
		Mat mat = new Mat();
		//mat.kSmallestElementEfficient(a, 7);
		int arr[][] = { {1, 1, 1, 1, 1},
	            {2, 2, 2, 2, 2},
	            {3, 3, 3, 3, 3},
	            {4, 4, 4, 4, 4},
	            {5, 5, 5, 5, 5},
	         };
		//mat.printSpiral(a);
		//mat.printSumOfKByKArrays(arr, 3);
//		int temp[][] = mat.transpose(arr);
//		for(int i=0; i<temp.length; i++) {
//			System.out.println(Arrays.toString(temp[i]));
//		}
//		
//		KthSmallestSortedMatrix element = new KthSmallestSortedMatrix();
//		element.kthSmallest(arr, 24);
		
		int ar1[] = {1, 12, 15, 26, 38};
	    int ar2[] = {2, 13, 17, 30, 45};
	    // 1 2 12 13 15 17 26 30 38 45
	    MedianOfSortedArrays arrays = new MedianOfSortedArrays();
	//    arrays.median(ar1, ar2);
	    
	    int sortedArr[][] = { {1, 3, 5, 7},
	            {2, 4, 6, 8},
	            {0, 9, 10, 11}} ;
		
	    PrintDiagonalWiseTopBot obj = new PrintDiagonalWiseTopBot();
	    obj.print();
	}

}

class PrintDiagonalWiseTopBot { 
	
	int arr[][] = { {1, 1, 1, 1, 1},
            {2, 2, 2, 2, 2},
            {3, 3, 3, 3, 3},
            {4, 4, 4, 4, 4},
            {5, 5, 5, 5, 5},
         };
	
	public void print() { 
		
		int cRow = 0, cCol = 0;
		while(cRow <= arr.length-1) {
			print(cRow, cCol);
			cRow ++;
		}
		
		cRow--;
		cCol++;
		while(cCol <= arr[0].length-1) {
			print(cRow, cCol);
			cCol++;
		}
		
	}
	
	private void print(int r, int c) {
		int COL = c;
		int ROW = r;
		if( c == r) {
			System.out.println(arr[r][c]);
			return;
		}
		
		 while(r >= COL && c <= ROW) {
			 System.out.print(arr[r--][c++]+" ");
		 }
		 System.out.println("");
	}
}

class SortKSortedArrays { 
	
	int sortedArr[][] = null; 
	int resultArr[] = null;
	private Heap heap ; 
	private class Heap {
		int heap[] = null;
		int heapSize = 0;
		public Heap(int size) {
			this.heap = new int[size];
		}
		
		public void add(int i) {
			heap[heapSize++] = i;
			maxHeapify(heapSize -1);
		}
		
		public void maxHeapify(int index) {
			if(index == 0) {
				return;
			}
			int leftIndex = leftIndex(index);
			int rightIndex = rightIndex(index);
			int smallestIndex = index;
			
			if(leftIndex < heapSize && heap[leftIndex] < heap[smallestIndex]) {
				smallestIndex = leftIndex;
			}
			
			if(rightIndex < heapSize && heap[rightIndex] < heap[smallestIndex]) {
				smallestIndex = rightIndex;
			}
			
			if(smallestIndex != index) {
				int temp = heap[smallestIndex];
				heap[smallestIndex] = heap[index];
				heap[index] = temp;
				maxHeapify(smallestIndex);
			}
			
		}
		
		public void buildMinHeap() {
			for(int i= heap.length/2; i>=0 ; i++) {
				maxHeapify(i);
			}
		}
		
		public int parentIndex(int index) {
			return (index-1)/2 ;
		}
		
		public int leftIndex(int index) {
			return 2*index + 1;
		}
		
		public int rightIndex(int index) {
			return 2*index + 2;
		}
		
		
	}
	public SortKSortedArrays(int sortedArr[][] ) {
		this.sortedArr = sortedArr;
		this.heap = new Heap(sortedArr[0].length);
		this.resultArr = new int[sortedArr.length * sortedArr[0].length];
	}
	
	public void sortUsingHeap() { 
		for(int i=0; i<sortedArr[0].length; i++) {
			heap.add(sortedArr[0][i]);
		}
		int resultIndex = 0;
		int nRows = sortedArr.length;
		int nCols = sortedArr[0].length;
		for(int i=0; i<nRows * nCols; i++) {
			
		}
	}
}
class MedianOfSortedArrays { 
	
	public void median(int ar1[] , int ar2[]) {
		median(ar1, ar2, 0, ar1.length-1, 0, ar2.length-1);
	}
	
	private void median(int ar1[] , int ar2[], int a1, int b1, int a2, int b2) {
		int m1 = (a1 + b1)/2;
		int m2 = (a2 + b2)/2;
		
		if(m1 == m2) {
			System.out.println("median ---> "+ar1[m1]);
			return;
		} else if(m1 < m2) {
			median(ar1, ar2, m1, b1, a2, m2);
		} else {
			median(ar1, ar2, m1, b1, m2, b2);
		}
	}
}
class KthSmallestSortedMatrix { 
	
	private HeapNode head;
	
	public void add(int val, int row, int col) {
		HeapNode node = new HeapNode(val, row, col);
		addToQueue(node);
	}
	
	public HeapNode peek() {
		return head;
	}
	
	public HeapNode poll() {
		if(head != null) {
			HeapNode node = head;
			head = head.next;
			return node;
		}
		return null;
	}
	
	public void print(HeapNode node) {
		HeapNode temp = node;
		while(temp != null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
	}
	
	private void addToQueue(HeapNode node) {
		if(head == null) {
			head = node;
		} else { 
			if(node.val <= head.val) {
				node.next = head;
				head = node;
			} else { 
				HeapNode temp = head.next;
				HeapNode prev = head;
				while(temp != null) {
					if(node.val <= temp.val) {
						node.next = temp;
						prev.next = node;
						break;
					} else {
						temp = temp.next;
						prev = prev.next;
					}
				}
				
				if(temp == null) {
					prev.next = node;
				}
			}	
		}
		
		System.out.println("After adding "+node.val);
		print(head);
		System.out.println();
	}
	
	
	
	private class HeapNode { 
		int val;
		int row; 
		int col;
		HeapNode next;
		
		public HeapNode(int val, int row, int col) {
			this.val = val;
			this.row = row;
			this.col = col;
		}
	}
	public void kthSmallest(int ar[][] , int k ) {
		for(int i=0; i<ar[0].length; i++) {
			add(ar[0][i], 0, i);
		}
		
		for(int i=1; i<=k; i++) {
			HeapNode node = poll();
			if(i == k) {
				System.out.println("kth smallest ---> "+node.val+" ");
				return;
			}
			
			if(node.row+1 < ar.length) {
				add(ar[node.row+1][node.col], node.row+1, node.col);
			} else {
				//add(Integer.MAX_VALUE, -1 , -1);
				
			}
		}
	}
}

class Mat {
	
	public int[][] transpose(int a[][] ) {
		int rows = a.length;
		int cols = a[0].length;
		int[][] trans = new int[cols][rows];
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				trans[j][i] = a[i][j];
			}
		}
		return trans;
	}
	
	public void printSumOfKByKArrays(int[][] a, int k) {
		int[][] res = new int[k][k];
		for(int i=0; i<k; i++) {
			for(int j=0; j<k; j++) {
				printSumKK(a, i, j, k);
			}
			System.out.println();
		}
	}
	
	public void printSumKK(int[][] a, int rowFrom, int colFrom, int k) {
		int sum = 0;
		for(int i=rowFrom; i < rowFrom + k; i++) {
			for(int j=colFrom; j< colFrom + k; j++ ) {
				sum += a[i][j];
			}
		}
		System.out.print(sum+" ");
 	}
	
	
	HeapNode a[] = null;
	int heapSize = -1;
	
	public void matrixMultiply(int a[][], int b[][], int res[][], int n) { 
		matrixMultiply(a, b, res, 0, a[0].length-1, 0, b[0].length-1, n);
	}
	
	// in correct 
	private void matrixMultiply(int a[][], int b[][] , int res[][], int r1, int c1, int r2, int c2, int n) {
		if(n == 1) {
			res[n-1][n-1] = a[r1][c1] * b[r2][c2];
		}
		
		if(n == 2) {
			 matrixMultiply(a, b, res, r1, c1/2, r2, c2/2, n/2) ;
			matrixMultiply(a, b, res,  r1, c1, r1+1, c2/2, n/2);
		}
		
		else {
			 matrixMultiply(a, b, res, r1/2, c1/2, r2/2, c2/2, n/2);
		}
	}
	public void printSpiral(int[][] a ) { 
		print(a, 0, a[0].length, a.length, a[0].length);
	}
	
	private void print(int[][] a, int row1, int col1, int numRow, int numCol) {
		if(numRow == 0 || numCol ==0) {
			return;
		}
		
		int r = row1, c = col1;
		int i = 0;
		while( i < numCol) {
			System.out.print(a[r][--c]+" ");
			i++;
		}
		
		numRow--;
		i = 0;
		while(i < numRow) {
			System.out.print(a[++r][c]+" ");
			i++;
		}
		
		numCol --;
		i = 0;
		while(i < numCol) {
			System.out.print(a[r][++c]+" ");
			i++;
		}
		
		numRow--;
		i = 0;
		while(i < numRow) {
			System.out.print(a[--r][c]+" ");
			i++;
		}
		i = 0;
		
		
		numCol--;
		
		print(a, r, c, numRow, numCol);
		
		
	}
	
	private class HeapNode {
		int row; 
		int col; 
		int val; 
		
		public HeapNode(int val, int row, int col) {
			this.val = val;
			this.row = row;
			this.col = col;
		}
		
	}
	
	private void swap(int i, int j) {
		HeapNode temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void buildMinHeap(HeapNode a[]) { 
		this.a = a; 
		this.heapSize = a.length;
		for(int i=a.length/2; i>=0; i--) {
			minHeapify(i);
		}
	}
	
	public void minHeapify(int i) {
		int leftIndex = leftChild(i);
		int rightIndex = rightChild(i);
		int smallestIndex = i;
		if(leftIndex < heapSize && a[leftIndex].val < a[smallestIndex].val) {
			smallestIndex = leftIndex;
		}
		
		if(rightIndex < heapSize && a[rightIndex].val < a[smallestIndex].val) {
			smallestIndex = rightIndex;
		}
		
		if(smallestIndex != i) {
			swap(smallestIndex, i);
			minHeapify(smallestIndex);
		}
	}
	
	public void kSmallestElementEfficient(int a[][], int k) { 
		// build min heap from first row
		HeapNode nodes[] = new HeapNode[a[0].length];
		for(int i=0; i<a[0].length; i++) {
			nodes[i] = new HeapNode(a[0][i], 0, i);
		}
		for(int i=1; i<=k; i++) {
			buildMinHeap(nodes);
			// first element is min element
			HeapNode min = nodes[0];
			System.out.println("i="+i+" min="+min.val);
			if(i == k)
				return;
			// take next element in min's col 
			if(min.row + 1 >= a.length) 
				min.val = Integer.MAX_VALUE;
			else {
				min.row = min.row + 1;
				min.col = min.col;
				min.val = a[min.row][min.col];
			}
		}
		System.out.println(nodes[0].val);
		
	}
	
	int leftChild(int index) {
		return 2*index + 1; 
	}
	
	int rightChild(int index) {
		return 2*index + 2;
	}
	
	int parent(int index) {
		return index/2;
	}
	
	
	public void kSmallestElement(int a[][], int k) {
		int arr[] = constructArray(a);
		Heap heap = new Heap(arr);
		heap.sort();
		System.out.println(heap.getValue(arr.length - k));
	}
	
	public int[] constructArray(int a[][]) {
		int temp[] = new int[a.length * a[0].length];
		int count = 0;
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[0].length; j++) {
				temp[count++] = a[i][j];
			}
		}
		
		return temp;
	}
}

class Heap {
	
	int a[] = null;
	int heapSize = 0;
	
	int leftChild(int index) {
		return 2*index + 1; 
	}
	
	int rightChild(int index) {
		return 2*index + 2;
	}
	
	int parent(int index) {
		return index/2;
	}
	
	int getValue(int index) {
		if(index >= a.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		return a[index];
	}
	
	public Heap(int[] a) {
		this.heapSize = a.length;
		this.a = a;
	}
	
	public void sort() {
		buildMinHeap();
		for(int i = a.length-1; i >0; i--) {
			swap(0, i);
			this.heapSize--;
			heapify(0);
		}
		System.out.println(Arrays.toString(a));
	}
	
	private void buildMinHeap() {
		for(int i=a.length/2; i>=0; i--) {
			heapify(i);
		}
	}
	
	private void heapify(int index) {
		int leftIndex = leftChild(index);
		int rightIndex = rightChild(index);
		int smallestIndex = index;
		
		if(leftIndex < heapSize && a[leftIndex] < a[smallestIndex]) {
			smallestIndex = leftIndex;
		}
		
		if(rightIndex < heapSize && a[rightIndex] < a[smallestIndex]) {
			smallestIndex = rightIndex;
		}
		
		if(smallestIndex != index) {
			swap(index, smallestIndex);
			heapify(smallestIndex);
		}
	}
	
	private void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
}