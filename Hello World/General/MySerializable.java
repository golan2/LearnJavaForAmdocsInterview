package General;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class MySerializable implements Serializable {
	static final String sFileName = "C:\\MySerializableWithoutDefaultCtor.txt";
	private static final long serialVersionUID = 1L;
	private List list;
	
	public MySerializable () {
		super();
		list = new LinkedList();
	}
	
	public void add(Object o){
		list.add(o);
	}

	public void clear() {
		list.clear();
	}
	
	public String toString() {
		String s ="MySerializable: {";
		
		if (list.size()==0) {
			s += "Empty";
		}
		else {
			Iterator it = list.listIterator();
			while (it.hasNext()) {
				s += it.next() + ", ";
			}			
		}
		
		s += "}";
		return s;		
	}
	
	public int size() { return list.size(); }
	
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		 out.write(list.size());
		 out.writeObject(list);
		 System.out.println("Writing MySerializable: length=" + list.size());
	}
	
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		int length = in.read();
		System.out.println("Reading MySerializable: length=" + length);
		list = (List) in.readObject();
	}
	
	public static void checkMySerializableWithoutDefaultCtor() {
		checkAsTouple();
	}
		
	static void checkAsStandAloneObjects() {
		
		MySerializableWithoutDefaultCtor without = new MySerializableWithoutDefaultCtor(1);
		MySerializableWithDefaultCtor with = new MySerializableWithDefaultCtor();
		
		System.out.println("View objects");		
			System.out.println("with = " + with );			
			System.out.println("without = " + without);			
		
		System.out.println("Write objects to file [" + sFileName + "]");			
			try {
				ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream(sFileName));
				out.writeObject(without);
				out.writeObject(with);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();						
			}
			with = null;
			without = null;
		
		System.out.println("Read objects from file [" + sFileName + "]");
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(sFileName));
				without = (MySerializableWithoutDefaultCtor) in.readObject();
				with = (MySerializableWithDefaultCtor) in.readObject();
				in.close();		
			} catch (IOException e) {
				e.printStackTrace();						
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
			}
		
		System.out.println("View objects");		
			System.out.println("with = " + with );			
			System.out.println("without = " + without);	
	}
		
	static void checkAsTouple() {
		MySerializableTouple touple = new MySerializableTouple(1,2);
		

		System.out.println("View touple");		
			System.out.println("touple =" + touple);
		
		System.out.println("Write touple to file [" + sFileName + "]");			
			try {
				ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream(sFileName));
				out.writeObject(touple);			
				out.close();
			} catch (IOException e) {
				e.printStackTrace();						
			}
			touple = null;
		
		System.out.println("Read touple from file [" + sFileName + "]");
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(sFileName));
				touple = (MySerializableTouple) in.readObject();
				
				in.close();		
			} catch (IOException e) {
				e.printStackTrace();						
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
			}
		
		System.out.println("View touple");
			System.out.println("touple =" + touple);	
	}     

	public static void checkSimpleNonSerializable() {
		
		/*
		 * I have a SimpleNonSerializable which doesn't implement Serializable
		 * I try to serialize it
		 * I get: java.io.NotSerializableException: General.SimpleNonSerializable
		 */
		
		SimpleNonSerializable a = new SimpleNonSerializable();

		a.val = 100;
		
		System.out.println("View SimpleNonSerializable");
			System.out.println("SimpleNonSerializable =" + a);
		
		System.out.println("Write SimpleNonSerializable to file [" + sFileName + "]");			
			try {
				ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream(sFileName));
				out.writeObject(a);			
				out.close();
			} catch (IOException e) {
				e.printStackTrace();						
			}
			a = null;
		
		System.out.println("Read SimpleNonSerializable from file [" + sFileName + "]");
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(sFileName));
				a = (SimpleNonSerializable) in.readObject();
				
				in.close();		
			} catch (IOException e) {
				e.printStackTrace();						
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
			}
	
		System.out.println("View SimpleNonSerializable");
			System.out.println("SimpleNonSerializable =" + a);		
	}

	public static void checkCannotBeSerializable() {
		CannotBeSerializable a = new CannotBeSerializable(121);
		
		System.out.println("View CannotBeSerializable");
			System.out.println("CannotBeSerializable =" + a);
	
		System.out.println("Write CannotBeSerializable to file [" + sFileName + "]");			
			try {
				ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream(sFileName));
				out.writeObject(a);	
				out.close();
			} catch (IOException e) {
				e.printStackTrace();						
			}
			a = null;
		
		System.out.println("Read CannotBeSerializable from file [" + sFileName + "]");
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(sFileName));
				a = (CannotBeSerializable) in.readObject();		//will throw java.io.InvalidClassException: General.CannotBeSerializable; no valid constructor
				
				in.close();		
			} catch (IOException e) {
				e.printStackTrace();						
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
			}
	
		System.out.println("View CannotBeSerializable");
			System.out.println("CannotBeSerializable =" + a);		
	}

}


class MySerializableTouple implements Serializable {
	MySerializableWithoutDefaultCtor without;
	MySerializableWithDefaultCtor with;
	
	private static final long serialVersionUID = 1L;
	
	public MySerializableTouple(int withVal, int withoutVal) {
		this.with = new MySerializableWithDefaultCtor(withVal);
		this.without = new MySerializableWithoutDefaultCtor(withoutVal);
		System.out.println("MySerializableTouple");
	}
	
	public String toString() {
		return super.toString() + "@(" + with.val + "," + without.val + ")";
	}
}

class MySerializableWithoutDefaultCtor implements Serializable {
	int val;
		
	private static final long serialVersionUID = 1L;
	
	public MySerializableWithoutDefaultCtor(int a) {
		System.out.println("MySerializableWithoutDefaultCtor");
		val=a;
	}
	
	public String toString() {
		return super.toString() + "@val=" + val;
	}
}

class MySerializableWithDefaultCtor implements Serializable {
	int val;
	
	
	private static final long serialVersionUID = 1L;
	
	public MySerializableWithDefaultCtor() {
		System.out.println("MySerializableWithDefaultCtor");
	}

	public MySerializableWithDefaultCtor(int a) {
		val = a;
		System.out.println("MySerializableWithDefaultCtor");
	}
	
	public String toString() {
		return super.toString() + "@val=" + val;
	}
}

class NotSerializableWithoutDefaultCtor {
	int val;
	

	public NotSerializableWithoutDefaultCtor(int i) {
		val=i;
	}

	public String toString() {
		return super.toString() + "@val=" + val;
	}

}

class SimpleNonSerializable {
	int val;
	
	public String toString() {
		return super.toString()	+ "@val=" + val;
	}
}

class SimpleSerializable implements Serializable{
	int val;	
	private static final long serialVersionUID = 1L;
	
	public SimpleSerializable() {
		this(0);
	}
	
	public SimpleSerializable(int i) {
		val=i;
	}
	
	public String toString() {
		return super.toString()	+ "@val=" + val;
	}
}

class NonSerializableWithDefaultCtor {
	int val;
	
	public String toString() {
		return super.toString()	+ "@val=" + val;
	}
}

class NonSerializableWithoutDefaultCtor {
	int val;
	
	public NonSerializableWithoutDefaultCtor(int i) {
		val=i;
	}
	
	public String toString() {
		return super.toString()	+ "@val=" + val;
	}
}

/*
 * I have a parent which is not Serializable and according to JavaAPI it must have a default ctor
 * And indeed we get
 * 		java.io.InvalidClassException: General.CannotBeSerializable; no valid constructor
 * in funcition "General.MySerializable.checkCannotBeSerializable" above
 */
class CannotBeSerializable extends NotSerializableWithoutDefaultCtor implements Serializable {
	int val2;

	private static final long serialVersionUID = 1L;
	
	public CannotBeSerializable() {
		this(0);
	}
	
	public CannotBeSerializable(int i) {
		super(i);
		val2=i+1;		
	}
	
	public String toString() {
		return super.toString()	+ "@val2=" + val2;
	}
}
