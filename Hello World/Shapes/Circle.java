/*
 * Created on 09/06/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Shapes;

public class Circle extends MyShape {
	private static final long serialVersionUID = 1L;
	double m_radius;	
	
	public Circle() {
		this(getRandomVal());
	}

	public Circle(double radius) {
		m_radius=radius;
	}
	
	public double getRadius() {
		return m_radius;
	}
	
	public void setRadius(double r) {
		m_radius=r;
	}
	
	public void paint() {
		System.out.println("Circle;Radius="+m_radius+";");
	}

	protected String getMe(){
		return "Circle";	
	}

	public double getArea() {		
		return Math.pow(m_radius,2)*pi;
	}

}
