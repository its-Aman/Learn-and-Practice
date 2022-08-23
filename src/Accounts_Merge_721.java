import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author AmanK
 *
 */
public class Accounts_Merge_721 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Accounts_Merge_721 am = new Accounts_Merge_721();
		List<List<String>> accounts = new ArrayList<>();

		accounts.add(Arrays.asList("John", "john_newyork@mail.com", "johnsmith@mail.com"));
		accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
		accounts.add(Arrays.asList("Mary", "mary@mail.com"));
		accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));

		System.out.println(am.accountsMerge(accounts));

		System.out.println(am.visited);
		System.out.println(am.adjecencyList);

	}

	private Set<String> visited = new HashSet<>();
	private Map<String, List<String>> adjecencyList = new HashMap<>();

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		for (List<String> account : accounts) {
			String firstEmail = account.get(1);

			for (int i = 2; i < account.size(); i++) {
				String currEmail = account.get(i);

				this.adjecencyList.putIfAbsent(firstEmail, new ArrayList<>());
				this.adjecencyList.get(firstEmail).add(currEmail);

				this.adjecencyList.putIfAbsent(currEmail, new ArrayList<>());
				this.adjecencyList.get(currEmail).add(firstEmail);

			}
		}

		List<List<String>> mergedAccounts = new ArrayList<>();

		for (List<String> account : accounts) {
			String name = account.get(0);
			String firstEmail = account.get(1);

			if (this.visited.contains(firstEmail)) {
				continue;
			}

			List<String> mergedAccount = new ArrayList<>();
			mergedAccount.add(name);

			this.DFS(mergedAccount, firstEmail);

			Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
			mergedAccounts.add(mergedAccount);
		}

		return mergedAccounts;
	}

	private void DFS(List<String> mergedAccount, String email) {
		this.visited.add(email);
		mergedAccount.add(email);

		if (!this.adjecencyList.containsKey(email)) {
			return;
		}

		for (String otherEmail : this.adjecencyList.get(email)) {
			if (!this.visited.contains(otherEmail)) {
				this.DFS(mergedAccount, otherEmail);
			}
		}
	}
}
