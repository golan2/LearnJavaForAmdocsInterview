package netserver;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/*
 * Created on Jun 12, 2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */

public class ServerEngine implements Runnable {
	boolean			m_isRunning=false;
	boolean 		m_stopRunning=false;
	String 			m_myName;
	Thread 			m_myThread;
	ServerSocket	m_server;	
	ArrayList 		m_clients = new ArrayList(25);
	ServerDisplay	m_disp;

	public ServerEngine(String myName, ServerDisplay disp, int port) throws Exception{	
		m_myName = myName;
		m_disp = disp;
		m_server = new ServerSocket(port);		
	}
	
	public void run() {		
		m_isRunning=true;
		{
			try {
				while (!m_stopRunning) {
					Socket sock = m_server.accept();				
					ClientHandler currentClient=new ClientHandler(sock, this, m_disp, m_clients.size());
					m_disp.addClientHandler(currentClient);
					m_clients.add(currentClient);
					currentClient.start();	
					Thread.sleep(500);
				}
			}
			catch (IOException e) {
				m_disp.errorPrint(e.toString());
			}
			catch (InterruptedException e) {
				m_disp.errorPrint(e.toString());
			}
			finally {
				terminateServer();
			}
		}
		m_isRunning=false;
	}
	
	//Go over the m_clients and close all non running.
	protected void terminateClosedm_clients() {
		Iterator it = m_clients.iterator();
		
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
	
	public void terminateServer() {
		//stop all clients
		ListIterator it = m_clients.listIterator();
		while (it.hasNext()) {		
			((ClientHandler)it.next()).terminateClient();			
		}
		//stop me
		m_stopRunning=true;
		while (m_isRunning) {
			try {
				wait(500);
			}
			catch (InterruptedException e) {}
		}
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
