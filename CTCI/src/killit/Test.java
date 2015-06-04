package killit;

public class Test {

	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<>();
		for(int i=0; i<5; i++)
			list.add(i*10);
		
		for(int i=0; i<5; i++)
			if(i%2 == 0)
				System.out.println(list.get(i));
			else
				list.remove(i);
	}

}
