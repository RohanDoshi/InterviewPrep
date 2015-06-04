package killit;

public class MyLinkedList<E> {
	private class Node<E> {
		Node<E> prev;
		Node<E> next;
		E value;
		public Node(Node<E> prev, E value, Node<E> next) {
			this.prev = prev;
			this.value = value;
			this.next = next;
		}
	}
	
	private Node<E> first;
	private Node<E> last;
	private int numOfElements;
	
	public void add(E item) {
		Node<E> l = last;
		last = new Node<E>(null, item, null);
		if(l == null) {
			first = last;
		} else {
			l.next = last;
			last.prev = l;
		}
		numOfElements++;
	}
	// 0 1 2 3 4
	public E get(int index) {
		checkIndex(index);
		Node<E> temp = null;
		if(index <= (numOfElements >> 2)) 
		{
			temp = first;
			for(int i = 0; i<index; i++)
				temp = temp.next;
		} else {
			temp = last;
			for(int i=numOfElements-1; i>index; i--) 
				temp = temp.prev;
		}
		return temp.value;
	}
	
	public E remove(int index) {
		checkIndex(index);
		Node<E> temp = null;
		if(index < (numOfElements >> 2)) {
			temp = first;
			for(int i=0; i<index; i++)
				temp = temp.next;
		} else { 
			temp = last;
			for(int i=numOfElements-1; i>index; i--)
				temp = temp.prev;
		}
		
		Node<E> prev = temp.prev;
		Node<E> next = temp.next;
		if(prev == null) {
			first = next;
			first.prev = null;
		} else if (next == null) {
			last = prev;
			last.next = null;
		} else {
			prev.next = next;
		}
		numOfElements--;
		return temp.value;
		
	}
	
	private void checkIndex(int index) {
		if(!(index >= 0 && index < numOfElements))
			throw new IndexOutOfBoundsException();
		
	}
}
