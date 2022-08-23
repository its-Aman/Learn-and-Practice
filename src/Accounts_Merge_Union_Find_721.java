import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author AmanK
 *
 */
public class Accounts_Merge_Union_Find_721 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Accounts_Merge_Union_Find_721 am = new Accounts_Merge_Union_Find_721();
		List<List<String>> accounts = new ArrayList<>();

		accounts.add(Arrays.asList("John", "john_newyork@mail.com", "johnsmith@mail.com"));
		accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
		accounts.add(Arrays.asList("Mary", "mary@mail.com"));
		accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));

		System.out.println(am.accountsMerge(accounts));
	}

	public List<List<String>> accountsMerge(List<List<String>> accountsList) {
		DSU dsu = new DSU(accountsList.size());
		Map<String, Integer> emailGroup = new HashMap<>();

		for (int i = 0; i < accountsList.size(); i++) {

			for (int j = 1; j < accountsList.get(i).size(); j++) {

				String email = accountsList.get(i).get(j);

				if (!emailGroup.containsKey(email)) {
					emailGroup.put(email, i);
				} else {
					dsu.union(i, emailGroup.get(email));
				}
			}
		}

		Map<Integer, List<String>> components = new HashMap<>();

		for (String email : emailGroup.keySet()) {
			int group = emailGroup.get(email);
			int groupRep = dsu.find(group);

			components.putIfAbsent(groupRep, new ArrayList<String>());
			components.get(groupRep).add(email);
		}

		List<List<String>> mergedAccount = new ArrayList<>();

		for (int group : components.keySet()) {
			List<String> component = components.get(group);
			Collections.sort(component);
			component.add(0, accountsList.get(group).get(0));
			mergedAccount.add(component);
		}

		return mergedAccount;
	}

	class DSU {
		int[] representatives;
		int[] size;

		public DSU(int size) {
			this.representatives = new int[size];
			this.size = new int[size];

			for (int i = 0; i < size; i++) {
				this.representatives[i] = i;
				this.size[i] = 1;
			}
		}

		public int find(int x) {
			int temp = x;

			while (temp != this.representatives[temp]) {
				temp = this.representatives[temp];
			}

			while (x != temp) {
				int next = this.representatives[x];
				this.representatives[x] = temp;
				x = next;
			}

			return temp;
		}

		public void union(int x, int y) {
			int xx = this.find(x);
			int yy = this.find(y);

			if (xx == yy)
				return;

			if (this.size[xx] >= this.size[yy]) {
				this.representatives[yy] = xx;
				this.size[xx] += this.size[yy];
			} else {
				this.representatives[xx] = yy;
				this.size[yy] += this.size[xx];
			}
		}
	}
}
