import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;


public class GlassFB2 {

	public static void main(String[] args) {
		GlassFB2 fb = new GlassFB2();
		System.out.println(fb.sum(2, 3));
		System.out.println(2^3);
		System.out.println(2&3);
		System.out.println("divide ---> "+fb.divide(-6, 3));
		System.out.println(fb.changeSign(-2));
		System.out.println(fb.changeSign(2));
		System.out.println(~2);
		System.out.println(fb.changeSign(0));
		System.out.println(~0);
		
		BinaryNode<Integer> node = new BinaryNode<Integer>(4);
		node.left = new BinaryNode<Integer>(2);
		node.right = new BinaryNode<Integer>(6);
		node.left.left = new BinaryNode<>(1);
		node.left.right = new BinaryNode<Integer>(3);
		node.right.left = new BinaryNode<Integer>(5);
		node.right.right = new BinaryNode<Integer>(7);
		
		fb.sinkBinaryNode(node);
		
		LinkedNode linked = new LinkedNode(10);
		linked.next = new LinkedNode(5);
		linked.next.next = new LinkedNode(12);
		linked.next.next.next = new LinkedNode(7);
		linked.next.next.next.next = new LinkedNode(11);
		
		linked.other = new LinkedNode(4);
		linked.other.next = new LinkedNode(20);
		linked.other.next.next = new LinkedNode(13);
		linked.other.next.other = new LinkedNode(2);
		linked.other.next.next.other = new LinkedNode(16);
		linked.other.next.next.other.other = new LinkedNode(3);
		
		linked.next.next.next.other = new LinkedNode(17);
		linked.next.next.next.other.other = new LinkedNode(9);
		linked.next.next.next.other.other.other = new LinkedNode(19);
		linked.next.next.next.other.next = new LinkedNode(6);
		linked.next.next.next.other.other.next = new LinkedNode(8);
		linked.next.next.next.other.other.other.next = new LinkedNode(15);
		
		fb.flattenLinkedNodeOther(linked);
		
		DLL d = new DLL(1);
		d.next = new DLL(2);
		d.next.prev = d;
		d.next.next = new DLL(3);
		d.next.next.prev = d.next;
		d.next.next.next = new DLL(4);
		d.next.next.next.prev = d.next.next;
		d.next.next.next.next = new DLL(5);
		d.next.next.next.next.prev = d.next.next.next;
		System.out.println();
		 d = fb.reverseDLL(d);
		 DLL temp = d;
		 while(temp != null) {
			 System.out.print(temp.data+" ");
			 temp = temp.next;
		 }
		 
		 
		Range[] dates = new Range[10];
		Random r = new Random();
		for(int i=0; i<dates.length; i++) {
			int from = r.nextInt(31);
			int to = r.nextInt(31);
			if(from <= to) {
				dates[i] = new Range(from, to);
			} else {
				i--;
			}
		}
		Arrays.sort(dates);
		System.out.println(Arrays.toString(dates));
		fb.maxOverlappingIntervals(dates);
		System.out.println(Math.pow(10, 13)/ Math.pow(2, 32));
		int[] arr ={1, 6, 3, 1, 3, 6, 6};
		fb.findDuplicatesNTimeConstantSpace(arr);
		
		int[] elem = {1,2,3,4};
		int[] index = {2,1,3,0};
		fb.permute(elem, index);
		int[]ms =  {10, 1, -3, 5, 8, 1};
		fb.maxSumDP(ms);
		System.out.println(fb.returnNthElementInOrder(node, 0));
		fb.inOrder(node);
		fb.numOfWays(4);
		
		LinkedNode linked1 = new LinkedNode(1);
		linked1.next = new LinkedNode(2);
		linked1.next.next = new LinkedNode(3);
		linked1.next.next.next = new LinkedNode(4);
		linked1.next.next.next.next = new LinkedNode(5);
		
		//fb.interleave(linked1);
		System.out.println();
		System.out.println(Math.exp(Math.log(27)/2));
		
		String s = "abc2134kd31";
		fb.printAllPrimesBetter(s);
		System.out.println(fb.cubeRoot(27));
		int[] balls = {2,1,3,4};
		int[] buckets = {3,2,0,4,1};
		fb.putBallIntoRightBucket(balls, buckets);
		System.out.println(Arrays.toString(buckets));
		System.out.println("print reverse....");
		fb.printReverse(linked1);
		fb.printAllUniqSubsets("reema");
		
	}
	// {}, {r} , {e}, {r,e} , {e, e}
	public void printAllUniqSubsets(String str) {
		List<List<Character>> list = new ArrayList<>();
		list.add(new ArrayList<Character>());
		Map<Character, Integer> map = new HashMap<>();
		char c[] = str.toCharArray();
		for(int i=0; i<str.length(); i++) {
			if(map.containsKey(c[i])) {
				map.put(c[i], map.get(c[i])+1);
				int elemCount = map.get(c[i]);
				int size = list.size();
				int count = 0;
				for(int j=0; j<size; j++) {
					List<Character> l = list.get(j);
					for(int k=0; k<l.size(); k++) {
						if(l.get(k) == c[i]) {
							count++;
						}
					}
					if(count == elemCount-1) {
						List<Character> newList = new ArrayList<Character>(l);
						newList.add(c[i]);
						list.add(newList);
					}
				}
			} else {
				map.put(c[i], 1);
				int size = list.size();
				for(int j=0; j<size; j++) {
					List<Character> l = new ArrayList<Character>(list.get(j));
					l.add(c[i]);
					list.add(l);
				}
			}
		}
		
		for(int i=0; i<list.size(); i++) 
			System.out.println(list.get(i).toString());
	}
	
	private double cubeRootNewtonRaphson(double num, double x) {
		return ((double)1/3)*((2*x)+(num/(x*x)));
	}
	
	
	public void printReverse(LinkedNode node) {
		if(node == null)
			return;
		
		if(node.next == null) {
			System.out.print(node.val+" ");
			return;
		}
		
		LinkedNode next = node.next;
		printReverse(next);
		System.out.print(node.val+" ");
	}
	
	public void putBallIntoRightBucket(int[] balls, int[] buckets) {
		for(int i=1; i<buckets.length; i++) {
			while(buckets[i] != i) {
				int ball = buckets[i];
				move(buckets, i, ball);
			}
		}
	}
	
	public void move(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public double cubeRoot(double num) {
		double low = 0;
		double high = num;
		double mid = (low + high)/ 2;
		mid = newtonRaphson(num, mid);
		while(Math.abs(mid*mid*mid -num) > 0.00001) {
			if(mid*mid*mid > num) {
				high = mid;
			} else {
				low = mid;
			}
			
			mid = newtonRaphson(num, mid);
		}
		
		return mid;
	}
	
	// a is the number and x is the guess
	public double newtonRaphson(double a, double x) {
		return ((double)1/3)*(2*x+(a/(x*x)));
	}
	
	public void printAllPrimes(String s) {
		char c[] = s.toCharArray();
		StringBuilder sb = null;
		for(int i=0; i<c.length;) {
			if(c[i] >= '1' && c[i] <= '9') {
				sb = new StringBuilder();
				while(i < c.length && c[i] >= '1' && c[i] <= '9') {
					sb.append(c[i]);
					i++;
				}
				Set<Integer> set = new HashSet<Integer>();
				printPrimes(sb.toString(),set);
				System.out.println(set.toString());
			} else {
				i++;
			}
		}
	}
	
	
	public void printAllPrimesBetter(String s) {
		char c[] = s.toCharArray();
	
		for(int i=0; i<c.length;) {
			if(c[i] >= '1' && c[i] <= '9') {
				int n = 0;
				while(i < c.length && c[i] >= '1' && c[i] <= '9') {
					n = n*10 + (c[i] - '0');
					if(isPrime(n))
						System.out.println("Prime --> "+n);
					i++;
				}
				
			} else {
				i++;
			}
		}
	}
	
	// 2134
	public void printPrimes(String s, Set<Integer> set) {
		if(s == null || s.isEmpty())
			return;
		
		for(int i=1; i<=s.length(); i++) {
			int n = Integer.parseInt(s.substring(0,i));
			if(isPrime(n)) 
				set.add(n);
			printPrimes(s.substring(i), set);
		}
	}
	
	public boolean isPrime(int n) {
		if(n <= 1)
			return false;
		
		if(n == 2 || n == 3)
			return true;
		
		if(n % 2 == 0 || n % 3 == 0) 
			return false;
		
		int sqrt = (int) Math.ceil(Math.sqrt(n));
		for(int i=5; i<=sqrt; i+=6)
			if(n % i == 0 || n % (i+2) == 0)
				return false;
		
		return true;
	}
	
	
	//1 2 3 4 5
	public void interleave(LinkedNode node) {
		if(node == null)
			return;
		
		LinkedNode mid = node;
		LinkedNode fast = node;
		while(fast != null) {
			fast = fast.next;
			mid = mid.next;
			if(fast != null)
				fast = fast.next;
		}
		
		LinkedNode midRev = reverseLinkedNode(mid);
		LinkedNode head = node;
		while(head != null && midRev != null) {
			LinkedNode temp = head.next;
			head.next = midRev;
			midRev = midRev.next;
			head.next.next = temp;
			head = temp;
		}
		
		head.next = null;
		
		System.out.println("Interweave list....");
		LinkedNode temp = node;
		while(temp != null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
	}
	
	
	
	// 1, 2, 3
	public void numOfWays(int n) {
		int[] arr = new int[n+1];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		for(int i=4; i<=n ;i++) {
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}
		
		System.out.println("\n numer of ways"+arr[n]);
	}
	
	public void inOrder(BinaryNode<Integer> node) {
		if(node == null)
			return;
		
		inOrder(node.left);
		System.out.print(node.value+" ");
		inOrder(node.right);
	}
	
	public int returnNthElementInOrder(BinaryNode<Integer> node, int n) {
		int rank[] = new int[1];
		int element[] = new int[1];
		returnNthElementInOrder(node, n, rank, element);
		return rank[0] == n ? element[0] : -1;
	}
	
	public void returnNthElementInOrder(BinaryNode<Integer> node, int n, int rank[], int element[]) {
		if(node == null)
			return;
		
		returnNthElementInOrder(node.left, n, rank, element);
		int lastRank = rank[0];
		if(n > lastRank) {
			rank[0]++;
			element[0] = node.value;
		}
		returnNthElementInOrder(node.right, n, rank, element);
	}
	
	public void maxSumDP(int[] arr) { 
		int v[] = new int[arr.length+1];
		v[0] = 0;
		v[1] = arr[0];
		for(int i=1; i<arr.length; i++) {
			v[i+1] = Math.max(v[(i+1)-2]+arr[i], v[(i+1)-1]);
		}
		System.out.println(Arrays.toString(v));
	}
	//[3, 8, 4]
	//[12, 8, 9, 10] 
	public void maxSum(int[] arr) {
		int max = 0;
		int sumEven = 0;
		int sumOdd = 0;
		for(int i=0; i<arr.length; i++) {
			if(i%2 == 0) {
				sumEven = sumEven + arr[i];
				if(sumEven < 0)
					sumEven = 0;
			} else { 
				sumOdd = sumOdd + arr[i];
				if(sumOdd < 0)
					sumOdd = 0;
			}
			
			max = Math.max(max, Math.max(sumOdd, sumEven));
		}
		
		System.out.println(max);
	}
	
	public void permute(int[] elem, int[] index) {
		for(int i=0; i<elem.length; i++) {
			int newIndex = index[i];
			swap(elem, index, i, newIndex);
		}
		System.out.println(Arrays.toString(elem));
	}
	
	private void swap(int[] arr, int index[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		
		temp = index[a];
		index[a] = index[b];
		index[b] = temp;
	}
	
	public void findDuplicatesNTimeConstantSpace(int[] arr) {
		int size = arr.length;
		for(int i=0; i<arr.length; i++) {
			int index = Math.abs(arr[i]);
			if(arr[index] > 0) {
				arr[index] = -arr[index];
			} else {
				System.out.println(Math.abs(arr[i]));
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public void maxOverlappingIntervals(Range[] range) {
		Range head = range[0];
		int count = 0;
		for(int i=1; i<range.length; i++) {
			if(range[i].from < head.to) {
				count++;
				head.to = Math.max(head.to, range[i].to);
			} else {
				head = range[i];
			}
		}
		System.out.println("Count --> "+count);
	}
	
	public DLL reverseDLL(DLL node) {
		if(node == null)
			return null;
		
		if(node.next == null) {
			node.prev = null;
			return node;
		}
		
		DLL next = node.next;
		node.next = null;
		DLL head = reverseDLL(next);
		next.next = node;
		node.prev = next;
		return head;
	}
	
	public LinkedNode reverseLinkedNode(LinkedNode node) {
		if(node == null)
			return null;
		
		if(node.next == null) {
			return node;
		}
		
		LinkedNode next = node.next;
		node.next = null;
		LinkedNode head = reverseLinkedNode(next);
		next.next = node;
		return head;
	}
	
	public void flattenLinkedNodeOther(LinkedNode node) {
		LinkedNode res = null, currRes = null;
		Queue<LinkedNode> queue = new LinkedList<>();
		while(node != null || !queue.isEmpty()) {
			if(node == null) {
				node = queue.poll();
			}
			
			if(node.next != null) {
				queue.add(node.next);
			}
			
			if(res == null) {
				res = node;
				currRes = node;
			} else {
				currRes.next = node;
				currRes = node;
			}
			
			node = node.other;
			currRes.next = null;
		}
		
		currRes = res;
		while(currRes != null) {
			System.out.print(currRes.val+" ---> ");
			currRes = currRes.next;
		}
	}
	
	public void flattenLinkedNode(LinkedNode node) {
		LinkedNode res = null, currRes = null;
		Queue<LinkedNode> queue = new LinkedList<>();
		while(node != null || !queue.isEmpty()) {
			if(node == null) {
				node = queue.poll();
			}
			
			if(node.other != null) {
				queue.add(node.other);
			}
			
			if(res == null) {
				res = node;
				currRes = node;
			} else {
				currRes.next = node;
				currRes = node;
			}
			
			node = node.next;
			currRes.next = null;
		}
		
		currRes = res;
		while(currRes != null) {
			System.out.print(currRes.val+" ---> ");
			currRes = currRes.next;
		}
	}
	
	public void sinkBinaryNode(BinaryNode<Integer> node) {
		Stack<BinaryNode<Integer>> stack = new Stack<>();
		sinkBinaryNode(node, stack);
	}
	
	public void sinkBinaryNode(BinaryNode<Integer> node, Stack<BinaryNode<Integer>> stack) {
		if(node == null)
			return;
		
		if(node.value == 0) {
			stack.push(node);
		} else {
			if(!stack.isEmpty()) {
				BinaryNode<Integer> zeroNode = stack.pop();
				zeroNode.value = node.value;
				node.value = 0;
			}
		}
		
		sinkBinaryNode(node.left, stack);
		sinkBinaryNode(node.right, stack);
		
		
	}
	
	public int sum(int a, int b) {
		if(b == 0)
			return a;
		
		int s = a^b;
		int c = (a&b) << 1;
		return sum(s,c);
	}
	
	public int divide(int a, int b) {
		if(b == 0)
			throw new ArithmeticException();
		boolean sign = (a < 0) ^ (b < 0);
		a = Math.abs(a);
		b = Math.abs(b);
		int res = 0;
		while(a >= b) {
			a = sum(a, -b);
			res = sum(res,1);
		}
		
		return sign ? -res : res;
	}
	
	public int changeSign(int a) {
		a = ~a;
		return sum(a,1);
	}

}

class LinkedNode { 
	int val;
	public LinkedNode(int val) {
		this.val = val;
	}
	LinkedNode next;
	LinkedNode other;
}


class DLL {
	DLL prev;
	DLL next;
	int data;
	public DLL(int data) {
		this.data= data;
	}
}
