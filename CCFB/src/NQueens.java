import java.util.ArrayList;


public class NQueens {

	public static void main(String[] args) {
		NQueens nQueens = new NQueens();
		Integer[] columns = new Integer[GRID_SIZE];
		ArrayList<Integer[]> list = new ArrayList<>();
		nQueens.solve(0, columns, list);
		
		for(int k=0; k<list.size(); k++) {
			Integer[] res = list.get(k);
			for(int i=0; i<GRID_SIZE; i++) {
				for(int j=0; j<GRID_SIZE; j++) {
					if(res[i] == j) {
						System.out.print(1+" ");
					} else {
						System.out.print(0+" ");
					}
				}
				System.out.println();
			}
			System.out.println("-------------------");
		}
	}
	
	private static final int GRID_SIZE = 8;
	
	public void solve(int row, Integer[] columns, ArrayList<Integer[]> list) {
		if(row == GRID_SIZE) {
			list.add(columns.clone());
		} else {
			for(int col=0; col<columns.length; col++) {
				if(check(columns, row, col)) {
					columns[row] = col;
					solve(row+1, columns, list);
				}
			}
		}
	}
	
	private boolean check(Integer[] columns, int row, int col) {
		for(int r=0; r<row; r++) {
			int c = columns[r];
			if(c == col) 
				return false;
			
			int colDist = Math.abs(c-col);
			int rowDist = row - r;
			
			if(colDist == rowDist)
				return false;
		}
		return true;
	}

}
