package pack;

import java.util.HashMap;

public class HashMapDS {

	static final int DEF_CAP = 10;
	public static void main(String[] args) {
		MyLinkedHashMap<String, String> map = new MyLinkedHashMap<>();
		//map.put(null,"1");
		//map.put(null, "2");
		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
		map.put("4", "four");
		map.put("2", "five");
		System.out.println(map.get("2"));
		map.printKeys();
		
	}

}


class MyLinkedHashMap<K,V> {
	
	private Entry<K,V>[] table;
	private float loadFactor ;
	private static final int DEF_CAP = 11;
	private static final float DEF_LOAD_FACTOR = 0.75f;
	private Entry startNode = null;
	private Entry lastNode = null;
	private class Entry<K, V> {
		 K key;
		 V value;
		 int hash;
		 Entry<K,V> nextEntry;
		 Entry<K,V> prevEntry;
	}
	
	public MyLinkedHashMap() {
		this(DEF_CAP, DEF_LOAD_FACTOR);
	}

	public MyLinkedHashMap(int cap, float lf) {
		this.table = new Entry[cap];
		this.loadFactor = lf;
	}
	
	public void put(K key, V value) {
		int hashcode = hashcode(key);
		
		Entry entry = new Entry<>();
		entry.hash = hashcode;
		entry.key = key;
		entry.value = value;
		if(startNode ==  null) {
			startNode = entry;
		}
		addEntry(entry);
		
	}
	
	public V get(K key) {
		int hashcode = hashcode(key);
		int entryAt = hashcode % table.length;
		Entry temp = table[entryAt];
		while(temp != null) {
			if(temp.key.equals(key)) {
				return (V) temp.value;
			}
		}
		
		return null;
		
	}
	
	
	private void addEntry(Entry entry) {
		
		int entryAt = entry.hash % table.length;
		Entry nodeAt = table[entryAt];
		if(nodeAt == null) {
			table[entryAt] = entry;
			if(lastNode == null) {
				lastNode = entry; // startNode and lastNode pointing to same node
			} else { 
				lastNode.nextEntry = entry;
				entry.prevEntry = lastNode;
				lastNode = entry;
			}
			
		} else { 
			Entry temp = nodeAt;
			boolean isExists = false;
			while(temp != null) {
				if(temp.key.equals(entry.key)) {
					temp.value = entry.value;
					isExists = true;
					break;
				}
			}
			if(!isExists) {
				entry.nextEntry = nodeAt;
				table[entryAt] = entry;
				lastNode.nextEntry = entry;
				entry.prevEntry = lastNode;
				lastNode = entry;
			}
		}
		
	}
	
	
	public void printKeys() {
		Entry temp = startNode;
		while(temp != null) {
			System.out.print(temp.key+" ");
			temp = temp.nextEntry;
		}
		System.out.println("Reverse");
		temp = lastNode;
		while(temp != null) {
			System.out.print(temp.key +" ");
			temp = temp.prevEntry;
		}
		System.out.println();
	}
	
	private int hashcode(K key) {
		return key == null ? 0 : key.hashCode();
	}
}

class MyHashMap<K,V> {
	
	private Entry<K,V>[] table;
	private float loadFactor ;
	private static final int DEF_CAP = 11;
	private static final float DEF_LOAD_FACTOR = 0.75f;
	private class Entry<K, V> {
		 K key;
		 V value;
		 int hash;
		 Entry<K,V> nextEntry;
	}
	
	public MyHashMap() {
		this(DEF_CAP, DEF_LOAD_FACTOR);
	}

	public MyHashMap(int cap, float lf) {
		this.table = new Entry[cap];
		this.loadFactor = lf;
	}
	
	public void put(K key, V value) {
		int hashcode = hashcode(key);
		
		Entry entry = new Entry<>();
		entry.hash = hashcode;
		entry.key = key;
		entry.value = value;
		
		addEntry(entry);
		
	}
	
	public V get(K key) {
		int hashcode = hashcode(key);
		int entryAt = hashcode % table.length;
		Entry temp = table[entryAt];
		while(temp != null) {
			if(temp.key.equals(key)) {
				return (V) temp.value;
			}
		}
		
		return null;
		
	}
	
	
	private void addEntry(Entry entry) {
		int entryAt = entry.hash % table.length;
		Entry nodeAt = table[entryAt];
		if(nodeAt == null) {
			table[entryAt] = entry;
		} else { 
			Entry temp = nodeAt;
			boolean isExists = false;
			while(temp != null) {
				if(temp.key.equals(entry.key)) {
					temp.value = entry.value;
					isExists = true;
					break;
				}
			}
			if(!isExists) {
				entry.nextEntry = nodeAt;
				table[entryAt] = entry;
			}
		}
	}
	
	private int hashcode(K key) {
		return key == null ? 0 : key.hashCode();
	}
}