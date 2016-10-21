package General;
/*
 * Created on Jul 21, 2005
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
public class MySingelton {
	static MySingelton  innerObject;
	int i;
	
	private MySingelton () {
		System.out.println("Creaing MySingelton");
	}
	
	static public MySingelton getCheckSingelton() {
		if (innerObject==null) {
			innerObject = new MySingelton();
		}
		return innerObject;		
	}
	
	public void P() { 
		
		System.out.println("innerObject = " + innerObject);
		System.out.println("i = " + i);
		
	}
}
