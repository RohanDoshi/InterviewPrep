import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

interface int1 {
	void dis();
}

interface int2 extends int1 { 
	void dis();
}

public class EfficientStack implements Iterable<String>, Cloneable {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Hashtable<String, String> tab = new Hashtable<>();
		tab.put("1", "one");
		tab.put("2", "two");
		Enumeration<String> en = tab.keys();
		while(en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
		

	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator<String>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public String next() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean hasPrevious() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public String previous() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int nextIndex() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int previousIndex() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void set(String e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void add(String e) {
				// TODO Auto-generated method stub
				
			}
		};
	}

}

class Outer { 
	private int i; 
	static int j;
	
	public void test() {
		System.out.println(i+" "+j+" "+ new Inner().k);
	}
	private  class Inner {
		int k;
		
		public void test() {
			System.out.println(i+" "+j+" "+k);
		}
	}
}
