package killit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class ArraysandStrings {

	public static void main(String[] args) {
		ArraysandStrings as = new ArraysandStrings();
		System.out.println(as.isStringUniqChars("rohan"));
		System.out.println(as.isStringUniqChars("rohandoshi"));
		System.out.println(as.isStringUniqCharsLC("rohandoshi"));
		System.out.println('c'^'c');
		as.replaceSpaceWith20("Mr John Smith    ".toCharArray());
		as.replaceSpaceWithPerc20("Mr John Smith    ".toCharArray(), "Mr John Smith".length());
		as.compressString("aabcccccaaa");
		System.out.println("abc".indexOf(""));
		System.out.println("abc".indexOf("", 3));
		int[] arr = {-2, 1, -3, 5, 8, 1};
		as.longestIncrSequence(arr);
		
		int [][]matrix = {{20, 40, 80}, 
						  {5, 60, 90}, 
						  {45, 50, 55} };
		as.printSortedGivenRowSorted(matrix);
		System.out.println();
		System.out.println(as.solveExp("3*8+5"));
		int[] dup = {6,-2,-3,6,3,-7};
		//as.removeDupMaintainOrder(dup);
		//System.out.println(Arrays.toString(dup));
		as.subsequenceWithLargestSum(arr);
		as.maxContiguousSum(arr);
		as.maxWindowSum(dup, 3);
		int [][] graph = { {0, 1, 0, 1, 0}, {}, {} };
		
	}
	
	public void maxWindowSum(int arr[], int windowSize) {
		int temp = windowSize;
		Queue<Integer> queue = new LinkedList<>();
		int curr_sum = 0, max_sum = 0;
		for(int i=0; i<arr.length; i++) {
			queue.add(arr[i]);
			curr_sum = curr_sum + arr[i];
			temp--;
			if(temp == 0) {
				if(curr_sum > max_sum)
					max_sum = curr_sum;
				
				curr_sum = curr_sum - queue.poll();
				temp = 1;
			}
		}
		
		System.out.println(max_sum);
	}
	
	public void maxContiguousSum(int[] arr) {
		int curr_sum = 0;
		int max_sum = 0;
		for(int i=0; i<arr.length; i++) {
			if(curr_sum + arr[i] > curr_sum) {
				curr_sum = curr_sum + arr[i];
			} else {
				curr_sum = 0;
			}
			
			if(curr_sum > max_sum) {
				max_sum = curr_sum;
			}
		}
		
		System.out.println("Max Sum ---> "+max_sum);
	}
	
	public void subsequenceWithLargestSum(int[] arr) {
		int sum[] = new int[arr.length];
		int seq[] = new int[arr.length];
		
		for(int i=0; i< arr.length; i++) {
			sum[i]= arr[i];
			if(i == 0)
				seq[i] = -1;
			else
				seq[i] = i;
			int j = 0;
			while(j < i) {
				if(sum[i] + arr[j] > sum[i]) {
					sum[i] = sum[i] + arr[j];
					seq[i] = j;
				}
				j++;
			}
		}
		
		System.out.println(Arrays.toString(sum));
		System.out.println(Arrays.toString(seq));
		
				
	}
	
	
	public void removeDupMaintainOrder(int[] arr) { 
		Set<Integer> set = new LinkedHashSet<>();
		int w = 0;
		for(int i=0; i<arr.length; i++) {
			if(!set.contains(arr[i])) {
				arr[w++] = arr[i];
				set.add(arr[i]);
			}
		}
		
		System.out.println(Arrays.toString(set.toArray()));
	}
	
	
	public boolean isDigit(char c) {
		return '0'<= c && c <= '9';
	}
	
	public int getNum(char c[], int pos[]) {
		int num = 0;
		while(pos[0] < c.length && isDigit(c[pos[0]])) {
			num = num * 10;
			num = num + (c[pos[0]] - '0');
			pos[0]++;
		}
		return num;
	}
	
	public int solveExp(String s) {
		
		int curr_sum = 0;
		int curr_prod = 1;
		char carr[] = s.toCharArray();
		int posIndex[] = new int[1];
		while(posIndex[0] < carr.length) {
			 int num = getNum(carr, posIndex);
			 if(posIndex[0] < carr.length && carr[posIndex[0]] == '*') {
				 curr_prod = curr_prod*num;
				 posIndex[0]++;
			 } else  {
				 curr_prod = curr_prod * num;
				 curr_sum = curr_sum + curr_prod;
				 curr_prod = 1;
				 posIndex[0]++;
			 } 
		}
		
		return curr_sum;
	}
	
	
	private class Cell {
		int r;
		int c;
		int val;
		public Cell(int val, int r, int c) {
			this.val = val;
			this.r = r;
			this.c = c;
		}
	}
	
	public void printSortedGivenRowSorted(int[][] mat) {
		Comparator<Cell> comparator = new Comparator<Cell>() {

			@Override
			public int compare(Cell o1, Cell o2) {
				if(o1.val > o2.val)
					return 1;
				else if(o1.val < o2.val)
					return -1;
				else
					return 0;
			}
		};
		
		PriorityQueue<Cell> queue = new PriorityQueue<Cell>(mat.length, comparator);
		for(int i=0; i<mat.length; i++) {
			queue.add(new Cell(mat[i][0], i, 0));
		}
		System.out.println("sorted order");
		while(!queue.isEmpty()) {
			Cell c = queue.poll();
			System.out.print(c.val+" ");
			if(c.c + 1 < mat[0].length) {
				queue.add(new Cell(mat[c.r][c.c+1], c.r, c.c+1));
			}
		}
	}
	
	public void longestIncrSequence(int arr[]) {
		int len[] = new int[arr.length];
		int seq[] = new int[arr.length];
		int max_length = 0; 
		int max_at=0; 
		for(int i=0; i<arr.length; i++) {
			len[i] = 1;
			seq[i] = i;
			
			int j=0;
			while(j < i) {
				if( arr[j] < arr[i] && len[j] + 1 >= len[i]) {
					len[i] = len[j] + 1;
					if(len[i] > max_length) {
						max_length = len[i];
						max_at = i;
					}
					seq[i] = j;
				}
				j++;
			}
		}
		
		System.out.println(Arrays.toString(len));
		System.out.println(Arrays.toString(seq));
		int res[] = new int[max_length];
		int i = max_at;
		while(max_length > 0) {
			res[--max_length] = arr[max_at];
			max_at = seq[max_at];
		}
		
		System.out.println("Res --->"+Arrays.toString(res));
	}
	
	// aabcccccaaa => a2b1c5a3
	public void compressString(String str) {
		 char c[] = str.toCharArray();
		 char prevChar = c[0];
		 char currentChar = '\0';
		 int currCharCount = 1;
		 StringBuffer sb = new StringBuffer(str.length());
		 
		 for(int i=1; i<c.length; i++) {
			 currentChar = c[i];
			 if(currentChar == prevChar)
				 currCharCount++;
			 else {
				 sb.append(prevChar);
				 sb.append(currCharCount);
				 currCharCount = 1;
			 }
			
			 if(i == c.length-1) {
				 if(currentChar == prevChar) {
					 sb.append(prevChar);
					 sb.append(currCharCount);
				 } else { 
					 sb.append(currentChar);
					 sb.append(1);
				 }
			 }
			 prevChar = currentChar;
		 }
		 
		 System.out.println(sb.toString());
	}
	
	public void setEntireMatrixToZero(int mat[][]) {
		boolean rows[] = new boolean[mat.length];
		boolean cols[] = new boolean[mat.length];
		
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				if(mat[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				if(rows[i] || cols[j]) {
					mat[i][j] = 0;
				}
			}
		}
		
		
	}
	
	public void rotateClockwise(int[][] arr) {
		
	}
	
	public void replaceSpaceWithPerc20(char[] str, int length) {
		
		int spaceCount = 0;
		for(int i=0; i<length; i++) {
			if(str[i] == ' ')
				spaceCount++;
		}
		
		int newLen = length + spaceCount * 2;
		if(newLen == length)
			return;
		
		for(int i=length-1; i>=0; i--) {
			if(str[i] != ' ') {
				str[--newLen] = str[i];
			} else {
				str[--newLen] = '0';
				str[--newLen] = '2';
				str[--newLen] = '%';
			}
		}
		
		System.out.println(str);
		
	}
	
	
	// %20, in place, a little inefficient
	public void replaceSpaceWith20(char[] str) {
		
		int lastNonSpaceChar = -1;
		for(int i=str.length-1; i>=0 ; i--) {
			if(str[i] != ' ') {
				lastNonSpaceChar = i;
				break;
			}
		}
		
		for(int i=0; i<str.length; i++) {
			if(str[i] == ' ') {
				for(int j=lastNonSpaceChar; j> i; j--) {
					str[j+2] = str[j];
				}
				lastNonSpaceChar += 2;
				str[i] = '%';
				str[i+1] = '2';
				str[i+2] = '0';
				i = i+2;
			}
		}
		
		
		System.out.println(str);
	}
	
	public boolean isStrPermutationOfStr(String s1, String s2) {
		int[] ascii1 = new int[256];
		char c1[] = s1.toCharArray();
		for(char c: c1) {
			ascii1[c]++;
		}
		
		char c2[] = s2.toCharArray();	
		for(char c: c2) {
			ascii1[c]--;
		}
		
		for(int i=0 ;i<ascii1.length; i++) {
			if(ascii1[i] != 0)
				return false;
		}
		
		return true;
	}
	
	// using hashtable, sort chars and check, use ASCII array, O(n2) brute force match
	public boolean isStringUniqChars(String str) {
		if(str == null || str.length() == 0)
			return true;
		
		boolean ascii[] = new boolean[256];
		char carr[] = str.toCharArray();
		for(char ch : carr) {
			if(ascii[ch])
				return false;
			else {
				ascii[ch] = true;
			}
		}
		
		return true;
	}
	
	// assume lower case
	public boolean isStringUniqCharsLC(String str) {
		if(str == null || str.length() == 0)
			return true;
		
		char carr[] = str.toCharArray();
		int check = 0;
		for(char c : carr) {
			int value = c - 'a';
			if((check & (1 << value)) > 0) {
				return false;
			}
			check = check | (1 << value);
		}
		
		return true;
	}

}
