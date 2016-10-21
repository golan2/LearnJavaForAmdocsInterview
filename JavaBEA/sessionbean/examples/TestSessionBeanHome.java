/*
 * TestSessionBeanHome.java
 */
package examples;

/**
 * Home interface for TestSessionBean.
 * @author Deepak Kumar
 * @Web http://www.roseindia.net
 * @Email deepak@roseindia.net
 */

public interface TestSessionBeanHome
   extends javax.ejb.EJBHome
{
   public examples.TestSessionBean create()
      throws javax.ejb.CreateException,java.rmi.RemoteException;

}
