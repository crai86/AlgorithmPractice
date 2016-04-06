package com.hashing;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public String minWindow(String S, String T) {
		StringBuilder st = new StringBuilder();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < T.length(); i++) {

			if (map.containsKey(T.charAt(i))) {
				int k = map.get(T.charAt(i));
				map.put(T.charAt(i), ++k);
			} else {
				map.put(T.charAt(i), 1);
			}

		}
		int start = 0, end = 0;
		StringBuilder smin = new StringBuilder();
		Map<Character, Integer> temp = new HashMap<>(map);
		int count = 0;
		while (start <= end && end < S.length()) {
			if (map.containsKey(S.charAt(end))) {
				start = map.containsKey(S.charAt(start)) ? start : end;
				int k = map.get(S.charAt(end));
				count++;
				k = k - 1;
				if( count < T.length()){
					
				}
//				if (k < 0) {
//					start = start + 1;
//					count = 0;
//					if (map.containsKey(start)) {
//						count++;
//					}
//					end++;
//					continue;
//				} else {
					map.put(S.charAt(end), k);
				//}
				if (count == T.length()) {
					st = new StringBuilder(S.substring(start, end + 1));
					if (smin.length() > 0 && smin.length() > st.length()) {
						smin = st;

					} else if (smin.length() == 0) {
						smin = st;
					}
					st = new StringBuilder();
					map = new HashMap<>(temp);
					count = 0;
					// end=start;
					start = start + 1;
					if (map.containsKey(start)) {
						count++;
					}
				}
			}
			end++;
		}
		return smin.toString();
	}

	public static void main(String[] args) {
		Solution sy = new Solution();
		System.out
				.println(sy
						.minWindow(
								"xiEjBOGeHIMIlslpQIZ6jERaAVoHUc9Hrjlv7pQpUSY8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvRQVHtuHae0xxwCbRh6S7fCLKfXeSFITfKHnLdT65K36vGC7qOEyyT0Sm3Gwl2iXYSN2ELIoITfGW888GXaUNebAr3fnkuR6VwjcsPTldQSiohMkkps0MH1cBedtaKNoFm5HbH15kKok6aYEVsb6wOH2w096OwEyvtDBTQwoLN87JriLwgCBBavbOAiLwkGGySk8nO8dLHuUhk9q7f0rIjXCsQeAZ1dfFHvVLupPYekXzxtWHd84dARvv4Z5L1Z6j8ur2IXWWbum8lCi7aErEcq41WTo8dRlRykyLRSQxVH70rUTz81oJS3OuZwpI1ifBAmNXoTfznG2MXkLtFu4SMYC0bPHNctW7g5kZRwjSBKnGihTY6BQYItRwLUINApd1qZ8W4yVG9tnjx4WyKcDhK7Ieih7yNl68Qb4nXoQl079Vza3SZoKeWphKef1PedfQ6Hw2rv3DpfmtSkulxpSkd9ee8uTyTvyFlh9G1Xh8tNF8viKgsiuCZgLKva32fNfkvW7TJC654Wmz7tPMIske3RXgBdpPJd5BPpMpPGymdfIw53hnYBNg8NdWAImY3otYHjbl1rqiNQSHVPMbDDvDpwy01sKpEkcZ7R4SLCazPClvrx5oDyYolubdYKcvqtlcyks3UWm2z7kh4SHeiCPKerh83bX0m5xevbTqM2cXC9WxJLrS8q7XF1nh",
								"dO4BRDaT1wd0YBhH88Afu7CI4fwAyXM8pGoGNsO1n8MFMRB7qugS9EPhCauVzj7h"));
		// System.out.println(sy.minWindow("0mJdGXwLm9AOZ5xA8u92KDYqGJroQ537hoRXjQoUCMOpDYwxoNjexJGWQJAIxSFF3ZbIe27oFxUTJxtv8mORwpuRZn30MDj3kXRW2Ix3lslj7kwmGZPXAKhBW4q5T2BzsqbL0ZETFqRdxVm8GCGfqshvpWzsRvprUcF9vw3VlftqTRzKRzr4zYB2P6C7lg3I7EhGMPukUj8XGGZTXqPqnCqes",
		// "rsm2ty04PYPEOPYO5"));
	}
	
}