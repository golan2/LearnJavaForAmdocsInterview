/*
 * Created on 12/06/2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package Shapes;

import java.net.ConnectException;
import java.net.SocketException;


public class Rectangle extends MyShape {

	private static final long serialVersionUID = 1L;
	double m_width, m_height;
	int IZIK=1;
	
	public Rectangle() {
		this(getRandomVal(),getRandomVal());
	}

	public Rectangle(double width, double height) {
		m_width = width;
		m_height = height;
	}
	
	public double getWidth() {
		return m_width;
	}
	
	public void setWidth(double w) {
		m_width=w;
	}

	public double getHeight() {
		return m_height;
	}
	
	public void setHeight(double h) {
		m_height=h;
	}
	
	public void paint() {
		System.out.println("Rectangle;Width="+m_width+";Height="+m_height+";");
	}

	public String getMe(){
		return "Rectangle";	
	}

	public double getArea() {
		return 0;
	}
	
	public int getRectIZIK() { return IZIK; }
	public void setRectIZIK(int val) { IZIK=val; }

	public void func() throws ConnectException, SocketException
	{
		System.out.println("Rectangle.func");
	}
}
