import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

/*
 * Created on Jul 31, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author IZIKG
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Main {

	public static void main(String[] args) throws IOException{		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));

		
		String line;
		Socket sock = new Socket(InetAddress.getByName("localhost"),6666);
		BufferedWriter bw = 
							new BufferedWriter (
								new OutputStreamWriter(
										sock.getOutputStream()));
		
		while (true) {
			line = br.readLine();

			if (line.toUpperCase().equals("QQQ")) 
			{
				System.out.println("QQQ - ACK");
				System.exit(0);
			}
			else
			{			
				
				bw.write(line);
			}
		}
	}
}
