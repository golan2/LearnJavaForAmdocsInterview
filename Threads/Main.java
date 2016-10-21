import java.io.IOException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			f4();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void f1() {
		System.out.println("start of f1");
		try {
			System.out.println("calling f2");
			f2();
		} catch (Exception e) {
			System.out.println("Exception");
		}
		System.out.println("end of f1");
	}

	static void f2() throws Exception{
		
	}
	
	static void f3() {
		new SimpleThread().start();
		new SimpleThread().start();
		new SimpleThread().start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void f4() throws IOException{
		Logger l = new Logger("C:\\1.txt");
		for (int i=1 ; i<=10 ; i++) {
			l.writeLine("No. " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}
}
