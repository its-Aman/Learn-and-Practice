/**
 * @author AmanK
 *
 */
public class Word_Search_79 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Word_Search_79 ws = new Word_Search_79();

		System.out.println(ws.exist(
				new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCCED"));
		System.out.println(ws
				.exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "SEE"));
		System.out.println(ws.exist(
				new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCB"));
		System.out.println(ws.exist(new char[][] { { 'c' } }, "c"));
		System.out.println(ws.exist(new char[][] { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B', 'C', 'D' } }, "AAB"));
	}

	public boolean exist(char[][] board, String word) {
		int R = board.length, C = board[0].length;

		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (board[i][j] == word.charAt(0)) {
					char temp = board[i][j];
					board[i][j] = '#';

					if (this.go(board, word.substring(1, word.length()), i, j))
						return true;

					board[i][j] = temp;
				}

		return false;
	}

	private boolean go(char[][] board, String word, int i, int j) {
		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

		if (word.length() == 0)
			return true;

		for (int[] dir : dirs) {
			int dx = i + dir[0], dy = j + dir[1];

			if (dx < 0 || dx >= board.length || dy < 0 || dy >= board[0].length || board[dx][dy] != word.charAt(0))
				continue;

			char original = board[dx][dy];
			board[dx][dy] = '#';

			if (this.go(board, word.substring(1, word.length()), dx, dy)) {
				board[dx][dy] = original;
				return true;
			}

			board[dx][dy] = original;
		}

		return false;
	}
}
