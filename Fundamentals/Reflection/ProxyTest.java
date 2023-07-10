class ProxyTest{

	static class EchoProxy{
		
		public static Greeter createFor(final Greeter target){
			final Class<?> tc = target.getClass();
			return new Greeter(){
				public String meet(String name, int age){
					System.out.printf(">> Invoking meet method of %s%n", tc);
					return target.meet(name, age);
				}

				public String leave(String name){
					System.out.printf(">> Invoking leave method of %s%n", 
						tc);
					return target.leave(name);
				}
			};
		}
	}

	public static void main(String[] args){
		EnglishGreeter eg = new EnglishGreeter();
		Greeter ep = EchoProxy.createFor(eg);
		System.out.println(ep.meet("Jill", 19));		
		System.out.println(ep.leave("Jack"));
	}
}
















