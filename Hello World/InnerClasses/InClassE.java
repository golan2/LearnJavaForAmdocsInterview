package InnerClasses;

public class InClassE extends InClassD{
	int e;
	
	public InClassE() {
		super();
	}
	
	public InClassE(InClassE rhs) {
		d=2;e=2;
	}
	
	
	public void func() {
		System.out.print("InClassE");
	}
	public String toString() {		
		return "InClassE: d=" + d + ", e=" + e;		
	}	
}
