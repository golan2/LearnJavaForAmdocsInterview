
public class SimpleThread implements Runnable {
	Thread m_Thread;
	int m_Number;
	static int m_Counter;
	boolean stopRunning=false;
	
	public SimpleThread() {
		m_Number=++m_Counter;
	}
	
	public void start() {
		System.out.println("Thread:" + m_Number + " Started.");
		if (m_Thread==null) {
			m_Thread = new Thread(this,new Integer(m_Number).toString());
			m_Thread.start();
		}	
	}	
	
	public void run() {
		int i=0;
		while (!stopRunning) {			
			System.out.println("Thread:" + m_Number + " Step: " + i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				System.out.println("Thread:" + m_Number + " Interrupted");
			}
			
			if (i>=10)
				stopRunning=true;
		}
	}

}
