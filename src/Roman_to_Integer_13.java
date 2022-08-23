/**
 * @author AmanK
 *
 */
public class Roman_to_Integer_13 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Roman_to_Integer_13 r2i = new Roman_to_Integer_13();

		System.out.println(r2i.romanToInt("DCXXI"));
		System.out.println(r2i.romanToInt("LVIII"));
		System.out.println(r2i.romanToInt("MCMXCIV"));
		System.out.println(r2i.romanToInt("IV"));

	}

	public int romanToInt(String S) {
		int N = S.length();
		int ans = 0;

		for (int i = 0; i < N; i++) {
			boolean inRange = i + 1 < N;

			switch (S.charAt(i)) {
			case 'I':
				if (inRange && S.charAt(i + 1) == 'V') {
					ans += 4;
					i += 1;
				} else if (inRange && S.charAt(i + 1) == 'X') {
					ans += 9;
					i += 1;
				} else {
					ans += 1;
				}
				break;

			case 'V':
				ans += 5;
				break;

			case 'X':
				if (inRange && S.charAt(i + 1) == 'L') {
					ans += 40;
					i += 1;
				} else if (inRange && S.charAt(i + 1) == 'C') {
					ans += 90;
					i += 1;
				} else {
					ans += 10;
				}
				break;

			case 'L':
				ans += 50;
				break;

			case 'C':
				if (inRange && S.charAt(i + 1) == 'D') {
					ans += 400;
					i += 1;
				} else if (inRange && S.charAt(i + 1) == 'M') {
					ans += 900;
					i += 1;
				} else {
					ans += 100;
				}
				break;

			case 'D':
				ans += 500;
				break;

			case 'M':
				ans += 1000;
				break;

			default:
				System.out.println("Invalid input" + S.charAt(i));
			}
		}

		return ans;
	}
}
