package pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class General2 {

	public static void main(String[] args) {
//		int denom[] = {1, 5, 10, 25 };
//		int quantity[] = {10, 10, 10, 10};
//		MinCoins coins = new MinCoins(denom, quantity);
//		System.out.println(coins.findMinCoins(35));
//		System.out.println(coins.findMinCoins(37));
//		System.out.println(Arrays.toString(coins.returnChange(35)));
//		System.out.println(Arrays.toString(coins.returnChange(37)));
		
//		KnapSack knapSack = new KnapSack();
//		System.out.println(knapSack.optimalValue(50));
		
//		DLLBinaryTree binaryTree = new DLLBinaryTree();
//		binaryTree.constructBalancedBinTreeZigZag();
		
		System.out.println(recursivePower(2, 4));
		
	}
	
	
	static double recursivePower(double x, int k) {
	    if (k < 0) {
	        return Math.pow(x, ++k) / x;
	    } else if (k == 0) {
	        return 1;
	    } else {
	        return Math.pow(x, --k) /1/x;
	    }
	}

}


class DLLBinaryTree {
	
	private DLLNode node; 
	
	public DLLBinaryTree() {
		
		node = new DLLNode(1);
		node.prev = null;
		node.next = new DLLNode(3);
		node.next.prev = node;
		node.next.next = new DLLNode(2);
		node.next.next.prev = node.next;
		node.next.next.next = new DLLNode(4);
		node.next.next.next.prev = node.next.next;
		node.next.next.next.next = new DLLNode(5);
		node.next.next.next.next.prev = node.next.next.next;
		node.next.next.next.next.next = new DLLNode(6);
		node.next.next.next.next.next.prev = node.next.next.next.next;
		node.next.next.next.next.next.next = new DLLNode(7);
		node.next.next.next.next.next.next.prev = node.next.next.next.next.next;
		node.next.next.next.next.next.next.next = new DLLNode(9);
		node.next.next.next.next.next.next.next.prev = node.next.next.next.next.next.next;
		node.next.next.next.next.next.next.next.next = new DLLNode(8);
		node.next.next.next.next.next.next.next.next.prev = node.next.next.next.next.next.next.next;
		
	}
	
	public void constructBalancedBinTreeZigZag() {
		int n = len(node);
		node = constructBalancedBinTreeZZZZ(n);
		printInOrder(node);
	}
	
	private boolean rev = true;
	public DLLNode constructBalancedBinTreeZZZZ(int n) {
		if(n <= 0)
			return null;
		
		DLLNode root = constructBalancedBinTreeZZZZ(n/2);
		
		if(root != null) {
			
			if(rev) {
				root.next = node;
				
				node = node.next;
				
				root.prev = constructBalancedBinTreeZZZZ(n-n/2-1);
				
				
			}  else {
				
				root.prev = node; 
				
				node = node.next; 
				
				root.next = constructBalancedBinTreeZZZZ(n-n/2-1);
			}
			
			rev = ! rev;
			
		} else {
			DLLNode temp = node;
			node = node.next;
			return temp;
		}
		
		
		return root;
	}
	
	public void constructBalancedBinTree() {
		
		int n = len(node);
		node = binTree(n);
		printInOrder(node);
	}
	
	public void printInOrder(DLLNode node) {
		if(node == null)
			return;
		
		printInOrder(node.prev);
		System.out.print(node.data+" ") ;
		printInOrder(node.next);
	}
	
	public DLLNode binTree(int n) {
		if(n <= 0)
			return null;
		
		DLLNode left = binTree(n/2);
		
		DLLNode root= node;
		root.prev = left;
		
		node = node.next;
		
		DLLNode right = binTree(n -  n/2 - 1);
		root.next = right;
		
		return root;
		
	}
	
	public int len(DLLNode node) {
		int count = 0;
		if(node == null)
			return count;
		
		while(node != null) {
			count++;
			node= node.next;
		}
		return count;
	}

}

class DLLNode { 
	int data; 
	public DLLNode(int data) {
		this.data = data;
	}
	DLLNode next;
	DLLNode prev; 
}

class KnapSack {
	
	int val[] = {60, 100, 120};
    int wt[] = {10, 20, 30};
    int W = 50;
    
    public int optimalValue() { 
    	return optimalValue(W);
    }
    
    public int optimalValue(int reqWeight) {
    	if(reqWeight < wt[0]) {
    		return 0;
    	}
    	int index = -1;
    	if((index = arrayIndex(reqWeight)) != -1) {
    		return val[index];
    	}
    	
    	int max = 0;
    	for(int i=0; i<wt.length; i++) {
    		if(wt[i] < reqWeight) {
    			max = Math.max(max, optimalValue(reqWeight-wt[i]) + optimalValue(wt[i]));
    		}
    	}
    	return max;
    	
    }
    
    public int arrayIndex(int reqWeight) {
    	for(int i=0; i<wt.length; i++) {
    		if(reqWeight == wt[i]) {
    			return i;
    		}
    	}
    	return -1;
    }
}

class MinCoins {
	private int denom[];
	private int quantity[]; 
	private Map<Integer, List<Integer>> listOfMinCoins ;
	
	public MinCoins(int[] denom, int[] quantity) {
		this.denom = denom;
		this.quantity = quantity;
	}
	
	public Integer[] returnChange(int change) {
		listOfMinCoins = new HashMap<>();
		List<Integer> list = returnChangeCoins(change, listOfMinCoins);
		return list.toArray(new Integer[list.size()]);
	}
	public int findMinCoins(int change) {
		int storedMin[] = new int[change+1];
		Arrays.fill(storedMin, -1);
		int res =  findMinCoins(change, storedMin);
		return res;
	}
	
	public int findMinCoins(int change, int storedMin[]) {
		if(change <= 0) {
			storedMin[0] = 0;
			return 0;
		}
		
		if(storedMin[change] != -1) {
			return storedMin[change];
		}
		int minCoins = -1;
		for(int den : denom) {
			if(change >= den) {
				int numCoins = findMinCoins(change-den, storedMin) + 1;
				if(minCoins == -1) {
					minCoins = numCoins;
				} else {
					minCoins = Math.min(minCoins, numCoins);
				}
			}
		}
		
		if(minCoins == -1) {
			storedMin[change] = 0;
			return 0;
		} else {
			storedMin[change] = minCoins;
			return minCoins;
		}
	}
	
	public List<Integer> returnChangeCoins(int change, Map<Integer, List<Integer>> listOfMinCoins) {
		
		if(change == 0) {
			List<Integer> list = new ArrayList<>();
			listOfMinCoins.put(change, list);
			return list;
		}
		if(listOfMinCoins.get(change) != null) {
			return listOfMinCoins.get(change);
 		}
		List<Integer> min = null;
	
		for(int i=0; i<denom.length; i++) {
			if(change >= denom[i]) {
				// min coins with this denom
				List<Integer> minCoins = returnChangeCoins(change - denom[i],listOfMinCoins) ;
				if(minCoins != null) {
					minCoins.add(denom[i]);
				
					if(min == null) {
						min = minCoins;
					} else if(minCoins.size() < min.size()) {
						min = minCoins;
					}
				}
			}
		}
		if(min == null) {
			listOfMinCoins.put(change, null);
			return null;
		}
		listOfMinCoins.put(change, min);
		return min;
				
	}
	
	
}
