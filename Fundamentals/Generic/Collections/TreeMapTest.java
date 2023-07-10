import java.util.*;

class TreeMapTest{

	public static void main(String[] args){
		Map<String, Interval> store = new TreeMap<String, Interval>();
		store.put("monday", new Interval(12, 31));
		store.put("tuesday", new Interval(15, 22));
		store.put("wednesday", new Interval(18, 43));
		store.put("thursday", new Interval(16, 54));
		store.put("friday", new Interval(11, 15));
		store.put("tuesday", new BigInterval(1, 15, 22));
		for(Map.Entry<String, Interval> e : store.entrySet())
			System.out.printf("%s => %s%n", e.getKey(), e.getValue());
		Scanner input = new Scanner(System.in);
		System.out.print("Key: ");
		String key = input.next();
		Interval value = store.get(key);
		if(value == null)
			System.out.println("No such key!");
		else
			System.out.printf("Value = %s%n", value);
	}
}











