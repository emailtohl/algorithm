package com.github.emailtohl.algorithm.sort;
/**
 * 二分搜索
 * @author HeLei
 */
public class BinSearch {
	public int recursionSearch(int[] arr, int low, int high, int key) {
		if (low > high)
			return -1;
		int m = (low + high) / 2;
		int mv = arr[m];
		if (mv == key)
			return m;
		else if (mv < key)
			return recursionSearch(arr, m + 1, high, key);
		else
			return recursionSearch(arr, low, m - 1, key);
	}

	public int iterateSearch(int[] arr, int key) {
		int low = 0, high = arr.length - 1, result = -1;
		while (low <= high) {
			int m = (low + high) / 2;
			int mv = arr[m];
			if (mv == key) {
				result = m;
				break;
			} else if (mv < key)
				low = m + 1;
			else
				high = m - 1;
		}
		return result;
	}
}
