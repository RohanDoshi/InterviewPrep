
public class EightQueensProblem {

	public static void main(String args[]) {
		EightQueen eightQueen = new EightQueen(8);
		eightQueen.solve();
	}
}

class EightQueen {
	
	Queen[][] chessBoard = null;
	
	Queen[] queens = null; 

 	public EightQueen(int size) {
		chessBoard = new Queen[size][size];
		queens = new Queen[size];
	}
 	
 	public void solve() {
 		int n = chessBoard.length;
 		
 		for(int j=0; j<n; j++) {
 			boolean b = solve1(j, 0, 0);
 			if(b)
 				print();
 		}
 		
 	}
 	
 	private boolean solve1(int currRow, int currCol, int currQueen) {
 		
 		int n = chessBoard.length;
 		boolean didItWork = false;
 		if(currRow < n && currCol < n && currQueen < n) {
 			if(!checkIsOk(currRow, currCol, currQueen)) {
 				int i = currRow;
 				while(i < n) {
 					didItWork = solve1(++i, currCol, currQueen);
 					if(didItWork)
 						break;	
 				}
 	 			
 	 		} else {
 	 			Queen q = new Queen();
 	 			q.row = currRow;
 	 			q.col = currCol;
 	 			queens[currQueen] = q;
 	 			if(currQueen == n-1) {
 	 	 			return true;
 	 			}
 	 			didItWork = solve1(0, currCol + 1, currQueen+1);
 	 		}	
 		}
 		
 		
 		return didItWork;
 	}
 	
 	private boolean checkIsOk(int currRow, int currCol, int currQueen) {
 		
 		for(int k=0; k<currQueen; k++) {
			if(currRow == queens[k].row || currCol == queens[k].col || !checkDiagUpIsOk(currRow, currCol, queens[k].row, queens[k].col) || 
					!checkDiagDownIsOk(currRow, currCol, queens[k].row, queens[k].col) ) {
				return false;
			}
		}
 		
 		return true;
 	}
 	
 	private boolean checkDiagUpIsOk(int currRow, int currCol, int qRow, int qCol) {
 		int n = chessBoard.length;
 		int r = qRow;
 		for(int i = qCol; i<n && r < n; i++) {
 			if(currRow == r++ && currCol == i) {
 				return false;
 			}
 		}
 		r = qRow;
 		for(int i=qCol; i>=0 && r<n; i--) {
 			if(currRow == r++ && currCol == i) {
 				return false;
 			}
 		}
 		return true;
 	}
 	
 	
 	private boolean checkDiagDownIsOk(int currRow, int currCol, int qRow, int qCol) {
 		int n = chessBoard.length;
 		int r = qRow;
 		for(int i = qCol; i<n && r > 0; i++) {
 			if(currRow == r-- && currCol == i) {
 				return false;
 			}
 		}
 		
 		r=qRow;
 		for(int i=qCol; i>=0 && r>0; i--) {
 			if(currRow == r-- && currCol == i) {
 				return false;
 			}
 		}
 		return true;
 	}
 	
 	private void print() {
 		int n = chessBoard.length;
 		System.out.println("====================");
 		for(int j=0; j<n; j++) {
 			for(int i=n-1; i>=0; i--) {
 				if(queens[j].row == i) {
 					System.out.print(1+" ");
 				} else {
 					System.out.print(0+" ");
 				}
 			}
 			System.out.println();
 		}
 		System.out.println("====================");
 	}
 	
 	
 	
}

class Queen {
	int row;
	int col;
}