import java.util.*;
import java.lang.reflect.*;

class SandboxTest{

	static class CommandClassLoader extends ClassLoader{
	
		@Override
		public Class<?> findClass(String name)
		throws ClassNotFoundException{
			String file = name.replace(".", "/") + ".claxx";
			byte[] binaries = DataFile.getBytes(file);
			if(binaries == null)
				throw new ClassNotFoundException(name);
			return super.defineClass(name, binaries, 0, binaries.length);
		}
	}

	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(System.in);
		System.setProperty("java.security.policy", "sandbox.policy");
		System.setSecurityManager(new SecurityManager());
		for(;;){
			System.out.print("SBT>");
			String cmd = input.next();
			if(cmd.equals("quit")) break;
			try{
				Class<?> cls = Class.forName("commands." + cmd, 
					true, new CommandClassLoader());
				Method meth = cls.getMethod("execute", String.class);
				meth.invoke(null, "SBT");
			}catch(InvocationTargetException e){
				System.out.printf("ERROR: %s%n", e.getTargetException());
			}catch(Exception e){
				System.out.printf("ERROR: %s%n", e);
			}
			System.out.println();
		}
	}
}











