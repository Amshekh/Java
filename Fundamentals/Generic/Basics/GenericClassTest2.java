class GenericClassTest2{

	static class IndexedValue<V>{
		
		private int index;
		private V value;
		private static int count;

		public IndexedValue(V value){
			index = ++count;
			this.value = value;
		}

		public final int getIndex(){
			return index;
		}

		public final V getValue(){
			return value;
		}
		
		public final void setValue(V value){
			this.value = value;
		}
		
		public final void copyValue(IndexedValue<? extends V> source){
			this.value = source.value;
		}
	}

	private static void print(IndexedValue<?> iv){
		System.out.printf("IndexedValue[%d]=>%s%n",
			iv.getIndex(), iv.getValue());
		//iv.setValue("abcd");
	}

	public static void main(String[] args){
		IndexedValue<Double> a = new IndexedValue<Double>(12.34);
		print(a);
		IndexedValue<String> b = new IndexedValue<String>("Monday");
		print(b);
		IndexedValue<Interval> c = new IndexedValue<Interval>(null);
		IndexedValue<BigInterval> d = new IndexedValue<BigInterval>(
			new BigInterval(1, 2, 30));
		c.copyValue(d);
		print(c);
	}
}














