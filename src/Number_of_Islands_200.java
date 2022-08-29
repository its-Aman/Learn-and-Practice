public class Number_of_Islands_200 {

	class UF {
		public int count = 0;
		public int[] id = null;

		public UF(int m, int n, char[][] grid) {

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == '1')
						count++;
				}
			}

			id = new int[m * n];

			for (int i = 0; i < m * n; i++)
				id[i] = i;
		}

		public int find(int p) {

			while (p != id[p]) {
				id[p] = id[id[p]];
				p = id[p];
			}

			return p;
		}

		public boolean isConnected(int p, int q) {
			int pp = find(p);
			int qq = find(q);

			return pp == qq;
		}

		public void union(int p, int q) {
			int pp = find(p);
			int qq = find(q);

			if (pp == qq)
				return;

			id[pp] = qq;

			count--;
		}
	}

	public int numIslands(char[][] grid) {
		if (grid.length == 0 || grid[0].length == 0)
			return 0;

		int R = grid.length, C = grid[0].length;

		UF uf = new UF(R, C, grid);

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {

				if (grid[r][c] == '0')
					continue;

				int pos = r * C + c;

				if (r > 0 && grid[r - 1][c] == '1')
					uf.union(pos, pos - C);

				if (r < R - 1 && grid[r + 1][c] == '1')
					uf.union(pos, pos + C);

				if (c > 0 && grid[r][c - 1] == '1')
					uf.union(pos, pos - 1);

				if (c < C - 1 && grid[r][c + 1] == '1')
					uf.union(pos, pos + 1);
			}
		}
		return uf.count;
	}
}