import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Job {
	int start;
	int end;
	int value;
	
	public Job(int start, int end, int value) {
		this.start = start;
		this.end = end;
		this.value = value;
	}
}

public class DynamicProgramming {

	public static void main(String[] args) {
		DynamicProgramming dp = new DynamicProgramming();
		int cost[] = {1,6,18,22,28}; //{7,6}; //;
		int weight[] = {1,2,5,6,7}; // {1,2};//;
		dp.solveKnapsack(5, cost, weight, 11);
		dp.solveKnapsackBruteForce(5, cost, weight, 11);
		System.out.println(dp.maxNumOfAWithNKeyPress(11));
		
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("i");
		dictionary.add("like");
		dictionary.add("sam");
		//dictionary.add("sung");
		dictionary.add("samsung");
		dictionary.add("ice");
		dictionary.add("cream");
		dictionary.add("icecream");
		dictionary.add("mobile");
		dictionary.add("man");
		dictionary.add("go");
		dictionary.add("mango");
		
		System.out.println(dp.canStringBeSplit(dictionary, "iceillikesamsung"));
		
		int INF = Integer.MAX_VALUE;
		int[][] costs = { {0, 15, 80, 90},
	              {INF, 0, 40, 50},
	              {INF, INF, 0, 70},
	              {INF, INF, INF, 0}
	             };
		
		System.out.println(dp.minCostFromStationToStation(costs, 0, 3));
		
		Job j1 = new Job(1, 2, 50);
		Job j2 = new Job(3, 5, 20);
		Job j3 = new Job(6, 19, 100);
		Job j4 = new Job(2, 100, 200);
		
		Job[] jobs = {j1, j2, j3 ,j4};
		System.out.println(dp.maxValueScheduling(jobs));
		int[] lis = { 10, 22, 9, 33, 21, 50, 41, 60, 80 }; //{10, 22, 33, 50, 60, 80}
		dp.LISMostEfficient(lis);
		
		int costArr[][] = { {1, 2, 3},{4, 1, 2}, {1, 5, 3} };
		System.out.println(dp.minCostPath(costArr, 2, 2));
		System.out.println("edit distance -->"+dp.editDistance("kitten", "sitting"));
		System.out.println("edit distance -->"+dp.editDistance("intention", "execution"));
		System.out.println("edit distance DP --->"+dp.editDistanceBottomUp("intention", "execution"));
		System.out.println("Coin Change ---> "+dp.coinChange(30));
		dp.coinChangeList(30, new ArrayList<Integer>());
		dp.coinChangeBottomUp(30);
	}
	
	public void coinChangeBottomUp(int n) {
		int denom[] = {5,10,25};
		int dp[] = new int[n+1];
		dp[0] = 1;
		for(int i=0; i<denom.length; i++) {
			dp[denom[i]] = 1;
		}
		for(int i=1; i<=n; i++) {
			for(int j=0; j<denom.length; j++) {
				if(i - denom[j] >= 0) {
					dp[i] = dp[denom[j]] + dp[i-denom[j]];
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println("coin change bottom up --> "+dp[n]);
	}
	
	public int coinChange(int n) {
		if(n < 0)
			return 0;
		
		if(n == 0)
			return 1;
		
		return coinChange(n-25) + coinChange(n-10) + coinChange(n-5) ;
	}
	
	
	public void coinChangeList(int n, List<Integer> list) {
		if(n < 0)
			return;
		
		if(n == 0) {
			System.out.println(Arrays.toString(list.toArray()));
			return;
		}
		
		list.add(25);
		coinChangeList(n-25, list);
		list.remove(list.size()-1);
		list.add(10);
		coinChangeList(n-10, list);
		list.remove(list.size()-1);
		list.add(5);
		coinChangeList(n-5, list) ;
		list.remove(list.size()-1);
	}
	
	
	public int editDistanceBottomUp(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		
		int dist[][] = new int[m+1][n+1];
		for(int i=0; i<= m; i++)
			dist[i][0] = i;
		
		for(int i=0; i<=n; i++)
			dist[0][i] = i;
		
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1))
					dist[i][j] = dist[i-1][j-1];
				else {
					dist[i][j] = 1 + Math.min(dist[i-1][j-1], Math.min(dist[i-1][j], dist[i][j-1]));
				}
 					
			}
		}
		System.out.println("Printing distance matrix");
		for(int i=0; i<=m ;i++) {
			for(int j=0; j<=n; j++) {
				System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
		return dist[m][n];
	}
	
	public int editDistance(String s1, String s2) {
		if(s1 == null || s2 == null)
			return 0;
		
		if(s1.isEmpty())
			return s2.length(); 
		
		if(s2.isEmpty())
			return s1.length();
		
		if(s1.charAt(0) == s2.charAt(0)) {
			return editDistance(s1.substring(1), s2.substring(1));
		} else {
			return 1 + Math.min(Math.min(editDistance(s1.substring(1), s2.substring(1)), editDistance(s1.substring(1), s2)), editDistance(s1, s2.substring(1)));
		}
	}
	
	public int minCostPath(int cost[][], int destRow, int destCol) {
		int totalCost[][] = new int[cost.length][cost[0].length];
		return minCostPath(cost, 0, 0, destRow, destCol , totalCost);
	}
	
	private int minCostPath(int cost[][], int currRow, int currCol, int destRow, int destCol,int totalCost[][]) {
		if(currRow < 0 || currRow >= cost.length || currCol < 0 || currCol >= cost[0].length)
			return -1;
		
		if(totalCost[currRow][currCol] != 0)
			return totalCost[currRow][currCol];
		
		int costCell = cost[currRow][currCol];
		
		if(currRow == destRow && currCol == destCol) {
			totalCost[currRow][currCol]= costCell;
			return totalCost[currRow][currCol];
		}
		
		int downCost = minCostPath(cost, currRow+1, currCol, destRow, destCol,totalCost);
		int rightCost = minCostPath(cost, currRow, currCol+1, destRow, destCol, totalCost);
		int diagCost = minCostPath(cost, currRow+1, currCol+1, destRow, destCol, totalCost);
		
		if(downCost == -1)
			downCost = Integer.MAX_VALUE;
		
		if(rightCost == -1)
			rightCost = Integer.MAX_VALUE;
		
		if(diagCost == -1)
			diagCost = Integer.MAX_VALUE;
		
		totalCost[currRow][currCol]=  Math.min(downCost, Math.min(rightCost, diagCost)) + costCell;
		return totalCost[currRow][currCol];
		
	}
	
	// O(nlogn) binary search
	public void LISMostEfficient(int arr[]) {
		
		int[] len = new int[arr.length];
		int[] seq = new int[arr.length];
		int maxLen = 1;
		len[0] = 1;
		seq[0] = 0;
		
		for(int i=1; i<arr.length; i++) {
			len[i] = 1;
			seq[i] = i;
			
			int low = 1;
			int high = maxLen;
			
			while(low <= high) {
				int mid = (low+high)/2;
				if(arr[seq[mid]] < arr[i]) {
					low = mid+1;
				} else {
					high = mid-1;
				}
					
			}
			
			len[i] = low;
			seq[low] = i;
			
			if(low > maxLen)
				maxLen = low;
		}
		
		System.out.println("Len --> "+Arrays.toString(len));
		System.out.println("Seq --> "+Arrays.toString(seq));
		System.out.println("MaxLen --> "+maxLen);
		
	}
	
	public void LISBruteForce(int arr[]) {
		int max = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] > arr[i]) {
					int prev = arr[j];
					int len = 2;
					for(int k=j+1; k<arr.length; k++) {
						if(arr[k] > prev) {
							len++;
							prev = arr[k];
						}
					}
					if(len > max)
						max = len;
				}
			}
		}
		
		System.out.println("Max Len ---> "+max);
	}
	
//	public int maxValueSchedulingDP(Job[] jobs) {
//		int table[] = new int[jobs.length];
//		
//	}
	
	
	
	
	public int maxValueScheduling(Job[] jobs) {
		return maxValueScheduling(jobs, 0);
	}
	
	public int maxValueScheduling(Job[] jobs, int startJob) {
		if(startJob >= jobs.length)
			return 0;
		
		int valueOfCurrJob = jobs[startJob].value;
		
		if(startJob == jobs.length-1)
			return valueOfCurrJob;
		
		int maxValue = 0;
		
		for(int i=startJob+1; i<jobs.length; i++) {
			int value = valueOfCurrJob;
			if(jobs[i].start >= jobs[startJob].end) {
				value = valueOfCurrJob + maxValueScheduling(jobs, i);  
			}
			if(value > maxValue)
				maxValue = value;
			
		}
		
		return maxValue;
		
		
	}
	
	public int minCostFromStationToStation(int[][] costs, int from, int to) {
		return minCostFromStationToStation(costs, from, from+1, to);
	}
	
	
	public int minCostFromStationToStation(int[][] costs, int from, int stop, int to) {
		if(from >= to)
			return 0;
		
		int min = Integer.MAX_VALUE;
		for(int i=stop; i<=to; i++) {
			int minCost = costs[from][i] + minCostFromStationToStation(costs, i, i+1, to);
			if(min > minCost)
				min = minCost;
		}
		return min;
	}
	
	public boolean canStringBeSplit(Set<String> dictionary, String str) {
		return canStringBeSplit(dictionary, str, 0, 1);
	}
	
	public boolean canStringBeSplit(Set<String> dictionary, String str, int start, int mid) {
		
		if(start >= str.length())
			return true;
		
		int temp = mid;
		while(temp <= str.length()) {
			if(!dictionary.contains(str.substring(start, temp)))
				temp++;
			else
				break;
		}
		if(temp == str.length() + 1)
			return false;
		
		if(canStringBeSplit(dictionary, str, temp, temp+1))
			return true;
		
		return canStringBeSplit(dictionary, str, start, temp+1);
	}
	
	enum Keys {
		A,
		Select_All,
		Copy_Selected,
		Paste_Copied;
	}
	
	// #Without DP
	public int maxNumOfAWithNKeyPress(int N) {
		return maxNumOfAWithNKeyPress(N, 0, 0, 0, false);
	}
	
	private int maxNumOfAWithNKeyPress(int N, int numOfKeysPressed, int numOfWhenCopied, int numOfAPrint, boolean copied) {
		if(N - numOfKeysPressed <= 0)
			return numOfAPrint;
		
		if(N - numOfKeysPressed == 1)
			return copied ? numOfAPrint + (numOfWhenCopied) : numOfAPrint+1;
		
		int printA1=0, printA2=0, printA3 = 0;
		
		printA1 = maxNumOfAWithNKeyPress(N, numOfKeysPressed + 1, numOfWhenCopied, numOfAPrint+1, copied);
		if(N-numOfKeysPressed >= 3) {
			printA2 = maxNumOfAWithNKeyPress(N, numOfKeysPressed+3, numOfAPrint, numOfAPrint*2, true);
		}
		
		if(copied) {
			printA3 = maxNumOfAWithNKeyPress(N, numOfKeysPressed+1, numOfWhenCopied, numOfAPrint + (numOfWhenCopied), copied);
		}
		
		return Math.max(printA3, Math.max(printA1, printA2));
		
	}
	
//	//------------------- Good try but incorrect 
//	public int maxNumOfAWithNKeyPress(int N, Keys[] keys) {
//		if(N <= 0)
//			return 0;
//		
//		if(N == 1)
//			return 1;
//		
//		int max = 0;
//		
//		for(int i=0; i<N; i++) {
//			max = Math.max(max, Math.max(N-i, (N-i)*(int)Math.pow(2, (i/3))));
//		}
//		return max;
//	}
	
	// steal the most expensive items from the store with total weight <= knapsackWeight
	public void solveKnapsack(int numOfItems, int[] cost, int[] weight, int knapsackWeight) {
		int[][] solution = new int[numOfItems+1][knapsackWeight+1];
		for(int i=1; i<=numOfItems; i++) {
			for(int j=1; j<=knapsackWeight; j++) {
				if(weight[i-1] <= j) {
					solution[i][j] = Math.max(solution[i-1][j], cost[i-1] + solution[i-1][j-weight[i-1]]);
				} else {
					solution[i][j] = solution[i-1][j];
				}
			}
		}
	
		System.out.println(solution[numOfItems][knapsackWeight]);
	}
	
	public void solveKnapsackBruteForce(int numOfItems, int[] cost, int[] weight, int knapsackWeight) {
		
		int maxValue = 0;
		for(int n=1; n<=numOfItems; n++) {
			for(int w=0; w<weight.length; w++) {
				int totalWeight = 0;
				int value = 0;
				for(int k=1; w+k<=n; k++) {
					if(totalWeight + weight[w+k-1] <= knapsackWeight) {
						totalWeight = totalWeight + weight[w + k-1];
						value = value + cost[w + k-1];
					}
				}
				if(value > maxValue)
					maxValue = value;
			}
		}
		
		System.out.println(maxValue);
	}

}
