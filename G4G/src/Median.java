import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Median {

	public static void main(String[] args) throws IOException {
		int A[] = {900};
		int B[] = {5, 8, 10, 20};
		
		int ar1[] = {1,2,3};// {1, 12, 15, 26, 38};
		int ar2[] = {4,5,6,7,8,9,10,11};//{2, 13, 17, 30, 45};
		
		Median median = new Median();
		System.out.println(median.medianSortedArr(A, B));
		System.out.println(median.medianSortedArr(ar1, ar2));
		System.out.println(median.findMedianSortedArrays(A, B)); 
		System.out.println(median.findMedianSortedArraysSimpler(ar1, ar2));
		MedianStreamIntegers medianStreamIntegers = new MedianStreamIntegers();
		BufferedReader br = new BufferedReader(new FileReader(new File("IntegerStream.txt")));
		String s = null;
		while((s = br.readLine()) != null) {
			int num = Integer.parseInt(s);
			medianStreamIntegers.add(num);
			System.out.println("median --> "+medianStreamIntegers.getMedian());
		}
	}	
	

	// The median check consists of two checks:
	// 1. Is the element to the right of this element equal to or larger
	// 2. Is the element to the left  of this element equal to or smaller
	// Returns a boolean to indicate whether the median was found in array A.
	
	public double findMedianSortedArraysSimpler(int a[], int b[]) {
		int mergedArrLen = a.length + b.length;
		int mediandMergedArr = (mergedArrLen - 1)/2;
		int numLargerThanMedian = mergedArrLen - mediandMergedArr;
		if(a.length == 0)
			if(b.length == 0)
				return -1;
			else
				return b[mediandMergedArr];
		
		if(b.length == 0)
			return a[mediandMergedArr];
		
		double median = findMedianSortedArraysSimpler(a, 0, a.length-1, b, 0, b.length-1, numLargerThanMedian, mediandMergedArr);
		if(median == -1) {
			return findMedianSortedArraysSimpler(b, 0, b.length-1, a, 0, a.length-1, numLargerThanMedian, mediandMergedArr);
		}else
			return median;
	}
	
	//int ar1[] = {1,2,3};
	//int ar2[] = {4,5,6,7,8,9,10,11};
	private double findMedianSortedArraysSimpler(int a[], int aStart, int aEnd, int b[], int bStart, int bEnd, int numLargerThanMedian, int mediandMergedArr) {
		int low = aStart;
		int high = aEnd;
		while(low <= high) {
			int a_mid = (low + high)/2;
			int a_numGreaterThanMid = aEnd - a_mid;
			int b_numGreaterThanMid = numLargerThanMedian - a_numGreaterThanMid;
			int b_index = bEnd - b_numGreaterThanMid+1;
			if(b_index <= bStart) {
				if(a[a_mid] <= b[bStart] && b_index == bStart) 
					return a[a_mid];
				else {
					high = a_mid-1;
				}
			} else if(b_index > bEnd) {
				if(b[bEnd] <= a[a_mid] && b_index-1 == bEnd)
					return a[a_mid];
				else
					low = a_mid+1;
			} else if(b[b_index -1] <= a[a_mid]) { 
				if(b[b_index] >= a[a_mid])
					return a[a_mid];
				else
					high = a_mid-1;
			} else {
				low = a_mid+1;
			}
		}
		
		return -1;
	}
	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
	 
		if ((m + n) % 2 != 0) // odd
			return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
		else { // even
			return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) 
				+ findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
		}
	}
	 
	public int findKth(int A[], int B[], int k, 
		int aStart, int aEnd, int bStart, int bEnd) {
	 
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
	 
		// Handle special cases
		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		if (k == 0)
			return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
	 
		int aMid = aLen * k / (aLen + bLen); // a's middle count
		int bMid = k - aMid - 1; // b's middle count
	 
		// make aMid and bMid to be array index
		aMid = aMid + aStart;
		bMid = bMid + bStart;
	 
		if (A[aMid] > B[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}
	 
		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}
	
	// Inefficient
	public int medianSortedArr(int arr1[], int arr2[]) {
		int[] newArr = new int[arr1.length + arr2.length];
		int i =0, j =0, k =0;
		while(i < arr1.length && j < arr2.length) {
			if(arr1[i] <= arr2[j]) {
				newArr[k] = arr1[i];
				i++;
			} else {
				newArr[k] = arr2[j];
				j++;
			}
			k++;
				
		}
		
		if(i != arr1.length) {
			while(i < arr1.length) 
				newArr[k++] = arr1[i++];
		}
		
		if(j != arr2.length) {
			while(j < arr2.length)
				newArr[k++] = arr2[j++];
		}
		
		int mid = (0 + newArr.length-1)/2;
		if(newArr.length % 2 == 0)
			return (newArr[mid] + newArr[mid+1])/2;
		else
			return newArr[mid];
	}

}


class MedianStreamIntegers {
	
	Comparator<Integer> minToMaxComparator = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1 < o2)
				return -1;
			else if(o1 > o2)
				return 1;
			else
				return 0;
		}
	};
	
	
	Comparator<Integer> maxToMinComparator = new Comparator<Integer>() {
		
		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1 < o2)
				return 1;
			else if(o1 > o2)
				return -1;
			else
				return 0;
		}
	};
	
	PriorityQueue<Integer> minHeap = new PriorityQueue<>(10, minToMaxComparator);
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10, maxToMinComparator);
	
	public void add(int elem) {
		
		int numOfElements = totalSize();
		if(numOfElements == 0) {
			maxHeap.add(elem);
		} else {
			if(elem > maxHeap.peek())
				minHeap.add(elem);
			else
				maxHeap.add(elem);
		}
		
		if(Math.abs(minHeap.size() - maxHeap.size()) >= 2) {
			if(minHeap.size() > maxHeap.size()) {
				int pop = minHeap.poll();
				maxHeap.add(pop);
			} else {
				int pop = maxHeap.poll();
				minHeap.add(pop);
			}
		}
	}
	
	public int getMedian() {
		int numOfElements = totalSize();
		if(numOfElements == 0)
			return Integer.MAX_VALUE;
		
		if(minHeap.size() == maxHeap.size()) {
			return (minHeap.peek() + maxHeap.peek())/2;
		} 
		
		if(minHeap.size() > maxHeap.size())
			return minHeap.peek();
		else
			return maxHeap.peek();
	}
	
	public int totalSize() {
		return minHeap.size() + maxHeap.size();
	}
}
