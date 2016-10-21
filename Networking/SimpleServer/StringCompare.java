

/*
 * Created on 12/06/2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */

package SimpleServer;
import java.util.Comparator;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class StringCompare implements Comparator
{
	public int compare(Object arg0, Object arg1) {
		return arg0.toString().compareTo(arg1.toString());

	}

}

