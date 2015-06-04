package killit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreesGraphs {

	public static void main(String[] args) {
		
		TreesGraphs tg = new TreesGraphs();
		
		Tree node = new Tree(1);
		node.left = new Tree(2);
		node.right = new Tree(3);
		node.left.left = new Tree(4);
		node.left.right = new Tree(5);
		node.left.left.left = new Tree(8);
		
		Tree node1 = new Tree(1);
		node1.left = new Tree(2);
		node1.right = new Tree(3);
		node1.left.left = new Tree(4);
		node1.left.right = new Tree(5);
		node1.right.left = new Tree(6);
		node1.left.left.left = new Tree(7);
		
		System.out.println(tg.isTreeHeighBalanced(node));
		System.out.println(tg.isTreeHeighBalanced(node1));
		System.out.println(!(tg.isTreeHeightBalancedSmart(node) == -1));
		System.out.println(!(tg.isTreeHeightBalancedSmart(node1) == -1));
		tg.createListAtEachDepth(node);
		System.out.println("******************");
		tg.createListAtEachDepth(node1);
		int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		System.out.println("******************");
		tg.createListAtEachDepth(tg.constructFullBinaryTree(arr));
		System.out.println(tg.isTreeBST(tg.constructFullBinaryTree(arr)));
		System.out.println(tg.isTreeBST(node1));
		tg.findNextNode(tg.constructFullBinaryTree(arr), 3);
		
		Tree anyPathSumTree = new Tree(7);
		anyPathSumTree.left = new Tree(5);
		anyPathSumTree.right = new Tree(12);
		anyPathSumTree.left.left = new Tree(3);
		anyPathSumTree.left.right = new Tree(6);
		anyPathSumTree.left.left.left= new Tree(1);
		anyPathSumTree.left.left.right = new Tree(4);
		anyPathSumTree.right.left = new Tree(9);
		anyPathSumTree.right.right = new Tree(15);
		anyPathSumTree.right.left.left = new Tree(8);
		anyPathSumTree.right.left.right = new Tree(10);
		anyPathSumTree.right.right.left = new Tree(13);
		anyPathSumTree.right.right.right = new Tree(17);
		
		tg.printAllPathsSumToAValue(anyPathSumTree, 12);
	}
	
	
	public void printAllPathsSumToAValue(Tree tree, int value) {
		if(tree == null)
			return;
		printAllPathsSumToAValue(tree.left, value);
		List<Tree> list = new ArrayList<>();
		list.add(tree);
		printAllPathsSumToAValue(tree, list, tree.val, value);
		printAllPathsSumToAValue(tree.right, value);
	}
	
	private void printAllPathsSumToAValue(Tree root, List<Tree> path, int sumSoFar, int val) {
		if(root == null)
			return;
		
		if(sumSoFar == val) {
			System.out.println(Arrays.toString(path.toArray()));
			return;
		}
			
		if(root.left != null) {
			path.add(root.left);
			printAllPathsSumToAValue(root.left, path, sumSoFar + root.left.val, val); // currRoot to left
			path.remove(path.size()-1);
		}
		if(root.right != null) {
			path.add(root.right);
			printAllPathsSumToAValue(root.right, path, sumSoFar + root.right.val, val); // currRoot to right
			path.remove(path.size()-1);
		}
		
		
	}
	
	public boolean isSubtree(Tree large, Tree sub) {
		if(large == null)
			return false;
		
		if(sub == null)
			return true;
		
		if(large.val == sub.val) {
			if(match(large, sub))
				return true;
		}
		
		return isSubtree(large.left, sub) || isSubtree(large.right, sub);
	}
	
	private boolean match(Tree t1, Tree t2) {
		if(t1 == null && t2 == null)
			return true;
		
		if(t1 == null || t2 == null)
			return false;
		
		return t1.val == t2.val && match(t1.left, t2.left) && match(t1.right, t2.right);
	}
	
	public Tree lca(Tree root, int n1, int n2) {
		boolean b1[] = new boolean[1];
		boolean b2[] = new boolean[1];
		
		Tree lca = lca(root, n1, n2, b1, b2);
		if(b1[0] && b2[0] || b1[0] &&  isExists(root, n2) || b2[0] && isExists(root, n1))
			return lca;
		
		else
			return null;
	}
	
	public boolean isExists(Tree root, int n) {
		if(root == null)
			return false;
		
		if(root.val == n)
			return true;
		
		return isExists(root.left, n) || isExists(root.right, n);
	}
	
	public Tree lca(Tree root, int n1, int n2, boolean[] b1, boolean[] b2) {
		if(root == null)
			return null;
		
		if(root.val == n1) {
			b1[0] = true;
			return root;
		}
		
		if(root.val == n2) {
			b2[0] = true;
			return root;
		}
		
		Tree left = lca(root.left, n1, n2, b1, b2);
		Tree right = lca(root.right, n1, n2, b1, b2);
		
		if(left != null && right != null)
			return root;
		
		return left != null ? left : right;
		
	}
	
	
	public void findNextNode(Tree root, int val) {
		Tree[] prev = new Tree[1];
		Tree next = findNextNode(root, val, prev);
		System.out.println("Next ---> "+(next != null ? next.val : "null"));
	}
	
	public Tree findNextNode(Tree root, int val, Tree[] prev) {
		if(root == null)
			return null;
		
		Tree left = findNextNode(root.left, val, prev);
		if(prev[0] == null) {
			prev[0] = root;
		} else {
			if(prev[0].val == val) {
				return root;
			} else {
				prev[0] = root;
			}
		}
		if(left == null)
			return findNextNode(root.right, val, prev);
		else
			return left;
	}
	
	public boolean isTreeBST(Tree node) {
		return isTreeBST(node, null);
	}
	
	public boolean isTreeBST(Tree node , int[] prev) {
		if(node == null)
			return true;
		
		boolean left = isTreeBST(node.left, prev);
		if(prev == null) {
			prev = new int[1];
		} else {
			if(node.val < prev[0]) 
				return false;
		}	
		prev[0] = node.val;
		
		if(left)
			return isTreeBST(node.right, prev); 
		else
			return false;
		
	}
	
	public void createListAtEachDepth(Tree tree) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		createListAtEachDepth(tree, map, 1);
		for(int j=1; ; j++) {
			if(!map.containsKey(j))
				break;
			for(int i=0; i<map.get(j).size(); i++) {
				System.out.print(map.get(j).get(i)+"->");
			}
			System.out.println();
		}
	}
	
	public void createListAtEachDepth(Tree node, Map<Integer, List<Integer>> map, int depth) {
		if(node == null)
			return;
		
		createListAtEachDepth(node.left, map, depth+1);
		createListAtEachDepth(node.right, map, depth+1);
		if(map.containsKey(depth)) {
			map.get(depth).add(node.val);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(node.val);
			map.put(depth, list);
		}
		
	}
	
	
	public Tree constructFullBinaryTree(int arr[]) {
		return constructFullBinaryTree(arr, 0, arr.length-1);
	}
	
	public Tree constructFullBinaryTree(int arr[], int start, int end) {
		if(start > end)
			return null;
		
		if(start == end)
			return new Tree(arr[start]);
		
		int mid = (start+end)/2;
		Tree root = new Tree(arr[mid]);
		root.left = constructFullBinaryTree(arr, start, mid-1);
		root.right = constructFullBinaryTree(arr, mid+1, end);
		return root;
	}
	
//	 struct node *root = newNode(1);
//	    root->left = newNode(2);
//	    root->right = newNode(3);
//	    root->left->left = newNode(4);
//	    root->left->right = newNode(5);
//	    root->left->left->left = newNode(8);
	
//	 struct node *root = newNode(1);  
//	  root->left = newNode(2);
//	  root->right = newNode(3);
//	  root->left->left = newNode(4);
//	  root->left->right = newNode(5);
//	  root->right->left = newNode(6);
//	  root->left->left->left = newNode(7);
	
	
	public int isTreeHeightBalancedSmart(Tree node) {
		if(node == null)
			return 0;
		
		int lh = isTreeHeightBalancedSmart(node.left);
		int rh = isTreeHeightBalancedSmart(node.right);
		
		if(lh == -1 || rh == -1 || Math.abs(lh-rh) > 1)
			return -1;
		
		return 1 + Math.max(lh, rh);
		
	}

	// #NotEfficient
	public boolean isTreeHeighBalanced(Tree node) {
		if(node == null)
			return true;
		
		boolean left = isTreeHeighBalanced(node.left);
		boolean right = isTreeHeighBalanced(node.right);
		return left && right && Math.abs(depth(node.left) - depth(node.right)) <= 1;
		
	}
	
	public int depth(Tree node) {
		if(node == null)
			return 0;
		
		return 1+Math.max(depth(node.left), depth(node.right));
	}

}

class Tree {
	Tree left;
	Tree right;
	int val;
	public Tree(int val) {
		this.val = val;
	}
	
	public Tree() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+this.val;
	}
}