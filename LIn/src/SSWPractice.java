import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;


public class SSWPractice {
	
	public static void main(String args[]) {
		int[] arr = {1,2,3,4,5,6,7};
		SSWPractice practice = new SSWPractice();
		BinaryTree tree = practice.constructBinarySearchTree(arr);
		System.out.println(practice.isBST(tree));
		BinaryTree temp = new BinaryTree(1);
		temp.left = new BinaryTree(Integer.MIN_VALUE);
		temp.right = new BinaryTree(Integer.MAX_VALUE);
		System.out.println(practice.isBST(temp));
		
		BinaryTree mirror = practice.newMirrorTree(tree);
		practice.inOrder(tree);
		System.out.println();
		practice.inOrder(mirror);
		System.out.println();
		System.out.println(practice.isMirror(tree, mirror));
		//{(-2, -4), (0, 0), (10, 15), (5, 6), (7, 8), (-10, -30)}
		List<Point> list = new ArrayList<>();
		list.add(new Point(-2, -4));
		list.add(new Point(0, 0));
		list.add(new Point(10, 15));
		list.add(new Point(5, 6));
		list.add(new Point(7, 8));
		list.add(new Point(-10, -30));
		//practice.KNearestPointsToPoint(list.toArray(new Point[list.size()]), new Point(5, 5), 2);
		Point[] points = list.toArray(new Point[list.size()]);
		practice.KNearestPointsToPointOptimal(points, new Point(5, 5), 2);
		System.out.println(Arrays.toString(points));
		System.out.println((Integer.MAX_VALUE-8) * 2);
		
		MyStringBuffer buffer = new MyStringBuffer();
		buffer.append("What the Fack");
		buffer.append(12345);
		buffer.append('R');
		System.out.println(buffer.toString());
		System.out.println(practice.editDistance("cats", "cat"));
		String[] dict = {"back" ,"hands", "brain", "feet", "game", "pack" , "bands", "dame", "beet", "drain", "bends", "dawn", "beets", "jack","damn", "drawn", "bents", "stack", "pick", "smack",};
		practice.transform(dict, "brain", "game");
		practice.transform(dict, "feet", "hands");
		practice.transform(dict, "pick", "jack");
		practice.transform(dict, "brain", "jack");
		
		LRUCache<String, String> cache = new LRUCache<>(5);
		cache.add("1", "one");
		cache.print();
		cache.add("2", "two");
		cache.print();
		cache.add("1", "one");
		cache.print();
		cache.add("3", "three");
		cache.print();
		cache.add("2", "Two");
		cache.print();
		cache.add("4", "four");
		cache.print();
		cache.add("5", "five");
		cache.print();
		cache.add("6", "sic");
		cache.print();
		System.out.println(practice.isNumber("-1010.203"));
		System.out.println(Float.MAX_VALUE);
		try {
			practice.isNumberRealInteger("3.4028235E38");
			System.out.println("YES");
		} catch(Exception e) {
			System.out.println("NO");
		}
		
		TopKWordCounts topKWordCounts = new TopKWordCounts(3);
		Random r = new Random();
		for(int i=0; i<=19; i++) {
			topKWordCounts.addWord(new Integer(r.nextInt(10)).toString());
			topKWordCounts.printCollectionQueue();
		}
			
	}
	
	public Integer[] topKIntegers(int[] arr, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(int i=0; i<arr.length; i++) {
			queue.add(arr[i]);
			if(queue.size() > k)
				queue.poll();
		}
		
		return queue.toArray(new Integer[queue.size()]);
	}
	
	public boolean isNumberRealInteger(String s) throws Exception {
		if(s == null || s.isEmpty())
			return false;
		
		int index = s.indexOf('E');
		if(index == -1)
			index = s.indexOf('e');
		if(index != -1) {
			float f1 = stringToFloat(s.substring(0, index));
			float f2 = stringToFloat(s.substring(index+1));
			System.out.println(f1);
			System.out.println(f2);
			System.out.println(f1 * Math.pow(10, f2));
		} else {
			System.out.println(stringToFloat(s));
		}
		return true;
	}
	
	private float stringToFloat(String s) throws Exception {
		int index = s.indexOf('.');
		if(index == -1) {
			return (float) stringToInteger(s);
		} else {
			String sub1 = s.substring(0, index);
			String sub2 = s.substring(index+1);
			int int1 = stringToInteger(sub1);
			int int2 = stringToInteger(sub2);
			return (float) (int1 + ((float)(int2)/Math.pow(10,size(int2))));
		}
	}
	
	private int sizeTable[] = {9,99,999,9999,99999,999999,9999999, 99999999, 999999999, Integer.MAX_VALUE};
	private int size(int num) {
		for(int i=0; i<sizeTable.length; i++) {
			if(num <= sizeTable[i])
				return i+1;
		}
		return -1;
	}
	
	private int stringToInteger(String s) throws Exception {
		char c = s.charAt(0);
		boolean neg = c == '-' ? true : false;
		int index = 0;
		if(neg)
			index = 1;
		
		int num = 0;
		for(int i=index; i< s.length(); i++) {
			c = s.charAt(i);
			if(c >= '0' && c <= '9') {
				num = num*10 + (c - '0');
			} else {
				throw new Exception("Not a number");
			}
		}
		num = neg ? -num : num;
		return num;
	}
	
	public boolean isNumber(String s) {
		if(s == null || s.isEmpty())
			return false;
		
		char c = s.charAt(0);
		boolean neg = c == '-' ? true : false;
		int index = 0;
		if(neg)
			index = 1;
		
		int num = 0;
		for(int i=index; i< s.length(); i++) {
			c = s.charAt(i);
			if(c >= '0' && c <= '9') {
				num = num*10 + (c - '0');
			} else {
				return false;
			}
		}
		num = neg ? -num : num;
		System.out.println(num);
		return true;
	}
	
	// Only 1  char change. all words in each step of transform must exist in dictionary
	public void transform(String[] dict, String w1, String w2) {
		Map<String, List<String>> map = createDictionaryGraph(dict);
		List<String> path = dfs(map, w1, w2);
		System.out.println("PATH "+path.toString());
	}
	
	private List<String> dfs(Map<String, List<String>> graph, String w1, String w2) {
		List<String> neighbors = graph.get(w1);
		List<String> path = new ArrayList<>();
		path.add(w1);
		Set<String> visited = new HashSet<String>();
		visited.add(w1);
		boolean pathFound = false;
		for(String word : neighbors) {
			pathFound = dfs(graph, word, w2, path, visited);
			if(pathFound)
				break;
		}
		
		if(pathFound) 
			return path;
		else
			return new ArrayList<>();
		
	}
	
	private boolean dfs(Map<String, List<String>> graph, String currWord,String destination, List<String> path, Set<String> visited) {
		if(currWord.equals(destination)) {
			path.add(destination);
			return true;
		}
		
		if(visited.contains(currWord)) {
			return false;
		}
		
		path.add(currWord);
		visited.add(currWord);
		
		List<String> neighbors = graph.get(currWord);
		for(String word : neighbors) {
			boolean pathFound = dfs(graph, word, destination, path, visited);
			if(pathFound)
				return true;
		}
		
		path.remove(path.size()-1);
		return false;
	}
	private Map<String, List<String>> createDictionaryGraph(String[] words) {
		Map<String, List<String>> map = new HashMap<>();
		for(int i=0; i<words.length; i++) {
			for(int j=i+1; j<words.length; j++) {
				if(editDistance(words[i], words[j]) == 1) {
					if(map.containsKey(words[i])) {
						map.get(words[i]).add(words[j]);
					} else {
						map.put(words[i], new ArrayList<String>());
						map.get(words[i]).add(words[j]);
					}
					
					if(map.containsKey(words[j])) {
						map.get(words[j]).add(words[i]);
					} else {
						map.put(words[j], new ArrayList<String>());
						map.get(words[j]).add(words[i]);
					}
				}
			}
		}
		return map;
	}
	
	private int editDistance(String word1, String word2) {
		if(word1 == null || word2 == null)
			return -1;
		
		if(word1.isEmpty())
			return word2.length();
		
		if(word2.isEmpty())
			return word1.length();
		
		int[][] dp = new int[word1.length()+1][word2.length()+1];
		
		for(int i=0; i<=word1.length(); i++) {
			dp[i][0] = i;
		}
		
		for(int i=0; i<=word2.length(); i++) {
			dp[0][i] = i;
		}
		
		for(int i=0; i<word1.length(); i++) {
			for(int j=0; j<word2.length(); j++) {
				if(word1.charAt(i) == word2.charAt(j)) {
					dp[i+1][j+1] = dp[i][j];
				} else {
					dp[i+1][j+1] = Math.min(dp[i][j], Math.min(dp[i][j+1], dp[i+1][j])) + 1;
				}
			}
		}
		
		return dp[word1.length()][word2.length()];
	}
	
	public void KNearestPointsToPointOptimal(Point[] points, Point p, int k) {
		double[] distances = new double[points.length];
		for(int i=0; i<points.length; i++) {
			distances[i] = Math.hypot(points[i].a - p.a, points[i].b-p.b);
		}
		int start = 0, end = points.length-1;
		while(start < end) {
			int index = partition(points, distances, start, end);
			if(index == k-1)
				return;
			else {
				if(index < k-1) {
					start = index+1;
				} else { 
					end = index-1;
				}
			}
		}
	}
	
	private int partition(Point[] points, double[] distances, int start, int end) {
		int j = start+1;
		double pivot = distances[start];
		for(int i=j; i<=end; i++) {
			if(distances[i] < pivot) {
				swap(distances, i, j);
				swap(points, i, j);
				j++;
			}
		}
		
		swap(distances, start, j-1);
		swap(points, start, j-1);
		return j-1;
	}
	
	private void swap(double[] arr, int a, int b) {
		double temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	private void swap(Point[] arr, int a, int b) {
		Point temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	
	public void KNearestPointsToPoint(Point[] points, Point p, int k) {
		final Map<Point, Double> pointDistance = new HashMap<>();
		Comparator<Point> comparator = new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if(pointDistance.get(o1) > pointDistance.get(o2))
					return -1;
				else if(pointDistance.get(o1) < pointDistance.get(o2))
					return 1;
				else
					return 0;
			}
		};
		PriorityQueue<Point> queue = new PriorityQueue<>(k, comparator);
		for(Point pt : points) {
			pointDistance.put(pt, Math.hypot(p.a - pt.a, p.b - pt.b));
			queue.add(pt);
			if(queue.size() > k)
				queue.poll();
		}
		System.out.println(queue.toString());
	}
	
	public BinaryTree newMirrorTree(BinaryTree tree) {
		if(tree == null) 
			return null;
		
		BinaryTree left = newMirrorTree(tree.left);
		BinaryTree right = newMirrorTree(tree.right);
		
		BinaryTree newTree = new BinaryTree(tree.val);
		newTree.left = right;
		newTree.right = left;
		return newTree;
	}
	
	public void inOrder(BinaryTree tree) {
		if(tree == null)
			return;
		
		inOrder(tree.left);
		System.out.print(tree.val+" ");
		inOrder(tree.right);
	}
	
	public boolean isMirror(BinaryTree tree1, BinaryTree tree2) {
		if(tree1 == null && tree2 == null)
			return true;
		
		if(tree1 == null || tree2 == null)
			return false;
		
		if(tree1.val == tree2.val)
			return isMirror(tree1.left, tree2.right) && isMirror(tree1.right, tree2.left);
		else
			return false;
	}
	
	public boolean isBST(BinaryTree tree) {
		if(tree == null)
			return true;
		
		boolean []bst = new boolean[1];
		bst[0] = true;
		isBSTTree(tree, bst);
		return bst[0];
	}
	
	private int isBSTTree(BinaryTree tree, boolean[] isBST) {
		if(tree == null)
			return Integer.MIN_VALUE;
		
		int maxLeft = Integer.MIN_VALUE;
		int maxRight = Integer.MAX_VALUE;
		
		if(tree.left != null)
			maxLeft = isBSTTree(tree.left, isBST);
		
		if(tree.right != null)
			maxRight = isBSTTree(tree.right, isBST);
	
		if(tree.val >= maxLeft && tree.val <= maxRight) {
			isBST[0] = isBST[0] && true;
		} else {
			isBST[0] = false;
		}
		
		return tree.right != null ? maxRight : tree.val;
	}
	
	public BinaryTree constructBinarySearchTree(int[] arr) {
		if(arr == null || arr.length == 0)
			return null;
		
		return constructBinarySearchTree(arr, 0, arr.length-1);
	}
	
	private BinaryTree constructBinarySearchTree(int[] arr, int start, int end) {
		if(start > end)
			return null;
		
		int mid = (start + end) >>> 1;
		
		BinaryTree binaryTree = new BinaryTree(arr[mid]);
		binaryTree.left = constructBinarySearchTree(arr, start, mid-1);
		binaryTree.right = constructBinarySearchTree(arr, mid+1, end);
		return binaryTree;
	}
	
}

class Point {
	int a;
	int b;
	public Point(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public String toString() {
		return "("+a+", "+b+")";
	}
}

class LRUCache<K,V> { 
	
	private Map<K,Node<V>> map;
	
	private class Node<V> {
		Node<V> next;
		Node<V> prev;
		V value;
		K key;
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private Node<V> head = null, tail = null;
	private int cacheSize = 0;
	private int numOfElements = 0;
	
	public LRUCache(int size) {
		this.map = new HashMap<>();
		this.cacheSize = size;
	}
	
	public void add(K key, V value) {
		
		if(!map.containsKey(key)) {
			Node<V> node = new Node<V>(key, value);
			map.put(key, node);
		} else {
			Node<V> node = map.get(key);
			node.value = value;
		}
		addNode(map.get(key));
		
		if(cacheSize == numOfElements)
			removeTail();
	}
	
	private void removeTail() {
		if(tail == null)
			return;
		
		K key = tail.key;
		map.remove(key);
		if(tail.prev != null) 
			tail.prev.next = null;
		tail = tail.prev;
		numOfElements--;
	}
	
	public V get(K key) {
		if(!map.containsKey(key))
			return null;
		
		return map.get(key).value;
	}
	
	private void addNode(Node<V> node) {
		if(head == null) {
			head = node;
			tail = node;
		} else {
			Node<V> prev = node.prev;
			Node<V> next = node.next;
			
			if(prev == null && next == null) {
				head.prev = node;
				node.next = head;
				head = node;
				numOfElements++;

			} else if(prev == null) {
				
			} else if(next == null) {
				prev.next = null;
				node.prev = null;
				node.next = head;
				head.prev = node;
				head = node;
			} else {
				prev.next = next.next;
				node.prev = null;
				node.next = null;
				addNode(node);
			}
		}
	}
	
	public void print() {
		Node<V> temp = head;
		while(temp != null) {
			System.out.print(temp.value.toString()+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
}



class TopKWordCounts {

	private class WordCount implements Comparable<WordCount> {
		String word;
		int count;
		int tableIndex = -1;
		public WordCount(String word, int count) {
			this.word = word;
			this.count = count;
		}
		
		@Override
		public String toString() {
			return word+"-"+count;
		}
		
		@Override
		public int compareTo(WordCount wc) {
			if(this.count < wc.count)
				return 1;
			else if(this.count > wc.count)
				return -1;
			else
				return 0;
		}
	}
	
	private class Heap { 
		Object table[] = null;
		int numOfElements;
		public Heap() {
			this.table = new Object[11];
		}
		
		void heapifyUp(int index) {
			if(index == 0) {
				((WordCount) table[0]).tableIndex = 0;
				return;
			}
			
			int parent = parent(index);
			Comparable<Object> parentObj = (Comparable<Object>)table[parent];
			
			if(parentObj.compareTo(table[index]) > 0) {
				swap(parent, index);
				((WordCount) table[parent]).tableIndex = index;
				((WordCount) table[index]).tableIndex = parent;
				heapifyUp(parent);
			} else {
				((WordCount) table[index]).tableIndex = index;
			}
		}
		
		void swap(int a, int b) {
			Object temp = table[a];
			table[a] = table[b];
			table[b] = temp;
		}
		
		int parent(int index) {
			return (int) Math.ceil((double) (index-1)/2);
		}
		
		void add(Object o) {
			if(numOfElements == table.length) {
				grow(numOfElements + 1);
			}
			
			table[numOfElements++] = o;
			heapifyUp(numOfElements-1);
		}
		
		void grow(int minCapacity) {
			int newCapacity = minCapacity * 2;
			table = Arrays.copyOf(table, newCapacity);
		}
		
		@Override
		public String toString() {
			StringBuffer buffer = new StringBuffer();
			for(int i=0; i<table.length; i++)
				if(table[i] != null)
				buffer.append(table[i].toString()+" ");
			return buffer.toString();
		}
	}
	
	private Map<String, WordCount> map;
	private Heap queue;
	
	public TopKWordCounts(int K) {
		this.map = new HashMap<>();
		this.queue = new Heap();
	}
	
	public void addWord(String word) {
		if(map.containsKey(word)) {
			WordCount wordCount = map.get(word);
			synchronized (wordCount) {
				wordCount.count++;
				queue.heapifyUp(wordCount.tableIndex);
			}
		} else {
			map.put(word, new WordCount(word, 1));
			queue.add(map.get(word));
		}
	}

	public void printCollectionQueue() {
		System.out.println(queue.toString());
	}
	
}