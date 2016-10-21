import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class PeerServer implements Runnable{
	ServerSocket sock;
	Thread mThread=null;
	//boolean isListening=false;
	
	public PeerServer(int port) throws IOException {
		sock = new ServerSocket(port);
		sock.setSoTimeout(5000);
		System.out.println("PeerServer("+port+")");
	}
/*	
	public void startListening() {
		isListening=true;
		
	}
	
	public void stopListening() {
		isListening=false;
	}
*/
	public void start() {
		if (mThread==null) {
			mThread = new Thread();
			mThread.start();
		}		
	}
	
	public void run() {
		Socket s=null;
		//while (isListening) {
			try {
				System.out.println("before accept");
				s = sock.accept();				
				System.out.println("Accepted port " + s.getPort());
				DataInputStream dis = new DataInputStream(s.getInputStream());
				int length = dis.available();
				byte[] buf = new byte[length+1];
				dis.read(buf);
				System.out.println(buf);
				//isListening=false;
			} catch (SocketTimeoutException e) {
				System.out.println("nothing was accepted - Timeout!");
			} catch (IOException e) {				
				e.printStackTrace();
			}
		//}
		if (s!=null) {
			if (!s.isClosed()) {
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
