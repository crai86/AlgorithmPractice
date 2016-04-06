import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.DefaultEditorKit.CutAction;

public class TestMap {
	static Map<String, CustomObject> map = new HashMap<>();

	public static void main(String[] args) {
		/**
		 * { 'user': 'A', 'page': 1},
		 * 
		 * { 'user': 'B', 'page': 5},
		 * 
		 * { 'user': 'A', 'page': 2}, // A 1 ­> 2
		 * 
		 * { 'user': 'A', 'page': 1},
		 * 
		 * { 'user': 'B', 'page': 2},
		 * 
		 * { 'user': 'C', 'page': 7},
		 * 
		 * { 'user': 'C', 'page': 3},
		 * 
		 * { 'user': 'A', 'page': 3},
		 * 
		 * { 'user': 'C', 'page': 1},
		 * 
		 * { 'user': 'C', 'page': 2}, // C 1 ­> 2
		 */

		String[] log = { "usr:A,page:1", "usr:B,page:5", "usr:A,page:2",
				"user: B, page: 2", "user:C,page:7", "user:C,page:3",
				"user:A,page:3", "user:C,page:1", "user:C,page:2" };
		discover_site_Map(log);
	}

	private static void discover_site_Map(String[] log) {
		for (String s : log) {
			String[] temp = s.split(",");
			String key = temp[0].split(":")[1];
			String val = temp[1].split(":")[1];
			if (map.containsKey(key)) {
				CustomObject customObject = map.get(key);
				Map<String, ArrayList<String>> customMap = customObject.map;
				if (customMap.containsKey(val)) {
					ArrayList<String> values = customMap.get(val);
					values.add(customObject.lastVisited);
					customObject.lastVisited = val;
				} else {
					ArrayList<String> value = new ArrayList<String>();
					value.add(val);
					customMap.put(val, value);
					customObject.lastVisited = val;
					
				}
			}else{
				//CustomObject customObject = new CustomObject(val, new Ha)
			}
		}
		System.out.println(map);

	}

	public static class CustomObject {
		String lastVisited;
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		public CustomObject(String lastVisited,
				Map<String, ArrayList<String>> map) {
			super();
			this.lastVisited = lastVisited;
			this.map = map;
		}

	}

}
