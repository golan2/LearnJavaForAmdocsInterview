/*
 * Created on 13/06/2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package netserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler extends Thread {
	boolean 		m_stopRunning=false;
	boolean			m_isRunning=false;
	int				m_number;
	Socket			m_socket=null;
	ServerDisplay	m_disp;
	ServerEngine	m_server;
	
	public ClientHandler(Socket clientSocket, ServerEngine server, ServerDisplay disp, int my_number ) {		
		this.m_socket = clientSocket;
		this.m_disp = disp;
		this.m_server = server;
	}
	public void run() {
		try {	
			
			char[] 			buffer = new char[4096];
			int				actualBytesRead;
			BufferedReader 	in = new BufferedReader(
									new InputStreamReader(
										m_socket.getInputStream()));		
			
			m_isRunning=true;
			m_disp.clientHandlerMsg(this,"ClientHandler start running [" + m_number +"] " + m_socket.toString());
			while (!m_stopRunning) {			
				actualBytesRead = in.read(buffer);
				if (actualBytesRead>0) {
					String str = new String(buffer,0,actualBytesRead);		
					m_disp.clientHandlerMsg(this,str);
					if (str.equals("END")) {
						m_stopRunning=true;
					}
					else if (str.equals("TerminateServer")) {
						m_server.terminateServer();
					}
				}
				sleep(1000);		
		}

		}catch (IOException e) {
		}catch (InterruptedException e) {
		}finally {
			terminateClient();			
		}
		
	}

	public void terminateClient() {
		m_stopRunning=true;
		if ( (m_socket!=null) && (!m_socket.isClosed()) ) {
			try {
				m_socket.close();								
			}catch (IOException e) {}
		}
		
		//wait for "m_stopRunning" to perform its effect inside the "run" method
		while (m_isRunning) {
			try {			
				sleep(500);
			}catch (InterruptedException e) {
			}
		}
		
		m_disp.removeClientHandler(this);
	}

	public boolean getISRunning() {
		return m_isRunning;
	}


}
