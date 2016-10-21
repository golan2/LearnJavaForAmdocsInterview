import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;


/*
 * Created on 13/06/2005
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
public class AppletNetworking extends Applet {
	private Button[] buttons = new Button[5];
	private Label lServer = new Label("Server");
	private TextField txtWriteOut = new TextField();
	private Panel pTop = new Panel();
	private Panel pBottom = new Panel();
	
	
	public void init() {		
		this.setLayout(new GridLayout(2,0));
		add(pTop);		
		add(pBottom);
		//pTop.add(lServer);
		pTop.add(new Label());
		pTop.add(txtWriteOut);
		pTop.add(new Label());
		txtWriteOut.setSize(500,36);		
		pTop.setLayout(new GridLayout(3,3));
		addFiveButtons();
		//lServer.setText("W=" + pTop.getSize().getWidth() + " H=" + pTop.getSize().getHeight());
	}
	
	
	
	private void addFiveButtons() {
		
		for (int i=0 ; i<5 ; i++) {
			buttons[i] =new Button("Order "+i);
			buttons[i].addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						try {
							Socket sock = new Socket(InetAddress.getByName("127.0.0.1"),23);
							BufferedWriter out = new BufferedWriter(
													new OutputStreamWriter(
														sock.getOutputStream()));							
							out.write(txtWriteOut.getText());
							txtWriteOut.setText("");
							out.write("END");
							sock.close();
						}catch (Exception e) {
							System.out.println(e.toString());
						}						
					}
					
				});
			pBottom.add(buttons[i]);
		}
		pBottom.setLayout(new GridLayout(0,5));
	}
}
