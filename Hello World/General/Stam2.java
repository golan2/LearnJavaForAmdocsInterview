package General;
import People.RoboCop;

/*
 * Created on 04/08/2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class Stam2 extends Stam {
	
	People.Person getOverrideRetVal() { return new RoboCop("Izik from inside Stam2",180, RoboCop.e_RBeginner, "R2D2"); }

}
