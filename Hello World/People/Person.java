/**
 * Created on 28/04/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package People;

/**
 * @author IZIKG
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class Person {
	String	m_name;
	double	m_height;
	
	protected void finalize() 
	{
		System.out.println("Finilizing Person\n" + this);
	}
	
	public Person(String name, double height)
	{
		m_name=name;
		m_height=height;
	}
	public Person()
	{
		this("",0);
		Meeting a = new Meeting();
		a.p_number=1;
		a.setNumber(2);
	}
	
	public String getName(){
		return m_name;
	}
	public double getHeight(){
		return m_height;
	}
	public void setName(String val){
		m_name=val;
	}
	public void setHeight(double val){
		m_height=val;
	}
	
	public String toString()
	{
		return 	
			"Name:\t\t" + m_name + "\n" +
			"Height:\t\t" + m_height;
	}
	
	class Meeting
	{
		int p_number;
		
		public void setNumber(int val)
		{
			p_number=val;
		}
	}
	
	public Person getPerson() { return (Cop) this; }
}
