/*
 * Created on 20/07/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package netserver;


public class ServerApplication {


	public ServerApplication() {
		super(); 
	}

	public static void main(String[] args) throws Exception {

		ServerTextualUI disp = new ServerTextualUI();
		ServerEngine server = new ServerEngine("IZIK",disp,6666);
		server.start();
		disp.errorPrint("The End");		
	}
}
