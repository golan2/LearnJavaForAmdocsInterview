/*
 * Created on 13/06/2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package SimpleServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class ClientHandler extends Thread {
	int			number;
	Socket		socket=null;
	boolean 	stopRunning=false;
	boolean		isRunning=false;
	PrintStream	out;
	
	public ClientHandler(Socket clientSocket, PrintStream out, int my_number ) {		
		socket = clientSocket;
		this.out = out;			
	}
	public void run() {
		try {		
		String			str;
		char[] 			buffer = new char[4096];
		int				actualBytesRead;
		BufferedReader 	in = new BufferedReader(
								new InputStreamReader(
									socket.getInputStream()));		
		
		isRunning=true;
		out.println("ClientHandler start running [" + number +"] " + socket.toString());
		while (!stopRunning) {			
			actualBytesRead = in.read(buffer);
			if (actualBytesRead>0) {
				str = new String(buffer,0,actualBytesRead);		
				out.println();
				if (str.equals("END")) {
					stopRunning=true;
				}			
			}
			sleep(1000);			
		}

		}catch (IOException e) {
		}catch (InterruptedException e) {
		}finally {
			isRunning=false;
			if (socket!=null) {
				if (!socket.isClosed()) {
					try {
						socket.close();
						out.println("ClientHandler [" + number + "] close its socket");
					}catch (IOException e) {}
				}
			}			
		}//finally-end
		
	}

	public void terminate() {
		stopRunning=true;
		while (isRunning) {
			try {			
				sleep(500);
			}catch (InterruptedException e) {
			}
		}
	}

	public boolean getISRunning() {
		return isRunning;
	}


}
