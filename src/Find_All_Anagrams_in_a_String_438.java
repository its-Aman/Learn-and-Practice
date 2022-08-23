import java.util.ArrayList;
import java.util.List;

/**
 * @author AmanK
 *
 */
public class Find_All_Anagrams_in_a_String_438 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Find_All_Anagrams_in_a_String_438 faaias = new Find_All_Anagrams_in_a_String_438();

		System.out.println(faaias.findAnagrams("cbaebabacd", "abc"));
		System.out.println(faaias.findAnagrams("abab", "ab"));
		System.out.println(faaias.findAnagrams("baa", "aa"));
	}

	public List<Integer> findAnagrams(String S, String P) {
		List<Integer> ans = new ArrayList<>();

		if (P.length() > S.length())
			return ans;

		int[] pCount = new int[26];
		int[] sCount = new int[26];

		for (int i = 0; i < P.length(); i++) {
			pCount[P.charAt(i) - 'a'] += 1;
			sCount[S.charAt(i) - 'a'] += 1;
		}

		for (int curr = 0; curr <= S.length() - P.length(); curr++) {
			int next = curr + P.length();
			boolean isAnagram = true;

			for (int k = 0; k < 26; k++) {
				if (pCount[k] != sCount[k]) {
					isAnagram = false;
					break;
				}
			}

			if (isAnagram)
				ans.add(curr);

			sCount[S.charAt(curr) - 'a'] -= 1;

			if (curr + P.length() >= S.length())
				break;

			sCount[S.charAt(next) - 'a'] += 1;

		}

		return ans;
	}

}
