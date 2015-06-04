import java.util.HashMap;
import java.util.HashSet;


class Node {
	Node next;
	int key;
	
	public Node(int key) {
		this.key = key;
	}
}


class SkipList { 
	SkipList skipNode;
	Node node;
	public SkipList(Node node) {
		this.node = node;
	}
}

class SmartNode  {
	SmartNode down;
	SmartNode next;
	int value;
	public SmartNode(int value) {
		this.value = value;
	}
}
public class LList {
	
	public Node reverseLL(Node node) {
		if(node == null) {
			return null;
		}
		
		Node head = node;
		Node next = node.next; 
		head.next = null;
		Node nextNext = null;
		while(next != null) {
			nextNext = next.next;
			next.next = head;
			head = next;
			next = nextNext;
		}
		
		return head;
	}
	
	public Node intersection(Node node1, Node node2) {
		if(node1 == null || node2 == null)
			return null;
		
		Node res = null;
		if(node1.key == node2.key) {
			res =  new Node(node1.key);
			res.next = intersection(node1.next, node2.next);
		}
		else if(node1.key < node2.key){
			res = intersection(node1.next, node2);
		} else
			res = intersection(node1, node2.next);
		
		return res;
		
	}
	
	// find triplets from 3 linked lists that amount to a sum
	public void findTriplets(Node node1, Node node2, Node node3, int sum) {
		HashSet<Integer> set = new HashSet<>();
		Node temp = node3;
		
		while(temp != null) {
			set.add(temp.key);
			temp = temp.next;
		}
		
		Node temp1 = node1, temp2 = null;
		while(temp1 != null) {
			temp2 = node2;
			while(temp2 != null) {
				int sum12 = temp1.key + temp2.key;
				if(set.contains(sum-sum12)){
					System.out.println(temp1.key +" "+  temp2.key +" "+ (sum - sum12));
				}
				temp2 = temp2.next;
			}
			temp1 = temp1.next;
		}
	}
	
	// rotate linked list counter clockwise
	public Node rotateCounterClockwise(Node node, int k) {
		Node temp = node;
		Node attach = null;
		Node res = null;
		while(temp != null) {
			if(k > 0) {
				if(attach == null) {
					attach = temp;
					temp = temp.next;
					attach.next = null;
				}
				else {
					Node temp2 = attach;
					while(temp2.next != null) {
						temp2 = temp2.next;
					}
					temp2.next = temp;
					temp = temp.next;
					temp2.next.next = null;
				}
			} else {
				if(res == null)
					res = temp;
				
				node = temp;
				temp = temp.next;
			}
			k--;
			
		}
		node.next = attach;
		
		return res;
	}
	
	
	
	public void printSmartNodeDown(SmartNode node) {
		while(node != null) {
			System.out.print(node.value +" ");
			node = node.down;
		}
 	}
	// flattening a linked list (smart)
	public SmartNode flattenLinkedList(SmartNode node) {
		if(node == null || (node.next == null))
			return node;
		
		SmartNode temp = node;
		while(temp.next != null) {
			node = merge(node, temp.next);
			temp = temp.next;
		}
		
		return node;
	}
	
	public SmartNode merge(SmartNode node, SmartNode next) {
		if(node == null)
			return next;
		
		if(next == null)
			return node;
		
		if(node.value < next.value) {
			node.down = merge(node.down, next);
			return node;
		}
		else {
			next.down = merge(node, next.down);
			return next;
		}
	}
	
	// flattening a linked list (inefficient and bad and ugly and incorrect)
	public SmartNode flatSmartLinkedList(SmartNode node) {
		if(node == null || (node.next == null && node.down == null))
			return node;
		
		SmartNode curr = node, res = node;
		SmartNode next = curr.next;
		SmartNode down = curr.down;
		while(curr.next != null || curr.down != null) {
			
			if(next != null && down != null) {
				
				if(down.value <= next.value) {
					SmartNode oldNext = next;
					next = down;
					down = down.down;
					curr.down = down;
					curr.next = next;
					next.down = null;
					next.next = oldNext;
				} else {
					SmartNode nextDown = next.down;
					SmartNode prev = next;
					while(nextDown != null && nextDown.value < down.value) {
						prev = nextDown;
						nextDown = nextDown.next;
					}
					prev.down = down;
					down = down.down;
					curr.down = down;
					prev.down.down = nextDown;
				}
				
			} else if(down != null) {
				curr.next = down;
				down = down.down;
				curr.next.next = null;
				curr.down = down;
			} else {
				curr = next;
				if(curr == null)
					break;
				next = curr.next;
				down = curr.down;
			}
		}
		
		return res;
	}
	
	// len of linked list
	public int len(Node node) {
		int count = 0;
		while(node != null) {
			count++;
			node = node.next;
		}
		return count;
	}
	
	// add two numbers represented by Linked Lists
	int carry = 0;
	
	public Node addLists(Node node1, Node node2) {
		int len1 = len(node1) ;
		int len2 = len(node2);
		
		if(len1 == 0) 
			return node2;
		
		if(len2 == 0)
			return node1;
		
		int diff = Math.abs(len1-len2);
		if(diff != 0) {
			return null;
		} else {
			Node node =  add(node1, node2);
			if(carry != 0) {
				Node newNode = new Node(carry);
				newNode.next = node;
				node = newNode;
			}
			return node;
		}
	}
	
	
 	public Node add(Node node1, Node node2) {
		int sum = 0; Node next = null;
		if(node1 == null && node2 == null)
			return null;
		
		if(node1 == null) {
			next = add(null, node2.next);
			sum = 0 + node2.key + carry;
		} else if (node2 == null) {
			next = add(node1.next , null);
			sum = node1.key + 0 + carry;
		} else { 
			next = add(node1.next, node2.next);
			sum = node1.key + node2.key + carry;
		}
		
		int digit = sum % 10;
		carry = sum / 10;
		Node node = new Node(digit);
		node.next = next;
		return node;
		
	}
	
	
	// sort 0s, 1s, 2s
	public Node sortZeroOneTwo(Node node) {
		if(node == null)
			return node;
		
		Node zeros = null, ones = null, twos = null;
		Node zTail = null, oTail = null, tTail = null;
		Node temp = node;
		while(temp != null) {
			Node next = temp.next;
			if(temp.key == 0) {
				if(zeros == null) {
					zeros = temp;
					zTail = temp;
					zTail.next = null;
				} else { 
					zTail.next = temp;
					zTail = zTail.next;
					zTail.next = null;
				}
			} else if(temp.key == 1) {
				if(ones == null) {
					ones = temp;
					oTail = temp;
					oTail.next = null;
				} else { 
					oTail.next = temp;
					oTail = oTail.next;
					oTail.next = null;
				}
			} else if(temp.key == 2) {
				if(twos == null) {
					twos = temp;
					tTail = temp;
					tTail.next = null;
				} else { 
					tTail.next = temp;
					tTail = tTail.next;
					tTail.next = null;
				}
			} else  {
				
			}
			temp = next;
		}
		
		zTail.next = ones;
		oTail.next = twos;
		return zeros;
 	}
	
	
	//swap kth node from beg with kth node from last
	public Node swapkBegEnd(Node node, int k) {
		
		if(node == null || k <= 0) 
			return node;
		
		int n = 0;
		Node temp = node, prev = null, slowNode = null;
		Node prevKBeg = null, prevKLast = null;
		while(temp != null) {
			n++;
			
			if(n == k) {
				prevKBeg = prev;
			}
			if(n == k+1) {
				slowNode = node;
			}
			
			prev = temp;
			temp = temp.next;
			if(slowNode != null) {
				prevKLast = slowNode;
				slowNode = slowNode.next;
			}
		}
		
		// prevKBeg can be null (before the first node) 
		if(prevKBeg == null) {
			Node last = prevKLast.next;
			prevKLast.next = node;
			last.next = node.next;
			node.next = null;
			node = last;
			return node;
			
		}
		// prevKBeg can be same as prevKLast
		else if(prevKBeg == prevKLast) {
			return node;
			
		} 
		
		// prevKBeg can be before prevKLast
		// prevKBeg can be after prevKLast
		else {
			Node KBeg = prevKBeg.next;
			Node KLast = prevKLast.next;
			Node nextBeg = KBeg.next;
			Node nextLast = KLast.next;
			
			prevKBeg.next = KLast;
			KLast.next = nextBeg;
			
			prevKLast.next = KBeg;
			KBeg.next = nextLast;
			return node;
		}
		
			
	}
	
	
	// delete N nodes after every M nodes
	public Node deleteNafterM(Node node, int m, int n) {
		if(node == null)
			return node;
		
		Node temp = node;
		int count = 1;
		while(count < m && temp != null) {
			temp = temp.next; 
			count++;
		}
		if(temp != null) {
			count = 0;
			Node temp2 = temp;
			while(count < n && temp != null) {
				count ++;
				temp = temp.next;
			}
			temp2.next = deleteNafterM(temp.next, m, n);
		}
		
		return node;
	}
	
	// quicksort on a single LL 
	public Node quickSort(Node node) {
		node = qSort(node, returnTail(node));
		printList(node);
		return node;
	}
	
	public Node returnTail(Node node) {
		while(node != null && node.next != null)
			node = node.next;
		
		return node;
	}
	
	public Node qSort(Node head, Node tail) {
		if(head != tail) {
			Node pivot = partition(head, tail);
			head = qSort(head, getNodeBeforePivot(head, pivot));
			head = qSort(pivot.next, returnTail(head));
		}
		return head;
	}
	
	public Node getNodeBeforePivot(Node head, Node pivot) {
		
		while(head.next != pivot)
			head = head.next;
		
		return head;
	}
	
	public Node partition(Node head, Node tail) {
		Node pivot = tail;
		Node temp = head;
		Node prev = null;
		while(temp != pivot) {
			if(temp.key > pivot.key) {
				if(prev != null)
					prev.next = temp.next;
				else {
					head = temp.next;
				}
				temp.next = null;
				Node tailNext = tail.next;
				tail.next = temp;
				temp.next = tailNext;
				
				if(prev != null)
					temp = prev.next;
				else
					temp = head;
				
			} else { 
				
				prev = temp;
				temp = temp.next;
			}
			
		}
		return pivot;
	}
	
	// merge linkedlist into another linkedlist at alternate positions
	public Node mergeLLAlternatePositions(Node node1, Node node2) {
		Node next1 = null, next2 = null;
		Node nodeCurr1 = node1, nodeCurr2 = node2;
		while(nodeCurr1 != null && nodeCurr2 != null) {
			
			next1 = nodeCurr1.next;
			next2 = nodeCurr2.next;
			nodeCurr1.next = nodeCurr2;
			nodeCurr2.next = next1;
			nodeCurr2 = next2;
			nodeCurr1 = next1;
		}
		return node1;
	}
	
	// Linked List Self Organizing Lists Move-to-front method, Count method, Transpose method
	// competitive analysis.. online vs offline... move-to-front is 4-Competitive.. 4 times 
	// more operations than offline...
	
	// 1 -> 2 -> 3 -> 4 -> 5 -> 6 
	// 2 -> 1 -> 4 -> 3 -> 6 -> 5 
	public Node swapPairwise(Node node) {
		if(node == null || node.next == null)
			return node; 
		
		Node nextNext = node.next.next;
		
		Node temp = node;
		node = node.next;
		node.next = temp;
		
		node.next.next = swapPairwise(nextNext);
		return node;
	}
	
	
	// 1 -> 2 -> 3 -> 4 -> 5 -> 6 
	// 1 -> 3 -> 5 -> 6 -> 4 -> 2
	public Node reverseAlternateNodes(Node odd) {
		if(odd == null || odd.next == null)
			return odd;
		
		Node prev = null;
		Node tail = odd;
		while(tail.next != null) {
			tail = tail.next;
		}
		int count = 1;
		Node res = odd;
		while(odd != tail) {
			
			if(count % 2 == 0) {
				
				prev.next = odd.next;
				Node temp = tail.next;
				tail.next = odd;
				odd.next = temp;
				odd = prev.next;
						
			} else { 
				
				prev = odd;
				odd = odd.next;
			}
			
			count++;
		}
		return res;
 	}
	
	public void printList(Node node) {
		while(node != null)
		{
			System.out.print(node.key+" ");
			node = node.next;
		}
	}
	
	public void printSmartList(SmartNode node) {
		while(node != null)
		{
			System.out.print(node.value+" ");
			node = node.next;
		}
	}
	
	public Node removeDuplicatesFromSortedLL(Node node) {
		if(node == null) {
			return node;
		}
		if(node.next == null) {
			return node; 
		}
		Node temp = removeDuplicatesFromSortedLL(node.next);
		if(node.key == temp.key) {
			return temp;
		} else {
			node.next = temp;
			return node;
		}
		
	}
	
	public static void main(String args[]) {
		
		
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(3);
		node.next.next.next.next = new Node(5);
		node.next.next.next.next.next = new Node(6);
		node.next.next.next.next.next.next = new Node(6);
		//node.next.next.next.next.next.next.next = new Node(8);
		//node.next.next.next.next.next.next.next.next = new Node(9);
		//node.next.next.next.next.next.next.next.next.next = new Node(10);
		
		
		Node node1 = new Node(8);
		node1.next = new Node(14);
		node1.next.next = new Node(19);
		node1.next.next.next = new Node(21);
		node1.next.next.next.next = new Node(22);
		node1.next.next.next.next.next = new Node(23);
		node1.next.next.next.next.next.next = new Node(24); 
		
		
		Node node3 = new Node(5);
		node3.next = new Node(8);
		node3.next.next = new Node(11);
		node3.next.next.next = new Node(14);
		node3.next.next.next.next = new Node(19);
		node3.next.next.next.next.next = new Node(20);
		node3.next.next.next.next.next.next = new Node(21); 
		
		SmartNode root = new SmartNode(5);
		root.next = new SmartNode(10);
		root.next.next = new SmartNode(19);
		root.next.next.next = new SmartNode(28);
		root.down = new SmartNode(7);
		root.down.down = new SmartNode(8);
		root.down.down.down = new SmartNode(30);
		root.next.down = new SmartNode(20);
		root.next.next.down = new SmartNode(22);
		root.next.next.down.down = new SmartNode(50);
		root.next.next.next.down = new SmartNode(35);
		root.next.next.next.down.down = new SmartNode(40);
		root.next.next.next.down.down.down = new SmartNode(45);
		
		LList list = new LList();
		//node = list.reverseAlternateNodes(node);
		//node = list.swapPairwise(node);
		//list.mergeLLAlternatePositions(node, node1);
		//list.quickSort(node);
		//node = list.deleteNafterM(node, 1, 1);
		//list.swapkBegEnd(node, 6);
		//node1 = list.sortZeroOneTwo(node1);
		//node1 = list.addLists(node, node1);
		//list.printList(node1);
		//root = list.flattenLinkedList(root);
		//list.printSmartNodeDown(root);
		//node = list.rotateCounterClockwise(node, 6);
		//list.findTriplets(node, node1, node3, 39);
		
		//node = list.intersection(node1, node3);
		//node = list.reverseLL(node);
		node = list.removeDuplicatesFromSortedLL(node);
		list.printList(node);
		
		
	}
}
