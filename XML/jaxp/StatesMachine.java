package jaxp;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class StatesMachine {
	Map m_flags;
	
	public StatesMachine() {
		this(true); 
	}

	public StatesMachine(boolean isSynchronized) {
		if (isSynchronized) {
			m_flags = new Hashtable();
		}
		else {
			m_flags = new HashMap();
		}
	}
	
	public void setInside(String nodeName) {
		m_flags.put(nodeName, Boolean.TRUE);
	}
	
	public boolean isInside(String nodeName) {
		Object o = m_flags.get(nodeName);
		if (o==null) {
			throw new NullPointerException();
		}
		
		Boolean val = (Boolean)o;
		return (val.equals(Boolean.TRUE));
	}
}

