import java.lang.reflect.*;

class ObjectAccessTest{

	static java.util.Date now = new java.util.Date();

	private static void printFields(Object obj, Class<?> c){
		Class<?> sc = c.getSuperclass();
		if(sc != Object.class) printFields(obj, sc);
		Field[] fields = c.getDeclaredFields();
		for(Field f : fields){
			int m = f.getModifiers();
			if(Modifier.isStatic(m)) continue;
			System.out.printf("  %s = ", f.getName());
			try{
				f.setAccessible(true);
				System.out.println(f.get(obj));
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}

	private static void printInstance(Object obj){
		Class<?> c = obj.getClass();
		System.out.printf("%s fields%n", c.getName());
		printFields(obj, c);
	}

	public static void main(String[] args){
		//printInstance(new Interval(3, 45));
		printInstance(new BigInterval(2, 3, 45));
	}
}













