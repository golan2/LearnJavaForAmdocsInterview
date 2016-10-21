package General;
/*
 * Created on 28/04/2005
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
public class Stam {

	public static void testFinalMethod() {
		T1 t3 = new T3();
		
		t3.f();
	}
	public static void testVirtualMethod() {
		T1 rt = new T3();
		
		System.out.println( (T2)rt);
		
	}
}

class MyString {
	private String[] str;
	
	public MyString(String string)
	{
		str = new String[1];
		str[0]=string;		 
	}

	public MyString(String[] strArray)
	{
		int i;
		
		str = new String[strArray.length];
		
		for (i=0 ; i<strArray.length ; i++)
		{
			str[i] = strArray[i];
		}
				
	}
	
	public String toString()
	{
		int i;
		StringBuffer sbuf = new StringBuffer();
		
		for (i=0 ; i<str.length ; i++)
		{			
			sbuf.append(str[i] + "\n");
		}
		return sbuf.toString();
	}
	

}

class T1 
{
	public void f() {
		System.out.println("T1.f()");
	}
	
	public String toString() {
		return new String("T1");
	}
}

class T2 extends T1
{
	public void f() {
		System.out.println("T2.f()");
	}
	public String toString() {
		return new String("T2");
	}	
}

class T3 extends T2
{
	public void f() {
		System.out.println("T3.f()");
	}
	public String toString() {
		return new String("T3");
	}	
}

class T4 extends T3
{
	public void f2() {
		System.out.println("T4.f()");
	}
}