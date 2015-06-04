package pack;

public class BitMan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((1<<6)-1);
		System.out.println(updateBits(1 << 1, 19 , 2, 6));
	}
	
	public static int updateBits(int n, int m, int i, int j) {
		 int max = ~0; /* All 1s */
		
		 // 1s through position j, then 0s
		 int left=max-((1<<j)-1);
		
		 // 1s after position i
		 int right=((1<<i)-1);
		
		 // 1s, with 0s between i and j
		 int mask = left | right;
		
		 // Clear i through j, then put m in there
		 return (n & mask) | (m << i);
		 }

}
