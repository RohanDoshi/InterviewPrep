package careerCup;

public class ProducerConsumerProblem {

}

class Buffer {
	private char[] buff;
	private int numOfElements;
	public Buffer(int size) {
		buff = new char[size];
	}
	
	public synchronized void put(char c) throws InterruptedException {
		while(numOfElements == buff.length)
			wait();
		buff[numOfElements++] = c;
		notify();
	}
	
	public synchronized char get() throws InterruptedException {
		while(numOfElements == 0)
			wait();
	
		char c = buff[--numOfElements];
		notify();
		return c;
	}
}