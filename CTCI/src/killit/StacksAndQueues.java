package killit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class StacksAndQueues {

	public static void main(String[] args) {
		StacksAndQueues sq = new StacksAndQueues();
		
		ArrayAs3Stacks arrayAs3Stacks = new ArrayAs3Stacks(9);
		for(int i=0; i<2; i++) {
			arrayAs3Stacks.push(1, i+1);
			arrayAs3Stacks.push(2, i+1);
			arrayAs3Stacks.push(3, i+1);
		}
		arrayAs3Stacks.printArr();
		QueueAs2Stacks queueAs2Stacks = new QueueAs2Stacks();
		for(int i=0; i<20; i++) {
			queueAs2Stacks.add(i);
		}
		for(int i=0; i<10; i++) {
			System.out.println(queueAs2Stacks.poll());
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.push(2);
		stack.push(1);
		stack.push(8);
		stack.push(7);
		
		sq.sortStack(stack, new Stack<Integer>());
		SetOfStacks setOfStacks = new SetOfStacks(3);
		for(int i=1; i<=16; i++) {
			setOfStacks.push(i);
		}
		for(int i=0; i<20; i++) {
			System.out.println(setOfStacks.popAt(i%3));
		}
		
	}
	
	public void sortStack(Stack<Integer> stack1, Stack<Integer> stack2) {
		while(!stack1.isEmpty()) {
			int num = stack1.pop();
			if(stack2.isEmpty()) {
				stack2.push(num);
			} else {
				if(stack2.peek() <= num) {
					stack2.push(num);
				} else {
					while(!stack2.isEmpty()) {
						int top2 = stack2.pop();
						if(top2 > num) {
							stack1.push(top2);
						} else {
							stack2.push(top2);
							break;
						}
					}
					stack2.push(num);
				}
			}
		}
		System.out.println(Arrays.toString(stack2.toArray()));
		System.out.println(stack2.pop());
	}

}

class ArrayAs3Stacks {
	
	int arr[];
	int size;
	int top1=-1, top2=-1, top3=-1;
	int start1, start2, start3;
	int maxSizeStack;
	Map<Integer, Integer> map ;
	
	public ArrayAs3Stacks(int size) {
		this.size = size;
		this.arr = new int[size];
		this.maxSizeStack = size/3;
		this.start1 = 0;
		this.start2 = maxSizeStack;
		this.start3 = maxSizeStack*2;
		this.map = new HashMap<Integer, Integer>();
		map.put(start1, top1);
		map.put(start2, top2);
		map.put(start3, top3);
	}
	
	public void push(int stack, int num) {
		if(stack <= 0 || stack > 3)
			return;
		
		pushStack(stack -1, num);
	}
	
	private void pushStack(int stackIndex, int num) {
		int top = -1;
		if(map.containsKey(stackIndex))
			top = map.get(stackIndex);
		else
			top = stackIndex*maxSizeStack-1;
		
		if(!isStackFull(stackIndex, top+1)) {
			arr[++top] = num;
			map.put(stackIndex, top);
		} else {
			System.out.println("Stack Full");
		}
		
	}
	
	private boolean isStackFull(int stackIndex, int top) {
		int start = stackIndex * maxSizeStack;
		if(top >= start && top < start + maxSizeStack)
			return false;
		else
			return true;
	}
	
	public void printArr() {
		System.out.println(Arrays.toString(arr));
	}
	
}


class QueueAs2Stacks {
	
	Stack<Integer> stack1 ;
	Stack<Integer> stack2 ;
	public QueueAs2Stacks() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}
	
	public void add(int item) {
		stack1.push(item);
	}
	
	public boolean isEmpty() {
		return stack1.size() == 0 && stack2.size() == 0;
	}
	
	public Integer poll() {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		
		if(!stack2.isEmpty()) {
			return stack2.pop();
		}
		
		return null;
	}
}


class SetOfStacks {
	
	List<Stack<Integer>> list; 
	int currStackIndex=-1;
	int maxCapacity=-1;
	
	public SetOfStacks(int maxCapacity) {
		list = new ArrayList<>();
		this.maxCapacity = maxCapacity;
	}
	
	public void push(int item) {
		if(list.size() == 0 || list.get(list.size()-1).size() == maxCapacity) {
			Stack<Integer> stack = new Stack<>();
			list.add(stack);
			currStackIndex++;
		}
		
		list.get(currStackIndex).add(item);
	}
	
	public int pop() {
		
		int ret = -1;
		int tempStackIndex = currStackIndex;
		if(tempStackIndex >= 0) {
			if(list.get(tempStackIndex).size() == 1) {
				ret = list.get(tempStackIndex).pop();
				list.remove(tempStackIndex);
				currStackIndex--;
				return ret;
			} else {
				return list.get(tempStackIndex).pop();
			}
		}
		
		return -1;
	}
	
	public int popAt(int index) {
		if(index < 0 || index >= currStackIndex)
			return -1;
		
		if(list.get(currStackIndex).size() == 0)
			return -1;
		else if(list.get(currStackIndex).size() == 1) {
			int ret =list.get(currStackIndex).pop();
			list.remove(currStackIndex);
			currStackIndex--;
			return ret;
		} else
			return list.get(currStackIndex).pop();
	}
	
	
}
