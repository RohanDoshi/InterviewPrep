package killit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class WordRanking {

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(new File("4000MostCommonWords")));
		String str = null;
		Trie trie = new Trie();
		int count = 1;
		while((str = br.readLine()) != null) {
			trie.addWordRank(str, count++);
		}
		br.close();
		br = new BufferedReader(new InputStreamReader(System.in));
		KeyPadT9 keyPadT9 = new KeyPadT9(trie);
		System.out.println("Enter keys in your numeric keypad");
		String key = br.readLine();
		
		System.out.println(Arrays.toString(keyPadT9.findImportantWordsForKey(key).toArray()));
		System.out.println(Arrays.toString(trie.getWordsThatMatchPattern("***er").toArray()));
	}
	
}


class KeyPadT9 {
	
	Trie rankedWords = null;
	Map<Integer, List<Character>> map = null;
	PriorityQueue<WordRank> queue = null;
	Comparator<WordRank> comparator = null;
	public KeyPadT9(Trie trie) {
		this.rankedWords = trie;
		this.map = new HashMap<Integer, List<Character>>();
		initializeMap();
		setComparator();
	}
	
	private void setComparator() {
		comparator = new Comparator<WordRank>() {
			
			@Override
			public int compare(WordRank o1, WordRank o2) {
				if(o1.rank > o2.rank)
					return 1;
				else if(o1.rank < o2.rank) 
					return -1;
				else 
					return 0;
			}
		};
	}
	
	private void initializeMap() {
		char c = 'a';
		int count = 0;
		for(int i=2; i<=9; i++) {
			map.put(i, new ArrayList<Character>());
			count = 0;
			while(count < 3 && c <= 'z') {
				map.get(i).add(c++);
				count++;
			}
		}
	}
	
	public List<WordRank> findImportantWordsForKey(String key) {
		
		queue = new PriorityQueue<>(10, comparator);
		findImportantWordsForKey(key, "");
		List<WordRank> list = new ArrayList<>();
		while(!queue.isEmpty()) {
			list.add(queue.poll());
		}
		return list;
	}
	
	private void findImportantWordsForKey(String key, String word) {
		 
		if(key.isEmpty()) {
			queue.addAll(rankedWords.getAllWordsStartingWith(word));
			return;
		}
		
		int keyNum = Integer.parseInt(key.substring(0, 1));
		List<Character> chars = map.get(keyNum);
		for(char c : chars) {
			findImportantWordsForKey(new String(key.substring(1)), new String(word+c));
		}
		
	}
	
	
}
