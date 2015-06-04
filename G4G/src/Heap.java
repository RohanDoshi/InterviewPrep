import java.util.Arrays;
import java.util.Comparator;


public class Heap<E> {
	
	private Object[] queue;
	private int numOfElements;
	private Comparator<E> comparator;
	private int initialCapacity; 
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE >> 2;
	private static final int DEFAULT_INITIAL_SIZE = 11;
	
	public Heap(int initialCapacity, Comparator<E> comparator) {
		this.initialCapacity = initialCapacity;
		this.comparator = comparator;
		this.queue = new Object[initialCapacity];
	}
	
	public Heap() {
		this(DEFAULT_INITIAL_SIZE, null);
	}
	
	public void add(E element) {
		if(numOfElements == queue.length) {
			grow(numOfElements + 1); 
		}
		
		queue[numOfElements++] = element;
		heapify(numOfElements-1);
	}
	
	public E poll() {
		if(numOfElements == 0)
			return null;
		
		E element = (E) queue[0];
		queue[0] = null;
		numOfElements --;
		if(numOfElements == 0)
			return element;
		
		E x = (E) queue[numOfElements];
		queue[0] = x;
		heapifyDown(0);
		return element;
	}
	
	public void heapifyDown(int index) {
		int half = numOfElements >>> 1;
		while(index < half) {
			int leftIndex = (index << 1) + 1; 
			int rightIndex = leftIndex + 1;
			int heapCompare = index;
			if(leftIndex < numOfElements) {
				index = heapCompare(index, leftIndex);
			}
			
			if(rightIndex < numOfElements) {
				index = heapCompare(index, rightIndex);
			}
			
			if(index == heapCompare)
				break;
			else { 
				swap(index, heapCompare);
				index = heapCompare;
			}
		}
 	}
	
	public void heapify(int index) {
		if(numOfElements == 1)
			return;
		
		while(index > 0) {
			int parent = (index -1) >>> 1;
			int indexFromCompare = heapCompare(parent, index);
			if(indexFromCompare == parent)
				break;
			else { 
				swap(parent, index);
				index = parent;
			}
		}
		
	}
	
	private void swap(int index1, int index2) {
		Object temp = queue[index1];
		queue[index1] = queue[index2];
		queue[index2] = temp;
	}
	
	
	private int heapCompare(int parentIndex, int child) {
		if(comparator != null) {
			E parent = (E) queue[parentIndex];
			E left = (E) queue[child];
			if(comparator.compare(parent, left) > 0) {
				return child;
			}
		} else {
			Comparable<? super E> parent = (Comparable<? super E>) queue[parentIndex];
			E left = (E) queue[child];
			if(parent.compareTo(left) > 0) {
				return child;
			}
			
		}
		
		return parentIndex;
	}
	
	private void grow(int minCapacity) {
		int oldCapacity = this.numOfElements;
		int newCapacity = oldCapacity + (oldCapacity < 64 ? oldCapacity : oldCapacity >> 1);
		if(newCapacity - MAX_ARRAY_SIZE > 0) {
			newCapacity = Integer.MAX_VALUE;
		}
		queue = Arrays.copyOf(queue, newCapacity);
	}
	
	public void print() {
		for(int i=0; i<numOfElements; i++) {
			System.out.print(queue[i]+" ");
		}
	}
	
}
