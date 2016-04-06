import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class KMP {

	public int[] createLps(String pattern) {
		int i = 1;
		int j = 0;
		int[] lps = new int[pattern.length()];
		while (i < pattern.length()) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				lps[i] = lps[j] + 1;
				i++;
				j++;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
		return lps;
	}

	public void findCount(String pattern) throws IOException {
		int[] lps = createLps(pattern);
		int j = 0;
		int count = 0;
		DataInputStream in = new DataInputStream(System.in);
		System.out.println("Enter the a character");
		Character ch = null;
		int m = pattern.length();
		while ((ch = (char) in.readByte()) != '&') {
			if (j < m && pattern.charAt(j) == ch) {
				j++;
				continue;
			}
			if (j == m) {
				count++;
				j = lps[j - 1];
			} else if (ch != pattern.charAt(j)) {
				if (j != 0) {
					j = lps[j - 1];
				}
			}
		}
		if (j == m) {
			count++;
		}
		System.out.println("Count is" + count);
	}

	public void findCount(String[] patterns) throws IOException {
		List<Node> nodes = new ArrayList<>();
		for (String pattern : patterns) {
			int[] lps = createLps(pattern);
			Node n = new Node(pattern.length(), 0, lps, pattern, 0);
			nodes.add(n);
		}
		DataInputStream in = new DataInputStream(System.in);
		System.out.println("Enter the a character");
		Character ch = null;

		while ((ch = (char) in.readByte()) != '&') {
			for (Node node : nodes) {
				findPatternUtil(node, ch);
			}
		}
		// if (j == m) {
		// count++;
		// }
		// System.out.println("Count is" + count);
		for (Node n : nodes) {
			System.out.println(n.pattern+":"+n.count);
		}
	}

	public void findPatternUtil(Node n, char ch) {
		if (n.j < n.m && n.pattern.charAt(n.j) == ch) {
			n.j++;
			return;
		}
		if (n.j == n.m) {
			n.count++;
			n.j = n.lps[n.j - 1];
		} else if (ch != n.pattern.charAt(n.j)) {
			if (n.j != 0) {
				n.j = n.lps[n.j - 1];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		KMP st = new KMP();
		st.findCount(new String[]{"cat","word"});
		
	}

	static class Node {
		int m;
		int j;
		int[] lps;
		String pattern;
		int count;

		public Node(int m, int j, int[] lps, String pattern, int count) {
			super();
			this.m = m;
			this.j = j;
			this.lps = lps;
			this.pattern = pattern;
			this.count = count;
		}

	}
}
