/**
 * @author AmanK
 *
 */
public class String_to_Integer_atoi_8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String_to_Integer_atoi_8 atoi = new String_to_Integer_atoi_8();

		System.out.println(atoi.myAtoi("42"));
		System.out.println(atoi.myAtoi("   -42"));
		System.out.println(atoi.myAtoi("4193 with words"));
		System.out.println(atoi.myAtoi("words and 987"));
		System.out.println(atoi.myAtoi("20000000000000000000"));
		System.out.println(atoi.myAtoi("9223372036854775808"));
	}

	public int myAtoi(String s) {
		s = s.trim();

		if (s.length() == 0)
			return 0;

		char first = s.charAt(0);
		int start = 0;
		int sign = 1;
		long sum = 0;

		if (first == '-') {
			sign = -1;
			start += 1;
		} else if (first == '+') {
			start += 1;
		}

		for (int i = start; i < s.length(); i++) {
			char curr = s.charAt(i);

			if (!Character.isDigit(curr))
				return (int) sum * sign;

			sum = sum * 10 + (curr - '0');

			if (sign == 1 && sum > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;

			if (sign == -1 && sign * sum < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}

		return (int) sum * sign;
	}
}
