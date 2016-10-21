/*
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

import j7DesignPatternsCourse.reflection.IntBaseArray;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import General.BitsShifter;
import General.CheckPolymorphism;
import General.MyError;
import General.MySerializable;
import General.MySingelton;
import General.RTException;
import General.checkDefaultForInterfaces;
import General.checkDefaultForInterfaces_Class;
import InnerClasses.InClassD;
import InnerClasses.InClassE;
import InnerClasses.Outer2;
import MyReflection.Investigator;
import MyReflection.Reflecting;
import People.Cop;
import People.Person;
import People.RoboCop;
import Shapes.Box;
import Shapes.MyShape;
import Shapes.Rectangle;
import Shapes.Triangle;

/**
 * @author IZIKG
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class HelloWorld {
	
	public static void main(String[] args) {
		
		try
		{
			//System.out.println(InetAddress.getByName("127.0.0.1").toString());
			//testConst();
			//testMisc();
			//testThreads();
			//testSystemProperies();
			//testBitShifting();
			//testShapes();
			//testSystemProperies();
			//testMySingelton();
			//testPolymorphismAndSingleton();
			//testMethodOverloading();
			//testInner();
			//testSpecialExceptions();
			//testTryAndCatch();
			//testReflection();
			//testSynchronizedInheritance();
			//testFileReadAndWrite();
			//testMySerializable();
			//testCommandLineParameters(args);
			//testBitsShifter();
			//General.Stam.testFinalMethod();
			//General.InitOrder.testInitOrder();
			//testArrayBase();
			//j7DesignPatternsCourse.dynamicClassLoading.Main.go();
			//Stam.testVirtualMethod();
			//Stam.testFinalMethod();
			//MySerializable.checkMySerializableWithoutDefaultCtor();
			//MySerializable.checkSimpleNonSerializable();
			//MySerializable.checkCannotBeSerializable();
			//testReadFromFile();
			
			
			String a = "TrUe";
			String b = "True";
			
			boolean ba = new Boolean(a).booleanValue();
			boolean bb = new Boolean(b).booleanValue();
			
			System.out.println(ba);
			System.out.println(bb);
				
			
		}
		catch (Exception e)
		{
			System.out.println("Error occured");
			e.printStackTrace();
			System.exit(1);
		}
		finally
		{
			//System.runFinalizersOnExit(true);
			System.out.println("The End");			
		}
	}
	
	public static void avoidWarningLocalVarNeverUsed(Object o){}
	
	public static void testInner() {
		Outer2 outer = new Outer2();
		
		System.out.println("Working on \'d\'");
		InClassD d = outer.getInnerClassA();
		System.out.println(d);
		
		//Here you can see that the inner class instance "e" holds "outer" object inside it
		//changing "outer.size" influences "e" as well
		System.out.println("Working on \'e\'");
		InClassE e = outer.getInnerClassE();
		System.out.println(e);
		outer.setSize(10);
		System.out.println(e);
		
		//Here you can see that 2 different instances of "InClassE" holds a reference to the same
		//object "outer". 
		System.out.println("Working on \'e1\' and \'e2\'");
		InClassE e1 = outer.getInnerClassE();
		InClassE e2 = outer.getInnerClassE();		
		System.out.println(e1);
		System.out.println(e2);
		
		outer.setSize(6);
		System.out.println(e1);
		System.out.println(e2);
		
		/*
				Outer2.Inner inner = outer.new Inner();
				Outer2.Inner inner_stand_alone = new Outer2().new Inner();
				
				System.out.println("inner.size="+inner.getSize());
				System.out.println("inner_stand_alone.size="+inner_stand_alone.getSize());
				
				inner.increment();
				inner_stand_alone.increment();
		
				System.out.println("inner.size="+inner.getSize());
				System.out.println("inner_stand_alone.size="+inner_stand_alone.getSize());
		*/
	}
	
	
	public static void testPolymorphismAndSingleton() {
		//MySingelton a = MySingelton.getCheckSingelton();
		//MySingelton b = MySingelton.getCheckSingelton();
		CheckPolymorphism c = new CheckPolymorphism();
		
		//avoidWarningLocalVarNeverUsed(a);
		//avoidWarningLocalVarNeverUsed(b);
		avoidWarningLocalVarNeverUsed(c);
	}
	
	public static void testMisc() throws Exception
	{			
		MyShape s=null;
		Box b=null;
		Rectangle r=null;
		MyShape[] shapes = new MyShape[3];
			
		int[] arr=new int[0];
			
		if (arr==null) {
			System.out.println("arr is null");				
		}
			
			
		shapes[0] = new Rectangle();
		shapes[1] = new Box();
		shapes[2] = new Triangle();
			
		b = new Box();
		s=b;
		r=b;
		r=(Rectangle)shapes[0];
			
		List lst = Arrays.asList(shapes);
			
		ObjectOutputStream oos = 
			new ObjectOutputStream(
				new FileOutputStream("C:\\Shapes.txt"));
		oos.writeObject(lst);
		
		lst=null;
		shapes[0]=null;
		shapes[1]=null;
		shapes[2]=null;
			
		ObjectInputStream ois = 
			new ObjectInputStream(
				new FileInputStream("C:\\Shapes.txt"));
		shapes = (MyShape[]) ois.readObject();
		
		for (int i=0 ; i<shapes.length ; i++) {
			if (shapes[i]==null) {
				System.out.println("shapes["+i+"]=null");
			}
			else {
				System.out.println("shapes["+i+"]="+shapes[i].toString());
			}
		}
			
		avoidWarningLocalVarNeverUsed(s);
		avoidWarningLocalVarNeverUsed(r);
	}
	
	public static void testPeople()
	{
		Person p1 = new Cop();
		
		System.out.println("===");
		System.out.println("p1:");
		
		p1.setName("p1");
		p1.setHeight(1.85);
		System.out.println(p1);
		System.out.println(new Cop("p2",1.65,Cop.e_RAdvanced));
		
		System.out.println("===");
		System.out.println("c1:");
		
		Cop c1 = new Cop();
		c1.setRank(Cop.e_RAdvanced);
		System.out.println(c1);

		
		System.out.println("===");
		System.out.println("rc1:");
		
		
		RoboCop rc1 = new RoboCop();
		rc1.setModel("Rexo23Fx");
		rc1.setPrvName("we");
		System.out.println(rc1);
		System.out.println("===");
		
		
	}

	public static void testShapes() throws IOException, ClassNotFoundException
	{
		MyShape[] shapes = new MyShape[15];
		
		for(int i=0 ; i<shapes.length ; i++) {
			shapes[i] = MyShape.getRandomShape();
		}
		
		ObjectOutputStream out =
			new ObjectOutputStream(
				new FileOutputStream("C:\\Shapes.txt"));
		out.writeObject(shapes);
		out.close();

		/*
		DataInputStream dis = 
			new DataInputStream(
				new FileInputStream(
					new File("C:\\Shapes.txt")));
		
		
		for(int i=0 ; i<shapes.length ; i++) {
			shapes[i].paint();			
		}
		
 		
		shapes = new MyShape[15];
		ObjectInputStream in =
			new ObjectInputStream(
				new FileInputStream("C:\\Shapes.txt"));
		shapes = (MyShape[]) in.readObject();
		
		for(int i=0 ; i<shapes.length ; i++) {
			shapes[i].paint();			
		}
		
		in.close();
		*/
	}
/*
	public static void testInner() {
		Outer2 outer = new Outer2();
		
		Outer2.Inner inner = outer.new Inner();
		Outer2.Inner inner_stand_alone = new Outer2().new Inner();
		
		System.out.println("inner.size="+inner.getSize());
		System.out.println("inner_stand_alone.size="+inner_stand_alone.getSize());
		
		inner.increment();
		inner_stand_alone.increment();

		System.out.println("inner.size="+inner.getSize());
		System.out.println("inner_stand_alone.size="+inner_stand_alone.getSize());
		
	}
*/
	public static void testSystemProperies() {
		List systemPropertiesList = new ArrayList(System.getProperties().entrySet());

		
		Class a = systemPropertiesList.getClass();		
		print(a);
		print(new Long(a.getClasses().length));
		print(new Long(new Box().getClass().getInterfaces().length));
		
		List classesList = Arrays.asList(a.getClasses());
		
		printSorted(systemPropertiesList);
		
		avoidWarningLocalVarNeverUsed(classesList);

	}

	public static void testMySingelton() {
		
		MySingelton a = MySingelton.getCheckSingelton();
		MySingelton b = MySingelton.getCheckSingelton();
		a.P();
		b.P();
	}

	public static void printSorted(List L) {
			Collections.sort(L, new StringCompare());
		Iterator it = L.iterator();
		while (it.hasNext())
		{
			print(it.next());
		}
	}

	public static void testBitShifting() {
		double a=123.0/5;
		bprint((int)a);
		bprint((int)-128.0);
		bprint(new Integer(-128>>1).intValue());
		bprint(new Integer(-128>>>1).intValue());
		bprint(new Integer(-128<<1).intValue());
	}
	
	public static void print(Object s) {
		System.out.println(s);
	}
	public static void print(double d) {
		System.out.println(""+d);
	}
	public static void bprint(int num) {
		int mask = 1;
		String result=" ["+num+"] (int)";
		while (mask>0)
		{
			result = ((num & mask)>0 ? 1 : 0) + result;
			mask = mask << 1;
			
		}
		System.out.println(result);
	}
	
	public static void bprint(long num) {
		int mask = 1;
		String result=" ["+num+"] (long)";
		while (mask>0)
		{
			result = ((num & mask)>0 ? 1 : 0) + result;
			mask = mask << 1;
			
		}
		System.out.println(result);
	}
/*
	public static void testThreads() {
		SimpleThread arr[] = new SimpleThread[10];

		for (int i=arr.length-1 ; i>=0; i--) {
			arr[i] = new SimpleThread("#"+i);
		}
		
		for (int i=arr.length-1 ; i>=0; i--) {
			arr[i].start();
		}
		
	}

	public static void testConst() {
		T a;
		final T b;
		
		a = new T(1);
		b = new T(2);

		getNonConstParams(a);
		getConstParams(a);
		
	}
	
	private static void getNonConstParams(T a) {
		a = new T(a.getVal()+1);
	}
	
	private static void getConstParams(final T a) {
		a.setVal(4);		 
	}
*/
	public static void testInetAddress() throws UnknownHostException {
		
		System.out.println(InetAddress.getByName("127.0.0.1").toString());
		
		MyShape s;
		Box b;
		Rectangle r;
		MyShape[] shapes = new MyShape[3];
		
		shapes[0] = new Rectangle();
		shapes[1] = new Box();
		shapes[2] = new Triangle();
		
		b = new Box();
		s=b;
		r=b;
		r=(Rectangle)shapes[0];
		b=(Box)shapes[0];
		
		avoidWarningLocalVarNeverUsed(s);
		avoidWarningLocalVarNeverUsed(r);
	}
	
	public static void testReflection() {
		Reflecting.exploreObject();
	}
	
	public static void testSynchronizedInheritance() {
		//create new class to extend "checkDefaultForInterfaces_Class"
		//the function "checkDefaultForInterfaces_Class.f" is synchronized
		//here is an example of "loosing" the synchronized skill during overriding 
		checkDefaultForInterfaces a = new checkDefaultForInterfaces_Class() {
			public void f() {}
		};		
		Investigator.showMethod(a, "f");	//show that it is not synchronized 
	}

	public static void testMethodOverloading() {
		Box b = new Box();
		Rectangle r = new Rectangle();

		try {
			b.func();
			r.func();
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testSpecialExceptions() {
		System.out.println("Inside \'testSpecialExceptions\'");
		try {
			//throwRTException();
			throwMyError();
		}
		catch (RTException rte) {
			System.out.println("RTException was catched.");
			System.out.println(rte);
		}
		catch (Exception e ) {
			System.out.println("Exception was catched.");
			System.out.println(e);
		}
		catch (MyError mye) {
			System.out.println("MyError was catched.");
			System.out.println(mye);			
		}
		catch (Throwable t ) {
			System.out.println("Throwable was catched.");
			System.out.println(t);
		}
	}
	
	protected static void throwRTException() throws RTException {
		throw new RTException();
	}
	
	protected static void throwMyError() throws MyError {
		throw new MyError();
	}
	
	public static void testTryAndCatch() {
		try {
			throwAllKindsOfExceptions();
		}
		catch (RTException rte) {
			System.out.println("RTException was catched.");
			System.out.println(rte);			
		}
		catch (NullPointerException npe) {
			System.out.println("NullPointerException was catched.");
			System.out.println(npe);
		}
		/* Not all types of exceptions are catched */
		finally {
			System.out.println("finally");
		}
	}

	protected static void throwAllKindsOfExceptions() /* throws RTException,NullPointerException  -- don't have to declare RunTimeExceptions */ {
		throw new RTException();
		//throw new NullPointerException();
	}	
	
	public static void testFileReadAndWrite() {		
		try {
			BufferedReader br = new BufferedReader (new FileReader("C:\\1.txt"));
			String line = null;
			System.out.println("FileOK");
			do {
				line = br.readLine();
				if (line!=null)
					System.out.println(line);
			}while (line!= null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void testMySerializable() {
		try {
			
			
			MySerializable o = new MySerializable();
			o.add("1");
			o.add("2");
			o.add("4");
			System.out.println(o);
			
			OutputStream out = new FileOutputStream("C:\\MySerializable.txt");
			writeMySerializable(o, out);
			o.clear();
			System.out.println(o);
			
			InputStream in = new FileInputStream("C:\\MySerializable.txt");
			o = readMySerializable(in);
			System.out.println(o);
			
		}
		catch (IOException ioe) {
			
		}
	}
	
	protected static void writeMySerializable(MySerializable obj, OutputStream out) throws IOException {
		ObjectOutputStream objOut = new ObjectOutputStream(out);
		objOut.writeObject(obj);
		
	}
	protected static MySerializable readMySerializable(InputStream in) throws IOException {
		ObjectInputStream objIn = new ObjectInputStream(in);
		try {
			return (MySerializable) objIn.readObject();
		} catch (ClassNotFoundException e) {
			System.out.println("Can\'t read from file - object not of type \'MySerializable\'.");			
		}
		return null;
	}
	
	public static void testCommandLineParameters(String[] args) {
		for (int i=0 ; i<args.length ; i++) {
			System.out.println("args[" + i + "] = " + args[i]);
		}
	}
	
	public static void testBitsShifter() {
		int num = 1;
		num = num << 31;
		num = num | 1;
		
		BitsShifter a = new BitsShifter(num);
		
		System.out.println("value = " + a.toInt());
		System.out.println("In binary         = " + a);
		//System.out.println("ShiftLeft         = " + a.ShiftLeft());		
		//System.out.println("ShiftRight        = " + a.ShiftRight(2));
		System.out.println("ShiftRightUS      = " + a.ShiftRightUS(2));		
		System.out.println("setBitVal(5, 0)   = " + a.setBitVal(5, 0));
		System.out.println("setBitVal(11, 1)  = " + a.setBitVal(11, 1));
		
		
	}
	
	public static void testArrayBase() {
	    long lStart = System.currentTimeMillis();
	    IntBaseArray iba = new IntBaseArray(500000, 0);
	    long lEnd = System.currentTimeMillis();
	    
	    for (int i = 0 ; i < 500000 ; ++i) {
	    	iba.add(i);
	    }
	    for (int i = 0 ; i < iba.size() ; ++i ) {
	    	iba.get(i);
	    }	      
	    
	    System.out.println(lEnd - lStart);
	  }
	
	public static void testReadFromFile() throws IOException {
		DataOutputStream out = new DataOutputStream(
				new FileOutputStream("\\\\izikg01\\ShareFolder\\Shapes.txt"));
		out.writeBytes("sd");
		DataInputStream in = new DataInputStream(
				new FileInputStream("\\\\izikg01\\ShareFolder\\Shapes.txt"));
		byte[] arr = new byte[in.available()];
		in.read(arr);
		String s = new String(arr);
		
		System.out.println(s);

	}
	
	public static int testFinaly() throws Exception {
		try {
			throw new Exception("testFinaly");			
		}
		catch (IOException e){
			System.out.println(e);
			
		}
		finally {
			System.out.println("testFinaly is about to return to ");
		}
	}

}

class StringCompare implements Comparator
{
	public int compare(Object arg0, Object arg1) {
		return arg0.toString().compareTo(arg1.toString());

	}

}



