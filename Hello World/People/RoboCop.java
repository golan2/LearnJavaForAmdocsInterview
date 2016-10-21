
package People;

/*
 * Created on 28/04/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author IZIKG
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RoboCop extends Cop 
{
	String m_model;
	
	public RoboCop() {
		super();
		m_model="";		
	}

	public RoboCop(String name, double height, PoliceRank rank, String model) {
		super(name, height, rank);
		m_model=model;
	}
	
	protected void finalize() 
	{
		System.out.println("Finilizing RoboCop\n" + this);
	}
	
	public String toString()
	{
		return
			super.toString() + "\n" +
			"Model:\t\t" + m_model;
	}
	public String getModel()
	{
		return m_model;
	}
	public void setModel(String val)
	{
		m_model=val;
	}
	public void setPrvName(String val)
	{
		m_name=val;
	}
}
