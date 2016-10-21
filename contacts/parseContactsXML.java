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
/*
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
*/



/**
 * @author yossi
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class parseContactsXML {
	
	private List m_contacts = new LinkedList(); 
	private static final String fileName = "C:\\Documents and Settings\\yossi.DANSHIR\\Desktop\\Exam\\contacts.xml";
	
	protected static void useSAX() {
		saxParserForContacts sax = new saxParserForContacts();
		List contacts = sax.readContacts(fileName);
		printContactsList(contacts);
		
	}
	
	protected static void printContactsList(List contacts) {
		Iterator it = contacts.iterator();
		int counter = 1;

		while (it.hasNext()) {
			Contact c = (Contact) it.next();
			System.out.println("Contact #" + counter + ": " + c.toString());
			counter++;
		}
		
	}
    public static void main(String[] args) {
    	useSAX();
    }
   
    
    
    
    /*
     * 
     
     //http://www.idevelopment.info/data/Programming/java/xml/JaxpXmlDomExample.java
    
  
    public void useDOM() {
    	
    	
        // Create File object from incoming file
        File xmlFile = new File(fileName);
 
        try {
        
            // Get Document Builder Factory
            DocumentBuilderFactory factory = 
                    DocumentBuilderFactory.newInstance();

            // Turn on validation, and turn off namespaces
            factory.setValidating(false);
            factory.setNamespaceAware(false);

            // Obtain a document builder object
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            System.out.println("isValidating=" + factory.isValidating());
       
            

            // Parse the document
            Document doc = builder.parse(xmlFile);

            doc.toString();
            
            System.out.println("\n");
            

        } catch (ParserConfigurationException e) {
            System.out.println("The underlying parser does not support " +
                               "the requested features.");
            e.printStackTrace();
        } catch (FactoryConfigurationError e) {
            System.out.println("Error occurred obtaining Document Builder " +
                               "Factory.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	*/
    
    /*
    private static void parseNode(Node node)  {

        switch (node.getNodeType()) {

            case Node.DOCUMENT_NODE:
                System.out.println("<xml version=\"1.0\">\n");
                // recurse on each child
                NodeList nodes = node.getChildNodes();
                if (nodes != null) {
                    for (int i=0; i<nodes.getLength(); i++) {
                        printNode(nodes.item(i), "");
                    }
                }
                break;

            case Node.ELEMENT_NODE:
                String name = node.getNodeName();
                
            	
            
                NamedNodeMap attributes = node.getAttributes();
                for (int i=0; i<attributes.getLength(); i++) {
                    Node current = attributes.item(i);
                    System.out.print(
                        " " + current.getNodeName() +
                        "=\"" + current.getNodeValue() +
                        "\"");
                }
                System.out.print(">");
                
            
                // recurse on each child
                NodeList children = node.getChildNodes();
                if (children != null) {
                    for (int i=0; i<children.getLength(); i++) {
                        printNode(children.item(i), indent + "  ");
                    }
                }
                
                System.out.print("</" + name + ">");
                break;

            case Node.TEXT_NODE:
                System.out.print(node.getNodeValue());
                break;
        }

    }
    */
}
