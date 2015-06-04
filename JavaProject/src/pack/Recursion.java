package pack;

import java.util.ArrayList;
import java.util.Arrays;

public class Recursion {

	public static void main(String[] args) {
		
//		for(int i=0; i<10; i++)
//			System.out.println(fib(i));
		
//		System.out.println(numPaths(0, 0, 1, 1));
//
//		ArrayList<Integer> set = new ArrayList<>();
//		set.add(1);
//		set.add(2);
//		set.add(3);
//		set.add(4);
//		set.add(5);
//		
//		ArrayList<ArrayList<Integer>> list = printAllSubsetsSet(set, 0);
//		for(ArrayList<Integer> sub : list) {
//			System.out.println(sub.toString());
//		}
		
//		for(int i=0; i<8; i++)
		placeQueen(0);
	}
	
	static int fib(int n) {
		if(n == 0)
			return 0;
		
		if(n == 1)
			return 1;
		
		return fib(n-1) + fib(n-2);
	}
	
	// can move only right and down
	static int numPaths(int fromRow, int fromCol, int m, int n) {
		
		if(fromRow == m && fromCol == n)
			return 1;
		
		if(fromRow == 0 && fromCol == 1) // this cell is prohibited
			return 0;
		
		if(fromRow > m || fromCol > n)
			return 0;
		
		int num = 0;
		num = num + numPaths(fromRow, fromCol+1, m, n);
		num = num + numPaths(fromRow+1, fromCol, m, n);
		
		
		return num;
		
	}
	
	static ArrayList<ArrayList<Integer>> printAllSubsetsSet(ArrayList<Integer> set, int index) {
		 ArrayList<ArrayList<Integer>> allSubsets = null;
		 if(set.size() == index) {
			 allSubsets = new ArrayList<ArrayList<Integer>>();
			 allSubsets.add(new ArrayList<Integer>());
		 } else {
			 allSubsets = printAllSubsetsSet(set, index + 1);
			 ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
			 Integer item = set.get(index);
			 for(ArrayList<Integer> subset : allSubsets) {
				 ArrayList<Integer> newSubset = new ArrayList<Integer>();
				 newSubset.addAll(subset);
				 newSubset.add(item);
				 moreSubsets.add(newSubset);
			 }
			allSubsets.addAll(moreSubsets); 
		 }
		 
		 return allSubsets;
	}
	
	static int[] colForRow = new int[8];
	static int[] rows = new int[8];
	
	static void placeQueen(int row) {
		if(row == 8) {
			System.out.println(Arrays.toString(colForRow));
			return;
		}
		for(int i=0; i<8; i++) {
			colForRow[row] = i;
			if(check(row)) 
				placeQueen(row+1);
		}
	}
	
	static boolean check(int row) {
		for(int i=0; i<row; i++) {
			int diff = Math.abs(colForRow[i] - colForRow[row]);
			if(diff == 0 || diff == row - i)
				return false;
		}
		return true;
	}

}
