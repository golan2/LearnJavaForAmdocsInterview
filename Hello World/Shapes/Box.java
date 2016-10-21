/*
 * Created on 12/06/2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package Shapes;

import java.io.EOFException;
import java.net.ConnectException;


public class Box extends Rectangle implements MyShape3D{
	private static final long serialVersionUID = 1L;
	double m_depth;
		
	public Box() {		
		this(getRandomVal(),getRandomVal(),getRandomVal());
	}
	
	public Box(double width, double height, double depth) {
			super(width,height);			
			m_depth=depth;
	}

	public double getDepth() {
		return m_depth;
	}
	
	public void setDepth(double d) {
		m_depth=d;
	}

	public void paint() {
		System.out.println("Box;Width="+m_width+";Height="+m_height+";Depth="+m_depth+";");
	}

	public String getMe(){
		return "Box";	
	}
	
	public double getVolume() {
		return getArea()*m_depth;
	}
/*
	private void blankFinal() {
		final String a;
		
		a = "124.34";		
		setHeight(Double.parseDouble(a));				
	}
*/
	public Paintable getNumber() throws EOFException  
	{
		return this;
	}
	
	//private static int initializeVarA() { return 5; }
	
	public void func() throws ConnectException
	{
		System.out.println("Box.func");
	}
}
