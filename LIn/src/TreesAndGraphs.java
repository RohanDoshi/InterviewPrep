import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class TreesAndGraphs {

	public static void main(String args[]) {
		
		TreesAndGraphs tg = new TreesAndGraphs();
		
		BinaryTree binaryTree = new BinaryTree(5);
		binaryTree.left = new BinaryTree(2);
		binaryTree.right = new BinaryTree(8);
		binaryTree.right.left = new BinaryTree(9);
		binaryTree.left.left = new BinaryTree(1);
		binaryTree.left.left.left = new BinaryTree(7);
		binaryTree.left.left.left.right = new BinaryTree(8);
		binaryTree.left.right = new BinaryTree(5);
		
		System.out.println(tg.isBalanced(binaryTree));
		
		Graph<Character> graph = new Graph<Character>();
		Character cycleVert[] = {'a','b','c','d','e'};
		for(char v: cycleVert) {
			graph.addVertex(v);
		}
		
		graph.addEdge('a', 'd');
		graph.addEdge('b', 'a');
		graph.addEdge('b', 'c'); 
		graph.addEdge('d', 'b');
		graph.addEdge('d', 'e');
		graph.addEdge('e', 'c');
		
		System.out.println(graph.isRouteExists('a', 'c'));
		System.out.println(graph.isRouteExists('e', 'a'));
		
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(tg.isBSTOtherWay(binaryTree));
		
		List<Node> list = tg.createLinkedListAtEachDepth(tg.constructBST(arr));
		for(int i=0; i<list.size(); i++) {
			Node node = list.get(i);
			while(node != null) {
				System.out.print(node.val+" ");
				node = node.next;
			}
			System.out.println();
		}
		
		System.out.println("********************");
		List<NodeBinaryTree> listSp = tg.createLinkedListAtEachDepthBFS(binaryTree);
		for(int i=0; i<listSp.size(); i++) {
			NodeBinaryTree node = listSp.get(i);
			while(node != null) {
				System.out.print(node.tree.val+" ");
				node = node.next;
			}
			System.out.println();
		}
		
		System.out.println(tg.isBST(binaryTree));
		
		System.out.println(tg.findNextInOrderParentPointer(binaryTree).val);
		
		System.out.println(tg.isSubTree(binaryTree, binaryTree.left.left));
		
		tg.printAllPaths(binaryTree, 15);
		
		BinaryTree bst = new BinaryTree(2);
		bst.left = new BinaryTree(1);
		bst.right = new BinaryTree(4);
		bst.right.left = new BinaryTree(3);
		bst.right.right = new BinaryTree(5);
		bst.right.right.left = new BinaryTree(6);
		tg.inOrderIterative(bst);
		bst = tg.delete(bst, 4);
		System.out.println();
		tg.inOrderIterative(bst);
	}
	
	public void inOrderIterative(BinaryTree tree) {
		if(tree == null)
			return;
		
		Stack<BinaryTree> stack = new Stack<>();
		while(tree != null) {
			stack.push(tree);
			tree = tree.left;
		}
		
		while(!stack.isEmpty()) {
			BinaryTree temp = stack.pop();
			System.out.print(temp.val+ " ");
			
			temp = temp.right;
			while(temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
 		}
	}
	
	// delete from a BST
	public BinaryTree delete(BinaryTree tree, int val) {
		if(tree == null)
			return null;
		
		if(tree.val == val) {
			if(tree.left == null && tree.right == null)
				return null;
			
			if(tree.left == null)
				return tree.right;
			
			if(tree.right == null)
				return tree.left;
			
			// find min node in right subtree
			// set that value
			// delete the min node
			BinaryTree minNode = minNode(tree.right);
			tree.val = minNode.val;
			tree.right = delete(tree.right, minNode.val);
			return tree;
		}
		
		tree.left = delete(tree.left, val);
		tree.right = delete(tree.right, val);
		
		return tree;
	}
	
	public BinaryTree minNode(BinaryTree tree) {
		if(tree == null)
			return null;
		
		while(tree.left != null)
			tree = tree.left;
		
		return tree;
	}
	
	
	public void printAllPaths(BinaryTree tree, int sum) {
		if(tree == null)
			return;
		
		List<List<Integer>> paths = new ArrayList<>();
		printAllPaths(tree, paths, new ArrayList<Integer>(), sum);
		
	}
	
	private void printAllPaths(BinaryTree tree, List<List<Integer>> paths, List<Integer> list, int sum) {
		if(tree == null)
			return;
		
		list.add(tree.val);
		int total = 0;
		
		for(int i=list.size()-1; i>=0; i--) {
			total += list.get(i);
			if(total == sum) {
				for(int j=list.size()-1; j>=i; j--) {
					System.out.print(list.get(j)+" ");
				}
				System.out.println();
			}
		}
		
		printAllPaths(tree.left, paths, list, sum);
		printAllPaths(tree.right, paths, list, sum);
	}
	
	public boolean isSubTree(BinaryTree tree1, BinaryTree tree2) {
		if(tree1 == null)
			return false;
		
		if(tree1.val == tree2.val) {
			boolean isMatch = match(tree1, tree2);
			if(isMatch)
				return true;
		}
		
		return isSubTree(tree1.left, tree2) || isSubTree(tree1.right, tree2);
	}
	
	private boolean match(BinaryTree tree1, BinaryTree tree2) {
		if(tree1 == null && tree2 == null)
			return true;
		
		if(tree1 == null || tree2 == null)
			return false;
		
		if(tree1.val == tree2.val) {
			return match(tree1.left, tree2.left) && match(tree1.right, tree2.right);
		} else {
			return false;
		}
	}
	
	
	
	public BinaryTree lca(BinaryTree tree, int a, int b) {
		if(tree == null)
			return null;
		
		if(tree.val == a || tree.val == b)
			return tree;
		
		BinaryTree left = lca(tree.left, a, b);
		BinaryTree right = lca(tree.right, a,b);
		
		if(left != null && right != null)
			return tree;
		
		if(left != null)
			return left;
		
		return right;
	}
	
	
	
	public BinaryTree findNextInOrderParentPointer(BinaryTree tree) {
		if(tree == null)
			return null;
		
		if(tree.right == null) {
			BinaryTree parent = tree.parent;
			if(parent == null)
				return null;

			BinaryTree parentParent = parent.parent;
			while(parentParent != null && parentParent.left == parent) {
				parent = parentParent;
				parentParent = parentParent.parent;
			}
			return parent;
			
		} else {
			BinaryTree node = tree.right;
			while(node.left != null)
				node = node.left;
			return node;
		}
	}
	
	public BinaryTree constructBST(int arr[]) {
		return constructBST(arr, 0, arr.length-1);
	}
	
	private BinaryTree constructBST(int arr[], int low, int high) {
		if(low > high)
			return null;
		
		int mid = (low + high)/2;
		BinaryTree root = new BinaryTree(arr[mid]);
		root.left = constructBST(arr, low, mid-1);
		root.right = constructBST(arr, mid+1, high);
		return root;
		
	}
	
	public boolean isBSTOtherWay(BinaryTree tree) {
		BinaryTree prev[] = new BinaryTree[1];
		return isBSTOtherWay(tree, prev);
	}
	
	public boolean isBSTOtherWay(BinaryTree tree, BinaryTree prevTree[]) {
		if(tree == null)
			return true;
		
		boolean lh = isBSTOtherWay(tree.left, prevTree);
		if(lh) {
			if(prevTree[0] != null) {
				if(prevTree[0].val > tree.val) 
					return false;
			}
		}
		prevTree[0] = tree;
		return isBSTOtherWay(tree.right, prevTree);
	}
	
	
	public boolean isBST(BinaryTree tree) {
		if(tree == null)
			return true;
		
		boolean bst[] = new boolean[1];
		bst[0] = true;
		isBST(tree, bst);
		return bst[0];
	}
	
	private int isBST(BinaryTree tree, boolean b[]) {
		
		int leftMax = Integer.MIN_VALUE;
		int rightMax = Integer.MAX_VALUE;
		
		if(tree.left != null) 
			leftMax = isBST(tree.left, b);
		
		if(tree.right != null)
			rightMax = isBST(tree.right, b);
		
		if(tree.val >= leftMax && tree.val <= rightMax) {
			b[0] = b[0] && true;
		} else {
			b[0] = false;
		}
		
		return tree.right != null ? rightMax : tree.val;
	}
	
	private class NodeBinaryTree { 
		BinaryTree tree;
		NodeBinaryTree next;
		public NodeBinaryTree(BinaryTree tree) {
			this.tree = tree;
		}
	}
	public List<NodeBinaryTree> createLinkedListAtEachDepthBFS(BinaryTree tree) {
		List<NodeBinaryTree> list = new ArrayList<>();
		if(tree == null)
			return list;
		
		list.add(new NodeBinaryTree(tree));
		int depth = 0;
		
		while(depth < list.size()) {
			NodeBinaryTree node = list.get(depth);
			depth++;
			NodeBinaryTree temp = null;
			while(node != null) {
				BinaryTree tempTree = node.tree;
				if(tempTree.left != null) {
					if(temp == null) {
						temp =  new NodeBinaryTree(tempTree.left);
						list.add(temp);
					} else {
						temp.next = new NodeBinaryTree(tempTree.left);
						temp = temp.next;
					}
				}
				
				if(tempTree.right != null) {
					if(temp == null) {
						temp =  new NodeBinaryTree(tempTree.right);
						list.add(temp);
					} else {
						temp.next = new NodeBinaryTree(tempTree.right);
						temp = temp.next;
					}
				}
				node = node.next;
			}
		}
		
		return list;
	}
	
	public List<Node> createLinkedListAtEachDepth(BinaryTree tree) {
		List<Node> list = new ArrayList<>();
		
		if(tree == null)
			return list;
		
		createLinkedListAtEachDepth(tree, 0, list);
		return list;
	}
	
	private void createLinkedListAtEachDepth(BinaryTree tree, int currDepth, List<Node> list) {
		if(tree == null)
			return;
		
		Node node = new Node(tree.val);
		if(list.size() == currDepth) {
			list.add(node);
		} else {
			Node nodeDepth = list.get(currDepth);
			while(nodeDepth.next != null)
				nodeDepth = nodeDepth.next;
			nodeDepth.next = node;
		}
		
		createLinkedListAtEachDepth(tree.left, currDepth+1, list);
		createLinkedListAtEachDepth(tree.right, currDepth+1, list);
	}
	
	public boolean isBalanced(BinaryTree tree) {
		boolean b[] = new boolean[1];
		b[0] = true;
		isBalanced(tree, b);
		return b[0];
	}
	
	private int isBalanced(BinaryTree tree, boolean b[]) { 
		if(tree == null)
			return 0;
		
		int lh = isBalanced(tree.left, b);
		int rh = isBalanced(tree.right, b);
		if(Math.abs(lh-rh) > 1) {
			b[0] = false;
		} else {
			b[0] = b[0] && true;
		}
		return Math.max(lh, rh)+1;
	}
}

class Graph<T> { 
	
	private class Vertex<T> { 
		Set<Edge<T>> neighbors;
		T name;
		public Vertex(T name) {
			this.name = name;
			this.neighbors = new HashSet<>();
		}
		
		void addEdge(Edge<T> edge) {
			this.neighbors.add(edge);
		}
		
		List<Edge<T>> edges() {
			return new ArrayList<>(this.neighbors);
		}
	}
	
	private class Edge<T> {
		Vertex<T> fromVertex;
		Vertex<T> toVertex;
		String name; 
		double distance;
		public Edge(Vertex<T> fromVertex, Vertex<T> toVertex) {
			this.fromVertex = fromVertex;
			this.toVertex = toVertex;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getDistance() {
			return distance;
		}
		public void setDistance(double distance) {
			this.distance = distance;
		}
		
	}
	
	private Map<T, Vertex<T>> map;
	
	public Graph() {
		this.map = new HashMap<T,Vertex<T>>();
	}
	
	public void addVertex(T name) {
		if(!map.containsKey(name))
			map.put(name, new Vertex<T>(name));
	}
	
	public void addEdge(T vertex1, T vertex2) {
		if(map.containsKey(vertex1) && map.containsKey(vertex2)) {
			Edge<T> edge = new Edge<>(map.get(vertex1), map.get(vertex2));
			map.get(vertex1).addEdge(edge);
		}
	}
	
	
	public boolean isRouteExists(T vertex1, T vertex2) {
		if(!map.containsKey(vertex1) || !map.containsKey(vertex2))
			return false;
		
		Vertex<T> v1 = map.get(vertex1);
		Vertex<T> v2 = map.get(vertex2);
		
		Iterator<Edge<T>> iterator = v1.neighbors.iterator();
		while(iterator.hasNext()) {
			boolean b = dfs(iterator.next().toVertex, v2, new HashSet<Vertex<T>>());
			if(b)
				return b;
		}
		
		return false;
	}
	
	private boolean dfs(Vertex<T> currVertex, Vertex<T> destVertex, Set<Vertex<T>> set) {
		if(currVertex == destVertex)
			return true;
		
		if(set.contains(currVertex))
			return false;
		
		set.add(currVertex);
		Iterator<Edge<T>> iterator = currVertex.neighbors.iterator();
		while(iterator.hasNext()) {
			boolean b = dfs(iterator.next().toVertex, destVertex, set);
			if(b)
				return b;
		}
		
		return false;
	}
	
	
}