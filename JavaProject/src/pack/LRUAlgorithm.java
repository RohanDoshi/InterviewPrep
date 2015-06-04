package pack;

import java.util.HashMap;
import java.util.Map;

public class LRUAlgorithm {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(5);
		cache.insert("1", "one");
		cache.print();
		cache.insert("2", "two");
		cache.print();
		cache.insert("3", "three");
		cache.print();
		cache.insert("4", "four");
		cache.print();
		cache.insert("5", "five");
		cache.print();
		cache.insert("6", "six");
		cache.print();
		cache.insert("4", "six");
		cache.print();
	}

}

class LRUCache {
	
		private class Node {
			Node prev;
			Node next;
			String data; 
			public Node(String data) {
				this.data = data;
			}
		}
	
		private Map<String, Node> map = null;
		private Node start = null;
		private Node end = null;
		private int capacity; 
		private int elementCount;
		
		public LRUCache(int capacity) {
			this.capacity = capacity;
			this.map = new HashMap<String, Node>();
		}
		
		public void insert(String key, String value) {
			// key not present 
			if(!map.containsKey(key)) {
				Node node = new Node(value);
				map.put(key, node);
				if(capacity == elementCount) {
					// remove the end node
					remove(end);
				}
				setHead(node);
				elementCount++;
			} else { 
				// key is already present 
				Node val = map.get(key);
				remove(val);
				setHead(val);
			}
			
			
		}
		
		public void setHead(Node node) {
			if(start == null) {
				start = node;
				end = node;
			} else { 
				node.next = start;
				start.prev = node;
				start = node;
			}
		}
		
		
		
		public void remove(Node node) {
			Node prev = node.prev; 
			Node next = node.next;
			
			// case when node to be removed is a head
			if(prev == null) {
				start = next;
			} else { 
				prev.next = next;
			}
			
			// case when node to be removed is a end node
			if(next == null) {
				end = prev;
			} else { 
				next.prev = prev;
			}
			node.prev = null;
			node.next = null;
			elementCount--;
		}
		
		public void print() { 
			Node temp = start; 
			while(temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
			System.out.println();
		}
		
}
