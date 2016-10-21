/*
 * Created on 09/06/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package InnerClasses;




/**
 * @author IZIKG
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Outer2 {

	private int size;
	
	class Inner2 extends Outer2 {
		int innerSizer;
		
		public Inner2() {
			innerSizer = size;
		}
		
		public int getOuterSize() {
			return size;
		}
		
		public void serInnerSize(int val) {
			innerSizer=val;
		}
	}
	
	
	public void funcWithInner() {
	}
	
	public void setSize(int newVal) {
		size = newVal;
	}
	
	public class Inner {
		public void increment() {
			size++;						
		}
		
		public int getSize() {
			return size;
		}
	}
	
	public InClassD getInnerClassA() {
		final int DOLLARE=4;
		
		class G extends InClassE {
			public String toString() {
				return "I am G ; DOLLAR=" + DOLLARE ;
			}
		}
		return new G();
		/*
		return new InClassE() {
			public String toString() {
				return super.toString() +  " (newE, dollar=" + DOLLARE + ")";
			}
		};
		*/
	}
	
	public static InClassE getInnerClassE_Static() {
		return new InClassE() {
			public String toString() {
				return super.toString() +  " (newE)";
			}
		};		
	}
	public InClassE getInnerClassE() {
		
		size=12;
		return new InClassE() {
			public String toString() {
				return super.toString() +  " (newE) ; size = " + size;
			}			
		};
	}

}



