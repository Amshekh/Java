import java.util.*;

class HashSetTest{

	public static void main(String[] args){
		Set<Interval> store = new HashSet<Interval>();
		store.add(new Interval(12, 31));
		store.add(new Interval(15, 22));
		store.add(new Interval(18, 43));
		store.add(new Interval(16, 54));
		store.add(new Interval(11, 15));
		store.add(new Interval(14, 82));
		for(Interval i : store)
			System.out.println(i);
	}
}


