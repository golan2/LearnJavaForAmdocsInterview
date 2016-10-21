package sessionBeanExample;

import javax.ejb.EJBObject;

public interface TestSessionBean extends EJBObject {
	public java.lang.String SayHello(  )
    throws java.rmi.RemoteException;
}
