package killit;

import java.util.Arrays;

public class NQueens {

	public static void main(String[] args) {
		ChessBoard board = new ChessBoard(8);
		board.solveNQueen();
	}

}

class ChessBoard {
	
	private int N;
	private int board[][] = null;
	private int numQueens ;
	public ChessBoard(int N) {
		this.N = N;
		this.board = new int[N][N];
		this.numQueens = N;
	}
	
	public void solveNQueen() {
		int row[] = new int[N];
		int col[] = new int[N];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(row, Integer.MIN_VALUE);
			Arrays.fill(col, Integer.MIN_VALUE);
			solve(numQueens, i, 0, row, col);
			display(row, col);
		}
	}
	
	private void solve(int queens, int currRow, int currCol, int row[], int col[]) {
		if(currRow < 0 || currRow >= N)
			return;
		
		if(queens == 0)
			return;
		
		if(!isRowColDiagAlreadyTaken(currRow, currCol, row, col)) {
			row[queens-1] = currRow;
			col[queens-1] = currCol;
			solve(queens-1, currRow+1, currCol+1, row, col);
		} else { 
			solve(queens, currRow+1, currCol, row, col);
			solve(queens, currRow-1, currCol, row, col);
		}
		
	}
	
	private boolean isRowColDiagAlreadyTaken(int currRow, int currCol, int row[] , int col[]) {
		for(int i= N-1; i>=0; i--) {
			if(row[i] == currRow || col[i] == currCol ) {
				return true;
			}
		}
		
		if(isDiagonalTaken(currRow, currCol, row, col))
			return true;
		
		return false;
	}
	
	private boolean isDiagonalTaken(int currRow, int currCol, int row[] , int col[]) {
		for(int i=N-1; i>=0; i--) {
			int r = row[i];
			int c = col[i];
			if(r == Integer.MIN_VALUE && c == Integer.MIN_VALUE)
				return false;
			
			while(r < N && c < N) {
				if(currRow == r && currCol == c) {
					return true;
				}
				c++;
				r++;
			}
			r = row[i];
			c = col[i];
			while(r >= 0 && c >= 0) {
				if(currRow == r && currCol == c) {
					return true;
				}
				c--;
				r--;
			}
			r = row[i];
			c = col[i];
			while(r >= 0 && c < N) {
				if(currRow == r && currCol == c) {
					return true;
				}
				r--;
				c++;
			}
			r = row[i];
			c = col[i];
			while(r < N && c >= 0) {
				if(currRow == r && currCol == c) {
					return true;
				}
				r++;
				c--;
			}
			
		}
		return false;
	}
	
	private void display(int row[], int col[]) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(row[j] == i && col[j] == j) 
					System.out.println(1+" ");
				else
					System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
