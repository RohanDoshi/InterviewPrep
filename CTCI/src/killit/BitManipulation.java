package killit;

public class BitManipulation {

	public static void main(String[] args) {
		BitManipulation bm = new BitManipulation();
		String s1 = "10000000000";
		String s2 = "10011";
		bm.merge(bm.stringBitsToInteger(s1.toCharArray()), bm.stringBitsToInteger(s2.toCharArray()),
				2, 6);
		System.out.println(~0);
		int n = 0;
		int len = 32;
		for(int i=0; i<len; i++) {
			len--;
			n = n+ (int)Math.pow(2,len);
		}
		System.out.println(n);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE+1);
		System.out.println(Math.pow(2, 31));
		System.out.println(bm.numOfBitsReqToConvert(-19, 19));
		//bm.printInBits(-23);
		bm.printInBits(Integer.MAX_VALUE);
		bm.printInBits(Integer.MIN_VALUE);
		bm.printInBits(-19);
		bm.swapOddEvenBits(1);
		System.out.println(bm.flipBit(15, 1));
		System.out.println(bm.flipBit(9, 1));
		bm.printDoubleInBinary(12.72);
		bm.printInBits(4);
		bm.printInBits(-4);
	}
	
	public void printDoubleInBinary(double val) {
		int intPortion = (int)val;
		double floatPortion = (val - intPortion);
		String s = "";
		while(intPortion > 0) {
			s = (intPortion & 1) + s;
			intPortion = intPortion >> 1;
		}
		System.out.println("intportion =>" +s);
		s = s+".";
		String f = "";
		while(floatPortion != 0) {
			double prod = (double)(floatPortion * 2);
			f = f + (int) prod;
			floatPortion = (prod - (int)prod);
		}
		
		s =s + f;
		System.out.println(s);
	}
	
	public void swapOddEvenBits(int num) {
		
		for(int i=0; i<32; i++) {
			int bit_0 = num & (1 << i);
			int bit_1 = num & (1 << (i+1));
			if((bit_0 ^ bit_1) == 1) {
				num = flipBit(num, i);
				num = flipBit(num, i+1);
			}
		}
		
		System.out.println(num);
	}
	// 1001 , 0110 ^ 1101 => 1011
	private int flipBit(int num, int i) {
		return  num ^ (1 << i);
	}
	
	public void printInBits(int num) {
		String s = "";
		int shiftBy = 32;
		while(shiftBy > 0) {
			s = (num & 1) + s;
			num = num >> 1;
			shiftBy--;
		}
		System.out.println(s);
	}
	// 2^9, 2^8, 2^6, 2^4, 2^3
	public int numOfBitsReqToConvert(int from, int to) {
		int count  = 0;
		int shiftBy = 32;
		while(shiftBy > 0) {
			if((from & 1) != (to & 1)) {
				count++;
			}
			from = from >> 1;
			to = to >> 1;
			shiftBy--;
		}
		
		return count;
	}
	
	public int stringBitsToInteger(char c[]) {
		int len = c.length;
		int n = 0;
		for(int i=0; i<c.length; i++) {
			--len;
			if(c[i] == '1')
				n = n+ (int)Math.pow(2,len);
		}
		return n;
	}
	
	public void merge(int m, int n, int i, int j) {
		for(int temp = i; temp<j; temp++) {
			m = m & ~(1 << temp);
		}
		for(int temp = 0; temp < i; temp++) {
			n = n << 1;
		}
		
		m = m | n;
		System.out.println("merge ->"+m);
	}

}
