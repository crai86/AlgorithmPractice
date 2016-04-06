import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution {
	
	int getMax(int A[], int n) {
		  int max = Integer.MIN_VALUE;
		  for (int i = 0; i < n; i++) {
		     if (A[i] > max) max = A[i];
		  }
		  return max;
		}

		int getSum(int A[], int n) {
		  int total = 0;
		  for (int i = 0; i < n; i++)
		    total += A[i];
		  return total;
		}

		int getRequiredPainters(int A[], int n, int maxLengthPerPainter) {
		  int total = 0, numPainters = 1;
		  for (int i = 0; i < n; i++) {
		    total += A[i];
		    if (total > maxLengthPerPainter) {
		      total = A[i];
		      numPainters++;
		    }
		  }
		  return numPainters;
		}

		int partition(int A[], int n, int k) {
		  int lo = getMax(A, n);
		  int hi = getSum(A, n);

		  while (lo < hi) {
		    int mid = lo + (hi-lo)/2;
		    int requiredPainters = getRequiredPainters(A, n, mid);
		    if (requiredPainters <= k)
		      hi = mid;
		    else
		      lo = mid+1;
		  }
		  return lo;
		}
		
		public static void main(String[] args) {
			Solution s = new Solution();
            int[] A = {1,2,10};
            System.out.println(s.partition(A, A.length, 3));
			
		}

}
