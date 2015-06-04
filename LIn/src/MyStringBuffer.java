import java.util.Arrays;



public class MyStringBuffer {

	 private char[] buffer;
	 private int count = 0;
	 transient char[] stringCache;
	 
	 public MyStringBuffer(int size) {
		buffer = new char[size];
	 }
	 
	 public MyStringBuffer() {
		this(16);
	 }
	 
	 public synchronized void append(char c) {
		 if(count == buffer.length)
			 grow(count+1);
		 buffer[count++] = c;
	 }
	 
//	 private int[] sizeTable = {9,99,999,9999,99999,999999,9999999,99999999,999999999, Integer.MAX_VALUE};
//	 private int size(int num) {
//		 for(int i=0; i<sizeTable.length; i++) {
//			 if(num <= sizeTable[i])
//				 return i+1;
//		 }
//		 return -1;
//	 }
	 
	 public synchronized void append(int i) {
		 append(Integer.toString(i));
	 }
	 
	 public synchronized void append(String s) {
		 for(int i=0; i<s.length(); i++) {
			 append(s.charAt(i));
		 }
	 }
	 
	 private void grow(int minCapacity) {
		 int oldCapacity = buffer.length;
		 int newCapacity = oldCapacity*2 + 2;
		 if(newCapacity - minCapacity < 0)
			 newCapacity = minCapacity;
		 if(newCapacity < 0) {
			 if(minCapacity < 0)
				 throw new OutOfMemoryError();
			 newCapacity = Integer.MAX_VALUE;
		 }
		 buffer = Arrays.copyOf(buffer, newCapacity);
	 }
	 
	 public String toString() {
		 return new String(buffer);
	 }
	 
}
