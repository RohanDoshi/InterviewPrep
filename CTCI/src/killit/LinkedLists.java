package killit;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedLists {

	private static class Node {
		Node next;
		int value;
		public Node(int value) {
			this.value = value;
		}
	}
	public static void main(String[] args) {
		LinkedLists ll = new LinkedLists();
		Node node = new Node(9);
		node.next = new Node(8);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(1);
		node.next.next.next.next.next = new Node(2);
		node.next.next.next.next.next.next = new Node(7);
		node.next.next.next.next.next.next.next = new Node(3);
		//node.next.next.next.next.next.next.next.next = node.next.next;
//		//ll.removeDuplicatesNoBufferAllowed(node);
//		ll.printLinkedList(node);
//		Node kth = ll.kthFromLastElement(node, 17);
//		Node kthIter = ll.kthFromLastElementIterative(node, 17);
//		System.out.println("kth = "+(kth != null ? kth.value : "Not found"));
//		System.out.println( "KthIter = "+(kthIter != null ? kthIter.value : "Not found"));
//		//ll.deleteMiddleGiven(node.next.next.next.next.next.next);
//		ll.printLinkedList(node);
//		ll.printLinkedList(node);
//		//node = ll.partitionLinkedList(node, 4);
//		//ll.partitionLinkedListBetter(node, 4);
//		node = ll.addTwoLinkedLists(node, node);
//		ll.printLinkedList(node);
		Node startOfLoop = ll.findNodeAtBeginningOfLoop(node);
		System.out.println("Loop begins at "+(startOfLoop != null ? startOfLoop.value : "No loop exists"));
		
		Node palin = new Node(1);
		palin.next = new Node(2);
		palin.next.next = new Node(3);
		palin.next.next.next = new Node(2);
		palin.next.next.next.next = new Node(1);
		//palin.next.next.next.next.next = new Node(1);
		
		ll.palinNode = palin;
		System.out.println(ll.isLinkedListPalindrome(palin));
		System.out.println(ll.isLinkedListPalindromeNeat(node));
		System.out.println(ll.isLinkedListPalindromeBetter(palin));
		
		System.out.println(ll.isPalinRecursive(palin));
		
		
		Node even = new Node(0);
		even.next = new Node(2);
		even.next.next = new Node(4);
		even.next.next.next = new Node(6);
		even.next.next.next.next = new Node(8);
		even.next.next.next.next.next = new Node(10);
		
		
		Node odd = new Node(1);
		odd.next = new Node(3);
		odd.next.next = new Node(5);
		odd.next.next.next = new Node(7);
		odd.next.next.next.next = new Node(9);
		
		//Node merge = ll.mergeSortedListsRecurs(even, odd);
		//ll.printLinkedList(merge);
		ll.reverseLinkedListNonDestructive(even);
		
	}
	
	
	public void reverseLinkedListNonDestructive(Node node) {
		printLinkedList(node);
		reverseNonDestructive(node, length(node));
		printLinkedList(node);
	}
	
	private Node reverseNonDestructive(Node node, int len) {
		if(len <= 0)
			return node;
		
		if(len == 1)
			return node.next;
		
		if(len == 2) {
			int temp = node.value;
			node.value = node.next.value;
			node.next.value = temp;
			return node.next.next;
		}
		
		Node rev = reverseNonDestructive(node.next, len-2);
		int temp = node.value;
		node.value = rev.value;
		rev.value = temp;
		return rev.next;
	}
	
	public Node mergeSortedListsRecurs(Node node1, Node node2) {
		if(node1 == null)
			return node2;
		
		if(node2 == null)
			return node1; 
		
		Node merge = mergeSortedListsRecurs(node1.next, node2.next);
		node1.next = null;
		node2.next = null;
		
		Node res = null;
		if(node1.value > node2.value) {
			node2.next = node1;
			node1.next = merge;
			res = node2;
		} else {
			node1.next = node2;
			node2.next = merge;
			res = node1;
		}
		
		return res;
		
	}
	
	public Node mergeSortedLists(Node node1, Node node2) {
		if(node1 == null)
			return node2;
		
		if(node2 == null)
			return node1; 
		
		Node start1 = node1; 
		Node start2 = node2; 
		
		Node res = null, resStart = null;
		
		while(start1 != null && start2 != null) {
			if(start1.value <= start2.value) {
				if(res == null) {
					res = start1; 
					resStart=res;
					start1 = start1.next;
					resStart.next = null;
				} else {
					resStart.next = start1; 
					start1 = start1.next;
					resStart = resStart.next;
					resStart.next = null;
				}
			} else  {
				if(res == null) {
					res = start2; 
					resStart = res;
					start2 = start2.next;
					resStart.next = null;
				} else {
					resStart.next = start2;
					start2 = start2.next;
					resStart = resStart.next;
					resStart.next = null;
				}
			}
		}
		
		if(start1 != null)
			resStart.next = start1; 
		
		if(start2 != null)
			resStart.next = start2;
		
		return res;
	}
	
	private class Result {
		Node resNode; 
		boolean res; 
		public Result(Node resNode, boolean res) {
			this.resNode = resNode;
			this.res = res;
		}
	}
	public boolean isPalinRecursive(Node node) {
		Result r = isPalinRecursiveNode(node, length(node));
		return r.res;
	}
	
	private Result isPalinRecursiveNode(Node node, int len) {
		
		if(len <= 0)
			return new Result(null, true);
		
		if(len == 1)
			return new Result(node.next, true);
		
		if(len == 2) 
			return new Result(node.next.next, node.value == node.next.value);
		
		Result r = isPalinRecursiveNode(node.next, len-2);
		if(r.resNode == null || !r.res)
			return r;
		
		if(r.resNode.value == node.value && r.res)
			return new Result(r.resNode.next, true);
		
		return new Result(null, false);
		
	}
	
	public boolean isLinkedListPalindromeBetter(Node node) {
		if(node == null)
			return false;
		
		if(node.next == null)
			return true;
		
		Node slow = node;
		Node fast = node.next;
		Stack<Node> stack = new Stack<>();
		
		while(fast != null) {
			stack.push(slow);
			slow = slow.next;
			fast = fast.next;
			if(fast != null) {
				fast = fast.next;
			}
		}
		
		Node compareWith = slow;
		while(compareWith != null) {
			if(compareWith.value == stack.peek().value) {
				compareWith = compareWith.next;
				stack.pop();
			} else {
				return false;
			}
		}
		
		return true;
	}
	
	
	public boolean isLinkedListPalindromeNeat(Node node) {
		System.out.println("Current list");
		printLinkedList(node);
		//reverseLinkedListRecursive(node, rev);
		Node revNode = reverseLinkedListRecursiveBetter(node);
		System.out.println("Reverse list");
		printLinkedList(revNode);
		Node revserse = revNode;
		while(node != null) {
			if(revserse.value != node.value)
				return false;
			
			revserse = revserse.next;
			node = node.next;
		}
		
		return true;
	}
	
	public Node reverseLinkedListRecursiveBetter(Node node) {
		if(node == null)
			return null;
		
		if(node.next == null)
			return node;
		
		Node next = node.next;
		node.next = null;
		Node head = reverseLinkedListRecursiveBetter(next);
		next.next = node;
		return head;
	}
	
	public Node reverseLinkedListRecursive(Node node, Node[] head) {
		if(node == null)
			return null;
		
		Node prev = reverseLinkedListRecursive(node.next, head);
		if(prev != null) {
			prev.next = node;
		} else {
			head[0] = node;
		}
		node.next = null;
		return node;
	}
	
	// bad , inefficient way
	Node palinNode  = null;
	public boolean isLinkedListPalindrome(Node node) {
		if(node == null)
			return true;
		
		boolean prevPair = isLinkedListPalindrome(node.next);
		boolean currentPair = node.value == palinNode.value;
		palinNode = palinNode.next;
		return prevPair && currentPair;
	}
	
	
	public Node findNodeAtBeginningOfLoop(Node node) {
		Node meetAt = loopExistsAndMeetAt(node);
		if(meetAt == null)
			return null;
		
		meetAt = meetAt.next;
		
		while(node != meetAt) {
			node = node.next;
			meetAt = meetAt.next;
		}
		
		return node;
		
	}
	
	public Node loopExistsAndMeetAt(Node node) {
		if(node == null)
			return null;
		
		Node slow = node;
		Node fast = node.next;
		
		while(fast != null && fast != slow) {
			slow = slow.next;
			fast = fast.next;
			if(fast != null) 
				fast = fast.next;
		}
		
		if(fast == null)
			return null;
		
		return fast;
		
	}
	
	private Node prefixZeroNodes(Node node, int num) {
		if(num <= 0)
			return node;
		
		Node zeroNode = new Node(0);
		zeroNode.next = prefixZeroNodes(node, num-1);
		return zeroNode;
	}
	
	public int length(Node node) {
		int count = 0;
		while(node != null) {
			count++;
			node = node.next;
		}
		return count;
	}
	
	public Node addTwoLinkedLists(Node node1, Node node2) {
		int len1 = length(node1);
		int len2 = length(node2);
		if(len1 > len2) {
			node2 = prefixZeroNodes(node2, len1-len2);
		} else if(len2 > len1) {
			node1 = prefixZeroNodes(node1, len2-len1);
		}
		int[] carry = new int[1];
		Node res=  addTwoLinkedListsCarry(node1, node2, carry);
		if(carry[0] != 0) {
			Node carryNode = new Node(carry[0]);
			carryNode.next = res;
			res = carryNode;
		}
		return res;
	}
	
	// 1-> 9-> 2
	//     2-> 1
	// 2-> 1-> 3
	private Node addTwoLinkedListsCarry(Node node1, Node node2, int[] carry) {
		if(node1 == null && node2 == null) {
			return null;
		}
		
		Node next = addTwoLinkedListsCarry(node1.next, node2.next, carry);
		int sum = node1.value + node2.value + carry[0];
		Node node = new Node(sum % 10);
		carry[0] = sum/10;
		node.next = next;
		return node;
	}
	
	/// #KickAss
	public void partitionLinkedListBetter(Node node, int x) {
		if(node == null)
			return;
		
		Node swapWith = node;
		while(node != null) {
			if(node.value > x) {
				if(swapWith.value <= x)
					swapWith = node;
			} else {
				swapValues(node, swapWith);
				swapWith = swapWith.next;
			}
			node = node.next;
		}
		
		
	}
	
	public void swapValues(Node a, Node b) {
		int temp = a.value ;
		a.value = b.value;
		b.value = temp;
	}
	
	public Node partitionLinkedList(Node node, int x) {
		if(node == null)
			return null;
		
		Node start = node;
		Node lessThan = null;
		Node greaterThan = null;
		
		while(start != null) {
			if(start.value < x) {
				if(lessThan == null) {
					lessThan = start;
					start = start.next;
					lessThan.next = null;
				} else {
					Node temp = start;
					start = start.next;
					temp.next = lessThan;
					lessThan = temp;
				}
			} else {
				if(greaterThan == null) {
					greaterThan = start;
					start = start.next;
					greaterThan.next = null;
				} else {
					Node temp = start;
					start = start.next;
					temp.next = greaterThan;
					greaterThan = temp;
				}
			}
		}
		
		if(lessThan == null)
			return greaterThan;
		
		start = lessThan;
		while(start.next != null)
			start = start.next;
		
		start.next = greaterThan;
		return lessThan;
	}
	
	public void deleteMiddleGiven(Node middleNode) {
		if(middleNode == null)
			return;
		
		Node prev = middleNode;
		Node next = middleNode.next;
		
		while(next.next != null) {
			prev.value = next.value;
			prev = next;
			next = next.next;
		}
		
		prev.value = next.value;
		prev.next = null;
	}
	
	public Node kthFromLastElementIterative(Node node, int k) {
		if(node == null)
			return null;
		
		int currNode = 1;
		Node temp = node;
		while(currNode != k && temp != null) {
			temp = temp.next;
			currNode++;
		}
		
		if(temp == null)
			return null;
		
		while(temp.next != null) {
			node = node.next;
			temp = temp.next;
		}
		
		return node;
	}
	
	public Node kthFromLastElement(Node node, int k) {
		if(node == null)
			return null;
		
		return kthFromLastElement(node, k, new int[1]);
	}
	
	private Node kthFromLastElement(Node node, int k, int[] position) {
		if(node == null) {
			return null;
		}
		Node kthFromLast = kthFromLastElement(node.next, k, position);
		position[0]++;
		if(kthFromLast == null) {
			if(position[0] == k) {
				return node;
			}
		}
		
		return kthFromLast; 
	}
	
	public void printLinkedList(Node node) {
		while(node != null) {
			if(node.next == null)
				System.out.println(node.value);
			else
				System.out.print(node.value+"->");
			node = node.next;
		}
	}
	
	public void removeDuplicates(Node node) {
		
		if(node == null)
			return;
		
		Set<Integer> set = new HashSet<>();
		Node curr = node;
		Node prev = null;
		
		while(curr != null) {
			if(set.contains(curr.value)) {
				prev.next = curr.next;
			} else {
				set.add(curr.value);
				prev = curr;
			}
			curr = curr.next;
		}
	}
	
	
	public void removeDuplicatesNoBufferAllowed(Node node) {
		if(node == null || node.next == null)
			return;
		
		while(node != null) {
			Node prev = node;
			Node curr = node.next;
			while(curr != null) {
				if(curr.value == node.value) {
					prev.next = curr.next;
				} else {
					prev = curr;
				}
				curr = curr.next;
			}
			node = node.next;
		}
	}
 
}
