/*
 * Created on 06/04/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package contacts;

/**
 * @author yossi
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class IllegalAreaCodeException extends InvalidDataException {
	private String	wrongAreaCode;
	
	public IllegalAreaCodeException() {
		wrongAreaCode="";
	}
	
	public IllegalAreaCodeException(String wrongAreaCode) {
		this.wrongAreaCode=wrongAreaCode;
	}
	
	public String toString() {
		return super.toString() +
				"Illegal area code: [" + wrongAreaCode + "]\n" /*+ 
				"The length of an area code can be 3 chars maximum."*/; 
	}
}
