import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;


public class NSlide {

	public static void main(String args[]) {
		Slider game = new Slider(3);
		game.buildMat();
		game.solve();
		game.print();
	}
}

class Slider { 
	private class Cell { 
		public Cell(int val, int col, int row) {
			this.val = val;
			this.row = row;
			this.col = col;
		}
		int val;
		int row;
		int col;
	}
	int[][] mat = {{0,1,3},{4,2,5}, {7,8,6}};
	int size = 0;
	Map<Integer, Cell> map = new HashMap<Integer, Slider.Cell>();
	
	public Slider(int size) {
		this.size = size;
		mat = new int[size][size];
	}
	
	public void buildMat() {
		
		int n = size * size - 1;
		int num = 1;
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				if(num <= n) {
					map.put(num, new Cell(num, j, i));
					num++;
				}
			}
		}
			
		int a[] = new int[size*size-1];
		for(int i=1; i<=n; i++) {
			a[i-1] = i;
		}
		shuffle(a);
		int count = 0;
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				if(count < a.length)
				mat[i][j] = a[count++];
			}
		}
		
		map.put(0, new Cell(0, size-1, size-1));
	}
	
	public void print() {
		System.out.println("==================");
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("==================");
	}
	
	private void shuffle(int a[]) {
		Random r = new Random();
		int index = -1;
		for(int i=0; i<a.length; i++) {
			index = r.nextInt(a.length);
			int temp = a[i];
			a[i] = a[index];
			a[index] = temp;
		}
	}
	// 0,2 --> 2,1 == 3
	// 2,1 --> 1,0 == 2
	// 1,1 --> 0,2 == 2
	
	public void solve() {
		solve1(size-1, size-1, -1, -1);
	}
	
	private class CellValMinsteps implements Comparable<CellValMinsteps> {
		int val;
		int minSteps;
		int currRow;
		int currCol;
		public CellValMinsteps(int val, int minSteps, int currRow, int currCol) {
			this.val = val;
			this.minSteps = minSteps;
			this.currCol = currCol;
			this.currRow = currRow;
		}
		@Override
		public int compareTo(CellValMinsteps o) {
			if(this.minSteps > o.minSteps)
				return 1;
			else if(this.minSteps < o.minSteps) 
				return -1;
			else
				return 0;
		}
		
	}
	private List<State> list = new ArrayList<>();
	private class State { 
		int [][] matrix; 
		public State(int[][] mat) {
			this.matrix = newMatFrom(mat);
		}
		
		public int[][] newMatFrom(int[][] mat) {
			int [][] arr = new int[mat.length][mat.length];
			for(int i=0; i<mat.length; i++) {
				for(int j=0; j<mat.length; j++) {
					arr[i][j] = mat[i][j];
				}
			}
			return arr;
		}
	}
	
	private void solve1(int blankRow, int blankCol, int prevRow, int prevCol) {
		// row and col denote the blank cell
		if(isGoalReached()) {
			print();
			System.exit(0);
		}
		else {
			print();
			this.list.add(new State(mat));
		}
		List<CellValMinsteps> list = new ArrayList<>();
		int leftCell, rightCell, upCell, downCell;
		int minLeft, minRight, minUp, minDown;
		
		if(blankCol > 0 && !(blankRow == prevRow && blankCol - 1 == prevCol)) {
			leftCell = mat[blankRow][blankCol-1];
			swap(blankRow, blankCol, blankRow, blankCol-1);
			minLeft = minNumOfStepsToGoal();
			swap(blankRow, blankCol, blankRow, blankCol-1);
			list.add(new CellValMinsteps(leftCell, minLeft, blankRow, blankCol-1));
		} 
		
		if(blankCol < size -1 && !(blankRow == prevRow && blankCol+1 == prevCol) ) {
			rightCell = mat[blankRow][blankCol+1];
			swap(blankRow, blankCol, blankRow, blankCol + 1);
			minRight = minNumOfStepsToGoal();
			swap(blankRow, blankCol, blankRow, blankCol+1);
			list.add(new CellValMinsteps(rightCell, minRight, blankRow, blankCol+1));
		}
		
		if(blankRow > 0 && !(blankRow -1 == prevRow && blankCol == prevCol)) {
			upCell = mat[blankRow-1][blankCol];
			swap(blankRow, blankCol, blankRow-1, blankCol);
			minUp = minNumOfStepsToGoal();
			swap(blankRow, blankCol, blankRow-1, blankCol);
			list.add(new CellValMinsteps(upCell, minUp, blankRow-1, blankCol));
		}
		
		if(blankRow < size -1 && !(blankRow +1 == prevRow && blankCol == prevCol)) {
			downCell = mat[blankRow+1][blankCol];
			swap(blankRow, blankCol, blankRow+1, blankCol);
			minDown = minNumOfStepsToGoal();
			swap(blankRow, blankCol, blankRow+1, blankCol);
			list.add(new CellValMinsteps(downCell, minDown, blankRow+1, blankCol));
		}
		
		CellValMinsteps[] arr = list.toArray(new CellValMinsteps[list.size()]);
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) {
			CellValMinsteps cellSelected = arr[i];
			
			mat[blankRow][blankCol] = mat[cellSelected.currRow][cellSelected.currCol];
			mat[cellSelected.currRow][cellSelected.currCol] = 0;
	
			if(!isStateInList(mat)) {
				solve1(cellSelected.currRow, cellSelected.currCol, blankRow, blankCol);
				mat[cellSelected.currRow][cellSelected.currCol] = mat[blankRow][blankCol];
				mat[blankRow][blankCol] = 0;
			} else { 
				mat[cellSelected.currRow][cellSelected.currCol] = mat[blankRow][blankCol];
				mat[blankRow][blankCol] = 0;
			}
		}
		
	}
	
	private boolean isStateInList(int[][] arr) {
		for(int i=0; i<list.size(); i++) {
			State s = list.get(i);
			boolean flag = true;
			for(int j=0; j<size; j++) {
				for(int k=0; k<size; k++) {
					flag = flag && s.matrix[j][k] == arr[j][k]; 
				}
			}
			if(flag)
				return true;
		}
		return false;
	}
	
	private void swap(int a, int b, int p, int q) {
		int temp = mat[a][b];
		mat[a][b] = mat[p][q];
		mat[p][q] = temp;
	}
	
	private boolean isGoalReached() {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(mat[i][j] != 0) {
					Cell c = map.get(mat[i][j]);
					if(c.row == i && c.col == j) {
						continue;
					} else
						return false;
				}
			}
		}
		return true;
	}
	
	private int minNumOfStepsToGoal() {
		int count =0;
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				count += Math.abs(i-map.get(mat[i][j]).row) + Math.abs(j-map.get(mat[i][j]).col);
			}
		}
		return count;
	}
	
}
