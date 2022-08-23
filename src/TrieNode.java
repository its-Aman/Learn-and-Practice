
public class TrieNode {
	TrieNode[] next = new TrieNode[26];
	boolean isEnd = false;

	public TrieNode() {
	}

	public TrieNode(boolean isEnd) {
		this.isEnd = isEnd;
	}
}
