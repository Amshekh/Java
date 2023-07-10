interface Filter{

	boolean isAllowed(int value);
}

class Algorithm{
	
	public static int addAll(int last){
		int sum = 0;
		for(int i = 1; i <= last; i++){
			sum += i;
		}
		return sum;
	}

	public static int addIf(int last, Filter check){
		int sum = 0;
		for(int i = 1; i <= last; i++){
			if(check.isAllowed(i)) sum += i;
		}
		return sum;
	}
}

class CallbackTest{

	//Nested member class
	static class OddFilter implements Filter{
		
		public boolean isAllowed(int value){
			return (value % 2) == 1;
		}
	}

	//Inner member class
	class MultipleFilter implements Filter{
		
		private int target;
	
		public MultipleFilter(int target){
			this.target = target;
		}

		public boolean isAllowed(int value){
			return (value % target) == 0;
		}
	}

	public static void main(String[] args){
		int limit = args.length == 0 ? 100 : Integer.parseInt(args[0]);
		System.out.printf("Sum of all integers upto %d is %d%n",
			limit, Algorithm.addAll(limit));
		Filter f = new CallbackTest.OddFilter();
		System.out.printf("Sum of odd integers upto %d is %d%n",
			limit, Algorithm.addIf(limit, f));
		Filter g = new CallbackTest().new MultipleFilter(7);
		System.out.printf("Sum of multiples of 7 upto %d is %d%n",
			limit, Algorithm.addIf(limit, g));
		final int d = 5;
		Filter h = new Filter(){
			public boolean isAllowed(int value){
				return (value % d) != 0;
			}
		};
		System.out.printf("Sum of integers not divisible by 5 "
			+ "upto %d is %d%n", limit, Algorithm.addIf(limit, h));
	}
}














