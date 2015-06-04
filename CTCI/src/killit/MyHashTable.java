package killit;

public class MyHashTable<K, V> {
	private class Entry<K,V> {
		final K key;
		V value;
		int hash;
		Entry<K,V> next;
		public Entry(K key, V value, int hash, Entry<K,V> next) {
			this.key = key;
			this.value = value;
			this.hash = hash;
			this.next = next;
		}
	}
	
	private Entry[] table;
	private int initialCapacity;
	private float loadFactor;
	private int numOfElements;
	private int threshold;
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE -8;
	public MyHashTable() {
		this(11, 0.75f);
	}
	
	public MyHashTable(int initialCapacity, float loadFactor) {
		this.initialCapacity = initialCapacity;
		this.loadFactor = loadFactor;
		this.table = new Entry[initialCapacity];
		this.threshold = (int)Math.min(this.initialCapacity*loadFactor, MAX_ARRAY_SIZE+1);
	}
	
	public V put(K key, V value) {
		if(key == null || value == null)
			throw new NullPointerException();
		
		int hash = key.hashCode();
		int position = hash % table.length;
		Entry<K,V> entry = table[position];
		for(Entry<K,V> e = entry; e != null; e = e.next) {
			if(e.key.equals(key) && e.hash == hash) {
				V old = e.value;
				e.value = value;
				return old;
			}
		}
		
		if(numOfElements > threshold) {
			rehash();
			position = hash % table.length;
		}
		
		
		Entry<K,V> e = table[position];
		Entry<K,V> newEntry = new Entry<K,V>(key, value, hash, e);
		table[position] = newEntry;
		numOfElements++;
		return value;
	}
	
	public V get(K key) {
		
		if(key == null)
			throw new NullPointerException();
		Entry<K,V> tab[] = table;
		int hash = key.hashCode();
		int position = hash % table.length;
		Entry<K,V> entry = tab[position];
		for(Entry<K,V> e = entry; e != null; e = e.next) {
			if(e.key.equals(key) && e.hash == hash) {
				return e.value;
			}
		}
		
		return null;
	}
	
	private void rehash() {
		
	}
	
	
	public V remove(K key) {
		
		if(key == null)
			throw new NullPointerException();
		
		Entry<K,V> tab[] = table;
		int hash = key.hashCode();
		int position = hash % table.length;
		Entry<K,V> entry = tab[position];
		for(Entry<K,V> e = entry, prev = null; e != null; prev= e, e = e.next) {
			if(e.key.equals(key) && e.hash == hash) {
				if(prev == null) {
					tab[position] = e.next; 
				} else {
					prev.next = e.next;
				}
				numOfElements--;
				V oldVal = e.value;
				e.value = null;
				return oldVal;
			}
		}
		
		return null;
	}
}
