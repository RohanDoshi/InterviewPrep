
public class Practice {

	public static void main(String[] args) {
		Practice practice = new Practice();
		practice.compress("aaabba", 2);
	}
	
	public void compress(String s, int num) {
		StringBuilder builder = new StringBuilder();
		char prev = '\0';
		int count = 0;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(prev != c) {
				count = 1;
			} else {
				count++;
			}
			if(count <= num) {
				builder.append(c);
			}
			prev = c;
		}
		System.out.println(builder);
	}
	
	public void sortStack() {
		
	}

}
