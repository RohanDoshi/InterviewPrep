import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


public class Scrabble {
	static Trie trie = new Trie();
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("web2")));
		String str = null;
		while((str = br.readLine()) != null) {
			trie.insert(str.toUpperCase());
		}
		br.close();
		ConstructBoard board = new ConstructBoard(8);
		board.fillItUpRandomly();
		board.print();
		board.findWords(trie);
	}
}

class ConstructBoard {
	
	char[][] board;
	int size;
	public ConstructBoard(int size) {
		this.size = size;
		this.board = new char[size][size];
	}
	
	public void fillItUpRandomly() {
		Random r = new Random();
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				board[i][j] = (char)((int)'A' + r.nextInt(26));
			}
		}
	}
	
	public void print() {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void findWords(Trie dictionary) {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				findWords1(i, j, Character.toString(board[i][j]), dictionary, new boolean[size][size]);
			}
		}
	}
	
	private void findWords1(int row, int col, String word, Trie dictionary, boolean pathTravelled[][]) {
		
		if(word.length() > 1 && dictionary.isWord(word))
			System.out.println(word);
		
		pathTravelled[row][col] = true;
		
		if(dictionary.suggestions(word).size() > 0) {
		// moveUp
			if(row > 0 && !pathTravelled[row-1][col])
				findWords1(row-1, col, word + Character.toString(board[row-1][col]) , dictionary, pathTravelled);
			
		// moveDown
			if(row + 1 < size && !pathTravelled[row+1][col])
				findWords1(row + 1, col, word + Character.toString(board[row+1][col]), dictionary, pathTravelled);
		
		// moveLeft
			if(col > 0 && !pathTravelled[row][col-1]) 
				findWords1(row , col - 1, word + Character.toString(board[row][col-1]), dictionary, pathTravelled);
		
		// moveRight
			if(col + 1 < size && !pathTravelled[row][col+1])
				findWords1(row , col + 1, word + Character.toString(board[row][col +1]), dictionary, pathTravelled);
		}
		
	}
	
	
}