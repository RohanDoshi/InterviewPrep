import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class RecursionDP {

	public static void main(String[] args) {
		RecursionDP fb = new RecursionDP();
		System.out.println(fb.countWays(5));
		System.out.println(fb.countWaysRecur(5));	
		int[] arr = {-40, -20, -1, 1,2,3,5,7,9,12,13};
		System.out.println(fb.possible("1^0|1|1".toCharArray(), 0, "1^0|1|1".length()-1, 0, true));
		System.out.println(Math.pow(2, 13));
		
		char[] ch = "AAB".toCharArray(); // B A C B A C B
		fb.schedule(ch, 2);
		
	}
	
	class Job {
		char c;
		int count;
		public Job(char c, int count) {
			this.c = c;
			this.count = count;
		}
	}
	
	public void schedule(char[] ch, int coolDown) {
		Comparator<Job> comparator = new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				if(o1.count > o2.count)
					return -1;
				else if(o1.count < o2.count)
					return 1;
				else
					return 0;
			}
		};
		PriorityQueue<Job> queue = new PriorityQueue<>(10, comparator);
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i<ch.length; i++)  {
			if(map.containsKey(ch[i])) {
				map.put(ch[i], map.get(ch[i])+1);
			} else {
				map.put(ch[i], 1);
			}
		}
		Character[] keys = map.keySet().toArray(new Character[map.size()]);
		for(int i=0; i<keys.length; i++) {
			queue.add(new Job(keys[i], map.get(keys[i])));
		}
		
		char c[] = new char[ch.length + (ch.length-1)*coolDown];
		int start = 0;
		Arrays.fill(c, '_');
		while(queue.size() != 0) {
			Job j = queue.poll();
			int count = j.count;
			int i = 1;
			while(i <= count) {
				c[start + (i-1)*(coolDown+1)] = j.c;
				i++;
			}
			start++;
		}
		
		System.out.println(new String(c,0,c.length));
	}
	
	// 1^ 0 | 1 | 1
	public int possible(char c[], int index, int end, int currVal, boolean target) {
		
		if(index == end) {
			if(c[index] == 1 && target)
				return 1;
			else if(c[index] == 0 && !target)
				return 1;
			else
				return 0;
		}
		
		int v = 0;
		if(target) {
			for(int i=index+1; i<=end; i++) {
				if(c[i] == '&') {
					v = v+ possible(c, index, i-1, currVal, true) * possible(c, i+1, end, currVal, true);
				} else if(c[i] == '|') {
					v = v + possible(c, index, i-1, currVal, true) * possible(c, i+1, end, currVal, true) +
							possible(c, index, i-1, currVal, true) * possible(c, i+1, end, currVal, false) +
							possible(c, index, i-1, currVal, false) * possible(c, i+1, end, currVal, true) ;
				} else if(c[i] == '^') {
					v = v + possible(c, index, i-1, currVal, true) * possible(c, i+1, end, currVal, false) + 
							possible(c, index, i-1, currVal, false) * possible(c, i+1, end, currVal, true) ;
				}
			}
		} else {
			for(int i=index+1; i<=end; i++) {
				if(c[i] == '&') {
					v = v + possible(c, index, i-1, currVal, false) * possible(c, i+1, end, currVal, false) +
							possible(c, index, i-1, currVal, true) * possible(c, i+1, end, currVal, false) +
							possible(c, index, i-1, currVal, false) * possible(c, i+1, end, currVal, true) ;
				} else if(c[i] == '|') {
					v = v + possible(c, index, i-1, currVal, false) * possible(c, i+1, end, currVal, false);
				} else if(c[i] == '^') {
					v = v + possible(c, index, i-1, currVal, true) * possible(c, i+1, end, currVal, true) + 
							possible(c, index, i-1, currVal, false) * possible(c, i+1, end, currVal, false) ;
				}
			}
		}
		
		return v;
	}
	
	
	// 25, 10, 5, 1
	
	
	public boolean isPathExists(int x, int y) {
		
		if(x == 0 && y == 0)
			return true; 
		
		boolean path = false;
		
		if(x > 0 && isFree(x-1, y))
			path = isPathExists(x-1, y);
		
		if(!path) {
			if(y > 0 && isFree(x, y-1))
				path = isPathExists(x, y-1);
		}
		return path;
	}
	
	public boolean isFree(int x, int y) {
		return true;
	}
	
	public int countWays(int n) {
		if(n < 0)
			return 0;
		
		if(n == 1 || n == 2)
			return n;
		
		if(n == 3)
			return 4;
		
		int[] tab = new int[n+1];
		tab[1] = 1;
		tab[2] = 2;
		tab[3] = 4;
		
		for(int i=4; i<=n; i++) {
			tab[i] = tab[i-1] + tab[i-2] + tab[i-3];
		}
		
		return tab[n];
		
	}
	
	
	public int countWaysRecur(int n) {
		if(n < 0)
			return 0;
		
		if(n == 1 || n == 2)
			return n;
		
		if(n == 3)
			return 4;
		
		return countWaysRecur(n-1) + countWaysRecur(n-2) + countWaysRecur(n-3);
		
	}

}
