public class Juggle {

	public void rotateArray(int[] a, int d) {
		int n = a.length;
		int len = gcd(n, d);
		for (int i = 0; i < len; i++) {
			int temp = a[i];
			int j = i;
			while (true) {
				int k = (j + d) % n;
				if (k == i)
					break;
				a[j] = a[k];
				j = k;

			}
			a[j] = temp;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}
	}

	private int gcd(int n, int d) {
		if (d == 0) {
			return n;
		}
		return gcd(d, n % d);
	}

	public static void main(String[] args) {
		Juggle ju = new Juggle();
		ju.rotateArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 }, 3);

	}
}
