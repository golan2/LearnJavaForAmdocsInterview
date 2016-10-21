/*
 * Created on 12/06/2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package MultiThreading;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class SimpleThread implements Runnable {

	String m_myName;
	private Thread m_myThread;
	
	public SimpleThread(String myName) {
		m_myName = myName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		for (int i=0 ; i<5 ; i++) {
			System.out.println(m_myName + ";i=" +  i + ";");
			try {
				Thread.sleep((long)Math.random());
			}catch (InterruptedException e) {
				
			}
		}
	}

	public void start() {
		if (m_myThread==null) {
			m_myThread = new Thread(this,m_myName);
			m_myThread.start();
		}
	}
}
