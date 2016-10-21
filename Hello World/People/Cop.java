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
public class Cop extends Person {

	public static final PoliceRank e_RBeginner = new PoliceRank(1);
	public static final PoliceRank e_RAdvanced = new PoliceRank(2);
	public static final PoliceRank e_RSargent = new PoliceRank(3);
	public static final PoliceRank e_ROfficer = new PoliceRank(4);
		
	PoliceRank m_rank;

	public Cop() 
	{
		super();
		m_rank=e_RBeginner;
		Meeting a = new Meeting();
		a.p_number=1;
		a.setNumber(2);		
	}
	public Cop(String name, double height, PoliceRank rank) {
		super(name, height);
		m_rank=rank;
	}

	protected void finalize() 
	{
		System.out.println("Finilizing Cop\n" + this);
	}

	
	public PoliceRank getRank()
	{
		return m_rank;
	}
	public void setRank(PoliceRank val)
	{
		m_rank=val;
	}	
	public String toString()
	{
		return
			super.toString() + "\n" +
			"Rank:\t\t" + m_rank.toString();
	}

	public Person getPerson() { return this; }

	
	
}

