package MyReflection;

import java.lang.reflect.*;

public class Investigator {

	public Investigator() {
	}

	public static void investigateObject(Object o) {
		Class c = o.getClass();
		
		
		System.out.println(c.getName());
		
		System.out.println("Methods:");
		Method []methods = c.getMethods();
		for (int i=0 ; i<methods.length ; i++) {
			Method m = methods[i];
			
			System.out.println("\t" + m.getName());
			System.out.println("\t\tSynchronized=" + Modifier.isSynchronized(m.getModifiers()));
		}	
	}
	
	public static void showMethod(Object o, String methodName ) {
		Method []methods = o.getClass().getMethods();
		
		for (int i=0 ; i<methods.length ; i++) {
			if ( methods[i].getName().equals(methodName))  {
				showMethod(methods[i]);
			}
		}		
	}
	
	protected static void showMethod(Method m) {
		int modi = m.getModifiers();
		StringBuffer buf = new StringBuffer();
		
		buf.append(m.toString());
				
		if (Modifier.isSynchronized(modi)) {
			buf.append("[Synchronized] ");
		}
		if (Modifier.isFinal(modi)) {
			buf.append("[Final] ");
		}
	}
}

