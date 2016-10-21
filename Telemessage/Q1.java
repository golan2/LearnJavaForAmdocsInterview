import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Q1 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		testSelfCleanMap();
		//Q2.testIntersect();
	}

	protected static void testSelfCleanMap()  throws InterruptedException{
		SelfCleanMap scm = new SelfCleanMap(4);
		
		for (int i=0 ; i<15 ; i++) {
			scm.put("K"+i, "V"+i);
			Thread.sleep(450);
		}
		
		Thread.sleep(2000);		//wait for TTL to run over on all items
						
		System.out.println("The End");
	}
}

/**
 * A map that cleans its entries within a given TTL from the moment they were entered.
 * @author IZIKG*
 */
class SelfCleanMap implements Map {
	protected 	MapCleaner		cleaner;
	protected 	Map				objetcs;
	static final boolean		isDebugPrint=true;
		
	/**
	 * Constructor to create a new SelfCleanMap with a predefined TTL
	 * @param:	ttl - the time each objects lives before it is removed from the map.
	 */
	public SelfCleanMap(int ttl) {
		cleaner = new MapCleaner(ttl);
		objetcs = new Hashtable();
		cleaner.start();		
	}
	
	/**
	 * Returns the number of key-value mappings in this map. If the map contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE. 
	 * @return The number of key-value mappings in this map.
	 */
	public synchronized int size() { 
		return objetcs.size(); 
	}
	
	/**
	 * Associates the specified value with the specified key in this map (optional operation). If the map previously contained a mapping for this key, the old value is replaced by the specified value. (A map m is said to contain a mapping for a key k if and only if m.containsKey(k) would return true.)) 
	 * @param key - key with which the specified value is to be associated.
	 * @param value - value to be associated with the specified key.
	 * @return Previous value associated with specified key, or null if there was no mapping for key. A null return can also indicate that the map previously associated null with the specified key, if the implementation supports null values.
	 */
	public synchronized Object put(Object key, Object value) {
		if (isDebugPrint) {
			System.out.println("put(" + key + "," + value + ")");
		}
		return objetcs.put(key, cleaner.createEntity(value));
	}
	
	/**
	 * Returns the value to which this map maps the specified key. Returns null if the map contains no mapping for this key. A return value of null does not necessarily indicate that the map contains no mapping for the key; it's also possible that the map explicitly maps the key to null. The containsKey operation may be used to distinguish these two cases.
	 * More formally, if this map contains a mapping from a key k to a value v such that (key==null ? k==null : key.equals(k)), then this method returns v; otherwise it returns null. (There can be at most one such mapping.) 
	 * @param key - key whose associated value is to be returned.
	 * @return the value to which this map maps the specified key, or null if the map contains no mapping for this key.
	 */
	public synchronized Object get(Object key) {		
		return objetcs.get(key);
	}	
	
	/**
	 * Responsible for cleaning items from "SelfCleanMap"
	 * Runs as a deamon and iterates on "objects" Map in order to find (and remove) items that should be removed.	 * 
	 * @author IZIKG
	 *
	 */
	class MapCleaner extends Thread{
		int	iTimeToLive;
		
		public MapCleaner (int ttl) {
			iTimeToLive=ttl;
			setDaemon(true);
		}
		
		public void run() {
			while (true) {
				synchronized (SelfCleanMap.this) {	//to sync with all synchronized methods of "SelfCleanMap"
					Iterator it = objetcs.entrySet().iterator();
					while (it.hasNext()) {
						Map.Entry entity = (Map.Entry) it.next();
						SelfCleanMapEntity scme = (SelfCleanMapEntity) entity.getValue();
						scme.decreaseTTL();
						if (scme.getTTL() < 0) {
							it.remove();
						}
					}
					if (isDebugPrint) {
						System.out.println("objetcs=" + objetcs);
					}
				}
				try {					
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		public SelfCleanMapEntity createEntity(Object value) {
			return new SelfCleanMapEntity(value,iTimeToLive);
		}
	}
	
	/**
	 * An entry for the SelfCleanMap (mainly adding the TTL)
	 * @author IZIKG
	 */
	class SelfCleanMapEntity {
		Object 		value;
		int			ttl;
		
		public SelfCleanMapEntity(Object value, int ttl) {
			this.value = value;
			this.ttl = ttl;
		}
		
		public int getTTL() { return ttl; }
		
		public void decreaseTTL() { ttl--; }
	}

	//#####################################################################################
	//   Below are functions in order to implement the "Map" interface for "SelfCleanMap"
	//#####################################################################################
	
	public boolean isEmpty() {
		return objetcs.isEmpty();		
	}

	public boolean containsKey(Object key) {
		return objetcs.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return objetcs.containsValue(value);
	}

	public synchronized Object remove(Object key) {	
		return objetcs.remove(key);
	}

	public synchronized void putAll(Map t) {
		Iterator it = t.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			put(entry.getKey(),entry.getValue());
		}
	}

	public synchronized void clear() {
		objetcs.clear();
	}

	public Set keySet() {
		return objetcs.keySet();
	}

	public synchronized Collection values() {
		return objetcs.values();		
	}

	public synchronized Set entrySet() {		
		return objetcs.entrySet();
	}
}