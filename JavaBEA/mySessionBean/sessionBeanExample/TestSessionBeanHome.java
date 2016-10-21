package sessionBeanExample;

import javax.ejb.EJBHome;

public interface TestSessionBeanHome extends EJBHome {
	public TestSessionBean create()
    throws javax.ejb.CreateException,java.rmi.RemoteException;
}
