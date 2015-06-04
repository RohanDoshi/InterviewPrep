
public class IntervalTree {
	private class Interval {
		double from;
		double to;
		public Interval(double from, double to) {
			this.from = from;
			this.to = to;
		}
		Interval left;
		Interval right;
	}
	private Interval root;
	public void add(double from, double to) {
		root = addInterval(root, from, to);
	}
	
	private Interval addInterval(Interval root, double from, double to) {
		if(root == null) 
			return new Interval(from, to);
		
		if(from > root.to) {
			root.right = addInterval(root.right, from, to);
		} else if(to <= root.from) {
			root.left = addInterval(root.left, from, to);
		} else {
			if(from < root.from && to >= root.to) {
				to = root.to-1;
				root.left = addInterval(root.left, from, to);
			} else if(from >= root.from && to > root.to) {
				from = root.to+1;
				root.right = addInterval(root.right, from, to);
			} else {
				
			}
		}
		
		return root;
	}
}
