import pack.HashMapDS;

class BinaryTree { 
	int key;
	BinaryTree left;
	BinaryTree right;
	
	public BinaryTree(int key) {
		this.key = key;
	}
	
}

class Algos { 
	
	
	// number of possible binary trees for N nodes
	int numOfBT(int n) {
		
		if(n == 0)
			return 0;
		
		return 0;
	}
	
	// max sum between any two leaves
	int maxSumRes = Integer.MIN_VALUE;
	int maxSumBetweenAnyTwoLeaves(BinaryTree root) {
		
		if(root == null)
			return 0;
		
		int leftMaxSum = maxSumBetweenAnyTwoLeaves(root.left);
		int rightMaxSum = maxSumBetweenAnyTwoLeaves(root.right);
		int maxAtRoot = root.key + leftMaxSum + rightMaxSum;
		if(maxAtRoot > maxSumRes)
			maxSumRes = maxAtRoot;
		
		return root.key + Math.max(leftMaxSum, rightMaxSum);
	}
	
}
public class Trees {
	
	public static void main(String args[]) {
		BinaryTree root = new BinaryTree(-15);
		root.left = new BinaryTree(5);
		root.right = new BinaryTree(6);
		root.left.left = new BinaryTree(-8);
		root.left.right = new BinaryTree(1);
		root.left.left.left = new BinaryTree(2);
		root.left.left.right = new BinaryTree(6);
		root.right.left = new BinaryTree(3);
		root.right.right = new BinaryTree(9);
		root.right.right.right = new BinaryTree(0);
		root.right.right.right.left = new BinaryTree(4);
		root.right.right.right.right = new BinaryTree(-1);
		root.right.right.right.right.left = new BinaryTree(10);
		Algos algos = new Algos();
		System.out.println(algos.maxSumBetweenAnyTwoLeaves(root)+" "+algos.maxSumRes);
		
	}
}
