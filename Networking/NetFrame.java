
import SimpleServer.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



/*
 * Created on 17/07/2005
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
public class NetFrame extends JFrame {

	GridLayout grdL = new GridLayout(2,3);
	JPanel contentPane = new JPanel(grdL);
	JButton cmdRunServer = new JButton("Run The Server");
	FirstServer theServer;
	static int serverRunStartedCounter=0;
	
	public NetFrame(){
		
		cmdRunServer.addActionListener( 
			new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						if ( theServer==null ) {
							//Load the server
							cmdRunServer.setText("Stop The Server");
							serverRunStartedCounter++;
							theServer = new FirstServer(new Integer(serverRunStartedCounter).toString(), 23);
							theServer.start();
						}else {
							//Stop the server
							cmdRunServer.setEnabled(false);
							theServer.terminate();
							while ( theServer.getIsRunning() ) {							
								theServer.wait(500);
							}
							cmdRunServer.setText("Run The Server");
							cmdRunServer.setEnabled(true);
							theServer=null;
						}					
					} catch (Exception e) {
					}									
				}
			
		});
		
	}
	
	
}
