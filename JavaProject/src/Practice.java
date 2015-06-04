import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;


public class Practice implements Comparable<String>{
	public static void main(String args[]) { 
		Check c = new Check();
		/* int arr[] = {1, 4, 0, 0, 3, 10, 5};
		int result[] = c.subArrayMeetsSumEfficient(arr, 7);
		System.out.println(Arrays.toString(result));
		char[][] mat = c.constructMatrix(6, 7);
		c.displayMatrix(mat);
		System.out.println(c.findFactorial(15)+" "+c.findNumOfZeroesFactorialN(15));
		System.out.println(c.findNumOfZeroesFactNSmart(40));
		c.turnOffKbitN(5, 120); 
		System.out.println(35 >> 6);
		c.turnOffKbitN(5, 120); 
		int arr[] = {12, 16, 22, 30, 35, 39, 42, 
	               45, 48, 50, 53, 55, 56};
		c.findKClosestElements(arr, 35, 4);
		
		float f = 3.3f;
		System.out.println(f % 10);
		System.out.println(c.isStringPalindrome("maddam"));
		System.out.println(c.isStringRotationOfPalindromeInefficient("mmada"));
		System.out.println(c.rotateWithoutRotate("madam", 0)); 
		System.out.println(c.longestCommonSubsequence("abacdfgdcaba", "abacdgfdcaba"));
		System.out.println(c.longestCommonSubstring("abacdfgdcaba", "abacdgfdcaba"));
		System.out.println(c.longestCommonSubstring("Rohan", "Rahul")); 
		int coins[] = {1,3,5};
		int len[] = {1,2,3,4,5,6,7,8,9,10};
		int pri[] = {1,5,8,9,10,17,17,20,24,30};
		c.rodCutting(len, pri);
		
		List<String> list = new Vector<String>(); */
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println(1);
			}
		});
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println(2);
			}
		});
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println(3);
			}
		});
		
		Hashtable<String, String> table = new Hashtable<>();
		
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return 0;
	}  

}

class T1 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}

class T2 extends Thread {
	
} 

class Check { 
	char X = 'X';
	char O = 'O';
	// find longest palindrome in a string 
	
	// least number of coins that make up a sum 
	int result[];
	
	/*int findMinNumCoinsForSum(int coins[], int sum) {
		
		if(result == null) {
			result = new int[sum]; 
			Arrays.fill(result, -1);
		}
		
		if(result[sum] != -1)
			return result[sum];
		
		if(sum <= 0)
			return 0;
		
		int prevMin = findMinNumCoinsForSum(coins, sum-1);
		int count = 0;
		for(int i=0; i< coins.length && coins[i] <= sum; i++) {
			if(coins[i] == sum) {
				count = 1;
				break;
			}
		}
		
		
	}
	*/
	
	int res[] = null;
	void rodCutting(int[] len, int[] pri) {
		res = new int[len.length];
		Arrays.fill(res, -1);
		for(int i=0; i<len.length; i++) {
			res[i] = rodCut(pri,len, i);
		}
		
		System.out.println(Arrays.toString(res));
	}
	
	int rodCut(int pri[], int len[], int lenIndex) {
		if(res[lenIndex] != -1)
			return res[lenIndex]; 
		
		else if(len[lenIndex] == 1)
			return pri[lenIndex];
		
		else { 
			int max = pri[lenIndex];
			for(int i=1; i<lenIndex; i++) {
				int result = res[i-1] + rodCut(pri, len, lenIndex-i);
				if(result > max) {
					max = result;
				}
			}
			return max;
		}
		
	}
	
	boolean isStringRotationOfPalindromeInefficient(String str) {
		for(int i=0; i<str.length(); i++) {
			str = rotateOnce(str);
			System.out.println("new string = "+str);
			if(isStringPalindrome(str))
				return true;
		}
		
		return false;
	}
	
	
	String longestCommonSubstring(String s1, String s2) {
		if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
			return "";
		
		int len1 = s1.length();
		int len2 = s2.length();
		String lcs = "";
		
		for(int i=0; i< len1; i++) {
			if(s1.charAt(i) == s2.charAt(i)) {
				lcs = s1.substring(0, 1) + lcsHelp(s1.substring(1, s1.length()), s2.substring(1, s2.length()));
			} 
		}
		return "";
		
	}
	
	String lcsHelp(String s1, String s2) {
		
		if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
			return "";
		
		if(s1.charAt(0) == s2.charAt(0)) {
			return s1.substring(0, 1) + lcsHelp(s1.substring(1, s1.length()), s2.substring(1, s2.length()));
		} 
		
		return "";
			
	}
	
	String longestCommonSubsequence(String s1, String s2)  {
		if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
			return "";
		
		
		String lcs1 = "", lcs2 = "", lcs3 = "";
		if(s1.charAt(0) == s2.charAt(0)) {
			lcs1 = s1.substring(0, 1) + longestCommonSubsequence(s1.substring(1, s1.length()), s2.substring(1, s2.length()));
		} 
			
		lcs2 = longestCommonSubsequence(s1, s2.substring(1, s2.length()));
			
		lcs3 = longestCommonSubsequence(s1.substring(1, s1.length()), s2);
		
		if(lcs1.length() > lcs2.length()) {
			if(lcs1.length() > lcs3.length())
				return lcs1;
			else
				return lcs3;
		} else if(lcs2.length() > lcs3.length())
			return lcs2;
		else
			return lcs3;
			
	}
	
	void longestPalindromSubstr(String str) {
		
	}
	
	boolean isStringPalindrome(String str) {
		// check if reverse is same
		if(str == null || str.length() == 0 || str.length() == 1)
			return true;
		
		char c[] = str.toCharArray();
		for(int i=0; i<c.length/2; i++) {
			if(c[i] != c[c.length-1-i])
				return false;
		}
		
		return true;
	}
	
	String rotateWithoutRotate(String str, int charIndex) {
		return str.substring(str.length()-1) + str.substring(charIndex, str.length()-1);
	}
	
	 String rotateOnce(String str) {
		if(str == null || str.length() == 0 || str.length() ==1)
			return str;
		
		char c[] = str.toCharArray();
		char charToBeShifted = c[0];
		for(int i=1; i<c.length; i++) {
			char temp = c[i];
			c[i] = charToBeShifted;
			charToBeShifted = temp;
		}
		c[0] = charToBeShifted;
		return new String(c);
	}
	
	void findKClosestElements(int arr[], int X, int k) {
		int foundAt = binarySearch(arr, X);
		if(foundAt == -1)
			System.out.println("Error !");
		else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			int left = foundAt - 1;
			int right = foundAt + 1;
			while(list.size() < k) {
				int min1 = -1, min2 = -1;
				if(left >= 0) {
					min1 = arr[foundAt] - arr[left];
				}
				
				if(right <= arr.length -1) {
					min2 = arr[right] - arr[foundAt];
				}
				
				if(min1 == min2)  {
					list.add(arr[left]);
					left--;
					if(list.size() < k) {
						list.add(arr[right]);
						right++;
					}
				} else if(min1 < min2) {
					list.add(arr[left]);
					left--;
				} else {
					list.add(arr[right]);
					right++;
				}
				
				
			}
			
			System.out.println(Arrays.toString(list.toArray()));
			
		}
	}
	
	private int binarySearch(int arr[], int X) {
		int p = 0 ;
		int q = arr.length - 1;
		
		while ( p < q ) {
			int mid = (p + q)/2;
			if(arr[mid] == X) 
				return mid; 
			
			if(arr[mid] < X) {
				p = mid + 1;
			} else 
				q = mid - 1;
			
		}
		
		return -1;
	}
	
	void turnOffKbitN(int k, int n) {
		if(k <0)
			return;
		
		int knum = 0;
		int shiftBy = 0;
		while((n >> shiftBy) > 0) {
			if(shiftBy == k) {
				shiftBy++;
			} else {
				knum =  (knum | (n & (1 << shiftBy++))); 
			}
		}
		
		System.out.println(knum);
	}
	
	
	int findFactorial(int n) {
		if(n <= 0)
			return 1;
		
		return n * findFactorial(n-1);
		
	}
	
	int findNumOfZeroesFactorialN(int n) {
		int count = 0;
		int fact = findFactorial(n);
		int digit = -1;
		while(fact>0) {
			digit = fact%10;
			if(digit == 0) {
				count++;
				fact = fact/10;
			} else
				break;
		}
		
		return count;
	}
	
	int findNumOfZeroesFactNSmart(int n) {
		int i= 1;
		int count = 0 ;
		while(n/Math.pow(5, i++) > 0)
			count = (int) (count + n/(Math.pow(5,i-1)));
		
		return count;
	}
	
	void displayMatrix(char[][] mat) {
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[0].length; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	char[][] constructMatrix(int m, int n) {
		if(m<=0 || n<=0)
			return new char[0][0];
		
		int minRow = 0, maxRow = m-1;
		int minCol = 0, maxCol = n-1;
		char mat[][] = new char[m][n];
		
		char currChar = X;
		int currRow = 0, currCol = 0;
		int loopCount = 0;
		while(minRow <= maxRow && minCol <= maxCol) {
			
			if(loopCount % 2 == 0)
				currChar = X;
			else
				currChar = O;
			loopCount++;
			while(currCol<=maxCol) {
				mat[currRow][currCol++] = currChar;
			}
			currCol--;
			currRow++;
			minRow++;
			
			while(currRow<=maxRow) {
				mat[currRow++][currCol] = currChar;
			}
			currRow--;
			currCol--;
			maxCol--;
			
			while(currCol>=minCol) {
				mat[currRow][currCol--] = currChar;
			}
			currCol++;
			currRow--;
			maxRow--;
			
			while(currRow>=minRow) {
				mat[currRow--][currCol] = currChar;
			}
			currRow++;
			currCol++;
			minCol++;
			
			
		}
		return mat;
	}
	
	int[] subArrayMeetsSumEfficient(int a[], int sum) {
		
		int temp = -1;
		
		if(a == null || a.length == 0) 
			return new int[0];
		
		if(a[0] == sum)
			return giveNewArrayFrom(a, 0, 0);
		
		int arr[] = Arrays.copyOf(a, a.length);
		for(int i=1; i<a.length; i++) {
			a[i] = a[i]+a[i-1];
			if(a[i] >= sum) {
				temp = i;
				break;
			}
		}
		
		if(temp != -1) {
			if(a[temp] == sum) 
				return giveNewArrayFrom(arr, 0, temp);
			else { 
				for(int i=0;i<temp; i++) {
					if(a[temp] - a[i] == sum) 
						return giveNewArrayFrom(arr, i+1, temp);
				}
				
				return new int[0];
			}
		} else 
			return new int[0];
	}
	int[] subArrayMeetsSumSimple(int a[], int sum) {
		int in1 = -1, in2 = -1;
		boolean found = false;
		for(int i=0; i<a.length; i++) {
			if(!found) {
				in1 = i;
				if(a[in1] == sum) {
					found = true;
					break;
				}
				int tempSum = a[in1];
				for(int j=i+1; j<a.length; j++) {
					in2 = j;
					tempSum = tempSum + a[j];
					if(tempSum == sum) {
						found = true;
						break;
					}
				}
				if(!found) {
					in1 = -1;
					in2 = -1;
				}
			}
		}
		
		if(!found)
			return new int[0];
		else 
			return giveNewArrayFrom(a, in1, in2);
	}
	
	private int[] giveNewArrayFrom(int a[], int i1, int i2) {
		int result[] = new int[i2-i1+1];
		for(int i=i1; i<=i2; i++) {
			result[i-i1] = a[i];
		}
		
		return result;
	}

}
