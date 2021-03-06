import java.util.HashMap;
import java.util.Map;


public class Trie {
	
	public static void main(String args[]) {
		Trie trie = new Trie('\0');
		trie.add("are");
		trie.add("area");
		trie.add("base");
		trie.add("cat");
		trie.add("cater");
		trie.add("children");
		trie.add("basement");
		System.out.println(trie.longestPrefixMatch("caterer"));
		System.out.println(trie.longestPrefixMatch("basemexy"));
		System.out.println(trie.longestPrefixMatch("child"));
		
	}

	private class TrieNode<Character> {
		Character value;
		boolean isEnd;
		Map<Character, TrieNode<Character>> childrenMap;
		
		public TrieNode(Character value) {
			this.value = value;
			this.childrenMap = new HashMap<Character, TrieNode<Character>>();
		}
	}
	
	
	private TrieNode<Character> root;
	
	public Trie(Character value) {
		this.root = new TrieNode<Character>('\0');
	}
	
	public void add(String value) {
		if(value == null || value.isEmpty())
			return;
		
		TrieNode<Character> curr = root;
		char[] arr = value.toCharArray();
		for(char ch : arr) {
			if(curr.childrenMap.containsKey(ch)) {
				curr = curr.childrenMap.get(ch);
			} else {
				TrieNode<Character> node = new TrieNode<Character>(ch);
				curr.childrenMap.put(ch, node);
				curr = node;
			}
		}
		
		curr.isEnd = true;
	}
	
	
	public void insert(String value) {
		if(value == null || value.isEmpty())
			return;
		
		TrieNode<Character> curr = root;
		char[] arr = value.toCharArray();
		insert(curr, arr, 0);
		
	}
	
	private void insert(TrieNode<Character> curr, char[] arr, int index) {
		if(index >= arr.length)
			return;
		
		if(curr.childrenMap.containsKey(arr[index])) {
			insert(curr.childrenMap.get(arr[index]), arr, index+1);
		} else {
			TrieNode<Character> node = new TrieNode<Character>(arr[index]);
			curr.childrenMap.put(arr[index], node);
			insert(node, arr, index+1);
		}
	}
	
	public void print() {
		print(root, String.valueOf(root.value));
	}
	
	public void print(TrieNode<Character> node, String s) {
		if(node == null)
			return;
		
		if(node.isEnd)
			System.out.println(s);
		
		Character[] keys = node.childrenMap.keySet().toArray(new Character[node.childrenMap.size()]);
		for(char key : keys) {
			print(node.childrenMap.get(key), s + key);
		}
	}
	
	public String longestPrefixMatch(String s) {
		if(s == null || s.isEmpty())
			return s;
		
		TrieNode<Character> curr = root;
		char c[] = s.toCharArray();
		String longestPrefix = "";
		for(int i=0; i<c.length; i++) {
			if(curr.childrenMap.containsKey(c[i])) {
				curr = curr.childrenMap.get(c[i]);
				if(curr.isEnd) 
					longestPrefix = new String(c,0,i+1);
			} else {
				break;
			}
		}
		return longestPrefix;
	}
}
