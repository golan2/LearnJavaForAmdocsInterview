/*
 * HafmanNodesList
 * ===============
 * (Used by "HafmanTree" class)
 * Holds the list of characters-nodes.
 * Each node will eventually be a node in a hafman-tree representing one character. 
 * Each node has:
 * 		Left
 * 		Right
 * 		Code (ascii)
 * 		Rate (probability)
 *
 *	The list knows how to build itself from an array of rates.
 *	The list knows how to transform itself to a hafman-tree.
*/

package hafmanTree;

import java.util.LinkedList;
import java.util.ListIterator;


public class HafmanNodesList {
	static final String LEFT_CODE = "1";
	static final String RIGHT_CODE = "0";
	
	LinkedList nodes = new LinkedList();
	
	//array is rates while index for array is ascii-code
	//thus rate("S") = rates['S']
	public HafmanNodesList(double[] rates) {
		for (int i=0 ; i<rates.length ; i++) {
			if (rates[i]>0) {
				nodes.add(new Leaf(i,rates[i]));
			}
		}			
	}

	public int size() {
		return nodes.size();
	}
	//What:
	//	Create a Hafman tree from the items in the list.
	//	After the function finishes processing the list will have only one item --- the root of the tree.
	//Return:
	//	The root of the tree
	//	Or null if list is empty
	public Node convertToHafmanTree() {
		Node ret;
		
		if (nodes.isEmpty())
			return null;
		
		//compose pairs until only one is left in list
		while (nodes.size() > 1) {
			ret = (Node)composeSmallestPair();
			if (ret != null)
				nodes.add(ret);
		}
		
		//build the codes in the tree recursively
		//	we know the list is not empty because we checked it in the beginning of the function
		//	we know there is no more than one element in the list because we got out of the loop above
		//	so the root of the tree is the first (the only) item in the list
		ret = (Node)nodes.getFirst();
		setCodeRecursively(ret, "");	//the "" is the code of the root
		
		return ret;
	}
	
	

	Node composeSmallestPair() {
		//What:
		//	Search for the two items with minimal rate and make a "pair" (a Node)
		//	containig them both and has its rate as the sum of their rates.
		//Return:
		//	The pair
		//How:
		//	[1] Go over the list and remember the two minimals (first & second)
		//	[2] Make pair
		//	[3] Remove both (first & second) from the list
		//	[4] Return the pair
		//
		Node first = Node.MAX_RATE;
		Node second = Node.MAX_RATE;
		
		if (nodes.size()<2)
			return null;
		//[1]
		ListIterator it = nodes.listIterator();
		while (it.hasNext()) {
			Node current = (Node)it.next();
			if (current.getRate() < first.getRate()) {
				//update first
				second=first;
				first=current;
			}
			else if (current.getRate() < second.getRate()) {
				//update second
				second=current;
			}
		}
		
		//[2]
		Node result = Node.makePair(first,second);
		
		//[3]
		nodes.remove(first);
		nodes.remove(second);
		
		return result;
	}

	//set the code of myself and recursively to sons below me
	void setCodeRecursively(Node root, String code){	
		root.setCode(code);
		if (root.getLeft() != null)
			setCodeRecursively((Node)root.getLeft(), code + LEFT_CODE);
		
		if (root.getRight() != null)
			setCodeRecursively((Node)root.getRight(), code + RIGHT_CODE);		
	}	
}
