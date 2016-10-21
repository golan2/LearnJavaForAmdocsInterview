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
 *	The class can easily be inherited in order to change beahvior.
 *	Just override these methods:
 *		validLengthForAreaCode
 *		validLengthForPhoneNumber
 *		isValidCharsOnly
 */
public class Phone {
	protected String 	m_areaCode;
	protected String 	m_phoneNumber;
	
	
	public Phone() {}
	
	public Phone(String areaCode, String phoneNumber) throws InvalidDataException{
		//use the setters - they will throw the relevant exceptions if needed.
		setAreaCode(areaCode);
		setPhoneNumber(phoneNumber);
	}
	
	
	public String getAreaCode() {
		return m_areaCode;
	}
	
	public void setAreaCode(String val) throws IllegalAreaCodeException {
		
		//verify the length
		if (val==null) {
			throw new IllegalAreaCodeException("null");
		}
		if (val.length() > validLengthForAreaCode()) {
			throw new IllegalAreaCodeException(val);
		}
		
		//verify that the area code is composed from digits only
		if (!isValidCharsOnly(val)) {
			throw new IllegalAreaCodeException(val);
		}		
		
		//if we get here then all validity checks were OK.
		m_areaCode=val;		
	}

	
	public String getPhoneNumber() {
		return m_phoneNumber;
	}
	
	public void setPhoneNumber(String val) throws IllegalPhoneNumberException {
		//verify the length
		if (val==null) {
			throw new IllegalPhoneNumberException("null");
		}
		if (val.length() > validLengthForPhoneNumber()) {
			throw new IllegalPhoneNumberException(val);
		}
		
		//verify that the area code is composed from digits only
		if (!isValidCharsOnly(val)) {
			throw new IllegalPhoneNumberException(val);
		}		
		
		//if we get here then all validity checks were OK.
		m_phoneNumber=val;	
	}
	
	//the method can easily be overriden by decendents in order to change data-validity checks
	//current implementation:
	//returns true if all chars in the string are from {0,1,...9}
	//null is ok for us
	protected boolean isValidCharsOnly(String str) {
		
		if (str==null) {
			return true;
		}
		
		//iterate chars and check them
		for (int i=0 ; i<str.length() ; i++) {
			char current = str.charAt(i);
			if (!('0' <= current && current <= '9')) {
				//it is not a digit
				return false;
			}
		}//for
		
		return true;
	}
	
	//allow decendents to change the class behaviour witout the need to re-code
	protected static int	validLengthForAreaCode() 	{ return 3; }
	protected static int	validLengthForPhoneNumber() { return 7; }

	
	public String toString() {
		return m_areaCode + "-" + m_phoneNumber;
	}
}
