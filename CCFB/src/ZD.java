import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Deque {
	private class Node {
		Node prev;
		Node next;
		int value;
		public Node(int value) {
			this.value = value;
		}
	}
	private int numOfElements;
	private Node head;
	private Node tail;
	
	public void pushFront(int val) {
		push(val,true);
	}
	
	private void push(int val, boolean front) {
		if(head == null || tail == null) {
			head = new Node(val);
			tail = head;
		} else {
			if(front) {
				Node node = new Node(val);
				node.next = head;
				head.prev = node;
				head = node;
			} else {
				Node node = new Node(val);
				tail.next = node;
				node.prev = tail;
				tail = node;
			}
		}
		this.numOfElements++;
	}
	
	public void pushBack(int val) {
		push(val, false);
	}
	
	public int popFront() {
		if(head == null)
			return Integer.MAX_VALUE;
		
		int ret = head.value;
		Node next = head.next;
		if(next != null) {
			next.prev = null;
		}
		head = next;
		this.numOfElements--;
		return ret;
	}
	
	public int popBack() {
		if(tail == null)
			return Integer.MAX_VALUE;
		
		int ret = tail.value;
		Node prev = tail.prev;
		if(prev != null) {
			prev.next = null;
		}
		tail = prev;
		this.numOfElements--;
		return ret;
	}
	
	public boolean isEmpty() {
		return numOfElements == 0;
	}
	
	public int peekFront() {
		if(head == null)
			return Integer.MAX_VALUE;
		
		return head.value;
	}
	
	public int peekBack() {
		if(tail == null)
			return Integer.MAX_VALUE;
		
		return tail.value;
	}
}

public class ZD {

	public static void main(String[] args) {
		int[] arr = {6,2,3,6,3,7};
		ZD zd = new ZD();
		arr = zd.preserveOrderRemoveDup(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(zd.isStringPalindrome("madam"));
		System.out.println(zd.isStringPalindrome("maddam"));
		System.out.println(zd.isStringPalindrome("madax"));
		int[] sum = {-1,-5,2,-1,3};
		System.out.println(zd.maxContiguosSum(sum));
		Integer A[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
		int B[] = {2, 1, 8, 3};
		zd.sort2(A, B);
		zd.longestIncrSubseq(arr);
		zd.longestIncrSubseq(sum);
		//zd.longestIncrSubseq(A);
		BinarySearchTree bst = new BinarySearchTree(6);
		for(int i=0; i<A.length; i++) {
			if(A[i] == 6)
				continue;
			
			bst.add(A[i]);
		}
		bst.inOrder();
		bst.remove(2);
		bst.inOrder();
		bst.remove(6);
		bst.inOrder();
		int arr6[]={-6, 3, -10, 2, -2};
		zd.maxProductSubarray(arr6);
		zd.leastSplitIntoPalindromes("rohoana");
		System.out.println(Integer.MAX_VALUE - (Integer.MAX_VALUE >>> 3));
		System.out.println(Math.ceil((double)1/2));
		PriorityQueue<Integer> queue = new PriorityQueue<>(15);
		queue.add(20);
		queue.add(2);
		queue.add(12);
		queue.add(13);
		queue.add(5);
		queue.add(15);
		queue.add(50);
		queue.add(25);	
		queue.print();
		Integer i = null;
		while((i = queue.poll())!= null) {
			System.out.print(i+" ");
		}
		
		int[] sliding = {1, 3, -1, -3, 5, 3, 6, 7};
		zd.slidingWinMaxSum(sliding, 3);
		System.out.println();
		zd.slidingWinMaxValue(sliding, 3);
		zd.slidingWinMaxValueBetter(sliding, 3);
		
		BinTree binTree = new BinTree(1);
		binTree.left = new BinTree(2);
		binTree.right = new BinTree(3);
		binTree.left.left = new BinTree(4);
		binTree.left.right = new BinTree(5);
		binTree.right.left = new BinTree(6);
		binTree.right.right = new BinTree(7);
		
		System.out.println(zd.sum(binTree));
		zd.pairThatSumTo(sliding, 2);
		int par[] = {1,2,3,4};
		zd.prodArr(par);
		System.out.println(Arrays.toString(sliding));
		zd.lisBetter(sliding);
		zd.longestIncrSubseq(sliding);
		
		MyHashTable<Integer, Integer> mymap = new MyHashTable<>(11, 0.75f);
		for(int j=0; j<20; j++) {
			mymap.put(j, j*2);
		}
		
		for(int j=0; j<20; j++) {
			System.out.print(mymap.get(j)+" ");
		}
		
		int lcm[] = {24,8,0,64};
		System.out.println("\nLCM -->"+zd.leastCommonMultiple(lcm));
	}
	
	public int leastCommonMultiple(int[] arr) {
		int lcm = arr[0];
		for(int i=1; i<arr.length; i++) 
			lcm = gcd(lcm, arr[i]);
		return lcm;
	}
	
	public int gcd(int a, int b) {
		if(a == 0)
			return b;
		
		if(b == 0)
			return a;
		
		int rem = a % b;
		return gcd(b, rem);
	}
	
	
	
	
	public void longestIncrSubseq(int[] arr) {
		int[] len = new int[arr.length];
		int[] seq = new int[arr.length];
		int maxLen = 1;
		int maxIndex = 0;
		
		for(int i=0; i<arr.length; i++) {
			len[i] = 1;
			seq[i] = i;
			int j=0; 
			while(j < i) {
				if(arr[j] < arr[i] && len[j] + 1 > len[i]) {
					len[i] = len[j] + 1;
					seq[i] = j;
					if(len[i] > maxLen) {
						maxLen = len[i];
						maxIndex = i;
					}
				}
				j++;
			}
		}
		
		System.out.println(maxLen);
		int[] sequence = new int[maxLen];
		for(int i=maxLen-1; i>=0; i--) {
			sequence[i] = arr[maxIndex];
			maxIndex = seq[maxIndex];
		}
		System.out.println("Sequence --> "+Arrays.toString(sequence));
	}
	
	
	public void lisBetter(int[] arr) {
		
		int M[] = new int[arr.length];
		int P[] = new int[arr.length];
		int len = 1;
		M[0] = 0;
		P[0] = -1;
		for(int i=0; i<arr.length; i++) {
			int low = 0;
			int high = len-1;
			while(low <= high) {
				int mid = (low + high) >>> 1;
				if(arr[M[mid]] < arr[i]) {
					low = mid+1;
				} else {
					high = mid-1;
				}
			}
			
			if(high == -1) {
				P[i] = -1;
			} else {
				P[i] = M[high];
			}
			
			if(high == len-1 || arr[i] < arr[M[high+1]]) {
				M[high+1] = i;
				if(high + 2 > len) {
					len = high+2;
				}
			}
		}
		//[1, 3, -1, -3, 5, 3, 6, 7]
		int lis[] = new int[len];
		int n = len-1;
		int p = M[n];
		while(n >= 0) {
			lis[n] = arr[p];
			p = P[p];
			n--;
		}
		
		System.out.println("Len --> "+Arrays.toString(M));
		System.out.println("Seq --> "+Arrays.toString(P));
		System.out.println(Arrays.toString(lis));
	}
	public void prodArr(int[] arr) {
		int[] p1 = new int[arr.length];
		int[] p2 = new int[arr.length];
		int p =1;
		for(int i=0; i<arr.length; i++) {
			p1[i] = p;
			p = p*arr[i];
		}
		p = 1;
		for(int i=arr.length-1; i>=0; i--) {
			p2[i] = p;
			p = p*arr[i];
		}
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = p1[i] * p2[i];
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public void pairThatSumTo(int[] arr, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++) 
			map.put(arr[i], i);
		
		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(arr[i]) && map.containsKey(target-arr[i])) {
				int index = map.get(target-arr[i]);
				if(index > i) {
					System.out.print("["+arr[i]+" "+(target-arr[i])+"]");
					map.remove(arr[i]);
					map.remove(target-arr[i]);
				}
			}
		}
	}
	
	
	public int sum(BinTree node) {
		int[] sum = new int[1];
		addAllNodes(node, sum);
		return sum[0];
	}
	
	private void addAllNodes(BinTree node, int[] sum) {
		if(node == null)
			return;
		
		addAllNodes(node.left, sum);
		sum[0] = sum[0] + node.val;
		addAllNodes(node.right, sum);
	}
	
	class Pair {
		int elem;
		int index;
		public Pair(int elem, int index) {
			this.elem = elem;
			this.index = index;
		}
	}
	
	
	// O(n)//[1 3 -1 -3 5 3 6 7]
	public void slidingWinMaxValueBetter(int[] arr, int w) {
		Deque deque = new Deque();
		for(int i=0; i<w; i++) {
			while(!deque.isEmpty() && arr[i] >= arr[deque.peekBack()]) {
				deque.popBack();
			}
			deque.pushBack(i);
		}
		int b[] = new int[arr.length-w+1];
		for(int i=w; i<arr.length; i++) {
			b[i-w] = arr[deque.peekFront()];
			while(!deque.isEmpty() && arr[i] >= arr[deque.peekBack()]) {
				deque.popBack();
			}
			while(!deque.isEmpty() && deque.peekFront() <= i-w) {
				deque.popFront();
			}
			deque.pushBack(i);
		}
		b[arr.length-w] = arr[deque.popFront()];
		System.out.println(Arrays.toString(b));
	}
	
	public void slidingWinMaxValue(int[] arr, int w) {
		Comparator<Pair> comparator = new Comparator<ZD.Pair>() {
			
			@Override
			public int compare(Pair o1, Pair o2) {
				if(o1.elem > o2.elem)
					return -1;
				else if(o1.elem < o2.elem)
					return 1;
				else
					return 0;
			}
		};
		java.util.PriorityQueue<Pair> queue = new java.util.PriorityQueue<Pair>(w, comparator);
		for(int i=0; i<w; i++) {
			queue.add(new Pair(arr[i], i));
		}
		int b[] = new int[arr.length-w+1];
		for(int i=w; i<arr.length; i++) {
			Pair p = queue.peek();
			b[i-w] = p.elem;
			while(p.index <= i-w) {
				queue.poll();
				p = queue.peek();
			}
			queue.add(new Pair(arr[i], i));
		}
		b[arr.length-w] = queue.poll().elem;
		System.out.println(Arrays.toString(b));
	}
	
	public void slidingWinMaxSum(int[] arr, int w) {
		int currSum = 0;
		int maxSum = 0;
		int start = 0;
		int maxStart = 0;
		for(int i=0; i<arr.length; i++) {
			currSum = currSum + arr[i];
			if(i-start+1 == w) {
				if(currSum > maxSum) {
					maxStart = start;
					maxSum = currSum;
				}
				currSum = currSum - arr[start];
				start++;
			}
		}
		int win[] = new int[w];
		for(int i=0; i<w; i++) {
			win[i] = arr[maxStart++]; 
		}
		System.out.println("\nMax Sum Sliding Wind -> "+maxSum+" "+Arrays.toString(win));
	}
	
	public void sort2(Integer[] arr, final int[] order) {
		Comparator<Integer> comparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int ind1 = search(order, o1);
				int ind2 = search(order, o2);
				if(ind1 != -1 && ind2 != -1) {
					if(ind1 < ind2)
						return -1;
					else if(ind1 > ind2) 
						return 1;
					else
						return 0;
						
				}
				
				if(ind1 == -1 && ind2 == -1)
					return 0;
				
				if(ind1 == -1) {
					return 1;
				} else {
					return -1;
				}
				
			}

			private int search(int[] order, Integer o1) {
				for(int j=0; j<order.length; j++) {
					if(order[j] == o1) 
						return j;
				}
				return -1;
			}
		};
		
		Arrays.sort(arr, comparator);
		System.out.println(Arrays.toString(arr));
	}
	
	public void leastSplitIntoPalindromes(String s) {
		List<String> list = minNumOfSplitsDP(s);//minNumOfSplits(s, 0);
		System.out.println(list.toString());
	}
	
	private List<String> minNumOfSplitsDP(String s) {
		char c[] = s.toCharArray();
		boolean[][] dp = new boolean[c.length][c.length];
		
		for(int i=0; i<c.length; i++) {
			dp[i][i] = true;
		}
		
		for(int i=1; i<c.length; i++) {
			if(c[i] == c[i-1]) 
				dp[i-1][i] = true;
		}
		
		for(int len=3; len<=c.length; len++) {
			for(int i=0; i+len<=c.length; i++) {
				int j = i+len-1;
				if(c[i] == c[j] && dp[i+1][j-1]) {
					dp[i][j] = true;
				}
			}
		}
		
		List<String> res = new ArrayList<>();
		
		return res;
	}
	
	private List<String> minNumOfSplits(String s, int index) {
		
		if(isStringPalindrome(s.substring(index))) {
			List<String> list = new ArrayList<>();
			list.add(s.substring(index));
			return list;
		} else {
			int minLen = Integer.MAX_VALUE;
			List<String> minList = new ArrayList<>();
			for(int i=index; i<s.length(); i++) {
				if(isStringPalindrome(s.substring(index,i+1))) {
					List<String> min = minNumOfSplits(s, i+1);
					if(min.size() + 1 < minLen) {
						minLen = min.size() + 1;
						minList = new ArrayList<>();
						minList.add(s.substring(index, i+1));
						minList.addAll(min);
					}
				}
			}
			return minList;
		}
	}
	
	public void maxProductSubarray(int[] arr) {
		int pos_prod = 1, neg_prod = 1, max_prod = 1;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < 0) {
				int temp = pos_prod;
				pos_prod = Math.max(neg_prod*arr[i], 1);
				neg_prod = temp * arr[i];
			} else if(arr[i] > 0) {
				pos_prod = Math.max(pos_prod*arr[i], neg_prod);
				neg_prod = Math.max(neg_prod*arr[i], 1);
			} else {
				pos_prod = 1;
				neg_prod = 1;
			}
			max_prod = Math.max(max_prod, Math.max(pos_prod, neg_prod));
		}
		System.out.println("Max Prod --> "+max_prod);
	}
	
	
	

	
	public void sort1(int[] arr, int order[]) {
		int temp[] = Arrays.copyOf(arr, arr.length);
		Arrays.sort(temp);
		int w = 0;
		for(int i=0; i<order.length; i++) {
			int x = order[i];
			int index = firstOccur(temp, x);
			while(index != -1 && index < temp.length && x == temp[index]) {
				arr[w++] = x;
				temp[index] = Integer.MAX_VALUE;
				index++;
			}
		}
		
		for(int i=0; i<temp.length; i++) {
			if(temp[i] != Integer.MAX_VALUE)
				arr[w++] = temp[i];
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	public int firstOccur(int[] arr, int x) {
		int low = 0;
		int high = arr.length-1;
		int lowest = arr.length;
		while(low < high) {
			int mid = (low + high) >>> 1;
			if(arr[mid] == x) {
				if(mid < lowest) {
					lowest = mid;
				}
				high = mid-1;
			} else if(arr[mid] < x) {
				low = mid+1;
			} else {
				high = mid-1;
			}
		}
		
		return lowest == arr.length ? -1 : lowest;
	}
	
	
	public void sort(int[] arr, int[] order) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			} else {
				map.put(arr[i], 1);
			}
		}
		
		int w = 0;
		for(int i=0; i<order.length; i++) {
			if(map.containsKey(order[i])) {
				int count = map.get(order[i]);
				while(count > 0) {
					arr[w++] = order[i];
					count--;
				}
				map.remove(order[i]);
			}
		}
		Integer keys[] = map.keySet().toArray(new Integer[map.size()]);
		for(int i=0; i<keys.length; i++) {
			arr[w++] = keys[i];
		}
		System.out.println(Arrays.toString(arr));
		
	}
	
	public int maxContiguosSum(int[] arr) {
		int currSum = 0;
		int maxSum = 0;
		int maxVal = Integer.MIN_VALUE;
		int start = 0, end = 0;
		Range r = new Range(start, end);
		for(int i=0; i<arr.length; i++) {
			currSum = currSum + arr[i];
			if(currSum < 0) {
				start = i+1;
				currSum = 0;
			}
			if(currSum > maxSum) {
				maxSum = currSum;
				r = new Range(start, i);
			}
			if(arr[i] > maxVal) {
				maxVal = arr[i];
				start = i;
				end = i;
			}
		}
		System.out.println(r);
		return maxSum == 0 ? maxVal : maxSum;
	}
	
	public int[] preserveOrderRemoveDup(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<arr.length; i++) {
			set.add(arr[i]);
		}
		int[] temp = new int[set.size()];
		int w = 0;
		for(int i=0; i<arr.length; i++) {
			if(set.contains(arr[i])) {
				temp[w++] = arr[i];
				set.remove(arr[i]);
			}
		}
		return temp;
	}
	
	public boolean isStringPalindrome(String s) {
		char c[]= s.toCharArray();
		for(int i=0; i<c.length/2; i++) {
			if(c[i] != c[c.length-1-i]) 
				return false;
		}
		return true;
	}

}

class BinarySearchTree {
	private class Node {
		Node left;
		Node right;
		int val;
		int count;
		public Node(int val) {
			this.val = val;
		}
	}
	
	public void inOrder() {
		System.out.println();
		inOrder(root);
		System.out.println();
	}
	
	private void inOrder(Node root) {
		if(root == null)
			return;
		
		inOrder(root.left);
		System.out.print(root.val+" ");
		inOrder(root.right);

	}
	
	private Node root;
	public BinarySearchTree(int val) {
		this.root = new Node(val);
	}
	
	public void add(int val) {
		root = add(root, val);
	}
	
	private Node add(Node node, int val) {
		if(node == null)
			return new Node(val);
		
		if(node.val == val) {
			node.count++;
		} else if(val < node.val) {
			node.left = add(node.left, val);
		} else {
			node.right = add(node.right, val);
		}
		return node;
	}
	
	public void remove(int val) {
		root = remove(root, val);
	}
	
	private Node remove(Node node, int val) {
		if(node == null)
			return null;
		
		if(node.val == val) {
			if(node.left == null && node.right == null)
				return null;
			
			if(node.left == null) 
				return node.right;
			
			if(node.right == null)
				return node.left;
			
			Node temp = node.right;
			while(temp.left != null) {
				temp = temp.left;
			}
			node.val = temp.val;
			node.right = remove(node.right, node.val);
			
		} else if(val < node.val) {
			node.left = remove(node.left, val);
		} else {
			node.right = remove(node.right, val);
		}
		return node;
		
	}
}


class PriorityQueue<E> {
	private Object[] elements;
	private int initialCapacity;
	private int numOfElements;
	private int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	
	public PriorityQueue(int initialCapacity) {
		if(initialCapacity < 0)
			initialCapacity = 11;
		this.initialCapacity = initialCapacity;
		this.elements = new Object[this.initialCapacity];
		this.numOfElements = 0;
	}
	
	public void add(E elem) {
		if(numOfElements == elements.length) {
			grow(1);
		}
		elements[numOfElements++] = elem;
		siftUp(numOfElements-1);
	}
	
	public void print() {
		System.out.println(Arrays.toString(elements));
	}
	
	public void heapify() {
		
	}
	
	private void siftUp(int index) {
		if(index == 0)
			return;
		
		int parentIndex = (int) (Math.ceil((double)index/2) - 1);
		@SuppressWarnings("unchecked")
		Comparable<Object> parentObj = (Comparable<Object>) elements[parentIndex];
		@SuppressWarnings("unchecked")
		Comparable<Object> currentObj = (Comparable<Object>) elements[index];
		if(currentObj.compareTo(parentObj) < 0) {
			swap(index, parentIndex);
			siftUp(parentIndex);
		}
	}
	
	public E poll() {
		if(numOfElements == 0)
			return null;
		
		if(numOfElements == 1) {
			E elem = (E) elements[0];
			elements[0] = null;
			numOfElements--;
			return elem;
		}
		
		@SuppressWarnings("unchecked")
		E elem = (E) elements[0];
		elements[0] = elements[numOfElements-1];
		elements[numOfElements-1] = null;
		numOfElements--;
		siftDown(0);
		return elem;
	}
	
	private void siftDown(int index) {
		if(index == numOfElements-1)
			return;
		
		Comparable<Object> indexObj = (Comparable<Object>) elements[index];
		int leftIndex = (index << 1) +1;
		int rightIndex = (index << 1) + 2;
		if(leftIndex < numOfElements) {
			Comparable<Object> leftObj = (Comparable<Object>) elements[leftIndex]; 
			if(indexObj.compareTo(leftObj) > 0) {
				swap(index, leftIndex);
				siftDown(leftIndex);
			}
			
		}
		indexObj = (Comparable<Object>) elements[index];
		if(rightIndex < numOfElements) {
			Comparable<Object> rightObj = (Comparable<Object>) elements[rightIndex];
			if(indexObj.compareTo(rightObj) > 0) {
				swap(index, rightIndex);
				siftDown(rightIndex);
			}
		}
	}
	
	
	private void swap(int a, int b) {
		Object temp = elements[a];
		elements[a] = elements[b];
		elements[b] = temp;
	}
	
	private void grow(int growBy) {
		int oldCapacity = elements.length;
		
		if(oldCapacity + growBy < 0)
			throw new OutOfMemoryError();
		
		int newCapacity = oldCapacity + (growBy < (oldCapacity >>> 1) ? oldCapacity >>> 1 : growBy);
		if(newCapacity > MAX_ARRAY_SIZE)
			newCapacity = Integer.MAX_VALUE;
		elements = Arrays.copyOf(elements, newCapacity);
	}
}

class StackMin {
	private Stack<Integer> stack1 = null;
	private Stack<Integer> stack2 = null;
	public StackMin() {
		this.stack1 = new Stack<>();
		this.stack2 = new Stack<>();
	}
	
	public void add(int val) {
		if(this.stack1.isEmpty()) {
			this.stack1.add(val);
			this.stack2.add(val);
		} else {
			this.stack1.add(val);
			if(val < this.stack2.peek()) {
				this.stack2.add(val);
			} else {
				this.stack2.add(this.stack2.peek());
			}
		}
	}
	
	public int pop() throws Exception {
		if(this.stack1.isEmpty()) {
			throw new Exception();
		}
		
		int elem = this.stack1.pop();
		this.stack2.pop();
		return elem;
	}
	
	public int min() throws Exception {
		if(this.stack2.isEmpty()) {
			throw new Exception();
		}
		return this.stack2.peek();
	}
}


class MyHashTable<K, V> {
	private class Entry<K, V> {
		K key;
		V value;
		int hashcode;
		Entry<K,V> next;
		public Entry(K key, V value, int hashcode) {
			this.key = key;
			this.value = value;
			this.hashcode = hashcode;
		}
	}
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	private int numOfElements;
	private Entry<K,V> table[] = null;
	private float loadFactor = 0.75f;
	public MyHashTable(int initialCapacity, float loadFactor) {
		this.table = new Entry[initialCapacity];
	}
	public V put(K key, V value) {
		if(key == null || value == null) 
			throw new NullPointerException();
		
		if(numOfElements >= loadFactor*table.length) {
			rehash();
		}
		
		int hashcode = key.hashCode();
		int index = hashcode % table.length;
		Entry<K,V> entry = table[index];
		Entry<K,V> originalEntry = entry;
		V ret = value;
		if(entry == null) {
			entry = new Entry<K,V>(key, value, hashcode);
		} else {
			Entry<K,V> temp = entry;
			while(temp != null && !temp.key.equals(key)) 
				temp = temp.next;
			
			if(temp == null) {
				Entry<K,V> newEntry = new Entry<K, V>(key, value, hashcode);
				newEntry.next = entry;
				entry = newEntry;
			} else {
				ret = temp.value;
				temp.value = value;
			}
		}
		table[index] = entry;
		if(originalEntry != entry)
			numOfElements++;
		return ret;
	}
	
	
	public V get(K key) {
		if(key == null)
			throw new NullPointerException();
		
		int hashcode = key.hashCode();
		int index = hashcode % table.length;
		Entry<K,V> entry = table[index];
		if(entry == null) {
			return null;
		} else {
			Entry<K,V> temp = entry;
			while(temp != null && !temp.key.equals(key))
				temp = temp.next;
			
			if(temp == null) 
				return null;
			
			return temp.value;
		}
	}
	
	public void rehash() {
		int oldCapacity = table.length;
		int newCapacity = oldCapacity << 1 + 1;
		if(newCapacity - MAX_ARRAY_SIZE > 0) {
			if(oldCapacity == MAX_ARRAY_SIZE) {
				return;
			} else {
				newCapacity = Integer.MAX_VALUE;
			}
		}
		
		Entry<K,V>[] newTable = new Entry[newCapacity];
		for(int i=0; i<table.length; i++) {
			Entry<K,V> entry = table[i];
			while(entry != null) {
				Entry<K,V> entryNext = entry.next;
				entry.next = null;
				int hashcode = entry.key.hashCode();
				int index = hashcode % newTable.length;
				entry.next = newTable[index];
				newTable[index] = entry;
				entry = entryNext;
			}
		}
		
		table = newTable;
	}
}