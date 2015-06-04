import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class ArraysAndStrings {

	public static void main(String[] args) {
		ArraysAndStrings as = new ArraysAndStrings();
		System.out.println(as.hasUniqChars("sohq"));
		System.out.println(as.replaceAllSpaces("Mr John Smith    "));
		System.out.println(as.compress("aabcccccaaa"));
		NodeLL node = new NodeLL(2);
		node.next = new NodeLL(7);
		node.next.next = new NodeLL(3);
		node.next.next.next = new NodeLL(4);
		node.next.next.next.next = new NodeLL(3);
		node.next.next.next.next.next = new NodeLL(4);
		node.next.next.next.next.next.next = new NodeLL(1);
		node.next.next.next.next.next.next.next = node.next.next.next.next;
		
//		//node = as.removeDup(node);
//		int kth = as.KthValFromLast(node, 5);
//		System.out.println(kth);
//		kth = as.KthValFromLastIter(node, 5);
//		System.out.println(kth);
//		as.print(node);
//		as.delete(node.next.next.next);
//		System.out.println();
//		as.print(node);
//		node = as.partition(node, 4);
//		System.out.println();
//		as.print(node);
		
		NodeLL node1 = new NodeLL(9);
		node1.next = new NodeLL(9);
		node1.next.next = new NodeLL(9);
		
		NodeLL node2 = new NodeLL(9);
		node2.next = new NodeLL(9);
		node2.next.next = new NodeLL(9);
		
		NodeLL sum = as.sum(node1, node2);
		System.out.println();
		as.print(sum);
		
		NodeLL collision = as.beginningOfLoop(node);
		System.out.println("\ncollision val -->"+collision.val);
		
		NodeLL palin = new NodeLL(1);
		palin.next = new NodeLL(2);
		palin.next.next = new NodeLL(3);
		palin.next.next.next = new NodeLL(3);
		palin.next.next.next.next = new NodeLL(2);
		palin.next.next.next.next.next = new NodeLL(1);
		
		System.out.println(as.isPalin(palin));
		
		Stack<Integer> stack1 = new Stack<>();
		stack1.push(9);
		stack1.push(5);
		stack1.push(8);
		stack1.push(1);
		stack1.push(3);
		stack1.push(2);
		stack1.push(4);
		
//		Stack<Integer> stack2 = new Stack<>();
//		Stack<Integer> stack3 = new Stack<>();
//		as.hanoi(7, stack1, stack2, stack3);
//		System.out.println(stack3.toString());
//		System.out.println(stack3.pop());
		as.sortStack(stack1);
	
		IntervalTree intervalTree = new IntervalTree();
		intervalTree.add(9, 12);
	}
	
	public void sortStack(Stack<Integer> s) {
		Stack<Integer> r = new Stack<>();
		while(!s.isEmpty()) {
			int top = s.pop();
			while(!r.isEmpty() && r.peek() > top) {
				s.push(r.pop());
			}
			r.push(top);
		}
		System.out.println(r.toString());
	}
	
	public void hanoi(int n, Stack<Integer> tower1, Stack<Integer> tower2, Stack<Integer> tower3) {
		if(n > 0) {
			hanoi(n-1, tower1, tower3, tower2);
			tower3.push(tower1.pop());
			hanoi(n-1, tower2, tower1, tower3);
		}
	}
	
	class Result {
		NodeLL node;
		boolean isPal;
		public Result(NodeLL node, boolean isPal) {
			this.node = node;
			this.isPal = isPal;
		}
	}
	public boolean isPalin(NodeLL node) {
		Result r = isPalin(node, len(node));
		return r.isPal;
	}
	
	private Result isPalin(NodeLL node, int len) {
		if(len == 0)
			return new Result(node, true);
		
		if(len == 1) {
			return new Result(node.next, true);
		}
		
		if(len == 2) {
			return new Result(node.next.next, node.val == node.next.val);
		}
		
		Result r = isPalin(node.next, len-2);
		if(!r.isPal)
			return new Result(node, r.isPal);
		
		if(node.val == r.node.val)
			return new Result(r.node.next, true);
		
		return new Result(r.node.next, false);
	}
	
	public int len(NodeLL node) {
		int count = 0;
		while(node != null) {
			count++;
			node = node.next;
		}
		return count;
	}
	
	public NodeLL beginningOfLoop(NodeLL node) {
		NodeLL fast = node;
		NodeLL slow = node;
		if(fast.next != null)
			fast = fast.next;
		else 
			return null;
		
		while(fast!= null && fast != slow) {
			slow = slow.next;
			fast = fast.next;
			if(fast != null)
				fast = fast.next;
		}
		
		if(fast == null)
			return null;

		
		slow = node;
		fast = fast.next;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}
	
	public NodeLL sum(NodeLL node1, NodeLL node2) {
		int[] carry = new int[1];
		NodeLL node = sum(node1, node2, carry);
		if(carry[0] != 0) {
			NodeLL nodeCarry = new NodeLL(carry[0]);
			nodeCarry.next = node;
			node = nodeCarry;
		}
		return node;
	}
	
	public NodeLL sum(NodeLL node1, NodeLL node2, int[] carry) {
		if(node1 == null && node2 == null)
			return null;
		
		if(node1 == null) {
		
			int sum = node2.val + carry[0];
			NodeLL node = new NodeLL(sum % 10);
			carry[0] = sum / 10;
			return node;
		
		}else if(node2 == null) {
			
			int sum = node1.val + carry[0];
			NodeLL node = new NodeLL(sum % 10);
			carry[0] = sum / 10;
			return node;
			
		} else {
		
			NodeLL soFar = sum(node1.next, node2.next, carry);
	
			int sum = node1.val + node2.val + carry[0];
			NodeLL node = new NodeLL(sum % 10);
			carry[0] = sum / 10;
			node.next = soFar;
			return node;
		}
		
	}
	
	public NodeLL partition(NodeLL node, int x) {
		NodeLL before = null, bptr = null;
		NodeLL after = null, aptr = null;
		NodeLL xVal = null, xptr = null;
		while(node != null) {
			NodeLL next = node.next;
			node.next = null;
			if(node.val < x) {
				if(before == null) {
					before = node;
					bptr = node;
				} else {
					bptr.next = node;
					bptr = bptr.next;
				}
			} else if(node.val > x){
				if(after == null) {
					after = node;
					aptr = node;
				} else {
					aptr.next = node;
					aptr = aptr.next;
				}
			} else {
				if(xVal == null) {
					xVal = node;
					xptr = node;
				} else {
					xptr.next = node;
					xptr = xptr.next;
				}
			}
			node = next;
		}
		
		NodeLL res = null;
		if(before != null) {
			res = before;
		} else if(xVal != null) {
			res = xVal;
		} else {
			res = after;
		}
		
		if(bptr != null) {
			bptr.next = xVal;
		}
		
		if(xptr != null) {
			xptr.next = after;
		}
		
		return res;
	}
	
	public void delete(NodeLL node) {
		if(node == null)
			return;
		
		NodeLL next = node.next;
		NodeLL prev = node;
		while(next != null) {
			node.val = next.val;
			prev = node;
			node = node.next;
			next = next.next;
		}
		prev.next = null;
		
	}
	
	public int KthValFromLastIter(NodeLL node, int k) {
		NodeLL fast = node;
		int count = 1;
		while(count != k && fast != null) {
			fast = fast.next;
			count++;
		}
		
		if(fast == null)
			return -1;
		
		NodeLL slow = node;
		while(fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return slow.val;
	}
	
	public int KthValFromLast(NodeLL node, int k) {
		int num[] = new int[1];
		NodeLL last = KthNodeFromLast(node, k, num);
		if(num[0] == k) {
			return last.val;
		} else {
			return -1;
		}
	}
	
	public NodeLL KthNodeFromLast(NodeLL node, int k, int[] num) {
		if(node == null)
			return null;
		
		NodeLL last = KthNodeFromLast(node.next, k, num);
		if(num[0] == k)
			return last;
		else {
			num[0]++;
			return node;
		}
	}
	
	
	public void print(NodeLL node) {
		while(node != null) {
			System.out.print(node.val+" ");
			node = node.next;
		}
	}
	
	public NodeLL removeDup(NodeLL node) {
		Set<Integer> val = new HashSet<>();
		NodeLL temp = node;
		NodeLL prev = null;
		while(temp != null) {
			if(!val.contains(temp.val)) {
				val.add(temp.val);
				if(prev == null)
					prev = temp;
				else
					prev = prev.next;
			} else {
				prev.next = temp.next;
			}
			temp = temp.next;
		}
		return node;
	}
	
	public String compress(String s) {
		char c[] = s.toCharArray();
		char prev = c[0];
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<c.length; i++) {
			if(c[i] == prev) {
				count++;
			} else {
				sb.append(prev);
				sb.append(count);
				count=1;
			}
			prev = c[i];
		}
		sb.append(prev);
		sb.append(count);
		return sb.length() > c.length ? s : sb.toString();
	}
	
	
	
	public boolean hasUniqChars(String s) {
		char c[] = s.toCharArray();
		int val = 0;
		for(int i=0; i<c.length; i++) {
			char ch = c[i];
			int v = (int)(ch-'a');
			if((val & (1 << v)) > 0)
				return false;
			val = val | (1 << v);
		}
		return true;
	}
	
	public String replaceAllSpaces(String s) {
		char c[] = s.toCharArray();
		int e = s.length()-1, last = e;
		while(e >= 0 && c[e] == ' ') {
			e--;
		}
		
		for(int i=e; i>=0; i--) {
			if(c[i] == ' ') {
				c[last--] = '0';
				c[last--] = '2';
				c[last--] = '%';
			} else {
				c[last--] = c[i];
			}
		}
		
		return new String(c);
	}

}

class NodeLL {
	int val;
	public NodeLL(int val) {
		this.val = val;
	}
	NodeLL next;
}
