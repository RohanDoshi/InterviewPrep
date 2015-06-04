import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Strings {

	public static void main(String[] args) {
		Strings s = new Strings();
		System.out.println(s.longestSubstrWithKUniqChars("aabbcc", 2));
		System.out.println(-1%4);
		System.out.println(s.areMovesCircular("GLLG".toCharArray()));
		System.out.println(s.unAvailableComp(1, "ABCBCADEED"));
		System.out.println(s.maxDepthNestedParen("( a(b) (c) (d(e(f)g)h) I (j(k)l)m)"));
		System.out.println(s.maxDepthNestedParen("(b) ((c) ()"));
		s.spacesString("ABC");
		System.out.println(s.longestSubstr("1538023"));
	}
	
	public boolean checkGrammar(String sent) {
		char c[] = sent.toCharArray();
		if(c.length <2)
			return false;
		
		if(c[0] < 'A' || c[0] > 'Z')
			return false;
		
		if(c[c.length-1] != '.')
			return false;
		
		int prevState = 0, currState = 0;
		int i = 1;
		while(i < c.length) {
			char ch = c[i];
			
			if(ch >='a' && ch <= 'z') {
				currState = 1;
			}
			
			if(ch == ' ') {
				currState = 2;
			}
			
			if(ch == '.') {
				currState = 3;
			}
			
			if(ch >= 'A' && ch <= 'Z') {
				currState = 4;
			}
			
			if(prevState == currState && (currState == 3 || currState == 2))
				return false;
			
			if(prevState == 4 && currState != 3)
				return false;
			
			i++;
			
			prevState = currState;
		}
		return true;
	}
	
	public String longestSubstr(String s) {
		String max = "";
		int[][] dp = new int[s.length()][s.length()];
		char c[] = s.toCharArray();
		for(int i=0; i<c.length; i++) {
			dp[i][i] = c[i]-'0';
		}
		
		for(int len=2; len<=c.length; len++) {
			for(int j=0; j<c.length-len+1; j++) {
				int k = j + len-1;
				int l = len/2;
				dp[j][k] = dp[j][k-l] + dp[k-l+1][k];
				
				if(len % 2 == 0 && dp[j][k-l] == dp[k-l+1][k] && len > max.length()) {
					max = s.substring(j, k+1);
				}
			} 
		}
		return max;
	}
	
	public void spacesString(String s) {
		spacesString(s, 0);
		System.out.println("----------------");
		char[] temp = new char[s.length()*2-1];
		temp[0] = s.charAt(0);
		spacesString(s.toCharArray(), temp,1,1);
	}
	
	private void spacesString(String s, int index) {
		if(index > s.length())
			return;
		
		if(index == s.length()) {
			System.out.println(s);
			return;
		}
		
		for(int i=index; i<s.length(); i++) {
			String sub = s.substring(0, i+1);
			spacesString(sub+" "+s.substring(i+1), i+2);
		}
	}
	
	private void spacesString(char[] s, char[] temp, int index, int tempIndex) {
		if(index > s.length)
			return;
		
		if(index == s.length) {
			System.out.println(temp);
			return;
		}
		
		temp[tempIndex] = s[index];
		spacesString(s, temp, index+1, tempIndex+1);
		
		temp[tempIndex] = ' ';
		temp[tempIndex+1] = s[index];
		spacesString(s, temp, index+1, tempIndex+2);
	}
	
	// O(1) space
	public int maxDepthNestedParen(String s) {
		char c[] = s.toCharArray();
		int maxDepth = 0;
		int numOpen = 0;
		for(int i=0; i<s.length(); i++) {
			if(c[i] == '(')
				numOpen++;
			if(c[i] == ')')
				numOpen--;
			if(numOpen > maxDepth)
				maxDepth = numOpen;
		}
		return numOpen == 0?
		 maxDepth : -1;
	}
	
	public int unAvailableComp(int n, String cust) {
		int count = 0;
		char c[] = cust.toCharArray();
		Set<Character> set = new HashSet<>();
		for(int i=0; i<c.length; i++) {
			if(!set.contains(c[i])) {
				if(n == 0){
					count++;
					i++;
				} else {
					n--;
					set.add(c[i]);
				}
			} else {
				n++;
				set.remove(c[i]);
			}
		}
		return count;
	}
	enum direction {
		N,
		E,
		S,
		W;
	}
	public boolean areMovesCircular(char[] arr) {
		int x = 0, y = 0;
		int i=0;
		direction d = direction.E;
		while(i < arr.length) {
			char c = arr[i];
			if(c == 'G') {
				if(d.equals(direction.E)) {
					x++;
				} else if(d.equals(direction.W)) {
					x--;
				} else if(d.equals(direction.N)) {
					y++;
				} else if(d.equals(direction.S)) {
					y--;
				}
			} else if(c == 'R') {
				int ord = (d.ordinal() +1) % direction.values().length;
				d = direction.values()[ord];
			} else if(c == 'L') {
				int ord = (d.ordinal() -1) % direction.values().length;
				if(ord < 0)
					ord = direction.values().length-1;
				d = direction.values()[ord];
			}
			i++;
		}
		
		return x== 0 &&  y == 0;
	}
	// aabbcc 
	public String longestSubstrWithKUniqChars(String s, int k) {
		
		int start = 0;
		Map<Character, Integer> set = new HashMap<>();
		int max = 0;
		for(int i=0; i<s.length(); i++) {
			set.put(s.charAt(i),i);
			if(set.size() == k) {
				if((i-start) > max) {
					max = i-start;
				}
			}
			if(set.size() > k) {
				char temp = s.charAt(start);
				start = set.get(temp) + 1;
				set.remove(temp);
			}
		}
		return s.substring(start, s.length());
	}

}
