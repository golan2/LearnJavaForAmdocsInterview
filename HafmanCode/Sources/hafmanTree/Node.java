/*
 * 	Inner node (non-leaf) in the hafman tree
 */
package hafmanTree;

public class Node {
	public static final Node MAX_RATE = new Node(Double.MAX_VALUE); 
	
	Node	m_left  = null;
	Node	m_right = null;
	String	m_code  = "";
	double	m_rate = 0;
	
	public Node() {}
	public Node(Node left, Node right) {
		m_left = left;
		m_right = right;
	}
	private Node(double rate) {
		m_rate=rate;	
	}	
	
	public Node 	getLeft() 	{	return m_left;	}
	public Node 	getRight() 	{	return m_right;	}	
	public double	getRate()	{	return m_rate;	}
	public String	getCode() 	{	return m_code;	}

	public void setLeft(Node node)	{	m_left  = node;	}
	public void setRight(Node node){	m_right = node;	}
	public void setRate(double rate){	m_rate  = rate;	}
	public void setCode(String code){	m_code  = code;	}

	public static Node makePair(Node a, Node b) {
		Node retval = new Node(a,b);
		retval.m_rate = a.getRate() + b.getRate();
		return retval;		
	}
}
