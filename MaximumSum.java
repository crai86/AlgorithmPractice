public class MaximumSum {
//Kandane's
	public void maximumSum(int[] a) {
		int max = a[0], sum = 0, curSum = a[0];
		for (int i = 1; i < a.length; i++) {
			curSum = Math.max(curSum+a[i], a[i]);
			max = Math.max(curSum, max);
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		MaximumSum mx = new MaximumSum();
		mx.maximumSum(new int[] { 1, 0, -3, -2 });
		// -1,0,3,-2
		/**
		 * sum=-1+0=-1
		 * curSum=Math.max(0,-1)=0
		 * curSum(3+0,0)=3
		 * max=3
		 * 
		 * sum=
		 */
	}
}
