/*
* SessionBean.java
*
*/ 
package examples;

//Java imports
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;


/**
* @author Deepak Kumar
* @Web http://www.roseindia.net
* @Email deepak@roseindia.net
*/


/**
*
* @ejb:bean name="ShoppingCart"
*			display-name="Shopping Cart Session Bean"
*			type="Stateful"
*			transaction-type="Container"
*			jndi-name="ShoppingCart"
*			view-type="remote"
*
* @ejb:transaction type="Supports"
*
* @ejb:permission unchecked=""
*
**/

 

public class ShoppingCartStatefulSessionBean implements SessionBean{

    Vector v = new Vector();
    String submit = null;
    String item = null;

	public void ejbCreate() throws CreateException {

	}

	public void setSessionContext( SessionContext aContext ) throws EJBException {

	}

 

	public void ejbActivate() throws EJBException {

	}

	public void ejbPassivate() throws EJBException {

	}

	public void ejbRemove() throws EJBException {

	}


 /**
   *  The method that adds the item
   *
   *  @ejb:interface-method view-type="remote"
   */

    public void addItem(String name) {
	v.addElement(name);
    }

 /**
   *  The method that removes the item
   *
   *  @ejb:interface-method view-type="remote"
   */
    public void removeItem(String name) {
	v.removeElement(name);
    }

 /**
   *  The method that set the item name
   *
   *  @ejb:interface-method view-type="remote"
   */
    public void setItem(String name) {
	item = name;
    }
    
   /**
   *  The method that sets the submit action
   *
   *  @ejb:interface-method view-type="remote"
   */

	public void setSubmit(String s) {
	submit = s;
    }

 /**
   *  The method that returns the all the items in the cart
   *
   *  @ejb:interface-method view-type="remote"
   */

    public String[] getItems() {
	String[] s = new String[v.size()];
	v.copyInto(s);
	return s;
    }
    
}

