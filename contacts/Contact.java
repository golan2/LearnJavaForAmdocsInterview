/*
 * Created on 06/04/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package contacts;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yossi
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Contact {
	protected String	m_firstName;
	protected String	m_lastName;
	protected String	m_street;
	protected int		m_zip;
	protected int		m_house;
	protected String	m_city;
	protected String	m_country;
	protected List		m_phones = new LinkedList();
	
	
	
	public String getFirstName() {
		return m_firstName;
	}
	
	public boolean setFirstName(String val) {
		m_firstName = val;
		return true;
	}

	public String getLastName() {
		return m_lastName;
	}
	
	public boolean setLastName(String val) {
		m_lastName = val;
		return true;
	}

	public String getStreet() {
		return m_street;
	}
	
	public boolean setStreet(String val) {
		m_street = val;
		return true;
	}

	public int getZip() {
		return m_zip;
	}
	
	public boolean setZip(int val) {
		m_zip = val;
		return true;
	}

	public int getHouse() {
		return m_house;
	}
	
	public boolean setHouse(int val) {
		m_house = val;
		return true;
	}

	public String getCity() {
		return m_city;
	}
	
	public boolean setCity(String val) {
		m_city = val;
		return true;
	}

	public String getCountry() {
		return m_country;
	}
	
	public boolean setCountry(String val) {
		m_country = val;
		return true;
	}

	//retun an iterator to the phone's list so the client can view but wont be able to add new phones (or some other objects) to the list
	public Iterator getPhonesIterator() {
		return m_phones.iterator();
	}

	//the "val" is already a well-defined phone because we hold "Phone" class responsible for that
	//The retuned value will be as in java.util.Collection.add - ie: if the addition suceeded.
	public boolean addPhone(Phone val) {
		return m_phones.add(val);
	}

	public String toString() {
		return 
			"Name: " + m_firstName + " " + m_lastName + ", " +
			"Address: " + m_street + " " + m_house + " " + m_city + "," + m_country + " , " + m_zip + " , " +
			"Phones: " + getPhonesListAsString();
	}
	
	protected String getPhonesListAsString() {
		StringBuffer buf = new StringBuffer();
		Iterator it = m_phones.iterator();
		while (it.hasNext()) {
			Phone p = (Phone) it.next();
			buf.append(p.toString() + ", ");
		}
		return buf.toString();
	}










}
