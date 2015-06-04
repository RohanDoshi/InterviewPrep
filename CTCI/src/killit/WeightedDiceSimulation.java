package killit;

import java.util.Random;

public class WeightedDiceSimulation {
	private static Random r= new Random();

	public static int roll(int[] n) {
			int[] wieghtedSum = new int[n.length];
			wieghtedSum[0] = n[0];
			for(int i=1;i<wieghtedSum.length;i++) { 
				wieghtedSum[i] = wieghtedSum[i-1]+n[i];
			}
			int p = r.nextInt(100);
			for(int i=0;i<wieghtedSum.length-1;i++) { 
				if(p <= wieghtedSum[i]) 
					return i+1;
				else if(p > wieghtedSum[i] && p<=wieghtedSum[i+1]) {
					return i+2;
				}
			}
			return n.length;
	}
	public static void main(String[] args) {
		int[] n = new int[] {20,30,10,0,20,20};
		for(int i=0;i<10; i++ ) 
			System.out.println(roll(n));
	}
}

