import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RecursionAndDynamicProgramming {

	public static void main(String[] args) {
		RecursionAndDynamicProgramming rdp = new RecursionAndDynamicProgramming();
		System.out.println(rdp.countNumStairs(5));
		int grid[][] = new int[3][3];
		System.out.println(rdp.numOfPaths(grid, 0, 0));
		int arr[] = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12 ,13};
		int arr1[] = {-10, -5, 2, 2, 2, 3, 4, 8, 9, 12 ,13};
		System.out.println(rdp.findMagicIndex(arr));
		System.out.println(rdp.findMagicIndex(arr1));
		int subs[] = {1,2,3};
		rdp.printAllSubsets(subs);
		rdp.printAllSubsetsInefficient(subs);
		String s = "abc";
		rdp.permutations(s);
		rdp.printAllAdjacentSubsets(s.toCharArray());
		rdp.permutationsOtherWay(s);
		rdp.printAllParanthesis(3);
		System.out.println(rdp.numOfWaysRepresentNCents(10)+" - "+rdp.makeChange(10, 25));
		
		KeyPad keyPad = new KeyPad();
		System.out.println(keyPad.combinations("234").toString());
	}
	
	public int makeChange(int n, int denom) {
		
		  int next_denom = 0;
		  switch (denom) {
			  case 25:
			  next_denom = 10;
			  break;
			  case 10:
			  next_denom = 5;
			  break;
			  case 5:
			  next_denom = 1;
			  break;
			  case 1:
			  return 1;
		  }
		 
		  int ways = 0;
		  for (int i = 0; i * denom <= n; i++) {
		  ways += makeChange(n - i * denom, next_denom);
		  }
		  return ways;
	}
	public int numOfWaysRepresentNCents(int N) {
		if(N <= 0)
			return 0;
		
		int[] denom = {1,5,10,25};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int res = numOfWaysRepresentNCents(N, denom, denom.length-1, map );
		System.out.println(map.toString());
		return res;
	}
	
	
	private int numOfWaysRepresentNCents(int N, int denom[], int index, Map<Integer, Integer> map) {
		
		if(index < 0 || N < 0)
			return 0;
		
		if(N == 0)
			return 1;
		
		int ways = 0;
		for(int i=index; i>= 0; i--) {
			ways += numOfWaysRepresentNCents(N - denom[i], denom, i, map);
		}
		
		return ways;
	}
	
	public void printAllParanthesis(int num) {
		printAllParanthesis(num, 0, 0, "");
	}
	
	private void printAllParanthesis(int num, int open, int close, String s) {
		if(open == num && close == num) {
			System.out.println(s);
			return;
		}
		
		if(open < num) {
			printAllParanthesis(num, open+1, close, s+"(");
			if(close < open) 
				printAllParanthesis(num, open, close+1, s+")");
		} else {
			printAllParanthesis(num, open, close+1, s+")");
		}
	}
	
	public void permutationsOtherWay(String s) {
		System.out.println("permutationsOtherWay {} "+s);
		System.out.println(permutationsOtherWay1(s).toString());
	}
	
	private List<String> permutationsOtherWay1(String s) {
		if(s == null)
			return null;
		
		List<String> permutations = new ArrayList<>();
		if(s.isEmpty()) {
			permutations.add("");
			return permutations;
		}
		
		char first = s.charAt(0);
		String remaining = s.substring(1);
		List<String> permutes = permutationsOtherWay1(remaining);
		for(int i=0; i<permutes.size(); i++) {
			String str = permutes.get(i);
			for(int j=0; j<=str.length(); j++)
				permutations.add(insert(str, j, first));
		}
		
		return permutations;
	}
	
	private String insert(String s, int index, char c) {
		return s.substring(0, index) + c + s.substring(index);
	}
	
	public void permutations(String s) {
		if(s == null || s.isEmpty())
			return;
		
		permute(s.toCharArray(), 0);
	}
	
	private void permute(char c[], int index) {
		
		if(index == c.length) {
			System.out.println(Arrays.toString(c));
			return;
		}
		
		for(int i=index; i<c.length; i++) {
			swap(c, i, index);
			permute(c, index+1);
			swap(c, i, index);
		}
	}
	
	private void swap(char c[], int a, int b) {
		char temp = c[a];
		c[a] = c[b];
		c[b] = temp;
	}
	
	public void printAllAdjacentSubsets(char[] arr) {
		for(int i=0; i<arr.length; i++) {
			StringBuffer buffer = new StringBuffer();
			for(int j=i; j<arr.length; j++) {
				buffer.append(arr[j]);
				System.out.println(buffer.toString());
			}
		}
	}
	
	public void printAllSubsetsInefficient(int[] arr) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<Integer>());
		for(int i=0; i<arr.length; i++) {
			int size = res.size();
			for(int j=0; j<size; j++) {
				List<Integer> list = new ArrayList<Integer>(res.get(j));
				list.add(arr[i]);
				res.add(list);
			}
		}
		System.out.println(res.toString());
	}
	
	public void printAllSubsets(int[] arr) {
		int n = arr.length;
		int size = (int) Math.pow(2, n);
		for(int i=0; i<size; i++) {
			System.out.print("{");
			for(int j=0; j<arr.length; j++) {
				if((i & (1 << j)) > 0) {
					System.out.print(arr[j]+" ");
				}
			}
			System.out.println("} ");
		}
	}
	
	public int findMagicIndex(int[] arr) {
		return findMagicIndex(arr, 0, arr.length-1);
	}
	
	private int findMagicIndex(int[] arr, int start, int end) {
		if(start > end || start < 0 || end >= arr.length)
			return -1;
		
		int mid = (start + end) >>> 1;
		if(arr[mid] == mid)
			return mid;
		
		int leftEnd = Math.min(mid-1, arr[mid]);
		int leftIndex = findMagicIndex(arr, start, leftEnd);
		if(leftIndex != -1)
			return leftIndex;
		
		int rightStart = Math.max(mid+1, arr[mid]);
		return findMagicIndex(arr, rightStart, end);
	}
	
	public int numOfPaths(int[][] grid, int fromRow, int fromCol) {
		int num[] = new int[1];
		boolean b[][] = new boolean[grid.length][grid.length];
		numOfPaths(grid, b, fromRow, fromCol, grid.length-1, grid.length-1, num);
		return num[0];
	}
	
	private void numOfPaths(int[][] grid, boolean[][] visited, int currRow, int currCol, int destRow, int destCol, int num[]) {
		if(currRow < 0 || currRow >= grid.length || currCol < 0 || currCol >= grid.length) 
			return;
		
		if(currRow == destRow && currCol == destCol) {
			num[0]++;
			return;
		}
		
		if(visited[currRow][currCol])
			return;
		
		visited[currRow][currCol] = true; 
		
		
		
		numOfPaths(grid, visited, currRow+1, currCol, destRow, destCol, num);
		numOfPaths(grid, visited, currRow, currCol+1, destRow, destCol, num);
		
		visited[currRow][currCol] = false;
	}
	
	// 1111, 22, 121, 211, 112, 31, 13
	public int countNumStairs(int N) {
		if(N <= 0)
			return 0;
		
		int dp[] = new int[N+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i=4; i<= N; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		return dp[N];
	}

}

class KeyPad { 
	private Map<Integer, List<Character>> map;
	
	public KeyPad() {
		this.map = new HashMap<>();
		construct();
	}
	
	private void construct() {
		char c = 'A';
		for(int i=2; i<=9; i++) {
			List<Character> list = new ArrayList<>();
			list.add(c++);
			list.add(c++);
			list.add(c++);
			if(i == 9)
				list.add(c++);
			map.put(i, list);
		}
	}
	
	public List<String> combinations(String s) {
		List<String> res = new ArrayList<>();
		combinations(s.toCharArray(), 0, "", res);
		return res;
	}
	
	private void combinations(char arr[], int index, String s, List<String> res) {
		if(index > arr.length)
			return;
		
		if(index == arr.length) {
			res.add(s);
			return;
		}
		
		int digit = (int) (arr[index] - '0');
		if(!map.containsKey(digit)) {
			res = Collections.EMPTY_LIST;
			return;
		}
		List<Character> list = map.get(digit);
		for(char c : list) {
			combinations(arr, index+1, s+c, res);
		}
	}
}
