/*
 * Created on Jul 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package synchronizedMethods;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/**  
 * @author IZIKG
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SharedObject {
	static Object			lockForPrint = new Object();
	static File				f = new File("C:\\1.txt");
	static FileOutputStream fos;
	static DataOutputStream dos;
	
	static {
		try {
			fos = new FileOutputStream(f);
			dos = new DataOutputStream(fos);
		}
		catch (FileNotFoundException e) {}
	}
	
	synchronized public void synch(User user) {
		user.incAge();
		print("User " + user.getID() + " (Age=" + user.getAge() + ")inside synch method.");		
	}
	
	public static void print(String msg) {
	
		
		Calendar c = Calendar.getInstance();
		String s = "[" + c.getTime() + ";" + c.getTimeInMillis() +  " - " + msg;
		//synchronized (lockForPrint) 
		{
			System.out.println(s);
			try {
				dos.writeBytes(s + "\n");
			}		
			catch (IOException e) {}
		}
	}	
}
