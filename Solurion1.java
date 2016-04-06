public class Solurion1 {

	public boolean isPalindrome(String s) {
		if (s.isEmpty())
			return true;
		int i = 0, j = s.length() - 1;
		while (i <= j) {
			if (!((s.charAt(i) >= 65 && s.charAt(i) <= 91)
					|| (s.charAt(i) >= 96 && s.charAt(i) <= 122) || (s
					.charAt(i) >= 48 && s.charAt(i) <= 57))) {
				i++;
			} else if (!((s.charAt(j) >= 65 && s.charAt(j) <= 91)
					|| (s.charAt(j) >= 96 && s.charAt(j) <= 122) || (s
					.charAt(j) >= 48 && s.charAt(j) <= 57))) {
				j--;
			} else if ((!(s.charAt(j) >= 48 && s.charAt(j) <= 57) && Character
					.toUpperCase(s.charAt(i)) == Character.toUpperCase(s
					.charAt(j)))
					|| ((int) s.charAt(i) == (int) s.charAt(j))) {
				i++;
				j--;
			} else
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Solurion1 st = new Solurion1();
		System.out.println(st.isPalindrome("Chan12  21nahC"));
	}
}
