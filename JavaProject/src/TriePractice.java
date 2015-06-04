import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class TriePractice {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("water");
		trie.insert("waste");
		trie.insert("wane");
		trie.insert("wrist");
		trie.insert("wise");
		trie.insert("weather");
		trie.insert("wat");
		trie.insert("war");
		trie.insert("wa");
		trie.suggestions("wa");
		trie.removeWord("water");
		System.out.println("after removing water..");
		trie.suggestions("wa");

	}

}

class Trie { 
	
	private class TrieNode { 
		char c; 
		Map<Character, TrieNode> map; 
		boolean isEnd;
		
		public TrieNode(char c) {
			this.c  = c; 
			map = new HashMap<Character, Trie.TrieNode>();
		}
		
		boolean contains(char c) {
			return map.containsKey(c);
		}
	}
	
	private TrieNode root; 
	public Trie() {
		this.root = new TrieNode('\0');
	}
	
	void insert(String word) {
		if(word == null || word.length() == 0)
			return;
		
		char ch[] = word.toCharArray();
		TrieNode curr = root;
		for(char c: ch) {
			if(curr.map.containsKey(c)) {
				curr = curr.map.get(c);
			} else { 
				curr.map.put(c, new TrieNode(c));
				curr = curr.map.get(c);
			}
		}
		curr.isEnd = true;
	}
	
	void removeAllChildren(String prefix) {
		
		if(prefix == null || prefix.length() == 0)
			return;
		
		char ch[] = prefix.toCharArray();
		TrieNode curr = root;
		for(char c: ch) {
				curr = curr.map.get(c);
		}
		
		curr.map.clear();
	}
	
	void removeWord(String word) {
		
		if(word == null || word.length() == 0)
			return;
		
		char ch[] = word.toCharArray();
		TrieNode curr = root;
		for(char c: ch) {
			if(curr.map.containsKey(c)) {
				curr = curr.map.get(c);
			} else { 
				System.out.println("word not found... ");
				return;
			}
		}
		
		if(curr.isEnd) { 
			curr.isEnd = false;
			root = removeWord2(root, word);
		}
		
	}
	
	private TrieNode removeWord2(TrieNode node,String word) {
		
		if(node == null) 
			return null;
		
		char ch[] = word.toCharArray();
		TrieNode child = node.map.get(ch[0]);
		if(child.map.size() == 0 && !child.isEnd) {
			node.map.remove(ch[0]);
			return null;
		}
		TrieNode temp = removeWord2(child, word.substring(1));
		if(temp == null && node.map.size() == 1 && !node.isEnd) {
			return null;
		}
		return node;
		
	}
	
	void suggestions(String prefix) {
		if(prefix == null || prefix.length() == 0) {
			return;
		}
		List<String> suggestions = new ArrayList<String>();
		char ch[] = prefix.toCharArray();
		TrieNode curr = root;
		for(char c: ch) {
			if(curr.map.containsKey(c)) {
				curr = curr.map.get(c);
			} else { 
				System.out.println("prefix not found ... ");
				return;
			}
		}
		
		getSuggestions(curr, prefix, suggestions);
		
		for(int i=0; i<suggestions.size(); i++) {
			System.out.println(suggestions.get(i));
		}
		
	}
	
	void getSuggestions(TrieNode node, String prefix, List<String> suggestions) {
		if(node == null)
			return;
		
		if(node.isEnd) 
			suggestions.add(prefix);
		
		Character[] children = node.map.keySet().toArray(new Character[node.map.keySet().size()]);
		for(char c: children) {
			TrieNode childNode = node.map.get(c);
			getSuggestions(childNode, prefix + Character.toString(c), suggestions);
		}
	}
}
