package InnerClasses;

public class InClassF extends InClassE{
	int f;
	public InClassF() {
		d=3;e=3;f=3;
	}
	public void func() {
		System.out.print("InClassF");
	}
	public String toString() {		
		return "InClassF: d=" + d + ", e=" + e + ", f=" + f;		
	}
}