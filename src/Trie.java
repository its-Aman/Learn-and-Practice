
public class Trie {
	
	TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode curr = this.root;

		for (char c : word.toCharArray()) {
			if (curr.next[c - 'a'] == null) {
				curr.next[c - 'a'] = new TrieNode();
			}
			curr = curr.next[c - 'a'];
		}

		curr.isEnd = true;
	}

	public boolean search(String word) {
		TrieNode curr = this.root;

		for (char c : word.toCharArray()) {
			if (curr.next[c - 'a'] == null) {
				return false;
			}
			curr = curr.next[c - 'a'];
		}

		return curr.isEnd;
	}

	public boolean startsWith(String prefix) {
		TrieNode curr = this.root;

		for (char c : prefix.toCharArray()) {
			if (curr.next[c - 'a'] == null) {
				return false;
			}
			curr = curr.next[c - 'a'];
		}

		return true;
	}
}
