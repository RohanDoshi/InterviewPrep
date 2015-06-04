package killit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OnlineAlgorithms {
//(4,3,5,1,6,2,4,3,3,8,9,1)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		IntegerStream is = new IntegerStream();
		while((s=br.readLine()) != null && !s.equalsIgnoreCase("NO")) {
			is.add(Integer.parseInt(s));
		}
		br.close();
		is.printKMostFrequent(3);
		System.out.println();
	}

}

class IntegerStream {
	private Map<Integer, Integer> map;
	private IntegerCount[] elements ;
	private int capacity;
	private int numOfElements; 
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE >> 16;
	
	public IntegerStream() {
		this(10);
	}
	
	public IntegerStream(int capacity) {
		if(capacity <= 0)
			capacity = 10;
		this.capacity = capacity;
		this.elements = new IntegerCount[capacity];
		this.map = new HashMap<Integer, Integer>();
	}
	
	public void add(int value) {
		if(map.containsKey(value)) {
			int elementIndex = map.get(value);
			elements[elementIndex].count++;
			if(elementIndex >1) {
				if(elements[elementIndex-1].count < elements[elementIndex].count) {
					map.put(elements[elementIndex-1].i, elementIndex);
					map.put(elements[elementIndex].i, elementIndex-1);
					swap(elementIndex, elementIndex-1);
					elementIndex = elementIndex-1;
				}
			}
			maxHeapify(elementIndex);
		} else
			add(new IntegerCount(value));
	}
	
	private void add(IntegerCount integerCount) {
		if(numOfElements >= elements.length) {
			grow(this.capacity);
		}
		elements[numOfElements++] = integerCount;
		map.put(integerCount.i, numOfElements-1);
		maxHeapify(numOfElements-1);
	}
	
	private void grow(int minCapacity) {
		int oldCapacity = elements.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1) ; // don't want to increase it by just one or two.. copying is an expensive affair
		
		if(newCapacity - minCapacity < 0) 
			newCapacity = minCapacity;
		
		if(newCapacity > MAX_ARRAY_SIZE) 
			newCapacity = hugeCapacity(minCapacity);
		
		elements = Arrays.copyOf(elements, newCapacity);
		this.capacity = newCapacity;
	}
	
	private int hugeCapacity(int minCapacity) {
		if(minCapacity < 0) 
			throw new OutOfMemoryError();
		
		if(minCapacity > MAX_ARRAY_SIZE)
			return Integer.MAX_VALUE;
		else
			return MAX_ARRAY_SIZE;
	}
	
	private void maxHeapify(int index) {
		if(index == 0) {
			return;
		}
		
		int parent = parentIndex(index);
		if(elements[parent].count < elements[index].count) {
			swap(parent, index);
			map.put(elements[parent].i, index);
			map.put(elements[index].i, parent);
			maxHeapify(parent);
		} 
	}
	
	private void swap(int index1, int index2) {
		IntegerCount temp = elements[index1];
		elements[index1] = elements[index2];
		elements[index2] = temp;
	}
	
	private int parentIndex(int index) {
		return (index - 1)/2;
	}
	
	private int leftIndex(int index) {
		return 2*index + 1;
	}
	
	private int rightIndex(int index) { 
		return 2*index + 2;
	}
	
	public void printKMostFrequent(int k) {
		if(k > numOfElements) {
			System.out.println("K should be less than numOfElements");
			return;
		}
		
		for(int i=0; i<k; i++) {
			System.out.print(elements[i].i+" ");
		}
	}
}

class IntegerCount { 
	int i;
	int count;
	public IntegerCount(int i) {
		this.i = i;
		this.count = 1;
	}
	
	public void incrementCountBy(int count) {
		this.count += count;
	}
	
	public void incrementCount() {
		this.count += 1;
	}
}