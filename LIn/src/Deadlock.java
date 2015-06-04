
public class Deadlock {
	
	private A a = new A();
	private B b = new B();
	
	Thread t1 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			while(true) {
				a.A_Method(b);
				
			}
		}
	});
	
	Thread t2 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			while(true)
				b.B_Method(a);
		}
	});

	public static void main(String[] args) {
		
		Deadlock d = new Deadlock();
		d.t1.start();
		d.t2.start();
	}

}

class A {
	
	public synchronized void A_Method(B b) {
		try {
            Thread.sleep(10000);
        } catch (InterruptedException exc) {
            // 
        }
		b.B_Method(this);
	}
}

class B { 
	public synchronized void B_Method(A a) {
		a.A_Method(this);
		
			try {
                Thread.sleep(10000);
            } catch (InterruptedException exc) {
                // 
            }
	}
}