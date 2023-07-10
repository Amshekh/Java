class GenericClassTest1{

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
	}

	public static void main(String[] args){
		IndexedValue<Double> a = new IndexedValue<Double>(12.34);
		System.out.printf("IndexedValue[%d]=>%s%n",
			a.getIndex(), a.getValue());
		//a.setValue("4.5");
		IndexedValue<String> b = new IndexedValue<String>("Monday");
		System.out.printf("IndexedValue[%d]=>%s%n",
			b.getIndex(), b.getValue());
		IndexedValue<Interval> c = new IndexedValue<Interval>(null);
		c.setValue(new BigInterval(1, 2, 30));
		System.out.printf("IndexedValue[%d]=>%s%n",
			c.getIndex(), c.getValue());
	}
}














