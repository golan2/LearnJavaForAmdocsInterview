import java.io.IOException;

public class SimpleP2P {

	public SimpleP2P() {
		
	}
	
	public static void main(String[] args) {
		try {
			PeerServer p = new PeerServer(4577);
			System.out.println("run");
			p.run();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
