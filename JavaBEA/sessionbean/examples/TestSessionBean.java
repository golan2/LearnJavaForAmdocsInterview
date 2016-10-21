/*
* TestSessionBean.java
*
*/ 
package examples;

/**
* Remote interface for TestSessionBean.
* @author Deepak Kumar
* @Web http://www.roseindia.net
* @Email deepak@roseindia.net
*/

public interface TestSessionBean
   extends javax.ejb.EJBObject
{
   /**
    * The method that returns Hello Message
    */
   public java.lang.String SayHello(  )
      throws java.rmi.RemoteException;

}
