/*
 * Created on Jun 12, 2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package People;

/**
 * @author FTP
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public final class PoliceRank
{	
	private int m_rank;
	
	public PoliceRank(int rank)
	{
		setRank(rank);
	}
	public int getRank()
	{
		return m_rank;
	}
	public void setRank(int val)
	{
		m_rank=val;
	}
	public String toString()
	{
		switch (m_rank)
		{
			case 1:
				return "Beginner";
				
			case 2:
				return "Advanced";
				
			case 3:
				return "Sargent";
				
			case 4:
				return "Officer";				
				
			default:
				return "no_rank";
		}
	}
}
