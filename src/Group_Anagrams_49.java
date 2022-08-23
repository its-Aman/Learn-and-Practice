import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author AmanK
 *
 */
public class Group_Anagrams_49 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Group_Anagrams_49 ga = new Group_Anagrams_49();

		System.out.println(ga.groupAnagrams(new String[] { "ac", "d" }));
		System.out.println(ga.groupAnagrams(new String[] { "abbbbbbbbbbb", "aaaaaaaaaaab" }));
		System.out.println(ga.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
		System.out.println(ga
				.groupAnagrams(new String[] { "cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc" }));
		System.out.println(ga.groupAnagrams(
				new String[] { "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" }));
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<Integer, List<String>> map = new HashMap<>();

		for (String str : strs)
			map.computeIfAbsent(this.computeCommonHash(str), k -> new ArrayList<>()).add(str);

		return List.copyOf(map.values());
	}

	private int computeCommonHash(String str) {
		int[] hash = new int[26];

		for (char c : str.toCharArray())
			hash[c - 'a'] += 1;

		return Arrays.hashCode(hash);
	}

}
