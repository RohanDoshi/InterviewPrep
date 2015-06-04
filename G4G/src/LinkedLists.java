


public class LinkedLists<T> {
	

	private class Result<T> { 
		Node<T> resNode;
		boolean res;
		public Result(Node<T> resNode, boolean res) {
			this.res = res;
			this.resNode = resNode;
		}
	}
	
	private class Palindrome<T> {
		Node<T> start;
		Node<T> end;
		int len;
		public Palindrome(Node<T> start, Node<T> end, int len) {
			this.start = start;
			this.end = end;
			this.len = len;
		}
	}
	
	public static void main(String[] args) {
		
		LinkedLists<Integer> ll = new LinkedLists<>();
		
		Node<Integer> node = new Node<Integer>(1);
		node.next = new Node<Integer>(2);
		node.next.next = new Node<Integer>(3);
		node.next.next.next = new Node<Integer>(4);
		node.next.next.next.next = new Node<Integer>(5);
		node.next.next.next.next.next = new Node<Integer>(6);
		node.next.next.next.next.next.next = new Node<Integer>(7);
		
//		System.out.println(ll.isLinkedListPalindrome(node));
//		
//		Node<Integer> reverseNode = ll.createNewReversedLinkedList(node);
//		node.print();
//		reverseNode.print();
//		System.out.println("lcs ==>"+ll.findLongestPalindromeIncorrect(node));
//		System.out.println("longest palin =>"+ll.longestPalindromeCorrectButInefficient(node));
		
//		Node<Integer> newList = ll.deleteNodesWithValKRecursive(node, 2);
		Node<Integer> rev = ll.reverseLinkedListPracticeIter(node);
		ll.print(rev);
	}
	
	public Node<Integer> reverseLinkedListPractice(Node<Integer> node) {
		if(node == null)
			return null;
		
		if(node.next == null)
			return node; // head
		
		Node<Integer> next = node.next;
		node.next = null;
		Node<Integer> head = reverseLinkedListPractice(next);
		next.next = node;
		return head;
	}
	
	public Node<Integer> reverseLinkedListPracticeIter(Node<Integer> node) {
		if(node == null)
			return null;
		
		Node<Integer> head = node;
		Node<Integer> next = node.next;
		head.next = null;
		while(next != null) {
			Node nextNext = next.next;
			next.next = head;
			head = next;
			next = nextNext;
		}
		
		return head;
	}
	
	
	public void print(Node<T> node) {
		while(node != null) {
			System.out.print(node.value+" ");
			node = node.next;
		}
	}
	
	
	public Node<T> deleteNodesWithValKRecursive(Node<T> node, int k) {
		if(node == null)
			return null;
		
		if(node.value.equals(k)) {
			node = deleteNodesWithValK(node.next, k);
		} else {
			node.next = deleteNodesWithValK(node.next, k);
		}
		
		return node;
	}
	
	// 2 2 3 9 2 1
	public Node<T> deleteNodesWithValK(Node<T> node, int k) {
		Node<T> prev = null;
		Node<T> curr = node;
		
		while(curr != null) {
			while(curr != null && curr.value.equals(k))
				curr = curr.next;
			
			if(prev == null && curr == null)
				return null;
			
			if(curr == null) {
				prev.next = null;
				return node;
			}
			
			if(prev == null) {
				node = curr;
				prev = curr;
			} else {
				prev.next = curr;
				prev = curr;
			}
			curr = curr.next;
		}
		
		return node;
	}
	
	public String longestPalindromeCorrectButInefficient(Node<T> node) {
		if(node == null)
			return "";
		int len = node.length();
		int i =1;
		String max = "";
		while(node != null) {
			i = 1;
			len = node.length();
			while(i <= len) {
				if(isLinkedListPalindrome(node,i).res) {
					String s = toString(node,i);
					if(s.length() > max.length())
						max = s;
				}
				i++;
			}
			node = node.next;
		}
		
		return max;
	}
	
	
	private String toString(Node<T> node, int len) {
		if(node == null)
			return "";
		
		StringBuilder sb = new StringBuilder();
		
		while(len > 0 && node != null) {
			sb.append(node.value);
			node= node.next;
			len--;
		}
		
		return sb.toString();
	}
	
	// Longest commong substring does not give the longest palindrome
	// Ex: 123421, 124321, lcs => 12 or 21..either of which are not palindromes
	public String findLongestPalindromeIncorrect(Node<T> node) {
		
		if(node == null)
			return "";
		
		Node<T> reveredList = createNewReversedLinkedList(node);
		return findLongestCommonSubstringLinkedLists(node, reveredList);
		
	}
	
	
	public String findLongestCommonSubstringLinkedLists(Node<T> node1, Node<T> node2) {
		if(node1 == null || node2 == null)
			return "";
		
		String s1="", s2 = "", s3 = "";
		if(node1.value.equals(node2.value)) {
			s1 = node1.value + findMaxContiguousMatch(node1.next, node2.next);
		}
		s2 = findLongestCommonSubstringLinkedLists(node1.next, node2);
		s3 = findLongestCommonSubstringLinkedLists(node1, node2.next);
		
		
		if(s1.length() >= s2.length() && s1.length() >= s3.length())
			return s1; 
		
		if(s2.length() >= s1.length() && s2.length() >= s3.length())
			return s2; 
		
		if(s3.length() >= s1.length() && s3.length() >= s2.length())
			return s3;
		
		return "";
		
	}
	
	private String findMaxContiguousMatch(Node<T> node1, Node<T> node2) {
		StringBuilder sb = new StringBuilder();
		while(node1 != null && node2 != null) {
			if(node1.value.equals(node2.value))
				sb.append(node1.value);
			else
				break;
			node1 = node1.next;
			node2 = node2.next;
		}
		
		return sb.toString();
	}
	
	public Node<T> createNewReversedLinkedList(Node<T> node) {
		return createNewReversedLinkedList(node, null);
		
	}
	
	
	public Node<T> createNewReversedLinkedList(Node<T> node, Node<T> prev) { 
		if(node == null)
			return prev;
		
		if(node.next == null) {
			Node<T> head = new Node<T>(node.value);
			head.next = prev;
			return head;
		}
		
		Node<T> newNode = new Node<T>(node.value);
		Node<T> head = createNewReversedLinkedList(node.next, newNode);
		newNode.next = prev;
		return head;
		
	}
	
	public Node<T> reverseLinkedList(Node<T> node) {
		if(node == null)
			return null;
		
		if(node.next == null)
			return node;
		
		Node<T> next = node.next;
		node.next = null;
		Node<T> head = reverseLinkedList(next);
		next.next = node;
		return head;
	}
	
	
	public boolean isLinkedListPalindrome(Node<T> node) {
		if(node == null)
			return false;
		
		Result<T> result =  isLinkedListPalindrome(node, node.length());
		return result.res;
	}
	
	private Result<T> isLinkedListPalindrome(Node<T> node, int len) {
		
		if(len <= 0)
			return new Result<>(null, true);
			
		if(len == 1)
			return new Result<>(node.next, true);
			
		if(len == 2)
			return new Result<>(node.next.next, node.value.equals(node.next.value));
		
		Result<T> r = isLinkedListPalindrome(node.next, len-2);
		if(r.resNode == null || !r.res)
			return new Result<>(null, false);
		
		if(node.value.equals(r.resNode.value))
			return new Result<>(r.resNode.next, true);
		
		return new Result<>(node, false);
	}
	
	

}



class Node<T> {
	Node<T> next;
	T value;
	public Node(T value) {
		this.value = value;
	}
	
	public int length() {
		Node<T> curr = this;
		int count = 0;
		while(curr != null) {
			count++;
			curr = curr.next;
		}
		return count;
	}
	
	public void print() {
		System.out.println();
		Node<T> curr = this;
		while(curr != null) {
			System.out.print(curr.value+" ");
			curr = curr.next;
		}
		System.out.println();
	}
}