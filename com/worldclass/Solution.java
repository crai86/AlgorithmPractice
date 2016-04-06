package com.worldclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public ArrayList<Integer> lszero(ArrayList<Integer> a) {
		ArrayList<Integer> t = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// findSol(a,0,0,t,map);
		// map.put(0,t);
		int[] sum = new int[a.size()];
		int totalSum = 0;
		for (int i = 0; i < a.size(); i++) {
			totalSum += a.get(i);
			sum[i] = totalSum;
		}
		for (int i = 0; i < a.size(); i++) {
			int key = sum[i];
			if (map.containsKey(key) || sum[i] == 0 || a.get(i) == 0) {
				if (sum[i] == 0) {
					if (!t.isEmpty()) {
						int len = t.get(t.size() - 1) - t.get(0);
						if (len < i) {
							t = new ArrayList();
							t.add(0);
							t.add(i + 1);
						}
					} else {
						t.add(0);
						t.add(i + 1);
					}
				} else if (a.get(i) == 0) {
					if (t.isEmpty()) {
						t.add(i);
						t.add(i + 1);
					}
				} else {
					int value = map.get(key);
					if (!t.isEmpty()) {
						int len = t.get(t.size() - 1) - t.get(0);
						if (len < i - value) {
							t = new ArrayList();
							t.add(value + 1);
							t.add(i + 1);
						}
					}else{
						t = new ArrayList();
						t.add(value + 1);
						t.add(i + 1);
					}
				}
			} else
				map.put(sum[i], i);
		}
//		System.out.println(map);
		if (t.isEmpty()) {
			return new ArrayList<Integer>();
		}
		return new ArrayList<Integer>(a.subList(t.get(0), t.get(t.size() - 1)));
	}

	public static void main(String[] args) {
		Solution st = new Solution();
		ArrayList<Integer> a = new ArrayList<Integer>() {
			{
				add(10);
				add(-3);
				add(-9);
				add(-10);
				add(9);
				add(-26);
				add(7);
				add(-2);
				add(-20);
				add(-19);
				add(-9);
				add(7);
				add(13);
				add(-5);
				add(-8);
				add(-24);
				add(-11);
				add(28);
				add(28);
				add(24);

			}
		};
		// 1, 2, -2, 4, -4
		// 10, -3, -9, -10, 9, -26, 7, -2, -20, -19, -9, 7, 13, -5, -8, -24,
		// -11, 28, 28, 24
		// a.add(1);
		// a.add(2);
		// a.add(-3);
		// a.add(3);

		// a.add(-4);
		System.out.println(st.lszero(a));
		List<Integer> te = new ArrayList<Integer>(){{
			add(2);
			add(1);
			add(-1);
			add(0);
			add(2);
			add(-1);
			add(1);
		}};
		String su = new String("Wnb9z9dMc7E8v1RTUaZPoDNIAXRlzkqLaa97KMWLzbitaCkRpiE4J4hJWhRcGnC8H6mwasgDfZ76VKdXhvEYmYrZY4Cfmf4HoSlchYWFEb1xllGKyEEmZOLPh1V6RuM7Mxd7xK72aNrWS4MEaUmgEn7L4rW3o14Nq9l2EN4HH6uJWljI8a5irvuODHY7A7ku4PJY2anSWnfJJE1w8p12Ks3oZRxAF3atqGBlzVQ0gltOwYmeynttUmQ4QBDLDrS4zn4VRZLosOITo4JlIqPD6t4NjhHThOjJxpMp9fICkrgJeGiDAwsb8a3I7Txz5BBKV9bEfMsKNhCuY3W0ZHqY0MhBfz1CbYCzwZZdM4p65ppP9s5QJcfjadmMMi26JKz0TVVwvNA8LP5Vi1QsxId4SI19jfcUH97wmZu0pbw1zFtyJ8GAp5yjjQTzFIboC1iRzklnOJzJld9TMaxqvBNBJKIyDjWrdfLOY8FGMOcPhfJ97Dph35zfxYyUf4DIqFi94lm9J0skYqGz9JT0kiAABQZDazZcNi80dSSdveSl6h3dJjHmlK8qHIlDsqFd5FMhlEirax8WA0v3NDPT8vPhwKpxcnVeu14Gcxr3h1wAXXV0y7Xy9qqB2NQ5HQLJ7cyXAckEYHsLCPSy28xcdNJatx1KLWohOQado4WywJbGvsFR17rKmvOPABweXnFD3odrbSMD4Na4nuBBswvMmFRTUOcf7jZi4z5JnJqXz6hitaPnaEtjoSEBq82a52nvqYy7hhldBoxen2et2OMadVEHeTYLL7GLsIhTP6UizHIuzcJMljo4lFgW5AyrfUlIBPAlhwaSiJtTvcbVZynDSM6RO1PqFKWKg2MHIgNhjuzENg2oFCfW7z5KJvEL9qWqKzZNc0o3BMRjS04NCHFvhtsteQoQRgz84XZBHBJRdekCdcVVXu9c01gYRAz7oIAxN3zKZb64EFKssfQ4HW971jv3H7x5E9dAszA0HrKTONyZDGYtHWt4QLhNsIs8mo4AIN7ecFKewyvGECAnaJpDn1MTTS4yTgZnm6N6qnmfjVt6ZU51F9BxH0jVG0kovTGSjTUkmb1mRTLQE5mTlVHcEz3yBOh4WiFFJjKJdi1HBIBaDL4r45HzaBvmYJPlWIomkqKEmQ4rLAbYG7C5rFfpMu8rHvjU7hP0JVvteGtaGn7mqeKsn7CgrJX1tb8t0ldaS3iUy8SEKAo5IZHNKOfEaij3nI4oRVzeVOZsH91pMsA4jRYgEohubPW8ciXwVrFi1qEWjvB8gfalyP60n1fHyjsiLW0T5uY1JzQWHKCbLVh7QFoJFAEV0L516XmzIo556yRH1vhPnceOCjebqgsmO78AQ8Ir2d4pHFFHAGB9lESn3OtJye1Lcyq9D6X93UakA3JKVKEt6JZDLVBMp4msOefkPKSw59Uix9d9kOQm8WCepJTangdNSOKaxblZDNJ5eHvEroYacBhd9UdafEitdF3nfStF7AhkSfQVC61YWWkKTNdx96OoJGTnxuqt4oFZNFtO7aMuN3IJAkw3m3kgZFRGyd3D3wweagNL9XlYtvZwejbjpkDOZz33C0jbEWaMEaUPw6BG49XqyQoUwtriguO0yvWyaJqD4ye3o0E46huKYAsdKAq6MLWMxF6tfyPVaoqOGd0eOBHbAF89XXmDd4AIkoFPXkAOW8hln5nXnIWP6RBbfEkPPbxoToMbV");
		System.out.println(su.length());
		String s1 = new String("");
		System.out.println(s1.length());
		System.out.println(te.subList(2, 6));
	}
}