/*
 * Created on 06/04/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package contacts;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//http://www.xslt.com/html/xsl-list/2002-06/msg01075.html

/**
 * @author yossi
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class saxParserForContacts extends DefaultHandler {

	
	private List 	m_contacts;
	private Contact	m_currentConact;
	private Phone	m_currentPhone;

	//States machine flags: (sm_ stands for states machine)
	//Better use a Map to map the strings to T/F
	boolean sm_isInsideContactsList			= false;
	boolean sm_isInsideContact				= false;
	boolean sm_isInsideName					= false;
	boolean sm_isInsideFirstName			= false;
	boolean sm_isInsideLastName				= false;
	boolean sm_isInsideAddress				= false;
	boolean sm_isInsideStreet				= false;
	boolean sm_isInsideCity					= false;
	boolean sm_isInsideCountry				= false;
	boolean sm_isInsidePhonesList			= false;
	boolean sm_isInsidePhone				= false;
	
	
	//TODO: replace all "//error!" with error code handling
	
	
	//TODO: create a states-machine to follow & verify the file structure
	
	public List readContacts(String fileName) {
		
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse( new File(fileName), this );
			return m_contacts;
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return null;
	}
	
	//public void startDocument() {}
	
	//public void endDocument() {}
	
	
	public void startElement(String uri, String name ,String qName, Attributes atts) {

		
		if (qName.equals("CONTACTS")) {		
			m_contacts = new LinkedList();
			sm_isInsideContactsList=true;
		}
		else if (qName.equals("CONTACT")) {
			if (sm_isInsideContactsList) {
				//initialize flags
				sm_isInsideContact=true;				
				
				m_currentConact = new Contact();
			}
			else {
				//error!
			}
		}
		else if (qName.equals("NAME")) {
			//ok so we are about to get the name.
			//next will be the first name and last name so we set their waiting flags
			if (sm_isInsideContact) {
				sm_isInsideName=true;
			}
			else {
				//error!
			}
		}
		else if (qName.equals("FIRST")) {
			if (sm_isInsideName) {
				sm_isInsideFirstName=true;
			}
			else {
				//error!
			}
		}
		else if (qName.equals("LAST")) {
			if (sm_isInsideName) {				
				sm_isInsideLastName=true;	
			}
			else {
				//error!
			}
		}
		else if (qName.equals("GENDER")) {
			//ignore
		}
		else if (qName.equals("ADDRESS")) {
			if (sm_isInsideContact) {
				sm_isInsideAddress=true;
			}
			else {
				//error!
			}			
		}
		else if (qName.equals("STREET")) {
			if (sm_isInsideAddress) {
				sm_isInsideStreet=true;	
				//zip and house are attributes.
				//street,city, and country are sub-elements and will be handled later
				m_currentConact.setHouse(Integer.parseInt( atts.getValue("house"))); 
				m_currentConact.setZip(Integer.parseInt( atts.getValue("zip")));
			}
			else {
				//error!
			}
		}
		else if (qName.equals("CITY")) {
			if (sm_isInsideAddress) {
				sm_isInsideCity=true;
			}
			else {
				//error!
			}
		}
		else if (qName.equals("COUNTRY")) {
			if (sm_isInsideAddress) {
				sm_isInsideCountry=true;
			}
			else {
				//error!
			}
		}
		else if (qName.equals("PHONES")) {
			if (sm_isInsideContact) {
				sm_isInsidePhonesList=true;
				m_currentPhone=null;
			}
			else {
				//error!
			}
		}
		else if (qName.equals("PHONE")) {
			if (sm_isInsidePhonesList) {
				sm_isInsidePhone=true;
				//the areacode is an attribute
				//the phone is a sub-element
				m_currentPhone = new Phone();
				try {
					m_currentPhone.setAreaCode(atts.getValue("areaCode"));
				} catch (IllegalAreaCodeException e) {
					//error!
				}
			
			}
			else {
				//error!
			}
		}
		else {
			//error!	
		}
	}
	
	public void endElement(String uri, String localName, String qName) {
		if (qName.equals("CONTACTS")) {
		}
		else if (qName.equals("CONTACT")) {
			m_contacts.add(m_currentConact);
			m_currentConact = null;
			sm_isInsideContact=false;
		}
		else if (qName.equals("NAME")) {
			sm_isInsideName=false;
		}
		else if (qName.equals("FIRST")) {
			sm_isInsideFirstName=false;
		}
		else if (qName.equals("LAST")) {
			sm_isInsideLastName=false;
		}
		else if (qName.equals("GENDER")) {
			//ignore
		}
		else if (qName.equals("ADDRESS")) {
			sm_isInsideAddress=false;
		}
		else if (qName.equals("STREET")) {
			sm_isInsideStreet=false;
		}
		else if (qName.equals("CITY")) {
			sm_isInsideCity=false;
		}
		else if (qName.equals("COUNTRY")) {
			sm_isInsideCountry=false;
		}
		else if (qName.equals("PHONES")) {
			sm_isInsidePhonesList=false;
		}
		else if (qName.equals("PHONE")) {
			m_currentConact.addPhone(m_currentPhone);
			m_currentPhone = null;
			sm_isInsidePhone=false;		
		}
		else {
			//error!	
		}
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		if (sm_isInsideFirstName) {		
			m_currentConact.setFirstName(String.copyValueOf(ch, start, length));
			//sm_isInsideFirstName=false;
		}
		else if (sm_isInsideLastName) {		
			m_currentConact.setLastName(String.copyValueOf(ch, start, length));
			//sm_isInsideLastName=false;
		}
		else if (sm_isInsideStreet) {
			m_currentConact.setStreet(String.copyValueOf(ch, start, length));
		}
		else if (sm_isInsideCity) {
			m_currentConact.setCity(String.copyValueOf(ch, start, length));
		}
		else if (sm_isInsideCountry) {
			m_currentConact.setCountry(String.copyValueOf(ch, start, length));
		}
		else if (sm_isInsidePhone) {
			try {
				m_currentPhone.setPhoneNumber(String.copyValueOf(ch, start, length));
			} catch (IllegalPhoneNumberException e) {
				//error!
			}
		}	
	}

}
