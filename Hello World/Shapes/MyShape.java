/*
 * Created on 09/06/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Shapes;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.Serializable;

/**
 * @author IZIKG
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class MyShape implements Paintable, Serializable{	
	
	public static double pi = 3.14;
	public abstract void paint();
	
	protected String getMe(){
		return "MyShape";	
	}
	
	public abstract double getArea();
	
	public static MyShape getRandomShape() {
		MyShape retval;
		switch ( (int)(Math.random()*4))
		{			
			case 0:
				retval = new Box(getRandomVal(),getRandomVal(),getRandomVal());
				break;
			case 1:
				retval = new Circle(getRandomVal());
				break;
			case 2:
				retval = new Rectangle(getRandomVal(),getRandomVal());
				break;
			default://case 3:
				retval = new Triangle(getRandomVal(),getRandomVal());
				break;
		}
		return retval;
	}
	
	final protected static double getRandomVal() {
		return Math.random()*100+1;
	}
	
	public Paintable getNumber() throws EOFException, FileNotFoundException
	{
		return this;
	}
	
	
}
