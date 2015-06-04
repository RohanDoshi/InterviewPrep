package killit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BinaryTrees {

	public static void main(String[] args) {
		Node root1 = new Node('a');
		root1.left = new Node('b');
		root1.left.parent = root1;
		root1.right = new Node('c');
		root1.right.parent = root1;
		root1.left.left = new Node('d');
		root1.left.left.parent = root1.left;
		root1.right.left = new Node('e');
		root1.right.left.parent = root1.right;
		root1.right.right = new Node('f');
		root1.right.right.parent = root1.right;
		Node lcaNode = lcaParentConstantMemory(root1, 'e', 'd');
		System.out.println("e, d => " + lcaNode.value);
		lcaNode = lcaParentConstantMemory(root1, 'e', 'f');
		System.out.println("e, f => " + lcaNode.value);
		lcaNode = lcaParentConstantMemory(root1, 'e', 'c');
		System.out.println("e, c => " + lcaNode.value);
		lcaNode = lcaParentConstantMemory(root1, 'e', 'z');
		System.out.println("e, z => " + (lcaNode == null ? "null" : lcaNode.value));
		
		Node root2 = new Node('j');
		root2.left = new Node('h');
		root2.left.parent = root2;
		
		Node[] forest = {root1, root2};
		lcaNode = lcaForest(forest, 'e', 'z');
		System.out.println("e, z => " + (lcaNode == null ? "null" : lcaNode.value));
		
		BinaryNode binaryNode = new BinaryNode(1);
		binaryNode.left = new BinaryNode(2);
		binaryNode.right = new BinaryNode(3);
		binaryNode.left.left = new BinaryNode(4);
		binaryNode.left.right = new BinaryNode(5);
		binaryNode.right.left = new BinaryNode(6);
		binaryNode.right.right = new BinaryNode(7);
		binaryNode.right.right.right = new BinaryNode(8);
		binaryNode.right.right.right.right = new BinaryNode(9);
		binaryNode.left.left.left = new BinaryNode(10);
		binaryNode.left.left.left.left = new BinaryNode(11);
		binaryNode.left.left.left.left.left = new BinaryNode(12);
		binaryNode.left.right.right = new BinaryNode(51);
		binaryNode.left.right.right.right = new BinaryNode(52);
		binaryNode.left.right.right.right.right = new BinaryNode(53);
		binaryNode.left.right.right.right.right.right = new BinaryNode(54);
		binaryNode.left.right.right.right.right.right.right = new BinaryNode(55);
		binaryNode.left.right.right.right.right.right.right.right = new BinaryNode(56);
		binaryNode.left.right.right.right.right.right.right.right.right = new BinaryNode(57);
		
		int[] totalSum = {0};
		sumOfPath(binaryNode, 0, new ArrayList<Integer>(), totalSum);
		System.out.println(totalSum[0]);
		printTreeLevelByLevel(binaryNode);
		System.out.println();
		printTreeLevelByLevelUsingCount(binaryNode);
		int ages[] = {8,8,8,9,9,11,15,16,16,16} ;
		numOfOccurencesOfAge(ages);
		printLikeATree(binaryNode);
		System.out.println("diameter ="+ diameterTree(binaryNode));
		int[] dia = new int[1];
		diameterTreeEfficient(binaryNode, dia);
		System.out.println("diameter --> "+dia[0]);
		
		BinaryNode colNode = new BinaryNode(8);
		colNode.left = new BinaryNode(6);
		colNode.right = new BinaryNode(10);
		colNode.left.left = new BinaryNode(4);
		colNode.left.right = new BinaryNode(7);
		colNode.left.left.left = new BinaryNode(3);
		colNode.left.left.right = new BinaryNode(5);
		colNode.right.left = new BinaryNode(9);
		colNode.right.right = new BinaryNode(12);
		
		printTreeColumnWise(colNode);
		printLevelOrder(colNode);
		System.out.println();
		System.out.println("------ using count var-------");
		printLevelOrderCount(colNode);
		System.out.println("----- print node to leaf paths-----");
		printPathsNodeToLeaf(colNode);
		printNodesAtDistanceKFromRoot(colNode, 2);
		
		List<LinkedNode> res = linkedListAtEachDepth(colNode);
		for(int i=0; i<res.size(); i++) {
			System.out.println(i);
			LinkedNode no = res.get(i);
			while(no != null) {
				System.out.print(no.value+" ");
				no = no.next;
			}
			System.out.println();
		}
		
		
		BinaryNode bst = new BinaryNode(9);
		bst.right = new BinaryNode(9);
		System.out.println(isBST(bst));
		System.out.println(isBSTCorrect(bst));
		System.out.println(isSubtree(colNode, colNode.left.right));
		printAllPathsSumTo(colNode, 10);
	}
	
	////////////////////////////////////////////// PRACTICE ////////////////////////////////////////
	
	
	public static void printAllPathsSumTo(BinaryNode node, int sum) {
		if(node == null)
			return;
		
		List<Integer> list = new ArrayList<>();
		printAllPathsSumTo(node, sum, list);
	}
	
	private static void printAllPathsSumTo(BinaryNode node, int sum, List<Integer> list) {
		if(node == null)
			return;
		
		
		list.add(node.digit);
		int t = 0;
		for(int i=list.size()-1; i>=0; i--) {
			t = t+list.get(i);
			if(t == sum) {
				printList(list, i, list.size()-1);
			}
		}
		printAllPathsSumTo(node.left, sum, list);
		printAllPathsSumTo(node.right, sum, list);
		list.remove(list.size()-13);
	}
	
	public static void printList(List<Integer> list, int from, int to) {
		System.out.print("[");
		for(int i=from; i<=to; i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println("]");
	}
	
	public static boolean isSubtree(BinaryNode node1, BinaryNode node2) {
		if(node1 == null || node2 == null)
			return false;
		
		boolean match = isSubtree(node1.left, node2);
		if(match)
			return true;
		
		if(node1.digit == node2.digit) {
			match = checkExactMatch(node1, node2);
			if(match)
				return true;
		}
		
		return isSubtree(node1.right, node2);
	}
	
	public static boolean checkExactMatch(BinaryNode node1, BinaryNode node2) {
		if(node1 == null && node2 == null)
			return true;
		
		if(node1 == null || node2 == null)
			return false;
		
		if(node1.digit == node2.digit) {
			return checkExactMatch(node1.left, node2.left) && checkExactMatch(node1.right, node2.right);
		} else {
			return false;
		}
	}
	
	
	
	public BinaryNode inOrderSucc(BinaryNode node) {
		if(node == null)
			return null;
		
		if(node.right != null) {
			BinaryNode temp = node.right;
			while(temp.left != null)
				temp = temp.left;
			return temp;
		} else {
			BinaryNode temp = node;
			BinaryNode par = temp.parent;
			while(par != null && par.right == temp) {
				temp = par;
				par = par.parent;
			}
			return par;
		}
		
	}
	
	public static boolean isBSTCorrect(BinaryNode node) {
		if(node == null)
			return true;
		
		boolean b[] = new boolean[1];
		b[0] = true;
		isBSTCorrect(node, b);
		return b[0];
	}
	
	private static int isBSTCorrect(BinaryNode node, boolean b[]) {
		if(node == null)
			return -1;
		
		int left = Integer.MIN_VALUE;
		int right = Integer.MAX_VALUE;
		if(node.left != null)
			left = isBSTCorrect(node.left, b);
		if(node.right != null)
			right = isBSTCorrect(node.right, b);
		
		if(node.digit >= left && node.digit < right) 
			b[0] = b[0] & true;
		else
			b[0] = false;
		
		return (node.left == null && node.right == null) || (node.right == null)  ? node.digit : right;
	}
	
	public static boolean isBST(BinaryNode node) {
		if(node == null)
			return true;
		return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean isBST(BinaryNode node, int min, int max) {
		if(node == null)
			return true;
		
		boolean left = isBST(node.left, min, node.digit);
		boolean right = isBST(node.right, node.digit, max);
		if(left && right) {
			if(node.digit >= min && node.digit < max)
				return true;
			else
				return false;
		} else {
			return false;
		}
	}
	
	public static List<LinkedNode> linkedListAtEachDepth(BinaryNode node) {
		if(node == null)
			return new ArrayList<>();
			
		List<LinkedNode> list = new ArrayList<>();
		linkedListAtEachDepth(node, 0, list);
		return list;
	}
	
	public static void linkedListAtEachDepth(BinaryNode node, int depth, List<LinkedNode> list) { 
		if(node == null)
			return;
		
		if(list.size() == depth) {
			list.add(new LinkedNode(node.digit));
		} else {
			LinkedNode noo = list.get(depth);
			while(noo.next != null)
				noo = noo.next;
			noo.next = new LinkedNode(node.digit);
		}
		linkedListAtEachDepth(node.left, depth+1, list);
		linkedListAtEachDepth(node.right, depth+1, list);
	}
	
	public boolean isHeightBalanced(BinaryNode node) {
		boolean b[] = new boolean[1];
		b[0] = true;
		isHeightBalancedCheck(node, b);
		return b[0];
	}
	
	private int isHeightBalancedCheck(BinaryNode node, boolean b[]) {
		if(node == null)
			return 0;
		
		int left = isHeightBalancedCheck(node.left, b);
		int right = isHeightBalancedCheck(node.right, b);
		
		if(Math.abs(left-right) > 1)
			b[0] = false;
		else
			b[0] = b[0] & true;
		
		return 1 + Math.max(left, right);
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void printNodesAtDistanceKFromRoot(BinaryNode node, final int k) {
		printNodesAtDistanceKFromRoot(node, 0, k);
	}
	
	
	public static void printNodesAtDistanceKFromRoot(BinaryNode node, int currDistance, final int k) {
		if(node == null)
			return;
		
		if(currDistance == k) {
			System.out.println(node);
			return;
		}
		
		printNodesAtDistanceKFromRoot(node.left, currDistance+1, k);
		printNodesAtDistanceKFromRoot(node.right, currDistance+1, k);
	}
	
	
	public static void printPathsBetweenTwoLeaves(BinaryNode node) {
		
	}
	
	public static void printPathsNodeToLeaf(BinaryNode node) {
		if(node == null)
			return;
		printPathsNodeToLeaf(node, new ArrayList<BinaryNode>());
		
	}
	
	private static void printPathsNodeToLeaf(BinaryNode node, List<BinaryNode> list) {
		if(node == null)
			return;
		
		if(node.left == null && node.right == null)
		{
			list.add(node);
			System.out.println(Arrays.toString(list.toArray()));
			list.remove(list.size()-1);
			return;
		}
		
		list.add(node);
		printPathsNodeToLeaf(node.left, list);
		printPathsNodeToLeaf(node.right, list);
		list.remove(list.size()-1);
	}
	
	
	public static void printLevelOrderCount(BinaryNode node) {
		if(node == null) 
			return;
		
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(node);
		int count = 1;
		
		while(queue.size() != 0) {
			if(count == 0) {
				System.out.println();
				count = queue.size();
			}
			
			BinaryNode n = queue.poll();
			System.out.print(n.digit+" ");
			count--;
			
			if(n.left != null)
				queue.add(n.left);
			
			if(n.right != null)
				queue.add(n.right);
		}
	}
	
	public static void printLevelOrder(BinaryNode node) {
		if(node == null) 
			return;
		
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(node);
		queue.add(null);
		while(queue.size() != 1) {
			BinaryNode n = queue.poll();
			if(n == null) {
				System.out.println();
				queue.add(null);
				continue;
			}
			System.out.print(n.digit+" ");
			if(n.left != null)
				queue.add(n.left);
			
			if(n.right != null)
				queue.add(n.right);
			
		}
		
	}
	
	
	static void printTreeColumnWise(BinaryNode node) {
		Map<Integer,Stack<Integer>> map = new HashMap<>();
		int col[] = new int[1];
		printTreeColumnWise(node, map, 0);
		for(int i=1; i<= map.size(); i++) {
			System.out.println(Arrays.toString(map.get(i).toArray()));
		}
	}
	
	private static int printTreeColumnWise(BinaryNode node, Map<Integer,Stack<Integer>> map, int col) {
		if(node == null)
			return col;
		
		int prevCol = 0;
		if(col == 0)
			prevCol = printTreeColumnWise(node.left, map, col);
		else
			prevCol = printTreeColumnWise(node.left, map, col-1);
		
		col = prevCol + 1;
		if(map.containsKey(col)) {
			Stack<Integer> stack = map.get(col);
			stack.push(node.digit);
		} else {
			Stack<Integer> stack = new Stack<>();
			stack.push(node.digit);
			map.put(col, stack);
		}
		
		prevCol = printTreeColumnWise(node.right, map, col+1);
		return prevCol - 1;
		
	}
	
	static int diameterTree(BinaryNode node) {
		if(node == null)
			return 0;
		
		int leftDia = diameterTree(node.left);
		int rightDia = diameterTree(node.right);
		
		int ldepth = depth(node.left);
		int rdepth = depth(node.right);
		int numOfNodes = 1 + ldepth + rdepth;
		return Math.max(Math.max(leftDia, rightDia), numOfNodes);
		
	}
	
	
	static int diameterTreeEfficient(BinaryNode node, int[] maxDia) {
		if(node == null)
			return 0;
		
		int leftHeight = diameterTreeEfficient(node.left, maxDia);
		int rightHeight = diameterTreeEfficient(node.right, maxDia);
		
		int dia = leftHeight + rightHeight + 1;
		if(dia > maxDia[0])
			maxDia[0] = dia;
		
		return Math.max(leftHeight, rightHeight)+1;
		
	}
	
	static void printTreeLevelByLevelUsingCount(BinaryNode node) {
		if(node == null)
			return ;
		
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(node);
		int count = 1;
		while(queue.size() != 0) {
			if(count == 0) {
				count = queue.size();
				System.out.println();
			}
			BinaryNode temp = queue.poll();
			System.out.print(temp.digit+" ");
			count--;
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null) {
				queue.add(temp.right);
			}
		}
	}
	
	// O(logn) algo
	static void numOfOccurencesOfAge(int ages[]) {
		int count[] = new int[ages[ages.length-1]+1];
		countNumOfOccurences(count, ages, 0, ages.length-1);
		System.out.println(Arrays.toString(count));
	}
	
	private static void countNumOfOccurences(int count[], int arr[], int start, int end) {
		
		if(arr[start] == arr[end]) {
			count[arr[start]] += end - start + 1;
		} else {
			countNumOfOccurences(count, arr, start, (start+end)/2);
			countNumOfOccurences(count, arr, (start+end)/2+1, end);
		}
		
	}
	
	static String SPACE = " ";
	
	static int depth(BinaryNode node) {
		if(node == null)
			return 0;
		
		return 1 + Math.max(depth(node.left), depth(node.right));
	}
	
	static void printLikeATree(BinaryNode node)  {
		int depth = depth(node);
		System.out.println();
		printLikeATree(node, depth);
	}
	
	static void printLikeATree(BinaryNode node, int depth) {
		if(node == null)
			return;
		
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(node);
		int currentLevel = 0;
		int spaces = depth - currentLevel;
		while(spaces > 0) {
			System.out.print(SPACE);
			spaces--;
		}
		int count = 1; 
		
		while(queue.size() != 0) {
			if(count == 0) {
				count = queue.size();
				System.out.println();
				depth--;
				currentLevel++;
				spaces = depth - currentLevel;
				while(spaces > 0) {
					System.out.print(SPACE);
					spaces--;
				}
				
			} 
			
			BinaryNode temp = queue.poll();
			if(temp == null)
				System.out.print(SPACE);
			else {
				System.out.print(temp.digit+SPACE);
				queue.add(temp.left);
				queue.add(temp.right);
			}
			count--;
			
		}
	}
	
	static void printTreeLevelByLevel(BinaryNode node) {
		if(node == null)
			return;
		
		Queue<BinaryNode> queue= new LinkedList<>();
		queue.add(node);
		queue.add(null);
		while(queue.size() != 1) {
			BinaryNode temp = queue.poll();
			if(temp == null) {
				System.out.println();
				queue.add(null);
			}
			else { 
				System.out.print(temp.digit+" ");
				if(temp.left != null)
					queue.add(temp.left);
				if(temp.right != null)
					queue.add(temp.right);
			}
		}
	}
	
	static void sumOfPath(BinaryNode root, int level, List<Integer> pathSum, int[] totalSum ) {
		if(root == null) {
			return;
		}
		
		if(root.left == null && root.right == null) {
			pathSum.add(root.digit);
			int pow = pathSum.size();
			int sum =0;
			for(int i=0; i<pathSum.size(); i++) {
				sum = sum + (int)(pathSum.get(i) * Math.pow(10, pow-1));
				pow--;
			}
			totalSum[0] = totalSum[0] + sum;
			pathSum.remove(pathSum.size()-1);
		} else {
			pathSum.add(root.digit);
			sumOfPath(root.left, level+1, pathSum, totalSum);
			sumOfPath(root.right, level+1, pathSum, totalSum);
			pathSum.remove(pathSum.size()-1);
		}
			
	}
 	
	// using parent pointer and O(1) memory
	static Node lcaParentConstantMemory(Node root, char c1, char c2) {
		
		if(root == null)
			return null;
		
		Node c1Node = findNode(root, c1);
		Node c2Node = findNode(root, c2);
		
		if(c1Node == null || c2Node == null)
			return null;
		
		int c1Depth = depth(root, c1);
		int c2Depth = depth(root, c2);
		while(c1Depth > c2Depth) {
			c1Node = c1Node.parent;
			c1Depth--;
		}
		
		while(c2Depth > c1Depth) {
			c2Node = c2Node.parent;
			c2Depth--;
		}
		
		while(c1Node != c2Node) {
			c1Node = c1Node.parent;
			c2Node = c2Node.parent;
		}
		
		return c1Node;
		
		
	}
	
	static int depth(Node root, char c) {
		if(root == null)
			return 0;
		
		if(root.value == c)
			return 1; 
		
		int leftDepth = depth(root.left, c);
		if(leftDepth != 0)
			return leftDepth + 1;
		
		int rightDepth = depth(root.right, c);
		if(rightDepth != 0)
			return rightDepth + 1;
		
		return 0;
	}
	
	// using parent pointer and enough memory
	static Node lcaParent(Node root, char c1, char c2) {
		if(root == null)
			return null;
		
		Node c1Node = findNode(root, c1);
		Node c2Node = findNode(root, c2);
		
		if(c1Node == null || c2Node == null)
			return null;
		
		Set<Node> pathToParent = new HashSet<>();
		while(c1Node != null) {
			pathToParent.add(c1Node);
			c1Node = c1Node.parent;
		}
		
		Node lca = null;
		while(c2Node != null) {
			if(pathToParent.contains(c2Node))
			{
				lca = c2Node;
				break;
			}
			c2Node = c2Node.parent;
		}
		return lca;
	}
	
	static Node findNode(Node root, char c) {
		if(root == null)
			return null;
		
		if(root.value == c)
			return root;
		
		Node left =  findNode(root.left, c) ;
		return left != null ? left : findNode(root.right, c);
	}
	
	// without parent pointer
	static Node lcaForest(Node[] forest, char c1, char c2) {
		Node res = null;
		for(Node node : forest) {
			res = lcaComplete(node, c1, c2);
			if(res != null)
				return res;
		}
		
		return null;
	}
	
	
	
	
	// without parent pointer
	static Node lcaComplete(Node root, char c1, char c2) {
		
		if(isNodeExists(root, c1) && isNodeExists(root, c2)) {
			return lca(root, c1, c2);
		}
		
		return null;
	}
	
	static Node lca(Node root, char c1, char c2) {
		
		if(root == null)
			return null;
		
		if(root.value == c1 || root.value == c2 )
			return root;
		
		Node left = lca(root.left, c1, c2);
		Node right = lca(root.right, c1, c2);
		
		if(left == null && right == null)
			return null;
		
		if(left != null && right != null)
			return root;
		
		if(left != null)
			return left;
		
		if(right != null)
			return right;
		
		return null;
		
	}
	
	static boolean isNodeExists(Node root, char c) {
		if(root == null)
			return false;
		
		if(root.value == c) 
			return true;
		
		return isNodeExists(root.left, c) || isNodeExists(root.right, c);
	}

}

class Node {
	Node parent;
	Node left;
	Node right;
	char value;
	public Node(char value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		Node temp = this;
		while(temp.right != this) {
			System.out.println(temp.value);
			temp = temp.right;
		}
		return "";
	}
}

class BinaryNode  { 
	BinaryNode left;
	BinaryNode right;
	BinaryNode parent;
	int digit;
	public BinaryNode(int digit) {
		this.digit = digit;
	}
	
	@Override
	public String toString() {
		return String.valueOf(digit);
	}
}