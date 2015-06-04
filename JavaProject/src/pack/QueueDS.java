package pack;

import java.util.Arrays;

public class QueueDS {

	public static void main(String args[]) {
		QueueLinkedList<Integer> queue = new QueueLinkedList<Integer>();
		for(int i=0; i<20; i++) {
			queue.add(i);
			if(i%3 ==0)
			queue.poll();
		}
		queue.print();
		for(int i=0; i<20; i++) {
			queue.poll();
		}
		
		System.out.println();
	}
}

class QueueLinkedList<T> {
	
	private class Node { 
		T data;
		Node next;
		Node previous;
	}
	
	private Node front = null;
	private Node rear = null;
	
	public void add(T data) {
		Node node = new Node();
		node.data = data;
		if(front == null) {
			front = node;
			rear = node;
		} else { 
			rear.next = node;
			rear = node;
		}
	}
	
	public Node poll() {
		if(front == null) {
			return front;
		}
		
		Node temp = front;
		front = front.next; 
		return temp;
	}
	
	public void print() {
		Node temp = front;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
}

class MyQueue<T> {
	
	private Object[] objects = null;
	private int capacityIncrement = 0;
	private int MAX_ARR_SIZE = Integer.MAX_VALUE - 8;
	int front = 0, rear = 0;
	
	
	public MyQueue(int initialCapacity, int capacityIncrement) {
		this.objects = new Object[initialCapacity];
		this.capacityIncrement = capacityIncrement;
	}
	
	public MyQueue(int initialCapacity) {
		this(initialCapacity, 0);
	}
	
	public MyQueue() {
		this(10);
	}
	
	public void printQueue() {
		System.out.println(Arrays.toString(objects));
	}
	
	public void add(Object o) {
		if(rear < objects.length ) {
			if(rear + 1 == front) {
				doubleQueue();
				objects[rear++] = o;
			} else {
				objects[rear++] = o;
			}
		} else { 
			if(front == 0) {
				grow(objects.length + 1);
				objects[rear++] = o;
			} else { 
				rear = rear % objects.length;
				objects[rear++] = o;
			}
		}
 	}
	// 0 1 2 3 
	// f = 2, r = 1
	// 
	public void doubleQueue() {
		Object[] newArr = new Object[objects.length * 2];
		for(int i=front ; i<objects.length; i++) {
			newArr[i-front] = objects[0];
		}
		int j = objects.length - front;
		for(int i=0; i<=rear; i++) {
			newArr[j++] = objects[i];
		}
		front = 0;
		rear = j-1;
	}
	
	private void grow(int minCapacity) {
		int currCapacity = objects.length;
		int newCapacity = currCapacity + (capacityIncrement > 0 ? capacityIncrement : currCapacity);
		if(newCapacity - minCapacity < 0) {
			newCapacity = minCapacity;
		}
		if(newCapacity - MAX_ARR_SIZE > 0) {
			newCapacity = huge(newCapacity);
		}
		
		objects = Arrays.copyOfRange(objects, 0, newCapacity);
	}
	
	private int huge(int minCapacity) {
		if(minCapacity < 0) {
			throw new OutOfMemoryError();
		}
		return (minCapacity > MAX_ARR_SIZE) ? Integer.MAX_VALUE : MAX_ARR_SIZE;
	}
	
	public Object poll() { 
		if(front >= objects.length) {
			front = front % objects.length;
		}
		if(objects[front] == null) {
			return null;
		}
		Object o = objects[front];
		objects[front] = null;
		front++;
		return o;
	}
//	
//	public Object peek() {
//		
//	}
	
	
}