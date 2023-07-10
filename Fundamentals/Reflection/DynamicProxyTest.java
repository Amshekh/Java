import java.lang.reflect.*;

class DynamicProxyTest{

	static class EchoProxy{
		
		public static Object createFor(final Object target){
			final Class<?> tc = target.getClass();
			InvocationHandler handler = new InvocationHandler(){
				public Object invoke(Object proxy, Method meth, 
						Object[] args) throws Exception{
					System.out.printf(">> Invoking %s method of %s%n", 
						meth.getName(), tc);
					return meth.invoke(target, args);
				}
			};
			return Proxy.newProxyInstance(tc.getClassLoader(), 
				tc.getInterfaces(), handler);
		}
	}

	public static void main(String[] args){
		EnglishGreeter eg = new EnglishGreeter();
		Greeter ep = (Greeter) EchoProxy.createFor(eg);
		System.out.println(ep.meet("Jill", 19));		
		System.out.println(ep.leave("Jack"));
	}
}
















