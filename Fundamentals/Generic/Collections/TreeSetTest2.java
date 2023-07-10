import java.util.*;

class TreeSetTest2{

	public static void main(String[] args){
		Comparator<Interval> cmp = new Comparator<Interval>(){
			public int compare(Interval i, Interval j){
				return i.getSeconds() - j.getSeconds();
			}
		};
		Set<Interval> store = new TreeSet<Interval>(cmp);
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


