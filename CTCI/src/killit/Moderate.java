package killit;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Moderate {

	public static void main(String[] args) {
		Moderate m = new Moderate();
		m.swapInPlace(-2, -3);
		
		m.numOfTrailingZeroes(50, new int[1]);
		m.numOfTrailingZeroesSmart(50);
		System.out.println(m.sign(-10));
		System.out.println(m.sign(10));
		System.out.println(m.sign(0));
		m.findMax(1, 5);
		m.findMax(5, 1);
		m.findMax(5, 5);
		m.findMaxHandleOverflow(1, -5);
		m.findMaxHandleOverflow(-1, -5);
		m.findMaxHandleOverflow(Integer.MIN_VALUE, -5);
		m.findMaxHandleOverflow(Integer.MAX_VALUE, -5); // # does not work because of overflow
		System.out.println(Integer.parseInt("1001", 2));
		int arr[] = {1,2,4,7,10,11,7,12,6,7,16,18,19};
		m.findIndicesBetweenWhichElemNeedToBeSortedToMakeSortedArr(arr);
		m.convertNumberToWords(12345);
		
		int[] pairSum = {-1, 2, 1, -4} ; //{-2,-1,0,3,5,6,7,9,13,14};
		m.findPairsThatMatchSum(pairSum, 1);
		System.out.println("------------------------");
		m.findPairsThatMatchSumMethod2(pairSum, 2);
		System.out.println("------------------------");
		m.findThreeSum(pairSum, 2);
		
	}
	
	public void findThreeSum(int[] arr, int sum) {
		Arrays.sort(arr);
		int i = 0;
		while(i + 1 < arr.length) {
			int j = i + 1;
			int k = arr.length-1;
			while(j < arr.length && k > i && j != k) {
					int tempSum = arr[i] + arr[j];
					if(tempSum + arr[k] == sum) {
						System.out.println("("+arr[i]+","+arr[j]+","+arr[k]+")");
						j++; k--;
					} else if(tempSum + arr[k] < sum) {
						j++;
					} else {
						k--;
					}
				}
			
			i++;
		}
	}
	
	public void findPairsThatMatchSumMethod2(int[] arr, int sum) {
		
		Arrays.sort(arr);
		int s = 0;
		int e = arr.length-1;
		
		while(s != e) {
			if(arr[s] + arr[e] == sum) {
				System.out.println("("+arr[s]+","+arr[e]+")");
				s++;
				e--;
			} else if(arr[s] + arr[e] < sum) {
				s++;
			} else {
				e--;
			}
		}
	}
	
	public void findPairsThatMatchSum(int[] arr, int sum) {
		Set<Integer> set = new HashSet<>();
		for(int i : arr) {
			set.add(i);
		}
		
		for(int i: arr) {
			if(set.contains(sum-i)) {
				System.out.println("("+i+","+(sum-i)+")");
			}
		}
	}
	
	public void convertNumberToWords(long num) {
		String[] digitsTens = {"zero","one","two","three","four","five","six","seven","eight","nine",
				"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty"};
		
		String million = "Million", thousand = "Thousand", hundred = "Hundred", billion ="Billion";
		
		String biggies[] = {billion, million, thousand, hundred};
		
		DecimalFormat decimalFormat = new DecimalFormat("0000000000");
		String numStr = decimalFormat.format(num);
		
		String sub = null;
		int subNum = 0;
		int big = 0;
		String res = "";
//		while(!numStr.equals("") ) {
//			sub = numStr.substring(0, 3);
//			subNum = Integer.parseInt(sub);
//			if(subNum != 0) {
//				if(sub.charAt(0) != 0) {
//					res = res + digitsTens[sub.charAt(0) - '0'] + hundred;
//				}
//				if(Integer.parseInt(sub.substring(1, 3)) < digitsTens.length) {
//					res = res + digitsTens[Integer.parseInt(sub.substring(1, 3))];
//				} else { 
//					
//				}
//				res = res + biggies[big];
//			}
//			big++;
//			numStr = numStr.substring(3, numStr.length());
//		}
		
		System.out.println(res);
		
		
	}
	
	// {1,2,4,7,10,11,7,12,6,7,16,18,19} => 3,9
	public void findIndicesBetweenWhichElemNeedToBeSortedToMakeSortedArr(int arr[]) {
		int maxSoFar = arr[0];
		int index1 = -1, index2 = -1;
		for(int i=1; i< arr.length; i++) {
			if(arr[i] >= maxSoFar) {
				maxSoFar = arr[i];
			} else {
				// 0 to i-1 binary search for arr[i]
				if(index1 == -1)
					index1 = bs(arr, 0, i-1, arr[i]);
				else {
					if(arr[i] < arr[index1])
						index1 = bs(arr,0, index1, arr[i]);
				}
				index2 = i;
			}
		}
		
		System.out.println(index1 +" -- "+index2);
	}
	
	private int bs(int arr[], int a, int b, int val) {
		if(a > b)
			return -1;
		
		if(a == b)
			return a;
		
		int mid = (a+b)/2;
		
		if(arr[mid] == val) 
			return mid;
		
		if(b-a == 1) 
			return arr[a] > val ? a : b;
		
		else if(val > arr[mid]) {
			return bs(arr, mid+1, b, val);
		} else {
			return bs(arr, a, mid-1, val);
		}
	}
	
	// Incorrect
	public void findMaxHandleOverflow(int a, int b) {
		int sign_a = sign(a); // 1
		int sign_b = sign(b); // 1
		int sign_c = sign(a-b); // 1
		
		// if a is positive but a-b is negative, it means either b is greater than a or a-b overflowed (b is neg)
		// if a is negative but a-b is positive, it means either b is lesser than a or a-b overflowed (b is pos)
		
		int use_sign_a = sign_a ^ sign_b; // 0
		// if use_sign_a is 0 , both are either positive or negative.
		int use_sign_c = sign_c ^ flip(use_sign_a); // 0
		int res = a*use_sign_a + b*use_sign_c;
		System.out.println("max ->"+res);
		
	}
	
	// #withoutIfElse
	public void findMax(int a, int b) {
		
		// find sign of a-b
		int si = sign(a-b);
		int q = flip(si);
		int res = a*q + si*b;
		System.out.println("max -> "+res);
		
	}
	
	public int flip(int bit) {
		return bit^1;
	}
	
	// 1 is Negative, 0 is positive.
	public int sign(int a) {
		return (a >> 31) & 1;
	}
	
	public void swapInPlace(int a, int b) {
		System.out.println("Before Swap -> ("+a+" "+b+")");
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("After Swap -> ("+a+" "+b+")");
	}
	
	// #Iterative
	public void numOfTrailingZeroesSmart(int n) {
		int count = 0;
		for(int i=5; n/i >0; i=i*5) {
			count = count+(n/i);
		}
		System.out.println(count);
	}
	
	public void numOfTrailingZeroes(int n, int zero[]) {
		if(n <= 0) {
			System.out.println(zero[0]);
			return;
		}
		
		if(n % 5 == 0) {
			int temp = n;
			while(temp != 0) {
				if(temp % 5 == 0)
					zero[0]++;
				temp = temp/5;
			}
		}
		
		numOfTrailingZeroes(n-1, zero);
	}

}
