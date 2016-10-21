import java.util.HashSet;

public class Q2 {

	public static void main(String[] args) {
		testIntersect();
	}
	
	public static void testIntersect() {
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		int[] b = {2,4,6,8,10};
		Object[] 	objects;
		int[]		integers;

		//two ways to do the same thing
		integers = intersectInt(a, b);		//returns int[]
		objects = intersectObjetcs(a, b);	//returns Integer[]
		
		for (int i=0 ; i<integers.length ; i++) {
			System.out.println("integers[" + i + "]="+ integers[i]);
		}
		
		System.out.println("");
		for (int i=0 ; i<objects.length ; i++) {
			System.out.println("objects[" + i + "]="+ objects[i]);
		}
	}
	
	protected static Object[] intersectObjetcs(int[] a, int[] b) {		
		HashSet aa = new HashSet();
		HashSet bb = new HashSet();

		for (int i=0 ; i<a.length ; i++) {
			aa.add(new Integer(a[i]));
		}
		for (int i=0 ; i<b.length ; i++) {
			bb.add(new Integer(b[i]));
		}		

		aa.retainAll(bb);
		
		return aa.toArray();
	}
	
	protected static int[] intersectInt(int[] a, int[] b) {		
		HashSet aa = new HashSet();
		int[]	res = new int[b.length];
		int		count=0;
		
		for (int i=0 ; i<a.length ; i++) {
			aa.add(new Integer(a[i]));
		}
		
		//Copy from "b" to "res" only what exists also in "aa"
		for (int i=0 ; i<b.length ; i++) {
			if (aa.contains(new Integer(b[i]))) {
				res[count++] = b[i];
			}
		}
		
		return res;		
	}
}
