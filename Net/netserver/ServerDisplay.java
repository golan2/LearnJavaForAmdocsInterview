/*
 * Created on Jul 26, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package netserver;

/**
 * @author IZIKG
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface ServerDisplay {
	
	//TODO: implement syncronization on this object for clients using it.
	
	//server-engine functions:
	public void addClientHandler(ClientHandler c);
	public void removeClientHandler(ClientHandler c);
	public void clearAll();
	public void errorPrint(String msg);
	
	//client-handler functions:
	public void clientHandlerMsg(ClientHandler c, String msg);
	
}
