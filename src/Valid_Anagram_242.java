public class Valid_Anagram_242 {
	public boolean isAnagram(String S, String T) {

		if (S.length() != T.length()) {
			return false;
		}

		int[] freq = new int[26];

		for (int i = 0; i < S.length(); i++) {
			freq[S.charAt(i) - 'a'] += 1;
			freq[T.charAt(i) - 'a'] -= 1;
		}

		for (int f : freq) {
			if (f != 0) {
				return false;
			}
		}

		return true;
	}
}
