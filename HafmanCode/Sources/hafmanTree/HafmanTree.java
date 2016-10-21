/*
 *	HafmanTree
 *	==========
 *	Given an array of rates the object will build a tree
 *	to form the hafman code according to the rate of each 
 *	character in the given array.
 *	
 *	The array must be organaized s.t. in item 'i' in the array
 *	we will have the rate of the character with the ascii 'i'.
 *	For instance rates[65] represents the rate of the char "A".
 *
 * 	The values of the rates can represent any rating technic as you want
 * 	but higher numbers means that the character is more likely to appear.
 * 
 *	How to use:
 *	===========
 *
 *	void foo()
 *	{
 *		double[] rates;
 *	
 *		. . .
 *		initialize 'rates' array with values about the probabilities
 *		. . .
 *
 *		HafmanTree obj = new HafmanTree(rates);		//create HafmanTree according to "rates"
 *		String[] codes = obj.getCodeArray();		//get the array of codes (codes[65] is the code of "A")
 *	 		
 */

package hafmanTree;

import java.io.PrintStream;


public class HafmanTree {
	Node 		m_root;
	String[]	m_codes;
	double[]	m_rates;
	
	public HafmanTree(double[] rates) {
		HafmanNodesList nl = new HafmanNodesList(rates);		
		m_root = nl.convertToHafmanTree();
		m_rates = new double[rates.length];
		System.arraycopy(rates,0,m_rates,0,rates.length);
	}
		
	//extract hafman-codes from the tree to a String array
	//this will allow faster access during the coding phase
	public String[] getCodeArray() {
		if (m_root==null) {
			return null;
		}
		if (m_codes==null) {
			m_codes = new String[256];
			recurssiveFillCodesInArray(m_root,m_codes);
		}
		return m_codes;
	}
	
	
	//go over the tree from the "root" and write each Leaf's code to "arr"
	//the index of the array is the ascii-code of the node (getAscii)
	//the values of items in the array are strings representing the hafman-codes.
	void recurssiveFillCodesInArray(Node root, String[] arr) {
		if (root==null)
			return;
		
		if (root instanceof Leaf) {
			Leaf l = (Leaf) root;
			int index = l.getAscii();
			arr[index] = l.getCode();
		}
		else if (root instanceof Node) {
			Node n = (Node) root;
			recurssiveFillCodesInArray(root.getLeft(), arr);
			recurssiveFillCodesInArray(root.getRight(), arr);
		}

	}
	
	public void printDictionary() {
		printDictionary(System.out);
	}
	
	public void printDictionary(PrintStream out) {
		if (m_root==null) {
			out.println("Dictionary is empty!");
		}
		else {
			printRecursively(out,m_root);
		}
		
	}
	
	void printRecursively(PrintStream out, Node root) {
		if (root==null)
			return;
		
		if (root instanceof Leaf) {
			Leaf l = (Leaf) root;
			char c = (char) l.getAscii(); 
			out.println("\"" + new Character(c).toString() + "\" = " + l.getCode());
		}
		else if (root instanceof Node) {
			Node n = (Node) root;
			printRecursively(out, root.getLeft());
			printRecursively(out, root.getRight());
		}
	}
	
	public void printCodesArray() {
		if (m_codes==null) {
			getCodeArray();
		}
		
		for (int i=0 ; i<m_codes.length ; i++) {
			if (m_codes[i]!=null && !m_codes[i].equals("")) {
				//this is a non-empty array item --- a real code here
				System.out.println("\t\"" + (char) i + "\" = " + m_codes[i]);
			
			}
		}
	}

	//will return (-1) if no tree is there (m_root=null)
	public double getAvgCodingLength() {
		
		if (m_root==null)
			return -1;
		
		if (m_codes==null) {
			getCodeArray();
		}
		
		double ret=0;
		for (int i=0 ; i<m_codes.length ; i++) {
			if (m_codes[i]!=null)
			ret += m_codes[i].length() * m_rates[i];
		}
		
		return ret;
	}

	//will return (-1) if no tree is there (m_rates=null)
	public double getNaiveCodingLength() {
		if (m_rates==null)
			return -1;
		
		int lettersCount=0;
		for (int i=0 ; i<m_rates.length ; i++) {
			if (m_rates[i]>0)
				lettersCount++;
		}
		
		
		return roundUp(log2(lettersCount));
		
	}
	
	private double log2(double val) {
		return ( Math.log(val) / Math.log(2) ); 
	}
	
	private double roundUp(double val) {
		if (Math.round(val) != val)
			return Math.round(val+0.5);
		else
			return val;
	}
}

