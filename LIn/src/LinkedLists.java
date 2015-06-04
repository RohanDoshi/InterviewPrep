import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class LinkedLists {

	public static void main(String[] args) {
		Node node = new Node(2);
		node.next = new Node(2);
		node.next.next = new Node(5);
		node.next.next.next = new Node(3);
		node.next.next.next.next = new Node(5);
		node.next.next.next.next.next = new Node(1);
		node.next.next.next.next.next.next = new Node(6);
		node.next.next.next.next.next.next.next = node.next.next;
		
		LinkedLists ll = new LinkedLists();
		System.out.println(ll.findNodeBeginningLoop(node).val);
//		//ll.removeDuplicatesNoSpace(node);
//		//Node kthFromLast  =ll.KthToLastRecursion(node, 2);
//		//ll.deleteMiddleLL(node.next.next);
//		//node = ll.partitionAroundX(node, 2);
//		//ll.print(node);
//		// 6153522 
//		Node temp = new Node(9);
//		Node res = ll.addTwoReversedNumbers(node, temp);
//		System.out.println(6153522+9);
//		ll.print(res);
//		Node res1 = ll.addTwoNumbers(node, temp);
//		System.out.println(2253516+9);
//		ll.print(res1);
		
		Node palin = new Node(3);
		palin.next = new Node(2);
		palin.next.next = new Node(5);
		palin.next.next.next = new Node(2);
		palin.next.next.next.next = new Node(3);
		System.out.println(ll.isPalindromeRecur(palin));
	}
	
	public boolean isPalindromeRecur(Node node) {
		return isPalindromeRecur(node, len(node)).res;
	}
	
	public Result isPalindromeRecur(Node node, int len) {
		if(len <= 0)
			return new Result(true, node);
		
		if(len == 1)
			return new Result(true, node.next);
		
		if(len == 2) 
			return new Result(node.val==node.next.val, node.next.next);
		
		Result r = isPalindromeRecur(node.next, len-2);
		if(r.res == false)
			return r;
		
		if(r.resNode != null) {
			return new Result(r.resNode.val == node.val, r.resNode.next);
		} else {
			return new Result(false, node);
		}
	}
	
	private class Result { 
		boolean res;
		Node resNode;
		public Result(boolean res, Node node) {
			this.res = res;
			this.resNode = node;
		}
	}
	
	// 1,2
	// 2,4
	// 3,5
	public boolean isPalindrome(Node node) {
		if(node == null)
			return true; 
		
		Node slow = node;
		
		Node fast = node.next;
		Stack<Integer> stack = new Stack<>();
		
		int count = 1;
		while(fast != null) {
			count++;
			stack.add(slow.val);
			slow = slow.next;
			fast = fast.next;
			if(fast != null) {
				count++;
				fast = fast.next;
			}
		}
		if(count % 2 != 0)
			slow = slow.next;
		while(!stack.isEmpty()) {
			if(stack.pop() != slow.val) 
				return false;
			slow = slow.next;
		}
		
		return true;
		
		
	}
	public Node findNodeBeginningLoop(Node node) {
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
		
		fast = fast.next;
		slow = node;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;
	}
	
	public Node reverseLinkedList(Node node) {
		if(node == null)
			return null;
		
		if(node.next == null) {
			return node;
		}
		
		Node next = node.next;
		node.next = null;
		Node head = reverseLinkedList(next);
		next.next = node;
		return head;
	}
	
	// 123 + 456 = 579
	// 1-2-3 + 4-5-6 = 5-7-9
	public Node addTwoNumbers(Node node1, Node node2) {
		int carry[] = new int[1];
		int len1 = len(node1);
		int len2 = len(node2);
		
		Node res = null;
		if(len1 == len2)
			res = addTwoNumbers(node1, node2, carry);
		else if(len1 > len2) {
			res = addTwoNumbers(node1, appendZeros(len1-len2, node2), carry);
		} else {
			res = addTwoNumbers(appendZeros(len2-len1, node1), node2, carry);
		}
		
		if(carry[0] != 0) {
			Node node = new Node(carry[0]);
			node.next = res;
			res = node;
		}
		return res;
	}
	
	
	private Node appendZeros(int numOfZeroes, Node node) {
		if(numOfZeroes <= 0)
			return node;
		
		Node res = null, resCurr = null;
		while(numOfZeroes > 0) {
			if(res == null) {
				res = new Node(0);
				resCurr = res;
			} else {
				resCurr.next = new Node(0);
				resCurr = resCurr.next;
			}
			numOfZeroes--;
		}
		
		resCurr.next = node;
		node = res;
		return node;
	}
	
	// 1-2-3-4
	// 9 
	// 1-2-4-3
	private Node addTwoNumbers(Node node1, Node node2, int[] carry) {
		
		if(node1 == null && node2 == null) 
			return null;
		
		Node next = addTwoNumbers(node1.next, node2.next, carry);
		int sum = node1.val + node2.val + carry[0];
		Node node = new Node(sum % 10);
		node.next = next;
		carry[0] = sum / 10;
		
		return node;
		
		
	}
	
	private int len(Node node) {
		int count = 0;
		while(node != null) {
			count++;
			node = node.next;
		}
		return count;
	}
	// 123 + 456 = 579
	// 3-2-1 + 6-5-4 = 5-7-9
	public Node addTwoReversedNumbers(Node node1, Node node2) {
		Node res = null;
		boolean isDone = false;
		int carry = 0;
		while(!isDone) {
			int a = 0, b = 0;
			if(node1 != null) {
				a = node1.val;
				node1 = node1.next;
			}
			if(node2 != null) {
				b = node2.val;
				node2 = node2.next;
			}
			int sum = a + b + carry;
			if(res == null) {
				res = new Node(sum%10);
			} else {
				Node node = new Node(sum % 10);
				node.next = res;
				res = node;
			}
			carry = sum / 10;
			if(node1 == null && node2 == null)
				isDone = true;
		}
		
		if(carry != 0) {
			Node node = new Node(carry);
			node.next = res;
			res = node;
		}
		
		return res;
		
	}
	
	public Node partitionAroundX(Node node, int x) {
		
		Node beforeX = null, beforeXCurr = null;
		Node afterX = null, afterXCurr = null;
		Node allX = null, allXCurr = null;
		
		while(node != null) {
			Node next = node.next;
			node.next = null;
			if(node.val < x) {
				if(beforeX == null) {
					beforeX = node;
					beforeXCurr = beforeX;
				} else { 
					beforeXCurr.next = node;
					beforeXCurr = beforeXCurr.next;
				}
			} else if(node.val > x) {
				if(afterX == null) {
					afterX = node;
					afterXCurr = node;
				} else {
					afterXCurr.next = node;
					afterXCurr = afterXCurr.next;
				}
			} else {
				if(allX == null) {
					allX = node;
					allXCurr = node;
				} else {
					allXCurr.next = node;
					allXCurr = allXCurr.next;
				}
			}
			node = next;
 		}
		
		
		Node res = null;
		if(beforeX != null) {
			res = beforeX;
		}  
		
		if(res != null && beforeX != null) {
			beforeXCurr.next = allX;
		} else {
			res = allX;
		}
		
		if(res != null && allX != null) {
			allXCurr.next = afterX;
		} else {
			if(allX == null) {
				if(beforeX != null) {
					beforeXCurr.next = afterX;
				} else {
					res = afterX;
				}
			} else {
				res = afterX;
			}
		}
		
		return res;
		
		
	}
	
	public void deleteMiddleLL(Node nodeToBeDeleted) {
		if(nodeToBeDeleted == null)
			return;
		
		Node next = nodeToBeDeleted.next;
		nodeToBeDeleted.val = next.val;
		nodeToBeDeleted.next = next.next;
		
	}
	
	public Node KthToLastRecursion(Node node, int k) {
		int curr[] = new int[1];
		return KthToLastRecursion(node, curr, k);
	}
	
	private Node KthToLastRecursion(Node node, int[] curr, int k) { 
		if(node == null)
			return null;
		
		Node t = KthToLastRecursion(node.next, curr, k);
		if(curr[0] == k)
			return t;
		
		curr[0]++;
		if(curr[0] == k)
			return node;
		
		return null;
	}
	
	public Node KthToLast(Node node, int k) {
		if(k <= 0)
			return null;
		
		Node curr = node;
		int count = 1;
		while(curr != null && count < k) {
			curr = curr.next;
			count++;
		}
		
		if(count < k)
			return null;
		
		while(curr.next != null) {
			curr = curr.next;
			node = node.next;
		}
		
		return node;
		
	}
	
	public void removeDuplicatesNoSpace(Node node) {
		Node temp = node;
		Node next = node.next;
		
		while(temp != null) {
			Node prev = temp;
			next = temp.next;
			while(next != null) {
				if(temp.val == next.val) {
					prev.next = next.next;
				} else {
					prev = next;
				}
				next = next.next;
			}
			temp = temp.next;
		}
		print(node);
	}
	
	public void removeDuplicates(Node node) {
		Set<Integer> set = new HashSet<>();
		Node temp = node;
		Node prev = node;
		while(temp != null) {
			if(set.contains(temp.val)) {
				prev.next = temp.next;
			} else {
				set.add(temp.val);
				prev = temp;
			}
			temp = temp.next;
		}
		print(node);
	}
	
	public void print(Node node) {
		while(node != null) {
			System.out.print(node.val+" ");
			node = node.next;
		}
	}

}

class Node {
	Node next;
	int val;
	public Node(int val) {
		this.val = val;
	}
}
