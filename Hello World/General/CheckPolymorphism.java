package General;
import MyReflection.Investigator;

/*
 * Created on Aug 4, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author IZIKG
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CheckPolymorphism {

	public CheckPolymorphism() {
		try {
			//C cc = (C) new A();	//	java.lang.ClassCastException: CheckPolymorphism
			A a = new A();
			A b = new B();
			A c = new C();
			
			/*
			a.f1();
			b.f1();
			c.f1();
			*/
			Investigator.investigateObject(a);
			Investigator.investigateObject(b);
			Investigator.investigateObject(c);
		}
		catch (Exception e) {
			System.out.print(e);
		}
	}
	
	class A {
		public void func() {
			System.out.print("A");
		}
		
		public synchronized void f1() {
			System.out.println("A::f1()");
		}
	}
	class B extends A{
		public void func() {
			System.out.print("B");
		}
		public void f1() {
			System.out.println("B::f1()");
		}
	}
	class C extends B{
		public void func() {
			System.out.print("C");
		}
		public synchronized void f1() {
			System.out.println("C::f1()");
		}
	}
}
