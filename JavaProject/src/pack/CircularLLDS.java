package pack;

public class CircularLLDS {

	public static void main(String[] args) {
		Circular circular = new Circular();
		
		circular.insert(3);
		circular.remove(5);
		circular.remove(3);
		
		circular.insert(3);
		circular.insert(4);
		circular.insert(5);

	}

}

class Circular {
	
	private class Node { 
		int data; 
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	
	private Node start;
	private Node end; 
	private int count;
	
	public Circular() {
		this.count = 0;
	}
	
	public void print() {
		System.out.println("Printing... ");
		if(start != null) {
			System.out.print(start.data+" ");
			Node temp = start.next; 
			while(temp != null && temp != start) {
				System.out.print(temp.data+" ");
				temp = temp.next;
			}
		}
		System.out.println();
	}
	
	public void insert(int data) {
		Node node = new Node(data);
		if(start == null) {
			start = node;
			end = node;
			start.next = end;
		} else { 
			node.next = start;
			end.next = node; 
			start = node;
		}
		count++;
		print();
	}
	
	public void remove(int data) {
		
		Node node = searchNode(data) ;
		
		if(node != null) {
			if(node == start) {
				if(node == end) {
					start = null;
					end = null;
				} else {
					end.next = start.next;
					start = start.next;
				}
			} else {
				// node can be end node or any other (but start)
				Node prev = start;
				while(prev.next != node) { 
					prev = prev.next;
				}
				prev.next = node.next; 
				if(end == node) {
					end = prev;
				}
			}
			
			count--;
		}
		
		print();
		
	}
	
	public Node searchNode(int data) {
		if(start == null) {
			return null;
		}
		
		if(start.next == end) {
			return (start.data == data ? start : null);
		}
		
		Node temp = start.next; 
		while(temp != start) {
			if(temp.data == data) {
				return temp;
			}
			temp = temp.next;
		}
		
		return null;
	}
}