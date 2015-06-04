import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Page2 {

	public static void main(String[] args) {
		int sumZero[] = {4, 2, -3, 1, 6, 0, -4};
		int tripletsZero[] = {-1,-3,5,4,-1};
		Page2 pg= new Page2();
		pg.sumTriplets(tripletsZero, 0);
		pg.sumTripletsToHandleDuplicates(tripletsZero, 0);
		pg.sumTriplets(sumZero, 0);
		pg.sumTripletsToHandleDuplicates(sumZero, 0);
		int[] candidate = {10, 1, 2, 7, 6, 1, 5};//{2,3,6,7};
		//pg.candidateSumOnlyOnce(candidate, 8);
		pg.allPairsThatSumToK(candidate, 6);
		int[] cand = {2,2,3};
		pg.allPairsThatSumToKLinear(cand, 5);
		int[] triplets = {-1,0, 1, 2, -1, -4};
		pg.allTripletsThatSumToK(triplets, 0);
		int[] triplets1= {-1,0, 1, 2, -1, -4};
		pg.allTripletsThatSumToKBetter(triplets1, 0);
	}
	
	public void allTripletsThatSumToKBetter(int[] arr, int sum) {
		System.out.println("allTripletsThatSumToKBetter...");
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			map.put(arr[i], i);
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(map.containsKey(sum - (arr[i] + arr[j]))) {
					int index = map.get(sum-arr[i] - arr[j]);
					if(index > j) {
						System.out.println("["+arr[i]+", "+arr[j]+", "+arr[index]+"]");
					}
				}
			}
			map.put(arr[i], -1);
		}
	}
	
	
	public void allTripletsThatSumToK(int[] arr, int sum){
		System.out.println("allTripletsThatSumToK...");
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) {
			if(i > 0) {
				while(i< arr.length && arr[i] == arr[i-1])
					i++;
				if(i == arr.length-1)
					break;
			}
			int j = i+1;
			int k = arr.length-1;
			while(j <k) {
				if(arr[i] + arr[j] + arr[k] <= sum) {
					if(arr[i] + arr[j] + arr[k] == sum)
						System.out.println("["+arr[i]+", "+arr[j]+", "+arr[k]+"]");
					do {
						j++;
					} while(j<k && arr[j] == arr[j-1]);
				} else {
					k--;
				}
			}
		}
		
	}
	
	// O(n) solution
	public void allPairsThatSumToKLinear(int[] arr, int k) {
		System.out.println("allPairsThatSumToKLinear..");
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++)
			map.put(arr[i], i);
		
		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(k-arr[i])) {
				int index = map.get(k-arr[i]);
				int elemIndex = map.get(arr[i]);
				if(elemIndex == i && index > i) {
					System.out.println("["+arr[i]+", "+arr[index]+"]");
				}
			}
		}
	}
	//O(nlogn) solution
	public void allPairsThatSumToK(int[] arr, int k) {
		System.out.println("allPairsThatSumToK...");
		Arrays.sort(arr);
		int i=0; 
		int j=arr.length-1;
		while(i<j) {
			if(arr[i] + arr[j] <= k) {
				if(arr[i] + arr[j] == k)
					System.out.println("["+arr[i]+", "+arr[j]+"]");
				do {
					i++;
				}while( i<j && arr[i] == arr[i-1]);
				
			} else if(arr[i] + arr[j] > k) {
				j--;
			}
		}
	}
	
	public void candidateSumOnlyOnce(int arr[], int sum) {
		candidateSumOnlyOnce(arr, 0, new ArrayList<Integer>(), sum);
	}
	
	
	private void candidateSumOnlyOnce(int arr[], int index, List<Integer> list, int sum) {
		if(sum < 0)
			return;
		
		if(sum == 0) {
			System.out.println(list.toString());
			return;
		}
		
		for(int i=index; i<arr.length; i++) {
			list.add(arr[i]);
			candidateSumOnlyOnce(arr, i+1, list, sum-arr[i]);
			list.remove(list.size()-1);
		}
	}
	
	
	// same candidate can be used more than once
	public void candidateSum(int arr[], int sum) {
		candidateSum(arr, 0, new ArrayList<Integer>(), sum);
	}
	
	private void candidateSum(int arr[], int index, List<Integer> list, int sum) {
		if(sum < 0)
			return;
		
		if(sum == 0) {
			System.out.println(list.toString());
			return;
		}
		
		for(int i=index; i<arr.length; i++) {
			list.add(arr[i]);
			candidateSum(arr, i, list, sum-arr[i]);
			list.remove(list.size()-1);
		}
	}
	
	public void sumTripletsToHandleDuplicates(int[] arr, int sum) {
		System.out.println("sumTripletsToHandleDuplicates....");
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			map.put(arr[i],i);
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(map.containsKey(sum -(arr[i]+arr[j])) && map.get(sum-arr[i]-arr[j]) > j) {
					System.out.println("["+arr[i]+", "+arr[j]+", "+arr[map.get(sum-arr[i]-arr[j])]+"]");
				}
			}
			map.put(arr[i], -1);
		}
	}
	
	public void sumTriplets(int[] arr, int sum) {
		System.out.println("sumTriplets...");
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			map.put(arr[i],i);
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(map.containsKey(sum -(arr[i]+arr[j])) && map.get(sum-arr[i]-arr[j]) > j) {
					System.out.println("["+arr[i]+", "+arr[j]+", "+arr[map.get(sum-arr[i]-arr[j])]+"]");
				}
			}
		}
	}

}

class BinTree {
	int val;
	BinTree left;
	BinTree right;
	public BinTree(int val) {
		this.val = val;
	}
}