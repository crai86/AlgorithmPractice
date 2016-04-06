import java.util.HashMap;
import java.util.Map;

public class TTLCache<T> {
	private long ttl;
	// Internal DS for storing any type of Key<T> and Node<T>
	private Map<Key, Node> map = new HashMap<>();

	// Initalize TTL for whole cache
	public TTLCache(long ttl) {
		this.ttl = ttl;
	}

	public <T> T get(T key) {
		Node<T> t = map.get(new Key(key));
		if (t != null) {
			// If it is expired then remove from map
			if (t.isExpired(ttl)) {
				map.remove(t);
				return null;
			}
			int currenttime = (int) System.currentTimeMillis();
			t.setstartTime(currenttime);
			return (T) t.getValue();
		}
		return null;
	}

	public void put(T key, T value) {
		Key<T> keyNode = new Key(key);
		// If map has already a Node of that cache
		if (map.containsKey(key)) {
			Node t = map.get(keyNode);
			t.setValue(value);
			// updated new current Time
			t.setstartTime(System.currentTimeMillis());

		} else {
			// If Map has no Node then add a new node
			Node t = new Node();
			t.setValue(value);
			// updated new current Time
			t.setstartTime(System.currentTimeMillis());
			map.put(keyNode, t);
		}

	}

	/**
	 * It is key class for Map . it can hold anyType
	 * 
	 * @author crai
	 *
	 * @param <T>
	 */
	public static class Key<T> {
		T key;

		public Key(T key) {
			this.key = key;
		}
	}

	/**
	 * It is key class for Map . it can hold anyValue under Node It has
	 * startTime which will be used for TTL
	 * 
	 * @author crai
	 *
	 * @param <T>
	 */

	public static class Node<T> {
		long startTime;
		T value;

		public T getValue() {
			return value;
		}

		/**
		 * Method to check TTL
		 * 
		 * @param ttl
		 * @return
		 */
		public boolean isExpired(long ttl) {
			if (System.currentTimeMillis() - this.startTime > ttl)
				return false;
			return true;
		}

		public void setstartTime(long startTime) {
			this.startTime = startTime;
		}

		public void setValue(T value) {
			this.value = value;
		}

	}
}
