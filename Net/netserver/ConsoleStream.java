/*
 * Created on Jul 20, 2005
 *
 */
package netserver;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

/**
 * @author IZIKG
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ConsoleStream extends OutputStream {
	JTextArea console;
	
	public ConsoleStream(JTextArea console) {
		this.console = console; 
	}
	
	public void write(int arg0) throws IOException {
		console.setText(console.getText() + new Integer(arg0).toString());
	}
	
	public void write(byte[] b) throws IOException {
		console.setText(console.getText() + new String(b));		
	}

	public void write(String s) throws IOException {
		console.setText(console.getText() + s);		
	}

	public void println(String s) throws IOException {
		console.setText(console.getText() + s + '\n');		
	}
	
	public void clear() {
		console.setText("");
	}
}
