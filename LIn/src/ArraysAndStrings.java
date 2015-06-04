
public class ArraysAndStrings {

	public static void main(String[] args) {
		ArraysAndStrings as = new ArraysAndStrings();
		System.out.println(as.hasUniqChars("ronilo"));
		System.out.println(as.isPermutation("abc", "bca"));
		as.replaceStringWithSpaces("Mr John Smith    ".toCharArray());
		System.out.println(as.compression("aabcccccaaa".toCharArray()));
		System.out.println(as.compression("aabc".toCharArray()));
		
		int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
		//as.setZeroMatrix(mat);
		as.rotateBy90(mat);
		System.out.println(as.isRotation("waterbottle", "erbottlewat"));
	}
	
	
	public boolean isRotation(String s1, String s2) {
		return (s1+s1).contains(s2);
	}
	
	//[[7, 2, 1], 
	//[4, 5, 6], 
	//[9, 8, 3]]
	
	public void rotateBy90(int[][] mat) { 
		int n = mat.length;
		for(int level=0; level<n/2; level++) {
			int first = level;
			int last = n - 1 - level;
			for(int i=first; i< last; i++) {
				int offset = i-first;
				
				int top = mat[first][i];
				
				mat[first][i] = mat[last-offset][first];
				
				mat[last-offset][first] = mat[last][last-offset];
				
				mat[last][last-offset] = mat[i][last];
				
				mat[i][last] = top;
			}
		}
	}
	
	public void setZeroMatrix(int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		
		boolean rows[] = new boolean[m];
		boolean cols[] = new boolean[n];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(rows[i] || cols[j])
					arr[i][j] = 0;
			}
		}
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
	
	public String compression(char c[]) {
		char compress[] = new char[c.length*2];
		char prev = c[0];
		int count = 1;
		int i = 1, index = 0;
		while(i < c.length) {
			if(c[i] == prev) {
				count++;
			} else { 
				compress[index++] = prev;
				compress[index++] = (char)(count+'0');
				count = 1;
			}
			prev = c[i];
			i++;
		}
		compress[index++] = prev;
		compress[index++] = (char)(count+'0');
		if(index-1 < c.length)
			return new String(compress, 0, index);
		else
			return new String(c);
	}
	
	public void replaceStringWithSpaces(char[] s) {
		int w = s.length-1;
		while(s[w] == ' ' && w >=0) {
			w--;
		}
		int i = s.length-1;
		while(w >= 0) {
			if(s[w] != ' ') {
				s[i--] = s[w];
			} else { 
				s[i--] = '0';
				s[i--] = '2';
				s[i--] = '%';
			}
			w--;
		}
		System.out.println(s);
	}
	
	public boolean hasUniqChars(String s) {
		int val = 0;
		for(int i=0; i<s.length(); i++) {
			if((val & (1 << (s.charAt(i) - 'a'))) > 0)
				return false;
			val = val | (1 << (s.charAt(i) - 'a')); 
		}
		return true;
	}
	
	public boolean isPermutation(String s1, String s2) {
		int b1[] = new int[256];
		int b2[] = new int[256];
		
		for(int i=0; i<s1.length(); i++)
			b1[s1.charAt(i)]++;
		
		for(int i=0; i<s2.length(); i++)
			b2[s2.charAt(i)]++;
		
		for(int i=0; i<256; i++) {
			if(b1[i] != b2[i])
				return false;
		}
		
		return true;
	}

}
