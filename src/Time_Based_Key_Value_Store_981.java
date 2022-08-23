import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author AmanK
 *
 */
public class Time_Based_Key_Value_Store_981 {

	private Map<String, TreeMap<Integer, String>> map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Time_Based_Key_Value_Store_981() {
		this.map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		this.map.putIfAbsent(key, new TreeMap<>());
		this.map.get(key).put(timestamp, value);
	}

	public String get(String key, int timestamp) {
		TreeMap<Integer, String> valMap = this.map.get(key);
		if (valMap == null) {
			return "";
		}

		Integer floorKey = valMap.floorKey(timestamp);

		if (floorKey == null) {
			return "";
		}

		return valMap.get(floorKey);
	}
}
