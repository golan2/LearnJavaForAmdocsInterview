/*
 * Created on 28/07/2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package synchronizedMethods;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class User extends Thread {

	private static int sequenceValue;
	
	boolean			m_isRunning=false;
	boolean			m_stopRunning=false;
	SharedObject	m_lock;
	int				m_id;
	int				m_age;
 
	
	public User(SharedObject lock) {
		this.m_lock=lock;
		m_id = ++sequenceValue;
		m_age=0;
		SharedObject.print("User " + m_id + " created.");
	}
	
	public int getID() {
		return m_id;
	}
	public void incAge() {
		m_age++;
	}

	public int getAge() {
		return m_age;
	}
	
	public void run () {
		m_isRunning=true;
		while (!m_stopRunning) {
			SharedObject.print("User " + m_id + " beore synchronized(m_lock) section.");
			synchronized(m_lock) {				
				SharedObject.print("User " + m_id + " beore calling synch method.");
				m_lock.synch(this);
				SharedObject.print("User " + m_id + " after calling synch method.");
			}
			/*
			try {
			sleep(2500);
			}
			catch (InterruptedException e) {}
			*/
		}
	}
	
	public void terminate() {
		m_stopRunning=true;		
		SharedObject.print("User " + m_id + " being terminated.");
		while (m_isRunning) {			
			try {
				wait(500);
			}
			catch (InterruptedException e) {}						
		}
		SharedObject.print("User " + m_id + " terminated succesfully.");
	}

	public void start() {
		SharedObject.print("User " + m_id + " started.");
		super.start();
	}
	
}
