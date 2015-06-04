import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Strings {

	public static void main(String[] args) {
		String s1 = "101001";
		String s2= "101010";
		Strings strings = new Strings();
		strings.multiplyTwoBinaryStrings(s1, s2);
		System.out.println(strings.removeRedundantSpaces("google  is one of   the best search    "));
		System.out.println(strings.reverseString("rohan"));
		System.out.println(strings.reverseString("rohand"));
		System.out.println(strings.minStringPossible("bcab"));
		System.out.println(strings.minStringPossibleSmart("bcababcbcabcbaca"));
		System.out.println(strings.minStringPossibleSmart("bcababcbcabcbaca"));
		System.out.println(strings.findMinSubstringThatContainsAllCharsTarget("bcababcbcabcbaca", "cbbacbc"));
	}
	
	
	public String findMinSubstringThatContainsAllCharsTarget(String s, String t) {
		if(s == null || t == null)
			return null;
		
		if(s.isEmpty() || t.isEmpty())
			return "";
		
		int asciiCount[] = new int[256];
		for(int i=0; i<t.length(); i++) {
			asciiCount[t.charAt(i)]++;
		}
		
		int start = 0;
		Queue<Character> queue = new LinkedList<>();
		int asciiCountSource[] = new int[256];
		
		for(int i=0; i<s.length(); i++) {
			asciiCountSource[s.charAt(i)]++;
			queue.add(s.charAt(i));
			if(queue.size() == t.length()) {
				if(isSameArrays(asciiCount, asciiCountSource)) {
					return s.substring(start, i+1);
				} else { 
					char firstChar = queue.poll();
					asciiCountSource[firstChar]--;
					start++;
				}
			}
		}
		
		return "";
	}
	
	private boolean isSameArrays(int a[], int b[]) {
		for(int i=0; i<a.length; i++) {
			if(a[i] != b[i])
				return false;
		}
		
		return true;
	}
	
	
	// string contains a,b,c only.. ac replaced by b, ba replaced by c..etc aa stays same
	// aabbcc -> acac -> abc -> cc
	public int minStringPossibleSmart(String s) {
		if(s == null || s.isEmpty() || s.length() == 1)
			return s == null ? 0 : s.length();
		
		int count[] = new int[3];
		for(int i=0; i<s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		
		if(count[0] == s.length() || count[1] == s.length() || count[2] == s.length())
				return s.length();
		
		if( (count[0] % 2 == 0  && count[1] % 2 == 0  && count[2] % 2 == 0) ||
				(count[0] % 2 == 1 && count[1] % 2 == 1  && count[2] % 2 == 1))
				return 2;
		else
			return 1;
		
		
		
	}
	
	public int minStringPossible(String s) {
		String res = minStringPossible(s, 0);
		return res.length();
	}
	
	private String minStringPossible(String s, int from) {
		
		if(from >= s.length() -1)
			return s;
		
		String str = "";
		String res = "";
		if(s.charAt(from) != s.charAt(from+1)) {
			str = str + getOtherChar(s.charAt(from), s.charAt(from+1));
			str = str + s.substring(from+2, s.length());
			res = minStringPossible(str, from);
		} else {
			str = s.charAt(from) + minStringPossible(s.substring(from+1, s.length()), from);
			if(str.charAt(from) != str.charAt(from+1))
				res = minStringPossible(str, from);
			else
				res = str;
		}
		
		return res;
	}
	
	private char getOtherChar(char a, char b) {
		if((a == 'a' && b== 'b') || (a=='b' && b=='a'))
			return 'c';
		
		if( (a=='b' && b=='c') || (a =='c' && b=='b'))
			return 'a';
		
		if((a=='a' && b=='c') || (a=='c' && b=='a'))
			return 'b';
		
		return '\0';
	}
	
	public String reverseString(String s) {
		if(s == null || s.isEmpty() || s.length() == 1)
			return s;
		
		char c[] = s.toCharArray();
		for(int i=0; i<c.length/2; i++) {
			char temp = c[i];
			c[i] = c[c.length-i-1];
			c[c.length-i-1] = temp;
		}
		
		return new String(c);
	}
	
	public String removeRedundantSpaces(String s) {
		
		StringBuilder sb = new StringBuilder();
		boolean spaceFound = false;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == ' ' && !spaceFound) {
				spaceFound = true;
				sb.append(' ');
			} else if(s.charAt(i) != ' '){
				spaceFound = false;
			}
			if(!spaceFound)
				sb.append(s.charAt(i));
		}
		
		return sb.toString();
	}
	
	
	public void multiplyTwoBinaryStrings(String s1, String s2) {
		char c1[] = s1.toCharArray();
		char c2[] = s2.toCharArray();
		
		int[] res = new int[c1.length + c2.length];
	
		
		int j = res.length-1;
		for(int i=c2.length-1; i>=0; i--) {
			res[j--] = c2[i]-'0';
		}
		
		int shift = res.length;
		for(int i=c1.length-1; i>=0; i--) {
			shift--;
			if(c1[i] == '0') {
				
			} else { 
				addToRes(c2, res, shift);
			}
			
		}
		
		System.out.println(Arrays.toString(res));
	}
	
	private void addToRes(char c[] , int[] res, int fromRes) {
		int carry = 0;
		int sum = 0;
		for(int i=c.length-1; i>=0 ; i--) {
			sum = (res[fromRes]) ^ (c[i] -'0');
			sum = carry ^ sum;
			carry = ((res[fromRes]) & (c[i]-'0'));
			res[fromRes] = sum ;
			fromRes--;
		}
		res[fromRes] = carry;
	}

}
