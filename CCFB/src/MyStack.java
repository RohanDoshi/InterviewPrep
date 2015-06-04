import java.util.Arrays;


public class MyStack {

	private Object[] table;
	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	private int index = -1;
	
	public MyStack(int initialCapacity) {
		this.table = new Object[initialCapacity];
	}
	
	public MyStack() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	public void push(Object o) {
		if(index == table.length)
			grow(index +1);
		
		table[index++] = o;
	}
	
	private void grow(int capacity) {
		Object[] temp = new Object[capacity];
		System.arraycopy(table, 0, temp, 0, table.length);
		this.table = temp;
	}
	
	public Object pop() throws Exception {
		if(index == -1)
			throw new Exception("stack is empty");
		
		Object o = table[index-1];
		table[index-1] = null;
		index--;
		return o;
	}
	
	public Object peek() throws Exception {
		if(index == -1)
			throw new Exception("stack is empty");
		
		return table[index-1];
	}
}
