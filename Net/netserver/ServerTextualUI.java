/*
 * Created on Jul 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package netserver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author IZIKG
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ServerTextualUI implements ServerDisplay {
	BufferedWriter fout = new BufferedWriter (
			new FileWriter( 
				new File("C:\\ServerTextualUI.utxt")));	
	
	public ServerTextualUI() throws IOException
	{}
	
	
	public void addClientHandler(ClientHandler c){
		try		{
			System.out.println("New client added - " + c);
			fout.write("New client added - " + c + "\n");
			fout.flush();
		}
		catch (IOException e) {} 
	}

	public void removeClientHandler(ClientHandler c) {
		try		{
			System.out.println("Client removed - " + c);
			fout.write("Client removed - " + c + "\n");
		}
		catch (IOException e) {}		
	}

	public void clearAll() {
		//nothing special to do on textual UI
		try		{
			System.out.println("Clear All");
			fout.write("Clear All\n");
		}
		catch (IOException e) {}		
	}

	public void errorPrint(String msg) {
		try		{
			System.out.println("ERROR - " + msg);
			fout.write("ERROR - " + msg + "\n");
		}
		catch (IOException e) {}		
	}
			
	

	public void clientHandlerMsg(ClientHandler c, String msg) {		
		try		{
			System.out.println(msg);
			fout.write(msg + "\n");
		}
		catch (IOException e) {}		
	}	

}
