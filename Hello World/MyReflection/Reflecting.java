/*
 * Created on Jul 24, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package MyReflection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Modifier;

/**
 * @author IZIKG
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Reflecting {

	/**
	 * 
	 */
	public Reflecting() {
		super();		
	}
	
	public void PublicVoidNoParam() {	
	}
	
	public void PublicVoidOneParamDouble(double a) {	
	}
	
	public int PublicIntOneParamDouble(double a) {
		return (int) a;
	}
	
	public static void exploreObject() {
		Object o = new Reflecting();
		Class c = o.getClass();
		
		
		if ( Modifier.isPublic(c.getModifiers()) ) {
			ppp("public ");
		}else if ( Modifier.isProtected(c.getModifiers()) ) {
			ppp("protected ");
		}else if ( Modifier.isPrivate(c.getModifiers()) ) {
			ppp("private ");
		}

		if ( Modifier.isFinal(c.getModifiers()) ) {
			ppp("final ");
		}

		ppp("class " + c.getName() + "\n");
		
		ppp(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		}.getClass().getInterfaces().length + "\n");
		
		
		
		
		ppp("\n");
		ppp((double)1);
		ppp(true);
	
	}	
		
	private static void ppp(Object o) {
		System.out.print(o.toString());
	}

	private static void ppp(double o) {
		System.out.print(o);
	}	
	private static void ppp(boolean o) {
		System.out.print(o);
	
	}	
}
