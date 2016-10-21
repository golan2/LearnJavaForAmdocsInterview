/*
 * Created on Jul 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package synchronizedMethods;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @author IZIKG
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Main {

	public static void main(String[] args) {
		SharedObject shared = new SharedObject();
		ArrayList users = new ArrayList(10);
		for (int i=0 ; i<10 ; i++) {
			User u = new User(shared);
			users.add(u);			
		}
		
		SharedObject.print("Iterate users and start them.");
		ListIterator it = users.listIterator();
		while (it.hasNext()) {
			((User)it.next()).start();
		}
		
		SharedObject.print("Iterate users and terminate old ones.");
		it = users.listIterator();
		while (it.hasNext()) { 
			User u = (User) it.next();
			SharedObject.print("User [id=" + u.getID() + ",age=" + u.getAge() + "].");
			if (u.getAge()>=(u.getID()+1)) {				
				u.terminate();
			}
		}
		
		SharedObject.print("The End");
		System.exit(0);


	}
}
