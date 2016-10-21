package General;

public class RTException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RTException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String toString() { 
		return new String("RTException.toString:\n") + super.toString();
	}

}
