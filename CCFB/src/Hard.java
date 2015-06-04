import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Hard {

	public static void main(String[] args) {
		Hard fb = new Hard();
		int[] cards = new int[52];
		for(int i=0; i<cards.length; i++) {
			cards[i] = i+1;
		}
		fb.shuffle(cards, 52);
		System.out.println(Arrays.toString(cards));
		fb.numOf2s(100);
		fb.numOf2sSmart(100);
		
		int a[] = {1,2,9,15,25};
		int b[] = {4,10,19};
		fb.findMinDiffSortedArr(a, b);
		String list[] = {"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"};
		fb.findLongestWordMadeOfOtherWords(list);
		Trie trie = new Trie('\0');
		String str = "bibs";
		for(int i=0; i<str.length(); i++) {
			trie.insert(str.substring(i));
		}
		
		System.out.println(trie.isExists("bs"));
		
	}
	
	public void findLongestWordMadeOfOtherWords(String[] list) {
		Comparator<String> comparator = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() > o2.length())
					return -1;
				else 
					return 1;
			}
		};
		Arrays.sort(list, comparator);
		System.out.println(Arrays.toString(list));
		Map<String, Boolean> map = new HashMap<>();
		for(int i=0; i<list.length; i++) {
			map.put(list[i], true);
		}
		
		for(int i=0; i<list.length; i++) {
			if(findLongestWordMadeOfOtherWords(list[i], true, map)) {
				System.out.println("longest word ----> "+list[i]);
				return;
			}
		}
	}
	
	private boolean findLongestWordMadeOfOtherWords(String word, boolean originalWord, Map<String, Boolean> map) {
		
		if(map.containsKey(word) && !originalWord)
			return map.get(word);
		
		for(int i=1; i<word.length(); i++) {
			String left = word.substring(0, i);
			String right = word.substring(i);
			if(map.containsKey(left) && map.get(left) && findLongestWordMadeOfOtherWords(right, false, map)) {
				return true;
			}
		}
		
		map.put(word, false);
		return false;
		
	}
	
	public void findMinDiffSortedArr(int[] a, int[] b) {
		// do BS in b for each element in a.. keep track of min diff returned by BS method
		int minDiff = Integer.MAX_VALUE;
		for(int i=0; i<a.length; i++) {
			minDiff = Math.min(minDiff, minBS(b, a[i]));
		}
		
		System.out.println("MinDiff --> "+minDiff);
	}
	
	public int minBS(int arr[], int x) {
		int low = 0;
		int high = arr.length-1;
		int minDiff = Math.abs(x - arr[high]);
		
		while(low < high) {
			int mid = (low + high) >>> 1;
			int diff = Math.abs(x - arr[mid]);
			if(diff < minDiff) {
				minDiff = diff ;
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
		
		return minDiff;
	}
	
	public void shuffle(int[] cards, int n) {
		if(n <= 0)
			return;
		
		shuffle(cards, n-1);
		if(n < cards.length) {
			Random r = new Random();
			int i = r.nextInt(n);
			int temp = cards[i];
			cards[i] = cards[n];
			cards[n] = temp;
		}
	}
	
	// brute force
	public void numOf2s(int num) {
		int count = 0;
		for(int i=0; i<=num; i++) {
			count = count + numOfValDigits(i, 2);
		}
		System.out.println("Num of 2s... "+count);
	}
	
	private int numOfValDigits(int n, int val) {
		int count = 0;
		while(n > 0) {
			if(n % 10 == val){
				count++;
			}
			n = n/10;
		}
		return count;
	}

	public void numOf2sSmart(int num) {
		int numOfDigits = Integer.toString(num).length();
		int count = 0;
		for(int i=0; i<numOfDigits; i++) {
			count = count + numOf2sSmart(num, i);
		}
		System.out.println("Num of 2s Smart... "+count);
	}
	
	private int numOf2sSmart(int num, int digit) {
		int powerOfDigit = (int) Math.pow(10, digit);
		int nextPowerOfDigit = powerOfDigit * 10;
		int right = num % powerOfDigit;
		int roundDown = num - (num % nextPowerOfDigit);
		int roundUp = num - (num % nextPowerOfDigit) + powerOfDigit;
		
		int digitVal = (num % nextPowerOfDigit) % powerOfDigit;
		if(digitVal < 2) {
			return roundDown/10;
		} else if(digitVal > 2) {
			return roundUp/10;
		} else {
			return roundDown/10 + right + 1;
		}
	}
}
