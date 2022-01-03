package trie.core;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Optional;

public class Trie {
	private boolean isMember;
	private SortedArrayMap<Character, Trie> children;

	public Trie() {
		isMember = false;
		children = new SortedArrayMap<>();
	}

	/******
	 * Determines the size of the Trie, based on the number of suffixes
	 * contained.
	 *
	 * @return the number of suffixes in this Trie
	 */
	public int size() {
		int count = 0;
		if (isMember){
			count++;
		}
		for (Association<Character, Trie> a : children) {
			count += a.getValue().size();
		}
		return count;
	}

	/******
	 * Get the child that has the character we request
	 *
	 * @param target
	 *            what to search for
	 * @return the child with target char, or null if not found
	 */
	public Optional<Trie> getChildWith(char target) {
		return children.get(target);
	}

	/******
	 * Find a path to the Trie node that corresponds to prefix. The path will 
	 * include all of the Trie nodes traversed while searching for it.
	 *
	 * @param prefix
	 *            The prefix to search for
	 * @return All of the Trie nodes on the path to prefix
	 */
	public ArrayDeque<Trie> find(String prefix) {
		ArrayDeque<Trie> path = new ArrayDeque<>();
		path.add(this);
		Trie current = this;
		for (char c : prefix.toCharArray()){
			Optional<Trie> child = current.getChildWith(c);
			if (child.isPresent()) {
				path.push(child.get());
				current = child.get();
			} else { break; }
		}
		return path;
	}

	/******
	 * Is the given value contained in this Trie? Walk through the tree, moving
	 * down to the appropriate child for each character in the value. If you
	 * fall off the tree, return false, otherwise return true if the last child
	 * is contained in the Trie.
	 *
	 * @param value
	 * @return true if value is contained in this Trie
	 */
	public boolean contains(String value) {
		ArrayDeque<Trie> path = find(value);
		if (path.size() == value.length() + 1) {
			return path.peek().isMember;
		}
		return false;
	}

	/******
	 * Walk through the value, and add a new chain of Trie nodes, one for each
	 * letter that is not already found in the Trie. Mark the last Trie node as
	 * contained.
	 *
	 * @param value
	 */
	public void add(String value) {
		ArrayDeque<Trie> path = find(value);
		int fell = path.size() ;
		Trie parent = path.peek();
		for (int i = fell - 1; i < value.length(); i++) {
			Trie temp = new Trie();
			parent.children.add(value.charAt(i), temp);
			parent = temp;
		}
		parent.isMember = true;
	}

	/******
	 * Walk down the tree, following the appropriate child, and saving the
	 * parent if there are other viable paths or if the parent is the end of
	 * another word. Unmark the last node. Then if it was an only child, remove
	 * the unneeded chain of nodes from the last good parent.
	 *
	 * @param value
	 */
	public void remove(String value) {
		ArrayDeque<Trie> path = find(value);
		Trie last = path.peek();
		if (path.size() == value.length() + 1) {
			last.isMember = false;
			while (last.children.size() > 0) {
				path.pop();
			}
		}
	}

	private void inOrderHelper(String currentPrefix, ArrayList<String> created) {
		if (this.isMember) {
			created.add(currentPrefix);
		}
		for (Association<Character, Trie> a : this.children) {
			a.getValue().inOrderHelper(currentPrefix + a.getKey(), created);
		}
	}
	/******
	 * Find all the words in this Trie in alphabetic order. Recursively visit
	 * all the children of this Trie, and add their found words into an
	 * ArrayList, prepending them with the in-progress prefix.
	 *
	 * Hint: you probably want to write a recursive helper method which takes as
	 * parameters the current prefix and a reference to the ArrayList being
	 * created.
	 *
	 * @return an ArrayList of the words
	 */
	public ArrayList<String> inorder() {
		ArrayList<String> strs = new ArrayList<>();
		inOrderHelper( "", strs);
		return strs;
	}

	/******
	 * List the words that begin with the given prefix, sorted alphabetically.
	 * First, navigate through the Trie to the node at the end of the prefix.
	 * Then, generate all the strings in the sub-trie but start with the given
	 * prefix instead of the empty string.
	 *
	 * @param prefix
	 *            String to begin
	 * @return an ArrayList of the words
	 */
	public ArrayList<String> successorsTo(String prefix) {
		ArrayDeque<Trie> path = find(prefix);
		ArrayList<String> strs = new ArrayList<>();
		if (path.peek().isMember) {
			strs.add(prefix);
		}
		path.peek().inOrderHelper(prefix, strs);
		return strs;
	}
}
