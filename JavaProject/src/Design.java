
class PrivCons {
	public PrivCons(int i) {
		// TODO Auto-generated constructor stub
	} 
	
	private PrivCons() {
		// TODO Auto-generated constructor stub
	}
}

class Sub extends PrivCons {

	public Sub(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}
	
}

public class Design {
	public static void main(String args[]) {
		AbsExt absExt = new AbsExt();
		absExt.fun();
	}
}

abstract class Abs { 
	abstract void funAbs();
	
	void fun() {
		System.out.println("fun called !");
		funAbs();
	}
}

class AbsExt extends Abs {

	@Override
	void funAbs() {
		System.out.println("funAbs called !");
		
	}
	
}

abstract class AbsShape { 
	abstract Shape getShape(String type);
}

class AbsShapeImpl extends AbsShape {

	@Override
	Shape getShape(String type) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
}

interface Shape { 
	void draw();
}


class Cir implements Shape {

	@Override
	public void draw() {
		
		System.out.println("Cir");
	}
	
}

class Rect implements Shape {

	@Override
	public void draw() {
		
		System.out.println("Rect");
	} 
	
}

class Sqr implements Shape {

	@Override
	public void draw() {
		
		System.out.println("Sqr");
	}  
	
}

class C implements Int1, Int2 {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
}