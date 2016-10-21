/*
 * Created on Jun 12, 2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package Shapes;

/**
 * @author FTP
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class Triangle extends MyShape {
	private static final long serialVersionUID = 1L;
	double m_height;
	double m_base;
	
	public Triangle() {
		this(getRandomVal(),getRandomVal());
	}
	
	public Triangle(double base, double height) {
		m_base=base;
		m_height=height;
	}
	
	public void paint() {
		System.out.println("Triangle;Base="+m_base+";Height="+m_height+";");
	}

	public double getArea() {
		return m_base*m_height/2;
	}

	public double getBase() {
		return m_base;
	}
	
	public void setBase(double b) {
		m_base=b;
	}

	public double getHeight() {
		return m_height;
	}
	
	public void setHeight(double h) {
		m_height=h;
	}
}
