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
public class IllegalPhoneNumberException extends InvalidDataException {
	private String	wrongPhoneNumber;
	
	public IllegalPhoneNumberException() {
		wrongPhoneNumber="";
	}
	
	public IllegalPhoneNumberException(String wrongPhoneNumber) {
		this.wrongPhoneNumber=wrongPhoneNumber;
	}
	
	public String toString() {
		return super.toString() +
				"Illegal phone number: [" + wrongPhoneNumber + "]\n" /*+ 
				"The length of a phone number can be 7 chars maximum."*/; 
	}

}
