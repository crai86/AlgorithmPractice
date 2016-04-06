import java.util.HashMap;
import java.util.Map;


public class WordCount {

	
	public static void main(String[] args) {
		counwords("the wheels on the bus go round and round");
	}

	private static void counwords(String string) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] st = string.split(" ");
		for(String s:st){
			if(map.containsKey(s)){
				map.put(s, map.get(s)+1);
			}else{
				map.put(s, 1);
			}
		}
		System.out.println(map);
	}
}
