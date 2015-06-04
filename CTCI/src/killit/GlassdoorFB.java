package killit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;



class BST<E extends Comparable<E>> implements Iterable<E> {
	
	private class Node<E> {
		Node<E> left;
		Node<E> right;
		E value;
		public Node(E value) {
			this.value = value;
		}
	}
	
	private Node<E> root;
	
	public void add(E value) {
		root = add(root, value);
	}
	
	private Node<E> add(Node<E> root, E value) {
		if(root == null) {
			return new Node<E>(value);
		}
		
		if(root.value.compareTo(value) >= 0) {
			root.left = add(root.left, value);
		} else {
			root.right = add(root.right, value);
		}
		return root;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			
			Stack<Node> stack = new Stack<>();
			
			Node<E> current = root;
			
			@Override
			public boolean hasNext() {
				return (current != null || stack.size() != 0);
			}
			
			@SuppressWarnings("unchecked")
			@Override
			public E next() {
				while(current != null) {
					stack.push(current);
					current = current.left;
				}
				
				current = stack.pop();
				E value = current.value;
				current = current.right;
				return value;
			}
			
			@Override
			public void remove() {
				
			}
		};
	}
	
}


public class GlassdoorFB {

	public static void main(String[] args) throws Exception {
		int arr[] = {6,8,-8,2,4,7,9,8,1,9,5,6};
		GlassdoorFB fb = new GlassdoorFB();
		//fb.sumOfKLargest(arr, 5);
		//fb.sumOfKLargestBetter(arr, 5);
		//System.out.println(fb.returnOneOfIndexOfMaxWithUniformProbability(arr));
		//fb.reservoirSampling(arr, 3);
		
		LRU<String, String> lruCache = new LRU<>(5);
		lruCache.add("Apple", "www.apple.com");
		lruCache.displayCache();
		lruCache.add("Google", "www.google.com");
		lruCache.displayCache();
		lruCache.add("Facebook", "www.facebook.com");
		lruCache.displayCache();
		lruCache.add("AOL", "American Online");
		lruCache.displayCache();
		lruCache.get("Google");
		lruCache.displayCache();
		lruCache.add("AOL", "www.aol.com");
		lruCache.displayCache();
		
		fb.listConsecutiveNumsEqSum(arr, 8);
		int consSum[] = {1, 4, 0, 0, 3, 10, 8};
		fb.listConsecutiveNumsEqSumBetter(consSum, 8);
		System.out.println("Consecutive sum");
		fb.listConsecutiveNumsEqSumBest(consSum, 8);
		char[] vert = {'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		Graph<Character> graph = new Graph<Character>();
		for(int i=0; i<vert.length; i++) {
			graph.add(vert[i]);
		}
		
		graph.addEdge('r', 's');
		graph.addEdge('s', 'w');
		graph.addEdge('r', 'v');
		graph.addEdge('w', 't');
		graph.addEdge('w', 'x');
		graph.addEdge('x', 'u');
		graph.addEdge('x', 'y');
		graph.addEdge('t', 'u');
		graph.addEdge('t', 'x');
		graph.addEdge('u', 'y');
		graph.depthFirstSearch();
		Graph<Character> clone = graph.clone();
		clone.depthFirstSearch();
		
		int k = 10;
		Comparator<Integer> comparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2)
					return 1;
				else if(o1 < o2)
					return -1;
				else
					return 0;
			}
		};
		System.out.println();
	
		TreeSet<Integer> set = new TreeSet<>(comparator);
		
		int max = Integer.MIN_VALUE;
		Random r = new Random();
		int numbers[]= new int[25];
		for(int i=0; i<25; i++) {
			int val  = r.nextInt(1000);
			System.out.print(val+" ");
			set.add(val);
			if(set.size() > k)
				set.pollFirst();
			numbers[i] = val;
		}
		System.out.println();
		
//		System.out.println(Arrays.toString(set.toArray()));
//		for(int i=0; i<numbers.length; i++) {
//			if(numbers[i] > set.first()) {
//				set.pollFirst();
//				set.add(numbers[i]);
//			}
//		}
		System.out.println(Arrays.toString(set.toArray()));
		//fb.readLine();
		
		System.out.println(fb.sqrt(4));
		System.out.println(fb.sqrt(5));
		System.out.println(fb.sqrt(8));
		
		System.out.println('1'-'0');
		
		KeyPad keyPad = new KeyPad();
		List<String> list = keyPad.getAllPermutations("23");
		System.out.println(Arrays.toString(list.toArray()));
		
		String lineWithComments = "This is a /* test */ and / I want to check "
				+ "// what happends here123\n /* Is this system */ working? "
				+ "or not???//Testing new line\na";
		
		fb.removeLineAndMultilineComments(lineWithComments);
		
		BST<Integer> bst = new BST<>();
		bst.add(8);
		bst.add(6);
		bst.add(10);
		bst.add(4);
		bst.add(7);
		bst.add(3);
		bst.add(5);
		bst.add(9);
		bst.add(12);
		Iterator<Integer> iterator = bst.iterator();
		System.out.println("In order iterator.....");
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
		char c[] = {'a','b','\0', 'd'};
		System.out.println(c);
		
		String sA="ab*c*d.";
		String sB="abdg";
		System.out.println(fb.isMatch(sA, sB));
		System.out.println("mmmaaammmma"+fb.isMatch("abbb", "ab*"));
		String s = String.valueOf(123);
		System.out.println(s);
		System.out.println("--- all possibili----");
		fb.printAllPossibleCharSets(1313);
		fb.printAllPossibleCharSets(101);
		System.out.println("");
		System.out.println("substring"+ ("12".substring(2,"12".length())));
		System.out.println(fb.findNumOfPossibleSets("1313"));
		System.out.println(fb.findNumOfPossibleSets("100"));
		int a = 10;
		System.out.println(-a);
	}
	
//	
//	public int reverseNum(int num) {
//		if(num >= 0 || )
//	}
	
	
	public int findNumOfPossibleSets(String num) {
		
		if(num == null)
			return 0;
		
		if(num.isEmpty())
			return 1;
		
		if(num.length() == 1) 
			return check(num.substring(0,1));
		
		return   check(num.substring(0,1)) * findNumOfPossibleSets(num.substring(1, num.length())) +
						check(num.substring(0, 2)) * findNumOfPossibleSets(num.substring(2, num.length()));
	}
	
	private int check(String num) {
		int val = Integer.parseInt(num);
		if(val > 0 && val <= 26) 
			return 1;
		else
			return 0;
	}
	
	public void printAllPossibleCharSets(int num) {
		Map<Integer, Character> map = new HashMap<>();
		char c = 'a';
		for(int i=1; i<26; i++) {
			map.put(i, c++);
		}
		printAllPossibleCharSets(String.valueOf(num), 0, String.valueOf(num).length()-1, "",  map);
	}
	
	private void printAllPossibleCharSets(String num, int from, int to, String res, Map<Integer, Character> map) {
		
		if(from > to) {
			System.out.println(res);
			return;
		}
		
		for(int i=from; i<=to; i++) {
			int parseNum = Integer.parseInt(num.substring(from, i+1));
			if(map.containsKey(parseNum)) 
			{
				char charToAppend = map.get(parseNum);
				printAllPossibleCharSets(num, i+1, to, res + charToAppend, map);
			}
		}
	}
	// #Regex
//	sA="ab*c*d.";
//	sB="abdg";
	public boolean isMatch(String s1, String s2) {
		if(s1.isEmpty() && s2.isEmpty())
			return true;
		
		return isMatch(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
	}
	
	private boolean isMatch(char[] s1, char[] s2, int len1, int len2) {
		
		if(len1 == 0 && len2 == 0)
			return true;
		
		if(len1 > 0) {
		
			if(s1[len1-1] == '*') {
				return isMatch(s1, s2, len1-1, len2) || isMatch(s1, s2, len1-2, len2);
			} else if(s1[len1-1] == '.') {
				return isMatch(s1, s2, len1-1, len2-1);
			} else { 
				if(len2 > 0) {
					if(s1[len1-1] == s2[len2-1])
						return isMatch(s1, s2, len1-1, len2-1);
					else
						return false;
				}
			}
		} 
		
		return false;
			
	}
	
	
	enum State {
		None,
		LineComment,
		MultilineComment;
	}
	// /* // */
	public void removeLineAndMultilineComments(String str) {
		char[] c = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		State state = State.None;
		for(int i=0; i<c.length; i++) {
			if(state.equals(State.None)) {
				if(c[i] == '/') {
					if(i+1 < c.length && c[i+1] == '/') {
						if(!state.equals(State.MultilineComment)) {
							state = State.LineComment;
						}
					} else if(i+1 < c.length && c[i+1] == '*') {
						if(!state.equals(State.LineComment)) {
							state = State.MultilineComment;
						}
					} else {
						sb.append(c[i]);
					}
				} else { 
					sb.append(c[i]);
				}
			} else if(state.equals(State.LineComment)) {
				if(c[i] == '\n') {
					if(!state.equals(State.MultilineComment)) {
						state = State.None;
					}
				}
			} else if(state.equals(State.MultilineComment)) {
				if(c[i] == '*') {
					if(i+1<c.length && c[i+1] == '/') {
						if(!state.equals(State.LineComment)) {
							state = State.None;
							i++;
						}
					}
				}
			}
		}
		
		System.out.println(sb);
	}
	
	public double sqrt(double num) {
		double low = 0;
		double high = num;
		
		double mid = (low + high)/2;
		while(Math.abs(mid*mid - num) > 0.000001) {
			if(mid*mid < num) {
				low = mid;
			} else if(mid*mid > num) {
				high = mid;
			}
			mid = (low+high)/2;
		}
		return mid;
	}
	
	static int recv_count = 0;
	private String recv() {
		String[] arr = {"123\n", "45\n", "6789", "abcde", "fg\n"};
		return arr[recv_count++];
	}
	
	public void readLine() {
		StringBuffer buffer = new StringBuffer();
		while(true) {
			String s = recv();
			buffer.append(s);
			if(buffer.charAt(buffer.length()-1) == '\n') {
				System.out.println(buffer.substring(0, buffer.length()-1));
				buffer.delete(0, buffer.length()-1);
			}
		}
	}
	
	class FromTo {
		int from;
		int to;
		public FromTo(int from, int to) {
			this.from = from;
			this.to = to;
		}
		
		@Override
		public String toString() {
			return "("+from+","+to+")";
		}
	}
	//{1, 4, 0, 0, 3, 10, 8};
	public void listConsecutiveNumsEqSumBest(int arr[], int sum) {
		List<FromTo> list = new ArrayList<>();
		int curr_sum = 0;
		int start = 0;
		for(int i=0; i<arr.length; i++) {
			curr_sum = curr_sum + arr[i];
			if(curr_sum > sum) {
				while(start < i && curr_sum > sum) {
					curr_sum = curr_sum - arr[start];
					start++;
				}
			}
			
			if(curr_sum == sum) {
				list.add(new FromTo(start, i));
			}
		}
		
		System.out.println(Arrays.toString(list.toArray()));
	}
	
	// select k random numbers from the array
	public void reservoirSampling(int arr[], int k) {
		int sample[] = new int[k];
		int i=0;
		while(i<k) {
			sample[i] = arr[i];
			i++;
		}
		Random r = new Random();
		while(i<arr.length) {
			int index = r.nextInt(i);
			if(index < k) {
				sample[index] = arr[i];
			}
			i++;
		}
		
		System.out.println(Arrays.toString(sample));
		
	}
	
	public int returnOneOfIndexOfMaxWithUniformProbability(int arr[]) {
		List<Integer> list = new ArrayList<>();
		int maxVal= arr[0];
		list.add(0);
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i] > maxVal) {
				maxVal = arr[i];
				list = new ArrayList<>();
				list.add(i);
			} else if(arr[i] == maxVal) {
				list.add(i);
			}
		}
		
		Random r = new Random();
		int random = r.nextInt(list.size());
		return list.get(random);
	}
	
	// 10 digits
	public void sumOfKLargestBetter(int arr[], int k) {
		int count[] = new int[10];
		for(int i=0; i<arr.length; i++) {
			count[arr[i]]++;
		}
		int i = count.length-1;
		int sum = 0;
		while(k > 0 && i > 0) {
			if(count[i] != 0) {
				sum = sum + i;
				count[i]--;
				k--;
			} else {
				i--;
			}
		}
		
		System.out.println("sum ->> "+sum);
	}
	
	
	// O(nlogn) Inefficient
	public void sumOfKLargest(int arr[], int k) {
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int from = arr.length-1;
		int sum = 0;
		while(k > 0) {
			sum = sum + arr[from--];
			k--;
		}
		System.out.println("Sum of "+k+" largest --> "+sum);
	}
	
	public void listConsecutiveNumsEqSumBetter(int arr[], int sum) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int curr_sum = 0;
		for(int i=0; i<arr.length; i++) {
			if(curr_sum + arr[i]== sum) {
				curr_sum = curr_sum + arr[i];
				queue.add(arr[i]);
				System.out.println(Arrays.toString(queue.toArray()));
			} else if(curr_sum + arr[i] > sum) {
				while(queue.size() != 0 && curr_sum + arr[i] > sum) {
					int trail = queue.poll();
					curr_sum = curr_sum - trail;
					if(curr_sum + arr[i] <= sum)
						break;
				}
				
				if(curr_sum + arr[i] == sum) {
					queue.add(arr[i]);
					curr_sum = curr_sum + arr[i];
					System.out.println(Arrays.toString(queue.toArray()));
				} else if(curr_sum + arr[i] < sum) {
					curr_sum = curr_sum + arr[i];
					queue.add(arr[i]);
				}
			} else {
				curr_sum = curr_sum + arr[i];
				queue.add(arr[i]);
			}
		}
		
		if(curr_sum == sum) {
			System.out.println(Arrays.toString(queue.toArray()));
		}
	}
	
	
	//Given a list of numbers, find the consecutive sequence of 
	//numbers whose sums equal to a target number. 
	// brute force
	public void listConsecutiveNumsEqSum(int arr[], int sum) {
		
		for(int i=0; i<arr.length; i++) {
			int curr_sum = arr[i];
			if(curr_sum == sum) {
				System.out.println(arr[i]);
			}
			for(int j=i+1; j<arr.length; j++) {
				curr_sum = curr_sum + arr[j];
				if(curr_sum == sum) {
					for(int k=i; k<=j; k++) {
						System.out.print(arr[k]+" ");
					}
					System.out.println();
				}
			}
		}

	}
 }

class Graph<T> { 
	
	private class Vertex<T> {
		List<Vertex<T>> edges;
		T name;
		public Vertex(T name) {
			this.name = name;
			this.edges = new ArrayList<>();
		}
		void addEdge(Vertex<T> edge) {
			this.edges.add(edge);
		}
	}
	
	private List<Vertex<T>> vertices;
	private Map<T, Vertex<T>> map;
	public Graph() {
		this.map = new HashMap<>();
		this.vertices = new ArrayList<>();
	}
	
	public Graph<T> clone() {
		Graph<T> cloneGraph = new Graph<>();
		Map<Vertex<T>, Vertex<T>> oldCloneMap = new HashMap<>();
		Set<Vertex<T>> visited = new HashSet<>();
		
		for(Vertex<T> vertex : vertices) {
			if(!visited.contains(vertex))
				dfsClone(cloneGraph, vertex, oldCloneMap, visited);
		}
		return cloneGraph;
	}
	
	private void dfsClone(Graph<T> clone, Vertex<T> vertex, Map<Vertex<T>,Vertex<T>> oldCloneMap, Set<Vertex<T>> visited) {
		if(!visited.contains(vertex)) {
			visited.add(vertex);
			Vertex<T> cloneVertex = new Vertex<>(vertex.name);
			clone.addVertex(cloneVertex);
			oldCloneMap.put(vertex, cloneVertex);
		}
		Vertex<T> cloneVertex = oldCloneMap.get(vertex);
		for(Vertex<T> edge : vertex.edges) {
			if(!visited.contains(edge)) {
				dfsClone(clone, edge, oldCloneMap, visited);
			}
			Vertex<T> cloneEdge = oldCloneMap.get(edge);
			cloneVertex.addEdge(cloneEdge);
		}
	}
	
	public void add(T name) {
		Vertex<T> vertex = new Vertex<T>(name);
		if(!map.containsKey(name)) {
			map.put(name, vertex);
			vertices.add(vertex);
		}
	}
	
	private void addVertex(Vertex<T> vertex) {
		if(!map.containsKey(vertex.name)) {
			map.put(vertex.name, vertex);
			vertices.add(vertex);
		}
	}
	
	public void addEdge(T from, T to) {
		if(map.containsKey(to) && map.containsKey(from)) {
			Vertex<T> vertexTo = map.get(to);
			Vertex<T> vertexFrom = map.get(from);
			vertexFrom.addEdge(vertexTo);
		}
	}
	
	public void depthFirstSearch() {
		Set<Vertex<T>> visited = new HashSet<>();
		for(Vertex<T> vertex : vertices) {
			if(!visited.contains(vertex))
				dfs(vertex, visited);
		}
	}

	private void dfs(Vertex<T> vertex, Set<Vertex<T>> visited) {
		visited.add(vertex);
		System.out.print(vertex.name+" ");
		for(Vertex<T> edge : vertex.edges) {
			if(!visited.contains(edge)) {
				dfs(edge, visited);
			} 
		}
	}
	
}

class LRU<K,V> {
	private class Node<V> {
		Node<V> next;
		Node<V> prev; 
		V val;
		public Node(V val) {
			this.val = val;
		}
	}
	private Map<K,Node<V>> map;
	private int capacity;
	private int elementCount;
	private Node<V> head;
	private Node<V> tail;
	
	public LRU(int capacity) {
		this.capacity = capacity;
	}
	
	public void add(K key, V value) {
		
		if(map == null) {
			map = new HashMap<>();
		}
		
		if(map.containsKey(key)) {
			Node<V> node = map.get(key);
			node.val = value;
			map.put(key, node);
			return;
		} else { 
			if(elementCount == capacity) {
				remove(tail);
				elementCount--;
			}
			Node<V> node = new Node<V>(value);
			map.put(key, node);
			add(node);
			elementCount++;
		}
	}
	
	private void add(Node<V> node) {
		
		if(head == null) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
	}
	
	public V get(K key) {
		if(map.containsKey(key)) {
			Node<V> node = map.get(key);
			setHead(node);
			return node.val;
		}
		
		return null;
	}
	
	private void setHead(Node<V> node) {
		if(node == null)
			return;
		
		if(head == null) {
			head = node;
			tail = node;
			return;
		}
		
		remove(node);
		node.next = head;
		head.prev = node;
		head = node;
	}
	
	public void remove(K key) {
		if(map.containsKey(key)) {
			Node<V> node = map.get(key);
			map.remove(key);
			remove(node);
			elementCount--;
		}
	}
	
	private Node<V> remove(Node<V> node) {
		if(node == null || head == null)
			return null;
		
		
		Node<V> next = node.next;
		Node<V> prev = node.prev;
		
		// It is head.
		if(prev == null) {
			next.prev = null;
			head = head.next;
		}
		// It is tail. Move it to head.
		else if(next == null) {
			prev.next = null;
			tail = prev;
		} else {
			prev.next = next;
			next.prev = prev;
		}
		return node;

	}
	
	public void displayCache() {
		Node<V> node = head;
		while(node != null) {
			System.out.print(node.val+" ");
			node = node.next;
		}
		System.out.println();
	}
	
}

class KeyPad {
	
	static Map<Integer,List<Character>> map;
	
	public KeyPad() {
		initializeMap();
	}
	
	private void initializeMap() {
		
		if(map == null) {
			map = new HashMap<>();
		}
		
		char c = 'a';
		int count = 0;
		for(int i=2; i<=9; i++) {
			count=0;
			map.put(i, new ArrayList<Character>());
			while(count < 3 && c <='z') {
				map.get(i).add(c++);
				count++;
			}
		}
	}
	
	public List<String> getAllPermutations(String key) throws Exception {
		List<String> list = new ArrayList<>();
		getAllPermutations(key, 0, "", list);
		return list;
	}
	
	private void getAllPermutations(String key, int index, String str, List<String> list) throws Exception {
		
		if(index == key.length()) {
			list.add(str);
			return;
		}
		
		char carr[] = key.toCharArray();
		int digit = Integer.parseInt(new String(carr, index, 1));
		if(!map.containsKey(digit))
			throw new Exception("Invalid input");
		
		List<Character> chars = map.get(digit);
		for(char c : chars) {
			getAllPermutations(key, index+1, str+c, list);
		}
		
	}

}




// with parent node... not clean
class BinarySearchTreeIterator implements Iterable<Integer>{

	private class Node { 
		Node left;
		Node right;
		Node parent;
		int value;
	}
	
	private Node root ;
	
	@Override
	public Iterator<Integer> iterator() {
		
		return new Iterator<Integer>() {
			Node current = leftMost(root);
			
			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public Integer next() {
				 return null;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
	private Node leftMost(Node node) {
		if(node == null)
			return null;
		
		while(node.left != null)
			node = node.left;
		
		return node;
	}
	
}
