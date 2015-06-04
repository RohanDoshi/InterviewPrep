package killit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Trie {

	private TrieNode root = null;
	
	public Trie() {
		root = new TrieNode('\0');
	}
	
	public void addWordRank(String word, int rank) {
		root.add(word, rank);
	}
	
	public List<WordRank> getAllWordsStartingWith(String str) {
		return root.wordsStartingWith(str);
	}
	
	public List<String> getWordsThatMatchPattern(String str) {
		return root.wordsPatternMatching(str);
	}
}


class TrieNode { 
	char ch;
	Map<Character, TrieNode> map;
	boolean isEndOfWord = false;
	int rankIfWord = -1;
	
	public TrieNode(char ch) {
		this.ch = ch;
		this.map = new HashMap<Character, TrieNode>();
	}
	
	public void add(String word, int rank) {
		char arr[] = word.toCharArray();
		TrieNode curr = this;
		for(char ch : arr) {
			if(curr.map.containsKey(ch)) {
				curr = curr.map.get(ch);
			} else {
				TrieNode newNode = new TrieNode(ch);
				curr.map.put(ch, newNode);
				curr = newNode;
			}
		}
		
		curr.isEndOfWord = true;
		curr.rankIfWord = rank;
	}
	
	public List<WordRank> wordsStartingWith(String str) {
		char[] arr = str.toCharArray();
		TrieNode curr = this;
		List<WordRank> list = new ArrayList<>();
		for(char ch: arr) {
			if(curr.map.containsKey(ch)) {
				curr = curr.map.get(ch);
			} else {
				return list;
			}
		}
		if(curr.isEndOfWord)
			list.add(new WordRank(str, curr.rankIfWord));
		
		list.addAll(getAllWords(curr, str));
		return list;
	}
	
	
	public List<String> wordsPatternMatching(String str) {
		List<String> list = new ArrayList<>();
		patternMatch(str.toCharArray(), this, 0, list, "");
		return list;
	}
	
	private void patternMatch(char[] arr, TrieNode curr, int from, List<String> words, String wordFormed) {
		if(from == arr.length) {
			if(curr.isEndOfWord) {
				words.add(new String(wordFormed));
			}
			return;
		}
		
		if(from >= arr.length)
			return;
		
		if(curr.map.containsKey(arr[from])) {
			patternMatch(arr, curr.map.get(arr[from]), from+1, words, wordFormed+arr[from]);
		} else if(arr[from] == '*') {
			Iterator<Character> iterator = curr.map.keySet().iterator();
			while(iterator.hasNext()) {
				char c = iterator.next();
				patternMatch(arr, curr.map.get(c), from+1, words, wordFormed+c);
			}
 		}
		
		
	}
	
	private List<WordRank>  getAllWords(TrieNode node, String str) {
		List<WordRank> list = new ArrayList<>();
		
		if(node == null) {
			return list;
		}
			
		if(node.isEndOfWord) {
			list.add(new WordRank(str, node.rankIfWord));
			return list;
		}
		
		Iterator<Character> iterator = node.map.keySet().iterator();
		while(iterator.hasNext()) {
			char c = iterator.next();
			list.addAll(getAllWords(node.map.get(c), new String(str)+c));
		}
		
		return list;
	}
}



class WordRank {
	String word;
	int rank;
	
	public WordRank(String word, int rank) {
		this.word = word;
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return this.word + "-"+ this.rank;
	}
}