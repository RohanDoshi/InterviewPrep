package pack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedListDS {

	public static void main(String[] args) {
		
		
		
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		
		
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(4);
		l2.add(5);
		
		
		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(6);
		l3.add(7);
		l3.add(8);
		l3.add(9);
	
		FlattenIterator list = new FlattenIterator(l1, l2, l3);
		
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		
//		ListOfListFlatten<Integer> l = new ListOfListFlatten<>(l1, l2, l3);
//		itr = l.iterator();
//		while(itr.hasNext()) {
//			System.out.print(itr.next()+" ");
//		}
		
//		LoopInLinkedList inLinkedList = new LoopInLinkedList();
//		//System.out.println("has loop ? " +inLinkedList.hasLoop());
//		//inLinkedList.removeLoop();
//		Node node = new Node(9);
//		node.next = new Node(9);
//		node.next.next = new Node(9);
//		
//		Node node2 = new Node(9);
//		node2.next = new Node(9);
//		node2.next.next = new Node(9);
//		
//		//inLinkedList.addTwoLists(node, node2);
//		
//		ReverseEveryKNodesAgain nodes = new ReverseEveryKNodesAgain();
//		nodes.reverseKNodes(3);
		
//		node = inLinkedList.removeDup(node);
//		Node temp = node;
//		while(temp != null) {
//			System.out.print(temp.val+" ");
//			temp = temp.next;
//		}
//		System.out.println();
		
	}

}
class Node { 
	int val;
	Node next;
	public Node(int val) {
		this.val = val;
	}
	
}


class ReverseEveryKNodesAgain { 
	
	private Node head = null;
	
	
	public ReverseEveryKNodesAgain() {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
	}
	
	public void reverseKNodes(int k) {
		if(k <= 0)
			return;
		
		head = revK(head,3);
		print(head);
	}
	
	public void print(Node node) {
		while(node != null) {
			System.out.print(node.val+" ");
			node = node.next;
		}
	}
	
	private Node revK(Node node, int k) {
		
		if(node == null)
			return null;
		
		Node curr = node;
		Node next = null;
		Node prev = null;
		
		// 1 -> 2 -> 3 -> 4
		int count = 0;
		while(count < k && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr =next;
			count++;
		}
		
		if(curr != null) {
			node.next = revK(curr, k);	
		}
		
		return prev;
	}
}

class FlattenIterator implements Iterable<Integer> {
	
	List<List<Integer>> list = null;
	
	public FlattenIterator(List<Integer> l1, List<Integer> l2, List<Integer> l3 ) {
		list = new ArrayList<List<Integer>>();
		list.add(l1);
		list.add(l2);
		list.add(l3);
	}
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Integer>() {
			
			int currentList = 0;
			int currentListElement = 0;
			
			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Integer next() {
				if(hasNext()) {
					return list.get(currentList).get(currentListElement++);
				} else {
					return null;
				}
			}
			
			@Override
			public boolean hasNext() {
				if(currentList < list.size()) {
					List<Integer> curr = list.get(currentList);
					if(currentListElement < curr.size()) {
						return true;
					} else { 
						currentList++;
						currentListElement = 0;
						return hasNext();
					}
				}
				return false;
			}
		};
	} 
	
}

class ReverseEveryKNodes {
	
	private Node head = null;
	
	public ReverseEveryKNodes() {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
	}
	
	public void print(Node node) {
		Node temp = node;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}
	
	public void reverseEveryK(int k) { 
		head = reverse(head, k);
		print(head);
	}
	
	private Node reverse(Node node, int k) {
		
		if(node == null) {
			return null;
		}
		
		int count = 1; 
		Node temp = node;
		while(temp != null && count != k) {
			temp = temp.next;
			count ++;
		}
		// 1 -> 2 -> 3 -> 4 (temp == 3)
		if(count == k) {
			Node curr = node; // curr =1 
			Node next = curr.next; // next =2 
			Node nextNext = null;
			Node temp2 = temp.next; // 4
			temp.next = null;
			while(next != null) {
				nextNext = next.next;
				next.next = curr;
				curr.next = nextNext;
				next = curr.next;
			}
			temp2 = reverse(temp2, k);
		}
		
		return node;
	}
	
}


class LoopInLinkedList { 
	
	private Node head;

	
	public Node removeDup(Node node) {
		if(node == null) {
			return node;
		}
		
		Node temp = removeDup(node.next);
		if(temp != null) {
			if(node.val == temp.val) {
				return temp;
			} else { 
				node.next = temp;
			}
		}
		
		return node;
	}
	
	public void addTwoLists(Node node1, Node node2) { 
		int carry = 0, sum = 0, temp = 0;
		Node temp1 = node1; 
		Node temp2 = node2; 
		Node res = null, resTemp = null;
		
		while(temp1 != null && temp2 != null) {
			sum = carry + temp1.val + temp2.val;
			temp = sum % 10;
			if(res == null) {
				res = new Node(temp);
				resTemp = res;
			} else { 
				resTemp.next = new Node(temp);
				resTemp = resTemp.next;
			}
			
			carry = sum / 10;
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		
		while(temp1 != null) {
			sum = carry + temp1.val;
			temp = sum % 10;
			
			resTemp.next = new Node(temp);
			resTemp = resTemp.next;
			
			carry = sum / 10;
			temp1 = temp1.next;
		}
		
		while(temp2 != null) {
			sum = carry + temp2.val;
			temp = sum % 10;
			
			resTemp.next = new Node(temp);
			resTemp = resTemp.next;
			
			carry = sum / 10;
			temp2 = temp2.next;
		}
		
		if(carry != 0) {
			resTemp.next = new Node(carry);
			resTemp = resTemp.next;
		}
		
		print(res);
	}
	
	public void print(Node node) {
		Node temp = node;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}
	
	public Node removeLoop() {
		Node slow = head;
		Node fast = head;
		while( fast != null && fast.next != slow ) {
			slow = slow.next;
			fast = fast.next;
			if(fast != null) {
				fast = fast.next;
			}
		}
		
		if(fast != null) {
			// remove loop
			// count num of nodes in loop
			int count = 1; // for fast node itself
			Node temp = fast.next;
			while(temp != fast) {
				count++;
				temp = temp.next;
			}
			slow = head; 
			fast = head;
			
			while(count > 0) {
				fast = fast.next;
				count--;
			}
			
			while(slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			// loop node found at slow/fast
			Node temp1 = slow;
			while(temp1.next != slow) {
				temp1 = temp1.next;
			}
			temp1.next = null;
			return head;
			
		} else {
			return head;
		}
	}
	
	
	public boolean hasLoop() {
		Node slow = head;
		Node fast = head;
		while( fast != null && fast.next != slow ) {
			slow = slow.next;
			fast = fast.next;
			if(fast != null) {
				fast = fast.next;
			}
		}
		
		if(fast != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public LoopInLinkedList() {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next  = head.next.next;
		
	}
	
}

class LList implements Iterable<Integer>{ 
	private Node root = null; 
	private Node last = null;
	private class Node { 
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
		}
		
	}
	
	public void add(int key) {
		if(root == null) {
			root = new Node(key);
			last = root;
		} else { 
			last.next = new Node(key);
			last = last.next;
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
}
class ListOfListFlatten<T> implements Iterable<T> {

	private List<T> list = null;

	public ListOfListFlatten(List<T> l1, List<T> l2, List<T> l3) {
		list = new ArrayList<>();
		list.addAll(l1);
		list.addAll(l2);
		list.addAll(l3);
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() {

			Iterator<T> itr = list.iterator();
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return itr.hasNext();
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				return itr.next();
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
}


class ListOfList<T> implements Iterable<T>{
	
	private List<List<T>> list = null;
	
	public ListOfList() {
		list = new ArrayList<List<T>>();
	}
	
	public void add(List<T> newList) {
		list.add(newList);
	}

	@Override
	public Iterator<T> iterator() {
	
		return new Iterator<T>() {

			private int currInnerList = 0;
			private int currentItem = 0;
			private List<T> temp = null;
			
			@Override
			public boolean hasNext() {
				if(currInnerList >= list.size()) {
					
				} else {
					temp = list.get(currInnerList);
					if(temp.size() > currentItem ) {
						return true;
					} else {
						currInnerList++;
						currentItem = 0;
						return hasNext();
					}
				}
				
				return false;
			}

			@Override
			public T next() {
				return temp.get(currentItem++);
			}

			@Override
			public void remove() {
				
			}
		};
	}
	
}
