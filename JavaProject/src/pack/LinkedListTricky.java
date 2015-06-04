package pack;

public class LinkedListTricky {

	static class Node { 
		int data;
		public Node(int data) {
			this.data = data;
		}
		Node next; 
	}
	public static void main(String[] args) {
		
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(5);
		node.next.next.next.next.next = new Node(6);
		node.next.next.next.next.next.next = new Node(7);
		node.next.next.next.next.next.next.next = new Node(8);
		node.next.next.next.next.next.next.next.next = new Node(9);
		node.next.next.next.next.next.next.next.next.next = new Node(10);
		
//		node = keepMremoveNIterative(node, 3	, 2);
//		
//		print(node);
		
		for(int i=0; i< 11; i++) 
			printKNodeFromLast(node, i);
		System.out.println("------------------------------");
		for(int i=0; i< 11; i++) 
			printKNodeFromLastEfficient(node, i);
	}
	
	static void printKNodeFromLast(Node node, int k) {
		if(node == null || k <= 0)
			return;
		
		int len = len(node); 
		if(k > len)
			return ;
		
		Node curr = node; 
		
		int count = 1;
		while(curr != null && count <= len -k) {
			curr = curr.next;
			count++;
		}
		
		System.out.println(curr.data);
	}
	
	
	static void printKNodeFromLastEfficient(Node node, int k) {
		if(node == null || k <= 0)
			return;
		
		Node slow = node;
		Node fast = node;
		
		int diff = 0;
		while(fast != null && diff < k) {
			fast = fast.next;
			diff++;
		}
		
		if(fast == null && diff == k) {
			System.out.println(slow.data);
			return;
		}
		
		if(fast == null && diff != k) {
			System.out.println(" Not possible ");
			return;
		}
		
		
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		System.out.println(slow.data);
		
	}
	
	
	
	static void print(Node node) { 
		while(node != null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
	}
	
	static int len(Node node) {
		if(node == null)
			return 0;
		
		int count = 0;
		while(node != null)
		{
			node = node.next; 
			count++;
		}
		return count;
	}
	
	
	static Node keepMremoveN(Node node, int m, int n, boolean keep) {
		if(node == null)
			return null;
		
		Node temp = node;
		int count = 1;
		if(keep) {
			while(count < m && temp != null) {
				temp = temp.next;
				count++;
			}
			
			if(temp != null) 
				temp.next = keepMremoveN(temp.next, m, n, false);
			
		} else {
			while(count < n && temp != null) {
				temp = temp.next;
				count++;
			}
			
			if(temp != null)
				node = keepMremoveN(temp.next, m, n, true);
			else
				return null;
		}
		
		return node;
	}
	
	
	static Node keepMremoveNIterative(Node node, int m, int n) {
		if(node == null)
			return null;
		
		Node temp = node;
		int count = 0;
		while(temp != null) {
			count = 1;
			while(count <m && temp != null) {
				temp = temp.next;
				count ++;
			}
			// temp is mth node 
			if(temp != null) {
				Node temp2 = temp.next;
				if(temp2 != null) {
					count =1;
					while(count <n && temp2 != null) {
						temp2 = temp2.next;
						count ++;
					}
					
					if(temp2 != null) {
						temp.next = temp2.next;
						temp = temp.next;
					}
					else
						temp.next = null;
					
				}
			}
		}
		
		return node;
	}

}
