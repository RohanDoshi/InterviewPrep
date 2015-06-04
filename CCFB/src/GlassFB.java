import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

import javax.xml.crypto.dsig.keyinfo.PGPData;




public class GlassFB {

	public static void main(String[] args) throws IOException {
		BinaryNode<Integer> node = new BinaryNode<Integer>(1);
		node.left = new BinaryNode<Integer>(2);
		node.right = new BinaryNode<Integer>(3);
		node.left.left = new BinaryNode<Integer>(4);
		node.left.right = new BinaryNode<Integer>(5);
		node.left.right.left = new BinaryNode<Integer>(8);
		node.right.left = new BinaryNode<Integer>(6);
		node.right.left.right = new BinaryNode<Integer>(9);
		node.right.right = new BinaryNode<Integer>(7);
		
		GlassFB fb = new GlassFB();
		fb.printSumOfEachPath(node);
		
		
		Node list = new Node(1);
		list.next = new Node(2);
		list.next.next = new Node(3);
		list.next.next.next = new Node(4);
		list.next.next.next.next = new Node(5);
		list.next.next.next.next.next = new Node(6);
		list.next.next.next.next.next.next = new Node(7);
		
		list = fb.reverse(list);
		fb.printList(list);
		list = fb.reverseIter(list);
		fb.printList(list);
		
		NQueens2 nQueens = new NQueens2(8);
		
		fb.allSetsSumToN(4);
		int set[] = {2,3,3};
		fb.printAllSubsetsOfLengthK(set, 2);
		String s[] = {"foo", "food", "foog", "asdf"};
		fb.smallestSubsetContainingPrefixesOfEveryString(s);
		
		Vector<Integer> v = new Vector<>();
		v.add(1);
		v.add(2);
		
		Vector<Integer> v1 = new Vector<>();
		v1.add(2);
		v1.add(1);
		
		Set<Vector<Integer>> set1 = new HashSet<>();
		set1.add(v);
		set1.add(v1);
		
		System.out.println(set1.size());
		fb.countAndSay(5);
		fb.countAndSay(6);
		int[] part = {5,3,6,1,2,4};
		fb.sumKLargestDigits(part, 2);
		
		final LRU<Integer, String> lru = new LRU<>(5);
		Thread t = new Thread() {
			@Override
			public void run() {
				lru.add(1, "ONE");
				lru.add(2, "TOO");
				lru.add(3, "THREE");
			}
		};
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				System.out.println(lru.get(1));
				lru.print();
				lru.add(2, "TWO");
				lru.add(5, "FIVE");
				lru.add(6, "SIX");
				lru.add(4, "FOUR");
				lru.print();
			};
		};
		//4 6 5 2 1 
//		lru.add(1, "ONE");
//		lru.add(2, "TOO");
//		lru.add(3, "THREE");
//		System.out.println(lru.get(1));
//		lru.print();
//		lru.add(2, "TWO");
//		lru.add(5, "FIVE");
//		lru.add(6, "SIX");
//		lru.add(4, "FOUR");
//		lru.print();
//		t.start();
//		t1.start(); 
		
		int[] arr = {2,5,6,4,6,1,6,6};
		System.out.println(fb.returnIndexLargestUniformlyAtRandom(arr));
		Range r = new Range(1, 2);
		Range r1 = new Range(1, 2);
		Range r2 = new Range(2, 1);
		System.out.println(r.hashCode()+" "+r1.hashCode()+" "+r2.hashCode());
		int zero[] = {0,1,0,-2,-1,3,-1,0};
		fb.moveZeroesToEnd(zero);
		System.out.println(Arrays.toString(zero));
		//fb.ReadLine();
		fb.consecutiveSeqNumWhoseSumEqTarget(zero, 0);
		int[][] minPath = {{1,2,3}, {4,8,2}, {1,5,3}};
		System.out.println(fb.minPathMatrixDP(minPath, 0, 0, 2, 2));
		
		
		BinaryNode<Integer> colNode = new BinaryNode(8);
		colNode.left = new BinaryNode(6);
		colNode.right = new BinaryNode(10);
		colNode.left.left = new BinaryNode(4);
		colNode.left.right = new BinaryNode(7);
		colNode.left.left.left = new BinaryNode(3);
		colNode.left.left.right = new BinaryNode(5);
		colNode.right.left = new BinaryNode(9);
		colNode.right.right = new BinaryNode(12);
		
		fb.printTreeColWise(colNode);
		fb.printAllPathsLeafToLeaf(colNode);
		
		
		BinaryNode<Integer> binaryNode = new BinaryNode(1);
		binaryNode.left = new BinaryNode(2);
		binaryNode.right = new BinaryNode(3);
		binaryNode.left.left = new BinaryNode(4);
		binaryNode.left.right = new BinaryNode(5);
		binaryNode.right.left = new BinaryNode(6);
		binaryNode.right.right = new BinaryNode(7);
		binaryNode.right.right.right = new BinaryNode(8);
		binaryNode.right.right.right.right = new BinaryNode(9);
		binaryNode.left.left.left = new BinaryNode(10);
		binaryNode.left.left.left.left = new BinaryNode(11);
		binaryNode.left.left.left.left.left = new BinaryNode(12);
		binaryNode.left.right.right = new BinaryNode(51);
		binaryNode.left.right.right.right = new BinaryNode(52);
		binaryNode.left.right.right.right.right = new BinaryNode(53);
		binaryNode.left.right.right.right.right.right = new BinaryNode(54);
		binaryNode.left.right.right.right.right.right.right = new BinaryNode(55);
		binaryNode.left.right.right.right.right.right.right.right = new BinaryNode(56);
		binaryNode.left.right.right.right.right.right.right.right.right = new BinaryNode(57);
		
		int[] max = new int[1];
		System.out.println(fb.diameter(binaryNode, max)+" diameter -> "+max[0]);
		System.out.println(fb.power(2, -4)+" "+Math.pow(2, -4)+" "+fb.powerEfficient(2, -4));
		System.out.println(Math.pow(2, 4));
		Page6 pg = new Page6();
		int[] bst = {1,2,3,4,5,6,7};
		BinaryNode<Integer> binarySearchTree = pg.constructBST(bst);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("bst")));
		fb.serialization(binarySearchTree, bw);
		bw.close();
		
		BufferedReader br = new BufferedReader(new FileReader(new File("bst")));
		BinaryNode<Integer> deser = fb.deserialization(br);
		fb.inOrder(deser);
		int preOrder[] = {4,2,1,3,6,5,7};
		System.out.println("-->"+fb.arrayOdd(preOrder, preOrder.length));
		
		System.out.println(572 % 273);
		System.out.println(572 % 26);
	}
	
	public BinaryNode<Integer> buildTree(int[] preOrder) {
		return buildTree(preOrder, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public BinaryNode<Integer> buildTree(int[] preOrder, int index, int min, int max) {
		if(index > preOrder.length)
			return null;
		
		BinaryNode<Integer> node = new BinaryNode(preOrder[index]);
		node.left = buildTree(preOrder, index+1, min, preOrder[index]);
		node.right = buildTree(preOrder, index, min, max);
		return null;
	}
	
	 
	int arrayOdd(int A[ ], int n) 
	{ 
	 if(n < 1) 
	 return 0; 
	 else 
	 return A[n-1]%2 + arrayOdd( A, n-1); 
	}
	
	public void inOrder(BinaryNode<Integer> node) {
		if(node == null)
			return;
		
		inOrder(node.left);
		System.out.print(node.value+ " ");
		inOrder(node.right);
	}
	
	public BinaryNode<Integer> deserialization(BufferedReader br) throws NumberFormatException, IOException {
		int[] lastRead = new int[1];
		return deserialization(br, Integer.MIN_VALUE, Integer.MAX_VALUE, lastRead);
	}
	
	public BinaryNode<Integer> deserialization(BufferedReader br, int min, int max, int[] lastRead) throws NumberFormatException, IOException {
		String s = br.readLine();
		if(s == null)
			return null;
		int nodeVal = Integer.parseInt(s);
		if(nodeVal >= min && nodeVal < max) {
			BinaryNode<Integer> binaryNode = new BinaryNode(nodeVal);
			binaryNode.left = deserialization(br, min, nodeVal, lastRead);
			binaryNode.right = deserialization(br, nodeVal, max, lastRead);
			return binaryNode;
		} else {
			lastRead[0] = nodeVal;
			return null;
		}
	}
	
	public void serialization(BinaryNode<Integer> bst, BufferedWriter bw) throws IOException {
		if(bst == null)
			return;
		
		bw.write(Integer.toString(bst.value)+"\n");
		serialization(bst.left, bw);
		serialization(bst.right, bw);
	}
	
	public double powerEfficient(double a, double b) {
		if(b < 0)
			return 1/powerEfficient(a, -b);
		
		if(b == 0)
			return 1;
		
		if(b == 1)
			return a;
		
		if(b % 2 == 0) 
			return powerEfficient(a*a, b/2);
		else
			return powerEfficient(a*a, b/2)*a;
	}
	
	
	public double power(double a, double b) {
		if(b < 0)
			return 1/power(a, -b);
		if(b == 0)
			return 1;
		
		if(b == 1)
			return a;
		
		return a*power(a,b-1);
	}
	
	
	public int diameter(BinaryNode<Integer> node, int max[]) {
		if(node == null)
			return 0;
		
		int left = diameter(node.left, max);
		int right = diameter(node.right, max);
		int curr = 1;
		int dia = left + right + curr;
		if(dia > max[0])
			max[0] = dia;
		return 1 + Math.max(left, right);
	}
	
	
	public void printAllPathsLeafToLeaf(BinaryNode<Integer> node) {
		List<List<BinaryNode<Integer>>> list = new ArrayList<>();
		printAllPathsLeafToLeaf(node, list);
		for(List<BinaryNode<Integer>> l : list) {
			System.out.println(l.toString());
		}
	}
	
	public void printAllPathsLeafToLeaf(BinaryNode<Integer> node, List<List<BinaryNode<Integer>>> list) {
		if(node == null)
			return;
		
		
	}
	
	public void printTreeColWise(BinaryNode<Integer> node) {
		Map<Integer, List<BinaryNode<Integer>>> map = new HashMap<>();
		int col[] = new int[1];
		printTreeColWise(node, col, map);
		int size = map.size();
		for(int i=1; i<=size; i++) {
			System.out.println(map.get(i).toString());
		}
	}
	
	public void printTreeColWise(BinaryNode<Integer> node, int[] col, Map<Integer, List<BinaryNode<Integer>>> map) {
		if(node == null)
			return ;
		
		if(col[0] != 0)
			col[0]--; // for left
		printTreeColWise(node.left, col, map);
		col[0]++;
		if(map.containsKey(col[0])) {
			map.get(col[0]).add(node);
		} else {
			map.put(col[0], new ArrayList<BinaryNode<Integer>>());
			map.get(col[0]).add(node);
		}
		int temp = col[0];
		col[0] = col[0]+1; // for right
		printTreeColWise(node.right, col, map);
		col[0] = temp; // for above
	}
	
	
	
	private int[][] minPathDP = null;
	public int  minPathMatrixDP(int[][] minPath, int fromRow, int fromCol, int toRow, int toCol) {
		
		if(minPathDP == null) {
			minPathDP = new int[minPath.length][minPath.length];
		}
		
		if(fromRow < 0 || fromCol < 0 || fromRow >= minPath.length || fromCol >= minPath.length)
			return Integer.MAX_VALUE;
		
		if(minPathDP[fromRow][fromCol] != 0)
			return minPathDP[fromRow][fromCol];
	
		if(fromRow == toRow && fromCol == toCol)
		{
			return minPath[fromRow][fromCol];
		}
		
		int minCost = minPath[fromRow][fromCol];
		minCost = minCost + Math.min(minPathMatrixDP(minPath, fromRow, fromCol+1, toRow, toCol), 
				Math.min(minPathMatrixDP(minPath, fromRow+1, fromCol, toRow, toCol),
						minPathMatrixDP(minPath, fromRow+1, fromCol+1, toRow, toCol)));
		minPathDP[fromRow][fromCol] =  minCost;
		return minCost;
	}
	
	public void consecutiveSeqNumWhoseSumEqTarget(int[] arr, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Range> list = new ArrayList<>();
		int curr_sum = target;
		for(int i=0; i<arr.length; i++) {
			curr_sum = curr_sum + arr[i];
			if(target == arr[i] || curr_sum == target || map.containsKey(target-curr_sum)) {
				if(target == arr[i]) {
					list.add(new Range(i, i));
				} else if(target == curr_sum) {
					list.add(new Range(0, i));
				} else {
					int index = map.get(target-curr_sum);
					list.add(new Range(index+1, i));
				}
			}
		}
		
		System.out.println(list.toString());
	}
	
	
	public String recv() {
		return "123\n45\n6789";
	}
	
	public void ReadLine() {
		String s = "";
		System.out.println();
		StringBuilder sb = new StringBuilder();
		while(!(s = s + recv()).isEmpty()) {
			char c[] =s.toCharArray();
			int i=0; 
			while(i < c.length) {
				if(c[i] != '\n') {
					sb.append(c[i]);
				} else {
					System.out.println(sb);
					sb = new StringBuilder();
				}
				i++;
			}
			s = sb.toString();
			sb = new StringBuilder();
		}
	}
	
	public void moveZeroesToEnd(int[] arr) {
		int i=0;
		int j = arr.length-1;
		while(i < j) {
			if(arr[j] != 0) {
				swap(arr, i, j);
				i++;
			} else {
				j--;
			}
		}
	}
	
	public int returnIndexLargestUniformlyAtRandom(int arr[]) {
		int maxArr[] = new int[arr.length];
		int start = 1;
		int max = arr[0];
		maxArr[0] = 0;
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
				maxArr[0] = i;
				start = 1;
			} else if(arr[i] == max) {
				maxArr[start++] = i;
			}
		}
		Random r = new Random();
		return maxArr[r.nextInt(start)];
	}
	
	// 0 1 2 3 (3rd largest, 2nd smallest) (kth largest is n-k+1 smallest)
	public void sumKLargestDigits(int[] arr, int k) {
		int n = arr.length;
		k = n-k;
		partitionKthSmallest(arr, k);
		System.out.println(Arrays.toString(arr));
		int sum = 0;
		while(k < arr.length) {
			sum = sum + arr[k++];
		}
		System.out.println(sum);
	}
	
	private void partitionKthSmallest(int[] arr, int k) {
		int low = 0;
		int high = arr.length-1;
		while(low < high) {
			int index = partition(arr, low, high);
			if(index == k-1)
				return;
			else if(index > k-1) {
				high = index-1;
			} else {
				low = index +1;
			}
		}
	}
	
	private int partition(int[] arr, int from, int to) {
		int pivot = arr[from];
		int j = from+1;
		for(int i=from+1; i<=to; i++) {
			if(arr[i] < pivot) {
				swap(arr, i, j);
				j++;
			}
		}
		swap(arr, from, j-1);
		return j-1;
	}
	
	private void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public void countAndSay(int n) {
		if(n <= 0)
			return;
		
		int nthSeq = countAndSay1(n);
		System.out.println("Nth Elem => "+nthSeq);
	}
	
	private int countAndSay1(int n) {
		if(n == 1)
			return 1;
		
		return count(countAndSay1(n-1));
	}
	
	private int count(int num) {
		if(num <= 0)
			return 0;
		
		int count = 1;
		int prev = num % 10;
		num = num / 10;
		
		if(num == 0) {
			return Integer.parseInt(count+""+prev);
		}
		
		String s = "";
		while(num > 0) {
			int digit = num % 10;
			if(digit == prev) {
				count++;
			} else {
				s = count+""+prev+s;
				count = 1;
			}
			num = num / 10;
			prev = digit;
		}
		s = count+""+prev+s;
		return Integer.parseInt(s);
		
	}
	
	
	public void smallestSubsetContainingPrefixesOfEveryString(String[] str) {
		Trie trie = new Trie('\0');
		for(int i=0; i<str.length; i++) {
			trie.insert(str[i]);
		}
		List<String> list = trie.getAllPrefixes();
		System.out.println(list.toString());
	}
	
	// Works #OnlyForUniq
	public void printAllSubsetsOfLengthK(int arr[], int k) {
		boolean b[] = new boolean[arr.length];
		printAllSubsetsOfLengthK(arr, b, 0, 0, k);
	}
	
	public void printAllSubsetsOfLengthK(int arr[], boolean[] b, int index, int currSize, int k) { 
		if(index > arr.length)
			return;
		
		if(currSize == k) {
			System.out.print("{");
			for(int i=0; i<arr.length; i++) {
				if(b[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println("}");
			return;
		}
		
		if(index == arr.length)
			return;
		
		b[index] = true;
		printAllSubsetsOfLengthK(arr, b, index+1, currSize+1, k);
		b[index] = false;
		printAllSubsetsOfLengthK(arr, b, index+1, currSize, k);
		
		
	}
	
	public void allSetsSumToN(int N) {
		allSetsSumToN(N, N, 1, new ArrayList<Integer>());
	}
	
	private void allSetsSumToN(int originalN, int N, int num, List<Integer> list) {
		if(N < 0)
			return;
		
		if(N == 0) {
			System.out.println(list.toString());
			return;
		}
		
		for(int i=num; i<=N; i++) {
			if(i == originalN)
				return;
			list.add(i);
			allSetsSumToN(originalN, N-i, i, list);
			list.remove(list.size()-1);
		}
	}
	
	public Node reverseIter(Node node) {
		if(node == null || node.next == null)
			return node;
		
		Node head = node;
		Node next = node.next; 
		Node nextNext = null;
		head.next = null;
		while(next != null) {
			nextNext = next.next;
			next.next = head;
			head = next;
			next = nextNext;
		}
		return head;
	}
	
	
	public void printList(Node node) {
		System.out.println();
		while(node != null) {
			System.out.print(node.value+"->");
			node = node.next;
		}
		System.out.println();
	}
	
	public Node reverse(Node node) {
		if(node == null)
			return null;
		
		if(node.next ==  null)
			return node;
		
		Node next = node.next;
		node.next = null;
		Node head = reverse(next);
		next.next = node;
		return head;
	}
	
	public void printSumOfEachPath(BinaryNode<Integer> node) {
		if(node == null)
			return;
		
		printSumOfEachPath(node, 0);
	}
	
	private void printSumOfEachPath(BinaryNode<Integer> node, int sum) {
		if(node == null)
			return;
		
		if(node.left == null && node.right == null) {
			System.out.println("sum --> "+(sum+node.value));
			return;
		}
		
		printSumOfEachPath(node.left, sum+node.value);
		printSumOfEachPath(node.right, sum+node.value);
	}

}

class NQueens2 {
	
	private int N;
	private int chessboard[][];
	private int rowArr[];
	private int colArr[];
	
	public NQueens2(int N) {
		this.N = N;
		this.chessboard = new int[N][N];
		this.rowArr = new int[N];
		this.colArr = new int[N];
	}
	
	public void solve() {
		int[] columns = new int[N];
		List<Integer[]> res = new ArrayList<>();
		solveCorrect(0, columns);
	}
	
	public void solveCorrect(int row, int[] columns)  {
		if(row == N) {
			System.out.println("--------------------");
			for(int i=0; i<N; i++) {
				chessboard[i][columns[i]] = columns[i];
			}
			System.out.println("--------------------");
			printBoard();
			return;
		}
		
		for(int col=0; col < N; col++) {
			if(checkValid(columns, row, col)) {
				columns[row] = col;
				solveCorrect(row+1, columns);
			}
		}
	}
	
	public boolean checkValid(int[] columns, int row, int col) {
		for(int r = 0; r < row; r++) {
			int currCol = columns[r];
			if(currCol == col)
				return false;
			
			int colDist = Math.abs(col=currCol);
			int rowDist = row  - r;
			if(rowDist == colDist)
				return false;
		}
		
		return true;
	}
	
	private void printBoard() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(chessboard[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private boolean solve(int queen, int row, int col) {
		if(queen == 0)
			return true;
		
		if(row >= N || col >= N || row < 0 || col < 0)
			return false;
		
		
		if(rowArr[row] == 0 && colArr[col] == 0 && diagonalUpEmpty(row, col) 
				&& diagonalDownEmpty(row, col)) {
			chessboard[row][col] = queen;
			rowArr[row] = queen;
			colArr[col] = queen;
			boolean b =  solve(queen-1, row+2, col+1);
			if(b == false) {
				b = solve(queen-1, row-2, col+1);
				if(b == false) {
					chessboard[row][col] = 0;
					rowArr[row] = 0;
					colArr[col] = 0;
				}
			}
			return b;
		} else {
			return solve(queen, row+1, col) || solve(queen, row-1, col);
		}
	}
	
	private boolean diagonalDownEmpty(int row, int col) {
		int r = row, c = col;
		while(r < N && c < N) {
			if(chessboard[r][c] != 0)
				return false;
			r++;
			c++;
		}
		
		r = row; c = col;
		while(r < N && c >= 0) {
			if(chessboard[r][c] != 0)
				return false;
			r++;
			c--;
		}
		return true;
	}
	
	private boolean diagonalUpEmpty(int row, int col) {
		int r = row, c = col;
		while(r >= 0 && c >= 0) {
			if(chessboard[r][c] != 0)
				return false;
			r--;
			c--;
		}
		
		r = row; c = col;
		while(r >= 0 && c < N) {
			if(chessboard[r][c] != 0)
				return false;
			r--;
			c++;
		}
		
		return true;
	}
	
	
	
}

class Node {
	Node next;
	int value;
	public Node(int value) {
		this.value = value;
	}
}


class LRU<K,V> {
	private class Node<V> { 
		Node<V> next;
		Node<V> prev;
		V data;
		public Node(V data) {
			this.data = data;
		}
	}
	
	private Map<K,Node<V>> map;
	private Node<V> head;
	private Node<V> tail;
	private int maxSize;
	private int currSize;
	
	public LRU(int maxSize) {
		this.map = new HashMap<K,Node<V>>();
		this.maxSize = maxSize;
	}
	
	synchronized public void add(K key, V value) {
		System.out.println(Thread.currentThread().getId());
		if(map.containsKey(key)) {
			Node<V> node = map.get(key);
			node.data = value;
			remove(node);
			add(node);
		} else {
			if(currSize == maxSize) {
				remove(tail);
			}
			map.put(key, new Node<V>(value));
			add(map.get(key));
		}
		
	}
	
	synchronized public V get(K key) {
		if(map.containsKey(key)) {
			Node<V> node = map.get(key);
			remove(node);
			add(node);
			return node.data;
		}
		return null;
	}
	
	synchronized private void add(Node<V> node) {
		if(head == null) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
		currSize++;
	}
	
	
	synchronized private void remove(Node<V> node) {
		if(node == null)
			return;
		
		// node is head 
		if(node.prev == null) {
			head = node.next;
			if(head != null)
				head.prev = null;
		} 
		// node is tail 
		else if(node.next == null) {
			tail = node.prev;
			tail.next = null;
		}
		// node is anywhere in between
		else { 
			Node<V> prev = node.prev;
			Node<V> next = node.next;
			prev.next = next;
			next.prev = prev;
		}
		
		currSize--;
	}
	
	public void print() {
		Node<V> temp = head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
}
