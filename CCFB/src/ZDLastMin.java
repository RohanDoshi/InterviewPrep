import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;


public class ZDLastMin {

	public static void main(String[] args) {
		int[] arr = {-1, 0, 1, 2, -1, -4};
		ZDLastMin zd = new ZDLastMin();
		zd.sum3sum(arr, 0);
		System.out.println("--------------");
		zd.sum3sumOther(arr, 0);
		
		int[] lis = {2,5,3};
		zd.lis(lis);
		int[] sliding = {1, 3, -1, -3, 5, 3, 6, 7};
		zd.slidingMinWin(sliding, 3);
		zd.slidingMinWinBetter(sliding, 3);
	}
	
	class Pair implements Comparable<Pair> {
		int elem;
		int index;
		@Override
		public int compareTo(Pair o) {
			if(this.elem < o.elem)
				return -1;
			else
				return 1;
		}
		public Pair(int elem, int index) {
			this.elem = elem;
			this.index = index;
		}
	}
	
	public void slidingMinWinBetter(int[] arr, int w) {
		Deque deque = new Deque();
		for(int i=0; i<w; i++) {
			while(!deque.isEmpty() && arr[deque.peekBack()] > arr[i])
				deque.popBack();
			deque.pushBack(i);
		}
		
		int[] res = new int[arr.length-w+1];
		for(int i=w; i<arr.length; i++) {
			res[i-w] = arr[deque.peekFront()];
			while(!deque.isEmpty() && arr[deque.peekBack()] > arr[i])
				deque.popBack();
			
			while(!deque.isEmpty() && deque.peekFront() <= i-w)
				deque.popFront();
			
			deque.pushBack(i);
		}
		res[res.length-1] = arr[deque.peekFront()];
		System.out.println(Arrays.toString(res));
	}
	
	//{1, 3, -1, -3, 5, 3, 6, 7}
	public void slidingMinWin(int[] arr, int w) {
		java.util.PriorityQueue<Pair> queue = new java.util.PriorityQueue<Pair>(w);
		for(int i=0; i<w; i++) 
			queue.add(new Pair(arr[i], i));
		
		int[] res = new int[arr.length-w+1];
		for(int i=w; i<arr.length; i++) {
			Pair p = queue.peek();
			res[i-w] = p.elem;
			while(!queue.isEmpty() && (queue.peek().index) <= i-w)
				queue.poll();
			queue.add(new Pair(arr[i], i));
		}
		res[res.length-1] = queue.poll().elem;
		System.out.println(Arrays.toString(res));
	}
	
	public void lis(int[] arr) {
		int[] m = new int[arr.length];
		int[] p = new int[arr.length];
		int len = 1;
		m[0] = 0;
		p[0] = -1;
		for(int i=0; i<arr.length; i++) {
			int low = 0;
			int high = len-1;
			while(low <= high) {
				int mid = (low + high) >>> 1;
				if(arr[m[mid]] < arr[i]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			
			if(high == -1) {
				p[i] = -1;
			} else {
				p[i] = high;
			}
			
			if(high == len-1 || arr[i] < arr[m[high+1]]) {
				m[high+1] = i;
				if(high + 2 > len) {
					len = high + 2;
				}
			}
		}
		
		System.out.println(Arrays.toString(m));
		System.out.println(Arrays.toString(p));
		
		int res[] = new int[len];
		int n = len-1;
		int pIndex = m[n];
		for(int i=res.length-1; i>=0; i--) {
			res[i] = arr[pIndex];
			pIndex = p[pIndex];
		}
		
		System.out.println(Arrays.toString(res));
	}
	
	//[-4, -1, -1, 0, 1, 2]
	public void sum3sumOther(int[] arr, int sum) {
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) {
			while(i-1 >= 0 && arr[i] == arr[i-1])
				i = i+1;
			
			int j = i+1;
			int k = arr.length-1;
			while(j<k) {
				int temp = arr[j] + arr[k];
				if(arr[i] + temp == sum) {
					System.out.println("["+arr[i]+" "+arr[j]+" "+arr[k]+"]");
					j++;
					k--;
				} else if(arr[i] + temp > sum) {
					k--;
				} else {
					j++;
				}
			}
		}
	}
	
	public void sum3sum(int[] arr, int sum) {
		Arrays.sort(arr);
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
				map.put(arr[i], i);
		}
		Set<Vector<Integer>> set = new HashSet<>();
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				int temp = arr[i] + arr[j];
				if(map.containsKey(sum-temp)) {
					int index = map.get(sum-temp);
					if(index > j) {
						//System.out.println("["+arr[i]+" "+arr[j]+" "+arr[index]+"]");
						Vector<Integer> v = new Vector<>();
						v.add(arr[i]);
						v.add(arr[j]);
						v.add(arr[index]);
						set.add(v);
					}
				}
			}
		}
		Iterator<Vector<Integer>> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().toString());
		}
	}

}
