package pack;

import java.awt.image.ReplicateScaleFilter;

public class AZIE {

	public static void main(String[] args) {
		secondRotationOfFirst("abc", "cab");
		int a[] = {0,1,3,2};
		isSuccessiveGrayCode(a);
		replace(1020, 0, 5);
	}
	
	// 102
	public static void replace(int num, int r, int w) {
		int exp = 10; 
		int count = 0;
		int res = 0;
		while(num != 0) {
			if(num % 10 == r) {
				res = res + w * (int)Math.pow(exp, count);
			} else {
				res = res + (num%10) * (int)Math.pow(exp, count);
			}
			count++;
			num = num/10;
		}
		
		System.out.println("num = "+res);
	}
	
	// abc cab bca //abcabc
	public static void secondRotationOfFirst(String s1, String s2) {
		if(s1 == null || s2 == null) {
			return;
		}
		
		if(s1.length() != s2.length()) {
			return;
		}
		
		if((s1+s1).indexOf(s2) != -1) {
			System.out.println(s2+" is substring of "+s1);
		}
	}
	
	public static void isSuccessiveGrayCode(int a[]) {
		
		for(int i=1; i<a.length; i++) {
			if((a[i] ^ a[i-1]) == 0) {
				System.out.println("No");
				break;
			}
		}
		System.out.println("Yay");
	}

}
