/*
 * 	Leaf in the hafman tree
 */
package hafmanTree;


public class Leaf extends Node {
	int		m_ascii = 0;
	
	public Leaf(int ascii, double rate) {
		m_ascii = ascii;
		m_rate	= rate;
		m_left  = null;
		m_right = null;
	}
	public int 	getAscii()			{	return m_ascii;	}
	public void setAscii(int val)	{	m_ascii = val;	}

}
