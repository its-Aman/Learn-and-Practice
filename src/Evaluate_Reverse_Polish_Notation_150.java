import java.util.*;

public class Evaluate_Reverse_Polish_Notation_150 {

	public int evalRPN(String[] tokens) {
		HashMap<String, Operationable> map = new HashMap<>();

		map.put("+", (b, a) -> a + b);
		map.put("-", (b, a) -> a - b);
		map.put("/", (b, a) -> a / b);
		map.put("*", (b, a) -> a * b);

		Stack<Integer> stack = new Stack<>();

		for (String token : tokens) {
			if ("+-*/".contains(token)) {
				int ans = map.get(token).op(stack.pop(), stack.pop());
				stack.push(ans);
			} else {
				stack.push(Integer.parseInt(token));
			}
		}

		return stack.pop();
	}
}

interface Operationable {
	int op(int n1, int n2);
}