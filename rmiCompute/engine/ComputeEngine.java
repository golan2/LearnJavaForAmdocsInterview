package engine;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import compute.Compute;
import compute.Task;

/*
 * UnicastRemoteObject is a convenient (non-mandatory) way to create an object that supports RMI.
 * The UnicastRemoteObject supplies implementations for a number of java.lang.Object methods (equals, hashCode, toString) 
 * so that they are defined appropriately for remote objects. 
 * UnicastRemoteObjectalso includes constructors and static methods used to export a remote object, that is, 
 * make the remote object available to receive incoming calls from clients.
 * If you choose to extend a remote object from any class other than UnicastRemoteObject then
 * you need to export the remote object by calling the UnicastRemoteObject.exportObject method 
 * explicitly from your class's constructor (or another initialization method, as appropriate).
 */
public class ComputeEngine extends UnicastRemoteObject implements Compute {
	
	private static final long serialVersionUID = 1L;

	public ComputeEngine() throws RemoteException {
		//During construction, a UnicastRemoteObject is exported thus may throw RemoteException 
		super();
	}

    public Object executeTask(Task t) {
        return t.execute();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        String name = "//host/Compute";
        try {
            Compute engine = new ComputeEngine();
            Naming.rebind(name, engine);
            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception: " + 
			       e.getMessage());
            e.printStackTrace();
        }

	}

}
