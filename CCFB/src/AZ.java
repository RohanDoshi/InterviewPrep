import java.util.Arrays;


public class AZ {

	public static void main(String[] args) {
		AZ az = new AZ();
		int[] arr  = {1,2,3,1,1,2,4,1,3,4,4,4,4,1,3};	// 1 1 1 2 2 3
		System.out.println(az.secondMostRepeating(arr));
	}
	
	public int secondMostRepeating(int[] arr) {
		Arrays.sort(arr);
		int count = 1, lastNum = arr[0];
		int maxCount = 1, maxNum = lastNum;
		for(int i=1; i<arr.length; i++) {
			if(arr[i] == lastNum) {
				count++;
			} else {
				if(count > maxCount) {
					maxCount = count;
					maxNum = lastNum;
				}
				count=0;
			}
			lastNum = arr[i];
		}
		
		if(count == arr.length)
			return maxNum;
		
		count = 0; lastNum = arr[0] != maxNum ? arr[0] : arr[maxCount];
		int secMaxNum = lastNum, secMaxCount = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != maxNum) {
				if(arr[i] == lastNum) {
					count++;
				} else {
					if(count > secMaxCount) {
						secMaxCount = count;
						secMaxNum = lastNum;
					}
					count=1;
				}
				lastNum = arr[i];
			}
		}
		
		if(count > secMaxCount) {
			secMaxCount = count;
			secMaxNum = arr[arr.length-1];
		}
		
		return secMaxNum;
	}

}

class StackMedian {
	
}
