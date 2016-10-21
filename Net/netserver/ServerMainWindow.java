/*
 * Created on 20/07/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package netserver;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ServerMainWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	GridLayout 		mainGridLayout = new GridLayout(2,1);
	JPanel			upperBorderLayout = new JPanel();
	JButton 		pressMe = new JButton("Press Me");
	JButton 		exit = new JButton("Exit");
	JTextArea 		textAreaConsole = new JTextArea();
	JScrollPane		lowerConsoleArea = new JScrollPane(textAreaConsole);
	ConsoleStream	console = new ConsoleStream(textAreaConsole);
	ServerEngine		server;
	
	
	public ServerMainWindow() throws Exception {
		super();
		initControls();
		server = new ServerEngine(getTitle(), new ServerTextualUI(), 4000);
		server.start();
	}

	private void initControls() {		
		Container cp = getContentPane();
		cp.setLayout(mainGridLayout);
		
		cp.add(upperBorderLayout);
		cp.add(lowerConsoleArea);			
		upperBorderLayout.add(pressMe,BorderLayout.CENTER);	
		upperBorderLayout.add(exit,BorderLayout.SOUTH);
		setSize(350,400);
		
		pressMe.addActionListener( 
			new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textAreaConsole.setText("");					
				}
		});

		exit.addActionListener( 
			new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					endProgram();
				}
		});
		
		this.addWindowListener(
			new WindowAdapter() {
				public void windowClosed(WindowEvent e) {
					endProgram();
				}
				
			}
		);
    }
	
	public void endProgram() {
		System.exit(0);
		
	}
}
