package pack;

import java.util.Arrays;

public class ArrayDataStructure {
	public static void main(String args[]) {
		int arr[] = {91, 56, 58, 57, 90, 92, 94, 93, 1, 45};//{1,2,3};
		Arr obj = new Arr();
		//obj.printPermutations(arr);
		//obj.largestSubArr(arr);
		IntersectionArrays arrays = new IntersectionArrays();
		int ar1[] = {1, 5, 10, 20, 40, 80};
		int ar2[] = {6, 7, 20, 80, 100};
		int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};
		
//		//arrays.printCommonElements(ar1, ar2, ar3);
//		BinarySearch binarySearch = new BinarySearch();
////		System.out.println(binarySearch.numOfOccur(1));
//		ShiftedArray array = new ShiftedArray();
//		int[] a = {4,5,6,7,8,9,1,2,3};
//		for(int e : a)
//			array.findElementInShiftedSortedArray(e);
//		
//		SubArray array2 = new SubArray();
//		int res[] = array2.findSmallestSubArrWithSum(280);
//		System.out.println(Arrays.toString(res));
//		
//		res = array2.findSmallestSubArrWithSumEfficient(280);
//		System.out.println(Arrays.toString(res));
//		
//		SumOfMaxSumPath max = new SumOfMaxSumPath();
//		//max.maxSumPath();
//		
//		AlternatePositiveNegativeElem elem = new AlternatePositiveNegativeElem();
//		//elem.alternate();
//		
//		FindNonRepeatingElements elements = new FindNonRepeatingElements();
//		elements.findTwoNonRepeatingElem();
//		
//		MergeProb mergeProb = new MergeProb();
//		System.out.println(Arrays.toString(mergeProb.merge()));
		
		SubSetSumProblem problem = new SubSetSumProblem();
		problem.findSubSetFor(9);
		
		RotateArr arr2 = new RotateArr();
		arr2.rotate(8);
	}
}

class RotateArr { 
	int a[] = {1,2,3,4,5,6,7};
	
	public void rotate(int k) {
		for(int i=0; i<k; i++) {
			int c = a[a.length-1];
			for(int j=a.length-1; j>0; j--) {
				a[j] = a[j-1];
			}
			a[0] = c;
			System.out.println(Arrays.toString(a));
		}
	}
}

class SubSetSumProblem { 
	int set[] = {3, 34, 4, 12, 5, 2};
	
	public void findSubSetFor(int sum) {
		for(int i=0; i<set.length; i++) {
			if(set[i] == sum) {
			//	lkll
			}
		}
		
		
		for(int i=0; i<set.length; i++) {
			boolean f = subSet(set, 0, i, sum - set[i]) ;
			if(f) {
				System.out.println("Yayyyyyyy !");
				break;
			}
		}
		
	}
	
	public boolean subSet(int[] a, int from,  int indexSub, int sum) {
		
		if(sum <= 0) {
			return false;
		}
		
		for(int i=from; i< a.length; i++) {
			
			if(i != indexSub) {
				
				if(sum == a[i]) {
					System.out.println("yayy");
					return true;
				}
			}
			
		}
		
		boolean flag = false;
		for(int i=indexSub+1; i<a.length; i++) {
			flag = flag | subSet(a, i + 1, i, sum-a[i]);
		}
		return flag;
		
		
	}
	
	/// BAD TRY .......
	public void findSubSet(int sum) {
		int table[][] = new int[set.length][set.length];
		for(int i=0; i<set.length; i++) {
			if(set[i] == sum) {
				System.out.println("yayy @ "+i);
			}
			table[i][i] = set[i];
		}
		
		for(int i=0; i<set.length; i++) {
			for(int j=i+1; j<set.length; j++) {
				table[i][j] = set[i] + set[j];
				table[j][i] = table[i][j];
				if(table[i][j] == sum) {
					System.out.println("yayy @ "+i+" "+j);
				}
			}
		}
		
		for(int l = 3; l <= set.length; l++) {
			for(int i=0; i < set.length; i++) {
				for(int j=i+1; j<set.length; j++) {
					int temp = table[i][j] + table[j+1][j+1];
					
				}
			}
		}
		
	}
}

class MergeProb { 
	
	int a[] = {2, Integer.MIN_VALUE, 7 ,Integer.MIN_VALUE, Integer.MIN_VALUE, 10 , Integer.MIN_VALUE};
	int b[] = {5,8,12,14};
	
	public int[] merge() {
		int larger[] = (a.length > b.length) ? a : b;
		
		int fillAt = larger.length -1;
		for(int i=larger.length-1; i>=0 ;i--) {
			if(larger[i] != Integer.MIN_VALUE) {
				larger[fillAt--] = larger[i];
			}
		}
		
		// { ......,2,7,10}
		int[] smaller = null;
		if(a==larger) 
			smaller = b;
		else
			smaller = a;
		
		int j = larger.length - smaller.length + 1;
		int i=0;
		int start = 0;
		while(start < a.length) {
			
			if( i < smaller.length && j < larger.length) {
				if(smaller[i] <= larger[j]) {
					larger[start++] = smaller[i++];
				} else {
					larger[start++] = larger[j++];
				}
			} else if(i < smaller.length) {
				larger[start++] = smaller[i++];
			} else {
				larger[start++] = larger[j++];
			}
			
			
		}
		
		return larger;
	
	}
}



// 2 0010
// 9 1001
class FindNonRepeatingElements { 
	
	int a[] = {1,3,4,5,7,3,1,5,2,4,7};
	int a2[] = {1,3,4,5,7,3,1,5,2,4,7,9};
	
	public void findOneNonRepeatingElem() { 
		int e = a[0];
		for(int i=1; i<a.length; i++) {
			e = e ^ a[i];
		}
		
		System.out.println(e);
	}
	
	public void findTwoNonRepeatingElem() { 
		int e = a2[0];
		for(int i=1; i<a2.length; i++) {
			e = e ^ a2[i];
		}
		// 2 and 9
		System.out.println(e); // 1011
		// 1011 & (~(1010)) // 1011 & 0101 = 0001
		e = e & (~(e-1));
		int x = 0, y = 0;
		for(int i=0; i<a2.length; i++) {
			if((a2[i] & e) == 0) {
				x = x ^ a2[i];
			} else { 
				y = y ^ a2[i];
			}
		}
		
		System.out.println(" e1 = "+x+" , e2 = "+y);
	}
}


class AlternatePositiveNegativeElem { 
	int a[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
	
	// stable alteration
	public void alternate() { 
		int outOfPlace = -1; 
		
		for(int i=0; i<a.length; i++) {
			
			if(outOfPlace != -1) {
				
				if((a[i] < 0 && a[outOfPlace] >=0) || (a[i] >=0 && a[outOfPlace] < 0)) {
					rightRotate(a, outOfPlace, i);
					outOfPlace = -1;
				}
			}
			
			if(outOfPlace == -1) {
				
				if((a[i] >= 0 && i%2 == 0) || (a[i] <0 && i%2 == 1)) {
					outOfPlace = i;
				}
			}
		}
		
		System.out.println(Arrays.toString(a));
	}
	
	private void rightRotate(int a[], int from, int to) {
		int temp = a[to];
		for(int i=to; i>from; i--) {
			a[i] = a[i-1];
		}
		
		a[from] = temp;
	}
}


class SmallestPossibleIntThatCannotBeRepresentedAsSum {
	int arr[] = {1, 2, 5, 10, 20, 40};
	int arr1[] = {1, 2, 3, 4, 5, 6};
	public void returnNum() {
		
		int res = arr[0]; 
		for(int i=0; i<arr.length && arr[i] <= res; i++) {
			res = res + arr[i];
		}
		
		System.out.println(res);
		
		int res1 = arr1[0]; 
		for(int i=0; i<arr1.length && arr1[i] <= res1; i++) {
			res1 = res1 + arr1[i];
		}
		
		System.out.println(res1);
	}
}

class SumOfMaxSumPath {
	int ar1[] = {2, 3, 7, 10, 12, 15, 30, 34};
    int ar2[] = {1, 5, 7, 8, 10, 15, 16, 19};
    
    public void maxSumPath() {
    	
    	int[] sumOfAr1 = fillSumArrFor(ar1);
    	int[] sumOfAr2 = fillSumArrFor(ar2);
    	
    	int l1 = 0, l2 = 0, sum = 0;
    	int lastMatch1 = -1, lastMatch2 = -1;
    	
    	while(l1 < ar1.length && l2 < ar2.length) {
    		 if(ar1[l1] < ar2[l2]) {
    			 
    			 l1++;
    		 } else if(ar1[l1] >  ar2[l2]) {
    			
    			 l2++;
    		 } else if(ar1[l1] == ar2[l2]) {
    			 if(lastMatch1 == -1 && lastMatch2 == -1) {
    				 sum += Math.max(sumOfAr1[l1], sumOfAr2[l2]);
    				 lastMatch1 = l1; 
    				 lastMatch2 = l2;
    			 } else { 
    				 sum += Math.max(sumOfAr1[l1] - sumOfAr1[lastMatch1], sumOfAr2[l2] - sumOfAr2[lastMatch2]);
    				 lastMatch1 = l1; 
    				 lastMatch2 = l2;
    			 }
    			 
    			 l1++;
    			 l2++;
    		 }
    		
    	}
    	
    	while(l1 < ar1.length) {
    		sum = sum + ar1[l1];
    		l1 ++;
    	}
    	
    	while(l2 < ar2.length) {
    		sum = sum + ar2[l2];
    		l2++;
    	}
    	
    	System.out.println(sum);
    }
    
    
    public int[] fillSumArrFor(int a[]) {
    	int res[] = new int[a.length];
    	if(a.length != 0) {
    		res[0] = a[0];
    		
    		for(int i=1; i<a.length; i++) {
        		res[i] = a[i] + res[i-1];
        	}
    	}
    	
    	return res;
    	
    }
}


class SubArray { 
	
	// Returns length of smallest subarray with sum greater than x.
	// If there is no subarray with given sum, then returns n+1
	int smallestSubWithSum(int arr[], int n, int x)
	{
	    // Initialize current sum and minimum length
	    int curr_sum = 0, min_len = n+1;
	 
	    // Initialize starting and ending indexes
	    int start = 0, end = 0;
	    while (end < n)
	    {
	        // Keep adding array elements while current sum
	        // is smaller than x
	        while (curr_sum <= x && end < n)
	            curr_sum += arr[end++];
	 
	        // If current sum becomes greater than x.
	        while (curr_sum > x && start < n)
	        {
	            // Update minimum length if needed
	            if (end - start < min_len)
	                min_len = end - start;
	 
	            // remove starting elements
	            curr_sum -= arr[start++];
	        }
	    }
	    return min_len;
	}
	
	int[] a = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
	
	public int[] findSmallestSubArrWithSum(int k) {
		int sum = 0, from = -1, to = -1, minLen = a.length;
		for(int i=0; i<a.length; i++) {
			sum  = a[i];
			if(sum > k) {
				from = i;
				to = i;
				minLen = 1;
				break;
			}
			for(int j = i+1; j < a.length; j++) {
				sum = sum + a[j];
				if(sum > k) {
					if(minLen > j - i + 1) {
						minLen = j - i + 1;
						from = i;
						to = j;
					}
				}
			}
		}
		
		int res[] = new int[minLen];
		if(from != -1 && to != -1) {
			for(int i = from; i<= to; i++) {
				res[i-from] = a[i];
			}
		}
		
		return res;
	}
	
	//      0   1   2   3  4   5   6  7  8   9
	// o(n){1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
	public int[] findSmallestSubArrWithSumEfficient(int k) {
		int sum = 0;
		int start = 0, end = 0, minLen = a.length+1;
		while(end < a.length) {
			sum += a[end++];
			if(sum > k) {
				break;
			}
		}
		
		while(sum > k && start < a.length) {
			
			if(end - start < minLen)
				minLen = end-start;
			
			sum = sum - a[start++];
		}
		
		return new int[0];
		
	}

	private int[] copyArr(int a[], int from, int to) {
		int arr[] = new int[to-from+1];
		for(int i=from; i<=to; i++) {
			arr[i] = a[i];
		}
		return arr;
	}
	private int findCrossSum(int a[], int from, int mid, int to) {
		int lSum = 0;
		for(int i=mid; i>= from; i--) {
			lSum += a[i];
		}
		
		int rSum = 0;
		for(int i=mid+1; i<=to; i++) {
			rSum += a[i];
		}
		
		return lSum + rSum;
	}
	
	private int findSum(int a[], int from, int to) {
		int sum = 0;
		for(int i= from; i<=to; i++) {
			sum += a[i];
		}
		
		return sum;
	}
}


class ShiftedArray {
	int[] arr = {4,5,6,7,8,9,1,2,3};
	
	public void findElementInShiftedSortedArray(int k) {
		findElem(arr, 0, arr.length-1, k);
	}
	
	private void findElem(int a[], int from, int to, int k) {
		if(from > to) {
			return;
		}
		
		int mid = (from + to)/2;
		if(a[mid] == k) {
			System.out.println("elem k="+k+" found at "+mid);
			return;
		}
		
		// from - mid and mid - to (one of them is sorted)
		if(a[from] < a[mid]) {
			if(a[from] <= k && k < a[mid]) {
				findElem(a, from, mid-1, k);
			} else {
				findElem(a, mid+1, to, k);
			}
		} else {
			if(a[mid] < k && k <= a[to]) {
				findElem(a, mid+1, to, k);
			} else {
				findElem(a, from, mid-1, k);
			}
		}
		
	}
}

class BinarySearch {
	
	int a[] = {1, 1, 2, 2, 2, 2, 3,};
	
	public int numOfOccur(int val) {
		int i =  bsLastOccurenceIndex(a, 0, a.length-1, val); 
		int j = bsFirstOccurenceIndex(a, 0, a.length-1, val) ;
		return i-j+1;
	}
	public int bsFirstOccurenceIndex(int a[], int from, int to, int val) {
		if(from > to) 
			return -1;
		
		int mid = (from + to) /2;
		
		if(a[mid] == val && (mid == 0 || a[mid-1] < a[mid])) {
			return mid;
		} else if(a[mid] < val){ 
			return bsFirstOccurenceIndex(a, mid+1, to, val);
		} else {
			return bsFirstOccurenceIndex(a, from, mid-1, val);
		}
		
	}
	
	public int bsLastOccurenceIndex(int a[], int from, int to, int val) {
		if(from > to) 
			return -1;
		
		int mid = (from + to) /2;
		
		if(a[mid] == val && (mid == a.length-1 || a[mid+1] > a[mid])) {
			return mid;
		} else if(a[mid] <= val){ 
			return bsLastOccurenceIndex(a, mid+1, to, val);
		} else {
			return bsLastOccurenceIndex(a, from, mid-1, val);
		}
		
	}
}

class IntersectionArrays { 
	
	public void printCommonElements(int[] a, int[] b, int[] c) {
		int i=0, j=0, k=0;
		while(i<a.length && j<b.length && k < c.length) {
			if(a[i] == b[j] && a[i] == c[k]) {
				System.out.print(a[i]+" ");
				i++; j++; k++;
			} else {
				if(a[i] < b[j]) {
					i++;
					if(b[j] < c[k]) {
						j++;
					} else if(b[j] > c[k]) {
						k++;
					} else { 
						
					}
				} else if(a[i] > b[j]) {
					j++;
					if(a[i] > c[k]) {
						k++;
					} else if(a[i] < c[k]) {
						i++;
					}
				} else {
					if(a[i] < c[k]) {
						i++;
						j++;
					} else if(a[i] > c[k]){
						k++;
					}
				}
			}
		}
	}
}

class Arr {
	
	public void largestSubArr(int arr[]) {
		int maxLen = 0;
		for(int i=0; i<arr.length; i++) {
			int max = arr[i];
			int min = arr[i];
			for(int j=i+1; j<arr.length; j++) {
				if(max < arr[j]) {
					max = arr[j];
				}
				if(min > arr[j]) {
					min = arr[j];
				}
				
				if(max-min == j-i) {
					maxLen = Math.max(maxLen, j-i + 1);
				}
			}
		}
		System.out.println("maxLen = " +maxLen);
	}
	
	
	public void printPermutations(int arr[]) {
		printPerm(arr, 0);
	}
	
	private void printPerm(int arr[], int index) {
		if(index == arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for(int i= index; i < arr.length; i++) {
			swap(arr, i, index);
			printPerm(arr, index+1);
			swap(arr, i,index);
		}
	}
	
	private void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
