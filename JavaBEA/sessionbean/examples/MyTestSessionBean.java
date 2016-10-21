/*
* SessionBean.java
*
*/ 
package examples;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

/**
* @author Deepak Kumar
* @Web http://www.roseindia.net
* @Email deepak@roseindia.net
*/

public class MyTestSessionBean implements SessionBean{

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
	*  The method that returns Hello Message
	*
	*/
	public String SayHello(){
		  String msg="Hello! I am Session Bean";
		  System.out.println(msg);
		  return msg;
	}

}

