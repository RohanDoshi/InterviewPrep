package pack;

import java.util.Arrays;
import java.util.Stack;

public class HanoiTower {

	static Stack<Integer> tower[] = new Stack[4];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 tower[1] = new Stack<Integer>();
         tower[2] = new Stack<Integer>();
         tower[3] = new Stack<Integer>();
         
         for (int d = 7; d > 0; d--)
             tower[1].push(d);
        
         System.out.println(Arrays.toString(tower[1].toArray()));
         move(7, 1, 2, 3);   
         System.out.println(Arrays.toString(tower[3].toArray()));
	}
	
	 public static void move(int n, int a, int b, int c)
     {
         if (n > 0)
         {
             move(n-1, a, c, b);     
             int d = tower[a].pop();                                             
             tower[c].push(d);                  
             move(n-1, b, a, c);     
         }         
     }

}
