package pack;

public class DynamicDPPractice {

	static  int costs[][] = {{1,2,3}, {4,8,2}, {1,5,3}};
	static String[] encoding = new String[27];
	
	public static void main(String[] args) {
		
		for(int i=1; i<encoding.length; i++) {
			encoding[i] = Character.toString((char) ('A' + i-1));
		}
		
		System.out.println(minCostPathFromOrigin(1, 0, 2, 2, 0));
		
		System.out.println(editDistance("zeil", "trails"));
		
		System.out.println(numOfEncodings("311316"));
	}
	
	static int minCostPathFromOrigin(int row, int col, int m, int n, int sum) {
		
		if(row >= costs.length || col >= costs[0].length)
			return Integer.MAX_VALUE;
		
		if(row == m && col == n)
			return sum + costs[m][n];
		
		int path1 = minCostPathFromOrigin(row, col+1, m, n, sum + costs[row][col]);
		
		int path2 = minCostPathFromOrigin(row+1, col, m, n, sum + costs[row][col]);
		
		int path3 = minCostPathFromOrigin(row+1, col+1, m, n, sum + costs[row][col]);
		
		int min = Math.min(path1, Math.min(path2, path3));
		
		return min;
		
	}
	
	
	static int editDistance(String w1, String w2) {
		
		return editDist(w1.toCharArray(), w2.toCharArray(), 0, 0);
	}
	
	static int editDist(char[] c1, char[] c2, int a, int b) {
		
		if(a >= c1.length)
			return c2.length -b; // insertion

		if(b >= c2.length) 
			return c1.length -a; // deletion
		
		int d1=Integer.MAX_VALUE , d2=Integer.MAX_VALUE, d3=Integer.MAX_VALUE, d4=Integer.MAX_VALUE;
		if(c1[a] == c2[b]) {
			d1 = editDist(c1, c2, a+1, b+1);
		} else { 
			d2 = 1+ editDist(c1, c2, a, b+1);
			d3 = 1+ editDist(c1, c2, a+1, b);
			d4 = 1+ editDist(c1, c2, a+1, b+1);
		}
		
		return Math.min(Math.min(d1, d2), Math.min(d3, d4));
	}
	
	
	static void printAllEncodings(String str) {
		
		for(int i=0; i<str.length(); i++) {
		
			String s1 = null, s2 = null;
			
			String sub = str.substring(0,i+1);
			int subInt = Integer.parseInt(sub);
			if(subInt < encoding.length) 
				s1 = encoding[subInt];
			else 
				s1 = null;
			
			if(s1 != null) {
				
				for(int j= i+1; j<str.length(); j++) {
					
					s2 = printEncodings(str, i+1, j);
					
					if(s1 != null && s2 != null) {
						System.out.println(s1 + s2);
					}
				}
				
				
			}
		}
	}
	
	static int numOfEncodings(String s) {
		
		int n[] = new int[s.length()];
		n[0] = 1;
		for(int i=1; i<s.length(); i++) {
			
			n[i] = n[i-1];
			
			int doubleDig = Integer.parseInt(s.substring(i-1, i+1));
			if(doubleDig <= 26) {
				if(i == 1)
					n[i] = n[i-1]+1;
				else
					n[i] = n[i] + n[i-2];
			}
			
		}
		
		return n[s.length()-1];
	}
	
	static String printEncodings(String str, int from, int to)  {
		
		if(from > to)
			return null;
		
		String s1 = null, s2 = null;
		
		String sub = str.substring(from, to+1);
		int subInt = Integer.parseInt(sub);
		if(subInt < encoding.length) 
			s1 = encoding[subInt];
		
		for(int i=to+1; i<str.length(); i++) {

			s2 = printEncodings(str, to + 1, i);
				
			if(s1 != null && s2 != null) {
					return s1+s2;
			}
		}
		
		return s1;
	}
	

}
