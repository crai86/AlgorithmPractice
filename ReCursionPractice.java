import java.util.ArrayList;

public class ReCursionPractice {
	int sum = 0;

	public int numchars(char ch, String s, int i) {
		if (i >= s.length()) {
			return 0;
		}
		if (ch == s.charAt(i)) {
			return 1 + numchars(ch, s, i + 1);
		}
		return numchars(ch, s, i + 1);
	}

	public static void main(String[] args) {
		ReCursionPractice rt = new ReCursionPractice();
		int k = rt.numchars('a', "absbd", 0);
		System.out.println(k);
		StringBuffer st = new StringBuffer("aester");
		StringBuffer sy = new StringBuffer();
		rt.removeVowels(st, 0, sy);
		System.out.println(sy + "*********");
		rt.mixallString("ab", "cd", 0, new StringBuffer());
	}

	public void mixallString(String s, String dynamic, int index,
			StringBuffer st) {
		ArrayList<ArrayList<String>> res = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			ArrayList<String> at = new ArrayList<String>();
			mexString(s.charAt(i), dynamic, 0, at);
			res.add(at);
		}
		System.out.println(res);
	}

	private void mexString(char charAt, String dynamic, int index,
			ArrayList<String> at) {
		if (index == dynamic.length()) {
			return;
		}
		StringBuffer st =new StringBuffer();
		st.append(charAt);st.append(dynamic.charAt(index));
		at.add(st.toString());
		mexString(charAt, dynamic, index+1, at);
		
	}

	public void removeVowels(StringBuffer s, int i, StringBuffer st) {
		if (i >= s.length()) {
			return;
		}
		if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
				|| s.charAt(i) == 'o' || s.charAt(i) == 'u') {

		} else {
			st.append(s.charAt(i));
		}
		removeVowels(s, i + 1, st);
	}
}
