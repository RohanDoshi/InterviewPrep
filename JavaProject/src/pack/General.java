package pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class TowerOfHanoi {
	List<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
	int numOfDiscs = 0;
	public TowerOfHanoi(int discs) {
		for(int i=0; i<3; i++) {
			stacks.add(new Stack<Integer>());
		}
		numOfDiscs = discs;
		for(int i=discs; i>0; i--) {
			stacks.get(0).push(i);
		}
	}
	
	public void move() {
		move(numOfDiscs,stacks.get(0),stacks.get(1), stacks.get(2));
		System.out.println(Arrays.toString(stacks.get(2).toArray()));
	}
	
	private void move(int numDiscs, Stack<Integer> fromTower,Stack<Integer> helpTower, Stack<Integer> toTower) {
		if(numDiscs == 1) {
			toTower.push(fromTower.pop());
		} else {
			move(numDiscs-1, fromTower, toTower, helpTower);
			toTower.push(fromTower.pop());
			move(numDiscs, helpTower, fromTower, toTower);
		}
	
	}
	
	
}

class Point implements Comparable<Point> { 
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Point o) {
		if(this.y < o.y) {
			return -1;
		} else if(this.y > o.y){
			return 1;
		} else 
			return 0;
	}
}
public class General {

	static int r[] = null;
	static int denom[] = {1,5,10,25};
	public static void main(String[] args) {
//		//printFib(10);
//		//System.out.println(findMinCoins(37));
//		TowerOfHanoi hanoi = new TowerOfHanoi(3);
//		hanoi.move();
//		RodCutting cutting = new RodCutting();
//		for(int i=1; i<=10; i++)
//			System.out.println("rod len = "+i+" "+cutting.optimalPrice(i)+" "+Arrays.toString(cutting.optimalLengths(i).toArray()));
//		
		Point p1 = new Point(1,5);
		Point p2 = new Point(8,11);
		Point p3 = new Point(3,6);
		Point p4 = new Point(10,20);
		
		Point[] points = {p1, p2, p3, p4};
		points = mergeOverlappingPoints(points);
		for(int i=0; i<points.length; i++) {
			System.out.println(points[i].x+" "+points[i].y);
		}
		
		IntegerPalin integerPalin = new IntegerPalin();
		System.out.println(integerPalin.isPalindromeRecur(1234321));
		
		SameCharsAtDistanceD atDistanceD = new SameCharsAtDistanceD();
		atDistanceD.rearrange(3);
		
	}
	
	public static Point[] mergeOverlappingPoints(Point[] points) {
		if(points == null || points.length == 0) {
			return new Point[0];
		}
		
		Arrays.sort(points);
		Point temp = points[0];
		List<Point> list = new ArrayList<>();
		for(int i=1; i<points.length; i++) {
			if(points[i].x <= temp.y || points[i].x - temp.y == 1) {
				temp.y = points[i].y;
				if( i == points.length-1) {
					list.add(temp);
				}
			} else { 
				list.add(temp);
				temp = points[i];
			}
		}
		
		return list.toArray(new Point[list.size()]);
		
	}
	
	public static void printFib(int k) {
		r = new int[k];
		Arrays.fill(r, -1);
		for(int i=0; i<k; i++) {
			System.out.print(fib(i)+", ");
		}

	}
	public static int fib(int i) {
		if(r[i] != -1) {
			return r[i];
		}
		if(i <= 0) {
			r[0] =0;
			return r[0];
		}
		
		if(i == 1) {
			r[1] = 1;
			return r[1];
		}
		
		r[i] = fib(i-1) + fib(i-2);
		return r[i];
	}
	
	static int findMinCoins(int change) {
		if(change <= findMinDenom()) {
			return 0;
		}
		
		if(isDenomExists(change)) {
			return 1;
		}
		int min = Integer.MAX_VALUE;
		for(int i=0; i<denom.length; i++) {
			if(denom[i] < change) {
				min = Math.min(min, findMinCoins(change - denom[i]) + 1);
			}
		}
		return min;
	}
	
	static boolean isDenomExists(int num) {
		for(int i=0; i<denom.length; i++) {
			if(denom[i] == num) {
				return true;
			}
		}
		
		return false;
	}
	
	static int findMinDenom() {
		int min = Integer.MAX_VALUE;
		for(int i=0; i<denom.length; i++) {
			min = Math.min(min, denom[i]);
		}
		return min;
	}

}

class RodCutting { 
	
	int len[] = {1,2,3,4,5,6,7,8,9,10};
	int price[] = {1,5,8,9,10,17,17,20,24,30};
	int dpOptimalPrice[] = new int[len.length];
	public RodCutting() {
		Arrays.fill(dpOptimalPrice, -1);
	}
	public List<Integer> optimalLengths(int rodLen) {
		if(rodLen <= 0) {
			throw new IllegalArgumentException("rod length");
		}
		
		if(rodLen == len[0]) {
			List<Integer> list = new ArrayList<>();
			list.add(price[0]);
		}
		
		if(rodLen > len[len.length-1]) {
			List<Integer> list1 = optimalLengths(rodLen - len[len.length-1]);
			List<Integer> list2 = optimalLengths(len[len.length-1]);
			list1.addAll(list2);
			return list1;
		} else {
			List<Integer> list = new ArrayList<>();
			int maxPrice = price[rodLen-1];	
			list.add(rodLen);
			for(int i=1; i<=rodLen/2; i++) {
				int maxCutPrice = optimalPrice(rodLen-i) + optimalPrice(i);
				if(maxPrice < maxCutPrice) {
					maxPrice = maxCutPrice;
					list = new ArrayList<>();
					list.add(rodLen-i);
					list.add(i);
				}
				
			}
			
			return list;
		}
	}
	
	
	public int optimalPrice(int length) {
		if(length <= 0) {
			return 0;
		}
		
		if(length == len[0]) {
			dpOptimalPrice[0] = length;
			return price[0];
		}
		
		if(length > len[len.length-1]) {
			return optimalPrice(length - len[len.length-1]) + optimalPrice(len[len.length-1]);
		} else {
			if(dpOptimalPrice[length-1] != -1) {
				return dpOptimalPrice[length-1];
			} else {
				int maxPrice = price[length-1];
				for(int i=1; i<=length/2; i++) {
					int maxCutPrice = optimalPrice(length-i) + optimalPrice(i);
					maxPrice = Math.max(maxPrice, maxCutPrice);
				}
				dpOptimalPrice[length-1] = maxPrice;
				return maxPrice;
			}
		}
	}
	
}



class IntegerPalin {
	int i = 1234321;
	 
	public boolean isPalindrome(int i) {
		
		if( i < 0)
			return false;
		
		int div = 1; 
		while(i/div >= 10) {
			div= div * 10;
		}
		
		while( i != 0) {
			int l = i/div;
			int r = i % 10;
			if(l != r)
				return false;
			i = i % div;
			i = i / 10;
			div = div / 100;
		}
		
		return true;
	}
	
	
	private int b = 1234321;
	public boolean isPalindromeRecur(int a) {
		if(a < 0)
			return false;
		
		if(a == 0)
			return true; 
		
		if(isPalindromeRecur(a/10) && (a%10) == (b%10)) {
			b = b/10;
			return true;
		} else {
			return false;
		}
	}
}
class CharCount { 
	int count;
	char c ; 
	public CharCount(char ch, int count) {
		this.c = ch;
		this.count = count;
	}
}
class SameCharsAtDistanceD {
	String s = "geeksforgeeks";
	
	public void rearrange(int d) {
		char c[] = s.toCharArray();
		CharCount[] table = new CharCount[256];
		for(int i=0; i<c.length; i++) {
			if(table[c[i]] == null) {
				table[c[i]] = new CharCount(c[i], 1); 
			} else {
				CharCount cc = table[c[i]];
				cc.count++;
			}
		}
		Comparator<CharCount> comp = new Comparator<CharCount>() {
			
			@Override
			public int compare(CharCount o1, CharCount o2) {
				if(o1.count > o2.count) 
					return -1;
				else if(o1.count < o2.count) 
					return 1;
				else
					return 0;
			}
		};
		PriorityQueue<CharCount> pq = new PriorityQueue<>(s.length(), comp);
		for(int i=0; i<table.length; i++) {
			if(table[i] != null) {
				pq.add(table[i]);
			}
		}
		
		Arrays.fill(c, '\0');
		
		while(!pq.isEmpty()) {
			CharCount cc = pq.poll();
			int p = -1;
			for(int i=0; i<c.length; i++) {
				if(c[i] == '\0') {
					p = i;
					break;
				}
			}
			for(int j=0; j<cc.count; j++) {
				if(p + j*d > c.length-1) {
					System.out.println("Not possible boss !");
					return;
				}
				c[p+j*d] = cc.c;
			}
		}
		
		System.out.println(Arrays.toString(c));
	}
}











