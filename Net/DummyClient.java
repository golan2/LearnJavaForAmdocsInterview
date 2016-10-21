import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//Summy:
//Connect to other side and send waht you get on screen to toher sied
public class DummyClient {
	Socket s;
	public DummyClient(String host,  int port) {
		try {			
			InetAddress addr= InetAddress.getByAddress(host, new byte[4]);
			
			
			int length = System.in.available();
			byte[] buf = new byte[length+1];			
			System.in.read(buf);
			
			s = new Socket(addr,port);
			
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

}
