import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author AmanK
 *
 */
public class Substring_with_Concatenation_of_All_Words_30 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Substring_with_Concatenation_of_All_Words_30 scaw = new Substring_with_Concatenation_of_All_Words_30();

		System.out.println(scaw.findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }));
		System.out.println(
				scaw.findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "good" }));

	}

	int wordCount;
	int wordLen;
	int totaWordlLen;
	Map<String, Integer> map;

	public List<Integer> findSubstring(String S, String[] words) {
		LinkedList<Integer> ans = new LinkedList<>();
		this.map = new HashMap<>();
		this.wordCount = words.length;
		this.wordLen = words[0].length();
		this.totaWordlLen = this.wordLen * this.wordCount;

		for (String word : words)
			map.put(word, 1 + map.getOrDefault(word, 0));

		for (int i = 0; i < S.length() - this.totaWordlLen + 1; i++) {
			if (this.slidingWindow(i, S))
				ans.add(i);
			if (this.helper(i, S, new HashMap<>(this.map)))
				break;
		}

		return ans;
	}

	private boolean slidingWindow(int start, String S) {
		final Map<String, Integer> seen = new HashMap<String, Integer>();
		int j = 0;

		while (j < this.wordCount) {
			String word = S.substring(start + j * this.wordLen, start + (j + 1) * this.wordLen);

			if (!this.map.containsKey(word))
				break;

			seen.put(word, seen.getOrDefault(word, 0) + 1);

			if (seen.get(word) > this.map.getOrDefault(word, 0))
				break;

			j += 1;
		}

		return j == this.wordCount;
	}

	private boolean helper(int start, String S, Map<String, Integer> localHashTable) {
		int i = 0;
		while (i < this.totaWordlLen) {
			String curr = S.substring(i + start, i + start + this.wordLen);
			if (!localHashTable.containsKey(curr) || localHashTable.get(curr) == 0) {
				return false;
			} else {
				i += this.wordLen;
				localHashTable.put(curr, localHashTable.get(curr) - 1);
			}
		}

		return true;
	}

}
