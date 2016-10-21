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

/**
 *   This is the Test Session Bean
 *
 *   @ejb:bean type="Stateless"
 *             name="CalculatorBean"
 *             jndi-name="CalculatorSessionBean"
 *             display-name="EJB Calculator Session Bean"
 *
 *   @ejb:env-entry name="CalculatorBean" type="java.lang.String" value="calculatorbean"
 */

public class CalculatorSessionBean implements SessionBean{

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
   *  The method that returns the multiplied value
   *
   *  @ejb:interface-method view-type="remote"
   */
	public int multiply(int val1, int val2){
		  System.out.println("I am from multiply : " + val1 + " * " + val2);
		  return val1*val2;
	}

}

