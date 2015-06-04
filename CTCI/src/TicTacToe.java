import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TicTacToe {
	
	public static void main(String args[]) throws IOException {
		TTT game = new TTT();
		game.game();
	}
}


class TTT {
	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private class Cell {
		public Cell() {
		}
		
		public Cell(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		int row; 
		int col; 
	}
	private char[][] mat = null;
	private int size = -1;
	private char ME = 'R';
	private char YOU = 'S';
	
 	public void game() throws IOException {
		
		System.out.println("What size do you want ? ");
		size = Integer.parseInt(br.readLine());
		
		mat = new char[size][size];
		
		System.out.println("I am gonna be 'R' , you gonna be 'S' ");
		
		System.out.println("Do you want to make the first move ? ");
		String firstMoveUser = br.readLine();
		makeMoves(firstMoveUser);
		
	}
	
	private void makeMoves(String firstMoveUser) throws NumberFormatException, IOException {
		if(firstMoveUser.equalsIgnoreCase("yes")) {
			int count = 0;
			while(count < size*size) {
				Cell yourMove = askUser();
				count++;
				if(countCharCol(yourMove.col, YOU) == size || countCharRow(yourMove.row, YOU) == size || countCharDiagLeftToRight(YOU) == size || 
						countCharDiagRightToLeft(YOU) == size) {
					print();
					System.out.println("You Won !!!! Well Played Machaa ");
					return;
				}
				print();
				Cell myMove = makeMyMove();
				if(myMove != null)
					mat[myMove.row][myMove.col] = ME; 
				count++;
				if(countCharCol(myMove.col, ME) == size || countCharRow(myMove.row, ME) == size || countCharDiagLeftToRight(ME) == size || 
						countCharDiagRightToLeft(ME) == size) {
					print();
					System.out.println("I Won !!!! Hell Yeaahhh ");
					return;
				}
				print();
			}
			
			
		} else {
			int count = 0;
			while(count < size*size) {
				Cell myMove = makeMyMove();
				mat[myMove.row][myMove.col] = ME; 
				count++;
				if(countCharCol(myMove.col, ME) == size || countCharRow(myMove.row, ME) == size || countCharDiagLeftToRight(ME) == size || 
						countCharDiagRightToLeft(ME) == size) {
					print();
					System.out.println("I Won !!!! Hell Yeaahhh ");
					return;
				}
				print();
				Cell yourMove = askUser();
				count++;
				if(countCharCol(yourMove.col, YOU) == size || countCharRow(yourMove.row, YOU) == size || countCharDiagLeftToRight(YOU) == size || 
						countCharDiagRightToLeft(YOU) == size) {
					System.out.println("You Won !!!! Well Played Machaa ");
					print();
					return;
				}
				print();
			}
			
		}
	}
	
	
	private void print() {
		System.out.println("-----------------------");
		for(int row=0; row<size; row++) {
			for(int col=0; col<size; col++) {
				System.out.print(mat[row][col] == '\0'?  'X' + " " : mat[row][col] +" ");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
		
	}
	
	private Cell makeMyMove() {
		
		System.out.println("my chance daaa ! ");
		// check if I am about to make a line.. (n-1) MEs in one line ? If yes, Yaaayyy 
		for(int row = 0; row < size; row++)  {
			if(countCharRow(row, ME) == size-1) {
				Cell c = setInEmptyCellGivenRow(row, ME);
				if(c != null)
					return c;
			}
		}
		
		for(int col = 0; col < size; col++) {
			if(countCharCol(col, ME) == size-1) {
				Cell c = setInEmptyCellGivenCol(col, ME);
				if(c != null)
					return c;
			}
		}
		
		if(countCharDiagLeftToRight(ME) == size-1) {
			for(int i=0; i<size; i++) {
				if(mat[i][i] == '\0') {
					mat[i][i] = ME;
					return new Cell(i,i);
				}
			}
		}
		
		if(countCharDiagRightToLeft(ME) == size-1) {
			for(int i=size-1,j=0; i>=0; i--) {
				if(mat[j][i] == '\0') {
					mat[j][i] = ME;
					return new Cell(j,i);
				}
			}
		}
		
		
		// check if the user is about to make a line.. (n-1) YOUs in one line ? if yes , stop that mofo !
		
		for(int row = 0; row < size; row++)  {
			if(countCharRow(row, YOU) == size-1) {
				Cell c = setInEmptyCellGivenRow(row, ME);
				if(c != null)
					return c;
			}
		}
		
		for(int col = 0; col < size; col++) {
			if(countCharCol(col, YOU) == size-1) {
				Cell c = setInEmptyCellGivenCol(col, ME);
				if(c != null)
					return c;
			}
		}
		
		
		
		if(countCharDiagLeftToRight(YOU) == size-1) {
			for(int i=0; i<size; i++) {
				if(mat[i][i] == '\0') {
					mat[i][i] = ME;
					return new Cell(i,i);
				}
			}
		}
		
		if(countCharDiagRightToLeft(YOU) == size-1) {
			for(int i=size-1, j=0; i>=0; i--, j++) {
				if(mat[j][i] == '\0') {
					mat[j][i] = ME;
					return new Cell(j,i);
				}
			}
		}
		
		int max = 0;
		Cell maxCell = null;
		
		for(int row=0; row<size; row++) {
			for(int col=0; col<size; col++) {
				if(mat[row][col] == '\0') {
					int numOfPoss = numOfPossibilities(row, col, ME);
					if(numOfPoss > max) {
						max = numOfPoss;
						maxCell = new Cell(row, col);
					}
				}
			}
		}
		
		if(maxCell != null) {
			return maxCell;
		}
		
		for(int row=0; row<size; row++) {
			for(int col=0; col<size; col++) {
				if(mat[row][col] == '\0') 
				{
					mat[row][col] = ME;
					return new Cell(row, col);
				}
			}
		}
		
		return null;
		
	}
	
	private int numOfPossibilities(int row, int col, char ch) {
		int count = 0;
		int num = 0;
		for(int i=0; i<size; i++) {
			if(mat[row][i] == ch || mat[row][i] == '\0') {
				count++;
			}
		}
		
		if(count == size) 
			num++;
		
		count = 0;
		for(int i=0; i<size; i++) {
			if(mat[i][col] == ch || mat[i][col] == '\0') {
				count++;
			}
		}
		
		if(count == size) 
			num++;
		
		count = 0;
		// center
		if(row == col && row == size/2) {
			for(int i=0; i<size; i++) {
				if(mat[i][i] == ch || mat[i][i] == '\0') {
					count++;
				}
			}
			
			if(count == size)
				num++;
			
			count = 0;
			for(int r=0, c=size-1; c>=0; c--, r++) {
				if(mat[r][c] == ch || mat[r][c] == '\0') {
					count++;
				}
			}
			
			
			if(count == size)
				num++;
		} else if(row == col) {
			
			count = 0;
			
			for(int i=0; i<size; i++) {
				if(mat[i][i] == ch || mat[i][i] == '\0') {
					count++;
				}
			}
			
			if(count == size)
				num++;
		}
		
		if((row == 0 && col == size-1) || (row == size-1 && col == 0)) {
			
			count = 0;
			for(int r=0, c=size-1; c>=0; c--, r++) {
				if(mat[r][c] == ch || mat[r][c] == '\0') {
					count++;
				}
			}
			
			
			if(count == size)
				num++;
		}
		
		return num;
		
	}
	
	private Cell setInEmptyCellGivenRow(int row, char ch) {
		for(int col=0; col<size; col++) {
			if(mat[row][col] == '\0') {
				mat[row][col] = ch;
				return new Cell(row, col);
			}
		}
		return null;
	}
	
	private Cell setInEmptyCellGivenCol(int col, char ch) {
		for(int row=0; row<size; row++) {
			if(mat[row][col] == '\0') {
				mat[row][col] = ch;
				return new Cell(row, col);
			}
		}
		return null;
	}
	
	private int countCharRow(int row, char ch) {
		int count = 0;
		for(int col=0; col<size; col++) {
			if(mat[row][col] == ch) 
				count++;
		}
		
		return count;
	}
	
	private int countCharCol(int col, char ch) {
		int count = 0;
		for(int row=0; row<size; row++) {
			if(mat[row][col] == ch)
				count++;
		}
		
		return count;
	}
	
	private int countCharDiagLeftToRight(char ch) {
		int count = 0;
		for(int i=0; i<size; i++) {
			if(mat[i][i] == ch) {
				count++;
			}
		}
		return count;
	}
	
	private int countCharDiagRightToLeft(char ch) {
		int count = 0;
		for(int i=size-1, row = 0; i>=0; i--, row++) {
			if(mat[row][i] == ch) {
				count++;
			}
		}
		return count;
	}
	
	private Cell askUser() throws NumberFormatException, IOException {
		Cell c = new Cell();
		System.out.println("Enter row: ");
		int row = Integer.parseInt(br.readLine());
		System.out.println("Enter col: ");
		int col = Integer.parseInt(br.readLine());
		if(row < size && col < size && mat[row][col] == '\0') {
			mat[row][col] = YOU;
			c.row = row;
			c.col = col;
			return c;
		} else {
			System.out.println("Incorrect input... Try again");
			return askUser();
		}
		
	}
}