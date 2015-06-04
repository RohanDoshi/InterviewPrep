package pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackDS {
	public static void main(String args[]) {
		Stack<Integer> st = new Stack<>();
		List<Stack<Integer>> list = new ArrayList<>();
		
		StackInConstantTime myStack = new StackInConstantTime();
		int arr[] = {9, 3, 22, 13, 4 , 5 , -2, 11, 4};
		for(int i=0; i<20; i++) {
			myStack.push(i);
		}
		myStack.print();
		
		for(int i=0; i<20; i++) {
			System.out.print(myStack.pop()+" ");
		}
		System.out.println();
		
		System.out.println(recursivePower(2, 4));
		
		System.out.println(numOfBinTrees(4));
	}
	
	static double recursivePower(double x, int k) {
	    if (k < 0) {
	        return recursivePower(x, ++k) / x;
	    } else if (k == 0) {
	        return 1;
	    } else {
	        return recursivePower(x, --k) * x;
	    }
	}
	
	
	static int numOfBinTrees(int n) {
		if(n <= 0)
			return 0;
		
		if(n == 1)
			return 1;
		
		int count = 0;
		for(int i=1; i<=n ;i++) {
			count = count + numOfBinTrees(i-1) * numOfBinTrees(n-i);
		}
		return count;
	}
}

class ImplmentArrThreeStacks { 
	int size = 300;
	int numOfStacks = 3;
	int[] arr = new int[size * numOfStacks];
	int[] stackPtr = {0,0,0};
	
	void push(int stackNum, int val) {
		int index = stackNum * size + stackPtr[stackNum];
		arr[index] = val;
		stackPtr[stackNum]++;
	}
	
}

class StackInConstantTime {
	
	private MyStack<Integer> stack = null;
	private MyStack<Integer> minStack = null;
	private MyStack<Integer> maxStack = null;
	
	public StackInConstantTime() {
		stack = new MyStack<Integer>();
		minStack = new MyStack<Integer>();
		maxStack = new MyStack<Integer>();
	}
	
	public void push(Integer e) {
		if(stack.size() == 0) {
			stack.push(e);
			minStack.push(e);
			maxStack.push(e);
		} else { 
			stack.push(e);
			Integer temp = (Integer) minStack.peek();
			if(e.intValue() < temp.intValue()) {
				minStack.push(e);
			} else {
				minStack.push(temp);
			}
			temp = (Integer) maxStack.peek();
			if(e > temp) {
				maxStack.push(e);
			} else {
				maxStack.push(temp);
			}
		}
	}
	
	public Integer pop() {
		minStack.pop();
		maxStack.pop();
		return (Integer) stack.pop();
	}
	
	public void print() {
		stack.print();
		minStack.print();
		maxStack.print();
	}
}

class MyStack<K> { 
	
	private Object[] objects = null;
	private int capacityIncrement = 0;
	private int elementCount = 0;
	private int MAX_LEN = Integer.MAX_VALUE >> 8;
	
	public MyStack() {
		this(10,0);
	}
	
	public MyStack(int capacity, int capacityIncrement) {
		objects = new Object[capacity];
		this.capacityIncrement = capacityIncrement;
	}
	
	public Object pop() {
		if(elementCount == 0) {
			throw new RuntimeException();
		}
		Object obj = objects[elementCount-1];
		objects[elementCount-1] = null;
		elementCount--;
		return obj;
	}
 	
	public void push(Object object) {
		if(elementCount >= objects.length) {
			grow(elementCount + 1);
		}
		
		objects[elementCount++] = object;
	}
	
	private void grow(int minCapacity) {
		int oldCapacity = objects.length;
		int newCapacity = oldCapacity + ((capacityIncrement == 0) ?  oldCapacity : capacityIncrement);
		if(newCapacity - minCapacity <0 ) {
			newCapacity = minCapacity;
		}
		if(newCapacity - MAX_LEN > 0) {
			newCapacity = hugeCapacity(newCapacity);
		}
		
		objects = Arrays.copyOf(objects, newCapacity);
	}
	
	private int hugeCapacity(int minCapacity) {
		if(minCapacity < 0) {
			throw new OutOfMemoryError();
		}
		return (minCapacity > MAX_LEN) ? Integer.MAX_VALUE : MAX_LEN;
		
	}
	
	public Object peek() {
		if(elementCount == 0) {
			return null;
		}
		return objects[elementCount-1];
	}
	
	public void print() {
		System.out.println(Arrays.toString(objects));
	}
	
	public int size() {
		return elementCount;
	}
	
}
