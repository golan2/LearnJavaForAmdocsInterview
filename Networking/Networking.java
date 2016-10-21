
import java.io.*;
import java.net.*;
import java.util.*;
import SimpleServer.*;


/*
 * Created on 12/06/2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class Networking  {
	
	public Networking() {

		/*
		NetFrame nf = new NetFrame();
		nf.setVisible(true);
		*/
		Frame1 frame = new Frame1();
		
	}
	
	public static void main(String[] args) throws Exception {	
		
		new Networking();
		
		//serverWithClientHandlers();				
		print("The End!");
		System.exit(1);
		
	}
	/*
	public static void showNetFrame() {
		
		//Center the window
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height)
		{
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width)
		{
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frame.setVisible(true);		
		
	}
	*/
	public static void printSorted(List L) {
			Collections.sort(L, new StringCompare());
		Iterator it = L.iterator();
		while (it.hasNext())
		{
			print(it.next());
		}
	}
	
	public static void print(Object s) {
		System.out.println(s);
	}
	
	public static void testURLConnection() throws IOException {
		String str;
		
		URL pensia = new URL("http://localhost/Pensia/");
				
		BufferedReader br = new BufferedReader(
							new InputStreamReader(pensia.openStream()));
		FileWriter fw = new FileWriter("C:\\1.htm");
		
		str = br.readLine();
		while (str != null) {
			fw.write(str+"\b\n");
			str = br.readLine();
		}
		br.close();
		fw.close();

	}
	
	public static void simpleAccept() throws IOException {
		ServerSocket server = new ServerSocket(23);
		byte[] data = new byte[4096];
		long start = System.currentTimeMillis();
		while (true) {
			Socket s = server.accept();
			
		}
	}

	public static void simpleServerThread() throws Exception {
		FirstServer server = new FirstServer("Izik", 23);
		server.start();
		Thread.sleep(180000);
		server.terminate();

	}
	
	public static void serverWithClientHandlers() throws Exception {
		FirstServer server = new FirstServer("Izik", 23);
		server.start();
		Thread.sleep(180000);
		server.terminate();
	}
}
