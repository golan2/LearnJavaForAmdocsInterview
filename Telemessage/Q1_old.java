import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * Changes:
 * [1]	Remove the ttls HashSet
 * [2] 	Use this code to get the iterator on the list:
 * 			Iterator it = objects.entrySet().iterator();
 * [3]	Remove the "key" from MapCleanerEntity
 * 		We only need (value,ttl)
 *
 *
 *	http://www.oracle.com/technology/pub/articles/maps1.html#T1
 */

public class Q1_old {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		testSelfCleanMap();
		

	}
	
	protected static void testSelfCleanMap() throws InterruptedException {
		SelfCleanMap_old a = new SelfCleanMap_old(4);
		
		
									//int i=0;
									//System.out.println("[" + ++i + "]" + a);
		
		System.out.println("put (one)");
		a.put("1", "one");		
		System.out.println("put (two)");
		a.put("2", "two");

		System.out.println("sleep (1500)");
		Thread.sleep(1500);
		
		System.out.println("put (three)");		
		a.put("3", "three");
		System.out.println("put (four)");
		a.put("4", "four");
		
		System.out.println("sleep (1500)");
		Thread.sleep(1500);
		
		System.out.println("put (five)");
		a.put("5", "five");
		
		System.out.println("sleep (2000)");
		Thread.sleep(2000);
		
		System.out.println("The End");
	}
	
	protected static void testMap()  {
		Map ppp = new Hashtable();
		ppp.put(new Integer("1"), "1");
		ppp.put(new Integer("2"), "2");
		ppp.put(new Integer("3"), "3");

		printMap(ppp);
		
		Iterator it = ppp.entrySet().iterator();
		if (it.hasNext()) {
			it.next();
			it.remove();
		}
		
		printMap(ppp);
	}
	
	protected static void printMap(Map p) {
		Iterator it = p.entrySet().iterator();
		String s="";
		while (it.hasNext()) {
			s += ((Map.Entry)it.next()).getValue() + "@";
		}
		System.out.println(s);
	}
}

class SelfCleanMap_old {
	Map			objects;	
	MapCleaner	cleaner;
	
	
	SelfCleanMap_old(int TTL) {
		cleaner = new MapCleaner(TTL);
		objects = new Hashtable();		
		cleaner.start();
	}
	
	public Object put(Object key, Object value) {
		Object ret;
		synchronized (objects) {
			ret = objects.put(key, cleaner.crateEntity(value));
			//System.out.println("put(" + value + ")");			
		}
		return ret;
	}
	
	public String toString() {
		String list="";
		Iterator it = objects.entrySet().iterator();
		
		synchronized (objects) {
			while (it.hasNext()) {
				Map.Entry ent = (Map.Entry)it.next();
				MapCleanerEntity mce = (MapCleanerEntity) ent.getValue();
				list += "(" + mce.oValue + "," + mce.iTTL + ")~";
			}
		}
		return super.toString() + "@size=" + objects.size() + "@" + list;
		
	}
	
	class MapCleaner extends Thread {		
		int	iTTL;
		
		MapCleaner(int TTL) {
			iTTL = TTL;
			setDaemon(true);
			//System.out.println("[MapCleaner] constructor");
		}
		
		public void run() {
			System.out.println("[MapCleaner] start working");
			while (true) {
				synchronized (objects) {
					System.out.println("[MapCleaner] Cleaning...");
					System.out.println("\t[MapCleaner] Before:" + SelfCleanMap_old.this.toString());
					Iterator it = objects.entrySet().iterator();
					int handled=0;
					int deleted=0;					
					while (it.hasNext()) {
						handled++;
						Map.Entry entry = (Map.Entry) it.next();
						MapCleanerEntity mce = (MapCleanerEntity) entry.getValue();
						if (mce.iTTL-- <= 0) {
							it.remove();
							deleted++;
						}
					}					
					System.out.println("\t[MapCleaner] After:" + SelfCleanMap_old.this.toString());
					System.out.println("\t[MapCleaner] handled=" + handled + ", deleted=" + deleted);
					System.out.println("[MapCleaner] Done!");
				}
				try {
					sleep(500);
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
			}
		}
		
		public MapCleanerEntity crateEntity(Object value) {
			return new MapCleanerEntity(value,iTTL);			
		}
	
	}
	
	class MapCleanerEntity {	
		Object 	oValue;
		int 	iTTL;
		
		MapCleanerEntity(Object value, int TTL) {
			System.out.println("[MapCleanerEntity] Creating ("+value+","+TTL+")");
			oValue = value;
			iTTL = TTL;
		}
	}
	



}





