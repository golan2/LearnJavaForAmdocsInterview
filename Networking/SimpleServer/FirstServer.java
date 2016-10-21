package SimpleServer;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * Created on Jun 12, 2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */

/**
 * @author FTP
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class FirstServer implements Runnable {

	boolean 		stopRunning=false;
	String 			m_myName;
	Thread 			m_myThread;
	ServerSocket	server;	
	ArrayList 		clients = new ArrayList(25);

	public FirstServer(String myName, int port) throws Exception{		
		m_myName = myName;
		server = new ServerSocket(port);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		Socket sock=null;
		BufferedReader in=null;
		BufferedWriter out=null;
		
		try {
			while (!stopRunning) {
				//System.out.println("Before Accept");
				//terminateClosedClients();
				
				sock = null;
				sock = server.accept();
				System.out.println("Client accepted at " + sock.toString());
				ClientHandler currentClient=new ClientHandler(sock,System.out, clients.size());
				clients.add(currentClient);
				currentClient.start();	
				Thread.sleep(500);
			}	
		}catch (IOException e) {
			System.out.print("The \'accept\' function has failed.");
		} catch (InterruptedException e) {
		}
		finally {
		}

	}
	//Go over the clients and close all non running.
	private void terminateClosedClients() {
		Iterator it = clients.iterator();
		
		while (it.hasNext()) {		
			ClientHandler client = (ClientHandler)it.next();
			if (!client.getISRunning()) {
				it.remove();
			}			
		}
	}
	
	public void start() {
		if (m_myThread==null) {
			m_myThread = new Thread(this,m_myName);
			m_myThread.start();
		}	
	}
	
	public void terminate() {
	Iterator it = clients.iterator();
	while (it.hasNext()) {		
		((ClientHandler)it.next()).terminate();		
	}
		stopRunning=true;
	}
}

/*
			System.out.println("After Accept");
			in = new BufferedReader(
								new InputStreamReader(
								sock.getInputStream()));
			out = new BufferedWriter(
								new OutputStreamWriter(
								sock.getOutputStream()));
			
			
			String str;
			str=in.readLine();
			while (str!=null) {
				if (str.equals("quit")) {
					
				}
				System.out.println(str);
				str=in.readLine();	
			}
			
			out.write("Text"); 
*/
