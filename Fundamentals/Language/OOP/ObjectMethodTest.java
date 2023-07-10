class ObjectMethodTest{
	
	public static void main(String[] args){
		Interval a = new Interval(5, 129);
		Interval b = new Interval(3, 55);
		Interval c = new Interval(7, 9);
		Interval d = b;
		System.out.printf("a => %s%n", a);
		System.out.printf("b => %s%n", b);
		System.out.printf("c => %s%n", c);
		System.out.printf("d => %s%n", d);
		System.out.printf("a is identical to b: %b%n", a == b);
		System.out.printf("a is identical to c: %b%n", a == c);
		System.out.printf("b is identical to d: %b%n", b == d);
		System.out.printf("hash-code of a = %x%n", a.hashCode());
		System.out.printf("hash-code of b = %x%n", b.hashCode());
		System.out.printf("hash-code of c = %x%n", c.hashCode());
		System.out.printf("hash-code of d = %x%n", d.hashCode());
		System.out.printf("a is equal to b: %b%n", a.equals(b));
		System.out.printf("a is equal to c: %b%n", a.equals(c));
		System.out.printf("b is equal to d: %b%n", b.equals(d));
		System.out.printf("a + b => %s%n", a.add(b));
		c = null;
		b = null;
		System.gc();
	}
}















