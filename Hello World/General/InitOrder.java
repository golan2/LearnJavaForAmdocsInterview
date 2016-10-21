package General;
/*
import A;
import B;
import C;
import D;
import F;
*/
public class InitOrder {
	public static void testInitOrder() {
		E e = new E();
		e.toString();
	}
}

class A {
	B b  = new B();	
	static C c = new C();
	static D d;
	
	static {
		d = new D();
	}
	
	A() {
		System.out.println("Create A");
	}
	
}

class B {
	B() {
		System.out.println("Create B");
	}
}

class C {
	C() {
		System.out.println("Create C");
	}
}

class D {
	D() {
		System.out.println("Create D");
	}
}

class E extends A  {
	F f = new F();
	E() {
		System.out.println("Create E");
	}	
}

class F {
	F() {
		System.out.println("Create F");
	}	
}