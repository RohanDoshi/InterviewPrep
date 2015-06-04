import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


public class BinaryTrees {

	public static void main(String[] args) {
		BinaryTrees trees = new BinaryTrees();
		BinaryNode<Character> node = trees.convertTernaryExpressionToTree("a?b?c:d:e");
		trees.preOrder(node);
		System.out.println();
		trees.inOrder(node);
		System.out.println("\n"+trees.minDepthBinaryTree(node));
		System.out.println("\n"+trees.minDepthUsingBFS(node));
		
		BinaryNode<Integer> bin = new BinaryNode<Integer>(1);
		bin.left = new BinaryNode<Integer>(2);
		bin.right = new BinaryNode<Integer>(3);
		bin.left.left = new BinaryNode<Integer>(9);
		bin.left.left.right = new BinaryNode<Integer>(10);
		bin.left.right = new BinaryNode<Integer>(6);
		bin.left.right.left = new BinaryNode<Integer>(11);
		bin.right.left = new BinaryNode<Integer>(4);
		bin.right.right = new BinaryNode<Integer>(5);
		bin.right.left.left = new BinaryNode<Integer>(12);
		bin.right.left.right = new BinaryNode<Integer>(7);
		
		trees.printDiagonalSums(bin);
		trees.printDiagonalSumsUsingQueue(bin);
		
		BinaryNode<Integer> anc = new BinaryNode<Integer>(1);
		anc.left = new BinaryNode<Integer>(2);
		anc.right = new BinaryNode<Integer>(3);
		anc.left.left = new BinaryNode<Integer>(4);
		anc.left.right = new BinaryNode<Integer>(5);
		anc.left.left.left = new BinaryNode<Integer>(8);
		anc.left.right.right = new BinaryNode<Integer>(9);
		anc.right.left = new BinaryNode<Integer>(6);
		anc.right.right = new BinaryNode<Integer>(7);
		anc.right.right.left = new BinaryNode<Integer>(10);
		trees.printAncestorsWithoutRecursion(anc, 10);
		
		
		BinaryNode<Integer> bst = new BinaryNode<Integer>(20);
		bst.left = new BinaryNode<Integer>(8);
		bst.right = new BinaryNode<Integer>(22);
		bst.left.left = new BinaryNode<Integer>(4);
		bst.left.right = new BinaryNode<Integer>(12);
		bst.left.right.left = new BinaryNode<Integer>(10);
		bst.left.right.right = new BinaryNode<Integer>(14);
		System.out.println("kth smallest...");
		System.out.println(trees.kThSmallestBT(bst, 3));
		System.out.println(trees.kThSmallestBT(bst, 5));
		
		BinaryNode<Integer> findNext = new BinaryNode<Integer>(10);
		findNext.left = new BinaryNode<Integer>(2);
		findNext.right = new BinaryNode<Integer>(6);
		findNext.left.left = new BinaryNode<Integer>(8);
		findNext.left.right = new BinaryNode<Integer>(4);
		//findNext.right.right = new BinaryNode<Integer>(5);
		
		trees.findNextNodeInSameLevel(findNext, 2);
		trees.findNextNodeInSameLevel(findNext, 6);
		trees.findNextNodeInSameLevel(findNext, 4);
		trees.findNextNodeInSameLevel(findNext, 8);
		trees.findNextNodeInSameLevel(findNext, 5);
		
		//trees.constructDLLFromLeaves(findNext);
		System.out.println(trees.isFullBinaryTree(findNext));
		
		BinaryNode<Integer> printDistRoot = new BinaryNode<Integer>(20);
		printDistRoot.left = new BinaryNode<Integer>(8);
		printDistRoot.right = new BinaryNode<Integer>(22);
		printDistRoot.left.left = new BinaryNode<Integer>(4);
		printDistRoot.left.right = new BinaryNode<Integer>(12);
		printDistRoot.left.right.left = new BinaryNode<Integer>(10);
		printDistRoot.left.right.right = new BinaryNode<Integer>(14);
		System.out.println("Print @ distance....");
		trees.printAllNodesAtDistanceK(printDistRoot, 8, 2);
		
	}
	
	public int printAllNodesAtDistanceK(BinaryNode<Integer> root, int fromNode, int distance) {
		if(root == null)
			return -1;
		
		if(root.value == fromNode) {
			printDown(root, 0, distance);
			return 0;
		}
		
		if(distance == 0) {
			System.out.print(root.value+" ");
			return -1;
		}
		
		int dl = printAllNodesAtDistanceK(root.left, fromNode, distance);
		if(dl != -1) {
			if(dl + 1 == distance) {
				System.out.print(root.value+" ");
			} else {
				printAllNodesAtDistanceK(root.right, fromNode, distance-dl-2);
			}
			return dl + 1;
		}
		
		int dr = printAllNodesAtDistanceK(root.right, fromNode, distance);
		if(dr != -1) {
			if(dr + 1 == distance) {
				System.out.print(root.value+" ");
			} else { 
				printAllNodesAtDistanceK(root.left, fromNode, distance-dr-2);
			}
			
			return dr + 1;
		}
		return -1;
	}
	
	private void printDown(BinaryNode<Integer> node, int currDistance, int distance) {
		if(node == null)
			return;
		
		if(distance == currDistance) {
			System.out.print(node.value+" ");
			return;
		}
		
		printDown(node.left, currDistance+1, distance);
		printDown(node.right, currDistance+1, distance);
	}
	
	public boolean isFullBinaryTree(BinaryNode<Integer> node) {
		if(node == null)
			return true;
	
		if(node.left == null && node.right == null)
			return true;
		
		if(node.left != null && node.right != null)
			return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
		
		return false;
	}
	
	public void constructDLLFromLeaves(BinaryNode<Integer> node) {
		List<BinaryNode<Integer>> list = new ArrayList<>();
		node = extractLeavesIntoDLL(node, list);
		System.out.println();
	}
	
	private BinaryNode<Integer> extractLeavesIntoDLL(BinaryNode<Integer> node, List<BinaryNode<Integer>> list) {
		if(node == null)
			return null;
		
		node.left = extractLeavesIntoDLL(node.left, list);
		if(node.left == null && node.right == null) {
			if(list.isEmpty()) {
				list.add(node);
			} else {
				BinaryNode<Integer> prev = list.get(list.size()-1);
				prev.right = node;
				node.left = prev;
				list.add(node);
			}
			return null;
		}
		node.right = extractLeavesIntoDLL(node.right, list);
		return node;
	}
	
	
	public void findNextNodeInSameLevel(BinaryNode<Integer> node, int key) {
		
		Queue<BinaryNode<Integer>> queue = new LinkedList<>();
		queue.add(node);
		queue.add(null);
		boolean keyFound = false;
		BinaryNode<Integer> next = null;
		
		while(queue.size() != 1) {
			BinaryNode<Integer> temp = queue.poll();
			if(keyFound) {
				next = temp;
				break;
			}
			if(temp == null) {
				queue.add(null);
				continue;
			}
			if(temp.value == key)
				keyFound = true;
			
			if(temp.left != null)
				queue.add(temp.left);
			
			if(temp.right != null)
				queue.add(temp.right);
			
		}
		if(keyFound)
			System.out.println("Next Node -->" +(next == null ? "Null" : next.value));
		else
			System.out.println("Key not found");
	}
	
	public int kThSmallestBT(BinaryNode<Integer> node, int k) {
		if(k <= 0)
			return Integer.MIN_VALUE;
		int[] rank = new int[1];
		BinaryNode<Integer> elem = kThSmallestBT(node, rank, k);
		if(elem != null)
			return elem.value;
		else
			return Integer.MIN_VALUE;
	}
	
	public BinaryNode<Integer> kThSmallestBT(BinaryNode<Integer> node, int[] rank, int k) { 
		if(node == null)
			return null;
		
		BinaryNode<Integer> left = kThSmallestBT(node.left, rank, k);
		if(left != null)
			return left;
		rank[0]++;
		if(rank[0] == k)
			return node;
		return kThSmallestBT(node.right, rank, k);
	}
	public void printAncestorsWithoutRecursion(BinaryNode<Integer> node, int val) {
		Stack<BinaryNode<Integer>> stack = new Stack<>();
		BinaryNode<Integer> temp = node;
		BinaryNode<Integer> prev = null;
		boolean flag = false;
		while(!flag) {
			while(temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			
			temp = stack.peek();
			if(temp.value == val) {
				while(stack.size() != 0) {
					System.out.print(stack.pop().value+" ");
				}
				flag = true;
			} else {
				if(temp.right == null || temp.right == prev) {
					prev = stack.pop();
					temp = null;
				} else
					temp = temp.right;
			}
		}
	}
	
	public void printDiagonalSumsUsingQueue(BinaryNode<Integer> node) {
		
		Queue<BinaryNode<Integer>> queue = new LinkedList<>();
		queue.add(node);
		queue.add(null);
		int sum = 0;
		while(queue.size()!=1) {
			BinaryNode<Integer> temp = queue.poll();
			if(temp == null) {
				System.out.println("sum --> "+sum);
				sum = 0;
				queue.add(null);
				continue;
			}
			while(temp != null) {
				sum = sum + temp.value;
				if(temp.left != null)
					queue.add(temp.left);
				temp = temp.right;
			}
		}
		
		if(sum != 0)
			System.out.println("sum --> "+sum);
			
	}
	
	
	public void printDiagonalSums(BinaryNode<Integer> node) {
		Map<Integer, Integer> map = new HashMap<>();
		printDiagonalSums(node, map, 1);
		for(int i=1; i<=map.size(); i++) {
			if(map.containsKey(i)) {
				System.out.println("dia ->"+i+" "+map.get(i));
			} else
				break;
		}
	}
	
	private void printDiagonalSums(BinaryNode<Integer> node, Map<Integer, Integer> map, int diagonal) {
		if(node == null)
			return;
		
		if(map.containsKey(diagonal)) {
			int sum = map.get(diagonal);
			sum = sum + node.value;
			map.put(diagonal, sum);
		} else {
			map.put(diagonal, node.value);
		}
		
		printDiagonalSums(node.left, map, diagonal+1);
		printDiagonalSums(node.right, map, diagonal);
	}
	
	public int minDepthUsingBFS(BinaryNode<Character> node) {
		if(node == null)
			return 0;
		
		Queue<BinaryNode<Character>> queue = new LinkedList<BinaryNode<Character>>();
		queue.add(node);
		queue.add(null);
		int depth=0;
		while(queue.size() != 1) {
			
			BinaryNode<Character> poll = queue.poll();
			if(poll == null) {
				depth++;
				queue.add(null);
				continue;
			}
			
			if(poll.left == null && poll.right == null)
				return depth;
			
			if(poll.left != null)
				queue.add(poll.left);
			
			if(poll.right != null)
				queue.add(poll.right);
			
		}
		
		return depth;
	}
	
	public int minDepthBinaryTree(BinaryNode<Character> root) {
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return 1;
		
		return 1 + Math.min(minDepthBinaryTree(root.left),minDepthBinaryTree(root.right));
	}
	
	public int  depth(BinaryNode<Character> node) {
		if(node == null)
			return 0;
		
		return 1 + Math.max(depth(node.left), depth(node.right));
	}
	
	public void inOrder(BinaryNode<Character> node) {
		if(node == null)
			return;
		
		inOrder(node.left);
		System.out.print(node.value+" ");
		inOrder(node.right);
	}
	
	public void preOrder(BinaryNode<Character> node) {
		if(node == null)
			return;
		
		System.out.print(node.value+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public BinaryNode<Character> convertTernaryExpressionToTree(String exp) {
		return convertTernaryExpressionToTree(new Stack<BinaryNode<Character>>(), exp.toCharArray(), 0);
	}
	
	private BinaryNode<Character> convertTernaryExpressionToTree(Stack<BinaryNode<Character>> stack, char[] c, int i) {
		if(i >= c.length)
			return null;
		
		BinaryNode<Character> node = new BinaryNode<Character>(c[i]);

		if(i+1 < c.length) {
			if(c[i+1] == '?') {
				stack.push(node);
				BinaryNode<Character> parent = stack.peek();
				parent.left = convertTernaryExpressionToTree(stack, c, i+2);
			} else if(c[i+1] == ':') {
				BinaryNode<Character> parent = stack.pop();
				parent.right = convertTernaryExpressionToTree(stack, c, i+2);
			}
		}
		return node;
		
	}

}


class BinaryNode<T> { 
	public BinaryNode(T value) {
		this.value = value;
	}
	BinaryNode<T> left;
	BinaryNode<T> right;
	T value;
}