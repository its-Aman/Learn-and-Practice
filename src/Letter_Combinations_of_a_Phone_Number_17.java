import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author AmanK
 *
 */
public class Letter_Combinations_of_a_Phone_Number_17 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Letter_Combinations_of_a_Phone_Number_17 lcoapn = new Letter_Combinations_of_a_Phone_Number_17();

		System.out.println(lcoapn.letterCombinations("23"));
		System.out.println(lcoapn.letterCombinations(""));
		System.out.println(lcoapn.letterCombinations("2"));
	}

	Map<Character, String[]> mapping = new HashMap<>();

	public List<String> letterCombinations(String digits) {
		List<String> ans = new ArrayList<>();

		if (digits == null || digits.length() == 0)
			return ans;

		this.mapTelephoneNumbers();

		for (char c : digits.toCharArray()) {
			List<String> temp = new ArrayList<>();

			if (ans.size() == 0) {
				ans = Arrays.asList(this.mapping.get(c));
				continue;
			}

			for (String curr : this.mapping.get(c)) {

				for (String s : ans) {
					temp.add(new String(s.concat(curr)));
				}

			}

			ans = temp;
		}

		return ans;
	}

	private void mapTelephoneNumbers() {
		this.mapping.put('2', new String[] { "a", "b", "c" });
		this.mapping.put('3', new String[] { "d", "e", "f" });
		this.mapping.put('4', new String[] { "g", "h", "i" });
		this.mapping.put('5', new String[] { "j", "k", "l" });
		this.mapping.put('6', new String[] { "m", "n", "o" });
		this.mapping.put('7', new String[] { "p", "q", "r", "s" });
		this.mapping.put('8', new String[] { "t", "u", "v" });
		this.mapping.put('9', new String[] { "w", "x", "y", "z" });
	}
}
