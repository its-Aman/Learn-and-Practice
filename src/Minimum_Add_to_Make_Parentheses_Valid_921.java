/**
 * 
 */

/**
 * @author AmanK
 *
 */

public class Minimum_Add_to_Make_Parentheses_Valid_921 {

	public int minAddToMakeValid(String S) {
		int ans = 0;
		int openCnt = 0;

		for (char c : S.toCharArray()) {
			if (c == '(') {
				openCnt += 1;
			} else {
				if (openCnt == 0) {
					ans += 1;
				} else {
					openCnt -= 1;
				}
			}
		}

		return ans + openCnt;
	}

}
